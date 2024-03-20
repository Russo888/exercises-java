import java.io.Reader.*;
import java.io.InputStreamReader.*;
import java.io.*;
import java.net.*;

public class Server
{
    Socket client;
    String indirizzo;
    int porta;
          
    BufferedReader in;
    BufferedWriter out; 
    
    public Server(String indirizzo, int porta)
    {
        this.indirizzo=indirizzo;
        this.porta=porta;
    }
  
    public String risposta(String richiesta)
    {
        String saba="";
        try
        {
            client = new Socket(indirizzo, porta);
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream())); 
         
            out.write(richiesta);   
            out.newLine();
            out.flush();
            
            saba=in.readLine(); 
            
            client.close(); 
            in.close();
            out.close();
        }
        catch (Exception e) 
        { 
               System.out.println("COMUNICAZIONE FALLITA!\nErrore: " + e.getMessage());
               saba="ERRORE!";
        }
        return saba;
   }
       
}