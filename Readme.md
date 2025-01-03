
# PetStore Selenium tests

Frameworks used: Selenium, Cucumber

Testing framework: TestNG, Allure Report, JUnit

Programming language: JAVA

Build tool : Maven

CI/CD Tool : Jenkins

## Tests run local

```bash
mvn clean test
```

```bash
allure serve target/surefire-reports
```
Evidences of local allure report : allureLocalPrint.png

## Tests

UserSigUp  - new user registration

UserSignIn - login with user

AddProductToCart (includes search item) - search item and adding the search item to the cart

BuyProduct - buying a item

## Jenkins pipeline configuration
Jenkins log: Jenkins_log.txt

Build step : mvn clean test

PostBuild Actions:
allure report; path : target/surefire-reports

##To improve
state element in some tests runs





