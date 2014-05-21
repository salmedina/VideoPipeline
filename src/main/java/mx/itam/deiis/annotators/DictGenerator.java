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

//public class DictGenerator{
public class DictGenerator extends JCasAnnotator_ImplBase{
	
	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {
		int k = 60;
		String sourceFile = "src\\main\\resources\\data\\example.sift";
		String outFile ="src\\main\\resources\\data\\out.txt";
		String objectFile = "src\\main\\resources\\data\\kmeans_model.obj";

		new kmeansCreateDictionary().createDictionary(k, sourceFile, outFile, objectFile);
    }
}