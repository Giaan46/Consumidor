package tokio.school;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class Restaurante {
    private List<Mesas> mesas = Collections.synchronizedList(new ArrayList<Mesas>());
    AtomicBoolean ocupado = new AtomicBoolean(false);
    public boolean MesasOcupadas(Mesas m){
        if(mesas.size() < 50){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(m.getMinutos()*100);
                        while(ocupado.get()) {
                            synchronized (mesas) {
                                mesas.wait();
                            }
                        }
                        ocupado.set(true);
                        Thread.sleep(100);
                        mesas.add(m);
                        ocupado.set(false);
                        synchronized (mesas) {
                            mesas.notifyAll();}
                        System.out.println("clientes entrando !! mesa de "+m.getComensales() +" comensales" + " quedan "+(50 - mesas.size() + " disponibles. "));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();


            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(m.getMinutos()*100);
                        while(ocupado.get()) {
                            synchronized (mesas) {
                                mesas.wait();
                            }
                        }
                        ocupado.set(true);
                        Thread.sleep((100));
                        mesas.remove(m);
                        ocupado.set(false);
                        synchronized (mesas){
                            mesas.notifyAll(); }
                        System.out.println("clientes entrando!! mesa de "+m.getComensales() +" comensales, quedan "+(50 - mesas.size() + " disponibles. "));
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
