/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fonts;

import controlador.Controlador;
import model.Model;
import vista.Gui;

/**
 *
 * @author profe
 */
public class Inici {
    
    private static Model m=new Model();
    private static Gui v=new Gui();
    private static Controlador c;
    
    public static void main(String[] args){
     
        c=new Controlador(m,v);
    
    
    }
    
}
