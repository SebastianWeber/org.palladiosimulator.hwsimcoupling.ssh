package org.palladiosimulator.hwsimcoupling.commands.ssh;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.palladiosimulator.hwsimcoupling.commands.ExtractionCommand;
import org.palladiosimulator.hwsimcoupling.util.MapHelper;

public class ExtractionCommandSSH extends CommandSSH implements ExtractionCommand {
	
	private String ip;
	private String user;
	private String key;
	
	public ExtractionCommandSSH(Map<String, Serializable> parameterMap) {
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
		command.add("python3");
		command.add("extract.py");
		return command;
	}

}