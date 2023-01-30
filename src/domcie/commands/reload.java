package domcie.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import domcie.lootboxes;
import domcie.config.Config;

public class reload implements CommandExecutor {
		
	public reload(lootboxes api) {
		api.getCommand("lootboxes").setExecutor(this);
	}
	@Override
	public boolean onCommand(CommandSender sender, Command command, String alias, String[] args) {
		if (alias.equalsIgnoreCase("lootboxes")) {
			if (args.length == 0) {
				sender.sendMessage("Autorem projektu LootBoxes jest DomCie99");
			} else { 
				if (args[0].equalsIgnoreCase("reload")) {
					sender.sendMessage("Reloaded LootBoxes config!");
					Config.getInst().reload();
				} else {
					sender.sendMessage("Usage: /LootBoxes :reload");
				}
			}
		}
		return false;
	}
}