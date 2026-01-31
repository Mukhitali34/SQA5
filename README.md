Running Tests in IntelliJ IDEA
Running Tests Using the Green Arrow (Simple Method)

Open the Test Class:
- Navigate to the Test Class in the src/test/java directory (for example, LoginTests.java).
Find the Test Method:
- Inside the test class, find the specific test method you want to run.
- A test method in TestNG is typically annotated with @Test like this:
@Test
public void TCLOGIN_001_validLogin() {
    // test logic here
}
Run the Test Method:
- Place your cursor inside the test method you want to run (e.g., inside TCLOGIN_001_validLogin).
- You will see a green arrow appear to the left of the method name.
- Click on the green arrow, and IntelliJ will run only the selected test method.
- The results of the test will be shown in the Run window at the bottom of the screen. If the test passes, you'll see a green icon. If it fails, you'll see a red icon with an error message.

Running Tests Using testng.xml Configuration
If you want to run multiple tests from different test classes or want to have a custom test suite, you can use testng.xml. Here's how you can run your tests through testng.xml:
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd" >
<suite name="SauceDemo Suite">
    <listeners>
        <listener class-name="listeners.TestListener"/>
    </listeners>
    <test name="UI Tests">
        <classes>
            <class name="tests.LoginTests"/>
        </classes>
    </test>
</suite>

- This configuration will run all the tests in the LoginTests class
- Set Up TestNG Configuration in IntelliJ IDEA:
- In IntelliJ, click on the Run/Debug Configurations button in the upper-right corner (this is the dropdown next to the green arrow).
- Click + and choose TestNG to add a new configuration.
- Select testng.xml in the Configuration tab.
- Choose suite as the test runner type, and specify the path to the testng.xml file.
- Click OK to save the configuration.
Run Tests via testng.xml:
- Now, you can run the entire suite by clicking the green arrow next to the testng.xml file or the TestNG configuration you just created.
- The tests defined in testng.xml will be executed in the order specified in the XML file, and you'll see the results in the Run window.
