public class Espada extends Arma{

    public Espada(String nombre, int daño, int rango) {
        super(nombre, daño, rango);
    }

    @Override
    public int dañoAtaque() {

        return super.getDaño();
    }

    @Override
    public String toString() {
        return super.getNombre()+" {Tipo: Espada, Daño: "+dañoAtaque()+" }";
    }
}
