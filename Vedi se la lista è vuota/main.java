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
        
        
        int appo=1000;
        //appo=Integer.parseInt(tastiera.readLine());
        Lista lista=new Lista();
        
        for(int i=0;i<1;i=i)
        {
            System.out.println("Inserisci: ");
            System.out.println("0 per chiudere il programma");
            System.out.println("1 per inserire una stringa");
            System.out.println("2 per visualizzare la lista");
            System.out.println("3 per eliminare la testa");
            System.out.println("4 per avere la coda");
            System.out.println("5 per inserire un elemento in coda");
            System.out.println("6 per eliminare la coda");
            
            System.out.println(">");
            appo=Integer.parseInt(tastiera.readLine());
        
            //while(appo!=0)
           // {
                if(appo==0)
                {
                    i=1;
                }
                if(appo==1)
                {
                    System.out.println("Inserisci una stringa");
                    String info=tastiera.readLine();
                    Nodo n=new Nodo(info);
                    lista.inserisciInTesta(n);
                }
                else if(appo==2)
                {
                    if(lista.vediSeVuota()==true)
                        System.out.println("La lista è vuota");
                    else
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
                else if(appo==5)
                {
                    System.out.println("Inserisci una stringa in coda");
                    String info=tastiera.readLine();
                    Nodo n=new Nodo(info);
                    lista.inserisciInCoda(n);
                }
                else if(appo==6)
                {
                    lista.cancellaCoda();
                }

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
