# README #

This README would normally document whatever steps are necessary to get your application up and running.

### What is this repository for? ###

* Quick summary
* Version
* [Learn Markdown](https://bitbucket.org/tutorials/markdowndemo)

### How do I get set up? ###

* Summary of set up
* Configuration
* Dependencies
* Database configuration
* How to run tests
* Deployment instructions

### Contribution guidelines ###

* Writing tests
* Code review
* Other guidelines

### Who do I talk to? ###

* Repo owner or admin
* Other community or team contact

## Creating a jar using below commond

```bash
$ mvn clean install
```

## Running the full application

```bash
$ java -jar opSecTechnicalAssessment/target/opsec_user-0.0.1-SNAPSHOT.jar

$ java -jar opSecTechnicalAssessment/target/opsec_gateway-0.0.1-SNAPSHOT.jar
```

```bash
$ GET URL for get singele user http://localhost:8080/opsec-user/v1/user?id=1

$ GET URL for get all user http://localhost:8080/opsec-user/v1/user

$ POST URL for create user http://localhost:8080/opsec-user/v1/user

$ PUT URL for update user http://localhost:8080/opsec-user/v1/user/1

$ DELETE URL for delete user http://localhost:8080/opsec-user/v1/user/1
```