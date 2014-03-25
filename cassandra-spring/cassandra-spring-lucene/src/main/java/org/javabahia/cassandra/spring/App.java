package org.javabahia.cassandra.spring;

import java.io.IOException;

import org.apache.lucene.queryparser.classic.ParseException;
import org.javabahia.cassandra.spring.model.Music;
import org.javabahia.cassandra.spring.model.Musics;
import org.javabahia.cassandra.spring.service.MusicService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class App {
	public static void main(String[] args) throws IOException, ParseException {
		@SuppressWarnings("resource")
		ApplicationContext ctx = new GenericXmlApplicationContext("SpringConfig.xml");
		Musics musicas = ctx.getBean(Musics.class);
		MusicService service = ctx.getBean(MusicService.class);
		for (Music musica: musicas.getMusics()) {
			service.save(musica);	
		}
		LuceneUtil.INSTANCE.backupToHD();
		System.out.println(service.findMusicByLyric("lepo lepo"));
		System.out.println(service.findMusicByLyric("aMoR"));
		
		System.out.println(service.findMusicByAuthor("Luan Santana"));
		System.out.println(service.findMusicByAuthor("Santana"));
		System.out.println(service.findMusicByAuthor("Psirico"));
	}
	
}