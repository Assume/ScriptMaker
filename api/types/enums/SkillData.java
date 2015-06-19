package scripts.ScriptMaker.api.types.enums;

import java.awt.Color;

import org.tribot.api2007.Skills;


public class SkillData {
	
	private static int[] sAttack = new int[2];
	private static int[] sStrength = new int[2];
	private static int[] sDefence = new int[2];
	private static int[] sRange = new int[2];
	private static int[] sMagic = new int[2];
	private static int[] sHitpoints = new int[2];
	private static int[] sSlayer = new int[2];
	private static int savedAttack = 0;
	private static int savedStrength = 0;
	private static int savedDefence = 0;
	private static int savedRange = 0;
	private static int savedMagic = 0;
	private static int savedHitpoints = 0;
	private static int savedSlayer = 0;
	public enum Skill {
		Attack(), Strength(), Defence(), Range(), Magic(), Hitpoints(), Slayer();

		Skill() {
		}

		public int getXp() {
			switch(this)
			{
			case Attack:
				return Skills.getXP(Skills.SKILLS.ATTACK);
			case Strength:
				return Skills.getXP(Skills.SKILLS.STRENGTH);
			case Defence:
				return Skills.getXP(Skills.SKILLS.DEFENCE);
			case Range: 
				return Skills.getXP(Skills.SKILLS.RANGED);
			case Magic:
				return Skills.getXP(Skills.SKILLS.MAGIC);
			case Hitpoints:
				return Skills.getXP(Skills.SKILLS.HITPOINTS);
			case Slayer:
				return Skills.getXP(Skills.SKILLS.SLAYER);
			}
			return 0;
		}
		
		public double getXpSinceLastSave() {
			int a = savedSlayer + savedAttack + savedDefence
					+ savedHitpoints + savedMagic + savedRange
					+ savedStrength;
			if (a == 0) {
				switch (this) {
				case Attack:
					savedAttack = getXp() - sAttack[0];
					return getXp() - sAttack[0];
				case Strength:
					savedStrength = getXp() - sStrength[0];
					return getXp() - sStrength[0];
				case Defence:
					savedDefence = getXp() - sDefence[0];
					return getXp() - sDefence[0];
				case Range:
					savedRange = getXp() - sRange[0];
					return getXp() - sRange[0];
				case Magic:
					savedMagic = getXp() - sMagic[0];
					return getXp() - sMagic[0];
				case Hitpoints:
					savedHitpoints = getXp() - sHitpoints[0];
					return getXp() - sHitpoints[0];
				case Slayer:
					savedSlayer = getXp() - sSlayer[0];
					return getXp() - sSlayer[0];
				}
				return 0;
			} else {
				double b;
				switch (this) {
				case Attack:
					b = getXp() - sAttack[0] - savedAttack;
					savedAttack = getXp() - sAttack[0];
					return b;
				case Strength:
					b = getXp() - sStrength[0] - savedStrength;
					savedStrength = getXp() - sStrength[0];
					return b;
				case Defence:
					b = getXp() - sDefence[0] - savedDefence;
					savedDefence = getXp() - sDefence[0];
					return b;
				case Range:
					b = getXp() - sRange[0] - savedRange;
					savedRange = getXp() - sRange[0];
					return b;
				case Magic:
					b = getXp() - sMagic[0] - savedMagic;
					savedMagic = getXp() - sMagic[0];
					return b;
				case Hitpoints:
					b = getXp() - sHitpoints[0] - savedHitpoints;
					savedHitpoints = getXp() - sHitpoints[0];
					return b;
				case Slayer:
					b = getXp() - sSlayer[0] - savedSlayer;
					savedSlayer = getXp() - sSlayer[0];
					return b;
				}
				return 0;
			}
		}

		public int getLevel() {
			switch(this)
			{
			case Attack:
				return Skills.getActualLevel(Skills.SKILLS.ATTACK);
			case Strength:
				return Skills.getActualLevel(Skills.SKILLS.STRENGTH);
			case Defence:
				return Skills.getActualLevel(Skills.SKILLS.DEFENCE);
			case Range: 
				return Skills.getActualLevel(Skills.SKILLS.RANGED);
			case Magic:
				return Skills.getActualLevel(Skills.SKILLS.MAGIC);
			case Hitpoints:
				return Skills.getActualLevel(Skills.SKILLS.HITPOINTS);
			case Slayer:
				return Skills.getActualLevel(Skills.SKILLS.SLAYER);
			}
			return 0;
		}

		public int percentToLevel() {
			switch(this)
			{
			case Attack:
				return Skills.getPercentToNextLevel(Skills.SKILLS.ATTACK);
			case Strength:
				return Skills.getPercentToNextLevel(Skills.SKILLS.STRENGTH);
			case Defence:
				return Skills.getPercentToNextLevel(Skills.SKILLS.DEFENCE);
			case Range: 
				return Skills.getPercentToNextLevel(Skills.SKILLS.RANGED);
			case Magic:
				return Skills.getPercentToNextLevel(Skills.SKILLS.MAGIC);
			case Hitpoints:
				return Skills.getPercentToNextLevel(Skills.SKILLS.HITPOINTS);
			case Slayer:
				return Skills.getPercentToNextLevel(Skills.SKILLS.SLAYER);
			}
			return 0;
		}

		public int xpToNextLevel() {
			switch(this)
			{
			case Attack:
				return Skills.getXPToNextLevel(Skills.SKILLS.ATTACK);
			case Strength:
				return Skills.getXPToNextLevel(Skills.SKILLS.STRENGTH);
			case Defence:
				return Skills.getXPToNextLevel(Skills.SKILLS.DEFENCE);
			case Range: 
				return Skills.getXPToNextLevel(Skills.SKILLS.RANGED);
			case Magic:
				return Skills.getXPToNextLevel(Skills.SKILLS.MAGIC);
			case Hitpoints:
				return Skills.getXPToNextLevel(Skills.SKILLS.HITPOINTS);
			case Slayer:
				return Skills.getXPToNextLevel(Skills.SKILLS.SLAYER);
			}
			return 0;
		}

		public int getLevelGained() {
			switch (this) {
			case Attack:
				return getLevel() - sAttack[1];
			case Strength:
				return getLevel() - sStrength[1];
			case Defence:
				return getLevel() - sDefence[1];
			case Range:
				return getLevel() - sRange[1];
			case Magic:
				return getLevel() - sMagic[1];
			case Hitpoints:
				return getLevel() - sHitpoints[1];
			case Slayer:
				return getLevel() - sSlayer[1];
			}
			return 0;
		}

		public int getXpGained() {
			switch (this) {
			case Attack:
				return getXp() - sAttack[0];
			case Strength:
				return getXp() - sStrength[0];
			case Defence:
				return getXp() - sDefence[0];
			case Range:
				return getXp() - sRange[0];
			case Magic:
				return getXp() - sMagic[0];
			case Hitpoints:
				return getXp() - sHitpoints[0];
			case Slayer:
				return getXp() - sSlayer[0];
			}
			return 0;
		}

		public int getXpPerHour(long runtime) {
			return (int) ((3600000.0 / runtime) * getXpGained());
		}

		public long TimeToLevel(long runtime) {
			long timeTillLevel = (long) ((xpToNextLevel() * 3600000.0) / getXpPerHour(runtime));

			return timeTillLevel;
		}

		public String toString(long runtime) {
			return (toString() + " | " + getLevel() + "(" + getLevelGained()
					+ ") | " + getXpGained() + " XP | " + getXpPerHour(runtime)
					+ "XP/HR | TTL: " + formatTime(TimeToLevel(runtime)));
		}
	}

	public static void Init() {
		try {
			sAttack[0] = Skill.Attack.getXp();
			sAttack[1] = Skill.Attack.getLevel();

			sStrength[0] = Skill.Strength.getXp();
			sStrength[1] = Skill.Strength.getLevel();

			sDefence[0] = Skill.Defence.getXp();
			sDefence[1] = Skill.Defence.getLevel();

			sRange[0] = Skill.Range.getXp();
			sRange[1] = Skill.Range.getLevel();

			sMagic[0] = Skill.Magic.getXp();
			sMagic[1] = Skill.Magic.getLevel();

			sHitpoints[0] = Skill.Hitpoints.getXp();
			sHitpoints[1] = Skill.Hitpoints.getLevel();

			sSlayer[0] = Skill.Slayer.getXp();
			sSlayer[1] = Skill.Slayer.getLevel();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String formatTime(long runTime) {
		long seconds = 0;
		long minutes = 0;
		long hours = 0;
		seconds = runTime / 1000;
		if (seconds >= 60) {
			minutes = seconds / 60;
			seconds -= (minutes * 60);
		}
		if (minutes >= 60) {
			hours = minutes / 60;
			minutes -= (hours * 60);
		}
		return (hours + ":" + minutes + ":" + seconds);
	}

	public static Color getCapeColor(int alpha, Skill skill) {
		switch (skill) {
		case Attack:
			return new Color(138, 17, 17, alpha);
		case Strength:
			return new Color(29, 150, 67, alpha);
		case Defence:
			return new Color(70, 74, 210, alpha);
		case Range:
			return new Color(87, 224, 74, alpha);
		case Magic:
			return new Color(200, 200, 200, alpha);
		case Hitpoints:
			return new Color(200, 200, 200, alpha);
		case Slayer:
			return new Color(69, 69, 69, alpha);
		}

		return null;
	}

	public static Color getTrimColor(Skill skill) {
		switch (skill) {
		case Attack:
			return new Color(217, 195, 56);
		case Strength:
			return new Color(138, 17, 17);
		case Defence:
			return new Color(232, 232, 232);
		case Range:
			return new Color(0, 0, 0);
		case Magic:
			return new Color(92, 94, 214);
		case Hitpoints:
			return new Color(138, 17, 17);
		case Slayer:
			return new Color(110, 0, 0);
		}
		return null;
	}

}
