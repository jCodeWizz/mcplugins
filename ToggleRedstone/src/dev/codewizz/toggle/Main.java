package dev.codewizz.toggle;

import org.bukkit.plugin.java.JavaPlugin; 

public class Main extends JavaPlugin {

	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new Events(), this);
	}
	
	@Override
	public void onDisable() {

	}
}
