package pack2;
 //este programa crea dos hilos, uno que imprime TIC y otro que imprime TAC. Cada print se imprime cada 0.1 segundos gracias al metodo sleep().

//hay veces que los textos TIC, TAC, TIC, TAC... se imprimen de forma ordenada y hay veces que no, y se intercalan por ejemplo TIC, TAC ,TAC, TIC...
//esto se debe porque depende de como el sistema operativo le asigna tiempo CPU a cada hilo.
public class Actividad2_1{

    public static void main(String[] args) {
        Hilo1 tic = new Hilo1();
        Hilo2 tac = new Hilo2();

        tic.start();
        tac.start();
    }

    static class Hilo1 extends Thread {
        @Override
        public void run() {
            while (true) {
                System.out.println("TIC");
                try {
                    Thread.sleep(300);  //pausa de 0.3 segundos cada print
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Hilo2 extends Thread {
        @Override
        public void run() {
            while (true) {
                System.out.println("TAC");
                try {
                    Thread.sleep(300); //pausa de 0.3 segundos cada print
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }






}
