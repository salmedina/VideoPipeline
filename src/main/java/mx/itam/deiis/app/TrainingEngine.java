package mx.itam.deiis.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.URL;

import mx.itam.deiis.utils.FSTool;

import org.apache.uima.UIMAFramework;
import org.apache.uima.analysis_engine.AnalysisEngine;
import org.apache.uima.analysis_engine.AnalysisEngineDescription;
import org.apache.uima.cas.CAS;
import org.apache.uima.util.XMLInputSource;
import org.opencv.core.Core;

public class TrainingEngine {

	public static void main(String [] args) throws Exception {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);	//Required for OpenCV to work
		
		String	sLine;
		long	startTime = System.currentTimeMillis();

		//Load AAE descriptor file
		URL descUrl = TrainingEngine.class.getResource("/analysis-engines/trainEngine.xml");
	    if (descUrl == null) {
	      throw new IllegalArgumentException("Error opening /analysis-engines/trainEngine.xml");
	    }
		// create AnalysisEngine		
		XMLInputSource input = new XMLInputSource(descUrl);
		AnalysisEngineDescription desc = UIMAFramework.getXMLParser().parseAnalysisEngineDescription(input);
		AnalysisEngine anAnalysisEngine = UIMAFramework.produceAnalysisEngine(desc);
		CAS aCas = anAnalysisEngine.newCAS();

	    sLine = FSTool.readAllFile("E:\\VPSpace\\Configurations\\config.yaml");
		//sLine =FSTool.readAllFile("/resources/config.yaml");
	    //Feed AAE line by line
		//BufferedReader br = new BufferedReader(new InputStreamReader(docUrl.openStream()));
		//while ((sLine = br.readLine()) != null)   {
			aCas.setDocumentText(sLine);
			anAnalysisEngine.process(aCas);
			aCas.reset();
		//}
		//Clean up
		//br.close();
		//br=null;
		anAnalysisEngine.collectionProcessComplete();
		anAnalysisEngine.destroy();	
		long endTime=System.currentTimeMillis();

		//Print out the whole execution time
		double totalTime=(endTime-startTime)/1000.0;
		System.out.println("Total time taken: "+totalTime);
	} //end main()
}
