package mx.itam.deiis.annotators;

import java.util.ArrayList;

import mx.itam.deiis.types.Performance;
import mx.itam.deiis.types.TrainingPerformance;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.cas.text.AnnotationIndex;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;

public class PerformanceResultsAnnotator extends JCasAnnotator_ImplBase{

	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {
		AnnotationIndex<Annotation> annot_perf = aJCas.getAnnotationIndex(Performance.type);
		FSIterator<Annotation> iterate_perfs = annot_perf.iterator();
		ArrayList<Performance> perfs = new ArrayList<Performance>();
		Performance ptemp = null;
		int count=0;
		TrainingPerformance tperf = new TrainingPerformance(aJCas);

		System.out.println("=================== PERFORMANCE EVALUATION ======================");

		//iterate over CASs to get performance
		while(iterate_perfs.hasNext()) {
			ptemp = (Performance)iterate_perfs.next();
			perfs.add(ptemp);
			count++;
		}

		for(int i=0; i<count; i++){
			String annotatorID = perfs.get(i).getPhase();

			switch(annotatorID){
			case "Feature_Extractor":
				tperf.setFeatExtract(perfs.get(i));
				System.out.printf("Feature Extractor execTime: %.3f segs \n",perfs.get(i).getExecTime());
				break;

			case "Dictionary_Generator":
				tperf.setDictGen(perfs.get(i));
				System.out.printf("Dictionary Generator execTime: %.3f segs \n",perfs.get(i).getExecTime());
				break;

			case "Visual_Words_Translator":
				tperf.setVwTranslation(perfs.get(i));
				System.out.printf("Visual Words Translator execTime: %.3f segs \n",perfs.get(i).getExecTime());
				break;

			case "Index_Generator":
				tperf.setIndexGen(perfs.get(i));
				System.out.printf("Index Generator execTime: %.3f segs \n",perfs.get(i).getExecTime());
				break;

			default:
				System.out.println("Unidentified phase in pipeline. Please verify!");
			}
		}

		tperf.addToIndexes();
		System.out.println("==================================================================");

	}
}
