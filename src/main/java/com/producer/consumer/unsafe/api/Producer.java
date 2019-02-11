package com.producer.consumer.unsafe.api;

class Producer implements Runnable{
    Shared shared;
    Producer(){}
    Producer(Shared shared){
           this.shared = shared;
    }
    @Override
    public void run() {
           while(true){
                  shared.produce();
           }
    }
}

