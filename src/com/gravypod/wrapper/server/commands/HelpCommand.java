package com.gravypod.wrapper.server.commands;

import java.util.ArrayList;

import com.gravypod.starmadewrapper.User;
import com.gravypod.starmadewrapper.plugins.commands.Command;

public class HelpCommand extends Command {
	
	private final ArrayList<String> helpMessages = new ArrayList<String>();
	
	private final String[] GENERIC_STRING_ARRAY = new String[0];
	
	@Override
	public void run(final String username, final User user, final String... args) {
	
		helpMessages.clear();
		
		for (final Command c : getServer().getCommandManager().getCommands()) {
			final String help = c.getHelp();
			if (help == null) {
				continue;
			}
			helpMessages.add(help);
		}
		
		pm(username, helpMessages.toArray(GENERIC_STRING_ARRAY));
	}
	
	@Override
	public String getHelp() {
	
		return "!help: Get a list of commands and their usage";
	}
	
}
