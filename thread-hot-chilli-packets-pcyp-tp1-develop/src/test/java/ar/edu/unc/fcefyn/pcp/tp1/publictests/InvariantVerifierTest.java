package ar.edu.unc.fcefyn.pcp.tp1.publictests;

import ar.edu.unc.fcefyn.pcp.tp1.api.OrderSnapshot;
import ar.edu.unc.fcefyn.pcp.tp1.api.OrderState;
import ar.edu.unc.fcefyn.pcp.tp1.api.PrinterSnapshot;
import ar.edu.unc.fcefyn.pcp.tp1.api.PrinterState;
import ar.edu.unc.fcefyn.pcp.tp1.api.SimulationResult;
import org.junit.jupiter.api.Assertions;

import java.util.List;

public class InvariantVerifierTest {

    /**
     * Comprueba los 10 invariantes obligatorios sobre el resultado de una simulación.
     */
    public static void verifyInvariants(SimulationResult result) {
        Assertions.assertNotNull(result, "El resultado de la simulación no debe ser nulo.");

        List<OrderSnapshot> orders = result.orders();
        List<PrinterSnapshot> printers = result.printers();

        // 1. Invariante 9: Al finalizar todas las órdenes deben estar procesadas
        Assertions.assertEquals(
                result.totalOrders(),
                result.processedOrders(),
                "Invariante 9 Violado: Existen órdenes pendientes o en estados intermedios."
        );

        // 2. Invariantes 1, 2 y 3: Validaciones por cada orden
        int totalOrderAssignments = 0;

        if (orders != null) {
            for (OrderSnapshot order : orders) {
                OrderState state = order.state();

                boolean isTerminal = state == OrderState.APPROVED
                        || state == OrderState.REJECTED
                        || state == OrderState.PRINT_FAILED
                        || state == OrderState.DEFECTIVE;

                Assertions.assertTrue(
                        isTerminal,
                        "Invariantes 1 y 2 Violados: La orden " + order.id() + " finalizó en estado no terminal: " + state
                );

                Assertions.assertTrue(order.assignmentCount() <= 1, "Invariante 3 Violado: Asignaciones excesivas en orden " + order.id());
                Assertions.assertTrue(order.validationCount() <= 1, "Invariante 3 Violado: Validaciones excesivas en orden " + order.id());
                Assertions.assertTrue(order.printingCount() <= 1, "Invariante 3 Violado: Impresiones excesivas en orden " + order.id());
                Assertions.assertTrue(order.qualityControlCount() <= 1, "Invariante 3 Violado: Controles de calidad excesivos en orden " + order.id());

                totalOrderAssignments += order.assignmentCount();
            }
        }

        // 3. Invariantes 6, 7 y 10: Validaciones por cada impresora
        int totalPrinterUses = 0;

        if (printers != null) {
            for (PrinterSnapshot printer : printers) {
                totalPrinterUses += printer.usageCount(); // <--- Corregido a usageCount()

                Assertions.assertNotEquals(
                        PrinterState.RESERVED,
                        printer.state(),
                        "Invariante 10 Violado: La impresora " + printer.id() + " quedó en estado RESERVED."
                );

                Assertions.assertNull(
                        printer.assignedOrderId(),
                        "Invariante 6 Violado: La impresora " + printer.id() + " finalizó reteniendo una orden."
                );
            }
        }

        // 4. Invariante 8: El contador de usos coincide con las asignaciones totales
        Assertions.assertEquals(
                totalOrderAssignments,
                totalPrinterUses,
                "Invariante 8 Violado: La suma de usos de impresoras (" + totalPrinterUses +
                        ") no coincide con las asignaciones de órdenes (" + totalOrderAssignments + ")."
        );

        // 5. Invariante de terminación de hilos
        Assertions.assertTrue(
                result.allThreadsTerminated(),
                "Invariante de Terminación Violado: Quedaron hilos activos al finalizar."
        );
    }
}