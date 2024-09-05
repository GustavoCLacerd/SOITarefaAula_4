package controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PingThread extends Thread {
    private String servidor;
    private String nomeServidor;

    public PingThread(String servidor, String nomeServidor) {
        this.servidor = servidor;
        this.nomeServidor = nomeServidor;
    }

    @Override
    public void run() {
        try {
            // Verifica se o sistema operacional é Linux
            String os = System.getProperty("os.name").toLowerCase();
            if (!os.contains("linux")) {
                System.out.println("Esta aplicação só pode ser executada em Linux.");
                return;
            }

            // Executa o comando de ping no Linux
            String command = "ping -4 -c 10 " + servidor;
            Process process = Runtime.getRuntime().exec(command);

            // Lê a saída do comando ping
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            double somaTempos = 0;
            int count = 0;

            while ((line = reader.readLine()) != null) {
                if (line.contains("time=")) {
                    // Extrai o tempo da linha
                    String[] parts = line.split("time=");
                    String tempoStr = parts[1].split(" ")[0];
                    double tempo = Double.parseDouble(tempoStr);
                    somaTempos += tempo;
                    count++;

                    // Exibe o tempo de cada iteração
                    System.out.println(nomeServidor + " - Tempo da iteração " + count + ": " + tempo + " ms");
                }
            }

            // Aguarda o processo finalizar
            process.waitFor();

            // Calcula e exibe o tempo médio
            if (count > 0) {
                double tempoMedio = somaTempos / count;
                System.out.println("Tempo médio de " + nomeServidor + ": " + tempoMedio + " ms");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
