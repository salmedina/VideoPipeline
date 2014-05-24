package mx.itam.deiis.utils;

import java.net.InetAddress;

public class HWTool {
	static public String getName() {
		String name = "unknown";
		try{
		  name=InetAddress.getLocalHost().getHostName();
		}catch (Exception e){
		  System.out.println("Could not obtain localhost name\n"+e.getMessage());
		}
		return name;
	}
	
	static public int getNumCores() {
		return Runtime.getRuntime().availableProcessors();
	}
	
	static public long getSysMem() {
		com.sun.management.OperatingSystemMXBean bean =
			  (com.sun.management.OperatingSystemMXBean)
			    java.lang.management.ManagementFactory.getOperatingSystemMXBean();
		 return bean.getTotalPhysicalMemorySize();
	}
	
	static public String getPrettySysMem() {
		long sysMem = getSysMem();
		if( sysMem < 1024)			return String.format("%d B", sysMem);
		if( sysMem < 1048576)		return String.format("%.2f KB", (double)sysMem/(double)1024);
		if( sysMem < 1073741824)	return String.format("%.2f MB", (double)sysMem/(double)1048576);
		if( sysMem < 1099511627776l)	return String.format("%.2f GB", (double)sysMem/(double)1073741824);
		
		return "TOO LARGE";
	}
	
	static public String getOSName() {
		return System.getProperty("os.name").toLowerCase();
	}
}
