package ca.strendin.MSTR_ItemLore;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;


public class MSTR_ItemLore extends JavaPlugin {@Override
    public void onDisable() {
    MSTR_Comms.logThis("Plugin DISABLED");        
}

@Override
public void onEnable() {
    //Commands
	getCommand("setitemlore").setExecutor(new MSTR_SetLoreCommand(this));
	getCommand("setitemname").setExecutor(new MSTR_SetNameCommand(this));
    MSTR_Comms.logThis("Plugin ENABLED");        
}

public Player findPlayerNamed(String thisName) {
    return this.getServer().getPlayer(thisName);
}

}
