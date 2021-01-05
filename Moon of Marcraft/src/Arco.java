public class Arco extends Arma {
    private Flecha flechas;
    private int cantidadFlechas;

    public Arco(String nombre, int daño, int rango) {
        super(nombre, daño, rango);
    }

    public void equiparFlechas(Flecha flechas){
        this.flechas= flechas;
        cantidadFlechas=flechas.getCantidad();
        super.setRango(flechas.getRango());
    }

    @Override
    public int dañoAtaque(){
       if(flechas!=null && flechas.getCantidad()>0){
           super.setDaño(super.getDaño()+ flechas.getDaño());
           restarFlecha();
           return super.getDaño();


       }else{

           System.out.println("El Arco no tiene flechas.");
           return 0;
       }

    }

    public void restarFlecha() {
        cantidadFlechas--;
    }

    public String toString() {
        if(flechas==null) {
            return super.getNombre() + " {Tipo: Arco, Daño: " + dañoAtaque() + " }";
        }else{
            return super.getNombre() + " {Tipo: Arco, Tipo de Flecha: "+flechas.getNombre()+", Daño: " + dañoAtaque() + ", Flechas restantes: "+(cantidadFlechas+1)+"}";
        }
    }
}
