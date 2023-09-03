package com.example.demo.socket.archivos;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	private final Integer PORT = 13;
	
	public Server() {
		Socket clientSocket;
		try {
			ServerSocket serverSocket = new ServerSocket(PORT);
			while(true) {
				System.out.println("--------1 Iniciando serverSocket --------------");
				System.out.println("--------2 A la espera del clientSocket --------");
				clientSocket = serverSocket.accept();
				System.out.println("--------3 Llegó el clientSocket ---------------");
				
				File fileDestino = new File("C:/server/Cabana.png");
				FileOutputStream fos = new FileOutputStream(fileDestino);
				DataInputStream entrada = new DataInputStream(clientSocket.getInputStream());
				
				int byteLeidos;
				while( (byteLeidos = entrada.read()) != -1) {
					fos.write(byteLeidos);
				}
				
				fos.close();
				entrada.close();
				
				System.out.println("--------4 Finaliza la atención clientSocket ---");
				clientSocket.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Server();
	}
	
}