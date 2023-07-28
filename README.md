# Cinema-Room-REST-Service

## About the project
Always wanted to have your private movie theater and screen only the movies you like? <br/>
You can buy a fancy projector and set it up in a garage, but how can you sell tickets? <br/>
The idea of a ticket booth is old-fashioned, so let's create a special service for that!<br/>
Make good use of Spring and write a REST service that can show the available seats, sell and refund tickets, <br/>
and display the statistics of your venue. Pass me the popcorn, please!

## Learning outcomes
In this project, we will create a simple Spring REST service to manage a small movie theater. <br/>
It will handle HTTP requests in controllers, create services, handling exception, and respond with JSON objects.

## How to run
You can simply download an archive, unzip it inside the directory you want to, and open it in your IDE. 

If you want to clone the repo:

- run the command line in the directory you want to store the app and type the following command: 
  
``git clone https://github.com/Hubertoom/Cinema-Room-REST-Service.git`` 

- or start with *Project from Version Control* in your IDE by providing the URL of this repository.


## How to use

Project The project starts on ``localhost/8080`` by default. <br/>
If port `8080` is busy on your machine, you can specify another 
``in applicatoin.properties`` -> ``server.port=``port_number 

There are 4 endpoints available:
- ``/seats" for retrieving all seats in the cinema theatre
- ``/purchase`` endpoint that handles ``POST`` requests and marks a booked ticket as purchased. A request should contain the following data:
    * row — the row number;
    * column — the column number.
example:
``{
    "row": 3,
    "column": 4
}``



#### Project page: https://hyperskill.org/projects/189