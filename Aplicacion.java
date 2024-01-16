package tokio.school;

import java.util.Random;

public class Aplicacion {
    public static void main(String[] args) {
        Restaurante restaurante = new Restaurante();
        while (true) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (!restaurante.MesasOcupadas(new Mesas(new Random().nextInt(20) + 10, new Random(1).nextInt(30))))
                        ;
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}