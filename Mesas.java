package tokio.school;

public class Mesas {
    private int comensales;
    private int minutos;

    public Mesas(int comensales, int minutos) {
        this.comensales = comensales;
        this.minutos = minutos;
    }

    public int getComensales() {
        return comensales;
    }

    public void setComensales(int comensales) {
        this.comensales = comensales;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }
}
