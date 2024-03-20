public class PoligonoRegolare
{
    private double lato;
    private int numeroLati;
    private double NF=0;

    public PoligonoRegolare(double l,int nl)
    {
        lato=l;
        numeroLati=nl;
    }

    public double calcolaPerimetro()
    {
        return lato*numeroLati;
    }
    
    public double calcolaArea()
    {
        return (calcolaPerimetro()*calcolaApotema())/2;
    }
    
    private double calcolaApotema()
    {
        NF=1/(2*Math.tan(Math.PI/numeroLati));
        return lato*NF;
    }
    
    public String determinaTipo()
    {
        if (numeroLati==5) return "Pentagono";
        else if (numeroLati==6) return "Esagono";
        else if (numeroLati==7) return "Ettagono";
        else if (numeroLati==8) return "Ottagono";
        else if (numeroLati==9) return "Ennagono";
        else if (numeroLati==10) return "Decagono";
        else if (numeroLati==11) return "Endecagono";
        else if (numeroLati==12) return "Dodecagono";
    }
}
