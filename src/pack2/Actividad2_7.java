package pack2;

public class Actividad2_7 {

    private static int contador = 0;

    class HiloContador extends Thread {
        public HiloContador(String nombre, int c){
            setName(nombre);
            contador = c;
        }
        public void run(){
            for(int i = 0; i < 5000; i++){
                contador++;
            }
        }
    }


}
