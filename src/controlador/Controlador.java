/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Model;
import vista.Gui;

public class Controlador {

    private Model m;
    private Gui v;
    File file = null;
    
    public Controlador(Model m, Gui v) {
        this.m = m;
        this.v = v;
        this.v.setVisible(true);

        control(m, v);
        
        
    }

    public void control(Model m, Gui v) {
        ActionListener actionListener = new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                if (actionEvent.getSource().equals(v.getSelectFileBTN())) {
                    int result = v.getFileChooser().showOpenDialog(v.getFileChooser());

                    if (result == v.getFileChooser().APPROVE_OPTION) {
                        File file = v.getFileChooser().getSelectedFile();
                        v.getFileJTF().setText(file.getAbsolutePath());

                        if (file.isFile()) v.getIsFileCHB().setSelected(true);
                        if (file.isDirectory()){ 
                            v.getIsDirectoryCHB().setSelected(true); 
                            boolean stat=true;
                                v.getIsEditCHB2().setEnabled(stat);
                                v.getIsExeCHB2().setEnabled(stat);
                                v.getIsReadCHB2().setEnabled(stat);
                                v.getIsDirectoryCHB2().setEnabled(stat);
                                v.getIsFileCHB2().setEnabled(stat);
                                v.getIsHiddenCHB2().setEnabled(stat);
                                v.getCrearBTN().setEnabled(stat);
                                v.getItemJTF().setEnabled(stat);
                              //  v.getEsborrarBTN().setEnabled(stat);
                                v.getPassejarBTN().setEnabled(stat);
                        }
                        
                        if (file.canExecute()) v.getIsExeCHB().setSelected(true);
                        if (file.canRead()) v.getIsReadCHB().setSelected(true);
                        if (file.canWrite()) v.getIsEditCHB().setSelected(true);
                        if (file.isHidden()) v.getIsHiddenCHB().setSelected(true);
                        
                    }
                    
                    

                } else if (actionEvent.getSource().equals(v.getInfoBTN())) {
                    File file = v.getFileChooser().getSelectedFile();
                    System.out.println(m.getFileInfo(file));
                    
                    JOptionPane.showMessageDialog(null, m.getFileInfo(file) , "informació", JOptionPane.INFORMATION_MESSAGE);
                    
                    
                    
                    
                } else if (actionEvent.getSource().equals(v.getCrearBTN())) { 
                    
                    System.out.println("asasdasdasdasdasd");
                    String fixer = v.getItemJTF().getText();
                    
                    v.getItemJTF().setText(v.getFileChooser().getSelectedFile().toString() + "/" +v.getItemJTF().getText());
                    System.out.println(v.getItemJTF().getText());
                    
                    File newfile = new File(v.getItemJTF().getText());
                    
                    if(newfile.exists()){
                        JOptionPane.showMessageDialog(null, "El fitxer ja existeix" , "error", JOptionPane.ERROR_MESSAGE);
                    
                    
                    } else {
                        
                        if(v.getIsFileCHB2().isSelected()){
                            if(v.getIsExeCHB2().isSelected())newfile.setExecutable(true);
                            if(v.getIsEditCHB2().isSelected())newfile.setReadable(true);
                            if(v.getIsReadCHB2().isSelected())newfile.setWritable(true);
                            if(v.getIsHiddenCHB2().isSelected())newfile.setReadOnly();
                                
                            try {     
                                newfile.createNewFile();    
                                
                                v.getItemJTF().setText(fixer);
                                
                            } catch (IOException ex) {
                                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        
                        } else if(v.getIsDirectoryCHB2().isSelected()){
                            v.getItemJTF().getText();
                            newfile.mkdir();
                            v.getItemJTF().setText(fixer);
                        
                        } else {
                            JOptionPane.showMessageDialog(null, "Selecciona que el he de crear" , "error", JOptionPane.ERROR_MESSAGE);
                            v.getItemJTF().setText(fixer);  
                        }                    
                    }
                    
                } else if (actionEvent.getSource().equals(v.getEsborrarBTN())) {    

                    
                        file.delete();
                    

                
                } else if (actionEvent.getSource().equals(v.getPassejarBTN())) {           
                        
                 
                    
                   // walkfiletree.
                                       
                        
                        
                } else {
                    System.out.println("asasdasdasdasdasd");
                }
            }
             
        };
         v.getSelectFileBTN().addActionListener(actionListener);
         v.getInfoBTN().addActionListener(actionListener);
         v.getCrearBTN().addActionListener(actionListener);
         v.getPassejarBTN().addActionListener(actionListener);

    }

}
