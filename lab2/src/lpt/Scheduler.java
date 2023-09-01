package lpt;

import java.util.ArrayList;
import java.util.List;

public class Scheduler {
	private Machine[] machines;
	/** Skapar en schemaläggare för maskinerna 
		i vektorn machines. */

	//Fel nr.1 konstruktorn skapade en ny lista, så attrubutet var fick aldirg ett värde.
	
	public Scheduler(Machine[] machineArray) {
		machines = machineArray;
	}
	
	/** Returnerar den maskin som har minst att göra. */
	private Machine machineWithLeastToDo() {
		int min = Integer.MAX_VALUE;
		int minPos = -1;
		for (int i = 0; i < machines.length; i++) {
			int totalTime = machines[i].getScheduledTime();
			if (totalTime < min) {
				min = totalTime;
				minPos = i;
			}
		}
		return machines[minPos];
	}
	
	//sorterade åt fel håll, platsbyte med j2 och j1 löste problemet
	/** Fördelar jobben i listan jobs på maskinerna. */
	public void makeSchedule(List<Job> jobs) {
		List<Job> tempJobList = new ArrayList<>(jobs);
		tempJobList.sort((j1, j2) -> j2.getTime() - j1.getTime());
		for (Job j : tempJobList) {
			Machine m = machineWithLeastToDo();	
			m.assignJob(j);
		}	
	}
	
	/** Tar bort alla jobb från maskinerna. */
	public void clearSchedule() {
		for(int i = 0; i < machines.length; i++) {
			machines[i].clearJobs();
		}	
	}

	/** Skriver ut maskinernas scheman. */

	//Fel 2. Listan löpte <= ist för <. Index out of bounds.
	 
	public void printSchedule() {
		for (int i = 0; i < machines.length; i++) {
			System.out.println(machines[i]);
		}
	}
}
