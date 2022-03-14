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
        command.add("python3");
        command.add("extract.py");
        return command;
    }

}