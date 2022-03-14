package org.palladiosimulator.hwsimcoupling.commands.ssh;

import java.io.File;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.palladiosimulator.hwsimcoupling.commands.CopyCommand;
import org.palladiosimulator.hwsimcoupling.util.MapHelper;

public class CopyCommandSSH extends CommandSSH implements CopyCommand {

    private String source_path;
    private String destination_filename;
    private String ip;
    private String user;
    private String key;

    public CopyCommandSSH(Map<String, Serializable> parameterMap, String source_path) {
        this.source_path = source_path;
        this.ip = MapHelper.getRequiredValueFromMap(parameterMap, "ip");
        this.user = MapHelper.getRequiredValueFromMap(parameterMap, "user");
        this.key = MapHelper.getRequiredValueFromMap(parameterMap, "key");
        this.destination_filename = new File(source_path).getName();
    }

    public List<String> getCommand() {
        List<String> command = getShell();
        command.add("scp");
        command.add("-r");
        command.add("-i");
        command.add(key);
        command.add(source_path);
        command.add(user + "@" + ip + ":" + destination_path + destination_filename);
        return command;
    }

    public String getDestination() {
        return destination_filename;
    }

}
