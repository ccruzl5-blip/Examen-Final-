package servicio;

import notificacion.NotificadorEmail;

// Esta clase depende de la ABSTRACCIÓN (NotificadorEmail)
public class ServicioUsuario {

    private final NotificadorEmail notificador;

    // INYECCIÓN DE DEPENDENCIA: La instancia concreta se pasa en el constructor.
    public ServicioUsuario(NotificadorEmail notificador) {
        this.notificador = notificador;
    }

    public void registrarUsuario(String nombre, String email) {
        System.out.println(" ServicioUsuario: Usuario " + nombre + " registrado.");

        String mensajeBienvenida = "Bienvenido a nuestro servicio.";

        // El servicio usa el notificador SIN saber qué clase CONCRETA es.
        this.notificador.enviarEmail(email, mensajeBienvenida);
    }
}