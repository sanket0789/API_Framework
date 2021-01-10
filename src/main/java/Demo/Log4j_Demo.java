package Demo;

import org.apache.logging.log4j.Logger;

public class Log4j_Demo {

	
	static Logger logger = org.apache.logging.log4j.LogManager.getLogger(Log4j_Demo.class);
	
	
	public static void main(String[] args) {

		System.out.println("\n Hello World !  \n ");
		
		logger.info("This is information Message");
		logger.error("This is an Error message");
		logger.warn("This is warning Message");
		logger.fatal("This is fatel error");
		logger.trace("This is trace level");
		
		System.out.println("\n Completed");
		
	
	}

}
