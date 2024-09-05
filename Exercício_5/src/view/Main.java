package view;

import controller.PingThread;

public class Main {
    public static void main(String[] args) {
        // Cria e inicia threads para ping nos três servidores
        PingThread uolThread = new PingThread("www.uol.com.br", "UOL");
        PingThread terraThread = new PingThread("www.terra.com.br", "Terra");
        PingThread googleThread = new PingThread("www.google.com.br", "Google");

        uolThread.start();
        terraThread.start();
        googleThread.start();
    }
}