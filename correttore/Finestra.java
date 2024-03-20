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



//import sun.audio.*;

public class Finestra extends JFrame implements ActionListener, KeyListener
{
    private int lunghezza;
    private String parola;
    JLabel labelparola;
    public JTextArea testo;
    JScrollPane scroll;
    int contatore1=0;
    int contatore2=0;
    
    LevenshteinDistance differenza= new LevenshteinDistance();
    
    int lunghezzaprova=0;
    boolean vedisegiusta=false;
    ArrayList<Label> labels= new ArrayList();
    ArrayList<String> parole= new ArrayList();
    ArrayList<String> arrparoleconsigliate1= new ArrayList();
    ArrayList<String> arrparoleconsigliate2= new ArrayList();
    String paroleconsigliate;
    
    
    public Finestra()
    {    
      setSize(800,600);        
      setLayout(new BorderLayout());
          
      JPanel pannello=new JPanel();
      pannello.setLayout(null);      
      pannello.setSize(800,600);
      add(pannello,BorderLayout.CENTER);
      //pannello.setLocation(1,1);  
      pannello.setBackground(new Color(255,255,0));


      labelparola=new JLabel();
      labelparola.setOpaque(false);
      labelparola.setLocation(320, 200); 
      labelparola.setText("");
      labelparola.setSize(800, 20);
      labelparola.setLayout(new BorderLayout());
      labelparola.setVisible(true);
      pannello.add(labelparola);
      
      
      testo=new JTextArea();
      testo.setVisible(true);
      testo.setLayout(new BorderLayout()); 
      testo.setSize(600,20);
      testo.setLocation(100,50);
      testo.addKeyListener(this);
      pannello.add(testo);
      
      scroll = new JScrollPane();
      scroll.setViewportView(new JLabel("Connecting to the database. Please wait..."));
      scroll.setLocation(0,500);
      scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  
      scroll.setSize(790,200);
      pannello.add(scroll);

      setVisible(true);
    }
 
    public static void main(String args[]) 
    {
        new Finestra();
    }
    
    public void actionPerformed(ActionEvent e)
    {
        
    }

    public void keyReleased(KeyEvent e)
    {
        parola=testo.getText();
        contatore1++;

        if(e.getKeyCode()==KeyEvent.VK_SPACE)
        {
            String paroleappoggio=parola.substring(contatore2,contatore1-1);
            parole.add(paroleappoggio);
            contatore2=contatore1;
            try 
            {   
                File myObj = new File("parole.txt");
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) 
                {
                    String data = myReader.nextLine();
                    String parolaDaConfrontare=data;
                    
                    //char c=s.charAt(0);//returns h.
                    int confronto=differenza.levenshteinDistance(paroleappoggio, parolaDaConfrontare);
                    
                    
                    if(data.length()>0&&confronto==0)
                    {
                        arrparoleconsigliate1.clear();
                        arrparoleconsigliate2.clear();
                        vedisegiusta=true;
                        break;
                    }
                    if(confronto==1)
                    {
                        arrparoleconsigliate1.add(parolaDaConfrontare);
                    }
                    if(confronto==2)
                    {
                        arrparoleconsigliate2.add(parolaDaConfrontare); 
                    }
                }
                myReader.close();
            } 
            catch (FileNotFoundException a)
            {
                System.out.println("An error occurred.");
                a.printStackTrace();
            }
            
            
            if(vedisegiusta==false)
            {
                paroleconsigliate=paroleappoggio+": ";
                int lunghezza1=arrparoleconsigliate1.size();
                int lunghezza2=arrparoleconsigliate2.size();
                if(lunghezza1>0&&lunghezza2==0)
                {
                    paroleconsigliate=paroleconsigliate+" "+arrparoleconsigliate1.get(1)+" "+arrparoleconsigliate1.get(2);
                    arrparoleconsigliate1.clear();
                    arrparoleconsigliate2.clear();
                }
                if(lunghezza1>0&&lunghezza2>0)
                {
                    paroleconsigliate=paroleconsigliate+" "+arrparoleconsigliate1.get(1)+" "+arrparoleconsigliate2.get(1);
                    arrparoleconsigliate1.clear();
                    arrparoleconsigliate2.clear();
                }
                if(lunghezza2>0&&lunghezza1==0)
                {
                    paroleconsigliate=paroleconsigliate+" "+arrparoleconsigliate2.get(1)+" "+arrparoleconsigliate2.get(2);
                    arrparoleconsigliate1.clear();
                    arrparoleconsigliate2.clear();
                }
                if(lunghezza2==0&&lunghezza1==0)
                {
                    paroleconsigliate=paroleconsigliate+" "+"non ci sono suggerimenti";
                }
            }
            if(vedisegiusta==true)
            {
                vedisegiusta=false;
                paroleconsigliate="";
            }
            
            labelparola.setText(paroleconsigliate);
        }

        validate();
        repaint();
    }
    
    public void keyTyped(KeyEvent e)
    {
        
    }
    
    public void keyPressed(KeyEvent e)
    {
        
    }

}