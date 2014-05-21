package mx.itam.deiis.utils;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.core.WhitespaceAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SearchEngine {
  private String mIndexPath = null;
  private IndexSearcher searcher = null;
  private QueryParser parser = null;
  static int HITS_PER_PAGE = 10;
  static String SEARCH_FIELD = "content";

  /** Creates a new instance of SearchEngine */
  public SearchEngine(String indexPath) throws IOException {
	  IndexReader reader = DirectoryReader.open(FSDirectory.open(new File(indexPath)));
	  searcher = new IndexSearcher(reader);
	  Analyzer whiteSpaceAnalyzer = new WhitespaceAnalyzer(Version.LUCENE_47);
	  parser = new QueryParser(Version.LUCENE_47, SEARCH_FIELD, whiteSpaceAnalyzer);
  }

  public int performSearch(String queryString) 
  throws IOException, ParseException {
    Query query = parser.parse(queryString);
    TopDocs results = searcher.search(query, 5 * HITS_PER_PAGE);
    ScoreDoc[] hits = results.scoreDocs;
    
    int numTotalHits = results.totalHits;
    System.out.println(numTotalHits + " total matching images");
    
    int start = 0;
    int end = Math.min(numTotalHits, HITS_PER_PAGE);
    
    for(ScoreDoc hit : hits) {
    	Document hitDoc = searcher.doc(hit.doc);
    	System.out.println("doc = "+hitDoc.get("path")+"  score = "+hit.score);
    }
    
    return end;
  }
}
