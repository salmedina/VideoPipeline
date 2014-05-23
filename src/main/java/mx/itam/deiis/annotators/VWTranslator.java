package mx.itam.deiis.annotators;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import mx.itam.deiis.spark.visualWordsTranslator;
import mx.itam.deiis.types.Dictionary;
import mx.itam.deiis.types.FeatFiles;
import mx.itam.deiis.types.Performance;
import mx.itam.deiis.types.VWFiles;
import mx.itam.deiis.utils.FSTool;
import mx.itam.deiis.utils.Stopwatch;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIndex;
import org.apache.uima.jcas.JCas;

import org.apache.commons.lang.StringUtils;

public class VWTranslator extends JCasAnnotator_ImplBase{
	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {
		System.gc();
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
		String vwPath		= vwFiles.getPath();
		String objectFile	= dictionary.getObj();
		String siftExt 		= ".sift";
		String vwExt		= ".vw";
		
		if(!FSTool.dirExists(featPath)) {
			System.out.println("Features' directory does not exist.");
		}
		if(!FSTool.dirExists(vwPath)) {
			System.out.println("VW directory does not exist.");
		}
		
		//Start taking record of time for performance
		Stopwatch stopWatch = new Stopwatch(true);

		List<String> siftList = new ArrayList<String>();
		siftList = FSTool.getFilesByExt(featPath, siftExt);
		String siftListStr = StringUtils.join(siftList, ",");
		System.out.printf("SIFT FILES: %d\n", siftList.size());
		System.out.println(siftListStr);
		
		visualWordsTranslator translator = new visualWordsTranslator(); 	
		translator.getVW(siftListStr, objectFile, vwPath);
		translator.close();
		
		String successFileStr = FSTool.mergePaths(vwPath, "_SUCCESS");
		if(FSTool.fileExists(successFileStr)) {
			ProcessSparkVW(siftList, featPath, vwPath);
			File successFile = new File(successFileStr);
			successFile.delete();
		}
		else {
			System.out.println("SPARK FAILURE! Could not build vw files");
		}
		
		
		//Check out execution time
		stopWatch.Stop();
		System.out.println("====================  Visual Words Tranlator  =====================");
		System.out.println("Total time taken: "+stopWatch.getTime()+" [s]"+"\n");
		System.out.println(siftListStr);
		
		// Generate PERFORMANCE annotation
		String annotatorID="Visual_Words_Translator";
		Performance perf = new Performance(aJCas);
		perf.setPhase(annotatorID);
		perf.setExecTime(stopWatch.getTime());
		perf.addToIndexes();
    }

	private void ProcessSparkVW(List<String> siftList, 
								String featPath,
								String vwPath) {
		int pos = 0;
		featPath += File.separator;
		for( String siftFile : siftList ) {
			//Rename the file
			String sparkVWFile = String.format("part-%05d", pos);
			String vwFileName = siftFile.replace(featPath, "").replace(".sift", ".vw");
			File newFile = new File(FSTool.mergePaths(vwPath, vwFileName));
			String sparkFileStr = FSTool.mergePaths(vwPath, sparkVWFile);
			File sparkFile = new File(sparkFileStr);
			
			// Replace newLines with spaces
			String contentStr = FSTool.readFileAsStr(sparkFileStr);
			contentStr = contentStr.replace("\n", " ");
			
			if(!FSTool.printStrToFile(newFile, contentStr)) {
				System.out.printf("Error saving %s", sparkFileStr);
			}
			sparkFile.delete();
			
			pos += 1;
		}
	}
}