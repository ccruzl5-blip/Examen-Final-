package notificacion;

public class EmailNotificador implements NotificadorEmail {
    @Override
    public void enviarEmail(String destinatario, String mensaje) {
        System.out.println(" EmailNotificador: Enviando Email a " + destinatario + ": " + mensaje);
    }
}