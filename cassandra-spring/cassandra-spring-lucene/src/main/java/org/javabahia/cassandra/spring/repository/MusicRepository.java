package org.javabahia.cassandra.spring.repository;

import org.easycassandra.persistence.cassandra.spring.CassandraRepository;
import org.easycassandra.persistence.cassandra.spring.CassandraTemplate;
import org.javabahia.cassandra.spring.model.Music;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository
@Scope("prototype")
public class MusicRepository extends CassandraRepository<Music, String>{


	@Value(value="#{cassandraFactory.template}")
	private CassandraTemplate cassandraTemplate;

	@Override
	protected CassandraTemplate getCassandraTemplate() {
		return cassandraTemplate;
	}

}
