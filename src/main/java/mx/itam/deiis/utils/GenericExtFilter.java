package mx.itam.deiis.utils;

import java.io.File;
import java.io.FilenameFilter;

//inner class, generic extension filter
public class GenericExtFilter implements FilenameFilter {
	private String extension;

	public GenericExtFilter(String ext) {
		this.extension = ext;
	}
	public boolean accept(File dir, String name) {
		return (name.endsWith(extension));
	}
}
