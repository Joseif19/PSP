package pack2;

import javafx.application.Platform;
import javafx.scene.control.Label;

public class MyHilo extends Thread {
    private int contador = 0;
    private SolicitarSuspender suspender = new SolicitarSuspender();
    private final int sleepTime;
    private final Label estadoLabel;
    private final Label contadorLabel;

    public MyHilo(String nombre, int sleepTime, Label estadoLabel, Label contadorLabel) {
        super(nombre);
        this.sleepTime = sleepTime;
        this.estadoLabel = estadoLabel;
        this.contadorLabel = contadorLabel;
    }

    public void Suspende() {
        suspender.set(true);
    }

    public void Reanuda() {
        suspender.set(false);
    }

    public int getContador() {
        return contador;
    }

    public void run() {
        try {
            while (!isInterrupted()) {
                contador++;
                Platform.runLater(() -> contadorLabel.setText(String.valueOf(contador))); // Actualizar contador en la GUI
                System.out.println(getName() + " - Contador: " + contador);
                suspender.esperandoParaReanudar(); // Suspender si es necesario
                Thread.sleep(sleepTime); // Pausa para visualizar el incremento del contador
            }
        } catch (InterruptedException e) {
            System.out.println(getName() + " interrumpido.");
        }
        System.out.println(getName() + " finalizado.");
        Platform.runLater(() -> estadoLabel.setText("Finalizado"));
    }
}


