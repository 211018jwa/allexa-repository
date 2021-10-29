package com.revature.demos;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class QueueDemo {

	public static void demo() {
		
		//List<String> linkedListQueue = new LinkedList<>();
		Queue<String> linkedListQueue = new LinkedList<>();
		
		linkedListQueue.add("1st Person");
		linkedListQueue.add("2nd Person");
		linkedListQueue.add("3rd Person");
		
		String element = linkedListQueue.poll();
		System.out.println(element);
		System.out.println(linkedListQueue.poll());
		System.out.println(linkedListQueue.poll());
		//System.out.println(linkedListQueue.poll());
		//remove gives an execption if the queue is empty
		System.out.println(linkedListQueue.remove());
		
	}

}
