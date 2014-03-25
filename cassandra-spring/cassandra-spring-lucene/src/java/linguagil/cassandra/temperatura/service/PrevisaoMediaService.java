package linguagil.cassandra.temperatura.service;

import java.util.Date;

import linguagil.cassandra.temperatura.model.PrevisaoTempo;
import linguagil.cassandra.temperatura.model.PrevisaoTempoID;
import linguagil.cassandra.temperatura.model.PrevisaoTempoMedia;
import linguagil.cassandra.temperatura.repository.PrevisaoTempoMediaRepository;
import linguagil.cassandra.temperatura.repository.PrevisaoTempoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrevisaoMediaService extends AbstractService{

	@Autowired
	private PrevisaoTempoMediaRepository repository;

	@Autowired
	private PrevisaoTempoRepository previsaoTempoRepository;

	public void atualizar(PrevisaoTempoID id) {
		PrevisaoTempo previsao = previsaoTempoRepository.findOne(id);
		Double temperaturaMedia = 0d;
		for (Double temperatura: previsao.getTemperaturas() ){
			temperaturaMedia+=temperatura;
		}
		temperaturaMedia/=previsao.getTemperaturas().size();
		
		PrevisaoTempoMedia previsaoTempoMedia = new PrevisaoTempoMedia();
		previsaoTempoMedia.setId(id);
		previsaoTempoMedia.setTemperatura(temperaturaMedia);

		repository.save(previsaoTempoMedia);
	}
	public PrevisaoTempoMedia findById(PrevisaoTempoID id) {
		Date dia = limparDia(id.getDia());
		id.setDia(dia);
		return repository.findOne(id);
	}
}
	