package by.epam.intro.finmanager.main;

import by.epam.intro.finmanager.controller.Controller;

public class Main {
	public static void main(String[] args) {
		Controller controller = new Controller();
		String response;

		String request = "authorization login=aaa password=1234";
		response = controller.doAction(request);
		System.out.println(response);

		request = "addTransaction date=05.10.2019 type=Booking.com sum=-600";
		response = controller.doAction(request);
		System.out.println(response);
		
		request = "addTransaction date=05.10.2019 type=Belavia sum=-1600";
		response = controller.doAction(request);
		System.out.println(response);
		
		request = "addTransaction date=10.10.2019 type=Booking.com sum=-600";
		response = controller.doAction(request);
		System.out.println(response);
		
		request = "addTransaction date=15.10.2019 type=Booking.com sum=-600";
		response = controller.doAction(request);
		System.out.println(response);

		request = "findTransaction date=05.10.2019";
		response = controller.doAction(request);
		System.out.println(response);
		
		request = "editTransaction 3 10.10.2019 Booking.com -600 sum=-600 sum=-900";
		response = controller.doAction(request);
		System.out.println(response);
		
		//4 15.10.2019 Booking.com -600
		
		request = "deleteTransaction 4 15.10.2019 Booking.com -600";
		response = controller.doAction(request);
		System.out.println(response);

	}
}