package linguagil.cassandra.temperatura.repository;

import linguagil.cassandra.temperatura.model.PrevisaoTempoID;
import linguagil.cassandra.temperatura.model.PrevisaoTempoMedia;

import org.easycassandra.persistence.cassandra.spring.CassandraRepository;
import org.easycassandra.persistence.cassandra.spring.CassandraTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository("previsaoMediaRepository")
public class PrevisaoTempoMediaRepository extends CassandraRepository<PrevisaoTempoMedia, PrevisaoTempoID>{


	@Value(value="#{cassandraFactory.template}")
	private CassandraTemplate cassandraTemplate;

	@Override
	protected CassandraTemplate getCassandraTemplate() {
		return cassandraTemplate;
	}
}
