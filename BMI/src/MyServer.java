/**********************************************

Workshop #5

Course: JAC444

Last Name: Khaikin

First Name: Sergey


Section:<section name>

This assignment represents my own work in accordance with Seneca Academic Policy.

Signature
Sergey Khaikin

Date: 2018-04-18

**********************************************/


import java.util.*;
import java.net.*;
import java.io.*;

class MyServer{
public static void main(String args[])throws Exception{
	ServerSocket ss = new ServerSocket(3333);
	System.out.println("BMICalculatorServer started at " + new Date());
	Socket s = ss.accept();
	DataInputStream din = new DataInputStream(s.getInputStream());
	DataOutputStream dout = new DataOutputStream(s.getOutputStream());
	 
	String str = "",str2="";
	while(!str.equals("stop")){
		
		System.out.println("Connected to a client at started at " + new Date());
		System.out.println("Waiting for height and weight from client:");
		
		str = din.readUTF();		
		double height = Double.parseDouble( str.replace(",",".") );
		
		str = din.readUTF();
		double weight = Double.parseDouble( str.replace(",",".") );
		
		System.out.println("Height is: " + height);
		System.out.println("Weight is: " + weight);
		
		double BMI = weight / (height * height);
		
		
		if(BMI >= 30)
			str2 = "Obese";
		else if(BMI >= 25)
			str2 = "Overweight";
		else if(BMI >= 18.5)
			str2 = "Normal";
		else
			str2 = "UnderWeight";
		

		System.out.println("Calculating BMI...:");
		dout.writeUTF(str2);
		dout.flush();
	}
	din.close();
	s.close();
	ss.close();
}
} 