package com.java.thread;

public class PrintOddEvenMain {
	
	public static void main(String[] args) {
 
		OddEvenRunnable oddRunnable = new OddEvenRunnable(1);
		OddEvenRunnable evenRunnable = new OddEvenRunnable(2);
		OddEvenRunnable evenRunnable1 = new OddEvenRunnable(3);
		OddEvenRunnable evenRunnable2 = new OddEvenRunnable(4);
		OddEvenRunnable evenRunnable3 = new OddEvenRunnable(0);
 
		Thread t1 = new Thread(oddRunnable,"1");
		Thread t2 = new Thread(evenRunnable,"2");
		Thread t3 = new Thread(evenRunnable1,"3");
		Thread t4 = new Thread(evenRunnable2,"3");
		Thread t5 = new Thread(evenRunnable3,"3");
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
 
	}
}
