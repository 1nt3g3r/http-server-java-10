package web;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {
    private WebServerConfig config = new WebServerConfig();

    public WebServerConfig getConfig() {
        return config;
    }

    public void start() {
        try {
            ServerSocket serverSocket = new ServerSocket(config.port);

            while(true) {
                Socket socket = serverSocket.accept();
                new Thread(new ConnectionHandler(socket, config)).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}