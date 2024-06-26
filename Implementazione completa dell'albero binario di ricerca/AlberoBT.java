
public class AlberoBT
{
    NodoBT Radice ;
    int pos =0;
    Lista lista =new Lista();
    
    public AlberoBT()
    {
        Radice =null ;
    }
    
    public AlberoBT( NodoBT r )
    {
        Radice = r ;
    }
    
    public void inserisciNodo( NodoBT n )
    {
        if(Radice==null)
        {
            Radice = n ;
            return;
        }
        inserisciNodo(n,Radice);
    }
    
    private void inserisciNodo (NodoBT n, NodoBT r )
    {
        if (n.compareTo(r) >0)
        {
            if(r.getDestra()==null)
                r.setDestra( n );
            else
                inserisciNodo(n ,r.getDestra() );
        }   
        else
        {
            if(r.getSinistra()==null)
                r.setSinistra(n) ;
            else
                inserisciNodo(n,r.getSinistra()) ;
        }
    }
    
    public boolean ricercaDato( NodoBT dato )
    {
        if (dato.compareTo(Radice) ==0)
            return true;
        else
            return ricercaDato(dato,Radice);
    }
    
    private boolean ricercaDato(NodoBT dato,NodoBT r )
    {
        if(r==null )
            return false ;
        if (dato.compareTo(r) == 0)
            return true;
        if(dato.compareTo(r) >0)
            return ricercaDato( dato, r.getDestra() ) ;
        else
            return ricercaDato( dato, r.getSinistra () ) ;
    }
    
    public Lista attraversamentoAnticipato()
    {
        lista.svuota();
        if( Radice == null )
            return null ;
        else
            attraversamentoAnticipato( Radice );
        return lista ;
    }    
    private void attraversamentoAnticipato ( NodoBT r )
    {
        if (r!=null)
        {
            lista.inserisciInCoda (new Nodo(r.getInfo()));
            attraversamentoAnticipato (r.getSinistra()) ;
            attraversamentoAnticipato (r.getDestra () ) ;
        }
        else
            return;
    }
    
    public Lista attraversamentoSimmetrico ()
    {
        lista.svuota();
        if (Radice == null)
            return null ;
        else
            attraversamentoSimmetrico ( Radice ) ;
        return lista ;
    }
    private void attraversamentoSimmetrico ( NodoBT r )
    {
        if(r!= null)
        {
            attraversamentoSimmetrico (r.getSinistra());
            lista.inserisciInCoda (new Nodo (r.getInfo()));
            attraversamentoSimmetrico (r.getDestra() );
        }
        else
            return;
    }
    
    public Lista attraversamentoPosticipato ()
    {
        lista.svuota () ;
        if ( Radice == null)
            return null ;
        else
            attraversamentoPosticipato ( Radice ) ;
        return lista ;
    }
    private void attraversamentoPosticipato ( NodoBT r )
    {
        if( r!= null )
        {
            attraversamentoPosticipato (r.getSinistra()) ;
            attraversamentoPosticipato (r.getDestra()) ;
            lista.inserisciInCoda (new Nodo(r.getInfo())) ;
        }
        else
            return;
    }

    public int numeroNodi(NodoBT r)
    {
        if (r!= null)
        {
            return 1+numeroNodi (r.getSinistra()) + numeroNodi(r.getDestra());
        }
        else
            return 0;
    }
    
    public void tabella ()
    {
    if( Radice!=null )
    tabella ( Radice ) ;
    pos=0;
    }
    private void tabella ( NodoBT r )
    {
        if (r != null )
            {
            pos++;
            if (r.getSinistra () == null && r.getDestra () == null )
            System.out.println ( " " + pos + " \t " + r . getInfo () + "\t\\ \t \\ ") ;
            if ( r.getSinistra () != null && r.getDestra() == null )
                {
                System . out . println ( " " +( pos ) + " \t " + r . getInfo () + " \t " +( pos +1)
                + " \t\\ " ) ;
                tabella ( r . getSinistra () ) ;
                }
            if ( r . getSinistra () == null && r.getDestra () != null )
                {
                System.out.println ( " " + pos + " \t " + r . getInfo () + " \t \\ \t " +(
                pos +1) ) ;
                tabella ( r . getDestra () ) ;
                }
            if (r.getSinistra() != null && r.getDestra()!=null )
                {
                System.out.println (" "+( pos ) +" \t " +r.getInfo()+" \t "+( pos +1)
                + " \t " + ( pos +1+ numeroNodi (r.getSinistra()))) ;
                tabella ( r . getSinistra () ) ;
                tabella ( r .getDestra () ) ;
                }
            }
            else
                return;
    }
    
    public AlberoBT bilanciamento ()
    {
    AlberoBT A2 = new AlberoBT () ;
    this.attraversamentoSimmetrico();
    int metà = (lista.numeroElementi()+1)/2;
    A2.inserisciNodo (new NodoBT (lista.leggiPosizione(metà).getInformazione())) ;
    bilanciamento ( A2 ,1 , metà-1) ;
    bilanciamento ( A2, metà +1 , lista.numeroElementi()) ;
    return A2 ;
    }
    private void bilanciamento ( AlberoBT A2, int a , int b )
    {
    if(a==b)
    A2 . inserisciNodo (new NodoBT (lista.leggiPosizione(a).getInformazione())) ;
    if(a<b)
    {
    int metà =a +((b-a) /2) ;
    A2.inserisciNodo (new NodoBT(lista.leggiPosizione ( metà ).getInformazione())) ;
    bilanciamento ( A2 ,a , metà-1) ;
    bilanciamento ( A2 , metà+1,b) ;
    }
    }


}