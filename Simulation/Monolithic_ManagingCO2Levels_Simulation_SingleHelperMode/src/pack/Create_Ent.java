package pack;

import java.util.*;

import eduni.simjava.*;
import eduni.simjava.distributions.*;
public class Create_Ent extends Sim_entity{
	Parameters p = new Parameters();
	public Sim_uniform_obj numOfHelpers_Generator;  //obj for simulation using uniform dist
	public Sim_uniform_obj helperType_Generator;
	public Sim_uniform_obj x_coordinate_Generator;
	public Sim_uniform_obj y_coordinate_Generator;
	public Sim_uniform_obj msgPayloadReadTimeLite_Generator;
	public Sim_uniform_obj msgPayloadReadTimeSeed_Generator;
	public Sim_uniform_obj task1Runtime_Generator;
	public Sim_uniform_obj task2RuntimeSeedZigbee_Generator;  // zigbee
	public Sim_uniform_obj task3RuntimeSeedZigbee_Generator;
	public Sim_uniform_obj task4Runtime_Generator; //Display on a local reg
	public Sim_uniform_obj task5Runtime_Generator; // Display on a local  lite
	public Sim_uniform_obj task6Runtime_Generator; // Circulate fresh air lite
	public Sim_uniform_obj helperWorkloadRatio_Generator; // 0 - 100%
        public Sim_uniform_obj CO2Level_Generator; 
	



	public Create_Ent(String arg0) {
		super(arg0);
	
		numOfHelpers_Generator = new Sim_uniform_obj("numOfHelpers", p.numOfHelpersMin, p.numOfHelpersMax);
	    add_generator(numOfHelpers_Generator); // send to method add-generatore in 
	    
	    helperType_Generator = new Sim_uniform_obj("helperType", p.helperTypeMin, p.helperTypeMax); // 0-4 type
	    add_generator(helperType_Generator);  
	    
	    x_coordinate_Generator = new Sim_uniform_obj("xCoordinate", 0, p.areaMaxX); 
	    add_generator(x_coordinate_Generator);
	    
	    y_coordinate_Generator = new Sim_uniform_obj("yCoordinate", 0, p.areaMaxY);
	    add_generator(y_coordinate_Generator);
	    
	    msgPayloadReadTimeLite_Generator = new Sim_uniform_obj("msgPayloadReadTimeLite", p.msgPayloadReadTimeLiteMin, p.msgPayloadReadTimeLiteMax);
	    add_generator(msgPayloadReadTimeLite_Generator); // بس اللايت هيلبر بتحتاج ميثود للريد تايم لأنه الريجيولار هيلبر تحتاج قيمة صفر حتى تقرأ هيلب اوبجكت
            
	    
		msgPayloadReadTimeSeed_Generator = new Sim_uniform_obj("msgPayloadReadTimeSeed", p.msgPayloadReadTimeSeedMin, p.msgPayloadReadTimeSeedMax);
		add_generator(msgPayloadReadTimeSeed_Generator); // حسب وقت قراءة الهيلب للسيدلحسابات ثاني اكسيد  
		
		task1Runtime_Generator = new Sim_uniform_obj("task1Runtime", p.task1RuntimeMin, p.task1RuntimeMax);
		add_generator(task1Runtime_Generator); // creat help object and oppnet task 
		
		task2RuntimeSeedZigbee_Generator = new Sim_uniform_obj("task2RuntimeSeedZigbee", p.task2RuntimeSeedZigbeeMin, p.task2RuntimeSeedZigbeeMax);
		add_generator(task2RuntimeSeedZigbee_Generator); // send & forward help
		
		task3RuntimeSeedZigbee_Generator = new Sim_uniform_obj("task3RuntimeSeedZigbee", p.task3RuntimeSeedZigbeeMin, p.task3RuntimeSeedZigbeeMax);
		add_generator(task3RuntimeSeedZigbee_Generator); //send & forward Send oppnetTasks 
		
		task4Runtime_Generator = new Sim_uniform_obj("task4Runtime", p.task4RuntimeMin, p.task4RuntimeMax);
		add_generator(task4Runtime_Generator);

		task5Runtime_Generator = new Sim_uniform_obj("task5Runtime", p.task5RuntimeMin, p.task5RuntimeMax);
		add_generator(task5Runtime_Generator);

		task6Runtime_Generator = new Sim_uniform_obj("task6Runtime", p.task6RuntimeMin, p.task6RuntimeMax);
		add_generator(task6Runtime_Generator); // fresh air

		helperWorkloadRatio_Generator = new Sim_uniform_obj("helperWorkloadRatio", p.helperWorkloadRatioMin, p.helperWorkloadRatioMax);
		add_generator(helperWorkloadRatio_Generator);
                
                CO2Level_Generator = new Sim_uniform_obj("CO2Level", p.CO2LevelMin, p.CO2LevelMax);
		add_generator(CO2Level_Generator);
			
	}
	
	public void body() {
		if (p.Helpers.size() >0)
			p.Helpers.clear();
		if (p.oppnet.size() >0)
			p.oppnet.clear();
		
	
		p.msgPayloadReadTimeLite = msgPayloadReadTimeLite_Generator.sample();
		
		p.msgPayloadReadTimeSeed = msgPayloadReadTimeSeed_Generator.sample();
		
	        p.task1Runtime = task1Runtime_Generator.sample();
		
		p.task2RuntimeSeedZigbee = task2RuntimeSeedZigbee_Generator.sample();
		p.task3RuntimeSeedZigbee = task3RuntimeSeedZigbee_Generator.sample();

		
		p.task4Runtime = task4Runtime_Generator.sample();
	
		p.task5Runtime = task5Runtime_Generator.sample();

		p.task6Runtime = task6Runtime_Generator.sample();
                
                p.CO2Level=CO2Level_Generator.sample();

	
		ArrayList <Location> loc = new ArrayList<Location>(); // declration the array
		
		// creating the seed 
                //if(p.CO2Level>0.6&&p.CO2Level<0.1){
		Seed s = new Seed("Sensor", p, p.msgPayloadReadTimeSeed);
		s.device = "Sensore";
		s.Comm_Channels.add("Zigbee");
                s.Coordinator=true; 
                //we don't need opp becuse opp just for BT
		//s.OPP = true;

		if (s.pr.Helpers.size()>0) s.pr.Helpers.clear();

		Location seed_loc = new Location(); // 
		seed_loc.X = x_coordinate_Generator.sample();
		seed_loc.Y = y_coordinate_Generator.sample();		
		seed_loc.X = Math.floor(seed_loc.X * 100) / 100;
		seed_loc.Y = Math.floor(seed_loc.Y * 100) / 100;

		s.location = seed_loc;  // store in array 
		loc.add(s.location); // add to array
	
		//generating number of helpers inside the operations area

		Helper h = null;
		p.numOfHelpers = (int) numOfHelpers_Generator.sample();
		int count = p.numOfHelpers;
		//generating types of helpers inside the operations area
		while(count >0){
			count = count -1;
			p.helperType = (int) helperType_Generator.sample();
			
			
			switch(p.helperType){
			case 1: 
				        h = new Regular_Helper("SmartPhone", p, p.approxMsgPayloadReadTimeRegHlpr);
					h.device = "SmartPhone";
					h.sortingOrder = 2;
					h.category = "Adhoc";
					h.Comm_Channels.add("BT");
					h.Comm_Channels.add("Zigbee");
		                        h.DeviceApps.add("Display");
					h.OPP = true;
					h.Coordinator = true;
				        h.helperWorkloadRatio = helperWorkloadRatio_Generator.sample();
     				break;
					
			case 2: 
				        h = new Lite("Billboard", p, p.msgPayloadReadTimeLite);
					h.device = "Billboard";
					h.sortingOrder = 2;
					h.category = "Adhoc";
					h.Comm_Channels.add("Zigbee");
					h.OPP = true;
					h.DeviceApps.add("Display");
					h.Coordinator = true;
				        h.helperWorkloadRatio = helperWorkloadRatio_Generator.sample();

					break;
					
			case 3: 
		                       h = new Regular_Helper("Car", p, p.approxMsgPayloadReadTimeRegHlpr);
                                       h.device = "Car";
                                       h.sortingOrder = 2;
                                       h.category = "Adhoc";
                                       h.Comm_Channels.add("BT");
                                       h.OPP = true;
                                       h.Comm_Channels.add("Zigbee");
                                       h.Coordinator = true; 
                                       h.DeviceApps.add("Display");
                                       h.helperWorkloadRatio = helperWorkloadRatio_Generator.sample();

				  break;
					
			case 4: 
					h = new Lite("Fan", p, p.msgPayloadReadTimeLite);
					h.device = "Fan";
					h.sortingOrder = 1;
					h.category = "Adhoc";
					h.Comm_Channels.add("Zigbee");
                                        h.DeviceApps.add("Circulate");
					//h.OPP = true;
                 			h.Coordinator = true;
				        h.helperWorkloadRatio = helperWorkloadRatio_Generator.sample();

					break;
                        case 5: 
			             	h = new Lite("Billboard2", p, p.msgPayloadReadTimeLite);
					h.device = "Billboard2";
					h.sortingOrder = 2;
					h.category = "Adhoc";
					h.Comm_Channels.add("Zigbee");
                                        h.Comm_Channels.add("BT");
                                        h.DeviceApps.add("Display");
					h.OPP = true;
                                        h.Coordinator = true;
				        h.helperWorkloadRatio = helperWorkloadRatio_Generator.sample();

					break; 
	
			
			default: break;
			}
			Location helper_loc = new Location();
			helper_loc.X = x_coordinate_Generator.sample();
			helper_loc.Y = y_coordinate_Generator.sample();	
			
			while (loc.contains(helper_loc)){
				helper_loc.X = x_coordinate_Generator.sample();
			    helper_loc.Y = y_coordinate_Generator.sample();
			}
			helper_loc.X = Math.floor(helper_loc.X * 100) / 100;
			helper_loc.Y = Math.floor(helper_loc.Y * 100) / 100;

			h.location = helper_loc;
			loc.add(h.location);
			p.Helpers.add(h);
			//Sort helpers by rank
			Collections.sort(p.Helpers);
			
			
		}
		  loc.clear();

	}
}


