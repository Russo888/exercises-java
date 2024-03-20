public class NodoBT
{
    Object info ;
    NodoBT sinistra ;
    NodoBT destra ;
    public NodoBT() 
    {

    }
    public NodoBT( Object i )
    {
        info = i ;
    }
    public Object getInfo()
    {
        return info ;
    }
    public void setInfo( Object i )
    {
        info = i ;
    }
    public NodoBT getSinistra()
    {
        return sinistra ;
    }
    public NodoBT getDestra()
    {
        return destra;
    }
    public void setSinistra( NodoBT s )
    {
        sinistra = s;
    }
    public void setDestra( NodoBT d )
    {
        destra = d;
    }
    public int compareTo( NodoBT n )
    {
        String sinfo = info.toString ();
        String sn = n.getInfo().toString();
        return sinfo.compareTo(sn.toString());
    }
}