package linguagil.cassandra.temperatura.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity(name = "previsaotempomedia")
public class PrevisaoTempoMedia {

	@EmbeddedId
	private PrevisaoTempoID id;
	
	@Column(name = "media")
	private Double temperatura;

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
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof PrevisaoTempoMedia) {
			PrevisaoTempoMedia other = PrevisaoTempoMedia.class.cast(obj);
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
