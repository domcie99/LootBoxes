package utils;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
public class cxDrop {

	public static List<cxDrop> cxDrops = new ArrayList<cxDrop>();
	
	private Material material;
	private String name;
	private List<String> lore;
	private double chance;
	private List<String> enchant;
	private int MinValue;
	private int MaxValue;
	
	public cxDrop(Material material, String name, List<String> lore, double chance, List<String> enchant, int MinValue, int MaxValue) {
		this.material = material;
		this.name = name;
		this.lore = lore;
		this.chance = chance;
		this.enchant = enchant;
		this.MinValue = MinValue;
		this.MaxValue = MaxValue;
		cxDrops.add(this);
	
	}
	public static cxDrop get(Material g) {
		for(cxDrop d : cxDrops) {
			if(d.getMaterial() == g) {
				return d;
			}
		}
		return null;
	}
	
	public Material getMaterial() {
		return material;
	}
	public String getName() {
		return name;
	}
	public double getChance() {
		return chance;
	}
	public List<String> getEnchant() {
		return enchant;
	}
	public List<String> getLore() {
		return lore;
	}
	public int getMinValue() {
		return MinValue;
	}
	public int getMaxValue() {
		return MaxValue;
	}
}
