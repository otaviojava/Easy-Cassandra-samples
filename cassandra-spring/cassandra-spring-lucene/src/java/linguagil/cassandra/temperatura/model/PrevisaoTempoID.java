package linguagil.cassandra.temperatura.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class PrevisaoTempoID implements Serializable {

	private static final long serialVersionUID = -3202328496277683345L;
	@Column
	private String cidade;
	@Column
	private Date dia;

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Date getDia() {
		return dia;
	}

	public void setDia(Date dia) {
		this.dia = dia;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof PrevisaoTempoID) {
			PrevisaoTempoID other = PrevisaoTempoID.class.cast(obj);
			return new EqualsBuilder().append(cidade, other.cidade)
					.append(dia, other.dia).isEquals();
		}
		return false;
	}
	@Override
	public int hashCode() {
		
		return new HashCodeBuilder().append(dia).append(cidade).toHashCode();
	}
	
	@Override
	public String toString() {
		
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
