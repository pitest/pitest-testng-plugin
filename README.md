# TestNG Plugin 

Adds support to pitest for TestNg

## Versions

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/org.pitest/pitest-testng-plugin/badge.svg?style=flat)](https://maven-badges.herokuapp.com/maven-central/org.pitest/pitest-testng-plugin)

* 0.1 requires pitest 1.7.6 or above

## Usage

To activate the plugin it must be placed on the classpath of the pitest tool (**not** on the classpath of the project being mutated).

### Maven

```xml
    <plugins>
      <plugin>
        <groupId>org.pitest</groupId>
        <artifactId>pitest-maven</artifactId>
        <version>1.7.6</version>
        <dependencies>
          <dependency>
            <groupId>org.pitest</groupId>
            <artifactId>pitest-testng-plugin</artifactId>
            <version>0.1</version>
          </dependency>
        </dependencies>
      </plugin>
   </plugins>
```
For Pitest configuration options, have a look at http://pitest.org/quickstart/maven/.


## About

Plugin extracted from code originally included in pitest, but removed in 1.7.6.

If you use TestNG with pitest and would like to improve support, this project is looking for a new owner.
