package mx.itam.deiis.annotators;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;

import mx.itam.deiis.types.DictFiles;
import mx.itam.deiis.types.Dictionary;
import mx.itam.deiis.types.IndexFiles;
import mx.itam.deiis.types.Performance;
import mx.itam.deiis.types.TrainingPerformance;
import mx.itam.deiis.types.TrainingRes;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIndex;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.cas.text.AnnotationIndex;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;

public class PerformanceResultsAnnotator extends JCasAnnotator_ImplBase{

	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {
		System.out.println("====================  Performance Results  =====================");
		
		///Obtain input annotators
		// RES FILES - load and verify
		FSIndex resIdx = aJCas.getAnnotationIndex(TrainingRes.type);
		Iterator resIter = resIdx.iterator();
		if(!resIter.hasNext()) {
			System.out.println("Missing result files annotation");
		}
		TrainingRes res = (TrainingRes)resIter.next();

		///Obtain input annotators
		// DICTIONARY - load and verify
		FSIndex dictIdx = aJCas.getAnnotationIndex(Dictionary.type);
		Iterator dictIter = dictIdx.iterator();
		if(!dictIter.hasNext()) {
			System.out.println("Missing dictionary object files annotation");
		}
		Dictionary dictionary = (Dictionary)dictIter.next();

		// DICT FILES - load and verify
		FSIndex dictIdxP = aJCas.getAnnotationIndex(DictFiles.type);
		Iterator dictIterP = dictIdxP.iterator();
		if(!dictIterP.hasNext()) {
			System.out.println("Missing dictionary files annotation");
		}
		DictFiles dictFiles = (DictFiles)dictIter.next();

		// INDEX FILES - load and verify
		FSIndex indexIdx = aJCas.getAnnotationIndex(IndexFiles.type);
		Iterator indexIter = indexIdx.iterator();
		if(!indexIter.hasNext()) {
			System.out.println("Missing index files annotation");
		}
		IndexFiles indFiles = (IndexFiles)indexIter.next();
		
		// Training Performance FILES - load and verify
		FSIndex trainIdx = aJCas.getAnnotationIndex(TrainingRes.type);
		Iterator trainIter = trainIdx.iterator();
		if(!trainIter.hasNext()) {
			System.out.println("Missing performance path files annotation");
		}
		TrainingRes trainFiles = (TrainingRes)indexIter.next();


		//Verify paths
		String objectFile		= dictionary.getObj();
		String dictPath 		= dictFiles.getPath();
		String indexPath 		= indFiles.getPath();
		String trainEngfile 	= res.getFile();
		String performanceFile	= trainFiles.getPerformanceFile();
		try{
			FileWriter writer = new FileWriter((trainEngfile));
			BufferedWriter bw = new BufferedWriter(writer);
			bw.write("#Config file for train engine results");
			bw.write("dict-path: "+objectFile);
			bw.write("dict-obj: "+ dictPath);
			bw.write("index-path: "+indexPath);
			bw.close();

		}catch(Exception e){
			System.out.println("ERROR while printing engine results config file.");
		}


		System.out.println("=================== PERFORMANCE EVALUATION ======================");
		
		TrainingPerformance tperf = new TrainingPerformance(aJCas);
		FSIndex perfIdx = aJCas.getAnnotationIndex(Performance.type);
		Iterator perfIter = perfIdx.iterator();
		
		//iterate over CASs to get performance
		ArrayList<Performance> perfs = new ArrayList<Performance>();
		Performance ptemp = null;
		int count=0;
		while(perfIter.hasNext()) {
			ptemp = (Performance)perfIter.next();
			perfs.add(ptemp);
			count++;
		}
		
		try{

		FileWriter writer = new FileWriter((performanceFile));
		BufferedWriter bwP = new BufferedWriter(writer);
		bwP.write("Performance results for training pipeline.");

		
		for(int i=0; i<count; i++){
			String annotatorID = perfs.get(i).getPhase();

			switch(annotatorID){
			case "Feature_Extractor":
				tperf.setFeatExtract(perfs.get(i));
				System.out.printf("Feature Extractor execTime: %.3f [s] \n",perfs.get(i).getExecTime());
				bwP.write("Feature_Extractor: "+perfs.get(i).toString());
				bwP.write("\n");
				break;

			case "Dictionary_Generator":
				tperf.setDictGen(perfs.get(i));
				System.out.printf("Dictionary Generator execTime: %.3f [s] \n",perfs.get(i).getExecTime());
				bwP.write("Dictionary_Generator: "+perfs.get(i).toString());
				bwP.write("\n");				
				break;

			case "Visual_Words_Translator":
				tperf.setVwTranslation(perfs.get(i));
				System.out.printf("Visual Words Translator execTime: %.3f [s] \n",perfs.get(i).getExecTime());
				bwP.write("Visual_Words_Translator: "+perfs.get(i).toString());
				bwP.write("\n");
				break;

			case "Index_Generator":
				tperf.setIndexGen(perfs.get(i));
				System.out.printf("Index Generator execTime: %.3f [s] \n",perfs.get(i).getExecTime());
				bwP.write("Index_Generator: "+perfs.get(i).toString());
				bwP.write("\n");
				break;

			default:
				System.out.println("Unidentified phase in pipeline. Please verify!");
			}
			bwP.close();
		}
		}catch(Exception e){
			System.out.println("Unable to write performance file!");
		}

		tperf.addToIndexes();
		System.out.println("==================================================================");

	}
}
