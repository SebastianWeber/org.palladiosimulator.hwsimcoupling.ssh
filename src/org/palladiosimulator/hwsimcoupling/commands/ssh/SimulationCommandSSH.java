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
        this.executable = MapHelper.getRequiredValueFromMap(parameterMap, "executable");
        this.parameters = MapHelper.getRequiredValueFromMap(parameterMap, "parameter");
        this.ip = MapHelper.getRequiredValueFromMap(parameterMap, "ip");
        this.user = MapHelper.getRequiredValueFromMap(parameterMap, "user");
        this.key = MapHelper.getRequiredValueFromMap(parameterMap, "key");
    }

    @Override
    public List<String> getCommand() {
        List<String> command = getShell();
        command.add("ssh");
        command.add("-i");
        command.add(key);
        command.add(user + "@" + ip);
        command.add("chmod 700 " + executable + " && " + "python3 execute_and_benchmark.py ./" + executable);
        for (String parameter : parameters.split(" ")) {
            command.add(parameter);
        }
        return command;
    }

}
