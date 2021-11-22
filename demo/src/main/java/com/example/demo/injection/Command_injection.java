package com.example.demo.injection;

import java.util.*; 
import java.io.File;
import java.io.*;

public class Command_injection{ 
public static void main(String[] args){ 
Scanner sc=new Scanner(System.in); 
System.out.println("Enter Username"); 
String user = sc.nextLine();
//toi & ping -n 2 8.8.8.8
String user_path = "c:\\users\\"+user;

File file = new File(user_path);
System.out.println(file.getPath());
try {
    String comm = "cmd.exe /c dir "+user_path;
    Process process = Runtime.getRuntime().exec(comm);
    BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));

    String s = null;
    while ((s = stdInput.readLine()) != null) {
        System.out.println(s);
    }
}
catch (IOException e) {
    System.out.println("Error executing command");
}
}
}