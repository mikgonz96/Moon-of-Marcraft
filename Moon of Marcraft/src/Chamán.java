import java.util.Random;

public class Chamán extends Enemigo{
    private int curación;
    public Chamán(int x, int y) {
        super("Chamán", 90,x,y,15,90);
    }

    public void curar(Enemigo e) {
        Random rnd=new Random();
        curación=rnd.nextInt(30)+1;
        e.curarVida(curación);
        System.out.println(super.getNombre()+" curó a "+e.getNombre()+". Ahora "+e.getNombre()+" tiene "+
                e.getVida()+" pts de vida.");
    }
}
