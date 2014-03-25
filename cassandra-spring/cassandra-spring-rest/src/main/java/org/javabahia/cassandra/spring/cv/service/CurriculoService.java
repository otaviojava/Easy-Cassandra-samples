package org.javabahia.cassandra.spring.cv.service;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.apache.lucene.queryparser.classic.ParseException;
import org.javabahia.cassandra.spring.cv.lucene.ResumeSearch;
import org.javabahia.cassandra.spring.cv.model.Resume;
import org.javabahia.cassandra.spring.cv.repository.ResumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class CurriculoService {
	
	@Autowired
	private ResumeRepository repository;
	
	@Autowired
	private ResumeSearch search;
	
	public void save(Resume cv){
		repository.save(cv);
		try {
			search.index(cv);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<Resume> procurarCV(String texto) {
		try {
			List<String> ids = search.findByBio(texto);
			return (List<Resume>) repository.findAll(ids);
		} catch (ParseException | IOException e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}

}
