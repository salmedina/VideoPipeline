package mx.itam.deiis.annotators;

import java.util.Iterator;

import mx.itam.deiis.spark.*;
import mx.itam.deiis.types.*;
import mx.itam.deiis.utils.FSTool;
import mx.itam.deiis.utils.Stopwatch;

/**
 * 
 * calling a class:
 * new kmeans(50,"data/example.sift");
 * object:
 * kmeans_spark$.MODULE$.callAll(50,"data/example.sift");
 *
 */

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIndex;
import org.apache.uima.jcas.JCas;

public class VWTranslator extends JCasAnnotator_ImplBase{
	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {
		//Obtain input annotators
		// FEAT FILES - load and verify
		FSIndex featIdx = aJCas.getAnnotationIndex(FeatFiles.type);
		Iterator featIter = featIdx.iterator();
		if(!featIter.hasNext()) {
			System.out.println("Missing dictionary files annotation");
		}
		FeatFiles featFiles = (FeatFiles)featIter.next();
		
		// VWFILES - load and verify
		FSIndex vwIdx = aJCas.getAnnotationIndex(VWFiles.type);
		Iterator vwIter = vwIdx.iterator();
		if(!vwIter.hasNext()) {
			System.out.println("Missing visual words files annotation");
		}
		VWFiles vwFiles = (VWFiles)vwIter.next();
		
		// DICT FILES - load and verify
		FSIndex dictIdx = aJCas.getAnnotationIndex(Dictionary.type);
		Iterator dictIter = dictIdx.iterator();
		if(!dictIter.hasNext()) {
			System.out.println("Missing dictionary files annotation");
		}
		Dictionary dictionary = (Dictionary)dictIter.next();
		
		//Verify paths
		String featPath		= featFiles.getPath();
		String sourceFile	= featPath + "\\*.sift";
		String objectFile	= dictionary.getObj();
		String outFile		= vwFiles.getPath();
		if(!FSTool.dirExists(featPath)) {
			System.out.println("Features' directory does not exist.");
		}
		if(!FSTool.dirExists(outFile)) {
			System.out.println("VW directory does not exist.");
		}
		
		//Start taking record of time for performance
		Stopwatch stopWatch = new Stopwatch(true);

		visualWordsTranslator translator = new visualWordsTranslator();
		translator.getVW(sourceFile, objectFile, outFile);
		
		// Generate VWFILES annotation
		VWFiles vws;
		vws = new VWFiles(aJCas);
		vws.setPath(outFile);
		vws.addToIndexes();
		
		//Check out execution time
		stopWatch.Stop();
		System.out.println("====================  Visual Words Tranlator  =====================");
		System.out.println("Total time taken: "+stopWatch.getTime()+" [s]"+"\n");
		
		// Generate PERFORMANCE annotation
		String annotatorID="Visual_Words_Translator";
		Performance perf = new Performance(aJCas);
		perf.setPhase(annotatorID);
		perf.setExecTime(stopWatch.getTime());
		perf.addToIndexes();
    }
}