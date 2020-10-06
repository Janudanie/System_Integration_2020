package org.example;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class SoapWS {
    private String message = new String("Hello, ");

    public void Hello() {}

    @WebMethod
    public String sayHello(String name) {
        return message + name + ".";
    }
}
