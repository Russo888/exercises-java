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
public class Finestra extends JFrame implements  KeyListener
{
    private int lunghezza;
    private String parola;
    private String lettera;
    private int contatoreparole=0;
    private int contatorelettere=0;
    private int errori=0;
    private int coordinatex=0;
    private ArrayList<String> trattini= new ArrayList();
    private ArrayList<JLabel> visualizzazionetrattini= new ArrayList();
    private String lettereusate=" ";
    JLabel tastipremuti;
    JLabel fine;
    JLabel comando;
    JLabel struttura;
    JLabel capa;
    JLabel collo;
    JLabel bracciosinistro;
    JLabel bracciodestro;
    JLabel corpo;
    JLabel gambasinistra;
    JLabel gambadestra;  
    private int letteremancanti;
    private ArrayList<Character> listaletterepremute= new ArrayList();
    public Finestra()
    {
      setSize(500,500);        
      setLayout(new BorderLayout());
      addKeyListener(this); 
        
      
      ArrayList<String> array= new ArrayList();
      try 
      {
          File myObj = new File("parole.txt");
          Scanner myReader = new Scanner(myObj);
          while (myReader.hasNextLine()) 
          {
                String data = myReader.nextLine();
                array.add(data);
                contatoreparole++;
          }
      myReader.close();
      } 
      catch (FileNotFoundException e) 
      {
          System.out.println("An error occurred.");
          e.printStackTrace();
      }
        int n = (int) (Math.random() * contatoreparole);
        parola=array.get(n);
        lunghezza=parola.length();
        letteremancanti=lunghezza;
        System.out.println(parola);
        
        trattini=new ArrayList();
        for(int i=0; i<lunghezza;i++)
        {
            trattini.add("_");
        }
        
        
        JPanel pannello=new JPanel();
        pannello.setLayout(null);      
        pannello.setSize(500,500);
        add(pannello,BorderLayout.CENTER);
        pannello.setBackground(new Color(255,255,255));
        pannello.addKeyListener(this); 
        
        coordinatex=100;
        visualizzazionetrattini=new ArrayList();
        for(int i=0; i<lunghezza;i++)
        {
             Tratteggio appo=new Tratteggio(trattini.get(i));
             visualizzazionetrattini.add(appo.dammiLabel());
        }
        
        for(int i=0;i<lunghezza;i++)
        {
            visualizzazionetrattini.get(i).setOpaque(false);
            visualizzazionetrattini.get(i).setLocation(coordinatex, 250);  
            visualizzazionetrattini.get(i).setSize(20, 20);
            visualizzazionetrattini.get(i).setLayout(new FlowLayout());
            pannello.add(visualizzazionetrattini.get(i));
            coordinatex=coordinatex+10;
        }
           
        tastipremuti=new JLabel();
        tastipremuti.setOpaque(false);
        tastipremuti.setLocation(100, 300); 
        tastipremuti.setSize(400, 20);
        tastipremuti.setLayout(new FlowLayout());
        pannello.add(tastipremuti);

        
        fine=new JLabel();
        fine.setOpaque(false);
        fine.setLocation(100, 350); 
        fine.setText("Hai perso, la parola corretta era "+parola);
        fine.setSize(450, 20);
        fine.setLayout(new FlowLayout());
        fine.setVisible(false);
        pannello.add(fine);

        comando=new JLabel();
        comando.setOpaque(false);
        comando.setLocation(100, 200); 
        comando.setText("Schiaccia una lettera");
        comando.setSize(350, 20);
        comando.setLayout(new FlowLayout());
        comando.setVisible(true);
        pannello.add(comando);
        
        //label dell'impiccato
        ImageIcon img1 = new ImageIcon("struttura.png");
        
        struttura=new JLabel(img1);
        struttura.setLocation(20, 20);         
        struttura.setSize(200, 200);      
        pannello.add(struttura);
        struttura.setVisible(true);
        
        ImageIcon img2 = new ImageIcon("capa.png");
        
        capa=new JLabel(img2);
        capa.setLocation(20, 20);         
        capa.setSize(200, 200);      
        pannello.add(capa);
        capa.setVisible(false);
        
        ImageIcon img3 = new ImageIcon("collo.png");
        
        collo=new JLabel(img3);
        collo.setLocation(20, 20);         
        collo.setSize(200, 200);      
        pannello.add(collo);
        collo.setVisible(false);
        
        ImageIcon img4 = new ImageIcon("bracciosinistro.png");
        
        bracciosinistro=new JLabel(img4);
        bracciosinistro.setLocation(20, 20);         
        bracciosinistro.setSize(200, 200);      
        pannello.add(bracciosinistro);
        bracciosinistro.setVisible(false);
        
        ImageIcon img5 = new ImageIcon("bracciodestro.png");
        
        bracciodestro=new JLabel(img5);
        bracciodestro.setLocation(20, 20);         
        bracciodestro.setSize(200, 200);      
        pannello.add(bracciodestro);
        bracciodestro.setVisible(false);
        
        ImageIcon img6 = new ImageIcon("corpo.png");
        
        corpo=new JLabel(img6);
        corpo.setLocation(20, 20);         
        corpo.setSize(200, 200);      
        pannello.add(corpo);
        fine.setVisible(false);
        
        ImageIcon img7 = new ImageIcon("gambasinistra.png");
        
        gambasinistra=new JLabel(img7);
        gambasinistra.setLocation(20, 20);         
        gambasinistra.setSize(200, 200);      
        pannello.add(gambasinistra);
        gambasinistra.setVisible(false);
        
        ImageIcon img8 = new ImageIcon("gambadestra.png");
        
        gambadestra=new JLabel(img8);
        gambadestra.setLocation(20, 20);         
        gambadestra.setSize(200, 200);      
        pannello.add(gambadestra);
        gambadestra.setVisible(false);
        
        listaletterepremute=new ArrayList();

        setVisible(true);
    }
 
    public static void main(String args[])
    {
        new Finestra();
    }

    
    public void keyReleased(KeyEvent e)
    {
        
    }
    
    public void keyTyped(KeyEvent e)
    {
        
    }
    
    public void keyPressed(KeyEvent e)
    {
        if(errori<7)
        {
            int controlloerrori=letteremancanti;
            String appo="";
            
            int contappoggio=0;
            for(int i=0; i<listaletterepremute.size();i++)
            {
                contappoggio++;
                if(listaletterepremute.get(i)==e.getKeyChar())
                {
                    contappoggio=0;
                }  
            }
            
            if(contappoggio==listaletterepremute.size())
            {
                    appo = new StringBuilder().append(e.getKeyChar()).append(", ").toString();
                    lettereusate=lettereusate+appo;
                    listaletterepremute.add(e.getKeyChar());
                    tastipremuti.setText("Le lettere provate sono: "+lettereusate);
                

                contatorelettere=0;
                for(int i=0;i<lunghezza;i++)
                {
                    lettera=parola.substring(contatorelettere,contatorelettere+1);
                    char controllolettera=parola.charAt(contatorelettere);
                    if(e.getKeyChar()==controllolettera||e.getKeyChar()==controllolettera+32)
                    {     
                        for(int j=0; j<lunghezza;j++)
                        {
                            trattini.set(i, lettera);
                        }
                        
                        visualizzazionetrattini.get(i).setText(trattini.get(i));
                        letteremancanti--;
                        if(letteremancanti==0)
                        {
                            fine.setText("Hai vinto, sei forte quasi quanto sabatelli!");
                            errori=8;
                            fine.setVisible(true);
                        }
                    }
                    contatorelettere++;
                }
            }
            if(controlloerrori==letteremancanti)
            {
                if(contappoggio==listaletterepremute.size()-1)
                       errori++;
                   
                if(errori==1)
                {
                    struttura.setVisible(false);
                    capa.setVisible(true);
                }
                    
                if(errori==2)
                {
                    capa.setVisible(false);
                    collo.setVisible(true);
                }
                
                if(errori==3)
                {
                    collo.setVisible(false);
                    bracciosinistro.setVisible(true);
                }
                
                if(errori==4)
                {
                    bracciosinistro.setVisible(false);
                    bracciodestro.setVisible(true);
                }
                
                if(errori==5)
                {
                    bracciodestro.setVisible(false);
                    corpo.setVisible(true);
                }
                
                if(errori==6)
                {
                    corpo.setVisible(false);
                    gambasinistra.setVisible(true);
                }
                
                if(errori==7)
                {
                    gambasinistra.setVisible(false);
                    gambadestra.setVisible(true);
                }
            }
        }
        else
        {
            fine.setVisible(true);
        }
        repaint();
        revalidate();
    }
    

}