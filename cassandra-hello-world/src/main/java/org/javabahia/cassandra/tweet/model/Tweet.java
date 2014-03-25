package org.javabahia.cassandra.tweet.model;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.easycassandra.Index;

@Entity(name = "tweet")
public class Tweet implements Serializable {

    private static final long serialVersionUID = 3L;
    
    @Id
    private UUID id;
    
    @Index
    @Column(name = "nickName")
    private String nickName;
    
    @Column(name = "message")
    private String message;

    @Column(name = "time")
    private Date time;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
    
	@Override
	public boolean equals(Object obj) {
	 if(obj instanceof Tweet) {
		 Tweet other = Tweet.class.cast(obj);
		 return new EqualsBuilder().append(id, other.id).isEquals();
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
