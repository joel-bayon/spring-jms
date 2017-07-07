package fr.cogitec;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public  class App {
	static int i = 1;
		
    public static void main(String[] args) throws Exception {
    	ConfigurableApplicationContext factory = new 
						ClassPathXmlApplicationContext("context.xml");
    	HelloWorldProducer producer = 
						factory.getBean(HelloWorldProducer.class);
    	System.out.println("thread :" + Thread.currentThread().getName() 
							   + " *** démmarage de l'appli ***");
        thread(producer, false);
        thread(producer, false);
		Thread.sleep(1000);
		System.out.println("thread :" + Thread.currentThread().getName() 
							   + " *** arrêt de l'appli ***");
        factory.close();              
    }
 
    public static void thread(Runnable runnable, boolean daemon) {
        Thread brokerThread = new Thread(runnable, "producer_"+i++);
        brokerThread.setDaemon(daemon);
        brokerThread.start(); 
    }
}

