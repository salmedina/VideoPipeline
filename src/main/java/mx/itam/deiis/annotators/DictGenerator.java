package mx.itam.deiis.annotators;

import java.util.Iterator;

import mx.itam.deiis.spark.*;
import mx.itam.deiis.types.*;
import mx.itam.deiis.utils.FSTool;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIndex;
import org.apache.uima.jcas.JCas;


//public class DictGenerator{
public class DictGenerator extends JCasAnnotator_ImplBase{
	
	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {
		//Obtain input annotators
		// FEAT FILES - load and verify
		FSIndex featIdx = aJCas.getAnnotationIndex(FeatFiles.type);
		Iterator featIter = featIdx.iterator();
		if(!featIter.hasNext()) {
			System.out.println("Missing feature files annotation");
		}
		FeatFiles featFiles = (FeatFiles)featIter.next();
		
		// DICT FILES - load and verify
		FSIndex dictIdx = aJCas.getAnnotationIndex(DictFiles.type);
		Iterator dictIter = dictIdx.iterator();
		if(!dictIter.hasNext()) {
			System.out.println("Missing dictionary files annotation");
		}
		DictFiles dictFiles = (DictFiles)dictIter.next();
		
		//Verify paths
		String featPath = featFiles.getPath();
		String dictPath = dictFiles.getPath();
		if(!FSTool.dirExists(dictPath)) {
			System.out.println("Dictionary directory does not exist.");
		}
		if(!FSTool.dirExists(featPath)) {
			System.out.println("Features' directory does not exist.");
		}
		
		long	startTime = System.currentTimeMillis();
		int 	k = 60;
		
		String annotatorID	= "Dictionary_Generator";
		String sourceFiles	= featPath + "\\*.sift";
		String outFile		= dictPath + "\\dictionary.txt";
		String objectFile	= dictPath + "\\kmeans_model.obj";

		new kmeansCreateDictionary().createDictionary(k, sourceFiles, outFile, objectFile);
		
		// Crate DICTIONARY annotation
		Dictionary dict=new Dictionary(aJCas);
		dict.setK(k);
		dict.setObj(objectFile);
		dict.setTextFile(outFile);
		dict.addToIndexes();

		long endTime=System.currentTimeMillis();
		double totalTime=(endTime-startTime)/1000.0;
		System.out.println("====================  Dictionary Generator  =====================");
		System.out.println("Total time taken: "+totalTime+" segs"+"\n");
		
		// Generate PERFORMANCE annotation
		Performance perf=new Performance(aJCas);
		perf.setPhase(annotatorID);
		perf.setExecTime(totalTime);
		perf.addToIndexes();
    }
}