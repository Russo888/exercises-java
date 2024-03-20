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
    
    public int numeroElementi()
    {
        Nodo n=testa ;
        if (testa !=null )
        {
            int cont=1;
            while(n.getSuccessivo()!=null)
        {
            n=n.getSuccessivo();
            cont++;
        }
            return cont;
        }
        else
            return 0;
    }
    
    public Nodo leggiPosizione (int pos)
    {
        if (testa!=null && pos<=numeroElementi())
        {
            Nodo n = testa ;
            for ( int i =1; i < pos ; i ++)
            n = n.getSuccessivo () ;
            return n ;
        }
        else
            return null ;
    }
    
    public void inserisciInPosizione (int pos, Nodo n1) throws Exception
    {
        if ( testa!=null && pos<=numeroElementi())
        {
            if (pos==1)
                inserisciInTesta (n1) ;
            else
            {
                Nodo n = leggiPosizione(pos-1) ;
                n1.setSuccessivo (n.getSuccessivo()) ;
                n.setSuccessivo (n1);
            }
        }
        else
        throw new Exception () ;
    }
    

    public void cancellaInPosizione(int pos) throws Exception
    {
    if (testa!=null && pos <= numeroElementi())
        {
        if(pos==1)
        cancellaTesta() ;
        else if (pos==numeroElementi())
        cancellaCoda() ;
        else
        {
        Nodo n=leggiPosizione(pos-1);
        n.setSuccessivo(n.getSuccessivo().getSuccessivo());
        }
        }
        else
        throw new Exception () ;
    }
    
}
