public class Lista
{
    Nodo testa;
    public Lista()
    {
      testa=null;  
    }

    public Lista(Nodo t)
    {
      testa=t;
    }

    public Nodo getTesta()
    {
        return testa;
    }
    
    public boolean vediSeVuota()
    {
        if (testa==null)
            return true;
        else 
            return false;
    }
    
    public void inserisciInTesta(Nodo n)
    {
     n.setSuccessivo ( testa ) ;
     testa = n;
    }
    
    public void cancellaTesta()
    {
        if(testa != null)
        testa = testa.getSuccessivo ();
    }
    
    public Nodo getCoda()
    {
        Nodo n=testa;
        if(testa!=null)
        {
            while( n.getSuccessivo() != null)
            {
                n=n.getSuccessivo();
            }
            return n;
        }
        else
        return null;
    }
    
    public void inserisciInCoda ( Nodo n )
    {
        if (testa == null)
        testa = n;
        else
        getCoda().setSuccessivo(n);
    }

    public void cancellaCoda ()
    {
        Nodo n = testa;
        if ( testa != null )
        {
            if( testa.getSuccessivo()==null )
            cancellaTesta () ;
            else
            {
                while( n.getSuccessivo ().getSuccessivo() != null )
                {
                    n = n . getSuccessivo () ;
                }
                n.setSuccessivo (null ) ;
            }
        }
    }
}
