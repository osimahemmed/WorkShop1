package com.java.thread;

public class OddEvenRunnable implements Runnable{
	 
	public int PRINT_NUMBERS_UPTO = 10;
	static int  number = 1;
	int remainder;
	static Object lock = new Object();
 
	OddEvenRunnable(int remainder)
	{
		this.remainder=remainder;
	}
 
	@Override
	public void run() {
		while (number < PRINT_NUMBERS_UPTO) {
			synchronized (lock) {
				while (number % 2 != remainder) { // wait for numbers other than remainder
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(number + " ");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				number++;
				lock.notifyAll();
			}
		}
	}
}
