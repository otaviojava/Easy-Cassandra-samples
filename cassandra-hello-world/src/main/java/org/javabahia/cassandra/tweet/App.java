package org.javabahia.cassandra.tweet;

import java.util.Date;
import java.util.UUID;

import org.javabahia.cassandra.tweet.model.Tweet;
import org.javabahia.cassandra.tweet.repository.TweetRepository;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	
    	TweetRepository personService = new TweetRepository();
    	
    	UUID uuid = UUID.randomUUID();
    	Tweet tweet = new Tweet();
    	tweet.setId(uuid);
    	tweet.setNickName("otaviojava");
    	tweet.setMessage("Linguágil 2014 was awesome");
    	tweet.setTime(new Date());
    	
    	personService.save(tweet);
    	tweet.setId(UUID.randomUUID());
    	tweet.setMessage("Bruno and Edson has gone on Linguagil 2014");
    	personService.save(tweet);
    	
    	Tweet otavio=personService.findOne(uuid);
    	System.out.println(otavio);
    	
    	System.out.println(personService.findByIndex(tweet.getNickName()));
    	
    }
}
