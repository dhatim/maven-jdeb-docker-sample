package com.dhatim.blog.resources;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("hello")
public class HelloWorldResource {

    @GET
    public String greet(@QueryParam("name") @DefaultValue("World") String name) {
        return "Hello, " + name + "!";
    }
}