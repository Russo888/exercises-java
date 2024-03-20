public class Cilindro extends Cerchio
{
    private int altezza;
    
    public Cilindro(double r)
    {
        super(r);
    }
    
    public void setAltezza(int h)
    {
        altezza= h;
    }
    
    public double calcolaVolume()
    {
        return super.calcolaArea()*altezza;
    }
    
    private double calcolaSuperficielaterale()
    {
        return super.calcolaCirconferenza()*altezza;
    }
    
    public double calcolaSuperficie()
    {
        return super.calcolaArea()+calcolaSuperficielaterale();
    }
}
