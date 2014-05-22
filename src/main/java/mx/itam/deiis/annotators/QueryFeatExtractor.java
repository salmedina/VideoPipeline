package mx.itam.deiis.annotators;

import java.util.Iterator;

import mx.itam.deiis.types.Performance;
import mx.itam.deiis.types.Query;
import mx.itam.deiis.types.SourceFiles;
import mx.itam.deiis.utils.FSTool;
import mx.itam.deiis.utils.SIFTTool;
import mx.itam.deiis.utils.Stopwatch;

import org.apache.commons.io.FilenameUtils;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIndex;
import org.apache.uima.jcas.JCas;

public class QueryFeatExtractor extends JCasAnnotator_ImplBase {
	
	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {
		// Obtain annotations
		// QUERY - load and verify
		FSIndex queryIdx = aJCas.getAnnotationIndex(Query.type);
		Iterator queryIter = queryIdx.iterator();
		if(!queryIter.hasNext()) {
			System.out.println("Missing Query annotation");
		}
		Query query = (Query)queryIter.next();
		
		String imgFile = query.getImgFile();
		if(!FSTool.fileExists(imgFile)) {
			System.out.println("Missing query file");
		}
		
		Stopwatch stopWatch = new Stopwatch(true);
		
		//Extract features
		String featFile = FilenameUtils.removeExtension(imgFile) + ".sift";
		SIFTTool imgTool = new SIFTTool();
		imgTool.extractFeatsToFile(imgFile, featFile);
		System.out.printf("Feat extracted from: %s", imgFile);
		
		query.setFeatFile(featFile);
		
		stopWatch.Stop();
		System.out.println("====================  Feat Extractor  =====================");
		System.out.println("Total time taken: "+stopWatch.getTime()+" segs"+"\n");
		
		// Generate PERFORMANCE annotation
		Performance perf=new Performance(aJCas);
		String annotatorID	= "Query_Feature_Extractor";
		perf.setPhase(annotatorID);
		perf.setExecTime(stopWatch.getTime());
		perf.addToIndexes();
	}

}
