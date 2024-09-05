package view;
import controller.ThreadVetor;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws Exception {
    int vt [] = new int [1000];
    
    Random r = new Random();

    for (int i = 0; i < 1000; i++){
        vt [i] = r.nextInt (101);
    }

        ThreadVetor t1 = new ThreadVetor(vt, 1);
		ThreadVetor t2 = new ThreadVetor(vt, 2);
		t1.start();
		t2.start();

    }
}
