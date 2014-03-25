package org.javabahia.cassandra.spring.repository;

import java.util.UUID;

import org.easycassandra.persistence.cassandra.spring.CassandraRepository;
import org.easycassandra.persistence.cassandra.spring.CassandraTemplate;
import org.javabahia.cassandra.spring.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("personRepository")
public class PersonRepository extends CassandraRepository<Person, UUID>{

	
	@Autowired
	private CassandraTemplate cassandraTemplate;
	
	@Override
	protected CassandraTemplate getCassandraTemplate() {
		return cassandraTemplate;
	}

}
