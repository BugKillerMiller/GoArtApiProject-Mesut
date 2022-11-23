# API Test Automation Framework

This framework can  help you speed up your framework setup process as it consist of most of the feature required to test Rest Api.

## Getting Started

To get started clone project from github. 

Below are the api used to write this framework which will help you drive your test.
* Junit
* RestAssured
* Cucumber
* Json Path
* Cucumber-html-report

Prerequisites

* JDK 1.8 or hire version should be installed.
* Maven should be installed.


## Configuration

* Environment config files (*.properties) to target your service.

## Writing Test

### Feature
As we have used cucumber we can write our test in Gherkin language which plain english language. Test can be written in feature file and it can be stored in features directory.

### Step definition
We can write step definition with respect to the feature in steps directory.

## Running your Test
When you are ready to run your tests from the command line, below is an examples of run command (standard maven command line syntax):


```
mvn verify
```

## Test Results

Once all the test are executed results can be generated in target folder below "cucumber-report-html --> report-feature_file-src-test-resource-features-goartApi-feature.html" file.

## Author

* Mesut Öztürk
