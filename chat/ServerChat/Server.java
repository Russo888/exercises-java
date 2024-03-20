import java.net.*;
import java.io.*;
import java.util.ArrayList; 
public class Server

{
    // Variabili globali del server necessarie ad elaborare la risposta
    static ArrayList<String> listaUtenti=new ArrayList();
    static ArrayList<Messaggio> listaMessaggi=new ArrayList();
    static int lunghezzaLista=0;

    public static void main(String args[])
    {
        ServerSocket ss;
        try
        {
            ss = new ServerSocket(2000);
            
            while(true)
            { 
                try
                {
                   
                    Socket client = ss.accept();
                    System.out.println("Accettata connessione da "+client.getRemoteSocketAddress().toString());
                    BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
                    
                    // Lettura richiesta dal client
                    
                    
                        String str=in.readLine();
                        String risposta = elaborazione(str);

                    
                        //trasmissione risposta del server 
                    
                        out.write(risposta);  
                        out.flush();
                        
                    
                    // chiusura connessione
                    client.close(); 
                    in.close();
                    out.close();
                    

                }
                catch(Exception e) 
                { 
                    System.out.println("COMUNICAZIONE FALLITA!\nErrore: " + e.getMessage());
                } 
            }
        }
        catch(Exception e) 
        {
            System.out.println("APERTURA ServerSocket FALLITA!\nErrore: " + e.getMessage());
        } 
    }
    
    static private String elaborazione(String risposta)
    {
       lunghezzaLista=listaUtenti.size();
       String comando=risposta.substring(0,4);
       String s="COMANDO NON ESISTENTE";
       
       if(comando.equals("NICK"))
        {
            int cont1=0;
            String nome=risposta.substring(4);
            for (int i=0;i<lunghezzaLista;i++)
            {
                 if(listaUtenti.get(i).equals(nome))
                 {
                     cont1++;
                 }
            }
            if(cont1==1)
            {
                cont1=0;
                s="DECLINED";
            }
            else
            {
                cont1=0;
                listaUtenti.add(nome);
                s="ACCEPT";
            }
       }
       
       if(comando.equals("QUIT"))
       {
            int cont2=0;
            String nome=risposta.substring(4);
            for (int i=0;i<lunghezzaLista;i++)
            {
                if(listaUtenti.get(i).equals(nome))
                 {
                     cont2++;
                 }
            }
            if(cont2==1)
            {
                cont2=0;
                listaUtenti.remove(nome);
                s="DISCONNECTED";
            }
            else
            {
                cont2=0;
                s="NOT FOUND";
            }
       }
       
       if(comando.equals("USRS"))
       {
           s="USERS: ";
           for(int i=0;i<lunghezzaLista;i++)
           {
                s=s+"§"+listaUtenti.get(i); 
           }  
       }
        
       if(comando.equals("TEXT"))
       {
            String[] c=risposta.split("§"); //TEXTUueue§nm§nd
            String mode=risposta.substring(4,5);//mode
            String testo=c[0].substring(5);//mess
            String NM=c[1];//NM
            String ND=c[2];//ND
            if(mode.equals("U"))            
            { 
                if(cercaN(NM)==false || cercaN(ND)==false ) 
                {
                    s="NOT FOUND";
                    return s;
                }
            }
            
            if( mode.equals("B")) 
                ND=" ";
            Messaggio mess=new Messaggio(mode,testo,NM,ND);
            listaMessaggi.add(mess);
            s="RECIVED";
            return s;
       }
       if(comando.equals("RCVD"))
       {
           s="RF";
           int cont=0;
           String nome=risposta.substring(4);
           if(cercaN(nome)==true)
           {
               for(int i=0; i<listaMessaggi.size();i++)
               {
                   if(listaMessaggi.get(i).getDestinatario()==nome || listaMessaggi.get(i).getMode().equals("B"))
                   {
                       s=s+listaMessaggi.get(i).getMittente()+"§";
                       s=s+listaMessaggi.get(i).getText()+"§";
                       s=s+listaMessaggi.get(i).getTime()+"§";
                       s=s+listaMessaggi.get(i).getMode()+"; ";
                       cont++;
                       listaMessaggi.remove(i);
                       i=i-1;
                   }        
               }
               if(cont==0)
               {
                   s="NO MEX";
               }  
               cont=0;
               return s;
            }
            s="NOT FAUND";
       }
       return s;
    }
    
    static private Boolean cercaN(String NN)
    {
        for(int i=0; i<listaUtenti.size();i++)
        {
            if(NN.equals(listaUtenti.get(i)))
                return true;
        }
        return false;
    }
}
 