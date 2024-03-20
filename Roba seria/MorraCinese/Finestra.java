import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList; 

public class Finestra extends JFrame implements ActionListener, MouseListener
{
    JLabel imm1;
    JLabel imm2;
    JLabel imm3;
    JLabel imm4;
    JLabel punteggio1;
    JLabel punteggio2;
    JButton a1;
    JButton b1;
    JButton c1;
    private int mossacomputer=0;
    private int mossagiocatore=0;
    private int punteggiocomputer=0;
    private int punteggiogiocatore=0;
    private int lunghezza1=0;
    private int lunghezza2=0;

    public Finestra()
    {
        
        setSize(900,900);        
        setLayout(new BorderLayout());
        
        JPanel a=new JPanel();
        a.setLayout(new GridLayout());
        a.setSize(300,100);
        a1= new JButton ("Sasso");
        a1.addActionListener(this);
        a.add(a1);
        add(a,BorderLayout.CENTER);
        a.setBackground(new Color(255,255,255)); 
        if(mossacomputer==0&&mossagiocatore==0)
        {
            a1.setVisible(false);
        }

        
        JPanel b=new JPanel();
        b.setLayout(new GridLayout());
        b.setSize(300,100);
        b1= new JButton ("Carta");
        b1.addActionListener(this);
        b.add(b1);
        add(b,BorderLayout.CENTER);
        b.setLocation(300,1);
        b.setBackground(new Color(255,255,255));
        if(mossacomputer==0&&mossagiocatore==0)
        {
            b1.setVisible(false);
        }

        
        JPanel c=new JPanel();
        c.setLayout(new GridLayout());
        c.setSize(300,100);
        c1= new JButton ("Forbici");
        c1.addActionListener(this);
        c.add(c1);
        add(c,BorderLayout.CENTER);
        c.setLocation(600,1);   
        c.setBackground(new Color(255,255,255));
        if(mossacomputer==0&&mossagiocatore==0)
        {
            c1.setVisible(false);
        }


        ImageIcon img1 = new ImageIcon(mossacomputer+".png");
        ImageIcon img2 = new ImageIcon(mossagiocatore+".png");
        ImageIcon img3 = new ImageIcon("4.png");
        ImageIcon img4 = new ImageIcon("5.png");
        
        JPanel immagini=new JPanel();
        immagini.setLayout(null);        
        add(immagini,BorderLayout.CENTER);
        immagini.setBackground(new Color(255,255,255));
        
        
        imm1=new JLabel(img1);
        imm1.setSize(150,150);
        imm1.setLocation(200,300);
        immagini.add(imm1);
        
        
        
        imm2=new JLabel(img2);
        imm2.setSize(150,150);
        imm2.setLocation(600,300);
        immagini.add(imm2);
        
        
        imm3=new JLabel(img3);
        imm3.setSize(329,153);
        imm3.setLocation(260,200);
        immagini.add(imm3);
        imm3.addMouseListener(this);
        
        imm4=new JLabel(img4);
        imm4.setSize(150,150);
        imm4.setLocation(260,350);
        immagini.add(imm4);
        imm4.setVisible(false);
        

        punteggio1 = new JLabel();   
        punteggio1.setText("Il punteggio del computer è: "+punteggiocomputer);;
        punteggio1.setOpaque(false);             
        punteggio1.setLocation(180, 150);
        punteggio1.setSize(200, 30);
        immagini.add(punteggio1);
        if(mossacomputer==0&&mossagiocatore==0)
        {
            punteggio1.setVisible(false);
        }   
        
        
        punteggio2 = new JLabel();  
        punteggio2.setText("Il tuo punteggio è: "+punteggiogiocatore);
        punteggio2.setOpaque(false);         
        punteggio2.setLocation(600, 150);
        punteggio2.setSize(200, 30);
        immagini.add(punteggio2);
        if(mossacomputer==0&&mossagiocatore==0)
        {
            punteggio2.setVisible(false);
        }      
        
        
        validate();
        repaint();
        setVisible(true);
    }


    public void actionPerformed(ActionEvent e)
    {
        if (e.getActionCommand()=="Sasso")
        {    
            mossagiocatore=1;
            mossacomputer=(int)(Math.random()*3+1);
            
            imm1.setLocation(200,300);
            imm2.setLocation(600,300);
            
            imm1.setIcon(new ImageIcon(mossacomputer+".png"));
            imm2.setIcon(new ImageIcon(mossagiocatore+".png"));  

            imm1.setVisible(true);
            imm2.setVisible(true);
        }
        
        if (e.getActionCommand()=="Carta")
        {
            mossagiocatore=2;
            mossacomputer=(int)(Math.random()*3+1);
            
            imm1.setLocation(200,300);
            imm2.setLocation(600,300);
            
            imm1.setIcon(new ImageIcon(mossacomputer+".png"));
            imm2.setIcon(new ImageIcon(mossagiocatore+".png"));
            
            imm1.setVisible(true);
            imm2.setVisible(true);
        }
        
        if (e.getActionCommand()=="Forbici")
        {
            mossagiocatore=3;
            mossacomputer=(int)(Math.random()*3+1);
            
            imm1.setLocation(200,300);
            imm2.setLocation(600,300);
            
            imm1.setIcon(new ImageIcon(mossacomputer+".png"));
            imm2.setIcon(new ImageIcon(mossagiocatore+".png"));
            
            imm1.setVisible(true);
            imm2.setVisible(true);
        }           
        

        //se vince il giocatore
        if(mossagiocatore==1)
        {
            if(mossacomputer==3)
            {
                punteggiogiocatore=punteggiogiocatore+1;
            }   
        }
        
        if(mossagiocatore==2)
        {
            if(mossacomputer==1)
            {
                punteggiogiocatore=punteggiogiocatore+1;
            }   
        }
        
        if(mossagiocatore==3)
        {
            if(mossacomputer==2)
            {
                punteggiogiocatore=punteggiogiocatore+1;
            }   
        }
        
        //se vince il computer
        if(mossagiocatore==1)
        {
            if(mossacomputer==2)
            {
                punteggiocomputer=punteggiocomputer+1;
            }   
        }
        
        if(mossagiocatore==2)
        {
            if(mossacomputer==3)
            {
                punteggiocomputer=punteggiocomputer+1;
            }   
        }
        
        if(mossagiocatore==3)
        {
            if(mossacomputer==1)
            {
                punteggiocomputer=punteggiocomputer+1;
            }   
        }
          

        //chi vince
        if(punteggiocomputer==5)
        {
            imm4.setLocation(360,75);
            imm4.setVisible(true);
            
            imm3.setIcon(new ImageIcon("7.png"));
            imm3.setLocation(280,170);
            imm3.setVisible(true);
            
            a1.setVisible(false);
            b1.setVisible(false);
            c1.setVisible(false);
            punteggio1.setLocation(180, 450);
            punteggio2.setLocation(600, 450);
        }
        
        if(punteggiogiocatore==5)
        {
            imm4.setLocation(360,75);
            imm4.setVisible(true);
            
            imm3.setIcon(new ImageIcon("6.png"));
            imm3.setLocation(280,170);
            imm3.setVisible(true);
            
            a1.setVisible(false);
            b1.setVisible(false);
            c1.setVisible(false);
            punteggio1.setLocation(180, 450);
            punteggio2.setLocation(600, 450);
         }
         
        punteggio1.setText("Il punteggio del computer è: "+punteggiocomputer);
        punteggio2.setText("Il tuo punteggio è: "+punteggiogiocatore);
        
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
            imm3.setVisible(false);   
                        
            a1.setVisible(true);
            b1.setVisible(true);
            c1.setVisible(true);
            
            punteggio1.setVisible(true);
            punteggio2.setVisible(true);
            
            validate();
            repaint();
        }
    }
    
    public void mouseClicked(MouseEvent e)
    {
    
    }

}
