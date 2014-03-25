package org.javabahia.cassandra.spring.cv.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.javabahia.cassandra.spring.cv.model.Resume;
import org.javabahia.cassandra.spring.cv.service.CurriculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("/resume")
public class ResumeResource {
	
	@Autowired
	private CurriculoService service;
	
	@GET
	public Response printMessage() {
		return Response.status(200).entity("It's working").build();
	}
	
	@GET
	@Path("/{conteudo}")
	@Produces("application/json;charset=utf-8")
	public List<Resume> getCV(@PathParam("conteudo")String text) {
		return service.procurarCV(text); 
 
	}
	
	@POST
	@Consumes("application/json;charset=utf-8")
	public Response insertResume(Resume curriculo) {
		service.save(curriculo);
		return Response.status(201).entity("Sucess").build();
 
	}

}
