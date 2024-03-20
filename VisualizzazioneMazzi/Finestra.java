import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.awt.MouseInfo.*;
import java.util.ArrayList;

public class Finestra extends JFrame implements MouseListener
{
    CartaDaGioco appoggio;
    JPanel p, p1;
    ArrayList <MazzoDiCarte> mazzi;
    Border border = BorderFactory.createLineBorder(Color.BLUE, 5);
    Border niente = BorderFactory.createLineBorder(Color.BLUE, 0);
    
    public Finestra()
    {
        int numero, seme;
        String semeStr = "", indirizzo;
        
        //-------------------------------------------------CREAZIONE MAZZO NAPOLETANO
        MazzoDiCarte mazzoCompleto = new MazzoDiCarte();
        String[] semi = { "b", "c", "d", "s"};        
        int[] valori = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        boolean scoperta = true;
        
        for(int i = 0; i < 10; i++)
           for(int j = 0; j < 4; j++)
           {
               indirizzo =  "carte/" + valori[i] + semi[j] + ".jpg";
               mazzoCompleto.aggiungiCarta(new CartaDaGioco(semi[j], valori[i], scoperta, indirizzo));
           }
                
        mazzoCompleto.mischiaMazzo();
        
        //-------------------------------------------------SETTINGS DELLA FINESTRA
        setResizable(false);
        setSize(550,550);
        setLayout(null);
        
        
        //-------------------------------------------------CREAZIONE DEI 4 MAZZETTI
        mazzi = new ArrayList();
        
        for(int i = 0; i < 4; i++)
        {
            mazzi.add(new MazzoDiCarte());
            
            for(int j = 0; j < 3; j++)
            {
                mazzi.get(i).aggiungiCarta(mazzoCompleto.pescaCartaCima());
                mazzi.get(i).vediCartaInPosizione(j).addMouseListener(this);
                 
            }
        }
        
        //-------------------------------------------------CREAZIONE DEI LAYOUT E PANNELLI
        p = new JPanel();
        p.setSize(500,500);
        p.setLayout(new BorderLayout());
        p.setLocation(0,0);
        
        p1 = new JPanel();
        p1.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 50));
        
        JPanel p2 = new JPanel();
        p2.setLayout(new FlowLayout(FlowLayout.CENTER));
        JPanel spazio = new JPanel();
        spazio.setSize(150,80);
        p2.add(spazio);
        
        JPanel p3 = new JPanel();
        p3.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        JPanel p4 = new JPanel();
        p4.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        p.add(p1, BorderLayout.NORTH);
        p.add(p2, BorderLayout.EAST);
        p.add(p3, BorderLayout.WEST);
        p.add(p4, BorderLayout.SOUTH);
        
        //-------------------------------------------------AGGIUNTA DELLE CARTE NELLA FINESTRA
        for(int i = 0; i < 3; i++)
        {
            p1.add(mazzi.get(0).vediCartaInPosizione(i));
            p2.add(mazzi.get(1).vediCartaInPosizione(i));
            p3.add(mazzi.get(2).vediCartaInPosizione(i));
            p4.add(mazzi.get(3).vediCartaInPosizione(i));
        }

        add(p);
        
        setVisible(true);
    }
    
     public void mouseClicked(MouseEvent e)
     {
         if(e.getButton() == MouseEvent.BUTTON3)
         {
            appoggio = (CartaDaGioco)e.getSource();
            if(appoggio.getScoperta())
               appoggio.copri();
            else
               appoggio.scopri();
          
         }
         
         if(e.getButton() == MouseEvent.BUTTON1)
         {
             appoggio = (CartaDaGioco)e.getSource();
             
             
                if(appoggio.getBorder() == border)
                    appoggio.setBorder(niente);
                else
                    appoggio.setBorder(border);
                        
             
         }
     }
    
    public void mouseEntered(MouseEvent e){}
    
    public void mouseExited(MouseEvent e){}
    
    public void mousePressed(MouseEvent e){}
    
    public void mouseReleased(MouseEvent e){}
    
}
