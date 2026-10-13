package ar.edu.unc.fcefyn.pcp.tp1.solution.workers;

import ar.edu.unc.fcefyn.pcp.tp1.solution.monitor.FarmMonitor;

/**
 * Esqueleto comun de los workers. run() hace: mientras procesar() devuelva
 * true, dormir delayMs FUERA del lock. Si procesar() devuelve false, termina
 * sin dormir. Ante InterruptedException o RuntimeException llama a
 * monitor.abortar().
 */
public abstract class Worker implements Runnable {

    protected final FarmMonitor monitor;
    private final long delayMs;

    protected Worker(FarmMonitor monitor, long delayMs) {
        this.monitor = monitor;
        this.delayMs = delayMs;
    }

    @Override
    public final void run() {
        throw new UnsupportedOperationException("TODO");
    }

    /** true = proceso una orden (aplicar demora); false = no hay mas trabajo. */
    protected abstract boolean procesar() throws InterruptedException;
}
