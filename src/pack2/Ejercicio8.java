package pack2;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Ejercicio8 extends Application {

    private MyHilo hilo1;
    private MyHilo hilo2;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("EJECUTAR, SUSPENDER Y REANUDAR HILOS");

        // Botones y etiquetas
        Button btnComenzar = new Button("Comenzar Proceso");
        Button btnFinalizar = new Button("Finalizar Proceso");
        Button btnReanudar1 = new Button("Reanudar");
        Button btnSuspender1 = new Button("Suspender");
        Button btnReanudar2 = new Button("Reanudar");
        Button btnSuspender2 = new Button("Suspender");

        Label labelHilo1 = new Label("HILO 1");
        Label labelHilo2 = new Label("HILO 2");
        Label estadoHilo1 = new Label("Inactivo");
        Label estadoHilo2 = new Label("Inactivo");
        Label contadorHilo1 = new Label("0");
        Label contadorHilo2 = new Label("0");

        // Layout
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        grid.add(btnComenzar, 1, 0);
        grid.add(btnFinalizar, 2, 0);

        grid.add(labelHilo1, 0, 1);
        grid.add(btnReanudar1, 1, 1);
        grid.add(btnSuspender1, 2, 1);
        grid.add(estadoHilo1, 3, 1);
        grid.add(contadorHilo1, 4, 1); // Mostrar contador de Hilo 1

        grid.add(labelHilo2, 0, 2);
        grid.add(btnReanudar2, 1, 2);
        grid.add(btnSuspender2, 2, 2);
        grid.add(estadoHilo2, 3, 2);
        grid.add(contadorHilo2, 4, 2); // Mostrar contador de Hilo 2

        // Evento para comenzar proceso
        btnComenzar.setOnAction(e -> {
            if (hilo1 == null && hilo2 == null) {
                hilo1 = new MyHilo("Hilo1", 500, estadoHilo1, contadorHilo1);
                hilo2 = new MyHilo("Hilo2", 500, estadoHilo2, contadorHilo2);
                hilo1.start();
                hilo2.start();
                estadoHilo1.setText("Corriendo");
                estadoHilo2.setText("Corriendo");
                btnComenzar.setDisable(true); // Desactivar botón de comenzar
            }
        });

        // Evento para suspender y reanudar Hilo1
        btnSuspender1.setOnAction(e -> {
            if (hilo1 != null) {
                hilo1.Suspende();
                estadoHilo1.setText("Suspendido");
            }
        });

        btnReanudar1.setOnAction(e -> {
            if (hilo1 != null) {
                hilo1.Reanuda();
                estadoHilo1.setText("Corriendo");
            }
        });

        // Evento para suspender y reanudar Hilo2
        btnSuspender2.setOnAction(e -> {
            if (hilo2 != null) {
                hilo2.Suspende();
                estadoHilo2.setText("Suspendido");
            }
        });

        btnReanudar2.setOnAction(e -> {
            if (hilo2 != null) {
                hilo2.Reanuda();
                estadoHilo2.setText("Corriendo");
            }
        });

        // Evento para finalizar proceso
        btnFinalizar.setOnAction(e -> {
            if (hilo1 != null) {
                hilo1.interrupt();
                System.out.println("Valor final del contador de Hilo1: " + hilo1.getContador());
            }
            if (hilo2 != null) {
                hilo2.interrupt();
                System.out.println("Valor final del contador de Hilo2: " + hilo2.getContador());
            }
            primaryStage.close(); // Cerrar ventana
        });

        // Escena y mostrar ventana
        Scene scene = new Scene(grid, 500, 200);
        primaryStage.setScene(scene);
        primaryStage.setOnCloseRequest(e -> btnFinalizar.fire());
        primaryStage.show();
    }
}

