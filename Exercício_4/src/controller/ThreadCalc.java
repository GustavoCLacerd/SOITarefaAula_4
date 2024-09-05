package controller;
import java.util.Random;

public class ThreadCalc extends Thread {
    private static int[] vt1 = new int[5];
    private static double[] vt2 = new double[5];
    private int sapoId;
    private int posicao;

    public ThreadCalc(int sapoId, int posicao) {
        this.sapoId = sapoId;
        this.posicao = posicao;
    }

    public void run() {
        int distanciaMaxima = 100, distanciaPercorrida = 0;
        Random random = new Random();
        long tempoInicial = System.nanoTime();

        while (distanciaPercorrida < distanciaMaxima) {
            int salto = random.nextInt(100 + 1);
            distanciaPercorrida += salto;
            System.out.println("Sapo " + sapoId + " saltou " + salto + " metros. Total percorrido: " + distanciaPercorrida + " metros.");
        }

        long tempoFinal = System.nanoTime();
        double tempoDecorrido = (tempoFinal - tempoInicial) / Math.pow(10, 9);

        vt1[posicao] = sapoId;
        vt2[posicao] = tempoDecorrido;

        System.out.println("Sapo " + sapoId + " chegou ao final em " + tempoDecorrido + " segundos.");

        synchronized (ThreadCalc.class) {
            if (posicao == 4) { 
                ordenarResultados();
                exibirResultados();
            }
        }
    }

    private static void ordenarResultados() {
        for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 5; j++) {
                if (vt2[i] > vt2[j]) {
                    double auxTempo = vt2[i];
                    vt2[i] = vt2[j];
                    vt2[j] = auxTempo;

                    int auxId = vt1[i];
                    vt1[i] = vt1[j];
                    vt1[j] = auxId;
                }
            }
        }
    }

    private static void exibirResultados() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Posição " + (i + 1) + ": Sapo " + vt1[i] + " com tempo de " + vt2[i] + " segundos.");
        }
    }
}
