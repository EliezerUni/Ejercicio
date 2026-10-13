package ar.edu.unc.fcefyn.pcp.tp1.solution.io;

import ar.edu.unc.fcefyn.pcp.tp1.api.OrderSnapshot;
import ar.edu.unc.fcefyn.pcp.tp1.api.SimulationResult;
import ar.edu.unc.fcefyn.pcp.tp1.solution.log.Evento;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

/**
 * Escribe los archivos de resultados. Se usa despues del join, sin hilos
 * vivos. Crea el directorio de salida si no existe y cierra los archivos.
 */
public class ResultWriter {

    public ResultWriter(Path outputDirectory) {
        throw new UnsupportedOperationException("TODO");
    }

    /** eventos.csv: cabecera exacta, separador ';', valores null como vacio. */
    public void escribirEventos(List<Evento> eventos) throws IOException {
        throw new UnsupportedOperationException("TODO");
    }

    /** elementos.csv: una fila por orden, ordenada por orderId. */
    public void escribirElementos(List<OrderSnapshot> ordenes) throws IOException {
        throw new UnsupportedOperationException("TODO");
    }

    /** resumen.properties con las claves minimas del enunciado. */
    public void escribirResumen(SimulationResult resultado, int ordenesIntermedias)
            throws IOException {
        throw new UnsupportedOperationException("TODO");
    }
}
