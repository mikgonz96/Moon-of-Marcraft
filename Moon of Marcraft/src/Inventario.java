import java.util.ArrayList;

public class Inventario {
    private ArrayList<Item> inventario;

    public Inventario(){
        this.inventario = new ArrayList<>();

    }


    public void agregarItem(Item item){
        this.inventario.add(item);

    }


    public void usarItem(Arma arma, String nom) throws ExcepcionNoSeEncuentra {

        if(inventario.contains(arma)){
            this.inventario.remove(arma);
            System.out.println(nom+" equipó "+arma.getNombre()+".\n");
        }else{
            throw new ExcepcionNoSeEncuentra(nom+" no tiene esa arma en su inventario.");
        }

    }

    public void usarItem(Armadura armadura, String nom) throws ExcepcionNoSeEncuentra{

        if(inventario.contains(armadura)){
            this.inventario.remove(armadura);
            System.out.println(nom+" equipó "+armadura.getNombre()+".\n");
        }else{
            throw new ExcepcionNoSeEncuentra(nom+" no tiene esa armadura en su inventario.");
        }
    }

    public void usarItem(Flecha flechas, String nom) throws ExcepcionNoSeEncuentra{

        if(inventario.contains(flechas)){
            this.inventario.remove(flechas);
            System.out.println(nom+" equipó "+flechas.getNombre()+".\n");
        }else{
            throw new ExcepcionNoSeEncuentra(nom+" no tiene esas flechas en su inventario.");
        }
    }

    public void usarItem(Comida comida, String nom) throws ExcepcionNoSeEncuentra {

        /* Esto no me convence mucho porque si otro personaje tiene en su inventario, por ejemplo,
        una manzana también se lo resta a ese pero no encontre otra manera de hacerlo.
        Se debe crear más de un objeto que se llame manzana o hay manera de solucionarlo
        con un único objeto manzana? */

        if(inventario.contains(comida)){
            int cant = comida.getCantUsos();

            if(cant>1){
                cant--;
                comida.setCantUsos(cant);
            }else{
                this.inventario.remove(comida);
            }

            System.out.println(nom+" comió "+comida.getNombre()+" y recuperó "+comida.getCura()+" pts de vida.\n");

        }else{
            throw new ExcepcionNoSeEncuentra(nom+" no tiene ese alimento en su inventario.");
        }

    }

    public String devolverInventario(String nom) {
        String inv="Inventario de "+nom+":\n";
        for(int i=0;i<inventario.size();i++){
            inv= inv + inventario.get(i).toString()+
                    '\n';
        }
        return inv;
    }



}
