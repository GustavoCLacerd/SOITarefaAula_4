package view;
import controller.ThreadCalc;

public class Main {
    public static void main(String[] args) throws Exception {
        int j = 0;
        for (int i = 1; i < 7; i++){
            ThreadCalc t = new ThreadCalc (i, j);
            t.start();
            j = j + 1;
        }
    }
}
