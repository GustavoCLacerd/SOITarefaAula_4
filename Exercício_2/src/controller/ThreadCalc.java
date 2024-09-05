package controller;

public class ThreadCalc extends Thread {
    private int vetor[];
    private int linha;
    public ThreadCalc (int vetor [], int linha){
        this.vetor = vetor; 
        this.linha = linha;
    }

    @Override
    public void run(){
        int soma = 0;
        for (int i = 0; i < 5; i++){
        soma += vetor [i];
        }
        System.out.println ("A soma da linha " + (linha + 1) +" é " +soma);
    }
}
