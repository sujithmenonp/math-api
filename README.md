# Requirements
Part-1
Implement the below two rest API end points with Spring with a Maven Based SpringBoot project .
The API should be running on port 9091 on http.

API 1- SUM
POST http://{{service-ip}}/api/add
{
            "x":"100",
            "y":"50"
}
return 200 OK with
{
            "result":"150"
}

 

API 2- DIFF
POST http://{{service-ip}}/api/diff
{
            "x":"100",
            "y":"50"
}
return 200 OK with
{
            "result":"50"
}

------
Part- 2
Implement a basic authentication mechanism for the same where a username and password is accepted

# Math API

1. Created 2-layer architecture (controller and service layer)No DB layer required
2. Created service layer for add and diff operations
3. Handled huge numbers using Big Decimal
4. Handled Request Validations using javax validation 
5. Handled service level exceptions using ResponseStatusException
6. Created models/dao for requests and responses
7. Added integration tests and units tests using JUnit and mockito
8. Added Spring Security with Basic Authentication with in-memory authentication
9.Dockerize the app

//TODO
1. Support LDAP or JDBC based auth instead of im-memory auth
2. Decide on deployment strategy
3. Have a service discovery mechanism
4. Add Log Statements
5. Capture metrics using actuators 
6. Add Client Module for Service Discovery

