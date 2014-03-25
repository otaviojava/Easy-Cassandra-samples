package linguagil.cassandra.temperatura.service;

import java.util.Date;

import linguagil.cassandra.temperatura.model.PrevisaoTempo;
import linguagil.cassandra.temperatura.model.PrevisaoTempoID;
import linguagil.cassandra.temperatura.repository.PrevisaoTempoRepository;

import org.easycassandra.persistence.cassandra.UpdateBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrevisaoService extends AbstractService{

	@Autowired
	private PrevisaoTempoRepository repository;
	
	@Autowired
	private PrevisaoMediaService mediaService;

	public void inserir(PrevisaoTempoID id, double temperatura) {
		Date dia = limparDia(id.getDia());
		id.setDia(dia);
		
		UpdateBuilder<PrevisaoTempo> updateBuilder = repository.updateBuilder(id);
		updateBuilder.addList("temperaturas", temperatura).value("temperatura", temperatura);
		updateBuilder.executeAsync();
		
		mediaService.atualizar(id);
	}
	
	public PrevisaoTempo findById(PrevisaoTempoID id) {
		Date dia = limparDia(id.getDia());
		id.setDia(dia);
		return repository.findOne(id);
	}
	

}
	