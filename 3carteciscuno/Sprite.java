import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList; 
public class Sprite extends JFrame
{
    JLabel o1;
    
    public Sprite(int c)
    {
        ImageIcon sprite1=new ImageIcon("1b.jpg");            
        ImageIcon sprite2=new ImageIcon("2b.jpg");
        ImageIcon sprite3=new ImageIcon("3b.jpg");
        ImageIcon sprite4=new ImageIcon("4b.jpg");
        ImageIcon sprite5=new ImageIcon("5b.jpg");
        ImageIcon sprite6=new ImageIcon("6b.jpg");
        ImageIcon sprite7=new ImageIcon("7b.jpg");
        ImageIcon sprite8=new ImageIcon("8b.jpg");
        ImageIcon sprite9=new ImageIcon("9b.jpg");
        ImageIcon sprite10=new ImageIcon("10b.jpg");
        ImageIcon sprite11=new ImageIcon("1s.jpg");            
        ImageIcon sprite12=new ImageIcon("2s.jpg");
        ImageIcon sprite13=new ImageIcon("3s.jpg");
        ImageIcon sprite14=new ImageIcon("4s.jpg");
        ImageIcon sprite15=new ImageIcon("5s.jpg");
        ImageIcon sprite16=new ImageIcon("6s.jpg");
        ImageIcon sprite17=new ImageIcon("7s.jpg");
        ImageIcon sprite18=new ImageIcon("8s.jpg");
        ImageIcon sprite19=new ImageIcon("9s.jpg");
        ImageIcon sprite20=new ImageIcon("10s.jpg");
        ImageIcon sprite21=new ImageIcon("1c.jpg");            
        ImageIcon sprite22=new ImageIcon("2c.jpg");
        ImageIcon sprite23=new ImageIcon("3c.jpg");
        ImageIcon sprite24=new ImageIcon("4c.jpg");
        ImageIcon sprite25=new ImageIcon("5c.jpg");
        ImageIcon sprite26=new ImageIcon("6c.jpg");
        ImageIcon sprite27=new ImageIcon("7c.jpg");
        ImageIcon sprite28=new ImageIcon("8c.jpg");
        ImageIcon sprite29=new ImageIcon("9c.jpg");
        ImageIcon sprite30=new ImageIcon("10c.jpg");        
        ImageIcon sprite31=new ImageIcon("1d.jpg");            
        ImageIcon sprite32=new ImageIcon("2d.jpg");
        ImageIcon sprite33=new ImageIcon("3d.jpg");
        ImageIcon sprite34=new ImageIcon("4d.jpg");
        ImageIcon sprite35=new ImageIcon("5d.jpg");
        ImageIcon sprite36=new ImageIcon("6d.jpg");
        ImageIcon sprite37=new ImageIcon("7d.jpg");
        ImageIcon sprite38=new ImageIcon("8d.jpg");
        ImageIcon sprite39=new ImageIcon("9d.jpg");
        ImageIcon sprite40=new ImageIcon("10d.jpg");
        
        

        switch (c)
        {
            case 1: o1=new JLabel(sprite1); o1.setSize(140,100); break;
            case 2: o1=new JLabel(sprite2); o1.setSize(140,100); break;
            case 3: o1=new JLabel(sprite3); o1.setSize(140,100); break;
            case 4: o1=new JLabel(sprite4); o1.setSize(140,100); break;
            case 5: o1=new JLabel(sprite5); o1.setSize(140,100); break;
            case 6: o1=new JLabel(sprite6); o1.setSize(140,100); break;
            case 7: o1=new JLabel(sprite7); o1.setSize(140,100); break;
            case 8: o1=new JLabel(sprite8); o1.setSize(140,100); break;
            case 9: o1=new JLabel(sprite9); o1.setSize(140,100); break;
            case 10: o1=new JLabel(sprite10); o1.setSize(140,100); break;
            case 11: o1=new JLabel(sprite11); o1.setSize(140,100); break;
            case 12: o1=new JLabel(sprite12); o1.setSize(140,100); break;
            case 13: o1=new JLabel(sprite13); o1.setSize(140,100); break;
            case 14: o1=new JLabel(sprite14); o1.setSize(140,100); break;
            case 15: o1=new JLabel(sprite15); o1.setSize(140,100); break;
            case 16: o1=new JLabel(sprite16); o1.setSize(140,100); break;
            case 17: o1=new JLabel(sprite17); o1.setSize(140,100); break;
            case 18: o1=new JLabel(sprite18); o1.setSize(140,100); break;
            case 19: o1=new JLabel(sprite19); o1.setSize(140,100); break;
            case 20: o1=new JLabel(sprite20); o1.setSize(140,100); break;
            case 21: o1=new JLabel(sprite21); o1.setSize(140,100); break;
            case 22: o1=new JLabel(sprite22); o1.setSize(140,100); break;
            case 23: o1=new JLabel(sprite23); o1.setSize(140,100); break;
            case 24: o1=new JLabel(sprite24); o1.setSize(140,100); break;
            case 25: o1=new JLabel(sprite25); o1.setSize(140,100); break;
            case 26: o1=new JLabel(sprite26); o1.setSize(140,100); break;
            case 27: o1=new JLabel(sprite27); o1.setSize(140,100); break;
            case 28: o1=new JLabel(sprite28); o1.setSize(140,100); break;
            case 29: o1=new JLabel(sprite29); o1.setSize(140,100); break;
            case 30: o1=new JLabel(sprite30); o1.setSize(140,100); break;
            case 31: o1=new JLabel(sprite31); o1.setSize(140,100); break;
            case 32: o1=new JLabel(sprite32); o1.setSize(140,100); break;
            case 33: o1=new JLabel(sprite33); o1.setSize(140,100); break;
            case 34: o1=new JLabel(sprite34); o1.setSize(140,100); break;
            case 35: o1=new JLabel(sprite35); o1.setSize(140,100); break;
            case 36: o1=new JLabel(sprite36); o1.setSize(140,100); break;
            case 37: o1=new JLabel(sprite37); o1.setSize(140,100); break;
            case 38: o1=new JLabel(sprite38); o1.setSize(140,100); break;
            case 39: o1=new JLabel(sprite39); o1.setSize(140,100); break;
            case 40: o1=new JLabel(sprite40); o1.setSize(140,100); break;
        }
        

        
    }
    
    public JLabel dammiLabel()
    {
        return o1;
    }
}
