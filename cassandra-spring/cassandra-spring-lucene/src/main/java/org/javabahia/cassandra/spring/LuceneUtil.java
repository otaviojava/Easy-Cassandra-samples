package org.javabahia.cassandra.spring;

import java.io.File;
import java.io.IOException;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.IOContext;
import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.util.Version;

public enum LuceneUtil {
INSTANCE;

private Directory directory;
private IndexWriter indexWriter;
private Analyzer analyzer;
public Directory getDirectory() {
	return directory;
}

public Analyzer getAnalyzer() {
	return analyzer;
}

public IndexWriter getIndexWriter() {
	
	IndexWriterConfig indexWriterConfig = new IndexWriterConfig(Version.LUCENE_46, analyzer);

	try {
		indexWriter = new IndexWriter(directory, indexWriterConfig);
	} catch (IOException exception) {
		exception.printStackTrace();
	}
	return indexWriter;
}


{
		analyzer = new StandardAnalyzer(Version.LUCENE_46);
		directory = new RAMDirectory();
		Directory hd = getDirecotoryHD();
		backup(hd, directory);
	
		
}

	private Directory getDirecotoryHD() {
		File file = new File(System.getProperty("user.home").concat("/lucene/music/"));
		if (!file.exists()) {
			file.mkdirs();
		}
		try {
			return FSDirectory.open(file);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

public void backupToHD() {
	Directory hd = getDirecotoryHD();
	backup(directory, hd);
}

	private void backup(Directory deDiretorio, Directory paraDiretoria) {

		try {
			for (String file : deDiretorio.listAll()) {
				deDiretorio.copy(paraDiretoria, file, file, IOContext.DEFAULT);
			}
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
	}
}
