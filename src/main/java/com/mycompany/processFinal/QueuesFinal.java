/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.processFinal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author Hp
 */
public class QueuesFinal {
    public static QueuesFinal[] systemQueues;
    public static Deque<Process>[] queue;
    
    private final int queueId;
    private final int queueAlgorithm; 
    
    private int queueAllocation;
                  
    public QueuesFinal (int queueId, int queueAlgorithm, int queueAllocation) {
        this.queueId = queueId;
        this.queueAlgorithm = queueAlgorithm;
        this.queueAllocation = queueAllocation;
    }
    
    public static void initializeQueues(int size) {
        systemQueues = new QueuesFinal[size];
        queue = new Deque[size];
        
        for (int i = 0; i < size; i++) {
            queue[i] = new ArrayDeque<>();
        }
    }
    
    public static void printProcessesOnQueue() {
    System.out.println("Processes on Queues: ");
    for (int i = 0; i < queue.length; i++) {
        System.out.println("From queue " + i);
        if (!queue[i].isEmpty()) {
            System.out.println(queue[i].size());
            Process p = queue[i].peek();
            System.out.println("Process " + p.getProcessId());
            }
        }
    }

    public static void printQueues() {
        for (int i = 0; i < systemQueues.length; i++) {
            System.out.print("FOR " +systemQueues[i].getQueueIndex() +": ");
            System.out.println(systemQueues[i].getQueueAlgorithm());
        }
    }
    
    public static void addProcessToQueue(int index, Process p) {
        queue[index].add(p);
    }
    
    public static Process removeFirstProcessFromQueue(int index) {
        return queue[index].poll();
    }
    
    //    public static void arrangeQueueOnAlgo()
    public static void arrangeProcessesOnQueue(int queueIndex){
        if(queueIndex < 0 || queueIndex > systemQueues.length-1){
            if(queueIndex < 0 ){
                arrangeProcessesOnQueue(0);
            }
            else if(queueIndex > systemQueues.length-1){
                arrangeProcessesOnQueue(systemQueues.length-1);
            }
        }
        else {
            List<Process> processList = new ArrayList<>(queue[queueIndex]);
            int schedulingAlgorithm = systemQueues[queueIndex].getQueueAlgorithm();

            switch (schedulingAlgorithm) {
                case 1 -> {
                    System.out.println("FCFS");
                    
                    Process currentProcess = null;
                    
                    if(!MFQS.runningProcessList.isEmpty()){
                        if(MFQS.runningProcessList.get(MFQS.runningProcessList.size()-1).getBurstTime() != 0 && MFQS.runningProcessList.get(MFQS.runningProcessList.size()-1) == queue[queueIndex].peek()){
//                            System.out.println("CURRENT PROCESS RUNNING IS FROM THIS QUEUE!");
                            currentProcess = queue[queueIndex].poll();
//                            System.out.println("POLLED FROM THE QUEUE: " +currentProcess.getProcessId());
                            processList = new ArrayList<>(queue[queueIndex]);
                        }
                    }
                    
                    processList.sort(new Comparator<Process>() {
                        @Override
                        public int compare(Process p1, Process p2) {
                            return Integer.compare(p1.getArrivalTime(), p2.getArrivalTime());
                        }
                    }); queue[queueIndex].clear();
                    while(!processList.isEmpty()){
                        addProcessToQueue(queueIndex, processList.remove(0));
//                        System.out.println("FIRST ElEMETN AFTER SORTING: " +queue[queueIndex].peek().getProcessId());
                    }
                    
                    if(currentProcess != null){
//                        System.out.println(currentProcess.getProcessId() +" IS ADDED AT FRONT");
                        queue[queueIndex].addFirst(currentProcess);
                    }

                }
                
                case 2 -> {
                    System.out.println("SJF");
                    
                    Process currentProcess = null;
                    
                    if(!MFQS.runningProcessList.isEmpty()){
                        if(MFQS.runningProcessList.get(MFQS.runningProcessList.size()-1).getBurstTime() != 0 && MFQS.runningProcessList.get(MFQS.runningProcessList.size()-1) == queue[queueIndex].peek()){
//                            System.out.println("CURRENT PROCESS RUNNING IS FROM THIS QUEUE!");
                            currentProcess = queue[queueIndex].poll();
//                            System.out.println("POLLED FROM THE QUEUE: " +currentProcess.getProcessId());
                            processList = new ArrayList<>(queue[queueIndex]);
                        }
                    }
                    
                    processList.sort(new Comparator<Process>() {
                        @Override
                        public int compare(Process p1, Process p2) {
                            return Integer.compare(p1.getBurstTime(), p2.getBurstTime());
                        }
                    }); queue[queueIndex].clear();
                    while(!processList.isEmpty()){
                        addProcessToQueue(queueIndex, processList.remove(0));
//                        System.out.println("FIRST ElEMETN AFTER SORTING: " +queue[queueIndex].peek().getProcessId());
                    }
                    
                    if(currentProcess != null){
//                        System.out.println(currentProcess.getProcessId() +" IS ADDED AT FRONT");
                        queue[queueIndex].addFirst(currentProcess);
                    }

                }

                case 3 -> {
                    System.out.println("SJRF");

                    processList.sort(new Comparator<Process>() {
                        @Override
                        public int compare(Process p1, Process p2) {
                            return Integer.compare(p1.getBurstTime(), p2.getBurstTime());
                        }
                    }); queue[queueIndex].clear();
                    while(!processList.isEmpty()){
                        addProcessToQueue(queueIndex, processList.remove(0));
                    }
                    
                    if(!MFQS.runningProcessList.isEmpty() && queue[queueIndex].peek().equals(MFQS.runningProcessList.get(MFQS.runningProcessList.size()-1))){
                        MFQS.runningTime = MFQS.countProcessAllocation(MFQS.runningTime); //reset runningTime
                    }
                } 
                
                case 4 -> {
                    System.out.println("NONPREEMPTIVE PRIORITY");
                    
                    Process currentProcess = null;
                    
                    if(!MFQS.runningProcessList.isEmpty()){
                        if(MFQS.runningProcessList.get(MFQS.runningProcessList.size()-1).getBurstTime() != 0 && MFQS.runningProcessList.get(MFQS.runningProcessList.size()-1) == queue[queueIndex].peek()){
//                            System.out.println("CURRENT PROCESS RUNNING IS FROM THIS QUEUE!");
                            currentProcess = queue[queueIndex].poll();
//                            System.out.println("POLLED FROM THE QUEUE: " +currentProcess.getProcessId());
                            processList = new ArrayList<>(queue[queueIndex]);
                        }
                    }
                    
                    processList.sort(new Comparator<Process>() {
                        @Override
                        public int compare(Process p1, Process p2) {
                            return Integer.compare(p1.getPriority(), p2.getPriority());
                        }
                    }); queue[queueIndex].clear();
                    while(!processList.isEmpty()){
                        addProcessToQueue(queueIndex, processList.remove(0));
//                        System.out.println("FIRST ElEMETN AFTER SORTING: " +queue[queueIndex].peek().getProcessId());
                    }
                    
                    if(currentProcess != null){
//                        System.out.println(currentProcess.getProcessId() +" IS ADDED AT FRONT");
                        queue[queueIndex].addFirst(currentProcess);
                    }

                }
                
                case 5 -> {
                    System.out.println("PREEMPTIVE PRIORITY");

                    processList.sort(new Comparator<Process>() {
                        @Override
                        public int compare(Process p1, Process p2) {
                            return Integer.compare(p1.getPriority(), p2.getPriority());
                        }
                    }); queue[queueIndex].clear();
                    while(!processList.isEmpty()){
                        addProcessToQueue(queueIndex, processList.remove(0));
                    }
                }
                
                default -> {
                }
            }
        }
        
        
    }
    
    public int getQueueIndex(){
        return queueId;
    }
    public int getQueueAlgorithm(){
        return queueAlgorithm;
    }
    public int getQueueAllocation(){
        return queueAllocation;
    }
    
    public void setQueueAllocation(int queueAllocation){
        this.queueAllocation = queueAllocation;
    }
    public static boolean isEmpty() {
        for (Queue<Process> q : queue) {
            if (!q.isEmpty()) {
                return false;
            }
        }
        return true;
    }
    
}
