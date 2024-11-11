package pack2;

public class PrimerHilo extends Thread{

    private int x;

    PrimerHilo(int x) {
        this.x = x;
    }

    public void run(){
        for(int i=1 ; i<=x ; i++){
            System.out.println("Hilo " + i);
        }
    }

    public static void main(String[] args) {
        PrimerHilo hilo = new PrimerHilo(10);

        hilo.start();
    }

}
