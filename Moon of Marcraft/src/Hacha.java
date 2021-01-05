import java.util.Random;

public class Hacha extends Arma{
    private float crítico;

    public Hacha(String nombre, int daño, float crítico, int rango) {
        super(nombre, daño, rango);
        this.crítico=crítico;
    }

    @Override
    public int dañoAtaque() {
        if(golpeCrítico()){
            System.out.println("¡¡Daño Crítico!!");
            return super.getDaño()*2;
        }else {
            return super.getDaño();
        }
    }



    private boolean golpeCrítico(){
        Random rnd=new Random();
        int probabilidad = rnd.nextInt(100);

        if(probabilidad >= crítico){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public String toString() {
        return super.getNombre()+ " {Tipo: Hacha, Daño: " + super.getDaño()
                + ", Probabilidad de daño crítico: " + crítico +"%}";
    }

}
