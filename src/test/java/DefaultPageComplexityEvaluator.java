
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/* [DESCRIPTION]
    - The final score value is set to the interval [0-1].
    - This means that the more the score tends to 1 the more fragile that selector is (and so is the Test).
**/
public class DefaultPageComplexityEvaluator implements IPageScoreStrategy {
    public static int numberOfElements;

    @Override
    public float evaluatePageComplexity(Page page) {
        Document document = page.getPage();
        setNumberOfElements(document.select("*").size());
        System.out.println("NUMBER OF PAGE ELEMENTS: "+numberOfElements);
        float firstRatio  = evaluateLinkRatio(document);// [0-1]
        System.out.println("NAV(P)= "+firstRatio);
        float secondRatio = evaluateDomRatio(document);// [0-1]
        System.out.println("DEPTH(P): "+secondRatio);
        float thirdRatio  = evaluateBranchingFactorRatio(document)/numberOfElements; // [0-1]
        System.out.println("BRANCH(P): "+thirdRatio);
        return ((firstRatio + secondRatio + thirdRatio) / 3); // [0-1]
    }

   public Float[] evaluatePageComplexityArray(Page page){

        Float [] res = new Float[4];
        Document document = page.getPage();
        setNumberOfElements(document.select("*").size());

        float firstRatio  = evaluateLinkRatio(document);            // [0-1]
        res[0] = firstRatio;
        float secondRatio = evaluateDomRatio(document);             // [0-1]
        res[1] = secondRatio;
        float thirdRatio  = evaluateBranchingFactorRatio(document)/numberOfElements; // [0-1]
        res[2] = thirdRatio;
        res[3] = ((firstRatio + secondRatio + thirdRatio) / 3);
        return res;

     }

    public static float getPageScoreWeight() {
        return 0.50f;
    }

    private static void setNumberOfElements(int numberOfElements) {
        DefaultPageComplexityEvaluator.numberOfElements = numberOfElements;
    }

    public static int getNumberOfElements() {
        return numberOfElements;
    }

    /* METHODS */

    private static float evaluateLinkRatio(Document document) {
        Elements links = document.select("a");
        float nLinks = links.size();
        System.out.println("NUMBER OF LINK ELEMENT: "+nLinks);
        return (nLinks / getNumberOfElements()); // [0-1]
    }

    private static float evaluateDomRatio(Document document) {
        float depth  = (float) evaluatePageDepth(document.child(0)); // Starting from root element
        System.out.println("LEVEL: "+depth);
        return (depth / getNumberOfElements()); // [0-1]
    }

    private static float evaluateBranchingFactorRatio(Document document) {
        int sumBranchingFactor = 0;
        int denominator = 0;
        for (Element elem : document.select("*")) {
            int elem_child_size = evaluateBranchingFactorForElement(elem);
            if(elem_child_size!=0){
                sumBranchingFactor += elem_child_size;
                denominator++;
            }
        }
        System.out.println("BF-MEDIO: "+sumBranchingFactor+" DEN: "+denominator+" 1-RP: "+((float) sumBranchingFactor /denominator));
        return ((float) sumBranchingFactor /denominator); // [0-1]
    }

    /* HELPER FUNCTIONS */

    private static int evaluatePageDepth(Element element) {
        if (element.children().isEmpty()) {
            return 1;
        } else {
            int maxChildrenDepth = 0;
            for (Element child : element.children()) {
                int childDepth = evaluatePageDepth(child);
                maxChildrenDepth = Math.max(maxChildrenDepth, childDepth);
            }
            return 1 + maxChildrenDepth;
        }
    }

    private static int evaluateBranchingFactorForElement(Element element) {
        return element.children().size();
    }
}