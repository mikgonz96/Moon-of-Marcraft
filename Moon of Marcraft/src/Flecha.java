public class Flecha extends Item {
    private int daño;
    private int cantidad;
    private int rango;

    public Flecha(String nombre, int daño, int cant, int rango) {
        super(nombre);
        this.daño=daño;
        this.cantidad=cant;
        this.rango=rango;
    }

    public int getDaño() {
        return daño;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getRango() {
        return rango;
    }

    @Override
    public String toString() {
        return super.getNombre()+" {Tipo: Flecha, Daño: " + daño +", Cantidad:" + cantidad +'}';
    }
}
