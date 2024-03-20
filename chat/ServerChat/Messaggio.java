import java.time.*;
public class Messaggio
{
    String testo;
    String mittente;
    String destinatario;
    String mode;
    LocalDateTime orario;

    public Messaggio(String mode, String testo, String mittente, String destinatario )
    {
        this.mode=mode;
        this.testo=testo;
        this.mittente=mittente;
        this.destinatario=destinatario;
        orario=LocalDateTime.now();
    }
    
    public String getMode()
    {
        return mode;
    }

    public String getText()
    {
        return testo;
    }

    public String getMittente()
    {
        return mittente;
    }

    public String getDestinatario()
    {
        return destinatario;
    }

    public LocalDateTime getTime()
    {
        return orario;
    }
}