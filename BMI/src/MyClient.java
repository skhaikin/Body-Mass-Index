import java.net.*;
import java.io.*;

class MyClient{
public static void main(String args[])throws Exception{
	Socket s = new Socket("localhost",3333);
	DataInputStream din = new DataInputStream(s.getInputStream());
	DataOutputStream dout = new DataOutputStream(s.getOutputStream());
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
	String str = "",str2 = "", strHeight = "", strWeight = "";
	while(!str.equals("stop")){
		
		System.out.print("Write your height in meters (ex 1.80): ");
		strHeight = br.readLine(); 
		
		System.out.print("Write your weight in kilograms (ex: 70.5): ");
		strWeight = br.readLine(); 
		
		dout.writeUTF(strHeight);
		dout.writeUTF(strWeight);
		dout.flush();
		
		System.out.println("Waiting for BMI from server…");
		str2 = din.readUTF();

		System.out.println("Your BMI is: " + str2);
	}
	
	dout.close();
	s.close();
}
} 

