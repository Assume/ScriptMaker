package scripts.ScriptMaker.api.types.enums;

import java.io.Serializable;

import org.tribot.api.General;
import org.tribot.api.input.Keyboard;
import org.tribot.api2007.GameTab;
import org.tribot.api2007.GameTab.TABS;
import org.tribot.api2007.Interfaces;
import org.tribot.api2007.Inventory;
import org.tribot.api2007.Player;
import org.tribot.api2007.Skills;

import scripts.ScriptMaker.main.vars;


public class Magic implements Serializable {
	private static final long serialVersionUID = 874943930509459009L;

	public enum Spell implements Serializable{		
		HomeTeleport(0,0),
		LowAlchemy(13,21),
		VarrockTeleport(15,25),
		LumbridgeTeleport(18,31),
		TelekineticGrab(19,33),
		FaladorTeleport(21,37),
		HouseTeleport(23,40),
		SuperheatItem(25,43),
		CamelotTeleport(26,45),
		ArdougneTeleport(32,51),
		HighAlchemy(34,55),
		WatchtowerTeleport(37,58),
		TrollheimTeleport(44,61),
		ApeAtollTeleport(47,64),
		AmuletOfGloryEdgeville(-1,0),
		AmuletOfGloryKaramja(-1,0),
		AmuletOfGloryDraynorVillage(-1,0),
		AmuletOfGloryAlKharid(-1,0),
		RingOfDuelingDuelArena(-1,0),
		RingOfDuelingCastleWars(-1,0),
		GamesNecklaceBurthrope(-1,0),
		GamesNecklaceBarbarianOutpost(-1,0);

		private static final long serialVersionUID = 8749439123131230909L;
		
		private int interfaceId, levelRequired;
		Spell(final int interfaceId, final int levelRequired) {
			this.interfaceId = interfaceId;
			this.levelRequired = levelRequired;
		}
		
		public int getInterfaceId() {
			return interfaceId;
		}
		
		public int getReqLevel() {
			return levelRequired;
		}
	}

	public static void teleport(Magic.Spell spell) {
		if (Skills.getActualLevel(Skills.SKILLS.MAGIC) >= spell.getReqLevel()) {
			if (spell.equals(Spell.RingOfDuelingCastleWars)) {
				teleportJewelry(230, 2, true, vars.duelRing);
				return;
			}
			if (spell.equals(Spell.RingOfDuelingDuelArena)) {
				teleportJewelry(230, 1, true, vars.duelRing);
				return;
			}
			if (spell.equals(Spell.GamesNecklaceBurthrope)) {
				teleportJewelry(230, 1, false, vars.gamesNeck);
				return;
			}
			if (spell.equals(Spell.GamesNecklaceBarbarianOutpost)) {
				teleportJewelry(230, 2, false, vars.gamesNeck);
				return;
			}
			if (spell.equals(Spell.AmuletOfGloryEdgeville)) {
				teleportJewelry(234, 1, false, vars.gloryNeck);
				return;
			}
			if (spell.equals(Spell.AmuletOfGloryKaramja)) {
				teleportJewelry(234, 2, false, vars.gloryNeck);
				return;
			}
			if (spell.equals(Spell.AmuletOfGloryDraynorVillage)) {
				teleportJewelry(234, 3, false, vars.gloryNeck);
				return;
			}
			if (spell.equals(Spell.AmuletOfGloryAlKharid)) {
				teleportJewelry(234, 4, false, vars.gloryNeck);
				return;
			}
			if (GameTab.getOpen() != TABS.MAGIC) {
				Keyboard.pressFunctionKey(6);
			}
			Interfaces.get(192, spell.getInterfaceId()).click("Cast");
		}
	}
	
	public static void spellOnItem(Magic.Spell spell, int itemId) {
		if (Skills.getActualLevel(Skills.SKILLS.MAGIC) >= spell.getReqLevel()) {
			if (GameTab.getOpen() == TABS.MAGIC) {
				Interfaces.get(192, spell.getInterfaceId()).click("Cast");
				Inventory.find(itemId)[0].click("Cast");
				while (Player.getAnimation() != -1) {
					General.sleep(50);
				}
			} else {
				Keyboard.pressFunctionKey(6);
				spellOnItem(spell, itemId);
			}
		}
	}
	
	static void teleportJewelry(int index, int child, boolean ring, int... ID) {
		if (Equipment.isEquiped(ID)) {
			if (ring) {
				if (GameTab.getOpen() != TABS.EQUIPMENT) {
					Keyboard.pressFunctionKey(4);
				}
				Interfaces.get(387,22).click("Operate");
				for(int fail=0;fail<40 && Interfaces.get(index,child) == null;fail++) {
					General.sleep(40,60);
				}
				if (Interfaces.get(index, child) == null) {
					System.out.println("Jewelery Teleportation was interupted trying again");
					teleportJewelry(index,child,ring,ID);
				}
				Interfaces.get(index,child).click("Continue");
			} else {
				if (GameTab.getOpen() != TABS.EQUIPMENT) {
					Keyboard.pressFunctionKey(4);
				}
				Interfaces.get(387,14).click("Operate");
				for(int fail=0;fail<80 && Interfaces.get(index,child) == null;fail++) {
					General.sleep(40,60);
				}
				if (Interfaces.get(index, child) == null) {
					System.out.println("Jewelery Teleportation was interupted trying again");
					teleportJewelry(index,child,ring,ID);
				}
				Interfaces.get(index,child).click("Continue");
			}
		} else {
			if (Inventory.find(ID).length > 0) {
				Inventory.find(ID)[0].click("Rub");
				for(int fail=0;fail<80 && Interfaces.get(index,child) == null;fail++) {
					General.sleep(40,60);
				}
				if (Interfaces.get(index, child) == null) {
					System.out.println("Jewelery Teleportation was interupted trying again");
					teleportJewelry(index,child,ring,ID);
				}
				Interfaces.get(index,child).click("Continue");
			}
		}
	}
}
