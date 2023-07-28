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
- ***`/seats`*** endpoint that handles `GET` requests and returns the information about the movie theatre.
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

      ........

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


- ***`/purchase`*** endpoint that handles `POST` requests and marks a booked ticket as purchased. A request should contain the following data:
    - row — the row number;
    - column — the column number.
    
    example:
*Request body:*
    ```json    
        {
            "row": 3,
            "column": 4
        }
    ```
    If request is correct and seat is not booked you get response containing unique UUID token for your ticket from them server:
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
    otherwise, if seat is booked:
    *Response body:*
    ```json
    {
    "error": "The ticket has been already purchased!"
    }
    ```
    or error if you chose unexisting seat:
    *Response body:*
    ```json
    {
    "error": "The number of a row or a column is out of bounds!"
    }
    ```
    
- ***`/return`***  endpoint, which will handle `POST` requests and allow customers to refund their tickets.
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
    or with an expired token or wrong tokken:
    *Response body:*
    ```json
    {
        "error": "Wrong token!"
    }
    ```
    
    
- ***`/stats`*** endpoint that will handle `GET` requests with URL parameters. If the URL parameters contain a password key with a `super_secret` value, return the movie theatre statistics in the following format:
    ```json
    {
        "current_income": 0,
        "number_of_available_seats": 81,
        "number_of_purchased_tickets": 0
    }
    ```
    If the parameters don't contain a password key or a wrong value has been passed you get:
    *Respone body:*
    ```json
    {
    "error": "The password is wrong!"
    }
    ```

#### Project page: https://hyperskill.org/projects/189