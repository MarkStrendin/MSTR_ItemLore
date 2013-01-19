package ca.strendin.MSTR_ItemLore;

import org.bukkit.entity.Player;

public class MSTR_Permissions {
    public static boolean canModifyItems(Player player) {
        return player.hasPermission("mstr_itemlore.modify");
    }
}
