/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avsystem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author zzzz
 */
public class M001 {
    @FXML
            AnchorPane anchor;
   String s1=null;
         @FXML
   void S1(ActionEvent event) throws IOException   
   {
        BufferedReader br = new BufferedReader(new FileReader("/home/zzzz/Desktop/KICHUHTK/test.txt"));
        s1=br.readLine();
        System.out.println(s1);
       PrintWriter writer = new PrintWriter("/home/zzzz/Desktop/KICHUHTK/test.txt");
                writer.println(s1.concat("_MCS1"));
  writer.close();
   // do something
                       
            AnchorPane pane= FXMLLoader.load(getClass().getResource("statements1.fxml"));
anchor.getChildren().setAll(pane);
 
   }
      @FXML
   void S2(ActionEvent event) throws IOException   
   {
        BufferedReader br = new BufferedReader(new FileReader("/home/zzzz/Desktop/KICHUHTK/test.txt"));
        s1=br.readLine();
        System.out.println(s1);
       PrintWriter writer = new PrintWriter("/home/zzzz/Desktop/KICHUHTK/test.txt");
                writer.println(s1.concat("_MCS2"));
  writer.close();
             AnchorPane pan= FXMLLoader.load(getClass().getResource("statements2.fxml"));
anchor.getChildren().setAll(pan);
   }}


