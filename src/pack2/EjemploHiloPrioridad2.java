package pack2;

public class EjemploHiloPrioridad2 extends Thread{

    EjemploHiloPrioridad2(String nombre){
        this.setName(nombre);
    }

    public void run(){
        System.out.println("Ejecutando [" + getName() + "]");
        for(int i=1 ; i<=5 ; i++){
            System.out.println("\t("+getName()+": " + i +")");
        }
    }

    public static void main(String[] args) {
        EjemploHiloPrioridad2 h1 = new EjemploHiloPrioridad2("Uno");
        EjemploHiloPrioridad2 h2 = new EjemploHiloPrioridad2("Dos");
        EjemploHiloPrioridad2 h3 = new EjemploHiloPrioridad2("Tres");
        EjemploHiloPrioridad2 h4 = new EjemploHiloPrioridad2("Cuatro");
        EjemploHiloPrioridad2 h5 = new EjemploHiloPrioridad2("Cinco");

        h1.setPriority(Thread.MIN_PRIORITY);
        h1.setPriority(3);
        h1.setPriority(Thread.NORM_PRIORITY);
        h1.setPriority(7);
        h1.setPriority(Thread.MAX_PRIORITY);

        h1.start();
        h2.start();
        h3.start();
        h4.start();
        h5.start();
    }

}
