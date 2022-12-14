package edu.javacourse.net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(25225);

        Map<String, Greetable> handlers = loadHandlers();
        System.out.println("server is started");
        while (true) {
            Socket client = socket.accept();
            new SimpleServer(client, handlers).start();
        }
    }

    private static Map<String, Greetable> loadHandlers() {
        Map<String, Greetable> result = new HashMap<>();
            try (FileInputStream is = new FileInputStream(
                    "F:\\1.Study\\Java\\1. Java_core\\projects\\ext-system\\network-tcp\\server\\src\\main\\resources\\server.properties")
            ) {
                Properties properties = new Properties();
                properties.load(is);

                for (Object command : properties.keySet()) {
                    String className = properties.getProperty(command.toString());
                    Class<Greetable> c = (Class<Greetable>) Class.forName(className);

                    Greetable handler = c.getConstructor().newInstance();
                    result.put(command.toString(), handler);
                }
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException();
            }
        return result;
    }
}

class SimpleServer extends Thread {
    private Socket client;
    private Map<String, Greetable> handlers;

    public SimpleServer(Socket client, Map<String, Greetable> handlers) {
        this.client = client;
        this.handlers = handlers;
    }

    @Override
    public void run() {
        handleRequest();
    }

    private void handleRequest() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

            String request = bufferedReader.readLine();
            String[] lines = request.split("\\s+");
            String command = lines[0];
            String userName = lines[1];
            System.out.println("server got string1 : " + command);
            System.out.println("server got string2 : " + userName);

            String response = buildResponse(command, userName);
            bufferedWriter.write(response);
            bufferedWriter.newLine();
            bufferedWriter.flush();

            bufferedWriter.close();
            bufferedReader.close();

            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String buildResponse(String command, String userName) throws IOException {
        Greetable handler = handlers.get(command);
        if (handler != null) {
            return handler.buildResponse(userName);
        }
        return "Hello, " + userName;
    }
}
