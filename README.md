## STATUS

### accomplished
- Created post method to upload script & parsed script 
- implemented simple front end to show robot position
- cover test cases

### could be improved 
- this is limited to 5 * 5 grids. If we need to change grid, we have to 
change code. We could make it configurable. 
- ui only show the last state of the robot move. 
- script parse based on new line, if line is not present between two 
command, code will not work
- http post method has a limitation of 4gb max upload, need to pay 
attention of the script size 


### remaining task
- what should we do if index out of bound? For example, we have five grid but user command
for FORWARD 9.  
- showing proper error message in case of index out of bound
- improve the look and feel 
- do not hold any previous state 
- add more command
- make grid dynamic or based on config


# ROBOT MOVEMENT 

## Tech spec
- java 1.8 
- spring boot 2.*
- maven
- freemarker & jquery

## DEV setup
To run  this project in local environment, you need to have the following 
- Java 8 or greater version
- Maven 3.5 or greater version

####  To run on the local env
```
$ mvn clean spring-boot:run
```
 

## How to run test 
On this project, there are  unit and integration test. Integration test is time consuming test. 
I am using `it` profile for integration test. 
It is possible to run unit and integration alone. Please follow the instruction bellow.
 Maven lifecycle may help to understand the test and verify phase.   

- Run unit test only
```
$ mvn clean test
```

- Run both unit & integration test
```
$ mvn clean verify 
```


Hit the browser 
```
http://localhost:8080

```

Example script
```
POSITION 1 3 SOUTH
FORWARD 3
WAIT
TURNAROUND
FORWARD 1
RIGHT
FORWARD 2

```

