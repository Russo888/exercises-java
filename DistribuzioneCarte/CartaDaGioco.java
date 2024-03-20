// da rifare
public class CartaDaGioco
{
    // instance variables - replace the example below with your own
    private String tipoCarte;
    private String seme;
    private boolean scoperta;
    private int numero;
    private String colore;

    
    public CartaDaGioco(String t, String s, int n, String c )
    {
         seme=s;
         tipoCarte=t;
         numero=n;
         colore=c;
        
    }

    
    public void setTipoCarte(String tipoCarte)
    {
        tipoCarte=this.tipoCarte;
        
    }
    
    public void setSeme(String tipoCarte)
    {
        seme=this.seme;        
    }
    
    public void setNumero(int numero)
    {
        this.numero=numero;
        
    }
    
    public void setColore(String colore)
    {
        this.colore=colore;
        
    }
    
    public String getTipoCarte()
    {
        return tipoCarte;
        
    }
    
    public String getSeme()
    {
        return seme;
        
    }
    
    public int getNumero()
    {
        return numero;
        
    }
    
    public String getColore()
    {
        return colore;
        
    }
    
    public void scopri()
    {
        coperta=true;
    }
    
    public void copri()
    {
        coperta=false;
    }
    
    public boolean getScoperta()
    {
        return coperta;
        
    }
}