/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package schedulerComponents;

import com.mycompany.process.Queue;
import com.mycompany.process.Process;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class MLFQScheduler {
	private List<Queue> queues;
	private List<Process> incomingProcesses;
	private int currentTime;
	private int entryQueue;

	public MLFQScheduler(List<Queue> queues, List<Process> incomingProcesses, int entryQueue) {
		this.queues = queues; 
		this.incomingProcesses = incomingProcesses;
		this.currentTime = 0;
		this.entryQueue = entryQueue;
	}
/*
		private void clockTick(processBlock proBlock){
		currentTime++;
		Iterator<Process> iterator = incomingProcesses.iterator();
		while(iterator.hasNext()){
			Process process = iterator.next();
			if(process.arrivalTime <= currentTime){
				queues.get(entryQueue).processes.add(process);
				iterator.remove();
			}
		}

		for (Queue queue : queues){
			if(!queue.processes.isEmpty()){
				Process process = queue.processes.poll();
				executeProcess(process, queue, proBlock);
		}
		}
	}*/
		

	
}
