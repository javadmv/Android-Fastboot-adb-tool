package adbfastboot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.io.PrintWriter;




public class GetCmdResult{
	String Command;
	String result="";
        String k;
	
           public String getResult(String Command){
			   
			   try{
              			   
		
			String command1 = "fastboot devices";
    Process child = Runtime.getRuntime().exec(command1);

   child.waitFor(); 
                BufferedReader reader=new BufferedReader(
                    new InputStreamReader(child.getInputStream())
                ); 
                String line; 
                if ((line = reader.readLine()) != null) 
                { 
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
		   
		   
                    
                 
                else{
                    return("pls connect handset");
                }
			   }
				catch(IOException e1) {e1.printStackTrace();} 
            catch(InterruptedException e2) {e2.printStackTrace();}
			return result="ERROR";
            }
			
			
			
              
			// Process provides control of native processes started by ProcessBuilder.start and Runtime.exec.
			// getRuntime() returns the runtime object associated with the current Java application.

}