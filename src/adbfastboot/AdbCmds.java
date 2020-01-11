package adbfastboot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.io.PrintWriter;




public class AdbCmds{
	String Command;
	String result="";
        String k;
	
           public String getResult(String Command){
			   
			   
			try{
                 			Process p = Runtime.getRuntime().exec(Command);
			
			
 
			BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
			BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
			
 
			// read the output from the command
			
			while ((k = stdInput.readLine()) != null) {
				 result= result +"\n"+k+"\n";
			}
 
			// read any errors from the attempted command
			
			while ((k = stdError.readLine()) != null) {
				result= result+"\n"+k+"\n";
			}
			return result;
 
			
		} catch (IOException e) {
			System.out.println("exception happened - here's what I know: ");
			StringWriter sw= new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			String ExceptionAsString=sw.toString();
			System.out.println(ExceptionAsString);
			return ExceptionAsString;
			
		}
		} 
		   
		   
                    
                 
              
			
			
			
              
			// Process provides control of native processes started by ProcessBuilder.start and Runtime.exec.
			// getRuntime() returns the runtime object associated with the current Java application.

}