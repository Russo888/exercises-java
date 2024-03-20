import java.io.*;
import java.lang.Object.*;
import java.io.Reader.*;
import java.io.InputStreamReader.*;
public class main
{

    public static void main(String [] args) throws Exception 
    {
        InputStreamReader in=new InputStreamReader(System.in);
        BufferedReader tastiera=new BufferedReader(new InputStreamReader(System.in));
        
        
        int appo=0;
        appo=Integer.parseInt(tastiera.readLine());
        Lista list=new Lista();
        
        while(appo!=0)
        {
            System.out.println("Inserisci");
            System.out.println("0 per chiudere il programma");
            System.out.println("1 per inserire una stringa");
            System.out.println("2 per visualizzare la lista");
        }
        
        while(appo!=0)
        {
            if(appo==1)
            {
                System.out.println("Inserisci una stringa");
                String info=tastiera.readLine();
                Nodo n=new Nodo(info);
                Lista.inserisciInTesta(n);
            }
            else if(appo==2)
            {
                VisualizzaLista(Lista.getTesta());
            }
            System.out.println(">>>");
            appo=Integer.parseInt(tastiera.readLine());
        }
    }

    public static void VisualizzaLista(Nodo n)
    {
        System.out.println(n.getInformazione());
        if(n.getSuccessivo() != null)
            VisualizzaLista(n.getSuccessivo());
    }
}
