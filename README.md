# Cinema-Room-REST-Service

## About the project
Always wanted to have your private movie theater and screen only the movies you like? <br/>
You can buy a fancy projector and set it up in a garage, but how can you sell tickets? <br/>
The idea of a ticket booth is old-fashioned, so let's create a special service for that!<br/>
Make good use of Spring and write a REST service that can show the available seats, sell and refund tickets, <br/>
and display the statistics of your venue. Pass me the popcorn, please!

## Table of contents
* [Learning outcomes](#learning-outcomes)
* [How to run](#how-to-run)
* [Technologies](#technologies)
* [How to use](#how-to-use)
* [Presentation video](#presentation-video)

## Learning outcomes
In this project, we will create a simple Spring REST service to manage a small movie theater. <br/>
We use Spring Boot and other technologies to create REST service. It will handle HTTP requests in controllers, handle exceptions, and respond with JSON objects.

## Technologies
- Java 17
- Spring Boot 3.1
- Gradle 8.1
- HTTP
- JSON
- Lombok 6.6

## How to run
You can download an archive, unzip it inside the directory you want to, and open it in your IDE. 

If you want to clone the repo:

- run the command line in the directory you want to store the app and type the following command: 
  
``git clone https://github.com/Hubertoom/Cinema-Room-REST-Service.git`` 

- or start with *Project from Version Control* in your IDE by providing the URL of this repository.


## How to use

Project The project starts on ``localhost/8080`` by default. <br/>
If port `8080` is busy on your machine, you can specify another 
``in applicatoin.properties`` -> ``server.port=``port_number 

There are 4 endpoints available:
- **`/seats`** endpoint that handles `GET` requests and returns the information about the movie theatre.
The response is a JSON object and has the following format:
    ```json
    {
        "total_rows":5,
        "total_columns":6,
        "available_seats":[
        {
            "row":1,
            "column":1
        },
        {
            "more json":"values..."
        },
        {
            "row":5,
            "column":5
        },
        {
            "row":5,
            "column":6
        }
        ]
    }
    ```
&nbsp;

- **`/purchase`** endpoint that handles `POST` requests and marks a booked ticket as purchased. A request should contain the following data:
    - row — the row number;
    - column — the column number.
    
    example: <br/>
*Request body:*
    ```json    
        {
            "row": 3,
            "column": 4
        }
    ```
    If the  request is correct and the  seat is not booked,d you get response containing a  unique UUID token for your ticket from them server: <br/>
    *Response body:*
    ```json
    {
    "token": "e739267a-7031-4eed-a49c-65d8ac11f556",
    "ticket": {
        "row": 3,
        "column": 4,
        "price": 10
    }
    ```
    otherwise, if the  seat is booked: <br/>
    *Response body:*
    ```json
    {
    "error": "The ticket has already been already purchased!"
    }
    ```
    or error if you chose an unexisting seat:
    *Response body:*
    ```json
    {
    "error": "The number of a row or a column is out of bounds!"
    }
    ```
    &nbsp;
- ***`/return`***  endpoint will handle `POST` requests and allow customers to refund their tickets. <br/>
    *Request body:*
    ```json
    {
    "token": "e739267a-7031-4eed-a49c-65d8ac11f556"
    }
    ```
    *Response body:*
    ```json
    {
            "returned_ticket": {
            "row": 1,
            "column": 2,
            "price": 10
        }
    }
    ```
    or with an expired token or wrong token: <br/>
    *Response body:*
    ```json
    {
        "error": "Wrong token!"
    }
    ```
    &nbsp;
    
- **`/stats`** endpoint that will handle `GET` requests with URL parameters. If the URL parameters contain a password key with a `super_secret` value, return the movie theatre statistics in the following format:
    ```json
    {
        "current_income": 0,
        "number_of_available_seats": 81,
        "number_of_purchased_tickets": 0
    }
    ```
    If the parameters don't contain a password key or a wrong value has been passed you get: <br/>
    *Response body:*
    ```json
    {
    "error": "The password is wrong!"
    }
    ```
    &nbsp;

## Presentation video

https://github.com/Hubertoom/readme-validatior/assets/137101859/a4e71b8b-0f9e-4bc7-a7b2-81c3f0db9c34

#### Project page: https://hyperskill.org/projects/189
