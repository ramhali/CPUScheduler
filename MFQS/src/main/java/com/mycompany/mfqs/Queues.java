/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mfqs;

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
public class Queues {
    static Queues[] systemQueues;
    static Deque<Process>[] queue;
    
    private final int queueId;
    private final int queueAlgorithm; 
                  
    Queues (int queueId, int queueAlgorithm) {
        this.queueId = queueId;
        this.queueAlgorithm = queueAlgorithm;
    }
    
    public static void initializeQueues(int size) {
        systemQueues = new Queues[size];
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
        List<Process> processList = new ArrayList<>(queue[queueIndex]);
        int schedulingAlgorithm = systemQueues[queueIndex].getQueueAlgorithm();
        
        switch (schedulingAlgorithm) {
            case 1 -> System.out.println("FCFS");
            case 2 -> {
                System.out.println("SJF");
    
//                Process p = removeFirstProcessFromQueue(queueIndex);
//                
//                System.out.println("ARE THE QUEUES EMPTY?" +isEmpty());
//                
//                processList.sort(new Comparator<Process>() {
//                    @Override
//                    public int compare(Process p1, Process p2) {
//                        return Integer.compare(p1.getBurstTime(), p2.getBurstTime());
//                    }
//                }); queue[queueIndex].clear();
//                while(!processList.isEmpty()){
//                    addProcessToQueue(queueIndex, processList.remove(0));
//                }
//                
////                queue[queueIndex].addFirst(current);
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
            }
            default -> {
            }
        }
        
    }
    
    public int getQueueIndex(){
        return queueId;
    }
    public int getQueueAlgorithm(){
        return queueAlgorithm;
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
