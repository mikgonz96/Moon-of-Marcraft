public class Comida extends Item{
    private int cura;
    private int cantUsos;

    public Comida(String nom, int cura, int usos){
        super(nom);
        this.cura=cura;
        this.cantUsos=usos;
    }

    public int getCura() {
        return cura;
    }

    public int getCantUsos() {
        return cantUsos;
    }

    public void setCantUsos(int cantUsos) {
        this.cantUsos = cantUsos;
    }

    @Override
    public String toString() {
        return super.getNombre()+" {Tipo: Comida, "+
                "Cura: " + cura + " pts de vida, Cantidad de usos disponible: "+cantUsos+
                '}';
    }

}
