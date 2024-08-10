/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mfqs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Hp
 */
public class MFQS {
    static ArrayList<Process> runningProcessList = new ArrayList<>();
    static int runningTime;
    
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
            
            Queues.systemQueues[i-1] = new Queues(i, queueAlgorithm, (int) Math.pow(2, i+1));
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
        
        Process.calculateProcessPerformance();
        
//        Queues.printProcessesOnQueue();
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
        boolean wronglyDemoted;
        
        while(!Process.processList.isEmpty() || !Queues.isEmpty()) {
            System.out.println("Clock Time: " +clockTime);
            System.out.println("QUEUE WHERE HIGHEST PROCESS:" +checkWhereHighestProcess());
            getArrivedProcesses(entryQueue, clockTime); //also arranges the queue based on algorithm
            
            Process currentProcess = checkFromAbove();
            wronglyDemoted = false;
            if(currentProcess != null){ //add process to the currentList
                if(!runningProcessList.contains(currentProcess)){ // set start time
                    currentProcess.setStartTime(clockTime);
                    Process.processListAfter.add(currentProcess);
                }
                
                runningProcessList.add(currentProcess); //add process to current running list
                
                if(currentProcess.getBurstTime() == 0){
//                    System.out.println("PROCESS IS FNISHING NOW");
                    int index = Process.processListAfter.indexOf(currentProcess);
                    
                    Process.processListAfter.get(index).setCompletionTime(clockTime);
                }
            }
            
            else {
                runningProcessList.add(new Process(-1, -1, -1, -1)); //dummy, for no process available on current clock time
            }
            
            
            if(!runningProcessList.isEmpty()){              
                if(runningProcessList.get(runningProcessList.size()-1).getProcessId() >= 0){ //check if there is process running
                    System.out.println("HIGHEST PRIORITY PROCESS: " +runningProcessList.get(runningProcessList.size()-1).getProcessId() +" WITH " +runningProcessList.get(runningProcessList.size()-1).getBurstTime() +" BURST TIME LEFT");
                }
                
                if(runningProcessList.size() >= 4 && runningProcessList.get(runningProcessList.size()-2).getProcessId() == -2
                        && (!runningProcessList.get(runningProcessList.size()-1).equals(runningProcessList.get(runningProcessList.size()-3)))){ //the preempted process is not to be demoted but promoted instead
                    
                    Process preempted = runningProcessList.get(runningProcessList.size()- 3); //3rd to the last process is wrongly demoted
                    promoteProcess(entryQueue, findProcessAndPoll(preempted));
                    Queues.arrangeProcessesOnQueue(entryQueue-1);
                    
                    wronglyDemoted = true;
                    
                }
            }
            
            System.out.println("DID PREEMPTION OCCUR? " +checkIfPreemptionHappened(runningProcessList));
            System.out.println("WAS THE PROCESS DEMOTED? " +wronglyDemoted);
            if(checkIfPreemptionHappened(runningProcessList) || wronglyDemoted){
                Process preempted;
                if(wronglyDemoted){
                    preempted = runningProcessList.get(runningProcessList.size()- 1); //last is the preempted
                }
                else{
                    preempted = runningProcessList.get(runningProcessList.size()- 2); //2nd to the last is the preempted
                }
                
                System.out.println("PREEMPTED PROCESS: " +preempted.getProcessId());
                
//                findProcessAndPoll(entryQueue, preempted);
//                System.out.println(p.getProcessId());
//                
                promoteProcess(entryQueue, findProcessAndPoll(preempted));
                runningTime = countProcessAllocation(runningTime);
//                System.out.println(entryQueue);
                Queues.arrangeProcessesOnQueue(entryQueue-1);
            }
            
            
            clockTime++;
        }
    }
    
    public static void fixedTimeSlot(int entryQueue) {
        System.out.println("FIXED TIME SLOT");
        System.out.println();
        
        int clockTime = 1;
        int currentQueue = 0;
        int allocationCounter = 0;
        
        int beforeQueue = 0;
        
//        boolean currentQueueChecker = false;
        boolean preEmpted = false;
        boolean recentlyPreEmpted;
        int first = Process.processList.get(0).getArrivalTime();
        
        while(!Process.processList.isEmpty() || !Queues.isEmpty()) {
            System.out.println();
            System.out.println("Clock Time: " +clockTime);
            getArrivedProcesses(entryQueue, clockTime); //also arranges the queue based on algorithm
            
            for(int i = 0; i < Queues.systemQueues.length; i++){
                Queues.systemQueues[i].setQueueAllocation(3-i);
            }
    
            System.out.println(first);
            
//            if(clockTime == first){
//                currentQueue = 0;
//                allocationCounter = 0;
//            }
            System.out.println("CURRENT QUEUE: " +currentQueue);
//            else{
//                System.out.println("PLAYING FROM QUEUE: " +currentQueue +" WITH ALLOCATION " +Queues.systemQueues[currentQueue].getQueueAllocation());
//            }
//            if(!currentQueueChecker){
//                currentQueue = checkWhereHighestProcess();
//                allocationCounter = 0;
//            }
           
            Process currentProcess = checkForAllocation(currentQueue);
            if(currentProcess == null){
                System.out.println("CURRENT PROCESS IS NULL");
            }
            else {
                System.out.println("PROCESS " +currentProcess.getProcessId() +" FROM QYEYE " +currentQueue);
            }
            
            
//            if(currentQueueChecker){
//                System.out.println("PLAYING FROM QUEUE: " +currentQueue +" WITH ALLOCATION " +Queues.systemQueues[currentQueue].getQueueAllocation());
//            }
            
            allocationCounter++; //increment by 1
            System.out.println("ALLOCTAION: " +allocationCounter);
            
            recentlyPreEmpted = preEmpted;
            preEmpted = false;
            
            if(currentQueue != -1){
                if(allocationCounter == Queues.systemQueues[currentQueue].getQueueAllocation()){
                    
                    System.out.println("ALLOCATION UP!");
                    allocationCounter = 0;

//                    Process preempted = runningProcessList.get(runningProcessList.size()- 1);
//                    System.out.println("PROCESS PREEMPTED LAST ELEMENT ON PRLCESS LIST: " +preempted.getProcessId());
//
//                    Process temp = findProcessAndPoll(preempted);
//
//                    if(temp != null){
//                        demoteProcess(currentQueue, temp);
//                        Queues.arrangeProcessesOnQueue(currentQueue+1);
//                    }

                    beforeQueue = currentQueue; //to be used for demotion
                    
                    //go to nextQueue
                    if(currentQueue >= Queues.systemQueues.length-1){
                        currentQueue = 0;
                    }
                    else {
                        currentQueue++;
                    }

                    
//                    System.out.println("PLAYING FROM QUEUE  " +currentQueue);
    //                runningProcessList.add(new Process(-1, -1, -1, -1)); //dummy, for no process available on current clock time
    ////                System.out.println("CURRENT PROCESS" +runningProcessList.get(runningProcessList.size()-1).getProcessId());
    ////                System.out.println("CURRENT PROCESS" +runningProcessList.get(runningProcessList.size()-2).getProcessId());

    //                Queues.arrangeProcessesOnQueue(currentQueue-1);
//    System.out.println("GET BURST TIME: " +runningProcessList.get(runningProcessList.size()-1).getBurstTime());
                    preEmpted = true;
                    
                }
//                currentQueueChecker = true; //the system is already running
            }
            
            
            if(currentProcess != null){ //add process to the currentList
                if(!runningProcessList.contains(currentProcess)){ // set start time
                    currentProcess.setStartTime(clockTime);
                    Process.processListAfter.add(currentProcess);
                }
                runningProcessList.add(currentProcess); //add process to current running list
            }
            else {
                runningProcessList.add(new Process(-1,-1,-1,-1)); //for no available process
            }
            
            if(!runningProcessList.isEmpty()){              
                if(runningProcessList.get(runningProcessList.size()-1).getProcessId() >= 0){ //check if there is process running
                    System.out.println("HIGHEST PRIORITY PROCESS: " +runningProcessList.get(runningProcessList.size()-1).getProcessId() +" WITH " +runningProcessList.get(runningProcessList.size()-1).getBurstTime() +" BURST TIME LEFT");
                }
            }
            
            if(currentProcess != null){
                if(currentProcess.getBurstTime() == 0){
//                    System.out.println("PROCESS IS FNISHING NOW");
                    int index = Process.processListAfter.indexOf(currentProcess);
                    
                    Process.processListAfter.get(index).setCompletionTime(clockTime);
                    if(runningProcessList.get(runningProcessList.size()-2).getProcessId() == -2){
                        runningProcessList.add(new Process(-2, -2, -2, -2)); //avoid printing if the process is already expired
                    }
                }
            }
            
            System.out.println("DID PREEMPTION OCCUR? " +checkIfPreemptionHappened(runningProcessList));
            System.out.println("PROCESS PREEMPTED? " +preEmpted);
            if(checkIfPreemptionHappened(runningProcessList) && !recentlyPreEmpted){
                Process preempted = runningProcessList.get(runningProcessList.size()- 2); //2nd to the last is the preempted
                
//                System.out.println("PREEMPTED PROCESS: " +preempted.getProcessId());
                
//                findProcessAndPoll(entryQueue, preempted);
//                System.out.println(p.getProcessId());
//                
                promoteProcess(entryQueue, findProcessAndPoll(preempted));
//                runningTime = countProcessAllocation(runningTime);
//                System.out.println(entryQueue);
                Queues.arrangeProcessesOnQueue(entryQueue-1);
            }
            
            if(preEmpted && !runningProcessList.isEmpty()){
                Process preempted = runningProcessList.get(runningProcessList.size()- 1);
                    System.out.println("PROCESS PREEMPTED LAST ELEMENT ON PRLCESS LIST: " +preempted.getProcessId() +" WITH BURST TIME " +preempted.getBurstTime());

                    Process temp = findProcessAndPoll(preempted);

                    System.out.println("CURRENT QUEUE: " +currentQueue);
                    System.out.println("BEFORE QUEUE: " +beforeQueue);
                    
                    if(temp != null && preempted.getBurstTime() > 0){
                        demoteProcess(beforeQueue, temp);
                        Queues.arrangeProcessesOnQueue(beforeQueue+1);
                        
                    }   
                    if(preempted.getBurstTime() == 0){
                        runningProcessList.add(new Process(-2, -2, -2, -2));
                    }                    
            }
            
            clockTime++;
        }
    }
    
    public static Process checkForAllocation(int queueIndex){
        Process p;
        if(queueIndex < 0){
            return null;
        }
        else if(!Queues.queue[queueIndex].isEmpty()){
                p = Queues.queue[queueIndex].peek();
                
                Queues.queue[queueIndex].peek().setBurstTime(Queues.queue[queueIndex].peek().getBurstTime()-1); //decrement by 1 burst time
                
                if(p.getBurstTime() == 0){
//                    System.out.println(Queues.queue[queueIndex].peek().getProcessId() +" IS ABOUT TO BE REMOVED");
                    Queues.queue[queueIndex].poll();
//                    System.out.println("NOW HIGHEST PROCESS IS AT INDEX: " +checkWhereHighestProcess());
                }
                
//                p = Queues.queue[i].peek();
//                Queues.queue[i].peek().setBurstTime(Queues.queue[i].peek().getBurstTime()-1); //decrement by 1 burst time
//                
//                runningTime = countProcessAllocation(runningTime);
//                System.out.println("RUNNING TIME: " +runningTime);
//                
//                if(runningTime >= Queues.systemQueues[i].getQueueAllocation()-1){
//                    System.out.println("PROCESS SHOULD BE DEMOTED");
////                    System.out.println(Queues.systemQueues[i].getQueueIndex());
//                    demoteProcess(Queues.systemQueues[i].getQueueIndex()-1, findProcessAndPoll(runningProcessList.getLast()));
//                    Queues.arrangeProcessesOnQueue(Queues.systemQueues[i].getQueueIndex());
//                    
//                    Queues.printProcessesOnQueue();
//                    
//                    runningProcessList.add(new Process(-2, -2, -2, -2)); //dummy, to avoid beinch flagged for preemption
//                    runningTime = countProcessAllocation(runningTime); //reset allocation counter
//                    
//                    System.out.println("LAST TWO PROCESSES: " +runningProcessList.get(runningProcessList.size()-2).getProcessId() +" " +runningProcessList.get(runningProcessList.size()-1).getProcessId());
//                }
//                
//                if(p.getBurstTime() == 0){
//                    System.out.println(Queues.queue[i].peek().getProcessId() +" IS ABOUT TO BE REMOVED");
//                    Queues.queue[i].poll();
//                    System.out.println("NOW HIGHEST PROCESS IS AT INDEX: " +checkWhereHighestProcess());
//                }
//                
//                System.out.println("FROM QUEUE: " +i);
                return p;
            }
        return null;
    }
    
    public static Process checkFromAbove(){
        Process p;
        
        for (int i = 0; i < Queues.systemQueues.length; i++) {
            if(!Queues.queue[i].isEmpty()){
                System.out.println("ALLOCATION OF QUEUE: " +Queues.systemQueues[i].getQueueAllocation());
                
                p = Queues.queue[i].peek();
                Queues.queue[i].peek().setBurstTime(Queues.queue[i].peek().getBurstTime()-1); //decrement by 1 burst time
                
                runningTime = countProcessAllocation(runningTime);
                System.out.println("RUNNING TIME: " +runningTime);
                
                if(runningTime >= Queues.systemQueues[i].getQueueAllocation()-1){
                    System.out.println("PROCESS SHOULD BE DEMOTED");
                    System.out.println(Queues.systemQueues[i].getQueueIndex());
                    demoteProcess(Queues.systemQueues[i].getQueueIndex()-1, findProcessAndPoll(runningProcessList.get(runningProcessList.size()-1)));
                    Queues.arrangeProcessesOnQueue(Queues.systemQueues[i].getQueueIndex());
                    
//                    Queues.printProcessesOnQueue();
                    
                    runningProcessList.add(new Process(-2, -2, -2, -2)); //dummy, to avoid being flagged for preemption
                    runningTime = -1; //reset allocation counter
//                    System.out.println("RUNNING TIME: " +runningTime);
//                    System.out.println("LAST TWO PROCESSES: " +runningProcessList.get(runningProcessList.size()-2).getProcessId() +" " +runningProcessList.get(runningProcessList.size()-1).getProcessId());
                }
                
                if(p.getBurstTime() == 0){
//                    System.out.println(Queues.queue[i].peek().getProcessId() +" IS ABOUT TO BE REMOVED");
                    Queues.queue[i].poll();
//                    System.out.println("NOW HIGHEST PROCESS IS AT INDEX: " +checkWhereHighestProcess());
                }
                
//                System.out.println("FROM QUEUE: " +i);
                return p;
            }
        }
        return null;
    }
    
    public static int countProcessAllocation(int runningTime){
//        System.out.println(runningProcessList.size() +" IS SIZE OF runningProcessList");
        if(runningProcessList.size() <= 1){
            return runningProcessList.size();
        }
        else {
            Process currentProcess = runningProcessList.get(runningProcessList.size()-1);
            Process previousProcess = runningProcessList.get(runningProcessList.size()-2);
            
//            System.out.println("CURRENT PROCESS: " +currentProcess.getProcessId());
//            System.out.println("PREVIOUS PROCESS: " +previousProcess.getProcessId());
            
            if(currentProcess.getBurstTime() <= 0 || previousProcess.getProcessId() <= 0){
                return 0;
            }
            
            if(currentProcess.equals(previousProcess)){
//                System.out.println("currentProcess.equals(previousProcess), +1 runningtime");
                runningTime++;
            }
            else {
                return 1; //counter for new process
            }
        }
        
//        if(runningProcessList.get(runningProcessList.size()-2).getProcessId() <= 0){ // for the process after demotion to count
//            runningTime++;
//        }
        return runningTime;
    }
    
    public static void getArrivedProcesses(int entryQueue, int clockTime) {
        Iterator<Process> iterator = Process.processList.iterator();
        while (iterator.hasNext()) {
            Process process = iterator.next();
            if (process.getArrivalTime() == clockTime) {
//                System.out.println("Process " + process.getProcessId() + " arrived!");
                Queues.addProcessToQueue(entryQueue, process);
                
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
            Queues.addProcessToQueue(currentQueue, p);
        }
        else {
            Queues.addProcessToQueue(currentQueue-1, p);
        }
    }
    
    public static void demoteProcess(int currentQueue, Process p) {
        if (currentQueue == Queues.systemQueues.length-1) {
             Queues.addProcessToQueue(currentQueue, p);
        }
        else {
            Process pToDemote = p;
            Queues.addProcessToQueue(currentQueue+1, pToDemote);
        }
    }
    
    public static boolean checkIfPreemptionHappened(ArrayList<Process> processList){
//        System.out.println("SIZE OF PROCESSLSIST: " +processList.size());
        if(processList.size() <= 1){
            return false;
        }
        else {
            Process currentProcess = processList.get(processList.size()-1);
            Process previousProcess = processList.get(processList.size()-2);
            
            System.out.println("CURRENT PROCESS: " +currentProcess.getProcessId());
            System.out.println("PREVIOUS PROCESS: " +previousProcess.getProcessId());
            
            if(processList.size() > 4 && processList.get(processList.size()-3).getBurstTime() == -2){ //for the case of demotion
                return false;
            }
            
            if(previousProcess.getBurstTime() <= 0){
                return false;
            }
            
            return !currentProcess.equals(previousProcess);
        }
    }
    
    public static Process findProcessAndPoll(Process p){
        for(int i= 0; i < Queues.systemQueues.length; i++){
            if (!Queues.queue[i].isEmpty()) {
            Iterator<Process> iterator = Queues.queue[i].iterator();
            while (iterator.hasNext()) {
                Process temp = iterator.next();
                if (temp.equals(p)) {
                    iterator.remove();
//                    System.out.println("Removed process with ID: " + temp.getProcessId());
                    return temp;
                }
            }
        }
        
            
//            System.out.println(Queues.queue[queueIndex].size());
//            Queues.printProcessesOnQueue();
//            for(int i = 0; i < Queues.queue[queueIndex].size(); i++) {
//                
//            }
//            for(int i = 0; i < Queues.queue[queueIndex].size(); i++){
//                System.out.println(Queues.queue[i].peek().getProcessId());
////                Process pr = Queues.queue[i].peek();
//                if(pr.equals(p)){
//                    System.out.println("PROCESS FOUND! ON: " +i);
//                    pr = Queues.queue[i].poll();
//                    return pr;
//                }
//            }
        }
//        System.out.println("NO PROCESS FOUND");
        return null;
    }
}
