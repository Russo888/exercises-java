import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.awt.MouseInfo.*;
import java.util.ArrayList;

public class Nodo
{
    Object informazione;
    Nodo successivo;

    public Nodo(Object informazione)
    {
        this.informazione = informazione;
    }
    
    public Nodo(Object informazione, Nodo successivo)
    {
        this.informazione = informazione;
        this.successivo = successivo;
    }

    public void setInformazione(Object informazione)
    {
        this.informazione = informazione;
    }
    
    public void setSuccessivo(Nodo successivo)
    {
        this.successivo = successivo;
    }
    
    public Object getInformazione()
    {
        return informazione;
    }
    
    public Nodo getSuccessivo()
    {
        return successivo;
    }
    
}
