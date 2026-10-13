package ar.edu.unc.fcefyn.pcp.tp1.solution.log;

import ar.edu.unc.fcefyn.pcp.tp1.api.OrderState;
import ar.edu.unc.fcefyn.pcp.tp1.solution.model.Order;

import java.util.List;

/**
 * Registro en memoria de los eventos. NO es thread-safe: solo se usa con el
 * lock de FarmMonitor tomado. El archivo se escribe al final, sin hilos vivos.
 */
public class EventLog {

    public EventLog() {
        throw new UnsupportedOperationException("TODO");
    }

    /** ORDER_CREATED: stage INITIALIZATION, thread "main", fromState y printer vacios. */
    public void registrarCreacion(Order orden) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * ORDER_STATE_CHANGED. Se llama DESPUES de transitar la orden. El hilo se
     * toma de Thread.currentThread().getName() y la impresora de
     * orden.getPrinterId() (dato historico).
     */
    public void registrar(Etapa etapa, Order orden, OrderState desde, OrderState hasta) {
        throw new UnsupportedOperationException("TODO");
    }

    /** Eventos en orden de confirmacion. */
    public List<Evento> eventos() {
        throw new UnsupportedOperationException("TODO");
    }
}
