/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ovm.co2.allmode;

/**
 *
 * @author sy
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author sy
 */
public class SimOutput {
 

    PrintWriter FileWriter = null;
 
    public double calculate_Sum(ArrayList measureValues){
    	double sum= 0;
    	//double avg = 0;
    	for (int i=0; i<measureValues.size(); i++)
    		sum= sum + (Double) measureValues.get(i);
    	
    	return sum;
    }
    
    public double calculate_Avg(ArrayList measureValues){
    	double sum= 0;
    	double avg = 0;
    	for (int i=0; i<measureValues.size(); i++)
    		sum= sum + (Double) measureValues.get(i);
    	avg = sum / measureValues.size();
    	
    	return avg;
    }
    
        public void outputFile(boolean Done, String oppnetFile, PrintWriter oppnetFileWriter, String measureName, double measureValue, String name, int id){
				
        	try {
				oppnetFileWriter = new PrintWriter(new BufferedWriter(new FileWriter(oppnetFile, true)));
			} catch (IOException e) {
				e.printStackTrace();
			}
        	if(name.equals("Sensor")){
        		oppnetFileWriter.println("==============================================");	
        	
	        	if(Done)
	        		oppnetFileWriter.println("Succeeded");	

        	   else if(!Done)
        		    oppnetFileWriter.println("Failed");	
        	}

			oppnetFileWriter.print(name +", "+ id+ ", "+ measureName+ "= ");
			oppnetFileWriter.println(measureValue);
			//oppnetFileWriter.print(this.get_name() +", "+ this.get_id()+ " Oppnet Success Time Per Iter= ");
			//oppnetFileWriter.println(this.oppnetTimeToSucceedPerIter);
			oppnetFileWriter.close();
    	}
    
    public void outputFile1(int num, boolean Done, String oppnetFile, PrintWriter oppnetFileWriter, String measureName, double measureValue, String name, int id){
			
        	try {
				oppnetFileWriter = new PrintWriter(new BufferedWriter(new FileWriter(oppnetFile, true)));
			} catch (IOException e) {
				e.printStackTrace();
			}
        	if(name.equals("Sensor")){
        		oppnetFileWriter.println("==============================================");	
        	
	        	if(Done)
	        		oppnetFileWriter.println("Succeeded");	

        	   else if(!Done)
        		    oppnetFileWriter.println("Failed");	
        	}

			oppnetFileWriter.print(name +", "+ id+ ", "+ measureName+ "= ");
			oppnetFileWriter.print(measureValue);
			oppnetFileWriter.println(", number = "+ num);

			//oppnetFileWriter.print(this.get_name() +", "+ this.get_id()+ " Oppnet Success Time Per Iter= ");
			//oppnetFileWriter.println(this.oppnetTimeToSucceedPerIter);
			oppnetFileWriter.close();
    	}
	}





