package ca.strendin.MSTR_ItemLore;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class MSTR_SetNameCommand implements CommandExecutor {

	public MSTR_SetNameCommand(MSTR_ItemLore mstr_ItemLore) {
	}

	public static ItemStack getRenamedItem(ItemStack item, String newName) {
		ItemStack result = item;		
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(newName);
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
                        
                        String newName = "";
                        
                        for(String thisPart : args) {                        	
                        	newName = newName + thisPart + " ";
                        }
                        
            			player.setItemInHand(getRenamedItem(player.getItemInHand(),newName));
                    	MSTR_Comms.sendError(player, "Item renamed!");
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
