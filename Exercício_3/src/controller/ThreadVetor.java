package controller;

public class ThreadVetor extends Thread {
    private int [] vt;
    private int n;

    public ThreadVetor (int [] vt, int n){
        this.vt = vt;
        this.n = n;
    }
    @Override
	public void run() {
		long tempInicial = System.nanoTime();
		if(n % 2 == 0) {
			for(int i = 0; i < vt.length; i++) {
			}
		}else {
			for(int valor : vt) {
			}
		}
		long tempFinal = System.nanoTime();
		double tempDecorrido = (tempFinal - tempInicial) / Math.pow(10, 9);
        System.out.println("Número: " + n + " | Tempo de execução: " + tempDecorrido + " segundos ");;
	}	
}
