public class Punto
{
    private double X;
    private double Y;
    
    
    public Punto(double X, double Y)
    {
      this.X=X;
      this.Y=Y;
    }

    public double distanzaDaOrigine()
    {
        return Math.sqrt(X*X+Y*Y);
    }
    
    public double getX()
    {
        return X;
    }
    
    public double getY()
    {
        return Y;
    }
    
    public void setX(double X)
    {
        this.X=X;
    }
    
    public void setY(double Y)
    {
        this.Y=Y;
    }
}
