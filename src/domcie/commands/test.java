package domcie.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import domcie.lootboxes;
import domcie.config.Config;

public class test implements CommandExecutor {
	
	Config cfg = Config.getInst();
	
	public test(lootboxes api) {
		api.getCommand("test").setExecutor(this);
	}
	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] arg3) {
		if(!(sender instanceof Player)) {
			sender.sendMessage("§4Komenda /test jest dostepna tylko dla graczy!"); 
			return false;
		}
		Player p = (Player) sender;

		p.sendMessage(cfg.cx$name.replace("&", "§"));
		return false;
		

		 
	}
}
