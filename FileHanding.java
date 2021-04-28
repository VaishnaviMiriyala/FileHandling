package m12.task1;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileHanding {
	
	public static void main(String[] args) {
		//File f = new File("C:\\Users\\123456\\Documents\\workspace-spring-tool-suite-4-4.10.0.RELEASE\\CoreJavaModule1\\src\\m12\\task1");
		File f2 = new File("C:\\Users\\123456\\Documents\\workspace-spring-tool-suite-4-4.10.0.RELEASE\\CoreJavaModule1\\src\\m12\\task1\\FileHanding.java");
		FileHanding obj = new FileHanding();
		
		try {
		//	obj.doWriteOnFile(f);
			obj.doReadFromFile(f2);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	public void doReadFromFile(File f)throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader(f));
		String line = "";
		int count = 0,count1 = 0,count2 = 0;
		int lineNumber = 1;
		while((line = br.readLine())!=null)
		{
			System.out.println(lineNumber+" "+line);
			boolean b = line.contains("file") || line.contains("File");
			
			if(b)
				{
					// spilt based on regexp for File input
				    Pattern pattern = Pattern.compile("File");
				    Matcher matcher = pattern.matcher(line);
				    
				    Pattern pattern1 = Pattern.compile("file");
				    Matcher matcher1 = pattern1.matcher(line);
				    
				    while(matcher.find() || matcher1.find()) {
				    	if(matcher1.find()) {
				    		count1++;
				    	}else {
				    		count2++;
				    	}
					     count++;
					     System.out.println("----->> line Number "+lineNumber+" & count "+count);
				    }
				}
			
			
			lineNumber++;
		}
		System.out.println("The number of time File word occurs: "+count2);
		System.out.println("The number of time file word occurs: "+count1);
		System.out.println("\n\n\n====>> File count "+count);
	}
	
	
	public void doWriteOnFile(File f)throws IOException
	{
		PrintWriter pw = new PrintWriter(new FileWriter(f));
		
		pw.append("gbfbfgnbgrfbnrgf");
	
		System.out.println("------------- Done ------------");
		pw.close();
	}

}
