public class Mago extends Enemigo{
    public Mago(int x, int y ) {
        super("Mago", 80,x,y,25,80);
    }

    public void ataque(Personaje pj,EstadoEspecial estadoEspecial) {
        pj.setEstadoEspecial(estadoEspecial);
        System.out.println("¡"+super.getNombre()+" hechizó a "+pj.getNombre()+"!");

    }
}
