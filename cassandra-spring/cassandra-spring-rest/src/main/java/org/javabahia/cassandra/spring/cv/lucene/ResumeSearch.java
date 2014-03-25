package org.javabahia.cassandra.spring.cv.lucene;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopScoreDocCollector;
import org.apache.lucene.util.Version;
import org.javabahia.cassandra.spring.cv.model.Resume;
import org.javabahia.cassandra.spring.cv.util.LuceneUtil;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class ResumeSearch {

	private static final String COLUMN_RESUME = "cv";
	private static final String COLUMN_COUNTRY = "estado";
	private static final String COLUMN_NAME = "name";
	private static final String COLUMN_NICk_NAME = "nickName";

	public List<String> findByBio(String bio) throws ParseException, IOException {
		Query query = new QueryParser(Version.LUCENE_46, COLUMN_RESUME,
				LuceneUtil.INSTANCE.getAnalyzer()).parse(bio);
		return returnResume(query);
	}
	
	

	private List<String> returnResume(Query query) throws IOException {
		int hitsPerPage = 10;
		IndexReader reader = DirectoryReader.open(LuceneUtil.INSTANCE.getDirectory());
		IndexSearcher searcher = new IndexSearcher(reader);
		TopScoreDocCollector collector = TopScoreDocCollector.create(
				hitsPerPage, true);
		searcher.search(query, collector);
		ScoreDoc[] hits = collector.topDocs().scoreDocs;
		
		   
		   List<String> resumeIDs = new LinkedList<>();
		    for(int i=0;i<hits.length;++i) {
		      int docId = hits[i].doc;
		      Document d = searcher.doc(docId);
		      resumeIDs.add(d.get(COLUMN_NICk_NAME));
		    }
		return resumeIDs;
	}
	
	public void indexarAll(List<Resume> resumes) throws IOException {
		IndexWriter indexWriter = LuceneUtil.INSTANCE.getIndexWriter();
		for (Resume resume : resumes) {
			indexWriter.addDocument(indexResume(resume));
		}
		indexWriter.close();
	}
	public void index(Resume resume) throws IOException {
		IndexWriter indexWriter = LuceneUtil.INSTANCE.getIndexWriter();
		indexWriter.addDocument(indexResume(resume));
		indexWriter.close();
	}

	private Document indexResume(Resume resume) {
		Document document = new Document();
		document.add(new TextField(COLUMN_NICk_NAME, resume.getNickName(), Field.Store.YES));
		document.add(new StringField(COLUMN_COUNTRY, resume.getCountry(), Field.Store.NO));
		document.add(new StringField(COLUMN_NAME, resume.getName(), Field.Store.NO));
		document.add(new TextField(COLUMN_RESUME, resume.getBio(), Field.Store.NO));
		return document;
	}
	
}
