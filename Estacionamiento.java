package tokio.school;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class Estacionamiento  {
    private List<Coche> coches = Collections.synchronizedList(new ArrayList<Coche>());
    AtomicBoolean ocupado = new AtomicBoolean(false);
    public boolean estacionarCoche(Coche c){
        if(coches.size() < 50){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                       Thread.sleep(c.getMinutos()*100);
                        while(ocupado.get()) {
                            synchronized (coches) {
                                coches.wait();
                            }
                        }
                        ocupado.set(true);
                        Thread.sleep(100);
                        coches.add(c);
                        ocupado.set(false);
                            synchronized (coches) {
                                coches.notifyAll();}
                                System.out.println("Coche aniadido " + c.getMatricula() + " quedan "+(50 - coches.size() + " disponibles. "));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();


            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(c.getMinutos()*100);
                        while(ocupado.get()) {
                            synchronized (coches) {
                                coches.wait();
                            }
                        }
                        ocupado.set(true);
                        Thread.sleep((100));
                        coches.remove(c);
                        ocupado.set(false);
                        synchronized (coches){
                            coches.notifyAll(); }
                        System.out.println("Coche saliendo " + c.getMatricula() +" quedan "+(50 - coches.size() + " disponibles. "));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
            return true;
        }
        return false;



    }
}
