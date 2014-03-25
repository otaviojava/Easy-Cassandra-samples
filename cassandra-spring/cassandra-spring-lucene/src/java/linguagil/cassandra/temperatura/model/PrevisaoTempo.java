package linguagil.cassandra.temperatura.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity(name = "previsaotempo")
public class PrevisaoTempo {

	@EmbeddedId
	private PrevisaoTempoID id;
	
	@Column(name = "temperatura")
	private Double temperatura;
	
	@ElementCollection
	@Column(name = "temperaturas")
	private List<Double> temperaturas;

	public PrevisaoTempoID getId() {
		return id;
	}

	public void setId(PrevisaoTempoID id) {
		this.id = id;
	}

	public Double getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(Double temperatura) {
		this.temperatura = temperatura;
	}

	public List<Double> getTemperaturas() {
		return temperaturas;
	}

	public void setTemperaturas(List<Double> temperaturas) {
		this.temperaturas = temperaturas;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof PrevisaoTempo) {
			PrevisaoTempo other = PrevisaoTempo.class.cast(obj);
			return new EqualsBuilder().append(id, other.id)
					.isEquals();
		}
		return false;
	}
	@Override
	public int hashCode() {
		
		return new HashCodeBuilder().append(id).toHashCode();
	}
	
	@Override
	public String toString() {
		
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.SHORT_PREFIX_STYLE);
	}
	
}
