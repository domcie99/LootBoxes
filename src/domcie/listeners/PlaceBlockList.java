package domcie.listeners;

import java.io.File;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import domcie.config.Config;
import domcie.config.Message;
import domcie.config.addlocation;
import domcie.config.configcreate;


public class PlaceBlockList implements Listener {	
	
	Config cfg = Config.getInst();
	Message msg = Message.getInst();
	
	File cxloc = configcreate.cxloc;
	File lootbox1loc = configcreate.lootbox1loc;
	File lootbox2loc = configcreate.lootbox2loc;
	File lootbox3loc = configcreate.lootbox3loc;
	File lootbox4loc = configcreate.lootbox4loc;
    @EventHandler
    public void onPlace(BlockPlaceEvent e) {
    	
    	if (e.getPlayer().getInventory().getItemInMainHand().getType().equals(cfg.cx$item)) {
	    	if (e.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasDisplayName() && e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase(cfg.cx$name.replace("&", "§"))) {
	    		String loc = "" + e.getBlock().getLocation();
	    		String[] parts = loc.split(",");
	    		loc = parts[1] + "," + parts[2] + "," + parts[3];
	
	    		addlocation.addloc(cxloc,loc); 
	    		e.getPlayer().sendMessage(msg.getMessage("placecobblex"));
	        }
    	}
    }
}
