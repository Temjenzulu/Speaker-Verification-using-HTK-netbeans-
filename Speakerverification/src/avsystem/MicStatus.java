/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avsystem;
import java.awt.EventQueue;
import java.awt.Component;
import javax.swing.SwingWorker;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;

import java.awt.GraphicsEnvironment;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.awt.Transparency;
import java.awt.geom.Path2D;

import java.io.File;
import java.io.IOException;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import static java.lang.String.format;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.TargetDataLine;

public class MicStatus extends JPanel
implements ActionListener {

    String s1=null;
    public static final int DEF_BUFFER_SAMPLE_SZ = 1024;
    
    public static final Color LIGHT_BLUE = new Color(128, 192, 255);
    public static final Color DARK_BLUE = new Color(0, 0, 127);
    private ByteArrayOutputStream recordBytes;
    private TargetDataLine audioLine;
    private AudioFormat format;
    public boolean isRunning;
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public enum PlayStat {
        NO_FILE, PLAYING, PAUSED, STOPPED
    }
    
    public interface PlayerRef {
        public Object getLock();
        public PlayStat getStat();
        public File getFile();
        public void playbackEnded();
        public void drawDisplay(float[] samples, int svalid);
        public void drawDisplay1(float[] samples, int svalid);
    }
    
 
    public JPanel contentPane = new JPanel(new BorderLayout());
    private JLabel fileLabel = new JLabel("No file loaded");
    private DisplayPanel displayPanel = new DisplayPanel();
    private JToolBar playbackTools = new JToolBar();
    
    private ToolsButton bOpen = new ToolsButton("Open");
    private ToolsButton bPlay = new ToolsButton("Play");
    private ToolsButton bPause = new ToolsButton("Pause");
    private ToolsButton bStop = new ToolsButton("Stop");
    
    private File audioFile;
    private AudioFormat audioFormat;
    
    private final Object statLock = new Object();
    
    private volatile PlayStat playStat = PlayStat.NO_FILE;
        public SoundRecord sR = new SoundRecord();
    
    private Thread recordThread;
    
    private final PlayerRef thisPlayer = new PlayerRef() {
        @Override
        public Object getLock() {
            return statLock;
        }
        
        @Override
        public PlayStat getStat() {
            return playStat;
        }
        
        @Override
        public File getFile() {
            return audioFile;
        }
        
        @Override
        public void playbackEnded() {
            synchronized(statLock) {
                playStat = PlayStat.STOPPED;
            }
            displayPanel.reset();
            displayPanel.repaint();
        }
         @Override
        public void drawDisplay(float[] samples, int svalid) {
            displayPanel.makePath(samples, svalid);
            displayPanel.repaint();
            try {
                func();
            } catch (IOException ex) {
                Logger.getLogger(MicStatus.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(MicStatus.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        private void func() throws IOException, InterruptedException {
             BufferedReader br = new BufferedReader(new FileReader("/home/zzzz/Desktop/KICHUHTK/test.txt"));
        s1=br.readLine();
            File wavFileName = new File("/home/zzzz/Desktop/KICHUHTK/"+s1.concat(".wav"));
            SoundRecord sr = new SoundRecord();
            sr.save(wavFileName);
        BufferedReader b = new BufferedReader(new FileReader("/home/zzzz/Desktop/KICHUHTK/test.txt"));
        s1=b.readLine();
        System.out.println(s1);
       PrintWriter writr = new PrintWriter("/home/zzzz/Desktop/KICHUHTK/me");
                writr.println("/home/zzzz/Desktop/KICHUHTK/" + s1.concat(".wav"));
                writr.close();
        }
    ;
        
        @Override
        public void drawDisplay1(float[] samples, int svalid) {
            displayPanel.makePath(samples, svalid);
            displayPanel.repaint();
        }
    };
    
    public MicStatus() {
        assert EventQueue.isDispatchThread();
        
      
        
        playbackTools.setFloatable(false);
        playbackTools.add(bOpen);
        playbackTools.add(bPlay);
        playbackTools.add(bPause);
        playbackTools.add(bStop);
        
        bOpen.addActionListener(this);
        bPlay.addActionListener(this);
        bPause.addActionListener(this);
        bStop.addActionListener(this);
        
        fileLabel.setOpaque(true);
        fileLabel.setBackground(Color.BLACK);
        fileLabel.setForeground(Color.WHITE);
        fileLabel.setHorizontalAlignment(JLabel.CENTER);
        
        playbackTools.setBackground(Color.GRAY);
        playbackTools.setMargin(new Insets(0, 24, 0, 0));
        
 
        contentPane.add(displayPanel, BorderLayout.CENTER);
       
        
       
    }
    
    private void systemExit() {
        boolean wasPlaying;
        synchronized(statLock) {
            if(wasPlaying = (playStat == PlayStat.PLAYING)) {
                playStat = PlayStat.STOPPED;
            }
        }
        

        
        if(wasPlaying) {
            /* 
             * helps prevent 'tearing' sound
             * if exit happens while during playback
             * 
             */
            try {
                Thread.sleep(250L);
            } catch(InterruptedException ie) {}
        }
        
        System.exit(0);
    }
    
           
private void loadAudio() throws UnsupportedAudioFileException, IOException {
          File selected = new File("/home/zzzz/Desktop/KICHUHTK/test.txt");
         AudioFileFormat fmt = AudioSystem.getAudioFileFormat(selected);
                
                audioFile = selected;
                audioFormat = fmt.getFormat();
               
                playStat = MicStatus.PlayStat.STOPPED;}
 
     
        
     public void change() throws UnsupportedAudioFileException, IOException {
            
        
            loadAudio();
        
            
    
            synchronized(statLock) {
             
                        playStat = MicStatus.PlayStat.PLAYING;
                        new MicStatus.PlaybackLoop(thisPlayer).execute();
            }}
  public void startRecording() 
   {
                 
		recordThread = new Thread(new Runnable() 
                {
			@Override
			public void run() 
                        {
				try 
                                {
					

					sR.startRecorder();

				} catch (Exception ex) {
                                    ex.printStackTrace();
				}
			}
		}); recordThread.start();
    }
    
    private static void showError(Throwable t) {
        JOptionPane.showMessageDialog(null,
            "Exception <" + t.getClass().getName() + ">" +
            " with message '" + t.getMessage() + "'.",
            "There was an error",
            JOptionPane.WARNING_MESSAGE
        );
    }
    
    public static class PlaybackLoop
    extends SwingWorker<Void, Void> {
        
        private final PlayerRef playerRef;
        
        public PlaybackLoop(PlayerRef pr) {
            playerRef = pr;
        }
        
        @Override
        public Void doInBackground() {
            try {
                AudioInputStream in = null;
                SourceDataLine out = null;
                
                try {
                    try {
                        final AudioFormat audioFormat = (
                            AudioSystem.getAudioFileFormat(playerRef.getFile()).getFormat()
                        );
                        
                        in = AudioSystem.getAudioInputStream(playerRef.getFile());
                        out = AudioSystem.getSourceDataLine(audioFormat);
                        
                        final int normalBytes = normalBytesFromBits(audioFormat.getSampleSizeInBits());
                        
                        float[] samples = new float[DEF_BUFFER_SAMPLE_SZ * audioFormat.getChannels()];
                        long[] transfer = new long[samples.length];
                        byte[] bytes = new byte[samples.length * normalBytes];
                        
                        out.open(audioFormat, bytes.length);
                        out.start();
                        
                        /*
                         * feed the output some zero samples
                         * helps prevent the 'stutter' issue.
                         * 
                         */
                        
                        for(int feed = 0; feed < 6; feed++) {
                            out.write(bytes, 0, bytes.length);
                        }
                        
                        int bread;
                        
                        play_loop: do {
                            while(playerRef.getStat() == PlayStat.PLAYING) {
                                
                                if((bread = in.read(bytes)) == -1) {
                                    
                                    break play_loop; // eof
                                }
                                
                                samples = unpack(bytes, transfer, samples, bread, audioFormat);
                                samples = window(samples, bread / normalBytes, audioFormat);
                                
                                playerRef.drawDisplay1(samples, bread / normalBytes);
                                
                                out.write(bytes, 0, bread);
                            }
                            
                            if(playerRef.getStat() == PlayStat.PAUSED) {
                                out.flush();
                                try {
                                    synchronized(playerRef.getLock()) {
                                        playerRef.getLock().wait(1000L);
                                    }
                                } catch(InterruptedException ie) {}
                                continue;
                            } else {
                                break;
                            }
                        } while(true);
                        
                    } catch(UnsupportedAudioFileException uafe) {
                        showError(uafe);
                    } catch(LineUnavailableException lue) {
                        showError(lue);
                    }
                } finally {
                    if(in != null) {
                        in.close();
                    }
                    if(out != null) {
                        out.flush();
                        out.close();
                    }
                }
            } catch(IOException ioe) {
                showError(ioe);
            }
            
            return (Void)null;
        }
        
        @Override
        public void done() {
            playerRef.playbackEnded();
            
            try {
                get();
            } catch(InterruptedException io) {
            } catch(CancellationException ce) {
            } catch(ExecutionException ee) {
                showError(ee.getCause());
            }
        }
    }
    
    public static float[] unpack(
        byte[] bytes,
        long[] transfer,
        float[] samples,
        int bvalid,
        AudioFormat fmt
    ) {
        if(fmt.getEncoding() != AudioFormat.Encoding.PCM_SIGNED
                && fmt.getEncoding() != AudioFormat.Encoding.PCM_UNSIGNED) {
            
            return samples;
        }
        
        final int bitsPerSample = fmt.getSampleSizeInBits();
        final int bytesPerSample = bitsPerSample / 8;
        final int normalBytes = normalBytesFromBits(bitsPerSample);
        
        /*
         * not the most DRY way to do this but it's a bit more efficient.
         * otherwise there would either have to be 4 separate methods for
         * each combination of endianness/signedness or do it all in one
         * loop and check the format for each sample.
         * 
         * a helper array (transfer) allows the logic to be split up
         * but without being too repetetive.
         * 
         * here there are two loops converting bytes to raw long samples.
         * integral primitives in Java get sign extended when they are
         * promoted to a larger type so the & 0xffL mask keeps them intact.
         * 
         */
        
        if(fmt.isBigEndian()) {
            for(int i = 0, k = 0, b; i < bvalid; i += normalBytes, k++) {
                transfer[k] = 0L;
                
                int least = i + normalBytes - 1;
                for(b = 0; b < normalBytes; b++) {
                    transfer[k] |= (bytes[least - b] & 0xffL) << (8 * b);
                }
            }
        } else {
            for(int i = 0, k = 0, b; i < bvalid; i += normalBytes, k++) {
                transfer[k] = 0L;
                
                for(b = 0; b < normalBytes; b++) {
                    transfer[k] |= (bytes[i + b] & 0xffL) << (8 * b);
                }
            }
        }
        
        final long fullScale = (long)Math.pow(2.0, bitsPerSample - 1);
        
        /*
         * the OR is not quite enough to convert,
         * the signage needs to be corrected.
         * 
         */
        
        if(fmt.getEncoding() == AudioFormat.Encoding.PCM_SIGNED) {
            
            /*
             * if the samples were signed, they must be
             * extended to the 64-bit long.
             * 
             * the arithmetic right shift in Java  will fill
             * the left bits with 1's if the MSB is set.
             * 
             * so sign extend by first shifting left so that
             * if the sample is supposed to be negative,
             * it will shift the sign bit in to the 64-bit MSB
             * then shift back and fill with 1's.
             * 
             * as an example, imagining these were 4-bit samples originally
             * and the destination is 8-bit, if we have a hypothetical
             * sample -5 that ought to be negative, the left shift looks
             * like this:
             * 
             *     00001011
             *  <<  (8 - 4)
             *  ===========
             *     10110000
             * 
             * (except the destination is 64-bit and the original
             * bit depth from the file could be anything.)
             * 
             * and the right shift now fills with 1's:
             * 
             *     10110000
             *  >>  (8 - 4)
             *  ===========
             *     11111011
             * 
             */
            
            final long signShift = 64L - bitsPerSample;
            
            for(int i = 0; i < transfer.length; i++) {
                transfer[i] = (
                    (transfer[i] << signShift) >> signShift
                );
            }
        } else {
            
            /*
             * unsigned samples are easier since they
             * will be read correctly in to the long.
             * 
             * so just sign them:
             * subtract 2^(bits - 1) so the center is 0.
             * 
             */
            
            for(int i = 0; i < transfer.length; i++) {
                transfer[i] -= fullScale;
            }
        }
        
        /* finally normalize to range of -1.0f to 1.0f */
        
        for(int i = 0; i < transfer.length; i++) {
            samples[i] = (float)transfer[i] / (float)fullScale;
        }
        
        return samples;
    }
    
    public static float[] window(
        float[] samples,
        int svalid,
        AudioFormat fmt
    ) {
        /*
         * most basic window function
         * multiply the window against a sine curve, tapers ends
         * 
         * nested loops here show a paradigm for processing multi-channel formats
         * the interleaved samples can be processed "in place"
         * inner loop processes individual channels using an offset
         * 
         */
        
        int channels = fmt.getChannels();
        int slen = svalid / channels;
        
        for(int ch = 0, k, i; ch < channels; ch++) {
            for(i = ch, k = 0; i < svalid; i += channels) {
                samples[i] *= Math.sin(Math.PI * k++ / (slen - 1));
            }
        }
        
        return samples;
    }
    
    public static int normalBytesFromBits(int bitsPerSample) {
        
        /*
         * some formats allow for bit depths in non-multiples of 8.
         * they will, however, typically pad so the samples are stored
         * that way. AIFF is one of these formats.
         * 
         * so the expression:
         * 
         *  bitsPerSample + 7 >> 3
         * 
         * computes a division of 8 rounding up (for positive numbers).
         * 
         * this is basically equivalent to:
         * 
         *  (int)Math.ceil(bitsPerSample / 8.0)
         * 
         */
        
        return bitsPerSample + 7 >> 3;
    }
    
    public class DisplayPanel
    extends JPanel {
        
        private final BufferedImage image;
        
        private final Path2D.Float[] paths = {
            new Path2D.Float(), new Path2D.Float(), new Path2D.Float()
        };
        
        private final Object pathLock = new Object();
        
        {
            Dimension pref = getPreferredSize();
            
            image = (
                GraphicsEnvironment
                .getLocalGraphicsEnvironment()
                .getDefaultScreenDevice()
                .getDefaultConfiguration()
                .createCompatibleImage(
                    pref.width, pref.height, Transparency.OPAQUE
                )
            );
        }
        
        public DisplayPanel() {
            setOpaque(false);
        }
        
        public void reset() {
            Graphics2D g2d = image.createGraphics();
            g2d.setBackground(Color.BLACK);
            g2d.clearRect(0, 0, image.getWidth(), image.getHeight());
            g2d.dispose();
        }
        
        public void makePath(float[] samples, int svalid) {
            if(audioFormat == null) {
                return;
            }
            
            /* shuffle */
            
            Path2D.Float current = paths[2];
            paths[2] = paths[1];
            paths[1] = paths[0];
            
            /* lots of ratios */
            
            float avg = 0f;
            float hd2 = getHeight() / 2f;
            
            final int channels = audioFormat.getChannels();
            
            /* 
             * have to do a special op for the
             * 0th samples because moveTo.
             * 
             */
            
            int i = 0;
            while(i < channels && i < svalid) {
                avg += samples[i++];
            }
            
            avg /= channels;
            
            current.reset();
            current.moveTo(0, hd2 - avg * hd2);
            
            int fvalid = svalid / channels;
            for(int ch, frame = 0; i < svalid; frame++) {
                avg = 0f;
                
                /* average the channels for each frame. */
                
                for(ch = 0; ch < channels; ch++) {
                    avg += samples[i++];
                }
                
                avg /= channels;
                
                current.lineTo(
                    (float)frame / fvalid * image.getWidth(), hd2 - avg * hd2
                );
            }
            
            paths[0] = current;
                
            Graphics2D g2d = image.createGraphics();
            
            synchronized(pathLock) {
                g2d.setBackground(Color.BLACK);
                g2d.clearRect(0, 0, image.getWidth(), image.getHeight());
                
                g2d.setRenderingHint(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON
                );
                g2d.setRenderingHint(
                    RenderingHints.KEY_STROKE_CONTROL,
                    RenderingHints.VALUE_STROKE_PURE
                );
                
                g2d.setPaint(DARK_BLUE);
                g2d.draw(paths[2]);
                
                g2d.setPaint(LIGHT_BLUE);
                g2d.draw(paths[1]);
                
                g2d.setPaint(Color.WHITE);
                g2d.draw(paths[0]);
            }
            
            g2d.dispose();
        }
        
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            
            synchronized(pathLock) {
                g.drawImage(image, 0, 0, null);
            }
        }
        
        @Override
        public Dimension getPreferredSize() {
            return new Dimension(DEF_BUFFER_SAMPLE_SZ / 4, 128);
        }
        
        @Override
        public Dimension getMinimumSize() {
            return getPreferredSize();
        }
        
        @Override
        public Dimension getMaximumSize() {
            return getPreferredSize();
        }
    }
    
    public static class ToolsButton
    extends JButton {
        public ToolsButton(String text) {
            super(text);
            
            setOpaque(true);
            setBorderPainted(true);
            setBackground(Color.BLACK);
            setForeground(Color.WHITE);
            
            setBorder(new LineBorder(Color.GRAY) {
                @Override
                public Insets getBorderInsets(Component c) {
                    return new Insets(1, 4, 1, 4);
                }
                @Override
                public Insets getBorderInsets(Component c, Insets i) {
                    return getBorderInsets(c);
                }
            });
            
            Font font = getFont();
            setFont(font.deriveFont(font.getSize() - 1f));
            
            addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent me) {
                    if(me.getButton() == MouseEvent.BUTTON1) {
                        setForeground(LIGHT_BLUE);
                    }
                }
                @Override
                public void mouseReleased(MouseEvent me) {
                    if(me.getButton() == MouseEvent.BUTTON1) {
                        setForeground(Color.WHITE);
                    }
                }
            });
        }
    }

    public class SoundRecord{
	/**
	 * Defines a default audio format used to record
	 */
        	

      AudioFormat getAudioFormat() {
        float sampleRate = 16000;
        int sampleSizeInBits = 16;
        int channels = 1;
        boolean signed = true;
        boolean bigEndian = true;
        AudioFormat audioFormat = new AudioFormat(sampleRate, sampleSizeInBits,
                                             channels, signed, bigEndian);
        return audioFormat;
    }
 

	/**
	 * Start recording sound.
	 * @throws LineUnavailableException if the system does not support the specified 
	 * audio format nor open the audio data line.
	 */
	public void startRecorder() throws LineUnavailableException, IOException, UnsupportedAudioFileException 
        {    
           
            audioFormat = getAudioFormat();
            System.out.println(format);
            DataLine.Info info = new DataLine.Info(TargetDataLine.class, audioFormat);

            if (!AudioSystem.isLineSupported(info)) 
            {
                
                throw new LineUnavailableException("The system does not support the specified format.");
            }
            audioLine = AudioSystem.getTargetDataLine(audioFormat);

            int bytesRead = 0;
            recordBytes = new ByteArrayOutputStream();
            isRunning = true;
            float[] samples = new float[DEF_BUFFER_SAMPLE_SZ * audioFormat.getChannels()];
            long[] transfer = new long[samples.length];
            final int normalBytes = normalBytesFromBits(audioFormat.getSampleSizeInBits());
            byte[] bytes = new byte[samples.length * normalBytes];
            audioLine.open(audioFormat,bytes.length);
            audioLine.start();
            

          //  loadAudio(0);
            
            while (isRunning) 
            {
                
                bytesRead = audioLine.read(bytes, 0, bytes.length);


                samples = unpack(bytes, transfer, samples, bytesRead, audioFormat);
                samples = window(samples, bytesRead / normalBytes, audioFormat);
                
                recordBytes.write(bytes, 0, bytesRead);
                
                thisPlayer.drawDisplay(samples, bytesRead / normalBytes);
                
                
            }
        }

	/**
	 * Stop recording sound.
	 * @throws IOException if any I/O error occurs.
	 */
	public void stop() throws IOException {
		isRunning = false;
		
		if (audioLine != null) {
			audioLine.drain();
			audioLine.close();
		}
	}


        
        public void save(File wavFile) throws IOException, InterruptedException {
              
       
		byte[] audioData = recordBytes.toByteArray();
          
		ByteArrayInputStream bais = new ByteArrayInputStream(audioData);
                AudioInputStream audioInputStream = new AudioInputStream(bais, audioFormat,audioData.length);		
		AudioSystem.write(audioInputStream, AudioFileFormat.Type.WAVE, wavFile);
        }}}
