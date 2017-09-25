package com.emaraic.recorder;
import com.esotericsoftware.tablelayout.swing.Table;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import avsystem.Capture;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.bytedeco.javacpp.avcodec;
import org.bytedeco.javacv.FFmpegFrameRecorder;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.FrameRecorder.Exception;
import org.bytedeco.javacv.Java2DFrameConverter;
import org.bytedeco.javacv.OpenCVFrameConverter;
import org.bytedeco.javacv.OpenCVFrameGrabber;

import static java.lang.Thread.sleep;

/**
 *
 * @author: Taha Emara 
 * Website: http://www.emaraic.com
 * E-mail: taha@emaraic.com
 */
public class CamRecorder extends JFrame { 
 public boolean me=false;
 String m=null;
    private JButton button1 = new JButton("One");
    private JButton control;
    private JPanel canvas;
    private static FFmpegFrameRecorder recorder = null;
    private static OpenCVFrameGrabber grabber = null;
    private static final int WEBCAM_DEVICE_INDEX = 0;
    private static final int CAPTUREWIDTH = 400;
    private static final int CAPTUREHRIGHT = 400;
    private static final int FRAME_RATE = 15;
    private static final int GOP_LENGTH_IN_FRAMES = 60;
    private volatile boolean runnable = true;
    private static final long serialVersionUID = 1L;
    private Catcher cat;
    private Thread catcher;

    public void CamRecorder1() {
        grabber = new OpenCVFrameGrabber(WEBCAM_DEVICE_INDEX);
        cat = new Catcher();

        setTitle("Camera Recorder");
     
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        control = new JButton(" ");
        canvas = new JPanel();
        Table table = new Table();
        table.pad(0);
        getContentPane().add(table);
        canvas.setBorder(BorderFactory.createEtchedBorder());
        table.addCell(canvas).width(CAPTUREWIDTH).height(CAPTUREHRIGHT);
        table.row();
        table.addCell(control);
        table.row();
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        
            catcher = new Thread(cat);
            catcher.start();
            runnable = true;
        
       

        
        //table.debug();
    }
    public void grabber() throws Exception, FrameGrabber.Exception{
catcher.stop();
            recorder.stop();
            grabber.stop();
            runnable = false;
         dispose();
    }
  public void grabber1() throws Exception, FrameGrabber.Exception
  {
    
      
        
         control.setText("Recording...");
        }
          
           
                   
        
    

    class Catcher implements Runnable {

        @Override
        public void run() {
            synchronized (this) {
               // while (runnable) {
                    try {
                        
                        grabber.setImageWidth(CAPTUREWIDTH);
                        grabber.setImageHeight(CAPTUREHRIGHT);
                        grabber.start();
                          BufferedReader bs = new BufferedReader(new FileReader("/home/zzzz/Desktop/KICHUHTK/id.txt"));
                          m=bs.readLine();
                        recorder = new FFmpegFrameRecorder(
                                "/home/zzzz/Desktop/"+ m.concat(".mp4"),
                                CAPTUREWIDTH, CAPTUREHRIGHT, 2);
                        recorder.setInterleaved(true);
                        // video options //
                        recorder.setVideoOption("tune", "zerolatency");
                        recorder.setVideoOption("preset", "ultrafast");
                        recorder.setVideoOption("crf", "28");
                        recorder.setVideoBitrate(2000000);
                        recorder.setVideoCodec(avcodec.AV_CODEC_ID_H264);
                        recorder.setFormat("mp4");
                        recorder.setFrameRate(FRAME_RATE);
                        recorder.setGopSize(GOP_LENGTH_IN_FRAMES);
                        // audio options //
                        recorder.setAudioOption("crf", "0");
                        recorder.setAudioQuality(0);
                        recorder.setAudioBitrate(192000);
                        recorder.setSampleRate(44100);
                        recorder.setAudioChannels(2);
                        recorder.setAudioCodec(avcodec.AV_CODEC_ID_AAC);

                        recorder.start();

                        Frame capturedFrame = null;
                        Java2DFrameConverter paintConverter = new Java2DFrameConverter();
                       long startTime = System.currentTimeMillis();
                        long frame = 0;
                        while ((capturedFrame = grabber.grab()) != null&&runnable) {
                            BufferedImage buff = paintConverter.getBufferedImage(capturedFrame, 1);
                            Graphics g = canvas.getGraphics();
                            g.drawImage(buff, 0, 0, CAPTUREWIDTH, CAPTUREHRIGHT, 0, 0, buff.getWidth(), buff.getHeight(), null);
                            if (control.getText().equals("Recording..."))
                            {
                          
                            recorder.record(capturedFrame);
                            }
                            
                        }
                    } catch (FrameGrabber.Exception ex) {
                        Logger.getLogger(CamRecorder.class.getName()).log(Level.SEVERE, null, ex);
                    }catch (Exception ex) {
                        Logger.getLogger(CamRecorder.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (FileNotFoundException ex) {
                    Logger.getLogger(CamRecorder.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(CamRecorder.class.getName()).log(Level.SEVERE, null, ex);
                }
                //}//end of while


                //}//end of while
            }
        }
    }


}