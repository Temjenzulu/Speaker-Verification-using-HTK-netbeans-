/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avsystem;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import avsystem.MicStatus;
import java.awt.TextArea;
import java.io.PrintWriter;
import javafx.scene.layout.AnchorPane;
/**
 *
 * @author deity
 */
public class Main implements Initializable {
     int i;
 @FXML
         AnchorPane anchor;
    String thisLine = null;
    String me=null;
    String ths=null;
     public String here=null;
    @FXML
     private TextField a1;
     @FXML
         private TextField  a2;
     @FXML
         private TextArea textfield;
         @FXML
     private TextField a3;
         @FXML
     public TextField id;

  @FXML
    void make(ActionEvent event) throws IOException {
     
       
      //  try 
    
            if(a1.getText()==null||a2.getText()==null||a3.getText()==null)
            {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                
                alert.setTitle("Empty Fields");
               // alert.setHeaderText("No field filled");
                alert.setContentText("Please enter your details.");
                alert.show();
            }
            else if(a2.getText().length()<=5)
            {
                Alert alert = new Alert(Alert.AlertType.WARNING);
               
                alert.setTitle("Weak password");
               // alert.setHeaderText("No field filled");
                alert.setContentText("Please enter a strong password");
                alert.show();}
             
             else if(a2.getText().length()!=a3.getText().length())
            {
                Alert alert = new Alert(Alert.AlertType.WARNING);
               
                alert.setTitle("Password Not Match");
               // alert.setHeaderText("No field filled");
                alert.setContentText("Password Not Match");
                alert.show();}
             else if(a2.getText().length()==a3.getText().length())
             {
        
         Stage stage = new Stage();
   Object root = FXMLLoader.load(getClass().getResource("welcome.fxml"));
   stage.setScene(new Scene((Parent) root));
   stage.setTitle("Please Record your data");
   stage.getScene().getWindow();
   stage.show();
            
                   
    }};
     
           
  
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
      @FXML
   void makesearch(ActionEvent event) throws FileNotFoundException, IOException
   {
         int j=0;
       ths=id.getText();
       BufferedReader br = new BufferedReader(new FileReader("/home/zzzz/Desktop/KICHUHTK/testspk.txt"));
          for(i=1;i<=10;i++)
        {
         thisLine =br.readLine();

          if(ths.equals(thisLine))
          {  j=1;
                             try{
    PrintWriter write = new PrintWriter("/home/zzzz/Desktop/KICHUHTK/id.txt");
    write.println(ths);
    write.close();
} catch (IOException e) {
   // do something
}
                             try {
                                 PrintWriter writ = new PrintWriter("/home/zzzz/Desktop/KICHUHTK/ID.txt");
    writ.println(ths);
    writ.close();
} catch (IOException e) {
   // do something
}
                   try{
    PrintWriter writer = new PrintWriter("/home/zzzz/Desktop/KICHUHTK/test.txt");
    writer.println(ths);
    writer.close();
} catch (IOException e) {
   // do something
}
        
            
       
       AnchorPane pane= FXMLLoader.load(getClass().getResource(thisLine.concat(".fxml")));
anchor.getChildren().setAll(pane);
 
    
                  break;
               }
    
        
     
      
       
      }
           if(id.getText()==null||id.getText().length()==0||id.getText().length()!=4)
                    {
                       Alert alert = new Alert(Alert.AlertType.WARNING);
                      
                       alert.setTitle("Empty Field"); 
                       alert.setContentText("Enter your 4-digit ID");
                       alert.show();}
      else  if(j==0)
        {
          {Alert alert = new Alert(Alert.AlertType.WARNING);
                      
                       alert.setTitle("Warning"); 
                       alert.setContentText("ID not found");
                       alert.show();
    }}
        
       
        
 }}
