package org.javabahia.cassandra.tweet.repository;

import java.util.List;
import java.util.UUID;

import org.easycassandra.persistence.cassandra.Persistence;
import org.javabahia.cassandra.tweet.model.Tweet;

public class TweetRepository {

	private Persistence persistence;
	
	public List<Tweet> findByIndex(String nickName) {
		return persistence.findByIndex("nickName", nickName, Tweet.class);
	}

	
	{
		this.persistence = CassandraManager.INSTANCE.getPersistence();
	}


	public void save(Tweet tweet) {
		persistence.insert(tweet);
	}


	public Tweet findOne(UUID uuid) {
		return persistence.findByKey(uuid, Tweet.class);
	}
	
}
