/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mfqs;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 *
 * @author Hp
 */
public class Queues {
    static Queues[] systemQueues;
    static Queue<Process>[] queue;
    
    private final int queueId;
    private final int queueAlgorithm; 
                  
    Queues (int queueIndex, int queueAlgorithm) {
        this.queueId = queueIndex;
        this.queueAlgorithm = queueAlgorithm;
    }
    
    public static void initializeQueues(int size) {
        systemQueues = new Queues[size];
        queue = new Queue[size];
        
        for (int i = 0; i < size; i++) {
            queue[i] = new ArrayDeque<>();
        }
    }
    
    public static void printProcesses() {
        for (int i = 0; i < queue.length; i++) {
            System.out.println("From queue " + i);
            while (!queue[i].isEmpty()) {
                Process p = queue[i].poll();
                System.out.println("Processing " + p.getProcessId());
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
    
    public int getQueueIndex(){
        return queueId;
    }
    public int getQueueAlgorithm(){
        return queueAlgorithm;
    }
}
