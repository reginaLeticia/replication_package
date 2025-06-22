
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.events.WebDriverListener;
import org.openqa.selenium.support.events.EventFiringDecorator;

import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;

import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class TestRunner {
    private final List<Test> testsToValidate;
    private final Judge judge;
    private WebDriver driver;
    private SelectorWebDriver listener;
    private int numberOfSuccessTests = 0, numberOfFailedTests = 0;

    public TestRunner(List<Test> tests, Judge judge) {
        this.judge = judge;
        this.testsToValidate = tests;
    }

    public int getNumberOfSuccessTests() {
        return this.numberOfSuccessTests;
    }

    public void setNumberOfSuccessTests(int numberOfSuccessTests) {
        this.numberOfSuccessTests = numberOfSuccessTests;
    }

    public int getNumberOfFailedTests() {
        return this.numberOfFailedTests;
    }

    public void setNumberOfFailedTests(int numberOfFailedTests) {
        this.numberOfFailedTests = numberOfFailedTests;
    }

    /* [DESCRIPTION]
        - This function was not written by me. I assume this is the observer initialization
    * */
    private void setupListener() {
        // TODO: COMMENT OUT THIS LINE OF CODE
        // System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

        ChromeDriverService service = new ChromeDriverService.Builder().withLogOutput(System.err).build();
        WebDriverListener listenerDriver;

        driver         = new ChromeDriver(service);
        listener       = new SelectorWebDriver(judge);
        listenerDriver = listener; // This class is used to track the pages and selectors visited during test execution (Observer)
        driver         = new EventFiringDecorator(listenerDriver).decorate(driver);

        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
        listener.setVisitedSelectors(new ArrayList<>());
        listener.setVisitedPages(new ArrayList<>());
    }

    public List<Test> executeTests() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        List<Test> testsFinished = new ArrayList<>();

        for (int testNum = 1; testNum <= testsToValidate.size(); testNum++) {
            setupListener();
            testsFinished.add(executeTest(testNum));
        }
        return testsFinished;
    }

    private Test executeTest(int testNum) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String testName, methodName;
        boolean testFailed = false;

        Test test;
        Method method1, method2, method3;

        List<Page> pageFinished;         // Tested Pages: each page tested will be added to this list
        List<Selector> selectorFinished; // Tested Selector: each selector tested will be added to this list

        System.out.println("Test no." + testNum + " Started!\n");

        // Get the test so it can be executed
        test = testsToValidate.get(testNum - 1);
        testName   = getClassName(test);
        methodName = getMethodName(testName);

        Class[] arg = new Class[1];
        arg[0] = WebDriver.class;

        System.out.println(testName);
        // Execute it
        Class testX = Class.forName(testName);
        Object objPetX = create(testX);

        method1 = testX.getDeclaredMethod("setUp", WebDriver.class);
        method1.invoke(objPetX, driver);
        method2 = testX.getDeclaredMethod(methodName);

        try {
            method2.invoke(objPetX);
            System.out.println("<Test: " + testName + ">" + ", <Invoked method: " + methodName + ">\n");
            test.setPassed(true);
        } catch(Exception e) {
            e.printStackTrace();
            String filePath = "src/test/java/XMLResult/" + JUnitRunner.SoftwareUsed + "/ErrorLog.txt";

            System.err.println("Error Log generated in: " + filePath);

            String errorMessage = "<Test: " + testName + "> " + "<Invoked method: " + methodName + ">" + "\n";

            errorMessage += "[ERROR] Exception Type: " + e.getClass().getName() + ", ";
            Throwable cause = e.getCause();
            if (cause != null) {
                errorMessage += "Root Cause: " + cause.getMessage();
            } else {
                errorMessage += "Root Cause: No detailed message available.";
            }

            errorMessage += "\n" + "------------------------------------------------------------------------------------" + "\n";
            Log.fillErrorLog(errorMessage, filePath);

            setNumberOfFailedTests(numberOfFailedTests + 1);
            testFailed = true;
            test.setPassed(false);
        }

        if(!testFailed) setNumberOfSuccessTests(numberOfSuccessTests + 1);

        method3 = testX.getDeclaredMethod("tearDown");
        method3.invoke(objPetX);

        System.out.println("Test no." + testNum + " Ended!\n");

        selectorFinished = listener.getVisitedSelectors();
        test.setSelectors(selectorFinished);

        pageFinished = listener.getVisitedPages();
        test.setPages(pageFinished);

        return test;
    }

    public List<Test> assignScoreToEachTest(List<Test> tests) {
        double scoreTest;

        for (Test testToJudge: tests) {
            scoreTest = judge.getTestScore(testToJudge);
            testToJudge.setTestScore(scoreTest);
        }
        return tests;
    }

    public static <T> T create(Class<T> someClass) {
        try {
            return someClass.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException ex) {
            throw new RuntimeException("Failed to create instance of class " + someClass.getName(), ex);
        }
    }

    private String getClassName(Test test) {
        String nomeTest;

        nomeTest = test.getClassName();
        nomeTest = nomeTest.replace(".java", "");
        nomeTest = nomeTest.replace("src/test/java/", "");
        nomeTest = nomeTest.replace("/", ".");
        return nomeTest;
    }

    private String getMethodName(String nomeTest) {
        String nomeMetodo = nomeTest.replace("Test", "");
        nomeMetodo = (nomeMetodo.substring(nomeMetodo.lastIndexOf(".") + 1).trim());
        nomeMetodo = decapitalize(nomeMetodo);
        return nomeMetodo;
    }

    public static String decapitalize(String string) {
        if (string == null || string.isEmpty()) return string;

        char[] c = string.toCharArray();
        c[0] = Character.toLowerCase(c[0]);
        c[1] = Character.toLowerCase(c[1]);
        return new String(c);
    }
}