package domcie.config;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import org.bukkit.entity.Player;

import utils.dropitems;


public class findstring {
	
	static File cxloc = configcreate.cxloc;
	static File lb1loc = configcreate.lootbox1loc;
	static File lb2loc = configcreate.lootbox2loc;
	static File lb3loc = configcreate.lootbox3loc;
	static File lb4loc = configcreate.lootbox4loc;
	
	public static void removeLineFromFile(String lineToRemove, File f, Player p) throws FileNotFoundException, IOException{
	    //Reading File Content and storing it to a StringBuilder variable ( skips lineToRemove)
	    StringBuilder sb = new StringBuilder();
	    try (Scanner sc = new Scanner(f)) {
	        String currentLine;
	        while(sc.hasNext()){
	            currentLine = sc.nextLine();
	            if(currentLine.equals(lineToRemove)){
	            	if(f.equals(cxloc)) {
	            		dropitems.cobblex(p);
	            	}
	            	if(f.equals(lb1loc)) {
	            		dropitems.lb1(p);
	            	}
	            	if(f.equals(lb2loc)) {
	            		dropitems.lb2(p);
	            	}
	            	if(f.equals(lb3loc)) {
	            		dropitems.lb3(p);
	            	}
	            	if(f.equals(lb4loc)) {
	            		dropitems.lb4(p);
	            	}
	                continue; //skips lineToRemove
	            }
	            sb.append(currentLine).append("\n");
	        }
	    }
	    //Delete File Content
	    PrintWriter pw = new PrintWriter(f);
	    pw.close();

	    BufferedWriter writer = new BufferedWriter(new FileWriter(f, true));
	    writer.append(sb.toString());
	    writer.close();
	}
}
