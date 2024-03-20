public class Auto
{
    private String modello;
    private int numeroMarcia;
    private int giriMotore;
    private boolean motoreAcceso;
    private int velocità;
    
    public Auto(String modello)
    {
        this.modello=modello;
    }

    public void accendiMotore()
    {
        motoreAcceso=true;
    }
    
    public void spegniMotore()
    {
        motoreAcceso=false;
    }
    
    public void accellera(int numeroGiriAumento)
    {
        if(numeroGiriAumento+giriMotore<=500)
        {
            setGiriMotore(getGiriMotore()+numeroGiriAumento);
            calcolaVelocità();
        }
    }
    
    public void decellera(int numeroGiriInMeno)
    {
        if(numeroGiriInMeno>=giriMotore)
        {
            setGiriMotore(getGiriMotore()-numeroGiriInMeno);
            calcolaVelocità();
        }
    }
    
    public void cambiaMarcia(int marcia)
    {
        if(marcia>=0 && marcia<=6)
        {
            setNumeroMarcia(marcia);
            calcolaVelocità();
        }
    }
    
    public int getVelocità()
    {
        return velocità;
    }
    
    public void setGiriMotore(int g)
    {
        giriMotore=g;
    }
    
    public int getGiriMotore()
    {
        return giriMotore;
    }
    
    public void setNumeroMarcia(int m)
    {
        numeroMarcia=m;
    }
    
    public int getNumeroMarcia()
    {
        return numeroMarcia;
    }
    
    public void setVelocità(int v)
    {
        velocità=v;
    }
    
    public void calcolaVelocità()
    {
        setVelocità((giriMotore*numeroMarcia)/100);
    }
}
