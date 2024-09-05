package view;

import java.util.Random;
import controller.ThreadCalc;

public class Main {
    public static void main (String Args []){
        int [][] matriz = new int [3][5];
        Random m = new Random();

        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 5; j++){
                matriz [i][j] = m.nextInt (21);
            }
            ThreadCalc t = new ThreadCalc (matriz[i], i);
            t.start ();
        }
    }
}