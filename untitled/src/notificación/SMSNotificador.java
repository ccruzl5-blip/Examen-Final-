package notificacion;

public class SMSNotificador implements NotificadorSMS {
    @Override
    public void enviarSMS(String telefono, String mensaje) {
        System.out.println(" SMSNotificador: Enviando SMS a " + telefono + ": " + mensaje);
    }
}