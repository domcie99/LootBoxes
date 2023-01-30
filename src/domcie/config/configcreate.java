package domcie.config;

import java.io.File;
import java.io.IOException;

import domcie.lootboxes;

public class configcreate {
	
	public static File mainDir = lootboxes.getInst().getDataFolder();
	public static File cfgFile = new File(mainDir, "config.yml");
	public static File data = new File(mainDir, "data");
	private static File messages = new File(lootboxes.getInst().getDataFolder(), "messages.yml");
	
	public static File lootbox1loc = new File(data, "lootbox1loc.yml");
	public static File lootbox2loc = new File(data, "lootbox2loc.yml");
	public static File lootbox3loc = new File(data, "lootbox3loc.yml");
	public static File lootbox4loc = new File(data, "lootbox4loc.yml");
	public static File cxloc = new File(data, "cxloc.yml");
	
	public static void check(){
		if(!mainDir.exists()) mainDir.mkdir();
		if(!data.exists()) data.mkdir();
		if(!messages.exists()) lootboxes.getInst().saveResource("messages.yml", true);
		
		if(!cxloc.exists()) {try {cxloc.createNewFile();} catch (IOException e) { e.printStackTrace();}}
		if(!lootbox1loc.exists()) {try {lootbox1loc.createNewFile();} catch (IOException e) { e.printStackTrace();}}
		if(!lootbox2loc.exists()) {try {lootbox2loc.createNewFile();} catch (IOException e) { e.printStackTrace();}}
		if(!lootbox3loc.exists()) {try {lootbox3loc.createNewFile();} catch (IOException e) { e.printStackTrace();}}
		if(!lootbox4loc.exists()) {try {lootbox4loc.createNewFile();} catch (IOException e) { e.printStackTrace();}}
		
		if(!cfgFile.exists()) lootboxes.getInst().saveDefaultConfig();
	}
	public static File getDataFolder(){
		return data;
	}
	public static File getConfigFile(){
		return cfgFile;
	}
	public static File getMessagesFile(){
		return messages;
	}
}
