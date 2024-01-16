package tokio.school;

public class Coche {
    private int matricula;
    private int minutos;

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public Coche(int matricula, int minutos){
        super();
        this.matricula = matricula;
        this.minutos = minutos;

    }
}
