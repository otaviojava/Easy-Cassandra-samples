package org.easycassandra.samples.javaee.rest.persistence;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import org.easycassandra.persistence.cassandra.CassandraFactory;
import org.easycassandra.persistence.cassandra.ClusterInformation;
import org.easycassandra.persistence.cassandra.EasyCassandraManager;
import org.easycassandra.persistence.cassandra.Persistence;
import org.easycassandra.samples.javaee.rest.api.CostUnit;

@ApplicationScoped
public class PersistenceManager {

	
	private static final String HOST = "localhost";

	private static final String KEY_SPACE = "javaee";

	@Produces
	private CassandraFactory cassandraFactory;
	
	@Produces
	private Persistence persistence;
	
	
	@Inject
	public void init(){
		ClusterInformation clusterInformation = ClusterInformation.create()
				.withKeySpace(KEY_SPACE).addHost(HOST);

		EasyCassandraManager easyCassandraManager=new EasyCassandraManager(clusterInformation);
		easyCassandraManager.addFamilyObject(CostUnit.class);
		persistence=easyCassandraManager.getPersistence();
		cassandraFactory=easyCassandraManager;
		
	}
}
