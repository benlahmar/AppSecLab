package com.example.demo.deseralisation;

import java.io.IOException;
import java.io.Serializable;

public class Command implements Runnable, Serializable {

	   private String command;

	   public Command(String command) {
	       this.command = command;
	   }

	   @Override
	   public void run() {
	       try {
	         Process p = Runtime.getRuntime().exec(command);
	        System.out.println(new String( p.getInputStream().readAllBytes()));
	       } catch (IOException e) {
	           throw new RuntimeException(e);
	       }
	   }
}