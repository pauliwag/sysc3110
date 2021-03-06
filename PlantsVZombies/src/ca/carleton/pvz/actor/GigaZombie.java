package ca.carleton.pvz.actor;

import ca.carleton.pvz.level.Level.Terrain;
import javafx.scene.image.Image;

/**
 * A subtype of Zombie that has a speed of 1 and the highest health of all
 * zombie types.
 *
 */
public class GigaZombie extends Zombie {

	private static final long serialVersionUID = 2794406455409047062L;
	public static final int GIGA_ZOMBIE_HEALTH = 2000;
	public static final int GIGA_ZOMBIE_SPEED = 1;
	public static final String GIGA_ZOMBIE_GRASS_SPRITE = "/ca/carleton/pvz/resources/giga_zombie_grass.png";
	public static final String GIGA_ZOMBIE_SAND_SPRITE = "/ca/carleton/pvz/resources/giga_zombie_sand.png";
	public static final String GIGA_ZOMBIE_ICE_SPRITE = "/ca/carleton/pvz/resources/giga_zombie_ice.png";

	/**
	 * Constructs a GigaZombie.
	 */
	public GigaZombie() {
		super(GIGA_ZOMBIE_HEALTH, GIGA_ZOMBIE_SPEED);
	}

	/**
	 * Gets the GigaZombie sprite.
	 *
	 * @return The GigaZombie sprite.
	 */
	@Override
	public Image getSprite(Terrain terrain) {
		if (terrain == Terrain.GRASS)
			return new Image(getClass().getResourceAsStream(GIGA_ZOMBIE_GRASS_SPRITE));
		if (terrain == Terrain.SAND)
			return new Image(getClass().getResourceAsStream(GIGA_ZOMBIE_SAND_SPRITE));
		if (terrain == Terrain.ICE)
			return new Image(getClass().getResourceAsStream(GIGA_ZOMBIE_ICE_SPRITE));
		return null;
	}

}
