package ca.carleton.pvz.level;

import java.awt.Point;
import java.util.HashMap;
import java.util.Random;

import ca.carleton.pvz.actor.FastZombie;
import ca.carleton.pvz.actor.NormalZombie;
import ca.carleton.pvz.actor.ShieldZombie;
import ca.carleton.pvz.actor.Zombie;

/**
 * Stores a wave of zombies.
 *
 */
public class Wave {

	/**
	 * This wave's number; determines when this wave will be deployed via the
	 * waves priority queue in the Level class.
	 */
	private int waveNum;

	/** A hash table of the numbers of different zombie types in this wave. */
	private HashMap<Class<? extends Zombie>, Integer> zombies;

	private static Random r;

	/**
	 * Creates a new wave comprising the specified numbers of zombies.
	 *
	 * @param waveNum This wave's sequence number.
	 * @param numNormalZombies The number of normal zombies initially in this
	 *            wave.
	 */
	public Wave(int waveNum, int numNormalZombies, int numShieldZombies, int numFastZombies) {

		this.waveNum = waveNum;

		zombies = new HashMap<>();
		zombies.put(NormalZombie.class, numNormalZombies);
		zombies.put(ShieldZombie.class, numShieldZombies);
		zombies.put(FastZombie.class, numFastZombies);

		r = new Random();

	}

	/**
	 * Returns whether this wave is defeated.
	 *
	 * @return true if this wave is defeated, false otherwise.
	 */
	public boolean isDefeated() {

		return getTotalNumZombies() == 0;

	}

	/**
	 * Gets the total number of zombies in this wave.
	 *
	 * @return The total number of zombies in this wave.
	 */
	public int getTotalNumZombies() {

		int totalNumZombies = 0;

		for (int num : zombies.values())
			totalNumZombies += num;

		return totalNumZombies;

	}

	/**
	 * Gets this wave's number.
	 *
	 * @return This wave's number.
	 */
	public int getNum() {

		return waveNum;

	}

	/**
	 * Sets this wave's number.
	 *
	 * @param waveNum The number to be assigned to this wave.
	 */
	public void setWaveNum(int waveNum) {

		this.waveNum = waveNum;

	}

	/**
	 * Gets the number of the specified zombie type in this wave.
	 *
	 * @param zombieType The zombie type whose quantity will be returned.
	 */
	public int getNumZombies(Class<? extends Zombie> zombieType) {

		return zombies.containsKey(zombieType) ? zombies.get(zombieType) : 0;

	}

	/**
	 * Sets the number of the specified zombie type in this wave.
	 *
	 * @param zombieType The zombie type whose quantity will be set.
	 * @param num The new quantity of the specified zombie type.
	 */
	public void setNumZombies(Class<? extends Zombie> zombieType, int num) {

		if (zombies.containsKey(zombieType))
			zombies.replace(zombieType, num);

	}

	/**
	 * Spawns zombies on game map according to waveNumber and numberofZombies.
	 *
	 * @param map The game map to be modified when zombies are spawning.
	 * @return The resulting game map after new zombies have spawned.
	 */
	public static Level spawnZombieOnLevel(Level level) {

		// TODO : Emigrate this method ...

		int randomRow = r.nextInt(5);
		Zombie zombie = new NormalZombie();
		level.placeActor(zombie, new Point(4, randomRow));
		return level;

	}

	public void setRemainingZombies(int num) {

		// TODO : This method is here for current ActionProcessor logic. Needs
		// to be refactored ...

		zombies.replace(NormalZombie.class, num);

	}

}