import java.io.*;
import java.lang.Object.*;
import java.io.Reader.*;
import java.io.InputStreamReader.*;
public class main
{
    private int cont=0;
    public static void main(String [] args) throws Exception 
    {
        InputStreamReader in=new InputStreamReader(System.in);
        BufferedReader tastiera=new BufferedReader(new InputStreamReader(System.in));
        
        
        int appo=1000;
        //appo=Integer.parseInt(tastiera.readLine());
        Lista lista=new Lista();
        int pos=0;
        
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
            System.out.println("7 per vedere il numero di elementi della lista");
            System.out.println("8 per vedere un nodo in una posizione");
            System.out.println("9 per inserire un nodo in una posizione");
            System.out.println("10 per eliminare un nodo in una posizione");            
            System.out.println(">");
            appo=Integer.parseInt(tastiera.readLine());
            
                if(appo==0)
                {
                    i=1;
                }
                if(appo==1)
                {
                    System.out.println("Inserisci una stringa");
                    System.out.println(">");
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
                    System.out.println(">");
                    String info=tastiera.readLine();
                    Nodo n=new Nodo(info);
                    lista.inserisciInCoda(n);
                }
                else if(appo==6)
                {
                    lista.cancellaCoda();
                }
                else if(appo==7)
                {
                    System.out.println("Gli elementi della lista sono: "+lista.numeroElementi());
                }
                else if(appo==8)
                {
                    System.out.println("Inserisci la posizione dell'elemento da visualizzare");
                    System.out.println(">");
                    pos=Integer.parseInt(tastiera.readLine());
                    Nodo n=lista.leggiPosizione (pos);
                    System.out.println(n.getInformazione());
                }
                else if(appo==9)
                {
                    System.out.println("Inserisci la posizione in cui mettere un elemento");
                    System.out.println(">");
                    pos=Integer.parseInt(tastiera.readLine());
                    System.out.println("Inserisci la stringa");
                    System.out.println(">");
                    String info=tastiera.readLine();
                    Nodo n=new Nodo(info);
                    lista.inserisciInPosizione (pos, n);
                }
                else if(appo==10)
                {
                    System.out.println("Inserisci la posizione in cui eliminare un elemento");
                    System.out.println(">");
                    pos=Integer.parseInt(tastiera.readLine());
                    lista.cancellaInPosizione(pos);
                }
            System.out.println("______________________________________________________________________________");
        }
    }

    public static void VisualizzaLista(Nodo n)
    {
        System.out.println(n.getInformazione());
        if(n.getSuccessivo() != null)
            VisualizzaLista(n.getSuccessivo());
    }
    
}
