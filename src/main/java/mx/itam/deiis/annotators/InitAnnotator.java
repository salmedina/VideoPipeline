package mx.itam.deiis.annotators;

import java.util.HashMap;
import java.util.Map;

import mx.itam.deiis.types.*;
import mx.itam.deiis.utils.FSTool;

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
		String experimentPath;
		String featPath;
		String dictPath;
		String vwPath;
		String indexPath;
		String performanceFile;
		String resultFile;
		
		// EXPERIMENT
		experimentPath = configMap.get("experiment-path").toString();
		Experiment experiment = new Experiment(aJCas);
		experiment.setId(
				Integer.parseInt(configMap.get("experiment-id").toString()));
		experiment.setPath(experimentPath);
		experiment.addToIndexes();
		if(!CheckPathConsistency(experimentPath)) {
			System.out.println("Experiment path could not be created");
			System.exit(-1);
		}
		
		// SOURCE FILES
		SourceFiles sourceFiles = new SourceFiles(aJCas);
		sourceFiles.setPath(configMap.get("source-path").toString());
		sourceFiles.setExt(configMap.get("img-file-ext").toString());
		sourceFiles.addToIndexes();
		
		// FEAT FILES
		featPath = FSTool.mergePaths(experimentPath, configMap.get("feat-path").toString());
		FeatFiles featFiles = new FeatFiles(aJCas);
		featFiles.setPath(featPath);
		featFiles.addToIndexes();
		if(!CheckPathConsistency(featPath)) {
			System.out.println("Features path could not be created");
			System.exit(-1);
		}
		
		// DICT PATH
		dictPath = FSTool.mergePaths(experimentPath, configMap.get("dict-path").toString());
		DictFiles dictFiles= new DictFiles(aJCas);
		dictFiles.setPath(dictPath);
		dictFiles.setVwNum(Integer.parseInt(configMap.get("vw-num").toString()));
		dictFiles.addToIndexes();
		if(!CheckPathConsistency(dictPath)) {
			System.out.println("Dictionary path could not be created");
			System.exit(-1);
		}
		
		//VW FILES
		vwPath = FSTool.mergePaths(experimentPath, configMap.get("vw-path").toString());
		VWFiles vwFiles = new VWFiles(aJCas);
		vwFiles.setPath(vwPath);
		vwFiles.addToIndexes();
		if(!CheckPathConsistency(vwPath)) {
			System.out.println("Visual words path could not be created");
			System.exit(-1);
		}
		
		// INDEX FILES
		indexPath = FSTool.mergePaths(experimentPath, configMap.get("index-path").toString());
		IndexFiles indexFiles = new IndexFiles(aJCas);
		indexFiles.setPath(indexPath);
		indexFiles.addToIndexes();
		if(!CheckPathConsistency(indexPath)) {
			System.out.println("Index path could not be created");
			System.exit(-1);
		}
		
		// RESULT file
		resultFile = FSTool.mergePaths(experimentPath, configMap.get("result-file").toString());
		EngineResult result = new EngineResult(aJCas);
		result.setFile(resultFile);
		result.addToIndexes();
		
		//PERFORMANCE FILE
		performanceFile = FSTool.mergePaths(experimentPath, configMap.get("performance-file").toString());
		TrainingRes performance = new TrainingRes(aJCas);
		performance.setPerformanceFile(performanceFile);
		performance.addToIndexes();
	
	}
	
	private boolean VerifyConfigMap(Map configMap) {
		boolean result = true;
		
		String fields[] = {"experiment-id", "experiment-path", 
				"source-path", "feat-path", "img-file-ext", 
				"dict-path","vw-num","vw-path", "index-path", "result-file","performance-file"};
		
		for(String field : fields) {
			if(configMap.get(field) == null) {
				System.out.printf("Missing %s in config file\n", field);
				result = false;
			}
		}
				
		return result;
	}
	
	private boolean CheckPathConsistency(String path) {
		if(!FSTool.dirExists(path)){
			if(!FSTool.mkdir(path)) {
				System.out.println("%s does not exists and could not be made");
				return false;
			}
		}
		return true;
	}
}
