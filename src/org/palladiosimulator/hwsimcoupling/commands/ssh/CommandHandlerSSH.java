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

public class CommandHandlerSSH implements CommandHandler{

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
