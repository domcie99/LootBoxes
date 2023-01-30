package domcie.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import domcie.lootboxes;
import domcie.config.Config;
import domcie.config.Message;
import utils.enchants;

public class cobblex implements CommandExecutor {
	
	Config cfg = Config.getInst();
	Message msg = Message.getInst();
	
	public cobblex(lootboxes api) {
		api.getCommand("cobblex").setExecutor(this);
		api.getCommand("cx").setExecutor(this);
	}
	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] arg3) {
		if(!(sender instanceof Player)) {
			sender.sendMessage("§4Komenda /cobblex jest dostepna tylko dla graczy!"); 
			return false;
		}
		Player p = (Player) sender;
		
		if (p.getInventory().contains(Material.COBBLESTONE, 576)) {
			sender.sendMessage(cfg.cx$message.replace("&", "§"));
			removeItems(p.getInventory(), Material.COBBLESTONE, 576);
			
			
			
			ItemStack item = new ItemStack(cfg.cx$item,1);
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName(cfg.cx$name.replace("&", "§"));
			
			List<String> Lore = new ArrayList<String>();
			for(String s : cfg.cx$lore) {
				Lore.add(s.replace("&", "§"));
			}
			 
			meta.setLore(Lore);
			item.setItemMeta(meta);

			for(String e : cfg.cx$enchant) {
				String[] ench = e.split(" ");
                int lvl = Integer.parseInt(ench[1]);
                String type = ench[0].toLowerCase();   
                Enchantment what = enchants.getEnchantment(type); 
                item.addUnsafeEnchantment(what, lvl);
			}
			
			p.getInventory().addItem(item);

		} else {
			int amount = 0;
			for(ItemStack is : p.getInventory().all(Material.COBBLESTONE).values())
			{
			    amount=amount+is.getAmount();
			}
			String ile = String.valueOf(576-amount);
		    sender.sendMessage(msg.getMessage("notenought").replace("{ILE}", ile));
		}
		return true;
	}
    public static void removeItems(Inventory inventory, Material type, int amount) {
        if (amount <= 0) return;
        int size = inventory.getSize();
        for (int slot = 0; slot < size; slot++) {
            ItemStack is = inventory.getItem(slot);
            if (is == null) continue;
            if (type == is.getType()) {
                int newAmount = is.getAmount() - amount;
                if (newAmount > 0) {
                    is.setAmount(newAmount);
                    break;
                } else {
                    inventory.clear(slot);
                    amount = -newAmount;
                    if (amount == 0) break;
                }
            }
        }
    }
		 
}
