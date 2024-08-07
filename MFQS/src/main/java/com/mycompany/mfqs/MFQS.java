/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mfqs;

import static com.mycompany.mfqs.Process.processList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author Hp
 */
public class MFQS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello World!");
        System.out.println("Number of Processes: ");
        int pNumber = scanner.nextInt();
        
//        Queues.initialize(3);
//        Queues.add(0, new Process(1,2,3,4));
//        Queues.add(2, new Process(5,6,7,8));
//        Queues.printProcesses();
        System.out.println(pNumber +" Processes!");
        generateProcess(pNumber);        
        Process.printProcessArray();
        arrangeProcess();
        System.out.println("Arranged Process based on Arrival Time: ");
        Process.printProcessArray();
        
        System.out.println("Number of Queues: ");
        int qNumber = scanner.nextInt();
        
        Queues.initializeQueues(qNumber);
        generateQueues(qNumber);
        
        System.out.println("Where the Processes will Enter (Entry Queue [0-n]): ");
        int entryQueue = scanner.nextInt();
        
        System.out.println("Priority Policy (1 - Higher Before Lower; 2 - Fixed Time Slots): ");
        int priorityPolicy = scanner.nextInt();
        
        startSimulator(entryQueue, priorityPolicy);
        
    }
    
    public static void generateProcess(int number){
        Scanner scanner = new Scanner(System.in);
        
        for(int i = 1; i <= number; i++){
            System.out.println("Set Arrival Time for Process " +i +": ");
            int aTime = scanner.nextInt();
            System.out.println("Set Burst Time for Process " +i +": ");
            int bTime = scanner.nextInt();
            System.out.println("Set Priority for Process " +i +": ");
            int priority = scanner.nextInt();
            
            Process.processList.add(new Process(i, bTime, aTime, priority));
            
        }
    }
    
    public static void arrangeProcess() {
        Process.processList.sort(new Comparator<Process>() {
            @Override
            public int compare(Process p1, Process p2) {
                return Integer.compare(p1.getArrivalTime(), p2.getArrivalTime());
            }
        });
    }
    
    public static void generateQueues(int size) {
        Scanner scanner = new Scanner(System.in);
        
        for(int i = 1; i <= size; i++){
            System.out.println("Set Algorithm for Queue " +i +": ");
            int queueAlgorithm = scanner.nextInt();
            
            Queues.systemQueues[i-1] = new Queues(i, queueAlgorithm);
        }
    }
    
    public static void startSimulator(int entryQueue, int priorityPolicy){        
        System.out.println("Simulator Started! ");
        
        if(priorityPolicy == 1){
            higherBeforeLower(entryQueue);
        }
        else if(priorityPolicy == 2){
            fixedTimeSlot(entryQueue);
        }
        
        
        Queues.printProcessesOnQueue();
//        Process test = Queues.queue[1].poll();
//        promoteProcess(1, test);
//        System.out.println("After Promotion");
//        Queues.printProcessesOnQueue();
//        
//        test = Queues.queue[1].poll();
//        demoteProcess(1, test);
//        System.out.println("After Demotion");
//        Queues.printProcessesOnQueue();
    }
    
    public static void higherBeforeLower(int entryQueue) {
        
        System.out.println("HIGHER BEFORE LOWER");
        System.out.println();
        
        int clockTime = 1;
        
        while(!Process.processList.isEmpty() || !Queues.isEmpty()) {
            System.out.println("Clock Time: " +clockTime);
            getArrivedProcesses(entryQueue, clockTime);
            
            checkFromAbove();
            
            clockTime++;
        }
    }
    
    public static void fixedTimeSlot(int entryQueue) {
        
    }
    
    public static Process checkFromAbove(){
        Process p;
        
        for (int i = 0; i < Queues.systemQueues.length; i++) {
            if(!Queues.queue[i].isEmpty()){
                p = Queues.queue[i].peek();
                System.out.println("HIGHEST PRIORITY PROCESS: " +p.getProcessId() +" WITH " +p.getBurstTime() +" BURST TIME");
                Queues.queue[i].peek().setBurstTime(Queues.queue[i].peek().getBurstTime()-1); //decrement by 1 burst time
                
                if(p.getBurstTime() == 0){
                    Queues.queue[i].poll();
                }
                
                return p;
            }
        }
        return null;
    }
    
    public static void getArrivedProcesses(int entryQueue, int clockTime) {
        Iterator<Process> iterator = Process.processList.iterator();
        while (iterator.hasNext()) {
            Process process = iterator.next();
            if (process.getArrivalTime() == clockTime) {
                System.out.println("Process " + process.getProcessId() + " arrived!");
                Queues.addProcessToQueue(entryQueue, process);
                
                if(checkWhereHighestProcess() <= entryQueue){
                    //promotion
                }
                Queues.arrangeProcessesOnQueue(entryQueue);
                
                iterator.remove();
                
                
            }
        }
    }
    
    public static int checkWhereHighestProcess() {
         for (int i = 0; i < Queues.systemQueues.length; i++) {
            if(!Queues.queue[i].isEmpty()){
                return i;
            }
        }
        return -1;
    }
    public static void promoteProcess(int currentQueue, Process p) {
        if (currentQueue == 0) {
            System.out.println("At Highest Queue");
        }
        else {
            Process pToPromote = p;
            Queues.addProcessToQueue(currentQueue-1, pToPromote);
        }
    }
    
    public static void demoteProcess(int currentQueue, Process p) {
        if (currentQueue == 2) {
            System.out.println("At Lowest Queue");
        }
        else {
            Process pToDemote = p;
            Queues.addProcessToQueue(currentQueue+1, pToDemote);
        }
    }

}
