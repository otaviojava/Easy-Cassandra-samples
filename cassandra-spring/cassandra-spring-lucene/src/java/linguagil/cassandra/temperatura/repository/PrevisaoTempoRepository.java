package linguagil.cassandra.temperatura.repository;

import linguagil.cassandra.temperatura.model.PrevisaoTempo;
import linguagil.cassandra.temperatura.model.PrevisaoTempoID;

import org.easycassandra.persistence.cassandra.UpdateBuilder;
import org.easycassandra.persistence.cassandra.spring.CassandraRepository;
import org.easycassandra.persistence.cassandra.spring.CassandraTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository("previsaoRepository")
public class PrevisaoTempoRepository extends CassandraRepository<PrevisaoTempo, PrevisaoTempoID>{

	
	
	@Value(value="#{cassandraFactory.template}")
	private CassandraTemplate cassandraTemplate;

	@Override
	protected CassandraTemplate getCassandraTemplate() {
		return cassandraTemplate;
	}

	public UpdateBuilder<PrevisaoTempo> updateBuilder(PrevisaoTempoID id) {
		return cassandraTemplate.updateBuilder(PrevisaoTempo.class, id);
	}

	
}
