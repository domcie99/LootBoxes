package utils;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import domcie.config.Config;
import domcie.config.Message;

public class dropitems extends Object {
	
	Config cfg = Config.getInst();
	static Message msg = Message.getInst();
	
	public static void cobblex(Player p) {
		//HashMap<Integer, ItemStack> rest = new HashMap<Integer, ItemStack>();
		p.sendMessage(msg.getMessage("cxdestroy"));
		for(cxDrop d : cxDrop.cxDrops) {
			if(constructors.chance(d.getChance())) {;
				int amount = constructors.getRandInt(d.getMinValue(), d.getMaxValue());	
				
				ItemStack item = new ItemStack(d.getMaterial(), amount);
				ItemMeta meta = item.getItemMeta();
				
				if(!d.getName().isEmpty() && !d.getName().equalsIgnoreCase("[]")){
					meta.setDisplayName(d.getName().replace("&", "§"));
				}
				
				List<String> Lore = new ArrayList<String>();
				for(String s : d.getLore()) {
					Lore.add(s.replace("&", "§"));
				}
				 
				meta.setLore(Lore);
				item.setItemMeta(meta);

				
				for(String s : d.getEnchant()) {
					String[] ench = s.split(" ");
                    int lvl = Integer.parseInt(ench[1]);
                    String type = ench[0].toLowerCase();               
                    Enchantment what = enchants.getEnchantment(type);                   
                    item.addUnsafeEnchantment(what, lvl);                 
				} 
				p.getInventory().addItem(item);
				break;
				
			}
		}
		
	}

	public static void lb1(Player p) {
		// TODO Auto-generated method stub
		
	}

	public static void lb2(Player p) {
		// TODO Auto-generated method stub
		
	}

	public static void lb3(Player p) {
		// TODO Auto-generated method stub
		
	}

	public static void lb4(Player p) {
		// TODO Auto-generated method stub
		
	}

}
