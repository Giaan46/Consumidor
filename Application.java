package tokio.school;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Application {
    public static void main (String []args){
        Estacionamiento estacionamiento = new Estacionamiento();
        while (true){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (!estacionamiento.estacionarCoche(new Coche(new Random().nextInt(9000) + 1000, new Random(1).nextInt(120)))) ;
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

     }

    }
}
