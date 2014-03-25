package org.javabahia.cassandra.spring.model;

import org.springframework.core.convert.converter.Converter;

public class MusicConverter implements Converter<String, Music>{

	private static final int INDEX_LYRICS = 2;
	private static final int INDEX_AUTHOR = 1;
	private static final int INDEX_NAME = 0;

	@Override
	public Music convert(String arg0) {
		String[] valores = arg0.split("\\|");
		Music musica = new Music();
		musica.setName(valores[INDEX_NAME]);
		musica.setAuthor(valores[INDEX_AUTHOR]);
		musica.setLyric(valores[INDEX_LYRICS]);
		return musica;
	}

}
