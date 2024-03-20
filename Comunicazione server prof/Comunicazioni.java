import java.awt.event.*;
import java.io.*;

public class Comunicazioni 
{
    String richiesta="";
    static ConnessioneAServer conn=new ConnessioneAServer("151.76.221.45",2000);
    
    public static void main(String args[]) throws Exception
    {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader tast = new BufferedReader(in);
        String risposta;
        String appo = "0";
        
        System.out.println("Inserire cognome:");
        appo=tast.readLine();
        risposta=conn.risposta(appo);
        System.out.println(""+risposta);
    }
}
