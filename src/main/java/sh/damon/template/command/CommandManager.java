package sh.damon.template.command;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.server.command.ServerCommandSource;
import sh.damon.template.command.commands.ExampleCommand;

import java.util.HashSet;

public class CommandManager {
    private final HashSet<BaseCommand> commands;

    public CommandManager() {
        this.commands = new HashSet<>();
    }

    /**
     * Register commands to the CommandDispatcher of the server
     * @param dispatcher The original instance coming from the server
     * @param isDedicated If the mod is running in dedicated environment or not
     */
    public void register(CommandDispatcher<ServerCommandSource> dispatcher, boolean isDedicated) {
        for (BaseCommand command : this.commands) {
            command.register(dispatcher);
        }
    }

    /**
     * Register all the commands you created in the commands/ directory here.
     */
    public void registerAll() {
        this.register(new ExampleCommand());
    }

    private void register(final BaseCommand command) {
        this.commands.add(command);
    }
}
