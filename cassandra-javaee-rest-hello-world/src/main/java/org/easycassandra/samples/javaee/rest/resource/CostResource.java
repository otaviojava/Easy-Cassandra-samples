package org.easycassandra.samples.javaee.rest.resource;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.easycassandra.persistence.cassandra.Persistence;
import org.easycassandra.samples.javaee.rest.api.CostOperations;
import org.easycassandra.samples.javaee.rest.api.CostUnit;

/**
 *
 * @author otaviojava
 */
@Path("/cost")
@RequestScoped
public class CostResource implements CostOperations{

	
	@Inject
	private Persistence persistence;
	
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public boolean save(CostUnit bean) {
    	
        return persistence.insert(bean);
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	@Override
	public boolean update(CostUnit bean){
		
    	return persistence.update(bean);
	}

    @Path("/{id}")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	@Override
	public boolean delete(@PathParam("id") String id) {
		
		return persistence.deleteByKey(id, CostUnit.class);
	}

    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
	@Override
	public List<CostUnit> list() {
		return persistence.findAll(CostUnit.class);
	}

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String get(){
        return "it's wokring";
    }

    @Path("/{id}")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	@Override
	public CostUnit retrieve(@PathParam("id") String id) {
		return persistence.findByKey(id, CostUnit.class);
	}
	
}
