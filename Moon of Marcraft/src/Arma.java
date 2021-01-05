public abstract class Arma extends Item{
    private int daño;
    private int rango;

    public Arma(String nombre, int daño, int rango) {
        super(nombre);
        this.daño = daño;
        this.rango=rango;
    }

    public abstract int dañoAtaque();

    public int getDaño() {
        return daño;
    }

    protected void setDaño(int daño) {
        this.daño = daño;
    }

    public int getRango() {
        return rango;
    }

    protected void setRango(int rango) {
        this.rango = rango;
    }
}
