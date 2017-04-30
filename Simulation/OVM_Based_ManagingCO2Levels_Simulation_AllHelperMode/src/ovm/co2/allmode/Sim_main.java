/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ovm.co2.allmode;

import eduni.simjava.Sim_system;
import java.io.File;

/**
 *
 * @author sy
 */
public class Sim_main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        deleteExistingFile("HelperIntegTime.txt");
		deleteExistingFile("TasksRuntimes.txt");
		deleteExistingFile("OppnetSuccessTime.txt");
		deleteExistingFile("NumRequestedHelpers.txt");
		deleteExistingFile("NumJoinedHelpers.txt");
		deleteExistingFile("NumRefusedHelpers.txt");
		deleteExistingFile("NumAdmittedHelpers.txt");
		deleteExistingFile("HelperUnhurriedTask.txt");
		deleteExistingFile("HelperUrgentTask.txt");

		Sim_system.initialise();
		Sim_system.set_trace_detail(false, true, false);
	
        Create_Ent ce = new Create_Ent("Create_Entities");
        
        Sim_system.set_output_analysis(Sim_system.IND_REPLICATIONS, 30, 0.95);
		Sim_system.run();

	}
	public static void deleteExistingFile(String filename){
		File oppnetFile = new File(filename);
		if (oppnetFile.exists())
			oppnetFile.delete();
	}

    }
    

