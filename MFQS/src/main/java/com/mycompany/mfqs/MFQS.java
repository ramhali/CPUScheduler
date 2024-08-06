/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mfqs;

import java.util.Arrays;
import java.util.Comparator;
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
        Process.printArray();
        arrangeProcess();
        System.out.println("Arranged Process based on Arrival Time: ");
        Process.printArray();
        
        System.out.println("Number of Queues: ");
        int qNumber = scanner.nextInt();
        
        Queues.initializeQueues(qNumber);
        generateQueues(qNumber);
        Queues.printQueues();
        
        Queues.addProcessToQueue(0, Process.process[0]);
        
        Queues.printProcesses();
    }
    
    public static void generateProcess(int number){
        Scanner scanner = new Scanner(System.in);
        Process.process = new Process[number];
        for(int i = 1; i <= number; i++){
            System.out.println("Set Arrival Time for Process " +i +": ");
            int aTime = scanner.nextInt();
            System.out.println("Set Burst Time for Process " +i +": ");
            int bTime = scanner.nextInt();
            System.out.println("Set Priority for Process " +i +": ");
            int priority = scanner.nextInt();
            
            Process.process[i-1] = new Process(i, bTime, aTime, priority);
            
        }
    }
    
    public static void arrangeProcess(){
        Arrays.sort(Process.process, new Comparator<Process>() {
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
}
