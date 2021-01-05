import java.awt.*;

public class Main {
    public static void main(String[] args){
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_RESET = "\u001B[0m";

        //Personajes

        Personaje tiburoncin=new Personaje("Tiburoncin",6,8);
        Personaje homero=new Personaje("Homero",8,5);


        //Items

            /*Comidas*/
        Comida manzana=new Comida("Manzana",10,5);
        Comida queso=new Comida("Queso",15, 4);
        Comida solomillo=new Comida("Solomillo",25, 3);

            /*Armas*/
        Espada espadaComún=new Espada("Espada Común",40,15);
        Espada espadaLarga=new Espada("Espada Larga", 70,20);
        Hacha hachaLiviana=new Hacha("Hacha Liviana",40, 20,15);
        Hacha hachaPesada=new Hacha("Hacha Pesada",60, 30,10);
        Arco arcoMadera=new Arco("Arco de Madera",30,30);
        Arco arcoHueso=new Arco("Arco de Hueso",45,40);
        Flecha flechaComún=new Flecha("Flecha Común",10,20,6);
        Flecha flechaIncendiaria=new Flecha("Flecha Incendiaria",20,25,10);

            /*Armaduras*/
        Armadura armaduraHierro=new Armadura("Armadura de Hierro",30);
        Armadura armaduraOro=new Armadura("Armadura de Oro",45);
        Armadura armaduraPlatino=new Armadura("Armadura Platino",60);


        //Otros Enemigos

        Guerrero guerrero=new Guerrero(10,6);
        Mago mago=new Mago(11,7);
        Chamán chamán=new Chamán(9,7);


/**********************************************************************************************************************/


        //Juego
        System.out.println(ANSI_BLUE + "\n ***BIENVENIDO A MOON OF MARCRAFT*** \n"+ ANSI_RESET);


            /*Información de Personajes*/
        tiburoncin.informaciónPersonaje();
        homero.informaciónPersonaje();


            /*Manejo de Inventario*/
        tiburoncin.guardarEnInventario(queso);
        tiburoncin.guardarEnInventario(espadaComún);
        tiburoncin.guardarEnInventario(armaduraHierro);

        homero.guardarEnInventario(solomillo);
        homero.guardarEnInventario(hachaPesada);
        //homero.guardarEnInventario(arcoHueso);
        //homero.guardarEnInventario(flechaIncendiaria);
        homero.guardarEnInventario(armaduraPlatino);


            /*Equipar Items*/
        tiburoncin.equipar(espadaComún);
        tiburoncin.equipar(armaduraHierro);

        homero.equipar(hachaPesada);
        //homero.equipar(arcoHueso);
        //homero.equipar(flechaIncendiaria);
        homero.equipar(armaduraPlatino);
        homero.mostrarEquipo();


            /*Pelea pvp y Consumir Items*/
        /*tiburoncin.atacar(homero);
        homero.atacar(tiburoncin);
        tiburoncin.atacar(homero);

        homero.consumir(solomillo);
        homero.consumir(solomillo);

        homero.consultarInventario();
        homero.informaciónPersonaje();
        tiburoncin.informaciónPersonaje();*/


            /*Pelea con otros Enemigos*/
        guerrero.ataque(homero);
        mago.ataque(homero,EstadoEspecial.Envenenado);
        homero.atacar(guerrero);
        chamán.curar(guerrero);

        homero.informaciónPersonaje();



            /*Errores*/
        tiburoncin.equipar(hachaLiviana);
        tiburoncin.equipar(armaduraOro);
        homero.consumir(manzana);
        homero.desequipar(espadaComún);
        tiburoncin.desequipar(armaduraPlatino);


    }
}
