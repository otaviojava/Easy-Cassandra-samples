package org.easycassandra.samples.javaee.rest.persistence;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import org.easycassandra.persistence.cassandra.CassandraFactory;
import org.easycassandra.persistence.cassandra.EasyCassandraManager;
import org.easycassandra.persistence.cassandra.Persistence;
import org.easycassandra.samples.javaee.rest.api.CostUnit;

@ApplicationScoped
public class PersistenceManager {

	
	@Produces
	private CassandraFactory cassandraFactory;
	
	@Produces
	private Persistence persistence;
	
	
	@Inject
	public void init(){
		EasyCassandraManager easyCassandraManager=new EasyCassandraManager("localhost", "javaee");
		easyCassandraManager.addFamilyObject(CostUnit.class);
		persistence=easyCassandraManager.getPersistence();
		cassandraFactory=easyCassandraManager;
		
	}
}
