package com.example.restapi;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Path("/hello")
public class HelloService {

    @GET
    @Path("/text")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(){
        return "Hello World!";
    }


    @GET@Path("/html")
    @Produces(MediaType.TEXT_HTML)
    public String helloUsingHTMl(){
        return "<html><body> <h1> Hello Welcome to HTML </h1> </body></html>";
    }

    @GET
    @Path("/list")
    @Produces(MediaType.TEXT_PLAIN)
    public String printList(){
        List<String> list = new ArrayList<>();
        Collections.addAll(list,"Pramod","Prakash","Pratik","Aditya","Pavan");
        return list.toString();
    }
}
