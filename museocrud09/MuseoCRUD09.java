/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package museocrud09;


import java.util.ArrayList;
import access.MuseoDAO;
import controller.MuseoController;
import model.*;

/**
 *
 * @author Yovany
 */
public class MuseoCRUD09 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        /*MuseoDAO museoDao = new MuseoDAO();
        
        ArrayList<Museo> listMuseos = museoDao.getListMuseos(3031);
        for (Museo museo : listMuseos) {
            System.out.println(museo.getMu_id() + "\t" + museo.getMu_nombre());
        }*/
        
        MuseoController mc = new MuseoController();
        mc.gestionMuseo();
    }
    
}
