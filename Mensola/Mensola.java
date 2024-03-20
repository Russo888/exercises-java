import java.util.ArrayList;
public class Mensola
{
    private ArrayList<Libro> Mensola;
    public Libro volumi[];

    public Mensola()
    {
        Mensola = new ArrayList<Libro>();    
    }
    
    public Mensola(Mensola mensola)
    {
        int posizione;
        
        volumi = new Libro[MAX_NUM_VOLUMI]; 
        for(posizione = 0; posizione < MAX_NUM_VOLUMI; posizione++)
        {
                           
        }
    }
    
    public int setVolume(Libro libro, int posizione)
    {
        if((posizione<0)||(posizione >=MAX_NUM_VOLUMI)) return -1;
        if(volumi[MAX_NUM_VOLUMI-1]!=null) return -2;
        if(getNumVolumi()==0) volumi[0] = new Libro(libro);
        
        if(volumi[posizione] != null)
        {
            for(int i = MAX_NUM_VOLUMI-1; i>=posizione;i--)
            {
                if(volumi[i]!=null) volumi[i+1] = volumi[i];
            }
            volumi[posizione] = new Libro(libro);
        }
        
        else 
        {
            for(int i = MAX_NUM_VOLUMI-1; i>=0;i--)
            {
                if(volumi[i]!=null)
                {
                    volumi[i+1] = new Libro(libro);
                    i=-1;
                }
            }
        }
        return posizione;
    }
    
    public void aggiungiVolume(Libro libro)
    {
        for(int i = 0; i<MAX_NUM_VOLUMI; i++)
        {
            if(volumi[i] == null)
            {
                volumi[i] = libro;
                i=MAX_NUM_VOLUMI+1;
            }
        }
    }
    
    public Libro getVolume(int posizione)
    {
        if((posizione<0)||(posizione >=MAX_NUM_VOLUMI)) return null;
        if(volumi[posizione]!=null) return new Libro(volumi[posizione]);
        else return null;
    }
    
    public int rimuoviVolume(int posizione)
    {
         if((posizione<0)||(posizione >=MAX_NUM_VOLUMI)) return -1;
         if(volumi[posizione]==null) return -2;
         volumi[posizione]=null;
         for(int i = posizione; i < MAX_NUM_VOLUMI-posizione-1;i++)
         {
             volumi[i] = volumi[i+1];
         }
         return posizione;
    }
    
    public int getNumMaxVolumi() {return MAX_NUM_VOLUMI;}
    
    public int getNumVolumi()
    {
        int posizione, n=0;
        for(posizione = 0; posizione<MAX_NUM_VOLUMI; posizione++)
        {
            if(volumi[posizione] != null) n++;
        }
        return n;
    }
}
