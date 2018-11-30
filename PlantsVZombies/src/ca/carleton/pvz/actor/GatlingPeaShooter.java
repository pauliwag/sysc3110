package ca.carleton.pvz.actor;

import java.io.InputStream;

import ca.carleton.pvz.level.Level.Climate;
import javafx.scene.image.Image;

/**
 * A class for the gatling pea shooter, which has a high damage output.
 *
 */
public class GatlingPeaShooter extends PeaShooter {

	private static final long serialVersionUID = -9009721810436148422L;
	public static final int GATLING_PEA_COST = 300;
	public static final int GATLING_PEA_DAMAGE = 350;

	/**
	 * Constructs a new gatling pea-shooting plant, which deals more damage per
	 * shot than a normal pea shooter.
	 */
	public GatlingPeaShooter() {
		super(GATLING_PEA_COST, GATLING_PEA_DAMAGE);
	}

	/**
	 * Gets the gatling pea shooter sprite.
	 *
	 * @return The gatling pea shooter sprite.
	 */
	@Override
	public Image getSprite(Climate climate) {
		if(climate == Climate.NORMAL) return new Image(getClass().getResourceAsStream("/ca/carleton/pvz/resources/threepeater.png"));
		if(climate == Climate.DESERT) return new Image(getClass().getResourceAsStream("/ca/carleton/pvz/resources/threepeater_desert.png"));
		if(climate == Climate.WINTER) return new Image(getClass().getResourceAsStream("/ca/carleton/pvz/resources/threepeater_winter.png"));
		return null;
	}

}
