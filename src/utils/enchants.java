package utils;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.enchantments.Enchantment;

public class enchants {

    public static Enchantment getEnchantment(String enchString) {
        // Clean up string - make lowercase and strip space/dash/underscore
        enchString = enchString.toLowerCase().replaceAll("[ _-]", "");
 
        // Set up aliases (this could probably be done outside the function so
        // we only do it once (eg. in a support class init or read from a file)
        Map <String, String> aliases = new HashMap<String, String>();
        aliases.put("power", "arrowdamage");
        aliases.put("flame", "arrowfire");
        aliases.put("infinity", "arrowinfinite");
        aliases.put("punch", "arrowknockback");
        aliases.put("sharpness", "damageall");
        aliases.put("baneofarthropods", "damagearthropods");
        aliases.put("smite", "damageundead");
        aliases.put("depthstrider", "depthstrider");
        aliases.put("efficiency", "digspeed");
        aliases.put("unbreaking", "durability");
        aliases.put("fireacpect", "fireaspect");
        aliases.put("knockback", "knockback");
        aliases.put("fortune", "lootbonusblocks");
        aliases.put("looting", "lootbonusmobs");
        aliases.put("luckofthesea", "luck");
        aliases.put("lure", "lure");
        aliases.put("respiration", "oxygen");
        aliases.put("protection", "protectionenvironmental");
        aliases.put("blastprotection", "protectionexplosions");
        aliases.put("featherfalling", "protectionfall");
        aliases.put("fireprotection", "protectionfire");
        aliases.put("projectileprotection", "protectionprojectile");
        aliases.put("silktouch", "silktouch");
        aliases.put("thorns", "thorns");
        aliases.put("aquaaffinity", "waterworker"); 
 
        // If an alias exists, use it
        String alias = aliases.get(enchString);
        if (alias != null)
            enchString = alias;
 
        // Loop through all enchantments and match (case insensitive and ignoring space,
        // underscore and dashes
        for (Enchantment value : Enchantment.values()) {
            if (enchString.equalsIgnoreCase(value.getName().replaceAll("[ _-]", ""))) {
                return value;
            }
        }
       
        return null; // nothing found.
    }
}
