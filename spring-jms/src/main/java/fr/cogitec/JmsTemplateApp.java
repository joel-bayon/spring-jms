package fr.cogitec;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public  class JmsTemplateApp {
		
    public static void main(String[] args) throws Exception {
    	ConfigurableApplicationContext factory = new 
						ClassPathXmlApplicationContext("spring.jms.xml");
    	JmsProducer producer = 
						factory.getBean(JmsProducer.class);
    	JmsConsumer consumer = 
				factory.getBean(JmsConsumer.class);
    	producer.send("Voici un beau message ... !");
    	System.out.println("**** received messsage : " + consumer.receive());
        factory.close();              
    }
}

