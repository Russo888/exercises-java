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
public class Finestra extends JFrame
{
    JLabel scritta;
    public Finestra()
    {
      setSize(900,900);        
      setLayout(new BorderLayout());
      
        
      
      ArrayList array= new ArrayList();
      int cont=0;
      try 
      {
          File myObj = new File("parole.txt");
          Scanner myReader = new Scanner(myObj);
          while (myReader.hasNextLine()) 
          {
                String data = myReader.nextLine();
                if(data.length()>=6)
                {
                     array.add(data);
                     //System.out.println(data);
                     cont++;
                }
          }
      myReader.close();
      } 
      catch (FileNotFoundException e) 
      {
          System.out.println("An error occurred.");
          e.printStackTrace();
      }
        int n = (int) (Math.random() * cont);
        
        JPanel pannello=new JPanel();
        pannello.setLayout(null);      
        pannello.setSize(400,300);
        add(pannello,BorderLayout.CENTER);
        pannello.setBackground(new Color(255,255,255));
            
        scritta=new JLabel();
        scritta.setOpaque(false);             
        scritta.setText("Il numero di parole complessive é:"+cont+" "+"parola a caso:"+array.get(n)); 
        scritta.setLocation(100, 150);
        scritta.setSize(400, 30);
        scritta.setLayout(new FlowLayout());
        pannello.add(scritta);
           
        setVisible(true);
    }
 
    public static void main(String args[])
    {
        new Finestra();
    }
    
    
}