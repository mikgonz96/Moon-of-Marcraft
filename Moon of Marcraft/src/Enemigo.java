public abstract class Enemigo {

    private String nombre;
    private int vida;
    private int maxVida;
    private Estado estado;
    private int x;
    private int y;
    private int rango;


    public Enemigo(String nombre, int vida,int x, int y, int rango, int maxVida) {
        this.nombre = nombre;
        this.vida = vida;
        this.maxVida=maxVida;
        definirEstado();
        this.x=x;
        this.y=y;
        this.rango=rango;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int ataque) {

        if(vida-ataque<0){
            this.vida=0;
        }else{
            this.vida = vida-ataque;
        }
        definirEstado();
    }

    protected void curarVida(int cura){

        if(vida+cura>maxVida){
            vida=maxVida;
        }else{
            this.vida=vida+cura;
        }
        definirEstado();
    }

    public String getNombre(){
        return nombre;
    }

    public Estado getEstado() {
        return estado;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    private void definirEstado() {
        if (vida > 50) {
            estado = Estado.Vivo;
        } else if (vida <= 50 && vida > 0) {
            estado = Estado.Herido;
        } else if (vida == 0) {
            estado = Estado.Muerto;
        }
    }

    protected boolean calculaRango(int xpj, int ypj) throws ExcepcionRango{
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
    protected boolean verificarVida( ) throws ExcepcionMuerto{

        if(estado!=Estado.Muerto){
            return true;
        }else{
            throw new ExcepcionMuerto(nombre+" está muerto por lo tanto no puede realizar esta acción.");
        }
    }
}
