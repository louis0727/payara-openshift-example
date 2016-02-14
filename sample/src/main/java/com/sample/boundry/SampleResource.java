package com.sample.boundry;


import javax.ejb.Stateless;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.GET;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Stateless
@Path("/")
public class SampleResource {

	@GET
	@Path("/hello")
	@Produces( MediaType.TEXT_PLAIN )
	public Response locations(@Context HttpHeaders httpHeaders, @Context HttpServletResponse response,
	        @Context HttpServletRequest request) {
             	     
        System.out.println("Request");
		
        return Response.status(Response.Status.OK).entity("Sample says hello").build();

	}
	
	@GET
	@Path("/health")
	@Produces( MediaType.TEXT_PLAIN )
	public Response health(@Context HttpHeaders httpHeaders, @Context HttpServletResponse response,
	        @Context HttpServletRequest request) {
             
		System.out.println("Health check");
        	
        return Response.status(Response.Status.OK).entity("healthy").build();

	}
    
}
