package view;

import controller.ThreadId;

public class Principal {
    public static void main (String Args []){
        for (int i = 0; i < 5; i++){
            ThreadId t = new ThreadId ();
            t.start ();
        }
    }
}
