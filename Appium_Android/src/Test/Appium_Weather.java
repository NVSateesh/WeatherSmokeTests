package Test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;

public class Appium_Weather {

       
    public void startAppiumServer() throws IOException, InterruptedException {  
	
	Process p =  Runtime.getRuntime().exec("cmd /c node.exe", null, new File("C:\\Program Files (x86)\\Appium"));
	Process q =  Runtime.getRuntime().exec("cmd /c appium.js", null, new File("C:/Program Files (x86)/Appium/node_modules/appium/lib/"));
	CommandLine command = new CommandLine("cmd.exe");
	command.addArgument("--address", false);  
	    command.addArgument("127.0.0.1");  
	    command.addArgument("--port", false);  
	    command.addArgument("4723");  
	    command.addArgument("--full-reset", false);
	
	      
	    
//	    command.addArgument("cmd.exe /C C:\\Program Files (x86)\\Appium\\node.exe");  
	    /*command.addArgument("C:/Program Files (x86)/Appium/node.exe");   //c:/Appium/node.exe
	    command.addArgument("C:/Program Files (x86)/Appium/node_modules/appium/lib/appium.js");  //c:/Appium/node_modules/appium/lib/appium.js 
	    command.addArgument("--address", false);  
	    command.addArgument("127.0.0.1");  
	    command.addArgument("--port", false);  
	    command.addArgument("4723");  
	    command.addArgument("--full-reset", false);  */

	  //command.addArgument("C:/Program Files (x86)/Appium/node.exe C:/Program Files (x86)/Appium/node_modules/appium/lib/appium.js --address 127.0.0.1 --chromedriver-port 9516 --bootstrap-port 4725 --selendroid-port 8082 --no-reset --local-timezone");
	   // command.addArgument("C:/Appium/node.exe C:/Appium/node_modules/appium/bin/Appium.js --address 127.0.0.1 --chromedriver-port 9516 --bootstrap-port 4725 --selendroid-port 8082 --no-reset --local-timezone");
	    
	    DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();  
	    DefaultExecutor executor = new DefaultExecutor();  
	    executor.setExitValue(1);  
	    //executor.execute(command, resultHandler);  
	  
	}


	public  void stopAppiumServer() throws IOException {  
	    CommandLine command = new CommandLine("cmd");  
	    command.addArgument("/c");  
	    command.addArgument("Taskkill /F /IM node.exe");  
	  
	    DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();  
	    DefaultExecutor executor = new DefaultExecutor();  
	    executor.setExitValue(1);  
	    executor.execute(command, resultHandler);  
	     
	}

	public static void main(String as[]) throws IOException, InterruptedException, Exception
	{
	    Appium_Weather aps = new Appium_Weather();
	    Thread.sleep(5000);
	    System.out.println("Starting Server...");
	    Thread.sleep(5000);
	   
	    aps.startAppiumServer();
	    Thread.sleep(5000);
	    System.out.println("Server Started....");
	   Thread.sleep(5000);
	  
	 /*  System.out.println("Stopping Server");
	    Thread.sleep(5000);
	   
	    aps.stopAppiumServer();
	    Thread.sleep(5000);
	    System.out.println("Server Stopped");*/
	}



}
