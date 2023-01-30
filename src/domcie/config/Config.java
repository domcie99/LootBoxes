package domcie.config;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;

import domcie.lootboxes;
import utils.cxDrop;

public class Config {
	
	private static Config inst;
	public FileConfiguration cfg = lootboxes.getInst().getConfig();
	
	public String cx$name;
	public Material cx$item;
	public List<String> cx$enchant;
	public int cx$minvalue;
	public int cx$maxvalue;
	public String cx$message;
	public List<String> cx$lore;

	public void reload(){
		lootboxes.getInst().reloadConfig();
		this.cfg = lootboxes.getInst().getConfig();
		load();
	}
	
	public void load(){
		
		this.cx$name = cfg.getString("cobblex.Name");
		this.cx$item = Material.getMaterial(cfg.getString("cobblex.Item"));
		this.cx$enchant = cfg.getStringList("cobblex.Enchant");
		this.cx$minvalue = cfg.getInt("cobblex.MinValue");
		this.cx$maxvalue = cfg.getInt("cobblex.MaxValue");
		this.cx$message = cfg.getString("cobblex.Message");
		this.cx$lore = cfg.getStringList("cobblex.Lore");
		
		for(String s : cfg.getConfigurationSection("cobblex.Items").getKeys(false)) {
			
			
			new cxDrop(
					Material.getMaterial(cfg.getString("cobblex.Items."+s+".Item"))
					, cfg.getString("cobblex.Items."+s+".Name")
					, cfg.getStringList("cobblex.Items."+s+".Lore")
					, cfg.getDouble("cobblex.Items."+s+".Chance")
					, cfg.getStringList("cobblex.Items."+s+".Enchant")
					, cfg.getInt("cobblex.Items."+s+".MinValue")
					, cfg.getInt("cobblex.Items."+s+".MaxValue")					
			);
		}

	}

	public static Config getInst(){
		if(inst == null) return new Config();
		return inst;
	}
	public Config(){
		inst = this;
	}

}
