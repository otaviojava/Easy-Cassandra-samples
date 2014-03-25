package org.javabahia.cassandra.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity
public class Music implements Serializable{
	
	private static final long serialVersionUID = -8245568483951712497L;

	@Id
	private String name;
	@Column
	private String author;
	@Column
	private String lyric;

	public String getName() {
		return name;
	}

	public void setName(String nome) {
		this.name = nome;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String autor) {
		this.author = autor;
	}

	public String getLyric() {
		return lyric;
	}

	public void setLyric(String lyric) {
		this.lyric = lyric;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.SHORT_PREFIX_STYLE);
	}

}
