package mx.itam.deiis.annotators;

import java.util.Iterator;

import mx.itam.deiis.spark.kmeansCreateDictionary;
import mx.itam.deiis.types.DictFiles;
import mx.itam.deiis.types.Dictionary;
import mx.itam.deiis.types.FeatFiles;
import mx.itam.deiis.types.Performance;
//import mx.itam.deiis.utils.FSTool;
import mx.itam.deiis.utils.FSTool;
import mx.itam.deiis.utils.Stopwatch;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIndex;
import org.apache.uima.jcas.JCas;


//public class DictGenerator{
public class DictGenerator extends JCasAnnotator_ImplBase{
	
	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {
		System.gc();
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
		
		Stopwatch stopWatch = new Stopwatch(true);
		int 	k = 500;
		
		String sourceFiles	= FSTool.mergePaths(featPath, "*.sift");
		String outFile		= FSTool.mergePaths(dictPath, "dictionary.txt");
		String objectFile	= FSTool.mergePaths(dictPath, "kmeans_model.obj");

		new kmeansCreateDictionary().createDictionary(k, sourceFiles, outFile, objectFile);
		
		// Crate DICTIONARY annotation
		Dictionary dict=new Dictionary(aJCas);
		dict.setK(k);
		dict.setObj(objectFile);
		dict.setTextFile(outFile);
		dict.addToIndexes();

		stopWatch.Stop();
		System.out.println("====================  Dictionary Generator  =====================");
		System.out.println("Total time taken: "+stopWatch.getTime()+" [s]"+"\n");
		
		// Generate PERFORMANCE annotation
		Performance perf=new Performance(aJCas);
		String annotatorID	= "Dictionary_Generator";
		perf.setPhase(annotatorID);
		perf.setExecTime(stopWatch.getTime());
		perf.addToIndexes();
    }
}