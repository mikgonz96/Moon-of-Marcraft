import java.awt.*;

public class Personaje {
    private String nombre;
    private int vida;
    private int defensa;
    private int ataque;
    private Estado estado;
    private EstadoEspecial estadoEspecial;
    private Inventario inventario;
    private Equipo equipo;
    private int x;
    private int y;


    public Personaje(String nombre,int x, int y) {
        this.nombre = nombre;
        this.vida = 100;
        this.defensa = 0;
        this.ataque = 0;
        definirEstado();
        this.estadoEspecial=EstadoEspecial.Normal;
        this.inventario = new Inventario();
        this.equipo = new Equipo();
        this.x=x;
        this.y=y;

    }


        /*Información y actualización de Personajes*/
    private void definirEstado() {
        if (vida > 50) {
            estado = Estado.Vivo;
        } else if (vida <= 50 && vida > 0) {
            estado = Estado.Herido;
        } else if (vida == 0) {
            estado = Estado.Muerto;
        }
    }

    public void informaciónPersonaje() {
        definirEstado();
        System.out.println(nombre +
                "\nVida: " + vida +
                "\nEstado: " + estado +
                "\nDefensa: " + defensa +
                "\nAtaque: " + ataque + "\n");
    }

    private boolean verificarVida() throws ExcepcionMuerto{

        if(estado!=Estado.Muerto){
            return true;
        }else{
            throw new ExcepcionMuerto(nombre+" está muerto por lo tanto no puede realizar esta acción.");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public int getDefensa() {
        return defensa;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int ataque) {

        this.vida = vida-ataque;

        if(vida<0){
            vida=0;
        }
        definirEstado();
    }

    public Estado getEstado(){
        return estado;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setEstadoEspecial(EstadoEspecial estadoEspecial) {
        this.estadoEspecial = estadoEspecial;
    }



    /*Manejo de Inventario y Equipo*/

    public void guardarEnInventario(Item item) {
        try {
            if (verificarVida()) {
                inventario.agregarItem(item);
                System.out.println(nombre + " guardó " + item.getNombre() + " en su inventario.\n");
            }
        }catch (ExcepcionMuerto e){
            System.err.println(e);
        }
    }

    public void consultarInventario() {
        try {
            if (verificarVida()) {
                System.out.println(inventario.devolverInventario(nombre));
            }
        }catch (ExcepcionMuerto e){
            System.err.println(e);
        }
    }


    public void equipar(Arma arma) {
        try {
            if (verificarVida()) {
                equipo.equipar(arma);
                inventario.usarItem(arma, nombre);
                ataque = arma.getDaño();
            }
        } catch (ExcepcionNoSeEncuentra | ExcepcionMuerto e) {
            System.err.println(e);
        }
    }

    public void equipar(Armadura armadura) {
        try {
            if (verificarVida()) {
                inventario.usarItem(armadura, nombre);
                equipo.equipar(armadura);
                defensa = equipo.devolverDefensa();
            }
        } catch (ExcepcionNoSeEncuentra | ExcepcionMuerto e) {
            System.err.println(e);
        }
    }

    public void equipar(Flecha flechas) {
        try {
            if (verificarVida()) {
                inventario.usarItem(flechas, nombre);
                equipo.equipar(flechas);
            }
        } catch (ExcepcionNoSeEncuentra | ExcepcionMuerto e) {
            System.err.println(e);
        }
    }

    public void desequipar(Arma arma) {
        try {
            if (verificarVida()) {
                equipo.desequipar(arma, nombre);
                guardarEnInventario(arma);
                ataque = 0;
            }
        } catch (ExcepcionNoEquipado | ExcepcionMuerto e) {
            System.err.println(e);
        }

    }

    public void desequipar(Armadura armadura) {
        try {
            if (verificarVida()) {
                equipo.desequipar(armadura, nombre);
                guardarEnInventario(armadura);
                defensa = 0;
            }
        } catch (ExcepcionNoEquipado | ExcepcionMuerto e) {
            System.err.println(e);
        }
    }

    public void consumir(Comida comida) {
        try {
            if (verificarVida()) {
                inventario.usarItem(comida, nombre);
                vida = vida + comida.getCura();

                if (vida > 100) {
                    vida = 100;
                }
            }
        } catch (ExcepcionNoSeEncuentra | ExcepcionMuerto e) {
            System.err.println(e);
        }
    }

    public void mostrarEquipo() {
        try {
            if (verificarVida()) {
        equipo.mostrarEquipo(nombre);
            }
        } catch (ExcepcionMuerto e) {
            System.err.println(e);
        }
    }


        /*Batalla*/

    /*Decidí hacer este método porque me pareció que era un calculo sencillo que se podía resolver
    en un método que devolviera si era posible el ataque o no*/
    private boolean calculaRango(int xpj, int ypj) throws ExcepcionRango{
        int rango=equipo.devolverRango();
        int límiteX=rango+x;
        int límiteX2=x-rango;
        int límiteY=rango+y;
        int límiteY2=y-rango;
        if(xpj<=límiteX && xpj>=límiteX2 && ypj>=límiteY2 && ypj<=límiteY) {
            return true;
        }else{
            throw new ExcepcionRango("El personaje que intenta atacar está fuera de rango.");
        }
    }

    private int dañoRealAtaque(boolean v) {

            if(v && estado==Estado.Herido && estadoEspecial==EstadoEspecial.Normal){
                return  equipo.devolverAtaque(nombre)/2;
            }else if((v && estadoEspecial==EstadoEspecial.Confundido)){
                System.out.println(nombre + " está confundido.");
                return 0;
            }else{
                return equipo.devolverAtaque(nombre);
            }

    }

    public void atacar(Personaje pj) {

        try{
            if(pj.estado != Estado.Muerto && calculaRango(pj.x,pj.y)){

                int dañoReal = dañoRealAtaque(verificarVida())-pj.defensa;

                if (dañoReal >= 0) {
                    pj.vida = pj.vida - dañoReal;
                    System.out.println(nombre + " atacó a " + pj.nombre + ". Ahora " + pj.nombre + " tiene " + pj.vida + " pts. de vida.\n");

                } else {
                    System.out.println(nombre + " atacó a " + pj.nombre + " pero falló. " + pj.nombre + " tiene " + pj.vida + " pts. de vida.\n");
                }
                pj.definirEstado();


            }else {
                System.err.println(pj.nombre + " ya está muerto.");
            }

            /*No me setea la vida y no entiendo por qué :( */
            if(estadoEspecial==EstadoEspecial.Envenenado){
                System.out.println(estadoEspecial);
                setVida(5);
                //vida=vida-5;
            }

        }catch (ExcepcionMuerto | ExcepcionRango e){
            System.err.println(e);
        }

    }

    public void atacar(Enemigo en) {

        try{
            if(en.getEstado() != Estado.Muerto && calculaRango(en.getX(),en.getY())){
                int dañoReal = dañoRealAtaque(verificarVida());

                if (dañoReal >= 0) {
                    en.setVida(dañoReal);
                    System.out.println(nombre + " atacó a " + en.getNombre() + ". Ahora " + en.getNombre() + " tiene " + en.getVida() + " pts. de vida.\n");
                } else {
                    System.out.println(nombre + " atacó a " + en.getNombre() + " pero falló. " + en.getNombre() + " tiene " + en.getVida() + " pts. de vida.\n");
                }
            }else {
                System.err.println(en.getNombre() + " ya está muerto.");
            }
        }catch (ExcepcionMuerto | ExcepcionRango e){
            System.err.println(e);
        }

    }
}



