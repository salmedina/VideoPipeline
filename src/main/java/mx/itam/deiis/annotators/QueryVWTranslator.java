package mx.itam.deiis.annotators;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import mx.itam.deiis.spark.visualWordsTranslator;
import mx.itam.deiis.types.Dictionary;
import mx.itam.deiis.types.Performance;
import mx.itam.deiis.types.Query;
import mx.itam.deiis.utils.FSTool;
import mx.itam.deiis.utils.Stopwatch;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIndex;
import org.apache.uima.jcas.JCas;

public class QueryVWTranslator extends JCasAnnotator_ImplBase {
	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {
		// Load and verify the annotations
		// QUERY
		FSIndex queryIdx = aJCas.getAnnotationIndex(Query.type);
		Iterator queryIter = queryIdx.iterator();
		if(!queryIter.hasNext()) {
			System.out.println("Missing Query annotation");
		}
		Query query = (Query)queryIter.next();
		
		// DICT FILES
		FSIndex dictIdx = aJCas.getAnnotationIndex(Dictionary.type);
		Iterator dictIter = dictIdx.iterator();
		if(!dictIter.hasNext()) {
			System.out.println("Missing dictionary files annotation");
		}
		Dictionary dictionary = (Dictionary)dictIter.next();
		
		String siftFile	= query.getFeatFile();
		String dictObj	= dictionary.getObj();
		String vwPath	= FilenameUtils.getFullPath(siftFile) + FilenameUtils.getBaseName(siftFile) + "VW";
		String vwFileStr= FilenameUtils.removeExtension(query.getImgFile()) + ".vw";
		
		Stopwatch stopWatch = new Stopwatch(true);
		
		//Translate through SPARK
		visualWordsTranslator translator = new visualWordsTranslator(); 	
		translator.getVW(siftFile, dictObj, vwPath);
		translator.close();
		
		//Extract info and save to file
		String sparkFile1 = FSTool.mergePaths(vwPath, "part-00000");
		String sparkFile2 = FSTool.mergePaths(vwPath, "part-00001");
		String contentStr = "";
		if(FSTool.fileExists(sparkFile1)) {
			contentStr += FSTool.readFileAsStr(sparkFile1).replace("\n", " ");
		}
		if(FSTool.fileExists(sparkFile2)) {
			contentStr += FSTool.readFileAsStr(sparkFile2).replace("\n", " ");
		}
		
		File vwFile = new File(vwFileStr);
		if(!FSTool.printStrToFile(vwFile, contentStr)) {
			System.out.printf("Error saving %s", vwFileStr);
		}
		
		try {
			FileUtils.deleteDirectory(new File(vwPath));
		} catch (IOException e) {
			System.out.printf("Error while trying to delete dir: %s\n", vwPath);
			e.printStackTrace();
		}
		//Save annotation
		query.setVwFile(vwFileStr);
		
		stopWatch.Stop();
		System.out.println("====================  VW TRANSLATOR =====================");
		System.out.println("Total time taken: "+stopWatch.getTime()+" segs"+"\n");
		
		// Generate PERFORMANCE annotation
		Performance perf=new Performance(aJCas);
		String annotatorID	= "Query_Feature_Extractor";
		perf.setPhase(annotatorID);
		perf.setExecTime(stopWatch.getTime());
		perf.addToIndexes();
	}
}
