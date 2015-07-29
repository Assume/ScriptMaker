package scripts.ScriptMaker.api.types.enums;

import java.awt.Point;

import org.tribot.api.General;
import org.tribot.api.input.Keyboard;
import org.tribot.api.input.Mouse;
import org.tribot.api2007.Game;
import org.tribot.api2007.GameTab;
import org.tribot.api2007.GameTab.TABS;
import org.tribot.api2007.Interfaces;
import org.tribot.api2007.Skills;

import scripts.ScriptMaker.api.methods.DefaultMethods;

public class Prayer {

	public enum Prayers {
		Piety(55, 54, "Piety", 70), Chivalry(53, 52, "Chivalry", 60), ProtectFromMelee(
				41, 40, "Protect from Melee", 43), ProtectFromMissiles(39, 38,
				"Protect from Missiles", 40), ProtectFromMagic(37, 36,
				"Protect from Magic", 37);

		private int interfaceId, hiddenId, levelRequired;
		private String name;

		Prayers(final int interfaceId, final int hiddenId, final String name,
				final int levelRequired) {
			this.interfaceId = interfaceId;
			this.hiddenId = hiddenId;
			this.name = name;
			this.levelRequired = levelRequired;
		}

		public int getInterfaceId() {
			return interfaceId;
		}

		public int getHiddenId() {
			return hiddenId;
		}

		public String getName() {
			return name;
		}

		public int getReqLevel() {
			return levelRequired;
		}

		public boolean isActivated() {
			return !Interfaces.get(271, hiddenId).isHidden();
		}
	}

	public int points() {
		return Skills.getCurrentLevel(Skills.SKILLS.PRAYER);
	}

	public static void disable(Prayer.Prayers pr) {
		if (GameTab.getOpen() != TABS.PRAYERS) {
			Keyboard.pressFunctionKey(5);
		}
		Point p = DefaultMethods.getRandomPoint(Interfaces.get(271,
				pr.getInterfaceId()).getAbsoluteBounds());
		Mouse.hop(p);// Could be move doesn't really matter
		for (int fsafe = 0; fsafe < 20
				&& !Game.getUptext().contains("Deactivate " + pr.getName()); fsafe++) {
			General.sleep(30);
		}
		if (Game.getUptext().contains("Deactivate " + pr.getName())) {
			DefaultMethods.leftClick(p);
		}
	}

	public static void activate(Prayer.Prayers pr) {
		if (GameTab.getOpen() != TABS.PRAYERS) {
			Keyboard.pressFunctionKey(5);
		}
		Point p = DefaultMethods.getRandomPoint(Interfaces.get(271,
				pr.getInterfaceId()).getAbsoluteBounds());
		Mouse.hop(p);// Could be move doesn't really matter
		for (int fsafe = 0; fsafe < 20
				&& !Game.getUptext().contains("Activate " + pr.getName()); fsafe++) {
			General.sleep(30);
		}
		if (Game.getUptext().contains("Activate " + pr.getName())) {
			DefaultMethods.leftClick(p);
		}
	}
}
