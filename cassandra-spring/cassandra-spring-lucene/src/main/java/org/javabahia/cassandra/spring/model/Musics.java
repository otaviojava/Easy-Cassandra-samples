package org.javabahia.cassandra.spring.model;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Musics {

	private List<Music> musics;

	public List<Music> getMusics() {
		return musics;
	}

	public void setMusics(List<Music> musics) {
		this.musics = musics;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.SHORT_PREFIX_STYLE);
	}
	
	
}
