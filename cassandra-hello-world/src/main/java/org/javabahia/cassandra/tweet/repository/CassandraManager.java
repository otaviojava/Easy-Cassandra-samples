package org.javabahia.cassandra.tweet.repository;

import org.easycassandra.persistence.cassandra.ClusterInformation;
import org.easycassandra.persistence.cassandra.EasyCassandraManager;
import org.easycassandra.persistence.cassandra.Persistence;
import org.javabahia.cassandra.tweet.model.Tweet;

public enum CassandraManager {
	INSTANCE;
	private EasyCassandraManager easyCassandraManager;
	private Persistence persistence;
	{
		easyCassandraManager = new EasyCassandraManager(ClusterInformation.create().addHost("localhost").withKeySpace("javabahia"));
		easyCassandraManager.addFamilyObject(Tweet.class);
		persistence = easyCassandraManager.getPersistence();
	}
	
	public Persistence getPersistence() {
		return persistence;
	}
}
