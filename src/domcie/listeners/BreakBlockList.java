package domcie.listeners;

import java.io.File;
import java.io.IOException;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import domcie.config.Config;
import domcie.config.configcreate;
import domcie.config.findstring;

public class BreakBlockList implements Listener {
	
	Config cfg = Config.getInst();
	
	File cxloc = configcreate.cxloc;
	File lootbox1loc = configcreate.lootbox1loc;
	File lootbox2loc = configcreate.lootbox2loc;
	File lootbox3loc = configcreate.lootbox3loc;
	File lootbox4loc = configcreate.lootbox4loc;
	
	@EventHandler(priority=EventPriority.LOWEST)
    public void onBreak(BlockBreakEvent e) {
		if (e.isCancelled()) {
			e.setCancelled(true);
			return;
		} 
		Block b = e.getBlock();
		Player p = e.getPlayer();
		if (b.getType().equals(cfg.cx$item)) {
			b.breakNaturally(new ItemStack(Material.AIR));
			
    		String loc = "" + b.getLocation();
    		String[] parts = loc.split(",");
    		loc = parts[1] + "," + parts[2] + "," + parts[3];
    		
    		try {
				findstring.removeLineFromFile(loc, cxloc, p);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
    }
}
