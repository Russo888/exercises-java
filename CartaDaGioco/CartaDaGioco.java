public class CartaDaGioco
{
    private String tipoCarte;
    private String seme;
    private int numero;
    private String colore;
    private boolean scoperta;
    
    public CartaDaGioco(String t, String s, int n, String c)
    {
        tipoCarte=t;
        seme=s;
        numero=n;
        colore=c;
    }
    
        public void setTipoCarte(String t)
    {
        tipoCarte=t;
    }
    
        public void setSeme(String s)
    {
        seme=s;
    }
    
        public void setNumero(int n)
    {
        numero=n;
    }
    
        public void setColore(String c)
    {
        colore=c;
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
}
