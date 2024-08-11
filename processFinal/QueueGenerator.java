/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.processFinal;

import com.mycompany.process.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author LENOVO
 */
public class QueueGenerator {
	public List<QueuesFinal> generateQueues(int numberOfQueue){
		List<QueuesFinal> queues = new ArrayList<>();
		for (int i = 0; i < numberOfQueue; i++){
			int id = i +1;
			QueuesFinal queue = new QueuesFinal(id, -1, 0);
			queues.add(queue);
		}
		return queues;
	}
}
