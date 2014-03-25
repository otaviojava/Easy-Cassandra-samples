package org.javabahia.cassandra.spring.lucene;

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
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopScoreDocCollector;
import org.apache.lucene.util.Version;
import org.javabahia.cassandra.spring.LuceneUtil;
import org.javabahia.cassandra.spring.model.Music;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;


@Service
@Scope("prototype")
public class MusicSearch {

	

	private static final String COLUNM_LYRIC = "lyric";
	private static final String COLUNM_AUTHOR = "Author";
	private static final String COLUMN_NAME = "name";

	public List<String> findMusicByLyric(String lyric) throws ParseException, IOException {
		
		Query query = new QueryParser(Version.LUCENE_46, COLUNM_LYRIC,
				LuceneUtil.INSTANCE.getAnalyzer()).parse(lyric);
		
		return returnMusics(query);
	}
	
	public List<String> findMusicByAuthor(String author) throws ParseException, IOException {
		Term term = new Term(COLUNM_AUTHOR, author);
		Query query = new TermQuery(term);
		return returnMusics(query);
	}

	private List<String> returnMusics(Query query) throws IOException {
		int hitsPerPage = 10;
		IndexReader reader = DirectoryReader.open(LuceneUtil.INSTANCE.getDirectory());
		IndexSearcher searcher = new IndexSearcher(reader);
		TopScoreDocCollector collector = TopScoreDocCollector.create(
				hitsPerPage, true);
		searcher.search(query, collector);
		ScoreDoc[] hits = collector.topDocs().scoreDocs;
		
		   
		   List<String> musics = new LinkedList<>();
		    for(int i=0;i<hits.length;++i) {
		      int docId = hits[i].doc;
		      Document d = searcher.doc(docId);
		      musics.add(d.get(COLUMN_NAME));
		    }
		return musics;
	}
	
	public void indexarAll(List<Music> musicas) throws IOException {
		IndexWriter indexWriter = LuceneUtil.INSTANCE.getIndexWriter();
		for (Music music : musicas) {
			indexWriter.addDocument(indexMusic(music));
		}
		indexWriter.close();
	}
	public void index(Music music) throws IOException {
		IndexWriter indexWriter = LuceneUtil.INSTANCE.getIndexWriter();
		indexWriter.addDocument(indexMusic(music));
		indexWriter.close();
	}

	private Document indexMusic(Music music) {
		Document document = new Document();
		document.add(new TextField(COLUMN_NAME, music.getName(), Field.Store.YES));
		document.add(new StringField(COLUNM_AUTHOR, music.getAuthor(), Field.Store.NO));
		document.add(new TextField(COLUNM_LYRIC, music.getLyric(), Field.Store.NO));
		return document;
	}
	
}
