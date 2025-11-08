package notificacion;

public interface NotificadorEmail {
    void enviarEmail(String destinatario, String mensaje);
}