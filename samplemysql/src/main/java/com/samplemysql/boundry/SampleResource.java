package com.samplemysql.boundry;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
		
		System.out.println("-------- ENV Variables ");
		
		final String DATABASE_SERVICE_NAME = System.getenv("DATABASE_SERVICE_NAME");
		System.out.println("ENV (DATABASE_SERVICE_NAME) = "+DATABASE_SERVICE_NAME);
             	     
		final String USER = System.getenv(DATABASE_SERVICE_NAME+"_USER");
		System.out.println("ENV ("+DATABASE_SERVICE_NAME+"_USER) = "+USER);
		
		final String PASSWORD = System.getenv(DATABASE_SERVICE_NAME+"_PASSWORD");
		System.out.println("ENV ("+DATABASE_SERVICE_NAME+"_PASSWORD) = "+PASSWORD);
		
		final String DATABASE = System.getenv(DATABASE_SERVICE_NAME+"_DATABASE");
		System.out.println("ENV ("+DATABASE_SERVICE_NAME+"_DATABASE) = "+DATABASE);
			
		final String HOST = System.getenv(DATABASE_SERVICE_NAME+"_SERVICE_HOST");
		System.out.println("ENV ("+DATABASE_SERVICE_NAME+"_SERVICE_HOST) = "+HOST);
		
		final String PORT = System.getenv(DATABASE_SERVICE_NAME+"_SERVICE_PORT");
		System.out.println("ENV ("+DATABASE_SERVICE_NAME+"_SERVICE_PORT) = "+PORT);
		
		System.out.println("-------- MySQL "
				+ "JDBC Connection Testing ------------");

		try {

			Class.forName("com.mysql.jdbc.Driver");

		} catch (ClassNotFoundException e) {

			System.out.println("Where is your MySQL JDBC Driver? "
					+ "Include in your library path!");
			e.printStackTrace();
			return Response.status(Response.Status.SERVICE_UNAVAILABLE).entity("No MySQL Driver!").build();

		}

		System.out.println("MySQL JDBC Driver Registered!");

		Connection connection = null;

		try {

			connection = DriverManager.getConnection(
					"jdbc:mysql://"+HOST+":"+PORT+"/"+DATABASE, USER, PASSWORD);

		} catch (SQLException e) {

			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return Response.status(Response.Status.SERVICE_UNAVAILABLE).entity("Connection Failed!").build();

		}

		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
			return Response.status(Response.Status.SERVICE_UNAVAILABLE).entity("Failed to make connection!").build();

		}
		
        return Response.status(Response.Status.OK).entity("Sample made a database connection").build();

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
