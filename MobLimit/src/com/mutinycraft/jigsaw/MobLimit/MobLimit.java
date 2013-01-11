package com.mutinycraft.jigsaw.MobLimit;

import java.util.logging.Logger;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;
import org.bukkit.plugin.java.JavaPlugin;

public class MobLimit extends JavaPlugin implements Listener {

	Logger log;
	private static final String VERSION = "1.0";

	private static final EntityType CAVE_SPIDER = EntityType.CAVE_SPIDER;
	private static final EntityType SKELETON = EntityType.SKELETON;
	private static final EntityType SPIDER = EntityType.SPIDER;
	private static final EntityType ZOMBIE = EntityType.ZOMBIE;

	@Override
	public void onEnable() {
		log = this.getLogger();
		getServer().getPluginManager().registerEvents(this, this);
		log.info(this.getName() + " v" + VERSION + " enabled!");
	}

	@EventHandler
	public void SpawnerEvent(CreatureSpawnEvent e) {
		EntityType type = e.getEntityType();
		if (e.getSpawnReason() == SpawnReason.SPAWNER) {
			if (type == CAVE_SPIDER || type == SKELETON || type == SPIDER
					|| type == ZOMBIE) {
				e.setCancelled(true);
			}
		}
	}

	@Override
	public void onDisable() {
		log.info(this.getName() + " v" + VERSION + " disabled!");
	}

}
