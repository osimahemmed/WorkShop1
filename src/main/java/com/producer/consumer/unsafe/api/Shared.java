package com.producer.consumer.unsafe.api;

import sun.misc.Unsafe;

public class Shared {

	volatile int i;
	volatile Unsafe unsafe;

	static Object monitor;
	volatile boolean isProducing;
	volatile boolean isProducerWaiting;
	volatile boolean isConsumerWaiting;

	@SuppressWarnings("deprecation")
	public int produce() {
		try {
			unsafe.monitorEnter(monitor);
			System.out.println("producer acquired the lock");
			while (!isProducing) {
				isProducerWaiting = true;
				System.out.println("producer: isconsumerwaiting:"
						+ isConsumerWaiting + ", isproducerwaiting:"
						+ isProducerWaiting);
				if (isConsumerWaiting) {
					unsafe.unpark(monitor);
				}
				// unsafe.monitorExit(monitor);
				if (isProducerWaiting) {
					unsafe.monitorExit(monitor);
					unsafe.park(false, 0);
				}

				isProducerWaiting = false;
				// unsafe.monitorEnter(monitor);
			}
			i++;
			System.out.println("Producing :" + i);
			/*
			 * if(!isProducing){ unsafe.unpark(monitor); }
			 */
			unsafe.monitorExit(monitor);
			System.out.println("Producer released lock");
			isProducing = false;
			// isConsumerWaiting = false;
			Thread.sleep(1000);
			return i;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}

	}

	public void consume(){
		try {
			unsafe.monitorEnter(monitor);
			System.out.println("Consumer acquired lock");
			while(isProducing) {
				System.out.println("consumer waiting");
				isConsumerWaiting = true;
				System.out.println("consumer: isconsumerwaiting:"+isConsumerWaiting+", isproducerwaiting:"+isProducerWaiting);
				if(isProducerWaiting){
					unsafe.unpark(monitor);
				}
				//unsafe.monitorExit(monitor);
				if(isConsumerWaiting){
					unsafe.monitorExit(monitor);
					unsafe.park(false, 0);
				}

				isConsumerWaiting = false;
				//unsafe.monitorEnter(monitor);
			}
			System.out.println("Consuming :"+i);
			/*if(isProducing){
                            unsafe.unpark(monitor);
                     }*/
			unsafe.monitorExit(monitor);
			isProducing = true;
			//isProducerWaiting = false;
			System.out.println("Consumer released lock");
		}catch(Exception e){
			e.printStackTrace();
		}
	}


}
