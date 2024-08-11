/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.processFinal;
//import com.mycompany.process.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

//import com.mycompany.process.ProcessGenerator;

/**
 * 
 *
 * @author LENOVO
 */
public class ProcessGenerator {
    private Random random = new Random();

    public List<Process> generateProcesses(int numberOfProcesses) {
        List<Process> processes = new ArrayList<>();
        for (int i = 0; i < numberOfProcesses; i++) {
            int id = i + 1;
            int burstTime = random.nextInt(10) + 1; // Random burst time between 1 and 10
            int arrivalTime = random.nextInt(10) + 1; // Random arrival time between 1 and 10
            int priority = random.nextInt(5) + 1; // Random priority between 1 and 5

            Process process = new Process(id, burstTime, arrivalTime, priority);
            processes.add(process);
        }
        return processes;
    }
}

