package com.example;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {
	@POST
	public String sayHelloForm(@FormParam("yourName")String name){
		return String.format("Hello yourName=%s %n", name); 
	}
	@Path("hoge")
	@GET
	public String getHeader(@HeaderParam("foo")String foo,
							@CookieParam("bar")String bar){
		return String.format("header foo=%s, bar=%s %n", foo, bar);
	}
	
	@Path("additionMatrix")
	@GET
	public int calculateMatrix(@MatrixParam("left")int left,
							   @MatrixParam("right") int right){
		return left + right ;
	}
	
	@Path("addition")
	@GET
	@Produces("text/plain")
	public int calculate(@QueryParam("a") int a, @QueryParam("b")int b){
		return a+b;
	}

	@Path("hello/{name}")
	@GET
	public String sayHello(@PathParam("name")String name){
		return String.format("Hello %s!", name);
	}
	
	/**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }
}
