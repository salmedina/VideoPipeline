package mx.itam.deiis.annotators;

import mx.itam.deiis.spark.*;
import mx.itam.deiis.types.*;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;


//public class DictGenerator{
public class DictGenerator extends JCasAnnotator_ImplBase{
	
	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {
		long	startTime = System.currentTimeMillis();
		int k = 60;
		Dictionary dict;
		Performance perf;
		String annotatorID="Dictionary_Generator";
		//Gaby Paths
		String sourceFile = "src/main/resources/data/*.sift";
		String outFile ="src/main/resources/data/dictionary.txt";
		String objectFile = "src/main/resources/data/kmeans_model.obj";

		/*	
		//Zal Paths
		String sourceFile = "src\\main\\resources\\data\\*.sift";
		String outFile ="src\\main\\resources\\data\\dictionary.txt";
		String objectFile = "src\\main\\resources\\data\\kmeans_model.obj";
		 */
		
		new kmeansCreateDictionary().createDictionary(k, sourceFile, outFile, objectFile);
		dict=new Dictionary(aJCas);
		perf=new Performance(aJCas);
		//dict.setBegin();
		//dict.setEnd();
		dict.setK(k);
		dict.setObj(objectFile);
		dict.setTextFile(outFile);
		dict.addToIndexes();

		long endTime=System.currentTimeMillis();
		double totalTime=(endTime-startTime)/1000.0;
		System.out.println("====================  Dictionary Generator  =====================");
		System.out.println("Total time taken: "+totalTime+" segs"+"\n");
		
		perf.setPhase(annotatorID);
		perf.setExecTime(totalTime);
		perf.addToIndexes();
    }
}