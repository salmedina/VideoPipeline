package mx.itam.deiis.annotators;

import java.io.IOException;
import java.util.Iterator;

import mx.itam.deiis.types.IndexFiles;
import mx.itam.deiis.types.Performance;
import mx.itam.deiis.types.SourceFiles;
import mx.itam.deiis.types.VWFiles;
import mx.itam.deiis.utils.Indexer;
import mx.itam.deiis.utils.FSTool;
import mx.itam.deiis.utils.Stopwatch;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIndex;
import org.apache.uima.jcas.JCas;

public class IndexGenerator extends JCasAnnotator_ImplBase{
	
	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {
		// Obtain annotators
		// INDEX FILES - load and verify
		FSIndex indexIdx = aJCas.getAnnotationIndex(IndexFiles.type);
		Iterator indexIter = indexIdx.iterator();
		if(!indexIter.hasNext()) {
			System.out.println("Missing index files annotation");
		}
		IndexFiles indexFiles = (IndexFiles)indexIter.next();
		
		// VW FILES - load and verify
		FSIndex vwIdx = aJCas.getAnnotationIndex(VWFiles.type);
		Iterator vwIter = vwIdx.iterator();
		if(!vwIter.hasNext()) {
			System.out.println("Missing VW files annotation");
		}
		VWFiles vwFiles = (VWFiles)vwIter.next();
		
		// VALIDATE existence of paths
		String indexPath = indexFiles.getPath();
		String vwPath = vwFiles.getPath();
		if(!FSTool.dirExists(indexPath)) {
			System.out.println("Index directory does not exist.");
		}
		if(!FSTool.dirExists(vwPath)) {
			System.out.println("VW directory does not exist.");
		}
		Stopwatch stopWatch = new Stopwatch(true);
		
		//Generate Index from paths
		Indexer indexGen = new Indexer(indexPath);
		
		try {
			indexGen.buildIndex(vwPath, ".vw");
		} catch( IOException e) {
			System.out.println("ERROR: IOException thrown while buiding index");
			System.out.println(e.toString());
		}
		
		stopWatch.Stop();
		System.out.println("====================  Index Generator  =====================");
		System.out.println("Total time taken: "+stopWatch.getTime()+" [s]"+"\n");
		
		// Generate PERFORMANCE annotation
		Performance perf=new Performance(aJCas);
		String annotatorID	= "Index_Generator";
		perf.setPhase(annotatorID);
		perf.setExecTime(stopWatch.getTime());
		perf.addToIndexes();
	}
}
