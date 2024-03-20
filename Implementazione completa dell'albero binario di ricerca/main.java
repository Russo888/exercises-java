import java.io.*;
import java.lang.Object.*;
import java.io.Reader.*;
import java.io.InputStreamReader.*;
public class main
{
    public static void main(String [] args) throws Exception
    {
        InputStreamReader in=new InputStreamReader(System.in);
        BufferedReader tastiera=new BufferedReader(in);
        AlberoBT albero=new AlberoBT();
        Lista lista=new Lista();
        NodoBT nodobt;
        int appo;
       
       for(int i=0;i<1;i=i)
       {
            System.out.println("Inserisci");  
            System.out.println("0 per chiudere il programma:");
            System.out.println("1 per inserire un nodo:");
            System.out.println("2 per cercare un nodo:");
            System.out.println("3 per vedere gli attraversamenti:");
            System.out.println("4 per vedere il numero di nodi sotto ad un nodo: ");
            System.out.println("5 per la tabella:");
            System.out.println("6 per il bilanciamento:");
            System.out.println(">");
            appo=Integer.parseInt(tastiera.readLine());
            if(appo==0)
            {
                i=0;
            }
            
            if (appo==1) 
            {
                  System.out.println("Inserisci un nodo:"); 
                  String newString= tastiera.readLine();
                  NodoBT n=new NodoBT(newString);
                  albero.inserisciNodo(n);
            }
            
            if(appo==2)
            {
                System.out.println("Inserisci il nodo da cercare:"); 
                String r= tastiera.readLine();
                if(albero.ricercaDato(new NodoBT(r))==true)
                {
                    System.out.println("C stesc u nod, c stesc!");
                }
                else
                {
                    System.out.println("U nod non c stesc" );
                }
            }
            
            if(appo==3)
            {
                Integer numero;
                for(int j=0; i<10;i++)
                {
                    Integer abbo= (int)(Math.random()*100)+1;
                    NodoBT n=new NodoBT(abbo);
                    albero.inserisciNodo(n);
                }
                System.out.println("Anticipato: " );
                lista=albero.attraversamentoAnticipato(); 
                VisualizzaLista(lista.getTesta());
                lista.svuota();
                System.out.println("Posticipato: " );
                lista=albero.attraversamentoPosticipato(); 
                VisualizzaLista(lista.getTesta());
                lista.svuota();
                System.out.println("Simmetrico: " );
                lista=albero.attraversamentoSimmetrico(); 
                VisualizzaLista(lista.getTesta());
                lista.svuota();
            }
            
            if (appo==4) 
            {
                System.out.println("Inserisci il nodo di cui vuoi sapere il numero di nodi derivanti:"); 
                String r= tastiera.readLine();
                System.out.println("Il numero di nodi è: "+albero.numeroNodi(new NodoBT(r))); 
            }
            
            if (appo==5) 
            {
                albero.tabella();
            }
            
            if (appo==5) 
            {
                albero.bilanciamento();
            }
        }    
    }
    public static void VisualizzaLista(Nodo n)
    {
            System.out.println(n.getInformazione());
            if(n.getSuccessivo() != null)
                VisualizzaLista(n.getSuccessivo());
    }
}

