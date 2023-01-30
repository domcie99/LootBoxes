package domcie;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import domcie.commands.cobblex;
import domcie.commands.reload;
import domcie.commands.test;
import domcie.config.Config;
import domcie.config.Message;
import domcie.config.configcreate;
import domcie.listeners.BreakBlockList;
import domcie.listeners.PlaceBlockList;

public class lootboxes extends JavaPlugin{
	
	public static lootboxes inst;
	public static PluginDescriptionFile desc;
	
	public static lootboxes getInst(){
		return inst;
	}
	
	public static void error(String s, boolean disable) {
		Bukkit.getConsoleSender().sendMessage("§c["+desc.getName()+" v"+desc.getVersion()+"] "+s);
		if(disable) Bukkit.getPluginManager().disablePlugin(inst);
	}
	public static void success(String s) {
		Bukkit.getConsoleSender().sendMessage("§a["+desc.getName()+" v"+desc.getVersion()+"] "+s);
	}
	public void onEnable() {
		inst = this;
		desc = this.getDescription();
		configcreate.check();
		new cobblex(this);
		new reload(this);
		new test(this);
		Config.getInst().load();
		Message.getInst().load();
		Bukkit.getPluginManager().registerEvents(new BreakBlockList(), this);
		Bukkit.getPluginManager().registerEvents(new PlaceBlockList(), this);
	}

}
