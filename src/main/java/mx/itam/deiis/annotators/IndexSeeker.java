package mx.itam.deiis.annotators;

import java.io.IOException;
import java.util.Iterator;

import mx.itam.deiis.types.IndexFiles;
import mx.itam.deiis.types.Query;
import mx.itam.deiis.utils.FSTool;
import mx.itam.deiis.utils.SearchEngine;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIndex;
import org.apache.uima.jcas.JCas;

public class IndexSeeker extends JCasAnnotator_ImplBase{

	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {
		// Obtain annotations
		// QUERY
		FSIndex queryIdx = aJCas.getAnnotationIndex(Query.type);
		Iterator queryIter = queryIdx.iterator();
		if(!queryIter.hasNext()) {
			System.out.println("Missing Query annotation");
		}
		Query query = (Query)queryIter.next();
		
		// INDEX FILES
		FSIndex indexIdx = aJCas.getAnnotationIndex(IndexFiles.type);
		Iterator indexIter = indexIdx.iterator();
		if(!indexIter.hasNext()) {
			System.out.println("Missing IndexFiles annotation");
		}
		IndexFiles indexFiles = (IndexFiles)indexIter.next();
		
		if(!FSTool.dirExists(indexFiles.getPath())) {
			System.out.println("Error: index path does not exist");
		}
		if(!FSTool.fileExists(query.getVwFile())) {
			System.out.println("Error: query VW file does not exist");
		}
		
		try{
			String queryVW = FSTool.readFileAsStr(query.getVwFile());
			
			SearchEngine goog = new SearchEngine(indexFiles.getPath());
			goog.performSearch(queryVW);
		}
		catch(IOException e) {
			System.out.println("Error: Could not search in the given index");
		} catch (org.apache.lucene.queryparser.classic.ParseException e) {
			System.out.println("Error: Parse error while reading index");
			e.printStackTrace();
		}
		
	}
}
