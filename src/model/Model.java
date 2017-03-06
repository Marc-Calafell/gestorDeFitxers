/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import vista.Gui;

public class Model {          
   
    private Gui v;
    
    public String getFileInfo(File file){
        
                    float midaTotal= file.getTotalSpace()/1024/1024/1024;
                    float espaiDisponible=file.getFreeSpace()/1024/1024/1024;
                    float espaiUtilitzable=file.getUsableSpace()/1024/1024/1024;
                    float pesFitxer=file.length()/1024;
                    
                    String info=
                        "Mida total: "+ midaTotal +"GB" + "\n" +
                        "Espai disponible: "+ espaiDisponible +"GB" + "\n" +
                        "Nom fitxer: "+ file.getName() + "\n" +
                        "Path fitxer: "+ file.getParent() + "\n" +
                        "Espai utilitzable: "+ espaiUtilitzable +"GB" + "\n" +
                        "Pes fitxer: "+ pesFitxer +"KB" + "\n" +
                        "Ultima modificació: " + file.lastModified();
        return info;
    
    }
    


}
/*
boolean	delete()
boolean	exists()

boolean	renameTo(File dest)

boolean	mkdirs()




*/
 
 
