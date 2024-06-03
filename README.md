# Dynamic Calculator Service README 

**Overview**
------------

The calculator is a simple spring-boot web application designed to perform basic arithmetic operations.

**Features**
------------

* Recieves a dynamic array of calculation instructions from a client and performs them.
* Perform addition, subtraction, multiplication, and division of two numbers.
* Supports decimal numbers.

**Usage**
---------

1. Run the program in your terminal or command prompt.
    * mvn spring-boot:run
2. Send a POST request to http://localhost:8080/calculate.
   Send a JSON array of calculation instructions in the body of your POST
3. Press Enter to execute the calculation.
4. The result will be displayed on the next line.

**Curl Example**
----------------
*Request:*
```bash
curl --location 'http://localhost:8080/calculate' \
--header 'Content-Type: application/json' \
--data '{
  "nodes": [
    {
      "value": 10,
      "operation": "assign",
      "dependencies": []
    },
    {
      "value": 5,
      "operation": "add",
      "dependencies": [0]
    },
    {
      "value": 2,
      "operation": "assign",
      "dependencies": []
    },
    {
      "value": 0,
      "operation": "subtract",
      "dependencies": [2, 1]
    },
    {
      "value": 3,
      "operation": "multiply",
      "dependencies": [3]
    }
  ]
}'
```

*Response:*
```bash
{
    "results": [
        10.0,
        15.0,
        2.0,
        -17.0,
        -51.0
    ]
}
```

**Limitations**
--------------

This is a basic calculator and does not support advanced features like trigonometric functions, exponential operations, or complex numbers.

**Development Notes**
--------------------

* This project uses [insert language/framework/library name] for development.
* Code organization follows standard best practices for readability and maintainability.

**Contributing**
-------------

If you'd like to contribute to this project, please feel free to submit pull requests. All contributions are welcome!

