package org.palladiosimulator.hwsimcoupling.commands.ssh;

import java.io.Serializable;
import java.util.Map;

import org.palladiosimulator.hwsimcoupling.commands.CopyCommand;
import org.palladiosimulator.hwsimcoupling.commands.ExtractionCommand;
import org.palladiosimulator.hwsimcoupling.commands.SimulationCommand;
import org.palladiosimulator.hwsimcoupling.consumers.ErrorConsumer;
import org.palladiosimulator.hwsimcoupling.consumers.OutputConsumer;
import org.palladiosimulator.hwsimcoupling.consumers.ssh.DemandExtractor;
import org.palladiosimulator.hwsimcoupling.consumers.ssh.ErrorDetector;
import org.palladiosimulator.hwsimcoupling.util.CommandHandler;

public class CommandHandlerSSH extends CommandHandler {

    public CommandHandlerSSH() {
        // ip: the ip address of the server
        // key: the cryptographic key used to connect to the server
        // user: the username used to connect to the server
        // executable: the executable to benchmark
        // parameter: the parameters for the execution of the executable
        parameters = new String[] { "ip", "key", "user", "executable", "parameter" };
    }

    @Override
    public CopyCommand getCopyCommand(Map<String, Serializable> parameterMap, String source_path) {
        return new CopyCommandSSH(parameterMap, source_path);
    }

    @Override
    public ExtractionCommand getExtractionCommand(Map<String, Serializable> parameterMap) {
        return new ExtractionCommandSSH(parameterMap);
    }

    @Override
    public SimulationCommand getSimulationCommand(Map<String, Serializable> parameterMap) {
        return new SimulationCommandSSH(parameterMap);
    }

    @Override
    public OutputConsumer getOutputConsumer() {
        return new DemandExtractor();
    }

    @Override
    public ErrorConsumer getErrorConsumer() {
        return new ErrorDetector();
    }

}
