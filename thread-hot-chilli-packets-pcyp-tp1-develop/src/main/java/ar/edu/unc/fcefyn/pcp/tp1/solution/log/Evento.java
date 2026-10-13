package ar.edu.unc.fcefyn.pcp.tp1.solution.log;

import ar.edu.unc.fcefyn.pcp.tp1.api.OrderState;

/**
 * Una fila de eventos.csv, en el orden de las columnas del archivo.
 *
 * <p>Convencion: {@code fromState} es {@code null} en ORDER_CREATED, y
 * {@code printer} es {@code null} cuando la orden aun no tuvo impresora.
 * ResultWriter escribe {@code null} como cadena vacia.
 */
public record Evento(
        long sequence,
        long elapsedMs,
        String thread,
        int orderId,
        Etapa stage,
        TipoEvento event,
        OrderState fromState,
        OrderState toState,
        String printer
) {
}
