# springboot-jersey
A sample code on how to integrate springboot with Jersey along with mysql

About to start a new project that you want to build with Spring? Do consider giving some thought to SpringBoot.

It offers a fast way to build applications. It looks at your classpath and at beans you have configured, makes reasonable assumptions about what you’re missing, and adds it. With Spring Boot you can focus more on business features and less on infrastructure. Most Spring Boot applications need very little Spring configuration.

In case you wish to use Jersey, you'll find most of the code in this project to get you moving right away.

Here's what I've used in this project : 
* SpringBoot
* Jersey
* BoneCP
* MySql
* Maven

Here's what you need to do to run the above project.

1. Git clone the project by running the following command in your terminal: 
``` git clone git@github.com:LeloucH-Zer0/springboot-jersey.git ```
2. Change the values in ProjectRestService/src/main/resources/db.properties to suit yourself. If you were to change the driver, make sure you add its maven dependency to ProjectBase/pom.xml
3. cd Project
4. mvn clean install
5. cd ProjectRestService
6. mvn spring-boot:run

The project should be up and running in a few seconds on port 8080.
You'd ideally see the message : Started ApplicationConfig in ***** seconds (JVM running for **)

I've created two APIs already. You could test whether the server is running fine by hitting those APIs ideally from a Postman Client.
The APIs can be tested even on a browser by opening [http://localhost:8080/sample/success](http://localhost:8080/sample/success) and [http://localhost:8080/sample/failure](http://localhost:8080/sample/failure)

Let me know if anything went wrong or whether anything needs to be added.


