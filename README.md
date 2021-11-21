### Problem
We would like you to implement an interface to an ATM. The use cases that you must fulfill are:
* A customer can login to the ATM account by providing a 4 digit pin number
* A customer can view their current balance
* A customer can deposit money
* A customer can withdraw money

We expect you to spend no more than 2 hours on this exercise but we do value a complete solution.   The requirements are left purposefully open ended.   Please consider that your solution should contain instructions on how to build, test, and execute your solution. A command line interface to represent the interface is adequate.

### Design

The application was developed using MVC pattern.

* Entry class: ATM
* Controller: ATMController
* Model: BankAccountView
* View: _Any class ends with View_
* Domain: BanakAccount
* Repository: BankAccountRepository

### Requirements
- Java 8
- Maven 3

### How to build
```sh
$ cd /path/to/dir
$ mvn clean package
...
```

### How to run
```sh
$ cd /path/to/dir
$ java -jar target/atm-1.0-SNAPSHOT.jar
...
```

### Things to improve
- Application won't run inside IDE like Intellij or Eclipse, because it depends on System.console() which IDEs don't support.
- How to simulate user input from command line? So we can automate tests.
