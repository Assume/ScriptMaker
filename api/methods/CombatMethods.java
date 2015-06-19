package scripts.ScriptMaker.api.methods;

import java.awt.event.KeyEvent;

import org.tribot.api.General;
import org.tribot.api.input.Keyboard;
import org.tribot.api.input.Mouse;
import org.tribot.api2007.Game;
import org.tribot.api2007.GameTab;
import org.tribot.api2007.GameTab.TABS;
import org.tribot.api2007.Player;
import org.tribot.api2007.types.RSNPC;

public class CombatMethods {

	static int getSpecial() {
		return Game.getSetting(300) / 10;
	}

	static boolean isSpecialOn() {
		Mouse.setSpeed(0);
		if (Game.getSetting(301) == 1) {
			return true;
		}
		return false;
	}

	/*
	 * static int getAntifireTimer() { return Game.getSetting(1299); }
	 * 
	 * static boolean isAntifired() { return getAntifireTimer() > 32; }
	 */

	static boolean monsterInCombat(RSNPC m) {
		return m.getInteractingCharacter() != null
				&& m.getInteractingCharacter().getCombatCycle() > 0;
	}

	static boolean inCombat() {
		return Player.getRSPlayer().getInteractingCharacter() != null
				&& Player.getRSPlayer().getInteractingCharacter()
						.getCombatCycle() > 0;
	}

	static boolean isCannonFiring() {
		if (Game.getSetting(1) == 1048576) {
			return true;
		}
		return false;
	}

	static boolean isRunEnabled() {
		if (Game.getSetting(173) == 1) {
			return true;
		}
		return false;
	}

	static boolean autoRetaliateIsEnabled() {
		if (Game.getSetting(172) == 1) {
			return false;
		}
		return true;
	}

	public static int getCombatStyle() {
		return (Game.getSetting(43));
	}

	static void useSpecial(int percentSpecUsed, int... specWeaponId) {
		if (isSpecialOn()) {
			return;
		}
		int curSpec = getSpecial();
		if (curSpec >= percentSpecUsed) {
			if (GameTab.getOpen() != TABS.COMBAT) {
				Keyboard.pressFunctionKey(1);
			}
			Mouse.clickBox(574, 417, 710, 427, 1);
			for (int fsafe = 0; getSpecial() >= curSpec && fsafe < 30; fsafe++) {
				General.sleep(40, 50);
			}
			if (getSpecial() >= curSpec) {
				useSpecial(percentSpecUsed, specWeaponId);
			}
		}
	}

	public static void turnOffRetaliate() {
		if (autoRetaliateIsEnabled()) {
			if (GameTab.getOpen() != GameTab.TABS.COMBAT) {
				Keyboard.pressFunctionKey(1);
			}
			Mouse.clickBox(575, 366, 705, 395, 1);
			for (int fail = 0; fail < 20 && autoRetaliateIsEnabled(); fail++) {
				General.sleep(50, 75);
			}
			if (autoRetaliateIsEnabled()) {
				turnOffRetaliate();
			}
			if (GameTab.getOpen() != GameTab.TABS.INVENTORY) {
				Keyboard.pressKey((char) KeyEvent.VK_ESCAPE);
			}
		}
	}

	public static void turnOnRetaliate() {
		if (!autoRetaliateIsEnabled()) {
			if (GameTab.getOpen() != GameTab.TABS.COMBAT) {
				Keyboard.pressFunctionKey(1);
			}
			Mouse.clickBox(575, 366, 705, 395, 1);
			for (int fail = 0; fail < 20 && !autoRetaliateIsEnabled(); fail++) {
				General.sleep(50, 75);
			}
			if (!autoRetaliateIsEnabled()) {
				turnOnRetaliate();
			}
			if (GameTab.getOpen() != GameTab.TABS.INVENTORY) {
				Keyboard.pressKey((char) KeyEvent.VK_ESCAPE);
			}
		}
	}
}
