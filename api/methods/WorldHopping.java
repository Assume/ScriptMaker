package scripts.ScriptMaker.api.methods;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;

import org.tribot.api.General;
import org.tribot.api.Timing;
import org.tribot.api.input.Mouse;
import org.tribot.api.types.generic.Condition;
import org.tribot.api2007.Combat;
import org.tribot.api2007.Game;
import org.tribot.api2007.GameTab;
import org.tribot.api2007.GameTab.TABS;
import org.tribot.api2007.Interfaces;
import org.tribot.api2007.Login;
import org.tribot.api2007.Login.STATE;
import org.tribot.api2007.Screen;
import org.tribot.api2007.types.RSInterfaceChild;

import scripts.ScriptMaker.main.Main;

public class WorldHopping {

	public final static Color WORLD_SWITCH_COLOUR = new Color(189, 152, 57);
	public final Color WORLD_GREEN_ARROW_COLOUR = new Color(47, 130, 43);
	public final static Color WORLD_RED_ARROW_COLOUR = new Color(172, 12, 4);

	public final static int WORLD_PIXEL_SIZE_X = 78;
	public final static int WORLD_PIXEL_SIZE_Y = 17;

	public static int[] worldsNotSupported = new int[] { 26, 35, 0, 1, 7, 8,
			37, 15, 16, 23, 24, 25, 31, 37, 32, 39, 40, 47, 48, 55, 56, 63, 64,
			71, 72, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93,
			94 };
	public final static int[] WORLDS_DONT_EXIST = new int[] { 7, 15, 23, 24,
			31, 32, 39, 40, 47, 48, 55, 56, 63, 64, 71, 72, 79, 80, 85, 86, 87,
			88, 89, 90, 91, 92 };
	public final static int WORLD_MAXIMUM_END = 94;

	private static boolean isAtWorldHopScreen() {

		return Screen.getColorAt(11, 0).equals(WORLD_SWITCH_COLOUR);
	}

	public static boolean hasMisconfiguredWorldSettings() {
		return Screen.getColorAt(301, 9).equals(WORLD_RED_ARROW_COLOUR);

	}

	private Main main;

	public WorldHopping(Main main) {
		this.main = main;
	}

	public static int getWorld() {
		int world = Game.getCurrentWorld();
		return world - 300;
	}

	public boolean hopp(int world) {
		main.setLoginBotState(false);
		if (world == -1)
			switchWorld(getRandomWorld());
		else
			switchWorld(world);
		Login.login();
		main.setLoginBotState(true);
		return true;
	}

	public boolean switchWorld(final int world) {

		long timeout = Timing.currentTimeMillis() + 60000;

		while (true && timeout > Timing.currentTimeMillis()) {
			Interfaces.closeAll();
			if (Combat.isUnderAttack()) {
				General.println("under attack exiting world hop loop");
				return false;
			}

			if (!isAtWorldHopScreen() && getWorld() == world) {
				// General.println("it returned true, currenet world = designated world");
				return true;
			}

			if (Login.getLoginState() == STATE.INGAME) {
				if (GameTab.getOpen() == TABS.LOGOUT) {

					RSInterfaceChild child = Interfaces.get(182, 6);
					if (child != null)
						child.click("Ok");
				} else {
					GameTab.open(TABS.LOGOUT);
				}
			} else if (Login.getLoginState().equals(STATE.WELCOMESCREEN)) {
				Login.login();
			} else if (isAtWorldHopScreen()) {
				if (hasMisconfiguredWorldSettings()) {
					Mouse.click(301, 9, 1);
					Timing.waitCondition(new Condition() {
						@Override
						public boolean active() {
							General.sleep(50, 100);
							return !hasMisconfiguredWorldSettings();
						}
					}, 2000);
				} else {
					Rectangle clickArea = getWorldClickArea(world);
					Point location = new Point((int) clickArea.getCenterX(),
							(int) clickArea.getCenterY());
					Mouse.hop(location);
					General.sleep(200);
					Mouse.sendPress(location, 1);
					Mouse.sendRelease(location, 1);
					Mouse.sendClickEvent(location, 1);

					if (Timing.waitCondition(new Condition() {
						@Override
						public boolean active() {
							General.sleep(50, 100);
							return !isAtWorldHopScreen() && getWorld() == world;
						}
					}, 2000)) {
						// General.println("it returned true, we not at world hop screen and currenet world = designated world");
						return true;
					}
				}
			} else if (getWorld() != world) {
				Rectangle rec = new Rectangle(10, 486, 100, 493);
				Point location = rec.getLocation();
				Mouse.hop(location);
				Mouse.sendPress(location, 1);
				Mouse.sendRelease(location, 1);
				Mouse.sendClickEvent(location, 1);
				Timing.waitCondition(new Condition() {
					@Override
					public boolean active() {
						General.sleep(50, 100);
						return isAtWorldHopScreen();
					}
				}, 5000);
			}

		}
		return !isAtWorldHopScreen() && getWorld() == world;
	}

	public boolean isWorldSupported(int world) {
		for (int i = 0; i < worldsNotSupported.length; i++) {
			if (worldsNotSupported[i] == world) {
				return false;
			}
		}
		return true;
	}

	public int getRandomWorld() {
		int randomWorld;
		while (!isWorldSupported((randomWorld = General.random(3,
				WORLD_MAXIMUM_END))))
			;
		return randomWorld;
	}

	public Rectangle getWorldClickArea(int world) {
		for (int w : worldsNotSupported) {
			if (w == world) {
				return null;
			}
		}

		int diff = 0;
		for (int i : WORLDS_DONT_EXIST) {
			if (world > i) {
				diff++;
			}
		}

		int x = (world - diff) / 17;
		int y = (world - diff) % 17;
		if (x == -1 || y == -1) {
			return null;
		} else {
			if (y == 0) {
				y = 17;
				x -= 1;
			}
			int xR = 208 + (x * 93);
			int yR = 62 + ((y - 1) * 24);
			return new Rectangle(xR, yR, WORLD_PIXEL_SIZE_X, WORLD_PIXEL_SIZE_Y);
		}
	}
}