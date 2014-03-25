package org.javabahia.cassandra.spring.service;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

import org.apache.lucene.queryparser.classic.ParseException;
import org.javabahia.cassandra.spring.lucene.MusicSearch;
import org.javabahia.cassandra.spring.model.Music;
import org.javabahia.cassandra.spring.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class MusicService {

	@Autowired
	private MusicRepository repository;
	
	@Autowired
	private MusicSearch musicaSearch;
	

	public void save(Music musica){
		repository.save(musica);
		try {
			musicaSearch.index(musica);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public List<Music> findMusicByLyric(String lyric) {
		try {
			List<String> ids = musicaSearch.findMusicByLyric(lyric);
			return (List<Music>) repository.findAll(ids);
		} catch (ParseException | IOException e) {
			Logger.getLogger(MusicService.class.getName()).severe("Error on findMusicByLyric " + e.getMessage());
		}
		return Collections.emptyList();
	}
	
	public List<Music> findMusicByAuthor(String author) {
		try {
			List<String> ids = musicaSearch.findMusicByAuthor(author);
			return (List<Music>) repository.findAll(ids);
		} catch (ParseException | IOException e) {
			Logger.getLogger(MusicService.class.getName()).severe("Error on findMusicByAuthor " + e.getMessage());
		}
		return Collections.emptyList();
	}
	
	
}
