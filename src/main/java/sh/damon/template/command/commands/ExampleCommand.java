package sh.damon.template.command.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.LiteralText;
import sh.damon.template.command.BaseCommand;

import static net.minecraft.server.command.CommandManager.literal;

/**
 * This is an example command it implements BaseCommand.
 * Every command needs the below to methods to be present to work.
 */
public class ExampleCommand implements BaseCommand {
    /**
     * This method will be called to tell the server how your command works,
     * for more information on this you can read here https://fabricmc.net/wiki/tutorial:commands
     */
    @Override
    public void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(
            literal("template").executes(this)
        );
    }

    /**
     * This method has the actual code that needs to be ran when the command is triggered by someone
     */
    @Override
    public int run(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
        final ServerCommandSource source = context.getSource();
        final ServerPlayerEntity serverPlayerEntity = source.getPlayer();

        source.sendFeedback(
            new LiteralText(
                serverPlayerEntity.isSpectator()
                ? "Woah you're spectating, epic!"
                : "You're not spectating, switch to spectator to see a cool message!"
            ),
            false
        );
        
        return 0;
    }
}
