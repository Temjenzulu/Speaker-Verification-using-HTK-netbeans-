/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avsystem;
import com.emaraic.recorder.CamRecorder;
import java.awt.BorderLayout;
import java.awt.Button;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;
import java.util.ResourceBundle;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javafx.embed.swing.SwingNode;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer;
import javax.sound.sampled.TargetDataLine;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import org.bytedeco.javacpp.avcodec;
import org.bytedeco.javacv.CanvasFrame;
import org.bytedeco.javacv.FFmpegFrameRecorder;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.FrameRecorder;
import org.bytedeco.javacv.OpenCVFrameGrabber;

public class Capture extends MicStatus implements Initializable{
  

    
final private static int WEBCAM_DEVICE_INDEX = 0;
    final private static int AUDIO_DEVICE_INDEX = 6;
public static final String FILENAME = "output.flv";
    final private static int FRAME_RATE = 30;
    final private static int GOP_LENGTH_IN_FRAMES = 60;

    private static long startTime = 0;
    private static long videoTS = 0;
    String s1=null;
    
        String s=null;
         String c=null;
     public MicStatus ms=new MicStatus();
      public MicStatus ns=new MicStatus();
      @FXML
    AnchorPane recordPane,recordPane1,anchor;
    @FXML
    private ToggleButton record,stop,camera;
    @FXML
       CamRecorder ls=new CamRecorder();
       

    @FXML
    public void again(ActionEvent event) throws IOException
    {
         AnchorPane pane= FXMLLoader.load(getClass().getResource("Main.fxml"));
anchor.getChildren().setAll(pane);
    }
    @FXML
        public void exit(ActionEvent event)
    {
        System.exit(0);
    }
    
    public void record(ActionEvent event) throws FrameRecorder.Exception, FrameGrabber.Exception
    {

      
        record.setDisable(true);
        stop.setDisable(false);
        ms.startRecording();
      
        SwingNode swingNode = new SwingNode();
        createSwingContent(swingNode);
   
        recordPane.getChildren().add(swingNode);

        ls.grabber1();
    }
     private void createSwingContent(final SwingNode swingNode ) {
         
         
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() 
            {
                swingNode.setContent(ms.contentPane);    
            }
            
        });}
        
 @FXML
    public void stop(ActionEvent event) throws IOException
    {
       
       
ms.sR.stop();

         
                  Stage stage = new Stage();
    Parent root = FXMLLoader.load(getClass().getResource("playrecorded.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }
      public void camera(ActionEvent event) throws IOException
             
    { 
          camera.setDisable(true);
        ls.CamRecorder1();
    }
     public void finish(ActionEvent event) throws IOException
             
    {   
         ls.grabber();
        ms.sR.stop();
        BufferedReader br = new BufferedReader(new FileReader("/home/zzzz/Desktop/KICHUHTK/test.txt"));
        s1=br.readLine();
        System.out.println(s1);
       PrintWriter writer = new PrintWriter("/home/zzzz/Desktop/KICHUHTK/test.txt");
                writer.println("/home/zzzz/Desktop/KICHUHTK/" + s1.concat(".mfcc"));
                writer.close();
                 BufferedReader bl = new BufferedReader(new FileReader("/home/zzzz/Desktop/KICHUHTK/test.txt"));
        c=bl.readLine();
        System.out.println(s1);
       PrintWriter write = new PrintWriter("/home/zzzz/Desktop/KICHUHTK/line1");
                write.println("/home/zzzz/Desktop/KICHUHTK/" + s1.concat(".wav"));
                write.close();
                
         BufferedReader b = new BufferedReader(new FileReader("/home/zzzz/Desktop/KICHUHTK/me"));
        s=b.readLine();
       
       PrintWriter writr = new PrintWriter("/home/zzzz/Desktop/KICHUHTK/me");
                writr.println(s.concat("\t"+"/home/zzzz/Desktop/KICHUHTK/" +s1.concat(".mfcc")));
                writr.close();

           AnchorPane pane= FXMLLoader.load(getClass().getResource("verify.fxml"));
anchor.getChildren().setAll(pane);
    }
 @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }}