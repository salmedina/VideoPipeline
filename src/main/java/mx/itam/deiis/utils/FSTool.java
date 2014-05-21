package mx.itam.deiis.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.net.URI;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;

import org.apache.commons.io.FileUtils;


public class FSTool {

	public static int importToProject(String sourceDir, String projectDir) {
		
		return -1;
	}
	
	/*
	 * Creates all the folders required for the project
	 */
	public static boolean createPojectFS(String root, String projectID) {
		
		Path path = FileSystems.getDefault().getPath(root, "SOURCE");
		if (!(new File(path.toString())).mkdirs()) {
		    return false;
		}
		path = FileSystems.getDefault().getPath(root, "FEATS");
		if (!(new File(path.toString())).mkdirs()) {
		    return false;
		}
		path = FileSystems.getDefault().getPath(root, "DICTS");
		if (!(new File(path.toString())).mkdirs()) {
		    return false;
		}
		path = FileSystems.getDefault().getPath(root, "VISUALWORDS");
		if (!(new File(path.toString())).mkdirs()) {
		    return false;
		}
		
		return true;
	}
	
	public static boolean mkdir(String dir) {
		if( dirExists(dir) ) {
			System.err.printf("FSTool::mkdir (%s) : Directory already exists");
			return true;
		}
		return (new File(dir)).mkdirs();
	}
	
	public static boolean fileExists(String filePath) {
		File f = new File(filePath);
		if(f.exists() && !f.isDirectory())
			return true;
		
		return false;
	}
	
	public static boolean dirExists(String dir) {
		Path path = FileSystems.getDefault().getPath(dir);
		return Files.exists(path, LinkOption.NOFOLLOW_LINKS);
	}
	
	public static boolean copyDir(String source, String target) {
		try {
		    FileUtils.copyDirectory(new File(source), new File(target));
		} catch (IOException e) {
		    e.printStackTrace();
		    return false;
		}
		return true;
	}
	
	/**
	 * Copies all the subfolders of source dir into the target Dir
	 */
	public static int cloneTreeStruct(String sourceDir, String targetDir) {
		List<String> sourceList = getDirList(new File(sourceDir));
		List<String> targetList = new ArrayList<String>();
		for(String srcDir : sourceList) {
			targetList.add(srcDir.replace(sourceDir, targetDir));
		}
		for(String tgtDir : targetList) {
			if( mkdir(tgtDir) ) {
				System.out.printf("Created: %s\n", tgtDir);
			} else {
				System.out.printf("Error on: %s\n", tgtDir);
			}
		}
		return targetList.size();
	}
	
	/**
	 * Gets a list of all the full path of subfolders of the given directory
	 * @param node
	 * @return
	 */
	public static List<String> getDirList(File node){
		List dirList = new ArrayList<String>();
 
		if(node.isDirectory()){
			dirList.add(node.getAbsolutePath());
			String[] subNote = node.list();
			for(String filename : subNote){
				getSubDirList(new File(node, filename), dirList);
			}
		}
		return dirList;
	}
	
	/**
	 * Auxiliary function for the recursive approach of getDirList 
	 * @param node
	 * @param dirList
	 * @return
	 */
	public static List<String> getSubDirList(File node, List<String> dirList){
		if(node.isDirectory()){
			dirList.add(node.getAbsolutePath());
			String[] subNote = node.list();
			for(String filename : subNote){
				getSubDirList(new File(node, filename), dirList);
			}
		}
		return dirList;
	}
	
	/**
	 * Prints a list of all the subdirectories of dir
	 * @param dir
	 * @return number of subfolders found in dir
	 */
	public static int printDirList(String dir) {
		List<String> dirList = getDirList(new File(dir));
		return printStrList(dirList);
	}
	
	public static int printStrList(List<String> dirList) {
		if( dirList == null)
			return 0;
		
		for(String tmpDir : dirList) {
			System.out.println(tmpDir);
		}
		
		return dirList.size();
	}
	
	public static List<String> getFileList(File node){
		List fileList = new ArrayList<String>();
 
		if(node.isDirectory()){
			String[] subNote = node.list();
			for(String filename : subNote){
				getSubFileList(new File(node, filename), fileList);
			}
		} else if(node.isFile()) {
			fileList.add(node.getAbsolutePath());
		}
		return fileList;
	}
	
	public static int getSubFileList(File node, List<String> fileList){
		if(node.isDirectory()){
			String[] subNote = node.list();
			for(String filename : subNote){
				getSubFileList(new File(node, filename), fileList);
			}
		} else if (node.isFile()) {
			fileList.add(node.getAbsolutePath());
		}
		return fileList.size();
	}
	
	/**
	 * Gets the list of files with given extension
	 * searches for the subdirectories
	 * @param path
	 * @param ext
	 * @return
	 */
	public static List<String> getFilesByExt(String path, String ext) {
		List<String> fileList = getFileList(new File(path));
		List<String> resList = new ArrayList<String>();
		for(String file : fileList) {
			if(file.endsWith(ext))
				resList.add(file);
		}
		
		return resList;
	}
	
	public static String readAllFile(String strFile)
    {
       File file = new File(strFile);
       URI uri = file.toURI();
       byte[] bytes = null;
       try{
          bytes = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(uri));
       }catch(IOException e) 
       { 
    	   e.printStackTrace(); return "ERROR loading file "+strFile; 
       }
    
       return new String(bytes);
    }
}
