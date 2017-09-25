/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avsystem;


import java.awt.event.ActionListener;
import java.io.IOException;
import javafx.embed.swing.SwingNode;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.SwingUtilities;
/**
 *
 * @author deity
 */
public class WaveFormDemo extends Capture implements ActionListener{

@FXML
ToggleButton play;
      @FXML
    AnchorPane playPane;

        
      public MicStatus ls=new Capture();
 
     private void createSwingContent(final SwingNode swingNode) {
         
         
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() 
            {
                swingNode.setContent(ls.contentPane);    
            }
            
        });
    }
 

    @FXML
    public void playrecorded(ActionEvent event) throws UnsupportedAudioFileException, IOException, LineUnavailableException
    {
        play.setDisable(true);
      SwingNode swingNode = new SwingNode();
        createSwingContent(swingNode);
         playPane.getChildren().add(swingNode);
   ls.change();
       
  
        
                         
             }
                
      @FXML
    public void next(ActionEvent event) throws UnsupportedAudioFileException, IOException, LineUnavailableException
    {
  
          Stage stage = new Stage();
   Object root = FXMLLoader.load(getClass().getResource("next.fxml"));
   stage.setScene(new Scene((Parent) root));
   stage.setTitle("Please Record your data");
   stage.getScene().getWindow();
   stage.show();
        
    }
       @FXML
    public void recordagain(ActionEvent event) throws UnsupportedAudioFileException, IOException, LineUnavailableException
    {
    
    
                      Stage stage = new Stage();
    Parent root = FXMLLoader.load(getClass().getResource("Record.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        
 
     
    
   
 


    }
  


        
        
}