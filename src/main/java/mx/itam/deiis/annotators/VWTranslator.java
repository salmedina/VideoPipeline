package mx.itam.deiis.annotators;

import mx.itam.deiis.spark.*;
import mx.itam.deiis.types.*;

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
import org.apache.uima.jcas.JCas;

public class VWTranslator extends JCasAnnotator_ImplBase{
	
	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {
		long	startTime = System.currentTimeMillis();
		Performance perf;
		VWFiles vws;
		String annotatorID="Visual_Words_Translator";
		
		//Gaby paths
		String sourceFile = "src/main/resources/data/*.sift";
		String objectFile ="src/main/resources/data/kmeans_model.obj";
		String outFile = "src/main/resources/data/vw";

		/*
		//Zal paths
		String sourceFile = "src\\main\\resources\\data\\testeg.sift";
		String objectFile ="src\\main\\resources\\data\\kmeans_model.obj";
		String outFile = "src\\main\\resources\\data\\vw";
		*/

		visualWordsTranslator translator = new visualWordsTranslator();
		translator.getVW(sourceFile, objectFile, outFile);
		
		vws = new VWFiles(aJCas);
		//vws.setBegin();
		//vws.setEnd();
		vws.setPath(outFile);
		vws.addToIndexes();
		long endTime=System.currentTimeMillis();
		double totalTime=(endTime-startTime)/1000.0;
		System.out.println("====================  Visual Words Tranlator  =====================");
		System.out.println("Total time taken: "+totalTime+" segs"+"\n");
		
		perf=new Performance(aJCas);
		perf.setPhase(annotatorID);
		perf.setExecTime(totalTime);
		perf.addToIndexes();

    }

}