import javax.swing.*;

public class CartaDaGioco extends JLabel
{
    String seme;
    int valore;
    boolean scoperta;
    String indirizzo;
    
    
    public CartaDaGioco(String seme, int valore, boolean scoperta, String indirizzo)
    {
        super(new ImageIcon(indirizzo));
        
        this.seme = seme;
        this.valore = valore;
        this.scoperta = scoperta;
        this.indirizzo = indirizzo;
        
        setSize(55, 101);
    }
    
    public Icon getImmagineCarta()
    {
        return 	super.getIcon();
    }
    
    public String getIndirizzo()
    {
        return indirizzo;
    }
    
    public void setIndirizzo(String indirizzo)
    {
        this.indirizzo = indirizzo;
    }
    
    public void scopri()
    {
        scoperta = true;
        setIcon(new ImageIcon(indirizzo));
    }
    
    public void copri()
    {
        scoperta = false;
        setIcon(new ImageIcon("carte/11d.jpg"));
    }
    
    public String getSeme()
    {
        return seme;
    }
    
    public int getNumero()
    {
        return valore;
    }
    
    public boolean getScoperta()
    {
        return scoperta;
    } 
    
    public void setSeme(String parametro)
    {
        seme = parametro;
    }
    
    public void setValore(int parametro)
    {
        valore = parametro;
    }

}