package pack2;

public class SolicitarSuspender {
    private boolean suspender = false;

    public synchronized void set(boolean b) {
        suspender = b;
        notifyAll(); // Notificar cambio de estado
    }

    public synchronized void esperandoParaReanudar() throws InterruptedException {
        while (suspender) {
            wait(); // Espera mientras el hilo está suspendido
        }
    }
}


