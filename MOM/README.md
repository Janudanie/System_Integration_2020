This is a projekt, made to demostrate the usage of a message broker.

I have chosen to use the message broker MQTT, which is a lightweight message broker, primarely used in IoT.

My project consist of two part.
* Java program that acts as the client
* C++ program that emulates 3 banks

How it works.

The Java program sends a loan request out on the topic "loanRequest".
The C++ program gets the loan request and generates 3 different loan offers, which it transmit out on the topic "loanOffer"
The Java program gets the 3 loan offer back, and finds the cheapest one, and presents it to the user.
