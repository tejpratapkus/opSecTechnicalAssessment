# README #

This README would normally document whatever steps are necessary to get your application up and running.

### What is this repository for? ###

* Quick summary
  * This service is to create, update, get, and delete user information.
* Version
  * The latest version of this application is 0.0.1-SNAPSHOT.

### How do I get set up? ###

* Summary of set up
  * You have to install Java 1.8 in your system and set the path.
  * You have to install MongoDb in you system.
  * You have to install Maven 4.0 in your system and set the path.
  * You have to install any IDE like STS, Intellij, Eclipse.
* Configuration
  * You have to create database inside MongoDb with the name opsec.
* Dependencies
  * You have to create database in you local system with provide name or if you wan't to change that, so you have to change db name inside application.properties file. 
* Database configuration
  * Database configuration has been done inside application.properties file.
* How to run test
  * You can run the test cases by moving to the project directory and open cmd and run the below provided commend.
    * mvn clean install -> it will execute the whole code and also execute the test cases.
* Deployment instructions
  * You can create a jar by using above maven command and put it into your server and run the below command.
    * nohup java -jar opsec_user-0.0.1-SNAPSHOT.jar &
    * nohup java -jar opsec_gateway-0.0.1-SNAPSHOT.jar &
  
### Who do I talk to? ###

* Repo owner or admin
  * User Name:- tejpratapkus
  * Email:- tejpratapk@gmail.com

## Creating a jar using below commond

```bash
$ mvn clean install
```

## Running the full application

```bash
$ nohup java -jar opSecTechnicalAssessment/target/opsec_user-0.0.1-SNAPSHOT.jar &

$ nohup java -jar opSecTechnicalAssessment/target/opsec_gateway-0.0.1-SNAPSHOT.jar &
```

```bash
$ GET URL for get singele user http://localhost:8080/opsec-user/v1/user?id=1

$ GET URL for get all user http://localhost:8080/opsec-user/v1/user

$ POST URL for create user http://localhost:8080/opsec-user/v1/user

$ PUT URL for update user http://localhost:8080/opsec-user/v1/user/1

$ DELETE URL for delete user http://localhost:8080/opsec-user/v1/user/1
```