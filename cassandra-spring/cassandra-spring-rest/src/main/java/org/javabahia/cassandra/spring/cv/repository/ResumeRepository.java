package org.javabahia.cassandra.spring.cv.repository;

import org.easycassandra.persistence.cassandra.spring.CassandraRepository;
import org.easycassandra.persistence.cassandra.spring.CassandraTemplate;
import org.javabahia.cassandra.spring.cv.model.Resume;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository
@Scope("prototype")
public class ResumeRepository extends CassandraRepository<Resume, String>{


	@Value(value="#{cassandraFactory.template}")
	private CassandraTemplate cassandraTemplate;

	@Override
	protected CassandraTemplate getCassandraTemplate() {
		return cassandraTemplate;
	}
}
