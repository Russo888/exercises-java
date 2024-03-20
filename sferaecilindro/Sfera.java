public class Sfera extends Cerchio
{

    public Sfera(double r)
    {
        super(r);
    }

    public double calcolaVolume()
    {
        return (4/3)*Math.PI*Math.pow(raggio,3);
    }

    public double calcolaSuperficie()
    {
        return 4*Math.PI*Math.pow(raggio,2);
    }
}
