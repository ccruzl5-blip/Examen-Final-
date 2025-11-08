import notificacion.EmailNotificador;
import notificacion.NotificadorEmail;
import notificacion.SMSNotificador;
import servicio.ServicioUsuario;

public class Main {
    public static void main(String[] args) {

        // --- 1. Usando Email Notificador ---
        System.out.println("--- Caso 1: Inyectando EmailNotificador ---");


        NotificadorEmail notificadorEmail = new EmailNotificador();

        // Crear el servicio e INYECTAR la dependencia
        ServicioUsuario servicioEmail = new ServicioUsuario(notificadorEmail);

        servicioEmail.registrarUsuario("Ana Pérez", "ana.perez@ejemplo.com");


        System.out.println("\n------------------------------------------\n");


        // --- 2. Usando SMS (Necesitamos un Adaptador/Proxy para cumplir con la interfaz) ---
        // El ServicioUsuario solo conoce NotificadorEmail, así que creamos un adaptador
        // para "disfrazar" el SMSNotificador como si fuera un NotificadorEmail.

        System.out.println("--- Caso 2: Inyectando Adaptador de SMS ---");

        // Clase temporal para adaptar SMSNotificador a la interfaz NotificadorEmail
        class SMSAdapter implements NotificadorEmail {
            private final SMSNotificador smsNotificador = new SMSNotificador();

            @Override
            public void enviarEmail(String destinatario, String mensaje) {
                // Llama al método de SMS en lugar de Email
                smsNotificador.enviarSMS(destinatario, mensaje);
            }
        }

        NotificadorEmail notificadorSMSAdapter = new SMSAdapter();

        // Creamos OTRO servicio, e INYECTAMOS el adaptador.
        // El código de ServicioUsuario sigue siendo el mismo.
        ServicioUsuario servicioSMS = new ServicioUsuario(notificadorSMSAdapter);

        servicioSMS.registrarUsuario("Juan López", "555-1234");
    }
}