package org.palladiosimulator.hwsimcoupling.commands.ssh;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.palladiosimulator.hwsimcoupling.commands.SimulationCommand;
import org.palladiosimulator.hwsimcoupling.util.MapHelper;

public class SimulationCommandSSH extends CommandSSH implements SimulationCommand {
	
	private String executable;
	private String parameters;
	private String ip;
	private String user;
	private String key;
	
	
	public SimulationCommandSSH(Map<String, Serializable> parameterMap) {
		this.executable = MapHelper.get_required_value_from_map(parameterMap, "executable");
		this.parameters = MapHelper.get_required_value_from_map(parameterMap, "parameter");
		this.ip = MapHelper.get_required_value_from_map(parameterMap, "ip");
		this.user = MapHelper.get_required_value_from_map(parameterMap, "user");
		this.key = MapHelper.get_required_value_from_map(parameterMap, "key");
	}

	@Override
	public List<String> get_command() {
		List<String> command = get_shell();
		command.add("ssh");
		command.add("-i");
		command.add(key);
		command.add(user + "@" + ip);
		command.add("chmod 700 " + executable + " && " + "python3 execute_and_benchmark.py ./" +  executable);
		for (String parameter : parameters.split(" ")) {
			command.add(parameter);
		}
		return command;
	}

}
