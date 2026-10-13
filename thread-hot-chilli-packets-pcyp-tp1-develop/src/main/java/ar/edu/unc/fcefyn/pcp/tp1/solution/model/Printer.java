package ar.edu.unc.fcefyn.pcp.tp1.solution.model;

import ar.edu.unc.fcefyn.pcp.tp1.api.PrinterSnapshot;
import ar.edu.unc.fcefyn.pcp.tp1.api.PrinterState;

/**
 * Impresora. NO es thread-safe: solo se usa con el lock de FarmMonitor
 * tomado. El int de reservar/liberar/marcarFueraDeServicio es el id de la
 * orden; se verifica que sea la duena de la reserva.
 */
public class Printer {

    /** Crea la impresora AVAILABLE con id "P-fila-columna". */
    public Printer(int row, int column) {
        throw new UnsupportedOperationException("TODO");
    }

    public String getId() {
        throw new UnsupportedOperationException("TODO");
    }

    public PrinterState getState() {
        throw new UnsupportedOperationException("TODO");
    }

    /** AVAILABLE -> RESERVED, usageCount++, asigna la orden. */
    public void reservar(int ordenId) {
        throw new UnsupportedOperationException("TODO");
    }

    /** RESERVED -> AVAILABLE, borra la orden asignada. */
    public void liberar(int ordenId) {
        throw new UnsupportedOperationException("TODO");
    }

    /** RESERVED -> OUT_OF_SERVICE, borra la orden asignada. No se reutiliza. */
    public void marcarFueraDeServicio(int ordenId) {
        throw new UnsupportedOperationException("TODO");
    }

    public PrinterSnapshot snapshot() {
        throw new UnsupportedOperationException("TODO");
    }
}
