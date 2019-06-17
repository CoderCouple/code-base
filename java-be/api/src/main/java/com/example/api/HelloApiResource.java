package com.example.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/v1")
public class HelloApiResource {

    @Path("/hello")
    @GET
    @Produces({"text/plain"})
    public String greet() {
        return "Hello World";
    }

}