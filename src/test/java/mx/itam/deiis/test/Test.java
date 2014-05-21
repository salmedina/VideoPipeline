package mx.itam.deiis.test;

import java.util.HashMap;
import java.util.Map;
import org.yaml.snakeyaml.Yaml;
import mx.itam.deiis.utils.FSTool;
import mx.itam.deiis.utils.SIFTTool;

public class Test {
  public static void main(String[] args) {

	  FSToolTest();
	  
	  //YAML example
	  //YAMLTest();
  }
  
  @SuppressWarnings("unused")
private static void OpenCVTest() {
	System.out.println("Hello, OpenCV");
	// This is required whenever using OpenCV
	//System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	SIFTTool imgTool = new SIFTTool();
	imgTool.extractFeatsToFile("E:\\Devel\\VideoPipelineTools\\Tux.jpg", "E:\\Devel\\VideoPipelineTools\\Tux.sift");
	
  }
  
  private static void FSToolTest() {
	  //FSTool.createPojectFS("F:\\Project-13", "13");
	  //FSTool.copyDir("F:\\Warez", "F:\\Test");
	  FSTool.printStrList(FSTool.getFilesByExt("C:\\Users\\Zal\\Downloads", ".pdf")); 
  }
  

  @SuppressWarnings("unused")
  private static void YAMLTest() {
	  Map<String, String> map = new HashMap<String, String>();
	  map.put("name", "Pushkin");
	  Yaml yaml = new Yaml();
	  String output = yaml.dumpAsMap(map);
	  System.out.println(output);
	  Yaml inYaml = new Yaml();
	  Map inMap = (HashMap<String, String>)inYaml.load(output);
	  
	  System.out.println("Break here");
  }
  
  
}
