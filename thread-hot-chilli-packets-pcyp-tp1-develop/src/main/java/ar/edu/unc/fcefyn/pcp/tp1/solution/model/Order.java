package ar.edu.unc.fcefyn.pcp.tp1.solution.model;

import ar.edu.unc.fcefyn.pcp.tp1.api.OrderSnapshot;
import ar.edu.unc.fcefyn.pcp.tp1.api.OrderState;

/**
 * Orden de impresion. NO es thread-safe: solo se usa con el lock de
 * FarmMonitor tomado.
 */
public class Order {

    /** Crea la orden en estado CREATED. */
    public Order(int id) {
        throw new UnsupportedOperationException("TODO");
    }

    public int getId() {
        throw new UnsupportedOperationException("TODO");
    }

    public OrderState getState() {
        throw new UnsupportedOperationException("TODO");
    }

    /** Id de la impresora usada; dato historico, no se borra al liberarla. */
    public String getPrinterId() {
        throw new UnsupportedOperationException("TODO");
    }

    public boolean isTerminal() {
        throw new UnsupportedOperationException("TODO");
    }

    public void asociarImpresora(String printerId) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Valida que la transicion sea legal (IllegalStateException si no) e
     * incrementa el contador de la etapa correspondiente.
     */
    public void transitar(OrderState nuevo) {
        throw new UnsupportedOperationException("TODO");
    }

    public OrderSnapshot snapshot() {
        throw new UnsupportedOperationException("TODO");
    }
}
