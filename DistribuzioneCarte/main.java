import java.io.*;
import java.util.*;

public class main
{
    private int giocatori;
    public static void main (String []args)throws Exception
    {
        String tipo="francesi";
        String colore="";
        String seme="";
        boolean scoperta=true;
        MazzoDiCarte francesi=new MazzoDiCarte();
        
        
        System.out.println("Creazione mazzo");
        for (int i=1; i<=4;i++)
        {
            switch(i)
            {
                case 1:seme="Cuori"; break;
                case 2:seme="Quadri"; break;
                case 3:seme="Picche"; break;
                case 4:seme="Fiori"; break;
            }
            
            switch(i)
            {
                case 1: colore="Rosso";break;
                case 2: colore="Rosso";break;
                case 3: colore="Nero";break;
                case 4: colore="Nero";break;
            }
            
            for(int j=1;j<=13;j++)
            {
                francesi.aggiungiCarta(new CartaDaGioco(tipo,seme,j,colore));
            }
        }
        francesi.mischiaMazzo();
        
    }
    
    public void setGiocatori(int c)
    {
        giocatori=g;
    }
    
    public void setGiocatori(int c)
    {
        giocatori=g;
    }



}
