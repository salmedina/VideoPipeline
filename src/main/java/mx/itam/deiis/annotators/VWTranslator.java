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
		String sourceFile = "src\\main\\resources\\data\\testeg.sift";
		String objectFile ="src\\main\\resources\\data\\kmeans_model.obj";
		String outFile = "src\\main\\resources\\data\\vw";

		visualWordsTranslator translator = new visualWordsTranslator();
		translator.getVW(sourceFile, objectFile, outFile);
    }

}