package com.javajaxrs.conf.res;

import javax.ws.rs.core.Response;

public class ResponseGenerator {

    private String query;
    private String variables;

    public ResponseGenerator() {
    }

    public ResponseGenerator(String Key) {
        this.query = query;
        this.variables = variables;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getVariables() {
        return variables;
    }

    public void setVariables(String variables) {
        this.variables = variables;
    }

    public static Response sample(){
       return Response.ok("{query: null ,variable: null }").build();
    }

    public Response getResponse(){
        return Response.ok("Key : "+getQuery()+", variables : "+getVariables()).build();
    }
}
