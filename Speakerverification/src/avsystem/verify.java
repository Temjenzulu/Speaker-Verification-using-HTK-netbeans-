/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avsystem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;
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
public class verify {
    String ths=null;
    String thisLine=null;
    @FXML
    AnchorPane anchor;
   @FXML
    public void verify(ActionEvent event) throws IOException, InterruptedException
    {
        try {
                        String target = new String("/home/zzzz/Desktop/KICHUHTK/silenceremoval.sh");
// String target = new String("mkdir stackOver");
                        Runtime rt = Runtime.getRuntime();
                        Process proc = rt.exec(target);
                        proc.waitFor();
                        StringBuffer output = new StringBuffer();
                        BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
                        String line = "";                       
                        while ((line = reader.readLine())!= null) {
                                output.append(line + "\n");
                        }
                        System.out.println("### " + output);
                } catch (Throwable t) {
                        t.printStackTrace();
                }
         try {
                        String target = new String("/home/zzzz/Desktop/KICHUHTK/testi.sh");
// String target = new String("mkdir stackOver");
                        Runtime rt = Runtime.getRuntime();
                        Process proc = rt.exec(target);
                        proc.waitFor();
                        StringBuffer output = new StringBuffer();
                        BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
                        String line = "";                       
                        while ((line = reader.readLine())!= null) {
                                output.append(line + "\n");
                        }
                        System.out.println("### " + output);
                } catch (Throwable t) {
                        t.printStackTrace();
                }
        try {
                        String target = new String("/home/zzzz/Desktop/KICHUHTK/test_script.sh");
// String target = new String("mkdir stackOver");
                        Runtime rt = Runtime.getRuntime();
                        Process proc = rt.exec(target);
                        proc.waitFor();
                        StringBuffer output = new StringBuffer();
                        BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
                        String line = "";                       
                        while ((line = reader.readLine())!= null) {
                                output.append(line + "\n");
                        }
                        System.out.println("### " + output);
                } catch (Throwable t) {
                        t.printStackTrace();
         
               }
                try {
                        String target = new String("/home/zzzz/Desktop/KICHUHTK/cleari.sh");
// String target = new String("mkdir stackOver");
                        Runtime rt = Runtime.getRuntime();
                        Process proc = rt.exec(target);
                        proc.waitFor();
                        StringBuffer output = new StringBuffer();
                        BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
                        String line = "";                       
                        while ((line = reader.readLine())!= null) {
                                output.append(line + "\n");
                        }
                        System.out.println("### " + output);
                } catch (Throwable t) {
                        t.printStackTrace();
                }
      int i=0;
                String sr=null;
                String sl=null;
                String st=null;
                String s=null;
                String sb=null;
        int j=0;
          BufferedReader bs = new BufferedReader(new FileReader("/home/zzzz/Desktop/KICHUHTK/recount_test.mlf"));
                for(j=0;j<3;j++)
           {
      
      sr=bs.readLine();
           }
               String[] ar = sr.split(" "); 
               sl=ar[2];
                BufferedReader bz = new BufferedReader(new FileReader("/home/zzzz/Desktop/KICHUHTK/ID.txt"));
                st=bz.readLine();
                
                if(sl.equals(st))
                { 
                       try {
                        String target = new String("/home/zzzz/Desktop/KICHUHTK/testv.sh");
// String target = new String("mkdir stackOver");
                        Runtime rt = Runtime.getRuntime();
                        Process proc = rt.exec(target);
                        proc.waitFor();
                        StringBuffer output = new StringBuffer();
                        BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
                        String line = "";                       
                        while ((line = reader.readLine())!= null) {
                                output.append(line + "\n");
                        }
                        System.out.println("### " + output);
                } catch (Throwable t) {
                        t.printStackTrace();
                }
                    String target = new String("/home/zzzz/Desktop/KICHUHTK/testfinal.sh");
// String target = new String("mkdir stackOver");
                        Runtime rt = Runtime.getRuntime();
                        Process proc = rt.exec(target);
                        proc.waitFor();
                        StringBuffer output = new StringBuffer();
                        BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
                        String line = "";                       
                        while ((line = reader.readLine())!= null) {
                                output.append(line + "\n");
                        }
                        System.out.println("### " + output);
                              BufferedReader b = new BufferedReader(new FileReader("/home/zzzz/Desktop/KICHUHTK/likelihood.log"));
             
            for(i=0;i<5;i++)
           {
      
      s=b.readLine();
           }
      
        String[] arr = s.split(" ");
          sb=arr[6];
    PrintWriter writr = new PrintWriter("/home/zzzz/Desktop/KICHUHTK/score.txt");
       
                writr.println(sb);
                writr.close();
         Scanner textfile = new Scanner(new File("/home/zzzz/Desktop/KICHUHTK/score.txt"));
         
        double nextInt=0;
        double nextIn=-104.6300;
     
    nextInt = textfile.nextDouble();

      if(nextInt>nextIn)
      {
       
          try {
                        String targe = new String("/home/zzzz/Desktop/KICHUHTK/clearv.sh");
// String target = new String("mkdir stackOver");
                        Runtime r = Runtime.getRuntime();
                        Process pro = r.exec(targe);
                        pro.waitFor();
                        StringBuffer outpu = new StringBuffer();
                        BufferedReader reade = new BufferedReader(new InputStreamReader(pro.getInputStream()));
                        String lin = "";                       
                        while ((line = reade.readLine())!= null) {
                                outpu.append(lin + "\n");
                        }
                        System.out.println("### " + outpu);
                } catch (Throwable t) {
                        t.printStackTrace();
                }
        
      AnchorPane pane= FXMLLoader.load(getClass().getResource("Result1.fxml"));
anchor.getChildren().setAll(pane);
          }
          else
          {
            try {
                        String targe = new String("/home/zzzz/Desktop/KICHUHTK/clearv.sh");
// String target = new String("mkdir stackOver");
                        Runtime r = Runtime.getRuntime();
                        Process pro = r.exec(targe);
                        pro.waitFor();
                        StringBuffer outpu = new StringBuffer();
                        BufferedReader reade = new BufferedReader(new InputStreamReader(pro.getInputStream()));
                        String lin = "";                       
                        while ((lin = reade.readLine())!= null) {
                                outpu.append(lin + "\n");
                        }
                        System.out.println("### " + outpu);
                } catch (Throwable t) {
                        t.printStackTrace();
                }
     AnchorPane pane= FXMLLoader.load(getClass().getResource("Result2.fxml"));
anchor.getChildren().setAll(pane);
          }
                        
                        
                 }
                
                  
                
        
                else {
                     AnchorPane pane= FXMLLoader.load(getClass().getResource("Result2.fxml"));
anchor.getChildren().setAll(pane);

                        String targe = new String("/home/zzzz/Desktop/KICHUHTK/clearv.sh");
// String target = new String("mkdir stackOver");
                        Runtime r = Runtime.getRuntime();
                        Process pro = r.exec(targe);
                        pro.waitFor();
                        StringBuffer outpu = new StringBuffer();
                        BufferedReader reade = new BufferedReader(new InputStreamReader(pro.getInputStream()));
                        String lin = "";                       
                        while ((lin = reade.readLine())!= null) {
                                outpu.append(lin + "\n");
                        }
                        System.out.println("### " + outpu);
                
                
                }      
        
       

          
    
        }}
