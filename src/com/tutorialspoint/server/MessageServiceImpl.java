package com.tutorialspoint.server;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.tutorialspoint.client.Message;
import com.tutorialspoint.client.MessageService;

public class MessageServiceImpl extends RemoteServiceServlet implements MessageService {

	private static final long serialVersionUID = 1L;

	public Message getMessage(String input) {
		String messageString = "Hello " + input + "!";
		Message message = new Message();
		message.setMessage(messageString);
		// test
		File file = new File("C:\\TestGWTRPC\\TEST123456.txt");
		try {
			file.createNewFile();
			System.out.println("File Created!!!..." + file.getPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
		//"bash", "-f", new File("scripts/test.sh").getAbsoluteFile()
		ProcessBuilder processBuilder = new ProcessBuilder("java","-jar","\"C:\\TestGWTRPC\\hellotest.jar\"");

		Process process;
		try {
			process = processBuilder.start();
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line = null;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		// test
		return message;
	}
}
