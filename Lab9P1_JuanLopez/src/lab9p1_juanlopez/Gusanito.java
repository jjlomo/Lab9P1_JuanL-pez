/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab9p1_juanlopez;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author jjlm1
 */
public class Gusanito {

    Random rand = new Random();
    ArrayList<String> instrucciones =new ArrayList<>();
    ArrayList <String> pasos=new ArrayList<>();
    int x;
    int y;
    int mx;
    int my;
    int alto;
    int largo;
    int obstaculos;
    int obx;
    int oby;
    boolean pos;
    char[][] tab ;
    

    public Gusanito(int alto, int largo) {
        this.alto = alto;
        this.largo = largo;
        this.tab = new char[alto][largo];
    }
    

    public char[][] tablero() {
        char[][] tablero = new char[alto][largo];
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[i].length; j++) {
                tab[i][j] = ' ';
            }
        }
        return tab;
    }

    public void llenado() {
        mx = rand.nextInt(alto);
        my = rand.nextInt(largo);
        //tab = assign(mx,my, 'Ó');
        tab[mx][my]='Ó';
        pos = false;
        while (pos == false) {
            x = rand.nextInt(alto);
            y = rand.nextInt(largo);
            pos = valid( tab,x, y);
        }
        System.out.println(x+ "alto gusano");
        System.out.println(y+"largo gusano");
        tab[x][y]='~';
        
        if (largo > alto) {
            obstaculos = rand.nextInt(((largo - alto) + alto)+1);
            System.out.println(obstaculos+" obstaculos");
        } else if (alto>largo){
            obstaculos = rand.nextInt(((alto - largo) + largo)+1);
            System.out.println(obstaculos+" obstaculos");
        }else if(alto==largo){
            obstaculos=alto;
            System.out.println(obstaculos+" obstaculos");
        }
        for (int i = 0; i < obstaculos; i++) {
            pos = false;
           
                obx = rand.nextInt(alto);
                oby = rand.nextInt(largo);
                pos = valid(tab,obx, oby);
                if (pos==true){
                tab[obx][oby]='#';
                }else{
                    while(pos=false){
                        obx = rand.nextInt(alto);
                oby = rand.nextInt(largo);
                pos = valid(tab,obx, oby);
                    }
                }
            tab[obx][oby]='#';
        }
        mx = rand.nextInt(alto);
        my = rand.nextInt(largo);
        pos = valid(tab,mx, my);
                if (pos==true){
                tab[mx][my]='#';
                }else{
                    while(pos=false){
                        mx = rand.nextInt(alto);
                my = rand.nextInt(largo);
                pos = valid(tab,mx, my);
                    }
                    System.out.println(mx+" alto manzana");
                    System.out.println(my+" largo manzana");
        tab[mx][my]='Ó';
     //   juego(tablero);
    }
//    juego(table);
    }
    public void juego() {
        tablero();
        llenado();
        // System.out.println(Arrays.deepToString(tablero));
//        JOptionPane.showMessageDialog(null, cad);
        System.out.println("en metodo juego");
        
        String matriz="";
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[i].length; j++) {
                
                matriz+=( "["+tab[i][j]+"]" );
            }
            matriz+="\n";
        }
       // JOptionPane.showMessageDialog(null, matriz);
        String instru=JOptionPane.showInputDialog(matriz);
       
        while (!"2".equals(instru)){
            instrucciones.add(instru);
            instru=JOptionPane.showInputDialog(matriz);
        }
        System.out.println(matriz);
        System.out.println(instrucciones);
        for(int ins=0;ins<instrucciones.size();ins++){
        String inst=instrucciones.get(ins);
        String[] movs=inst.split(" ");
        int mov=Integer.parseInt(movs[0]);
        if(movs[1].contentEquals("up")||movs[1].contentEquals("Up")||movs[1].contentEquals("UP")){
            x-=mov;
            if(x>=alto||y>=largo||x<0||y<0){
                System.out.println("Se ha salido del mapa");
            }else{
//            tab[x][y]=' ';
            tab[x][y]='~';
            }
            
        }else if(movs[1].contentEquals("dn")||movs[1].contentEquals("Dn")||movs[1].contentEquals("DN")){
            x+=mov;
            if(x>=alto||y>=largo||x<0||y<0){
                System.out.println("Se ha salido del mapa");
            }else{
//            tab[x][y]=' ';
            tab[x][y]='~';
            }
            
        }else if(movs[1].contentEquals("rt")||movs[1].contentEquals("RT")||movs[1].contentEquals("Rt")){
            y+=mov;
            if(x>=alto||y>=largo||x<0||y<0){
                System.out.println("Se ha salido del mapa");
            }else{
//            tab[x][y]=' ';
            tab[y][y]='~';
            }
            
        }else if(movs[1].contentEquals("lt")||movs[1].contentEquals("Lt")||movs[1].contentEquals("LT")){
            y-=mov;
            if(x>=alto||y>=largo||x<0||y<0){
                System.out.println("Se ha salido del mapa");
            }else{
//            tab[x][y]=' ';
            tab[x][y]='~';
            }
        }
        if (ins!=instrucciones.size()-1){
            
        }
         for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[i].length; j++) {
                
                matriz+=( "["+tab[i][j]+"]" );
            }
            matriz+="\n";
        }
         pasos.add(matriz);
         matriz="";
    }
        matriz="";
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[i].length; j++) {
                
                matriz+=( "["+tab[i][j]+"]" );
            }
            matriz+="\n";
        }
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[i].length; j++) {
                
                System.out.print( "["+tab[i][j]+"]" );
            }
            System.out.println("");
        }
        String salio="\n Ha salido del mapa";
        String vic="\n El gusano ha llegado a la manzana!!";
        String nada="\n EL gusano no llegó a la manzana:( ";
        String ver="\n 1. Paso siguiente\n 2. Paso anterior\n 3. Seleccionar paso";
        String paso0="Paso 0\n";
        if(x>=alto||y>=largo||x<0||y<0){
                System.out.println("Se ha salido del mapa");
                JOptionPane.showMessageDialog(null, matriz+salio);
            }else if(tab[mx][my]==tab[x][y]){
        JOptionPane.showMessageDialog(null, matriz+vic);
            }else{
                JOptionPane.showMessageDialog(null, matriz+nada);
        System.out.println("fin metodo juego");
        System.out.println("");
        
        }
        String pas=pasos.get(0);
        String opcion=JOptionPane.showInputDialog(null,paso0+pas+ver);
        while(!"4".equals(opcion)){
        if (opcion.equals("1")){
                
                int paso=Integer.parseInt(opcion);
                pas=pasos.get(paso+1);
                 opcion=JOptionPane.showInputDialog(null,pas);
            }else 
        if (opcion.equals("2")){
                
                int paso=Integer.parseInt(opcion);
                pas=pasos.get(paso-1);
                 opcion=JOptionPane.showInputDialog(null,pas);
            }else 
            if (opcion.equals("3")){
                String op=JOptionPane.showInputDialog(null,pas);
                int paso=Integer.parseInt(op);
                pas=pasos.get(paso);
                JOptionPane.showMessageDialog(null, pas);
            }
         opcion=JOptionPane.showInputDialog(null,pas+ver);
    }
    }
    public void fin() {

    }

    public boolean valid( char[][]tab ,int a, int l) {
        boolean vof;
        if (tab[a][l] != ' ') {
            vof = true;
        } else {
            vof = false;
        }
        return vof;
    }

    public char[][] assign(int x, int y, char valor) {
        tab[x][y] = valor;
        return tab;
    }
}
