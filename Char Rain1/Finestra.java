import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.lang.*;
import java.io.File;
import java.util.Date;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.*; 
import java.lang.Object.*;
import java.io.InputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.*;
import java.io.IOException;


//import sun.audio.*;

public class Finestra extends JFrame implements ActionListener, MouseListener
{
    private int lunghezza;
    private String parola;
    private int coordinatex=0;
    private int coordinatey=0;
    JLabel labelparola;
    private int punteggio;
    private int livello=0;
    private int posappo;
    public JTextField testo;
    private String tentativo;
    JButton invia;
    JButton stop;
    JLabel labelpunteggio;
    JLabel labellivello;
    JLabel labelstart;
    JLabel linea;
    JLabel fine;
    JLabel labelleoricucci;
    JLabel labelsaba;
    JLabel labelcassano;
    String suono;
    
    ArrayList<String> arrayparole= new ArrayList();
    private int contparole;
    
    ArrayList<String> arraysillabe= new ArrayList();
    private int contsillabe;
    
    ArrayList<String> arraylettere= new ArrayList();
    private int contlettere;
    
    Timer t1;
    Timer t2;
    Timer t3;
    
    AePlayWave suonodiavvio= new AePlayWave("suonodiavvio.wav");
    AePlayWave esplosione= new AePlayWave("esplosione.wav");
    AePlayWave tin= new AePlayWave("tin.wav");
    AePlayWave comecassano= new AePlayWave("comecassano.wav");
    AePlayWave comesabatelli= new AePlayWave("comesabatelli.wav");
    AePlayWave comeleoricucci= new AePlayWave("comeleoricucci.wav");
    AePlayWave musichetta= new AePlayWave("musichetta.wav");
    
    public Finestra() throws UnsupportedAudioFileException, IOException, LineUnavailableException
    {
      t1=new Timer(20, this);
      t1.setActionCommand("TIMER");
      
      t2=new Timer(10, this);
      t2.setActionCommand("TIMER");
      
      t3=new Timer(1, this);
      t3.setActionCommand("TIMER");
      
      setSize(800,600);        
      setLayout(new BorderLayout());
      
      musichetta.start();
      
      //parole
      arrayparole= new ArrayList();
      try 
      {
          File myObj = new File("parole.txt");
          Scanner myReader = new Scanner(myObj);
          while (myReader.hasNextLine()) 
          {
                String data = myReader.nextLine();
                arrayparole.add(data);
                contparole++;
          }
          myReader.close();
      } 
      catch (FileNotFoundException e) 
      {
          System.out.println("An error occurred.");
          e.printStackTrace();
      }
      //sillabe
      try 
      {
          File myObj = new File("sillabe.txt");
          Scanner myReader = new Scanner(myObj);
          while (myReader.hasNextLine()) 
          {
                String data = myReader.nextLine();
                arraysillabe.add(data);
                contsillabe++;
          }
          myReader.close();
      } 
      catch (FileNotFoundException e) 
      {
          System.out.println("An error occurred.");
          e.printStackTrace();
      }
      //lettere
      try 
      {
          File myObj = new File("lettere.txt");
          Scanner myReader = new Scanner(myObj);
          while (myReader.hasNextLine()) 
          {
                String data = myReader.nextLine();
                arraylettere.add(data);
                contlettere++;
          }
          myReader.close();
      } 
      catch (FileNotFoundException e) 
      {
          System.out.println("An error occurred.");
          e.printStackTrace();
      }
      
      
      int n = (int) (Math.random() * contlettere);
      posappo = (int) (Math.random() * 750);
          
      parola=arraylettere.get(n);
      lunghezza=parola.length();
     
          
      JPanel pannello=new JPanel();
      pannello.setLayout(null);      
      pannello.setSize(800,600);
      add(pannello,BorderLayout.CENTER);
      //pannello.setLocation(1,1);  
      pannello.setBackground(new Color(255,255,0));


      labelparola=new JLabel();
      labelparola.setOpaque(false);
      labelparola.setLocation(0, 0); 
      labelparola.setText(parola);
      labelparola.setSize(lunghezza*10, 20);
      labelparola.setLayout(new BorderLayout());
      labelparola.setVisible(false);
      pannello.add(labelparola);
      
      linea=new JLabel();
      linea.setOpaque(false);
      linea.setLocation(0, 450); 
      linea.setText("___________________________________________________________________________________________________________________________");
      linea.setSize(800, 20);
      linea.setLayout(new BorderLayout());
      linea.setVisible(false);
      pannello.add(linea);
      
      testo=new JTextField(20);
      testo.setVisible(false);
      testo.setLayout(new BorderLayout()); 
      testo.setSize(200,20);
      testo.setLocation(150,500);
      testo.addActionListener(this);
      pannello.add(testo);
      
      invia= new JButton ("invia");
      invia.addActionListener(this);
      invia.setLayout(new BorderLayout());   
      invia.setSize(100,20);
      invia.setLocation(350,500);
      invia.setVisible(false);
      pannello.add(invia);
      
      stop= new JButton ("stop");
      stop.addActionListener(this);
      stop.setLayout(new BorderLayout());   
      stop.setSize(100,20);
      stop.setLocation(450,500);
      stop.setVisible(false);
      pannello.add(stop);
      
      labelpunteggio=new JLabel();
      labelpunteggio.setOpaque(false);
      labelpunteggio.setLocation(560, 500); 
      labelpunteggio.setText("Il tuo punteggio è: "+ punteggio);
      labelpunteggio.setSize(800, 20);
      labelpunteggio.setLayout(new BorderLayout());
      labelpunteggio.setVisible(false);
      pannello.add(labelpunteggio);
      
      labellivello=new JLabel();
      labellivello.setOpaque(false);
      labellivello.setLocation(100, 500); 
      labellivello.setText("lvl: "+livello);
      labellivello.setSize(800, 20);
      labellivello.setLayout(new BorderLayout());
      labellivello.setVisible(false);
      pannello.add(labellivello);
      
      ImageIcon img1 = new ImageIcon("start.png");
      labelstart=new JLabel(img1);
      labelstart.setSize(329,153);
      labelstart.setLocation(230,180);
      pannello.add(labelstart);
      labelstart.addMouseListener(this);
      
      fine=new JLabel();
      fine.setOpaque(false);
      fine.setLocation(230,180); 
      fine.setText("Hai finito un gioco con un punteggio di: "+livello);
      fine.setSize(800, 20);
      fine.setLayout(new BorderLayout());
      fine.setVisible(false);
      pannello.add(fine);
      
      
      ImageIcon immagineleo = new ImageIcon("leoricucci.png");
      ImageIcon immaginesaba = new ImageIcon("saba.png");
      ImageIcon immaginecassano = new ImageIcon("cassano.png");
      
      
      labelleoricucci=new JLabel(immagineleo);
      labelleoricucci.setSize(524,366);
      labelleoricucci.setLocation(200,100);
      labelleoricucci.setVisible(false);
      pannello.add(labelleoricucci);
        
      labelsaba=new JLabel(immaginesaba);
      labelsaba.setSize(197,250);
      labelsaba.setLocation(250,200);
      labelsaba.setVisible(false);
      pannello.add(labelsaba);
        
      labelcassano=new JLabel(immaginecassano);
      labelcassano.setSize(304,339);
      labelcassano.setLocation(200,200);
      labelcassano.setVisible(false);
      pannello.add(labelcassano);
      
      t1.start();
      setVisible(true);
    }
 
    public static void main(String args[]) throws UnsupportedAudioFileException, IOException, LineUnavailableException
    {
        new Finestra();
    }
    
    public void actionPerformed(ActionEvent e)
    {
      coordinatey++;          
      labelparola.setLocation(posappo,coordinatey);    
      
        if (e.getActionCommand()=="invia")
        {  
            String txt=testo.getText();
            if(txt.equals(parola))
            {
                tin.run();
                testo.setText("");
                punteggio=punteggio+lunghezza;
                coordinatey=0;
                livello++;
                
                if(livello<4)
                {
                    int n = (int) (Math.random() * contlettere);
                    posappo = (int) (Math.random() * 750);
                    parola=arraylettere.get(n);
                    lunghezza=parola.length();
                    if(livello==2)
                    {
                        t1.stop();
                        t2.start();
                    }
                    if(livello==3)
                    {
                        t2.stop();
                        t3.start();
                    } 
                }
                
                if(livello>3 && livello<7)
                {
                    int n = (int) (Math.random() * contsillabe);
                    posappo = (int) (Math.random() * 750);
                    parola=arraysillabe.get(n);
                    lunghezza=parola.length();
                    if(livello==4)
                    {
                        t3.stop();
                        t1.start();
                    }
                    if(livello==5)
                    {
                        t1.stop();
                        t2.start();
                    }
                    if(livello==6)
                    {
                        t2.stop();
                        t3.start();
                    }
                }
                
                if(livello>6 && livello<10)
                {
                    do
                    {
                        int n = (int) (Math.random() * contparole);
                        posappo = (int) (Math.random() * 750);
                        parola=arrayparole.get(n);
                        lunghezza=parola.length();
                    }while(lunghezza>8);
                    if(livello==7)
                    {
                        t3.stop();
                        t1.start();
                    }
                    if(livello==8)
                    {
                        t1.stop();
                        t2.start();
                    }
                    if(livello==9)
                    {
                        t2.stop();
                        t3.start();
                    }
                }
                
                if(livello==10)
                {
                        do
                        {
                            int n = (int) (Math.random() * contparole);
                            posappo = (int) (Math.random() * 750);
                            parola=arrayparole.get(n);
                            lunghezza=parola.length();
                        }while(lunghezza<10);   
                }
                
                labelparola.setText(parola);
                labelparola.setSize(lunghezza*10, 20);
                labelparola.setLocation(posappo, coordinatey); 
            }
        }
        
        
        
        if(coordinatey==450 && livello>0)
        {
            testo.setText("");
            punteggio=punteggio-lunghezza;
            coordinatey=0;
            esplosione.run();
            
            if(livello<4)
            {
                    int n = (int) (Math.random() * contlettere);
                    posappo = (int) (Math.random() * 750);
                    parola=arraylettere.get(n);
                    lunghezza=parola.length();
                    if(livello==2)
                    {
                        t1.stop();
                        t2.start();
                    }
                    if(livello==3)
                    {
                        t2.stop();
                        t3.start();
                    }
                    
            }
                
            if(livello>3 && livello<7)
            {
                    int n = (int) (Math.random() * contsillabe);
                    posappo = (int) (Math.random() * 750);
                    parola=arraysillabe.get(n);
                    lunghezza=parola.length();
                    if(livello==4)
                    {
                        t3.stop();
                        t1.start();
                    }
                    if(livello==5)
                    {
                        t1.stop();
                        t2.start();
                    }
                    if(livello==6)
                    {
                        t2.stop();
                        t3.start();
                    }
            }
                
            if(livello>6 && livello<10)
            {
                    do
                    {
                        int n = (int) (Math.random() * contparole);
                        posappo = (int) (Math.random() * 750);
                        parola=arrayparole.get(n);
                        lunghezza=parola.length();
                    }while(lunghezza>8);  
                    if(livello==7)
                    {
                        t3.stop();
                        t1.start();
                    }
                    if(livello==8)
                    {
                        t1.stop();
                        t2.start();
                    }
                    if(livello==9)
                    {
                        t2.stop();
                        t3.start();
                    }
            }
            
            if(livello==10)
            {
                    do
                    {
                        int n = (int) (Math.random() * contparole);
                        posappo = (int) (Math.random() * 750);
                        parola=arrayparole.get(n);
                        lunghezza=parola.length();
                    }while(lunghezza<10);   
            }
            
            labelparola.setText(parola);
            labelparola.setSize(lunghezza*10, 20);
            labelparola.setLocation(posappo, coordinatey); 
            
        }
        
        if(livello==11 || e.getActionCommand()=="stop")
        {
            fine.setText("Hai finito un gioco con un punteggio di: "+punteggio);
            fine.setVisible(true);
            
            labelparola.setVisible(false); 
            labelpunteggio.setVisible(false);
            labellivello.setVisible(false);
            linea.setVisible(false);
            testo.setVisible(false);
            invia.setVisible(false);
            stop.setVisible(false);
            t1.stop();
            t2.stop();
            t3.stop();
            if(punteggio<10)
            {
                musichetta.stop();
                comecassano.start();
                labelcassano.setVisible(true);
            }
            if(punteggio>=10&&punteggio<40)
            {
                musichetta.stop();
                comesabatelli.start();
                labelsaba.setVisible(true);
            }
            if(punteggio>=40)
            {
                musichetta.stop();
                comeleoricucci.start();
                labelleoricucci.setVisible(true);
            }
        }
        
        labellivello.setText("lvl: "+livello);
        labelpunteggio.setText("Il tuo punteggio è: "+ punteggio);
        validate();
        repaint();
    }

    
    public void mouseExited(MouseEvent e)
    {
    
    }
    
    public void mouseEntered(MouseEvent e)
    {
    
    }
    
    public void mouseReleased(MouseEvent e)
    {
    
    }
   
    public void mousePressed(MouseEvent e)
    {
        if(e.getButton() == MouseEvent.BUTTON1)
        {           
            coordinatey=0;
            labelparola.setLocation(posappo, coordinatey); 
            labelstart.setVisible(false);
            labelparola.setVisible(true); 
            labelpunteggio.setVisible(true);
            labellivello.setVisible(true);
            linea.setVisible(true);
            testo.setVisible(true);
            invia.setVisible(true);
            stop.setVisible(true);
            
            livello=1;
            suonodiavvio.start();
        }
            
        validate();
        repaint();
    }
    
    public void mouseClicked(MouseEvent e)
    {
    
    }
    
 

}