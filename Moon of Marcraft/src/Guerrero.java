public class Guerrero extends Enemigo{
    private int ataque=30;
    private int dañoReal;

    public Guerrero( int x, int y) {
        super("Guerrero", 130,x,y, 6,130);
    }

    private int dañoRealAtaque(boolean v) {
        if(v && super.getEstado()==Estado.Herido){
            return  ataque/2;
        }else {
            return ataque;
        }
    }

    public void ataque(Personaje pj) {

        try{
            if(pj.getEstado() != Estado.Muerto && calculaRango(pj.getX(),pj.getY())){
                int dañoReal = dañoRealAtaque(verificarVida())-pj.getDefensa();

                if (dañoReal >= 0) {
                    pj.setVida(dañoReal);
                    System.out.println(super.getNombre() + " atacó a " + pj.getNombre() + ". Ahora " + pj.getNombre() + " tiene " + pj.getVida() + " pts. de vida.\n");
                } else {
                    System.out.println(super.getNombre() + " atacó a " + pj.getNombre() + " pero falló. " + pj.getNombre() + " tiene " + pj.getVida() + " pts. de vida.\n");
                }
            }else {
                System.err.println(pj.getNombre() + " ya está muerto.");
            }
        }catch (ExcepcionMuerto | ExcepcionRango e){
            System.err.println(e);
        }

    }


}
