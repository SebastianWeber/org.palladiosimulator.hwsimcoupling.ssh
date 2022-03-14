package org.palladiosimulator.hwsimcoupling.commands.ssh;

import java.util.List;

import org.palladiosimulator.hwsimcoupling.commands.Command;

public abstract class CommandSSH implements Command {

    // Empty path results in using the home directory of the given user
    public final String destination_path = "~/";

    public abstract List<String> getCommand();

}
