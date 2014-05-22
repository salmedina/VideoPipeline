package mx.itam.deiis.annotators;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import mx.itam.deiis.types.*;
import mx.itam.deiis.utils.FSTool;
import mx.itam.deiis.utils.SIFTTool;
import mx.itam.deiis.utils.Stopwatch;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIndex;
import org.apache.uima.jcas.JCas;
import org.opencv.core.Core;

public class FeatExtractor extends JCasAnnotator_ImplBase{
	
	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {
		// Obtain annotators
		// SOURCE FILES - load and verify
		FSIndex sourceIdx = aJCas.getAnnotationIndex(SourceFiles.type);
		Iterator sourceIter = sourceIdx.iterator();
		if(!sourceIter.hasNext()) {
			System.out.println("Missing source files annotation");
		}
		SourceFiles sourceFiles = (SourceFiles)sourceIter.next();
		
		// FEATURE FILES - load and verify
		FSIndex featIdx = aJCas.getAnnotationIndex(FeatFiles.type);
		Iterator featIter = featIdx.iterator();
		if(!featIter.hasNext()) {
			System.out.println("Missing feature files annotation");
		}
		FeatFiles featFiles = (FeatFiles)featIter.next();
		
		//Verify that paths exist
		FSTool fsTool = new FSTool();
		Stopwatch stopWatch = new Stopwatch(true);
		
		String sourceExt = sourceFiles.getExt();
		String sourcePath = sourceFiles.getPath();
		String featPath = featFiles.getPath();
		
		if(!fsTool.dirExists(sourcePath)) {
			System.out.println("Source directory does not exist.");
		}
		if(!fsTool.dirExists(featPath)) {
			System.out.println("Features' directory does not exist.");
		}
		
		//Obtain the list of files from source path
		List<String> sourceList = fsTool.getFilesByExt(sourcePath, sourceExt);
		
		/*
		//Extract their features and save them in the feature path
		SIFTTool imgTool = new SIFTTool();
		String featFile = "";
		for( String source : sourceList) {
			featFile = source.replace(sourcePath, featPath);
			featFile = featFile.replace(sourceExt, ".sift");
			imgTool.extractFeatsToFile(source, featFile);
			System.out.printf("Feat extracted from: %s\n", source);
		}
		*/
		
		// PARALLELIZE EXTRACTION		
		ExecutorService exec = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() - 1);
		//Auxiliary class
		class OneShot implements Runnable{
            String Source;
            String SourcePath;
            String FeatPath;
            String SourceExt;
            public OneShot(String source, String sourcePath, String featPath, String sourceExt) {
            	Source		= source;
            	SourcePath	= sourcePath;
            	FeatPath	= featPath;
            	SourceExt	= sourceExt;
            }
        	@Override
            public void run() {
        		
        		String featFile = Source.replace(SourcePath, FeatPath);
        		featFile = featFile.replace(SourceExt, ".sift");
        		if(!FSTool.fileExists(featFile)) {
	        		SIFTTool imgTool = new SIFTTool();
	        		imgTool.extractFeatsToFile(Source, featFile);
	    			System.out.printf("Feat extracted from: %s\n", Source);
        		} else {
        			System.out.printf("Feat already exists: %s\n", Source);
        		}
            }
        }
		try {
		    for (final String source : sourceList) {
		        exec.submit(new OneShot(source, sourcePath, featPath, sourceExt) );
		    }
		} finally {
		    exec.shutdown();
		}
		
		//Await for all threads to finish
		try {
		  exec.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
		} catch (InterruptedException e) {
			System.out.println("PARALLEL ERROR! Feat extractors timedout");
		}
		
		
		stopWatch.Stop();
		System.out.println("====================  Feat Extractor  =====================");
		System.out.println("Total time taken: "+stopWatch.getTime()+" segs"+"\n");
		
		// Generate PERFORMANCE annotation
		Performance perf=new Performance(aJCas);
		String annotatorID	= "Feature_Extractor";
		perf.setPhase(annotatorID);
		perf.setExecTime(stopWatch.getTime());
		perf.addToIndexes();
	}
}
