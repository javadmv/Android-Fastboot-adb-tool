/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adbfastboot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 *
 * @author javad
 */
public class EdlCmds {
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
    
}
