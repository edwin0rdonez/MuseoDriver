/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import java.util.ArrayList;
import java.util.Scanner;

import access.MuseoDAO;
import model.*;

/**
 *
 * @author Yovany
 */
public class MuseoController {
    Scanner sc = new Scanner(System.in);
    
    public void gestionMuseo(){
        int opcion;
        do{
            System.out.println("Gestion de Museos".toUpperCase());
            System.out.println("1. Agregar Museos");
            System.out.println("2. Cosultar Museos");
            System.out.println("3. Actualizar Museos");
            System.out.println("4. Eliminar Museos");
            System.out.println("5. Listar Museos");
            System.out.println("6. Salir");
            System.out.println("Digite Opción : ");
            opcion = sc.nextInt();
            sc.nextLine();
            switch(opcion){
                case 1: addMuseo(); break;
                case 2: getMuseo(); break;
                case 3: updatetMuseo(); break;
                case 4: deleteMuseo(); break;
                case 5: listMuseo(); break;
            }
        }while ( opcion != 6);
    }
    
    private void addMuseo(){
        //TODO
        int id;
        do{
            System.out.println("Agregar Museo");
            System.out.print("Código : [ 0 -> Terminar ] : ");
            id = sc.nextInt();
            sc.nextLine();
            if ( id != 0){
                MuseoDAO museoDao = new MuseoDAO();
                ArrayList<Museo> museo = museoDao.getListMuseos(id);
                if ( museo.size() > 0){
                    System.out.println("Código de museo ya está registrado");
                }else{
                    System.out.println("Nombre : ");
                    String nombre = sc.nextLine();
                    Museo nuevoMuseo = new Museo(id, nombre);
                    
                    if (museoDao.saveMuseo(nuevoMuseo)  == 1){
                        System.out.println("Museo grabado con éxito");
                    }else{
                        System.out.println("Error al grabar el museo");
                    }
                }
                System.out.println("Presione una tecla para continuar");
                sc.nextLine();
                        
            }
        }while (id != 0);
    }
    
    private void getMuseo(){
        //TODO
        System.out.println("CONSULTAR MUSEO");
        System.out.println("Codigo : ");
        int codigo = sc.nextInt();
        sc.nextLine();
        
        MuseoDAO museoDao = new MuseoDAO();
        ArrayList<Museo> listMuseo = museoDao.getListMuseos(codigo);
        if (listMuseo.size() > 0 ){
            System.out.println("CODIGO\tNOMBRE");
            for (Museo museo : listMuseo) {
                System.out.println(museo.getMu_id() + "\t" + museo.getMu_nombre());
            }
        }else {
            System.out.println("Código de museo no existe".toUpperCase());
        }
        
        System.out.println("Presione una tecla para continuar");
        sc.nextLine();
    }
    
    private void updatetMuseo(){
        //TODO
    }
    
    private void deleteMuseo(){
        //TODO
    }
    
    private void listMuseo(){
        //TODO
        MuseoDAO museoDao = new MuseoDAO();
        ArrayList<Museo> listMuseo = museoDao.getListMuseos(0);
        System.out.println("LISTADO DE MUSEOS");
        System.out.println("CODIGO\tNOMBRE");
        for (Museo museo : listMuseo) {
            System.out.println(museo.getMu_id() + "\t" + museo.getMu_nombre());
        }
        System.out.println("Presione una tecla para continuar");
        sc.nextLine();
    }
}
