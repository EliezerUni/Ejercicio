package ar.edu.unc.fcefyn.pcp.tp1.solution.monitor;

import ar.edu.unc.fcefyn.pcp.tp1.api.OrderSnapshot;
import ar.edu.unc.fcefyn.pcp.tp1.api.PrinterSnapshot;
import ar.edu.unc.fcefyn.pcp.tp1.api.SimulationConfig;
import ar.edu.unc.fcefyn.pcp.tp1.solution.log.Evento;

import java.util.List;

/**
 * Unica region critica de la simulacion: todo el estado compartido se accede
 * con synchronized sobre este objeto. Las demoras NO se hacen aqui adentro.
 *
 * <p>Contrato de los metodos de etapa (asignar, validar, imprimir,
 * controlarCalidad): cada llamada espera con wait() hasta poder tomar una
 * orden, la procesa de forma atomica (transicion, evento, cola siguiente,
 * impresora, notifyAll) y devuelve true. Devuelve false cuando no queda
 * trabajo para esa etapa (el worker debe terminar), o si se llamo a abortar().
 */
public class FarmMonitor {

    /**
     * Crea las ordenes 1..totalOrders (estado CREATED), las impresoras y
     * registra los ORDER_CREATED.
     */
    public FarmMonitor(SimulationConfig config) {
        throw new UnsupportedOperationException("TODO");
    }

    /** CREATED -> WAITING_VALIDATION; reserva una impresora. */
    public boolean asignar() throws InterruptedException {
        throw new UnsupportedOperationException("TODO");
    }

    /** WAITING_VALIDATION -> READY_TO_PRINT | REJECTED (libera la impresora). */
    public boolean validar() throws InterruptedException {
        throw new UnsupportedOperationException("TODO");
    }

    /** READY_TO_PRINT -> PRINTED (libera) | PRINT_FAILED (OUT_OF_SERVICE). */
    public boolean imprimir() throws InterruptedException {
        throw new UnsupportedOperationException("TODO");
    }

    /** PRINTED -> APPROVED | DEFECTIVE. */
    public boolean controlarCalidad() throws InterruptedException {
        throw new UnsupportedOperationException("TODO");
    }

    /** Despierta a todos los hilos y hace que las etapas devuelvan false. */
    public void abortar() {
        throw new UnsupportedOperationException("TODO");
    }

    // ---- Lectura: SOLO despues del join (sin hilos vivos) ----

    /** Snapshots de las ordenes, ordenados por id. */
    public List<OrderSnapshot> snapshotsOrdenes() {
        throw new UnsupportedOperationException("TODO");
    }

    public List<PrinterSnapshot> snapshotsImpresoras() {
        throw new UnsupportedOperationException("TODO");
    }

    /** Eventos en orden de confirmacion. */
    public List<Evento> eventos() {
        throw new UnsupportedOperationException("TODO");
    }

    /** Ordenes que no estan en estado terminal (debe ser 0 al finalizar). */
    public int ordenesIntermedias() {
        throw new UnsupportedOperationException("TODO");
    }
}
