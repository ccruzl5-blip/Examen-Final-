package notificacion;

public interface NotificadorPush {
    void enviarPush(String token, String mensaje);
}