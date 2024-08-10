/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mfqs;

import java.util.ArrayList;

/**
 *
 * @author Hp
 */
public class Process {
    static ArrayList<Process> processList = new ArrayList<>();
    static ArrayList<Process> processListAfter = new ArrayList<>();
    
    private final int processId;
    private final int arrivalTime;
    
    private int originalBurstTime;
    private int burstTime;
    private int priority;
    
    private int startTime;
    private int completionTime;
    private int turnAroundTime;
    private int waitingTime;
    private int responseTime;
    
    Process (int processId, int burstTime, int arrivalTime, int priority) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.arrivalTime = arrivalTime;
        this.priority = priority;
        
        this.originalBurstTime = burstTime;
    }
    
    public void setBurstTime(int bTime){
        this.burstTime = bTime;
    }
    
    public void setPriority(int priority) {
        this.priority = priority;
    }
    
    
    public int getProcessId(){
        return processId;
    }
    public int getBurstTime(){
        return burstTime;
    }
    public int getArrivalTime(){
        return arrivalTime;
    }
    public int getPriority(){
        return priority;
    }
    
    public int getOriginalBurstTime(){
        return originalBurstTime;
    }
    
    // ------------------ GETTER//SETTER FOR PROCESS PERFORMANCES --------------
    
    
    public int getStartTime(){
        return startTime;
    }   
    public int getCompletionTime(){
        return completionTime;
    }
    public int getTurnAroundTime(){
        return turnAroundTime;
    }
    public int getWaitingTime(){
        return waitingTime;
    }
    public int getResponseTime(){
        return responseTime;
    }
    
   
    public void setStartTime(int startTime){
        this.startTime = startTime;
    }   
    public void setCompletionTime(int completionTime){
        this.completionTime = completionTime;
    }
    public void setTurnAroundTime(int turnAroundTime){
        this.turnAroundTime = turnAroundTime;
    }
    public void setWaitingTime(int waitingTime){
        this.waitingTime = waitingTime;
    }
    public void setResponseTime(int responseTime){
        this.responseTime = responseTime;
    }
    
    // -------------------------------------------------------------------------
    
    public static void printProcessArray() {
        System.out.print("Processes on Array: ");
        for (Process process : processList) {
            System.out.print(process.getProcessId() + " ");
        }
        System.out.println();
    }
    
    public static void calculateProcessPerformance() {
        System.out.println("Processes on Array After: ");
        for (Process process : processListAfter) {
            process.setTurnAroundTime((process.getCompletionTime() - process.getArrivalTime())+1);
            process.setWaitingTime(process.getTurnAroundTime() - process.getOriginalBurstTime());
            process.setResponseTime(process.getStartTime() - process.getArrivalTime());
            
            System.out.println("FOR " +process.getProcessId());
            System.out.println("START TIME: " +process.getStartTime());
            System.out.println("COMPLETION TIME: " +process.getCompletionTime());
            System.out.println("TURNAROUND TIME: " +process.getTurnAroundTime());
            System.out.println("WAITING TIME: " +process.getWaitingTime());
            System.out.println("RESPONSE TIME: " +process.getResponseTime());

        }
        System.out.println();
    }
    
}
