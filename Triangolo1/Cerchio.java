public class Cerchio
{
    protected double raggio;

    public Cerchio(double r)
    {
        raggio= r;
    }

    public double calcolaDiametro()
    {
        return raggio*2;
    }
    
    public double calcolaCirconferenza()
    {
        return 2*raggio*Math.PI;
    }
    
    public double calcolaArea()
    {
        return Math.PI*Math.pow(raggio,2);
    }
    

    
   
}

