# LambdaTest certification Assignment

## Instructions to run test: 
Simply Execute below command </br>
`mvn clean test -DltUser=XXXXXX -DltToken=XXXXXX`

ltUser - Lambdatest username </br>
ltToken - LambdaTest token to run test </br>

If no paramaters passed then credentials will be taken from Const.java file
you can simpley run command `mvn clean test` to use default credentials from Const.java file

Assumptions: </br>
1) Follow Assignment instructions as a requirement. Any non compliance will be fail the test and considered as defect
2) TimeOut - I have set 90 seconds timeout. becaue I have only 1 parallel test license to my account. The other test was failing after waiting in queue. so for demo purpose i have set 90 seconds. you can change timeout to 20 seconds by setting `TIMEOUT=20000;` in Const.java
3) The code/framework runs 2 tests in parallel even though I have one parallel execution license.

Tests Failing becaue of below defects: </br>
1) Defect#1 : clicking on  "all integrations link" does not open new page in new tab/window. Actual: This link opens in same window/tab
2) Defect#2 : Page title failed after opening testing whiz learn more expected [TestingWhiz Integration | LambdaTest] but found [Running Automation Tests Using TestingWhiz LambdaTest | LambdaTest]For Seamless Browser Compatibility Testing | LambdaTest]

Final Test Session Id from lambdatest: </br>
* ZK4W5-XBDLY-BFNEN-Y1O1T - Chrome
* MU5TD-SZOED-M9SRZ-IOOTA - Edge