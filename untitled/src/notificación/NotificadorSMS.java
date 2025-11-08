package notificacion;

public interface NotificadorSMS {
    void enviarSMS(String telefono, String mensaje);
}