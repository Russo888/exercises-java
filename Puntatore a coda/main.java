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
        
        
        int appo=10;
        //appo=Integer.parseInt(tastiera.readLine());
        Lista lista=new Lista();
        
        while(appo!=0)
        {
            System.out.println("Inserisci: ");
            System.out.println("0 per chiudere il programma");
            System.out.println("1 per inserire una stringa");
            System.out.println("2 per visualizzare la lista");
            System.out.println("3 per eliminare la coda");
            System.out.println("4 per avere la coda");
       
        
            //while(appo!=0)
           // {
                if(appo==1)
                {
                    System.out.println("Inserisci una stringa");
                    String info=tastiera.readLine();
                    Nodo n=new Nodo(info);
                    lista.inserisciInTesta(n);
                }
                else if(appo==2)
                {
                    VisualizzaLista(lista.getTesta());
                }
                else if(appo==3)
                {
                    lista.cancellaTesta();
                }
                else if(appo==4)
                {
                    lista.getCoda();
                }
                System.out.println(">");
                appo=Integer.parseInt(tastiera.readLine());
            //}
        }
    
    }

    public static void VisualizzaLista(Nodo n)
    {
        System.out.println(n.getInformazione());
        if(n.getSuccessivo() != null)
            VisualizzaLista(n.getSuccessivo());
    }
    
}
