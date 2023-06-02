package dev.codewizz.toggle;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Lightable;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

public class Events implements Listener {

	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		Action a = e.getAction();
		Block b = e.getClickedBlock();
		
		if(p.isSneaking() && a == Action.RIGHT_CLICK_BLOCK && b != null && e.getHand() == EquipmentSlot.HAND && e.getMaterial() == Material.AIR) {
			
			if(b.getType() == Material.REDSTONE_LAMP) {
				BlockData d = b.getBlockData();
				if(d instanceof Lightable) {
					((Lightable) d).setLit(true);
					b.setBlockData(d);
					e.setCancelled(true);
				}
			}
		}
	}
	
}
