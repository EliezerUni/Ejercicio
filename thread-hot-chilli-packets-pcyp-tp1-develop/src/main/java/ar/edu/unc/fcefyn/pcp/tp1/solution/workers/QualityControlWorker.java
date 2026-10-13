package ar.edu.unc.fcefyn.pcp.tp1.solution.workers;

import ar.edu.unc.fcefyn.pcp.tp1.solution.monitor.FarmMonitor;

public class QualityControlWorker extends Worker {

    public QualityControlWorker(FarmMonitor monitor, long delayMs) {
        super(monitor, delayMs);
    }

    @Override
    protected boolean procesar() throws InterruptedException {
        return monitor.controlarCalidad();
    }
}
