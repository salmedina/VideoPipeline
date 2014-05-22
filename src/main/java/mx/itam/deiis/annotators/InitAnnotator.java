package mx.itam.deiis.annotators;

import java.util.HashMap;
import java.util.Map;

import mx.itam.deiis.types.*;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.yaml.snakeyaml.Yaml;

public class InitAnnotator extends JCasAnnotator_ImplBase{
	
	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {
		String configStr = aJCas.getDocumentText();
		if(configStr.isEmpty()) {
			System.out.println("Configuration files is empty.");
		}
		
		//Load map from YAML file
		Yaml configYaml = new Yaml();
		Map configMap = (HashMap<String, String>)configYaml.load(configStr);
		
		if(!VerifyConfigMap(configMap)) {
			System.out.println("Invalid config file.");
		}
		
		//Load values and build initial annotations
		// EXPERIMENT
		Experiment experiment = new Experiment(aJCas);
		experiment.setId(
				Integer.parseInt(configMap.get("experiment-id").toString()));
		experiment.setPath(configMap.get("experiment-path").toString());
		experiment.addToIndexes();
		
		// SOURCE FILES
		SourceFiles sourceFiles = new SourceFiles(aJCas);
		sourceFiles.setPath(configMap.get("source-path").toString());
		sourceFiles.setExt(configMap.get("img-file-ext").toString());
		sourceFiles.addToIndexes();
		
		// FEAT FILES
		FeatFiles featFiles = new FeatFiles(aJCas);
		featFiles.setPath(configMap.get("feat-path").toString());
		featFiles.addToIndexes();
		
		// DICT PATH
		DictFiles dictFiles= new DictFiles(aJCas);
		dictFiles.setPath(configMap.get("dict-path").toString());
		dictFiles.addToIndexes();
		
		//VW FILES
		VWFiles vwFiles = new VWFiles(aJCas);
		vwFiles.setPath(configMap.get("vw-path").toString());
		vwFiles.addToIndexes();
		
		// INDEX FILES
		IndexFiles indexFiles = new IndexFiles(aJCas);
		indexFiles.setPath(configMap.get("index-path").toString());
		indexFiles.addToIndexes();
		
		// TRAINING PERFORMANCE
		EngineResult result = new EngineResult(aJCas);
		result.setFile(configMap.get("result-file").toString());
		result.addToIndexes();
		
		TrainingRes performance = new TrainingRes(aJCas);
		performance.setPerformanceFile(configMap.get("performance-file").toString());
		performance.addToIndexes();
	
	}
	
	private boolean VerifyConfigMap(Map configMap) {
		boolean result = true;
		
		String fields[] = {"experiment-id", "experiment-path", 
				"source-path", "feat-path", "img-file-ext", 
				"dict-path","vw-path", "index-path", "result-file","performance-file"};
		
		for(String field : fields) {
			if(configMap.get(field) == null) {
				System.out.printf("Missing %s in config file\n", field);
				result = false;
			}
		}
				
		return result;
	} 
}
