package com.producer.consumer.unsafe.api;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

public class ProducerConsumerDemo {
    public static void main(String ...s){
           //System.out.println("Start");
           Unsafe unsafe = getUnsafe();
           Object lock = new Object();
           Shared shared = new Shared();
           shared.monitor = lock;
           shared.isProducing = true;
           shared.unsafe = unsafe;
           //shared.isProducerWaiting = false;
           //shared.isConsumerWaiting = false;
           
           Thread prod = new Thread(new Producer(shared));
           Thread cons = new Thread(new Consumer(shared));
           
           prod.start();
           cons.start();
           
           //System.out.println("end");
           
    }

    /*private static void method1() {
           Object lock = new Object();
           Shared shared = new Shared();
           shared.monitor = lock;
           shared.isProducing = true;
           
           Thread prod = new Thread(new Producer(shared));
           Thread cons = new Thread(new Consumer(shared));
           
           prod.start();
           cons.start();
    }*/
    private static Unsafe getUnsafe() {
            try {

                Field unsafeField = Unsafe.class.getDeclaredField("theUnsafe");
                unsafeField.setAccessible(true);
                return (Unsafe) unsafeField.get(null);

            } catch (Exception e) {
                e.printStackTrace();
                return null;
            } 
        }

}

