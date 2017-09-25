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
public class statements2{
    @FXML
            AnchorPane anchor;
    String s1=null;
    String s=null;
   public void s1(ActionEvent event) throws IOException   
   {
          BufferedReader b = new BufferedReader(new FileReader("/home/zzzz/Desktop/KICHUHTK/id.txt"));
        s=b.readLine();
        System.out.println(s);
       PrintWriter write = new PrintWriter("/home/zzzz/Desktop/KICHUHTK/id.txt");
                write.println(s.concat("_S01"));
                write.flush();
        BufferedReader br = new BufferedReader(new FileReader("/home/zzzz/Desktop/KICHUHTK/test.txt"));
        s1=br.readLine();
        System.out.println(s1);
       PrintWriter writer = new PrintWriter("/home/zzzz/Desktop/KICHUHTK/test.txt");
                writer.println(s1.concat("_S01"));
                writer.flush();
                AnchorPane pane=FXMLLoader.load(getClass().getResource("s2statement1.fxml"));
anchor.getChildren().setAll(pane);
   }
    

public void s2(ActionEvent event) throws IOException   
   {
          BufferedReader b = new BufferedReader(new FileReader("/home/zzzz/Desktop/KICHUHTK/id.txt"));
        s=b.readLine();
        System.out.println(s);
       PrintWriter write = new PrintWriter("/home/zzzz/Desktop/KICHUHTK/id.txt");
                write.println(s.concat("_S02"));
                write.flush();
      BufferedReader br = new BufferedReader(new FileReader("/home/zzzz/Desktop/KICHUHTK/test.txt"));
        s1=br.readLine();
        System.out.println(s1);
       PrintWriter writer = new PrintWriter("/home/zzzz/Desktop/KICHUHTK/test.txt");
                writer.println(s1.concat("_S02"));
                writer.flush();
                
                      AnchorPane pane=FXMLLoader.load(getClass().getResource("s2statement2.fxml"));
anchor.getChildren().setAll(pane);
   }
    
  public  void s3(ActionEvent event) throws IOException   
   {
          BufferedReader b = new BufferedReader(new FileReader("/home/zzzz/Desktop/KICHUHTK/id.txt"));
        s=b.readLine();
        System.out.println(s);
       PrintWriter write = new PrintWriter("/home/zzzz/Desktop/KICHUHTK/id.txt");
                write.println(s.concat("_S03"));
                write.flush();
     BufferedReader br = new BufferedReader(new FileReader("/home/zzzz/Desktop/KICHUHTK/test.txt"));
        s1=br.readLine();
        System.out.println(s1);
       PrintWriter writer = new PrintWriter("/home/zzzz/Desktop/KICHUHTK/test.txt");
                writer.println(s1.concat("_S03"));
                writer.flush();
             AnchorPane pane=FXMLLoader.load(getClass().getResource("s2statement3.fxml"));
anchor.getChildren().setAll(pane);
   }
    
public void s4(ActionEvent event) throws IOException   
   {
          BufferedReader b = new BufferedReader(new FileReader("/home/zzzz/Desktop/KICHUHTK/id.txt"));
        s=b.readLine();
        System.out.println(s);
       PrintWriter write = new PrintWriter("/home/zzzz/Desktop/KICHUHTK/id.txt");
                write.println(s.concat("_S04"));
                write.flush();
       BufferedReader br = new BufferedReader(new FileReader("/home/zzzz/Desktop/KICHUHTK/test.txt"));
        s1=br.readLine();
        System.out.println(s1);
       PrintWriter writer = new PrintWriter("/home/zzzz/Desktop/KICHUHTK/test.txt");
                writer.println(s1.concat("_S04"));
                writer.flush();
                    AnchorPane pane=FXMLLoader.load(getClass().getResource("s2statement4.fxml"));
anchor.getChildren().setAll(pane);
   }
    
public void s5(ActionEvent event) throws IOException   
   {
          BufferedReader b = new BufferedReader(new FileReader("/home/zzzz/Desktop/KICHUHTK/id.txt"));
        s=b.readLine();
        System.out.println(s);
       PrintWriter write = new PrintWriter("/home/zzzz/Desktop/KICHUHTK/id.txt");
                write.println(s.concat("_S05"));
                write.flush();
       BufferedReader br = new BufferedReader(new FileReader("/home/zzzz/Desktop/KICHUHTK/test.txt"));
        s1=br.readLine();
        System.out.println(s1);
       PrintWriter writer = new PrintWriter("/home/zzzz/Desktop/KICHUHTK/test.txt");
                writer.println(s1.concat("_S05"));
                writer.flush();
                     AnchorPane pane=FXMLLoader.load(getClass().getResource("s2statement5.fxml"));
anchor.getChildren().setAll(pane);
   }
    
public void s6(ActionEvent event) throws IOException   
   {
          BufferedReader b = new BufferedReader(new FileReader("/home/zzzz/Desktop/KICHUHTK/id.txt"));
        s=b.readLine();
        System.out.println(s);
       PrintWriter write = new PrintWriter("/home/zzzz/Desktop/KICHUHTK/id.txt");
                write.println(s.concat("_S06"));
                write.flush();
       BufferedReader br = new BufferedReader(new FileReader("/home/zzzz/Desktop/KICHUHTK/test.txt"));
        s1=br.readLine();
        System.out.println(s1);
       PrintWriter writer = new PrintWriter("/home/zzzz/Desktop/KICHUHTK/test.txt");
                writer.println(s1.concat("_S06"));
                writer.flush();
                  AnchorPane pane=FXMLLoader.load(getClass().getResource("s2statement6.fxml"));
anchor.getChildren().setAll(pane);
   }
    
public void s7(ActionEvent event) throws IOException   
   {
          BufferedReader b = new BufferedReader(new FileReader("/home/zzzz/Desktop/KICHUHTK/id.txt"));
        s=b.readLine();
        System.out.println(s);
       PrintWriter write = new PrintWriter("/home/zzzz/Desktop/KICHUHTK/id.txt");
                write.println(s.concat("_S07"));
                write.flush();
     BufferedReader br = new BufferedReader(new FileReader("/home/zzzz/Desktop/KICHUHTK/test.txt"));
        s1=br.readLine();
        System.out.println(s1);
       PrintWriter writer = new PrintWriter("/home/zzzz/Desktop/KICHUHTK/test.txt");
                writer.println(s1.concat("_S07"));
                writer.flush();
                   AnchorPane pane=FXMLLoader.load(getClass().getResource("s2statement7.fxml"));
anchor.getChildren().setAll(pane);
   }
    
public void s8(ActionEvent event) throws IOException   
   {
          BufferedReader b = new BufferedReader(new FileReader("/home/zzzz/Desktop/KICHUHTK/id.txt"));
        s=b.readLine();
        System.out.println(s);
       PrintWriter write = new PrintWriter("/home/zzzz/Desktop/KICHUHTK/id.txt");
                write.println(s.concat("_S08"));
                write.flush();
 BufferedReader br = new BufferedReader(new FileReader("/home/zzzz/Desktop/KICHUHTK/test.txt"));
        s1=br.readLine();
        System.out.println(s1);
       PrintWriter writer = new PrintWriter("/home/zzzz/Desktop/KICHUHTK/test.txt");
                writer.println(s1.concat("_S08"));
                writer.flush();
                    AnchorPane pane=FXMLLoader.load(getClass().getResource("s2statement8.fxml"));
anchor.getChildren().setAll(pane);
   }
    
public void s9(ActionEvent event) throws IOException   
   {
          BufferedReader b = new BufferedReader(new FileReader("/home/zzzz/Desktop/KICHUHTK/id.txt"));
        s=b.readLine();
        System.out.println(s);
       PrintWriter write = new PrintWriter("/home/zzzz/Desktop/KICHUHTK/id.txt");
                write.println(s.concat("_S09"));
                write.flush();
       
   BufferedReader br = new BufferedReader(new FileReader("/home/zzzz/Desktop/KICHUHTK/test.txt"));
        s1=br.readLine();
        System.out.println(s1);
       PrintWriter writer = new PrintWriter("/home/zzzz/Desktop/KICHUHTK/test.txt");
                writer.println(s1.concat("_S09"));
                writer.flush();
                   AnchorPane pane=FXMLLoader.load(getClass().getResource("s2statement9.fxml"));
anchor.getChildren().setAll(pane);
   }
    
public void s10(ActionEvent event) throws IOException   
   {
          BufferedReader b = new BufferedReader(new FileReader("/home/zzzz/Desktop/KICHUHTK/id.txt"));
        s=b.readLine();
        System.out.println(s);
       PrintWriter write = new PrintWriter("/home/zzzz/Desktop/KICHUHTK/id.txt");
                write.println(s.concat("_S10"));
                write.flush();
 BufferedReader br = new BufferedReader(new FileReader("/home/zzzz/Desktop/KICHUHTK/test.txt"));
        s1=br.readLine();
        System.out.println(s1);
       PrintWriter writer = new PrintWriter("/home/zzzz/Desktop/KICHUHTK/test.txt");
                writer.println(s1.concat("_S10"));
                writer.flush();
                     AnchorPane pane=FXMLLoader.load(getClass().getResource("s2statement10.fxml"));
anchor.getChildren().setAll(pane);
   }
    

   
}