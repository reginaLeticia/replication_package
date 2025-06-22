
import config.LocatorTypeScore;
import org.jsoup.nodes.Document;

/* [DESCRIPTION]
    - The final score value is set to the interval [0-1].
    - This means that the more the score tends to 1 the more fragile that selector is (and so is the Test).
**/
public class DefaultSelectorComplexityEvaluator implements ISelectorScoreStrategy {
   // @Override
    public float evaluateSelectorComplexity(Selector selector, Document document) {

        Float [] results = new Float[4];

        String selectorType   = selector.getType();
        String selectorString = selector.getSelector();

        int level, depth = 0;
        float hierarchyScore; // [0-1]
        float typeScore;      // [0-1]

        // Step 1: Hierarchy Score calculation
        switch (selectorType) {
            case "CssSelector":
                // depth = evaluateCssSelectorHierarchyDepth(selectorString);
                depth = SelectorDepthEvaluator.evaluateCssSelectorHierarchyDepth(selectorString);
                results[0]= (float) depth;
                //level = depth + 1;
                hierarchyScore = (1 - ((float) 1 / depth)); // [0-1]
                results[1] = (float) hierarchyScore;
                break;
            case "XPath":
                // depth = evaluateXPathSelectorHierarchyDepth(selectorString);
                depth = SelectorDepthEvaluator.evaluateXPathSelectorHierarchyDepth(selectorString);
                //level = depth + 1;
                results[0] = (float) depth;
                hierarchyScore = (1 - ((float) 1 / depth)); // [0-1]
                results[1] = (float) hierarchyScore;
                break;
            default:
                hierarchyScore = 0.0f;
        }

        System.out.println("[Selector Complexity Evaluator] Selector: " + selectorString);
        System.out.println("[Selector Complexity Evaluator] (Debug) Hierarchy Depth: " + depth);
        System.out.println("[Selector Complexity Evaluator] (Analyzed) Selector Hierarchy Score: " + hierarchyScore);

        // Step 2: Type Score calculation (Rule Based)
        switch (selectorType) {
            case "CssSelector":
                typeScore = evaluateCssSelectorTypeScore(selectorString, depth);
                break;
            case "XPath":
                typeScore = evaluateXPathTypeScore(selectorString, depth);
                break;
            case "TagName":
                typeScore= LocatorTypeScore.tagname_score;
                break;
            case "Name":
                typeScore = LocatorTypeScore.name_score;
                break;
            case "LinkText":
                typeScore = LocatorTypeScore.link_text_score;
                break;
            case "ClassName":
                typeScore = LocatorTypeScore.class_score;
                break;
            case "PartialLinkText":
                typeScore = LocatorTypeScore.partial_linktext_score;
                break;
            case "Id":
                typeScore = LocatorTypeScore.id_score;
                break;
            default:
                typeScore = 0.0f; // If the selector is of type "id" we set score to 0.0f too.
        }
        System.out.println("[Selector Complexity Evaluator] (Analyzed) Selector Type Score: " + typeScore);

        results[2] = typeScore;
        // Step 3: Combination
        //needed for the test
        results[3] = ((hierarchyScore + typeScore) / 2); // [0-1]
        //return results;
        return ((hierarchyScore + typeScore) / 2); // [0-1]

    }

    public static float getSelectorScoreWeight() {
        return 0.0f;
    }

    /* METHODS */

    /*
        private static int evaluateCssSelectorHierarchyDepth(String selectorString) {
            if (selectorString == null || selectorString.isEmpty()) {
                System.out.println("[Selector Complexity Evaluator] (ERROR) " + selectorString + " is Null or empty string!");
                return 0;
            }

            String[] combinators = selectorString.split("[ >~+]+");
            return combinators.length - 1;
        }

        private static int evaluateXPathSelectorHierarchyDepth(String selectorString) {
            if (selectorString == null || selectorString.isEmpty()) {
                System.out.println("[Selector Complexity Evaluator] (ERROR) " + selectorString + " is Null or empty string!");
                return 0;
            }

            if (selectorString.startsWith("//"))
                selectorString = selectorString.substring(2);
            else if (selectorString.startsWith("/"))
                selectorString = selectorString.substring(1);

            String[] combinators = selectorString.split("/");
            return combinators.length - 1;
        }
     */

    private static float evaluateCssSelectorTypeScore(String selectorString, int depth) {
        if (depth >= 1) {
            String lastElement = getLastCssSelectorElement(selectorString);
            return evaluateCssSelectorElementType(lastElement);
        }
        return evaluateCssSelectorElementType(selectorString);
    }

    private static float evaluateXPathTypeScore(String selectorString, int depth) {
        if (depth >= 1) {
            String lastLevel = selectorString.substring(selectorString.lastIndexOf("/") + 1);
            String evaluate = "//" + lastLevel;
            return evaluateXPathElementType(evaluate);
        }
        return evaluateXPathElementType(selectorString);
    }

    private static String getLastCssSelectorElement(String selectorString) {
        String[] elements = selectorString.split("[ >~+]+");
        return elements[elements.length - 1];
    }

    private static float evaluateCssSelectorElementType(String lastElement) {
        //there's notigh like linkText and PartialText in CSS Sintax
        if (lastElement.startsWith("#") || lastElement.contains("#")) {
            return 0.0f; // id selector
        }else if(lastElement.startsWith("[@name=") || lastElement.contains("[@name=") ){
            return  0.0f;
        }
        else if (lastElement.startsWith(".") || lastElement.contains(".")) {
            return 0.5f; // class name selector
        } else {
            return 0.8f; // tag name selector or other types
        }
    }

    private static float evaluateXPathElementType(String xpathLastElement) {
        // In order Best to Worst
        if (xpathLastElement.contains("@id") || xpathLastElement.contains("@name")) {
            return 0.0f;
        } else if (xpathLastElement.contains("@class")) {
            return 0.5f;
        } else if (xpathLastElement.contains("[text()")) { // LinkText
            return 0.6f;
        } else if (xpathLastElement.contains("[contains(text()")) { // Partial LinkText
            return 0.7f;
        }
        return 0.8f;
    }
}