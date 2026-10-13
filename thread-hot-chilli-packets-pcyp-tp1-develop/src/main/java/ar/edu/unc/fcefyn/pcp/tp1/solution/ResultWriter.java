package ar.edu.unc.fcefyn.pcp.tp1.solution;

import ar.edu.unc.fcefyn.pcp.tp1.api.OrderSnapshot;
import ar.edu.unc.fcefyn.pcp.tp1.api.OrderState;
import ar.edu.unc.fcefyn.pcp.tp1.api.SimulationResult;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class ResultWriter {

    /**
     * Exporta los eventos procesados a eventos.csv
     * Cabecera obligatoria: sequence;elapsedMs;thread;orderId;stage;event;fromState;toState;printer
     */
    public <E> void writeEventosCsv(String outputDir, List<E> eventos) {
        File file = new File(outputDir, "eventos.csv");
        try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
            writer.println("sequence;elapsedMs;thread;orderId;stage;event;fromState;toState;printer");

            if (eventos != null) {
                for (E e : eventos) {
                    writer.println(e.toString());
                }
            }

            System.out.println("Archivo eventos.csv generado con éxito.");
        } catch (IOException e) {
            System.err.println("Error al escribir eventos.csv: " + e.getMessage());
        }
    }

    /**
     * Exporta las órdenes a elementos.csv
     * Cabecera obligatoria: orderId;finalState;printer;assignmentCount;validationCount;printingCount;qualityControlCount
     */
    public void writeElementosCsv(String outputDir, SimulationResult result) {
        File file = new File(outputDir, "elementos.csv");
        try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
            writer.println("orderId;finalState;printer;assignmentCount;validationCount;printingCount;qualityControlCount");

            if (result.orders() != null) {
                for (OrderSnapshot order : result.orders()) {
                    String printerId = order.assignedPrinterId() != null ? order.assignedPrinterId() : "";
                    writer.printf("%d;%s;%s;%d;%d;%d;%d%n",
                            order.id(),
                            order.state(),
                            printerId,
                            order.assignmentCount(),
                            order.validationCount(),
                            order.printingCount(),
                            order.qualityControlCount()
                    );
                }
            }

            System.out.println("Archivo elementos.csv generado con éxito.");
        } catch (IOException e) {
            System.err.println("Error al escribir elementos.csv: " + e.getMessage());
        }
    }

    /**
     * Exporta el resumen del resultado de la simulación a resumen.properties
     */
    public void writeResumenProperties(String outputDir, SimulationResult result) {
        File file = new File(outputDir, "resumen.properties");
        Properties prop = new Properties();

        Map<OrderState, Integer> totals = result.totalsByState();

        int approved = totals != null ? totals.getOrDefault(OrderState.APPROVED, 0) : 0;
        int rejected = totals != null ? totals.getOrDefault(OrderState.REJECTED, 0) : 0;
        int printFailed = totals != null ? totals.getOrDefault(OrderState.PRINT_FAILED, 0) : 0;
        int defective = totals != null ? totals.getOrDefault(OrderState.DEFECTIVE, 0) : 0;
        int remainingIntermediate = result.totalOrders() - result.processedOrders();

        prop.setProperty("totalOrders", String.valueOf(result.totalOrders()));
        prop.setProperty("processedOrders", String.valueOf(result.processedOrders()));
        prop.setProperty("approvedOrders", String.valueOf(approved));
        prop.setProperty("rejectedOrders", String.valueOf(rejected));
        prop.setProperty("printFailedOrders", String.valueOf(printFailed));
        prop.setProperty("defectiveOrders", String.valueOf(defective));
        prop.setProperty("durationMillis", String.valueOf(result.durationMillis()));
        prop.setProperty("allThreadsTerminated", String.valueOf(result.allThreadsTerminated()));
        prop.setProperty("remainingIntermediateOrders", String.valueOf(remainingIntermediate));

        try (FileWriter writer = new FileWriter(file)) {
            prop.store(writer, "Resumen de Ejecución de Simulación PCP TP1");
            System.out.println("Archivo resumen.properties generado con éxito.");
        } catch (IOException e) {
            System.err.println("Error al escribir resumen.properties: " + e.getMessage());
        }
    }
}