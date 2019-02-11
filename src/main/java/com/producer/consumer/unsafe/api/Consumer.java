package com.producer.consumer.unsafe.api;

class Consumer implements Runnable{
    Shared shared;
    Consumer(){}
    Consumer(Shared shared){
           this.shared = shared;
    }
    @Override
    public void run() {
           while(true){
                  shared.consume();
           }
    }
    
}

