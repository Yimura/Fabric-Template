package sh.damon.template;

import net.fabricmc.api.ModInitializer;
import sh.damon.template.command.CommandManager;
import sh.damon.template.util.Log;

public class Template implements ModInitializer {
	public static final String MOD_ID = "template";
	public static final String MOD_NAME = "Template";

	public final CommandManager commandManager = new CommandManager();

	public static Log log = new Log(MOD_NAME);

	private static Template instance;

	@Override
	public void onInitialize() {
		Template.instance = this;

		this.commandManager.registerAll();

		Template.log.info( "Mod is ready.");
	}

	public static Template getInstance() {
		return instance;
	}
}
