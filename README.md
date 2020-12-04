# springboot-rsocketbasicauth-example
An example of using Basic Auth with [RSocket](http://rsocket.io) and Spring Boot.

## Building the Example
Run the following command to build the example application:

    ./gradlew clean build
    
## Running the Example
Follow the steps below to run the example application:

1. Run the following command to start the `hello-service`:

        ./gradlew :hello-service:bootRun
        
2. In a new terminal, run the following command to send a request to the unsecured `hello` endpoint:

        ./gradlew :hello-client:bootRun --args="hello Bob"
        
    If successful, you will see the following response:
    
        2019-12-18 11:02:55.038  INFO 3540 --- [           main] e.client.hello.HelloClientApplication    : Sending message without Basic Auth metadata...
        2019-12-18 11:02:55.065  INFO 3540 --- [           main] e.client.hello.HelloClientApplication    : Response: Hello, Bob, from unsecured method
        
3. Next, run the following command to send a request to the secure `hello.secure` endpoint:

        ./gradlew :hello-client:bootRun --args="hello.secure Bob"
        
    You will receive an `io.rsocket.exceptions.ApplicationErrorException: Access Denied` because you have not supplied valid credentials.
   
4. Next, run the following command to send a request to the secure `hello.secure` endpoint, but this time supplying valid credentials:

        ./gradlew :hello-client:bootRun --args="--username=admin --password=password hello.secure Bob"
        
    If successful, you will see the following response:

        2019-12-18 11:07:12.171  INFO 3575 --- [           main] e.client.hello.HelloClientApplication    : Sending message with Basic Auth metadata...
        2019-12-18 11:07:12.284  INFO 3575 --- [           main] e.client.hello.HelloClientApplication    : Response: Hello, Bob, from secured method

## Bugs and Feedback
For bugs, questions, and discussions please use the [Github Issues](https://github.com/gregwhitaker/springboot-rsocketbasicauth-example/issues).

## License
MIT License

Copyright (c) 2019-Present Greg Whitaker

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
