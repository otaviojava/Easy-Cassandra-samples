package org.javabahia.cassandra.spring;

import java.util.UUID;

import org.javabahia.cassandra.spring.entity.Person;
import org.javabahia.cassandra.spring.repository.PersonRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	@SuppressWarnings("resource")
		ApplicationContext ctx = new GenericXmlApplicationContext("SpringConfig.xml");
    	
    	PersonRepository personService=ctx.getBean(PersonRepository.class);
    	
    	UUID uuid=UUID.randomUUID();
    	Person person=new Person();
    	person.setId(uuid);
    	person.setName("Otávio Santana");
    	person.setYear(25);
    	
    	personService.save(person);
    	
    	
    	Person otavio=personService.findOne(uuid);
    	System.out.println(otavio.getName());
    	
    	
    }
}
