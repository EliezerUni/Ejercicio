package ar.edu.unc.fcefyn.pcp.tp1.publictests;

import ar.edu.unc.fcefyn.pcp.tp1.api.ConfigurationLoader;
import ar.edu.unc.fcefyn.pcp.tp1.api.SimulationConfig;
import ar.edu.unc.fcefyn.pcp.tp1.api.SimulationResult;
import ar.edu.unc.fcefyn.pcp.tp1.solution.ConcurrentSimulation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

public class StressTest {

    @Test
    @DisplayName("Test de Estrés: Múltiples corridas y verificación de invariantes")
    void testStressMultipleRuns() throws Exception {
        int totalCorridas = 20;

        // Se utiliza Path.of para pasar el tipo de dato esperado por ConfigurationLoader
        Path configPath = Path.of("config/tp1.properties");
        SimulationConfig config = ConfigurationLoader.load(configPath);

        for (int i = 1; i <= totalCorridas; i++) {
            final int runNumber = i;

            assertTimeoutPreemptively(Duration.ofSeconds(15), () -> {
                ConcurrentSimulation simulation = new ConcurrentSimulation();

                // Ejecución de la simulación concurrente
                SimulationResult result = simulation.execute(config);

                // Comprobación de los 10 invariantes obligatorios en cada corrida
                InvariantVerifierTest.verifyInvariants(result);

                System.out.println("Corrida de estrés #" + runNumber + " aprobada con éxito.");
            }, "La simulación en la corrida #" + runNumber + " demoró demasiado o cayó en Deadlock.");
        }
    }
}