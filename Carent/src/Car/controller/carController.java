package Car.controller;
import Car.view.*;
import Car.controller.*;

public class carController {
	public static void start() {
		//open Login Window
		Login log=new Login();
		//set the windows until user connect to system
		log.control( true);
		int pos=log.getAcces();
		if(pos==1)System.out.println("Admin");
		else System.out.println("user");
		
		
	}

}
