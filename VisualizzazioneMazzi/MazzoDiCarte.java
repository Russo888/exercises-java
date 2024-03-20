import java.util.*;
public class MazzoDiCarte
{
    ArrayList<CartaDaGioco> mazzo;
    
    public MazzoDiCarte()
    {
        mazzo = new ArrayList();
    }
    
    public void mischiaMazzo()
    {
        Collections.shuffle(mazzo);
    }
    
    public void aggiungiCarta(CartaDaGioco carta)
    {
        mazzo.add(carta);
    }
    
    public void inserisciCarta(CartaDaGioco carta, int posizione)
    {
        mazzo.add(posizione, carta);
    }
    
    public void eliminaCarta(CartaDaGioco carta)
    {
        mazzo.remove(carta);
    }
    
    public void scopriCarta(int posizione)
    {
        mazzo.get(posizione).scopri();
    }
    
    public void copriCarta(int posizione)
    {
        mazzo.get(posizione).copri();
    }
    
    public CartaDaGioco pescaCartaCima()
    {
        CartaDaGioco a=mazzo.get(0);
        mazzo.remove(0);
        return a;
    }  
    public CartaDaGioco pescaCartaInPosizione(int pos)
    {
        CartaDaGioco a=mazzo.get(pos);
        mazzo.remove(pos);
        return a;
    }  
    public CartaDaGioco vediCartaCima()
    {
        return mazzo.get(0);
        
    }  
    public CartaDaGioco vediCartaInPosizione(int pos)
    {
        return mazzo.get(pos);
        
    }  
    public String toString()
    {
       
        String r="";
        for(int i=0;i<mazzo.size();i++)
        {
           
            r+=""+vediCartaInPosizione(i).getSeme().charAt(0) + vediCartaInPosizione(i).getNumero()+" ";
            
        }
        
        return r;
    }
    
    public int numeroCarte()
    {
        return mazzo.size();
    }
}