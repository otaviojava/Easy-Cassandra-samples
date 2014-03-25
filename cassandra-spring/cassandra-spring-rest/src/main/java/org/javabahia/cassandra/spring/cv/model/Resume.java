package org.javabahia.cassandra.spring.cv.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity
public class Resume  implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	private String nickName;
	@Column
	private String name;
	@Column
	private String country;
	@Column
	private String bio;

	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	
	@Override
	public String toString() {

		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.SHORT_PREFIX_STYLE);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Resume) {
			Resume other = Resume.class.cast(obj);
			return new EqualsBuilder().append(other.nickName, nickName)
					.isEquals();
		}
		return false;
	}

	@Override
	public int hashCode() {

		return new HashCodeBuilder().append(nickName).toHashCode();
	}
}
