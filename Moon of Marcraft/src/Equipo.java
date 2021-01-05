import java.util.ArrayList;

public class Equipo {
    private Arma arma;
    private Armadura armadura;

    public void equipar(Arma arma){
            this.arma = arma;
    }

    public void equipar(Armadura armadura) {
        this.armadura = armadura;
    }


    public void equipar(Flecha flechas){
        /*Use el instanceof porque si no tenía que crear un método abstracto en Arma que sirviera
        para equipar flechas pero solo lo utilizaría una clase y en las otras iba a queda un método innecesario vacío entonces
        como solo es necesaria en esta instancia diferenciar que tipo de arma es decidí usar instanceof.
         */
        if(arma instanceof Arco){
            ((Arco) arma).equiparFlechas(flechas);
        }
    }

    public void desequipar(Arma arma, String nom) throws ExcepcionNoEquipado{

        if(this.arma == arma){
        arma=null;
        }else{
            throw new ExcepcionNoEquipado(nom+" no tiene equipada esa arma.");
        }
    }

    public void desequipar(Armadura armadura, String nom) throws ExcepcionNoEquipado {
        if(this.armadura==armadura){
           armadura=null;
        }else{
            throw new ExcepcionNoEquipado(nom+" no tiene equipada esa armadura.");
        }
    }

    public int devolverAtaque(String nom){
        if(this.arma!=null){
            return arma.dañoAtaque();
        }else{
            System.err.println(nom + " no tiene ningún arma equipada.");
            return 0;
        }

    }

    public int devolverDefensa(){
        return armadura.getDefensa();
    }

    public int devolverRango(){
        return arma.getRango();
    }

    public void mostrarEquipo(String nom){
        System.out.println("Equipo de "+nom+":\n"+arma.toString()+"\n"+armadura.toString()+"\n");

    }

}
