/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack;

import java.util.ArrayList;

import eduni.simjava.distributions.Sim_uniform_obj;


public class Parameters {

 	
	// Input parameters for the simulation area
	public static double areaMaxX = 1217;
	public static double areaMaxY = 14.3;
	
	// Input parameters for the node set
	//??
	public static int numOfHelpersMin = 5;
	public static int numOfHelpersMax = 427;
	
	// Input parameters for individual nodes
	
	public static int helperTypeMin = 1;
	public static int helperTypeMax = 6;
	
	public static double approxMsgPayloadReadTimeRegHlpr = 0;

	public static double msgPayloadReadTimeLiteMin = 29;
	public static double msgPayloadReadTimeLiteMax = 43;
	
	public static double msgPayloadReadTimeSeedMin = 29;
	public static double msgPayloadReadTimeSeedMax = 43;
	
	public static double task1RuntimeMin = 29;
	public static double task1RuntimeMax = 43; //seed create help object and oppnet tasks
	
	public static double task2RuntimeSeedZigbeeMin = 35.88;
	public static double task2RuntimeSeedZigbeeMax = 49.88; //seed send help object (rading time + communucation)
	public static double approxTask2RuntimeRegHlprWiFi =  0.176; //smartphone read and forward help object
	public static double approxTask2RuntimeRegHlprBT = 0.532;//car read and forward help object
	public static double task2RuntimeLiteZigbeeMin = 35.88;
	public static double task2RuntimeLiteZigbeeMax = 49.88;//billboard2 read and forward help object


	public static double task3RuntimeSeedZigbeeMin = 41.96;
	public static double task3RuntimeSeedZigbeeMax = 55.96; //seed send oppnet tasks(rading time + communucation)
	public static double approxTask3RuntimeRegHlprWiFi = 0.3008; //smartphone forward and read oppnet task
	public static double approxTask3RuntimeRegHlprBT = 0.948;//car forward and read oppnet task
        public static double task3RuntimeLiteZigbeeMin = 41.96;
        public static double task3RuntimeLiteZigbeeMax = 55.96; //billboard2 forward and read oppnet task  
	
        public static double task4RuntimeMin = 5000;
	public static double task4RuntimeMax = 11000; //time for reqular helpers (car- smartphone) to display text help msg
	
	public static double task5RuntimeMin = 3000 ;
	public static double task5RuntimeMax = 8000; //time for lite helpers (billboard- billboard2) to display text help msg
	

	public static double task6RuntimeMin = 29 ;
	public static double task6RuntimeMax = 43; // time for fan to circulate air
	
	public static double helperWorkloadRatioMin = 0;
	public static double helperWorkloadRatioMax = 100;
        
        public static double CO2LevelMin = 0;
	public static double CO2LevelMax = 100;
	
	// Input parameters for links
	
	public static double actualZigbeeDelTimeCtrlMsg = 3.776;
	public static double actualZigbeeDelTimeHelpObjectMsg = 6.88;
	public static double actualZigbeeDelTimeOppnetTaskMsg = 12.96;

	public static double actualBTdelTimeCtrlMsg = 0.287;
	public static double actualBTdelTimeHelpObjectMsg = 0.532;
	public static double actualBTdelTimeOppnetTaskMsg = 0.948;
	
	public static double actualWiFiDelTimeCtrlMsg = 0.1024;
	public static double actualWiFiDelTimeHelpObjectMsg = 0.176;
	public static double actualWiFiDelTimeOppnetTaskMsg = 0.3008;
		

	///Random Variables
	public int numOfHelpers;
		
	public int helperType;
	
	public double msgPayloadReadTimeLite;
        
	public double msgPayloadReadTimeSeed;
	
	public double task1Runtime;
	
	public double task2RuntimeSeedZigbee;
	
	public double task3RuntimeSeedZigbee;
	
	public double task4Runtime;
	
	public double task5Runtime;

        public double task6Runtime;

        public double helperWorkloadRatio;
        
        public double CO2Level;


	public ArrayList <Node>oppnet = new ArrayList<Node>();
	public ArrayList <Helper> Helpers = new ArrayList<Helper>();   
}
