package pack2;

public class Main2_6{

    public static void main(String[] args) {
        System.out.println("Prueba con EjemploHiloPrioridad1");
        EjemploHiloPrioridad1.ejecutarPrueba();

        System.out.println("\nPrueba con EjemploHiloPrioridad2");
        EjemploHiloPrioridad2 h1 = new EjemploHiloPrioridad2("Uno");
        EjemploHiloPrioridad2 h2 = new EjemploHiloPrioridad2("Dos");
        EjemploHiloPrioridad2 h3 = new EjemploHiloPrioridad2("Tres");
        EjemploHiloPrioridad2 h4 = new EjemploHiloPrioridad2("Cuatro");
        EjemploHiloPrioridad2 h5 = new EjemploHiloPrioridad2("Cinco");

        h1.setPriority(Thread.MIN_PRIORITY);
        h2.setPriority(3);
        h3.setPriority(Thread.NORM_PRIORITY);
        h4.setPriority(7);
        h5.setPriority(Thread.MAX_PRIORITY);

        h5.start();
        h3.start();
        h1.start();
        h4.start();
        h2.start();
    }
}
