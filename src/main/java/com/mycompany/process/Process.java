package com.mycompany.process;

import java.util.ArrayList;

public class Process {
    static ArrayList<Process> processList = new ArrayList<>();
	
    private int id;
    private int burstTime;
    private int arrivalTime;
    private int priority;

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBurstTime() {
		return burstTime;
	}

	public void setBurstTime(int burstTime) {
		this.burstTime = burstTime;
	}

	public int getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public Process(int id, int burstTime, int arrivalTime, int priority) {
        this.id = id;
        this.burstTime = burstTime;
        this.arrivalTime = arrivalTime;
        this.priority = priority;
    }

	/**
	 * Iterates through the processlist and gets their ID's
	 * @return ArrayList of process ID's
	 */
	public static ArrayList<Integer> getProcessArray() {
            ArrayList<Integer> processes = new ArrayList<Integer>();
		
            for (Process process : processList) {
                processes.add(process.getId());
            }
            return processes;
        }
	
    @Override
    public String toString() {
        return "Process ID: " + id + ", Burst Time: " + burstTime + ", Arrival Time: " + arrivalTime + ", Priority: " + priority;
    }
}


