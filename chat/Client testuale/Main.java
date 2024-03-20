//
//  ESEMPIO DI STRUTTURA DI UN CLIENT
//
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main
{
    // VARIABILI GLOBALI CHE SERVONO PER RICHIEDERE
    // SERVIZI AL SERVER
    static String richiesta="    ";
    static int comando=0;
    static int cont=0;
    static String nome="";
    // CREAZIONE DI UN OGGETTO PER LA CONNESSIONE AL SERVER
    // SPECIFICANDO INDIRIZZO E PORTA
    // (Vedi classe definita in seguito)
    
    public static void main(String args[]) throws Exception
    {
       InputStreamReader in = new InputStreamReader(System.in);
       BufferedReader tastiera = new BufferedReader(in);
       ConnessioneAServer conn=new ConnessioneAServer("127.0.0.1",2000);
       
       
       while (true)
       {   
           do
           {
               if(richiesta.substring(0,4).equals("QUIT")) cont=0;
               
               System.out.println("Inserisci: ");
               System.out.println("1 se vuoi registrarti nella chat");
               System.out.println("2 per vedere la lista degli utenti registrati alla chat");
               System.out.println("3 per vedere tutti i messaggi che ti sono stati inviati");
               System.out.println("4 per mandare un messaggio");
               System.out.println("5 per uscire dalla chat");
               System.out.println(" ");
               System.out.println("Inserire un comando");
               System.out.println(">");
               
               comando=Integer.parseInt(tastiera.readLine());
           
           
               if(comando==1)
               {
                   if(cont==1)
                   {
                       System.out.println("Sei già registrato nella chat");
                   }
                   if(cont==0)
                   {
                       richiesta="NICK";
                       System.out.println("Inserisci il tuo nickname");
                       nome=tastiera.readLine();
                       richiesta=richiesta+nome;
                       cont=1;
                   }
               }
               
               if(comando==2)
               {
                   if(cont==0)
                   {
                       System.out.println("Devi prima registrarti");
                   }
                   if(cont==1)
                   {
                       richiesta="USRS";
                   }
               }
               
               if(comando==3)
               {
                   if(cont==0)
                   {
                       System.out.println("Devi prima registrarti");
                   }
                   if(cont==1)
                   {
                       richiesta="RCVD";
                       richiesta=richiesta+nome;
                   }
               }
               
               if(comando==4)
               {
                   if(cont==0)
                   {
                       System.out.println("Devi prima registrarti");
                   }
                   if(cont==1)
                   {
                       richiesta="TEXT";
                       int mode=0;
                       String testo="";
                       String destinatario="";
                       System.out.println("Inserisci");
                       do
                       {
                           System.out.println("1 per mandare un messaggio ad un utente specifico");
                           System.out.println("2 per mandare un messaggio a tutti");
                           mode=Integer.parseInt(tastiera.readLine());
                       }while(mode<1 && mode>2);
                       if(mode==1)
                       {
                           System.out.println("Inserisci il messaggio che vuoi inviare");
                           testo=tastiera.readLine();
                           System.out.println("Inserisci il destinatario del messaggio");
                           destinatario=tastiera.readLine();
                           richiesta=richiesta+"U"+testo+"§"+nome+"§"+destinatario;
                       }
                       if(mode==2)
                       {
                           System.out.println("Inserisci il messaggio che vuoi inviare");
                           testo=tastiera.readLine();
                           richiesta=richiesta+"B"+testo+"§"+nome+"§ ";
                       }    
                   }
               }
               
               if(comando==5)
               {
                   if(cont==0)
                   {
                       System.out.println("Devi prima registrarti");
                   }
                   if(cont==1)
                   {
                       richiesta="QUIT";
                       richiesta=richiesta+nome;
                   }
               }
               
               
           }while(cont==0);
           
           
           
           String risposta=conn.risposta(richiesta);
           System.out.println(risposta);
       }
    }
    
}