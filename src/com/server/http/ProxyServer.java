package com.server.http;

import java.net.ServerSocket;
import java.net.Socket;

public final class ProxyServer {

	public static void main(String argv[]) throws Exception {
		int port = 80;
		ServerSocket WebSocket = new ServerSocket(port);

		while (true) {
			// Listen for a TCP connection request.
			Socket connectionSocket = WebSocket.accept();
			// Construct object to process HTTP request message
			HttpRequest request = new HttpRequest(connectionSocket);

			Thread thread = new Thread(request);
			thread.start(); // start thread
		}
	}
}