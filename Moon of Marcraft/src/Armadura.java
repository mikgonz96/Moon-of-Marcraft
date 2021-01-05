public class Armadura extends Item{
    private int defensa;

    public Armadura(String nombre, int defensa) {
        super(nombre);
        this.defensa=defensa;
    }

    public int getDefensa() {
        return defensa;
    }

    @Override
    public String toString() {
        return super.getNombre()+" {Tipo: Armadura, Defensa: "+defensa+"}";
    }
}
