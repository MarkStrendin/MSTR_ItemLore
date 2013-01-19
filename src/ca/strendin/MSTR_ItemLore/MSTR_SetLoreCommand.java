package ca.strendin.MSTR_ItemLore;

import java.util.ArrayList;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class MSTR_SetLoreCommand implements CommandExecutor {

	public MSTR_SetLoreCommand(MSTR_ItemLore mstr_ItemLore) {
	}

	public static ItemStack getItemWithAddedLore(ItemStack item, String lore) {
		ItemStack result = item;		
		ItemMeta meta = item.getItemMeta();		
		ArrayList<String> newLore = new ArrayList<String>();		
		newLore.add(lore);		
		meta.setLore(newLore);
		result.setItemMeta(meta);		
		return result;		
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2,
			String[] args) {
		if (sender instanceof Player) {
            if (MSTR_Permissions.canModifyItems(((Player)sender))) {
                Player player = (Player)sender;
                
                try
                {
                	if (args.length > 0) {                        
                        String newLoreString = "";
                        
                        for(String thisPart : args) {                        	
                        	newLoreString = newLoreString + thisPart + " ";
                        }

            			player.setItemInHand(getItemWithAddedLore(player.getItemInHand(),newLoreString));            			
            			
            			
                    	MSTR_Comms.sendError(player, "Lore added!");
                	}
                	             	
                } catch (Exception ex) {
                	MSTR_Comms.sendError(player, "There was an error naming that item");
                }
                
                
                
            } else {
            	MSTR_Comms.permDenyMsg((Player)sender);
            }
        } else {
        	MSTR_Comms.sendConsole("Player command only!");
        }        
        return true;
	}

}
