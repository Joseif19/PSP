package pack2.Actividad2_9;

public class Consumidor extends Thread {

    private Cola cola;
    private int n;

    public Consumidor(Cola c, int n){
        cola = c;
        this.n = n;
    }

    public void run(){
        for(int i = 0; i < 5; i++){
            cola.put(i);
            System.out.println(i + "=>Consumidor: " + n + ", consume: " + i);
            try{
                sleep(100);
            }catch(InterruptedException e){

            }
        }
    }

}
