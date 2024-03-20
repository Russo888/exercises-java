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
        
        int urgenza=0;
        int appo=1000;
        int rossi=0;
        int gialli=0;
        int bianchi=0;
        Lista lista=new Lista();
        Lista lista1=new Lista();
        int pos=0;
        
        for(int i=0;i<1;i=i)
        {
            System.out.println("Inserisci: ");
            System.out.println("0 per chiudere il programma");
            System.out.println("1 per inserire un nuovo paziente");
            System.out.println("2 per eliminare il paziente urgente");
            System.out.println("3 per vedere il numero di pazienti rossi, gialli e bianchi");
            System.out.println("4 per eliminare un paziente");
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
                    System.out.println("Inserisci la gravità del caso: ");
                    System.out.println("1 se il caso è molto urgente");
                    System.out.println("2 se il caso è normalmente urgente");
                    System.out.println("3 se il caso non è urgente");
                    System.out.println(">");
                    urgenza=Integer.parseInt(tastiera.readLine());
                    if(i==1)
                    {
                        lista.inserisciInTesta(n);
                        rossi++;
                    }
                    if(appo==2)
                    {
                        lista.inserisciInPosizione (rossi+1, n);
                        gialli++;                    
                    }
                    if(i==3)
                    {
                        lista.inserisciInCoda(n);
                        bianchi++;
                    }
                }
                else if(appo==2)
                {
                    System.out.println(lista.getTesta()+" è stato curato");
                    lista.cancellaTesta();
                }
                else if(appo==3)
                {
                    System.out.println("I pazienti totali sono: "+lista.numeroElementi());
                    System.out.println("I pazienti rossi: "+rossi);
                    System.out.println("I pazienti gialli: "+gialli);
                    System.out.println("I pazienti bianchi: "+bianchi);
                }
                else if(appo==4)
                {
                    System.out.println("Inserisci il paziente da eliminare");
                    System.out.println(">");
                    String info=tastiera.readLine();
                    pos=lista.cercaNodo(info);
                    lista.cancellaInPosizione(pos);
                }               
            System.out.println("______________________________________________________________________________");
        }
    }

    public static void VisualizzaLista(Nodo n)
    {
        System.out.println("______________________________________________________________________________");
        System.out.println(n.getInformazione());
        if(n.getSuccessivo() != null)
            VisualizzaLista(n.getSuccessivo());
        System.out.println("______________________________________________________________________________");
    }
    
}
