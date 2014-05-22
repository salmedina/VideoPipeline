package mx.itam.deiis.annotators;

import java.util.HashMap;
import java.util.Map;

import mx.itam.deiis.types.Dictionary;
import mx.itam.deiis.types.IndexFiles;
import mx.itam.deiis.types.Query;
import mx.itam.deiis.types.QueryRes;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.yaml.snakeyaml.Yaml;

public class QueryAnnotator extends JCasAnnotator_ImplBase{
	
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
		//QUERY file
		Query query = new Query(aJCas);
		query.setImgFile(configMap.get("query-file").toString());
		query.addToIndexes();
		
		//DICTIONARY
		Dictionary dictionary = new Dictionary(aJCas);
		dictionary.setTextFile(configMap.get("dict-file").toString());
		dictionary.setObj(configMap.get("dict-obj").toString());
		dictionary.addToIndexes();
		
		//INDEX Files
		IndexFiles indexFiles = new IndexFiles(aJCas);
		indexFiles.setPath(configMap.get("index-path").toString());
		indexFiles.addToIndexes();
		
		//QUERY RESult
		QueryRes queryRes = new QueryRes(aJCas);
		queryRes.setFile(configMap.get("result-file").toString());
		queryRes.addToIndexes();
	}
	
	private boolean VerifyConfigMap(Map configMap) {
		boolean result = true;
		
		String fields[] = {"query-file", "dict-file", 
				"dict-obj", "index-path", "result-file"};
		
		for(String field : fields) {
			if(configMap.get(field) == null) {
				System.out.printf("Missing %s in config file\n", field);
				result = false;
			}
		}
				
		return result;
	} 
}
