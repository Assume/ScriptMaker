package scripts.ScriptMaker.api.methods;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import org.tribot.api.DynamicClicking;
import org.tribot.api.General;
import org.tribot.api.input.Keyboard;
import org.tribot.api.input.Mouse;
import org.tribot.api.types.generic.CustomRet_0P;
import org.tribot.api2007.Banking;
import org.tribot.api2007.Camera;
import org.tribot.api2007.ChooseOption;
import org.tribot.api2007.Game;
import org.tribot.api2007.GameTab;
import org.tribot.api2007.Interfaces;
import org.tribot.api2007.Inventory;
import org.tribot.api2007.Login;
import org.tribot.api2007.NPCChat;
import org.tribot.api2007.Objects;
import org.tribot.api2007.Player;
import org.tribot.api2007.Skills;
import org.tribot.api2007.Walking;
import org.tribot.api2007.types.RSItem;
import org.tribot.api2007.types.RSNPC;
import org.tribot.api2007.types.RSObject;
import org.tribot.api2007.types.RSTile;

public class DefaultMethods {

	public static int[] convertIntegerToInt(Integer[] ar) {
		int[] arrs = new int[ar.length];
		for (int i = 0; i < arrs.length; i++) {
			arrs[i] = ar[i];
		}
		return arrs;
	}

	public static double getHPPercent() {
		return ((double) Skills.getCurrentLevel(Skills.SKILLS.HITPOINTS)
				/ (double) Skills.getActualLevel(Skills.SKILLS.HITPOINTS) * 100);
	}

	// Used to get a random point in a interface rectangle with a offset
	// Probably a better way to do this
	public static Point getRandomPoint(Rectangle rec) {
		int randomX = getRandomInteger(rec.getMinX() + 10, rec.getMaxX() - 10);
		int randomY = getRandomInteger(rec.getMinY() + 10, rec.getMaxY() - 10);
		return new Point(randomX, randomY);
	}

	public static int getRandomInteger(double min, double max) {
		return General.random((int) min, (int) max);
	}

	public static int stringLength(String s, Graphics g) {
		int x = 0;
		for (int c1 = 0; c1 < s.length(); c1++) {
			char ch = s.charAt(c1);
			x += g.getFontMetrics().charWidth(ch);
		}
		return x;
	}

	// BruteForces a Area using a center tile and a randius
	public static List<RSTile> circleArea(RSTile center, int radius) {
		List<RSTile> area = new ArrayList<RSTile>();
		for (int x = center.getX() - radius; x < radius + center.getX(); x++) {
			for (int y = center.getY() - radius; y < radius + center.getY(); y++) {
				if (center.distanceTo(new RSTile(x, y)) < radius) {
					area.add(new RSTile(x, y));
				}
			}
		}
		return area;
	}

	public static RSTile getNearestSafespot(ArrayList<RSTile> p) {
		RSTile[] g = p.toArray(new RSTile[p.size()]);
		RSTile temp;
		for (int i = 0; i < g.length - 1; i++) {
			if (Player.getPosition().distanceTo(g[i]) > Player.getPosition()
					.distanceTo(g[i + 1])) {
				temp = g[i];
				g[i] = g[i + 1];
				g[i + 1] = temp;
				i = -1;
			}
		}
		if (g.length > 0) {
			return g[0];
		}
		return null;
	}

	public static void clickObject(RSObject o, String option) {
		clickObject(o, option, 0);
	}

	private static boolean objectCheck(RSObject o) {
		for (RSObject a : Objects.getAt(o.getPosition())) {
			if (a.getID() == o.getID()) {
				return true;
			}
		}
		return false;
	}

	public static void clickObject(RSObject o, String option, int fail) {
		if (fail > 4)
			return;
		if (o == null || o.getModel() == null
				|| Objects.find(50, o.getID()).length == 0 || !objectCheck(o))
			return;
		if (!o.isOnScreen() || fail > 4) {
			RSTile tile = o.getPosition();
			Keyboard.pressKey((char) KeyEvent.VK_CONTROL);
			Walking.walkTo(tile);
			Keyboard.releaseKey((char) KeyEvent.VK_CONTROL);
			General.sleep(250, 350);
			while (Player.isMoving() && !o.isOnScreen()) {
				// If Object is moving or if using
				// NPC pass the npc/Object
				turnTo(tile);
			}
			// Additonal Failsafe so that it always clicks properly
			while (Player.isMoving())
				General.sleep(30, 50);
			// Probably not needed
			if (!o.isOnScreen()) {
				clickObject(o, option, fail + 1);
			}
			fail = 0;
		}
		// 5 Is a default offset of 5 Increase this to make it more random
		Point p = getAverage(o.getModel().getAllVisiblePoints(), 10);
		Mouse.move(p);
		for (int fSafe = 0; fSafe < 20 && !Game.getUptext().contains(option)
				|| fSafe < 20 && !Game.getUptext().contains("Use"); fSafe++)
			General.sleep(10, 15);
		if (Game.getUptext().contains(option)
				|| Game.getUptext().contains("Use")) {
			Keyboard.pressKey((char) KeyEvent.VK_CONTROL);
			Mouse.click(1);
			Keyboard.releaseKey((char) KeyEvent.VK_CONTROL);
		} else {
			Mouse.click(3);
			for (int fSafe = 0; fSafe < 20 && !ChooseOption.isOpen(); fSafe++)
				General.sleep(20, 25);
			if (ChooseOption.isOpen() && ChooseOption.isOptionValid(option)) {
				Keyboard.pressKey((char) KeyEvent.VK_CONTROL);
				ChooseOption.select(option);
				Keyboard.releaseKey((char) KeyEvent.VK_CONTROL);
			} else if (ChooseOption.isOpen()) {
				ChooseOption.close();
				clickObject(o, option, fail + 1);
			} else {
				clickObject(o, option, fail + 1);
			}
		}
		General.sleep(350, 500);
		while (Player.isMoving() && Player.getAnimation() == -1) {
			General.sleep(20, 30);
		}
	}

	public static void turnTo(final RSTile loc) {
		if (loc == null) {
			return;
		}
		final int cAngle = Camera.getCameraRotation();
		final int angle = 180 + Camera.getTileAngle(loc);
		final int dir = cAngle - angle;
		if (Math.abs(dir) <= 190 && Math.abs(dir) >= 180) {
			return;
		}
		Camera.setCameraRotation(Camera.getCameraRotation()
				+ ((dir > 0 ^ Math.abs(dir) > 180) ? 10 : -10));
	}

	public static void turnTo(final RSObject loc) {
		if (loc == null) {
			return;
		}
		final int cAngle = Camera.getCameraRotation();
		final int angle = 180 + Camera.getTileAngle(loc.getPosition());
		final int dir = cAngle - angle;
		if (Math.abs(dir) <= 190 && Math.abs(dir) >= 180) {
			return;
		}
		Camera.setCameraRotation(Camera.getCameraRotation()
				+ ((dir > 0 ^ Math.abs(dir) > 180) ? 10 : -10));
	}

	public static boolean rightClick(RSNPC m, String option) {
		try {
			Mouse.setSpeed(500);
			if (m.isValid()) {
				if (m.getModel() != null) {

					Mouse.move(DefaultMethods.getAverage(m.getModel()
							.getAllVisiblePoints(), 0));
					Mouse.click(DefaultMethods.getAverage(m.getModel()
							.getAllVisiblePoints(), 0), 3);
					General.sleep(80, 120);
					for (int fSafe = 0; fSafe < 20 && !ChooseOption.isOpen(); fSafe++)
						General.sleep(General.random(10, 15));
					if (ChooseOption.isOpen()) {
						if (ChooseOption.isOptionValid(option)) {
							return ChooseOption.select(option);
						} else {
							ChooseOption.close();
							return false;
						}
					}
				}
			}
		} catch (Exception e) {

		}
		return false;
	}

	public static boolean click(RSNPC m, String option) {
		return clickR(m, option);
	}

	public static boolean clickR(RSNPC m, String option) {
		try {
			Mouse.setSpeed(500);
			if (m.isValid()) {
				if (m.getModel() != null)
					Mouse.move(DefaultMethods.getAverage(m.getModel()
							.getAllVisiblePoints(), 0));
				for (int fSafe = 0; fSafe < 20
						&& !Game.getUptext().contains(option); fSafe++)
					General.sleep(General.random(10, 15));
				if (Game.getUptext().contains(option)) {
					Mouse.click(1);
					return true;
				}
			}
		} catch (Exception e) {

		}
		return false;

	}

	public static boolean click(RSObject m, String option) {
		try {
			Mouse.setSpeed(500);
			if (m != null) {
				if (m.getModel() != null)
					Mouse.move(DefaultMethods.getAverage(m.getModel()
							.getAllVisiblePoints(), 0));
				for (int fSafe = 0; fSafe < 20
						&& !Game.getUptext().contains(option); fSafe++)
					General.sleep(General.random(10, 15));
				if (Game.getUptext().contains(option)) {
					Mouse.click(1);
					return true;
				} else {
					Mouse.click(DefaultMethods.getAverage(m.getModel()
							.getAllVisiblePoints(), 0), 3);
					General.sleep(80, 120);
					for (int fSafe = 0; fSafe < 20 && !ChooseOption.isOpen(); fSafe++)
						General.sleep(General.random(10, 15));
					if (ChooseOption.isOpen()) {
						if (ChooseOption.isOptionValid(option)) {
							return ChooseOption.select(option);
						} else {
							ChooseOption.close();
							return false;
						}
					}
				}
			}
		} catch (Exception e) {

		}
		return false;
	}

	public static boolean inBuildingMode() {
		if (Game.getSetting(261) == 1)
			return true;
		return false;
	}

	public static boolean isBuildingInterfaceOpen() {
		if (Game.getSetting(262) == 14)
			return true;
		return false;
	}

	public static void setBuildingMode() {
		if (Interfaces.get(398, 19) == null) {
			if (GameTab.getOpen() != GameTab.TABS.OPTIONS) {
				Keyboard.pressFunctionKey(10);
			}
			Interfaces.get(261, 35).click("Open");
			for (int fsafe = 0; fsafe < 20 && Interfaces.get(398, 19) == null; fsafe++) {
				General.sleep(20, 30);
			}
		}
		if (Interfaces.get(398, 19) != null) {
			if (!Interfaces.get(398, 19).click("Ok")) {
				setBuildingMode();
			} else {
				if (Banking.isPinScreenOpen()) {
					Banking.inPin();
				}
			}
		} else {
			setBuildingMode();
		}
	}

	// Finds average points in a Point[] use offset to make it random
	public static Point getAverage(Point[] pointArray, int offset) {
		int averagex = 0;
		int averagey = 0;
		int totalx = 0;
		int totaly = 0;
		for (int i = 0; i < pointArray.length; i++) {
			totalx = totalx + pointArray[i].x;
			totaly = totaly + pointArray[i].y;
		}
		if (pointArray.length != 0) {
			averagex = totalx / pointArray.length;
			averagey = totaly / pointArray.length;
		}
		return new Point(averagex + General.random(-offset, offset), averagey
				+ General.random(-offset, offset));
	}

	// Fastest point clicking method (built for sudoku)
	public static void leftClick(final Point point) {
		DynamicClicking.clickPoint(new CustomRet_0P<Point>() {
			@Override
			public Point ret() {
				return point;
			}
		}, 1);
	}

	public static void leftClick(int x, int y) {
		leftClick(new Point(x, y));
	}

	// Fast accurate Drop Method for trash randoms events (some ids missing)
	public void dropAllExcept(ArrayList<Integer> t) {
		for (RSItem d : Inventory.getAll()) {
			if (!t.contains(d.getID())) {
				d.click("drop");
			}
		}
	}

	public static void turnTo(final RSNPC loc) {
		if (loc == null) {
			return;
		}
		final int cAngle = Camera.getCameraRotation();
		final int angle = 180 + Camera.getTileAngle(loc.getPosition());
		final int dir = cAngle - angle;
		if (Math.abs(dir) <= 190 && Math.abs(dir) >= 180) {
			return;
		}
		Camera.setCameraRotation(Camera.getCameraRotation()
				+ ((dir > 0 ^ Math.abs(dir) > 180) ? 10 : -10));
	}

	public static String lastMessage() {
		try {
			if (Interfaces.get(137) != null) {
				for (int i = Interfaces.get(137).getChildren().length - 1; i > 0; i--) {
					try {
						if (Interfaces.get(137).getChildren()[i].getText() != "") {
							return Interfaces.get(137).getChildren()[i]
									.getText();
						}
					} catch (Exception e) {
					}
				}
			}
		} catch (Exception e) {
		}
		return "";
	}

	public int getFirstEmpty() {
		if (Inventory.getAll().length > 0 && !Inventory.isFull()) {
			if (Inventory.getAll()[0].getIndex() > 0) {
				return 0;
			}
		} else {
			return -1;
		}
		RSItem[] t = Inventory.getAll();
		for (int i = 0; i < t.length; i++) {
			if (t[i].getIndex() != i) {
				return i;
			}
		}
		return t.length + 1;
	}

	public static void logOut() {
		if (Player.getRSPlayer().isInCombat()) {
			while (Player.getRSPlayer().isInCombat()) {

			}
			System.out.println("Logging out");
			if (Login.logout()) {
				// If in divinus loader change this to throw exception
			}
		} else {
			System.out.println("Out of food Logging out");
			if (Login.logout()) {
				// If in divinus loader change this to throw exception
			}
		}
	}

	public static void doStrongholdDoor() {
		String[] ops = {
				"Don't give him my password.",
				"Don't tell them anything and inform Jagex through the game website.",
				"Nobody",
				"Game Inbox on the RuneScape website.",
				"The birthday of a famous person or event.",
				"Talk to any banker in RuneScape.",
				"Nowhere.",
				"Recovering your account if it is stolen.",
				"Use the 'Recover a Lost Password' section on the RuneScape website.",
				"Only on the RuneScape website.",
				"Memorable",
				"No",
				"Politely tell them no and then use the 'Report Abuse' button.",
				"No, it might steal my password.",
				"Don't tell them anything and click the 'Report Abuse' button.",
				"Don't give them the information and send an 'Abuse report'.",
				"Every couple of months",
				"Virus scan my computer then change my password and recoveries.",
				"No.",
				"To help me recover my password if I forget it or it is stolen." };

		NPCChat.clickContinue(true);
		if (Interfaces.get(230, 0) != null || Interfaces.get(228, 0) != null) {
			String[] ans = NPCChat.getOptions();
			if (ans.length > 0) {
				for (int a = 0; a < ans.length; a++) {
					for (int i = 0; i < ops.length; i++) {
						if (ans[a].toString().equals(ops[i])) {
							NPCChat.selectOption(ops[i], true);
						}
					}
				}
			}
			NPCChat.clickContinue(true);
		}
		NPCChat.clickContinue(true);
		General.sleep(500);
	}

	public static boolean intArrayContains(int num, int... array) {
		for (int d : array) {
			if (d == num) {
				return true;
			}
		}
		return false;
	}

}
