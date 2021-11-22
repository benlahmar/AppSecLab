package com.example.demo.deseralisation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ValueObject implements Serializable {

	   private String value;
	   private String sideEffect;

	   public ValueObject() {
	       this("empty");
	   }

	   public ValueObject(String value) {
	       this.value = value;
	       this.sideEffect = java.time.LocalTime.now().toString();
	   }
	
	   public static void main(String[] args) throws IOException  {
		   
		   		//lire();
		   		Command cmd=new Command("cmd /c dir");
		   		cmd.run();
		   		Gadget g=new Gadget(cmd);
		   		//ecrire(g);
		   		
		   		FileInputStream fileIn;
				try {
					fileIn = new FileInputStream("ValueObject.ser");
					ObjectInputStream in = new ObjectInputStream(fileIn);
					Gadget vo2 = (Gadget) in.readObject();
					
					System.out.println(vo2.toString());
					in.close();
					fileIn.close();
				} catch (IOException | ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

	
	
	   }
	   
	   public static void lire()
	   {
		   FileInputStream fileIn;
		try {
			fileIn = new FileInputStream("ValueObject.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			ValueObject vo2 = (ValueObject) in.readObject();
			System.out.println(vo2.toString());
			in.close();
			fileIn.close();
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	   }
	   
	   public static void ecrire(Object o)
	   {
		   //ValueObject vo1 = new ValueObject("Hi");
			FileOutputStream fileOut;
			try {
				fileOut = new FileOutputStream("ValueObject.ser");
				ObjectOutputStream out = new ObjectOutputStream(fileOut);
				out.writeObject(o);
				out.close();
				fileOut.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	   }

	@Override
	public String toString() {
		return "ValueObject [value=" + value + ", sideEffect=" + sideEffect + "]";
	}
	   
	   
}