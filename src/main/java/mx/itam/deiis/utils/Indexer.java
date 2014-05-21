package mx.itam.deiis.utils;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.document.Document;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.core.WhitespaceAnalyzer;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.IndexWriterConfig.OpenMode;
import org.apache.lucene.index.Term;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringReader;
import java.io.InputStreamReader;

public class Indexer {
    
	private String mIndexPath = null;
	private IndexWriter indexWriter = null;
    /** Creates a new instance of Indexer */
    public Indexer(String indexPath) {
    	mIndexPath = indexPath;
    }
 
    public IndexWriter getIndexWriter(boolean create) throws IOException {
        if (indexWriter == null) {
        	Directory indexDir = FSDirectory.open(new File(mIndexPath));
        	Analyzer analyzer = new WhitespaceAnalyzer(Version.LUCENE_47);
        	IndexWriterConfig iwc = new IndexWriterConfig(Version.LUCENE_47, analyzer);
        	
       		iwc.setOpenMode( create? OpenMode.CREATE: OpenMode.CREATE_OR_APPEND);
       		//iwc.setRAMBufferSizeMB(256.0)
       		
            indexWriter = new IndexWriter(indexDir, iwc);
        }
        return indexWriter;
   }    
   
    public void closeIndexWriter() throws IOException {
        if (indexWriter != null) {
            indexWriter.close();
            indexWriter = null;
        }
   }
    
    public boolean indexVisualWords(String vwPath, String fileExt) throws IOException {
        
        
        File[] fileList = getFilesByExt(vwPath, fileExt);
        System.out.println("Total files found: " + fileList.length);
        IndexWriter writer = getIndexWriter(true);
        for(File file: fileList) {
        	System.out.println("Indexing image: " + file);
        	FileInputStream fis;
        	try {
	        	fis = new FileInputStream(file);
        	} catch (FileNotFoundException fnfe) {
	        	return false;
        	}
        	
        	Document doc = new Document();
        	//TODO: get filename without extension or owner which is folder name
            doc.add(new StringField("owner", "0", Field.Store.YES));
            doc.add(new StringField("path", file.getPath(), Field.Store.YES));
            doc.add(new TextField("content", new BufferedReader(new InputStreamReader(fis, "UTF-8"))));
            writer.addDocument(doc);
        }
        
        return true;
    }
    
    public static File[] getFilesByExt(String path, String ext) {
		GenericExtFilter filter = new GenericExtFilter(ext);
		File dir = new File(path);
 
		if(dir.isDirectory()==false) {
			System.out.println("Directory does not exists : " + path);
			return null;
		}
		// list out all the file name and filter by the extension
		File[] list = dir.listFiles(filter);
 
		if (list.length == 0) {
			return list;
		}
		for (File file : list) {
			String temp = new StringBuffer(path).append(file.getPath())
					.append(file).toString();
		}
		
		return list;
	}
    
    public void buildIndex(String vwPath, String fileExt) throws IOException {
          // Get fresh index
          getIndexWriter(true);

          // Index all visual word files
          indexVisualWords(vwPath, fileExt);
          
          // Clean code
          closeIndexWriter();
     }    
}
