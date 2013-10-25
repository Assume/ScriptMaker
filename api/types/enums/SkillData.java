package scripts.ScriptMaker.api.types.enums;

import java.awt.Color;

import org.tribot.api2007.Skills;

import scripts.ScriptMaker.main.vars;



public class SkillData {
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
			int a = vars.savedSlayer + vars.savedAttack + vars.savedDefence
					+ vars.savedHitpoints + vars.savedMagic + vars.savedRange
					+ vars.savedStrength;
			if (a == 0) {
				switch (this) {
				case Attack:
					vars.savedAttack = getXp() - vars.sAttack[0];
					return getXp() - vars.sAttack[0];
				case Strength:
					vars.savedStrength = getXp() - vars.sStrength[0];
					return getXp() - vars.sStrength[0];
				case Defence:
					vars.savedDefence = getXp() - vars.sDefence[0];
					return getXp() - vars.sDefence[0];
				case Range:
					vars.savedRange = getXp() - vars.sRange[0];
					return getXp() - vars.sRange[0];
				case Magic:
					vars.savedMagic = getXp() - vars.sMagic[0];
					return getXp() - vars.sMagic[0];
				case Hitpoints:
					vars.savedHitpoints = getXp() - vars.sHitpoints[0];
					return getXp() - vars.sHitpoints[0];
				case Slayer:
					vars.savedSlayer = getXp() - vars.sSlayer[0];
					return getXp() - vars.sSlayer[0];
				}
				return 0;
			} else {
				double b;
				switch (this) {
				case Attack:
					b = getXp() - vars.sAttack[0] - vars.savedAttack;
					vars.savedAttack = getXp() - vars.sAttack[0];
					return b;
				case Strength:
					b = getXp() - vars.sStrength[0] - vars.savedStrength;
					vars.savedStrength = getXp() - vars.sStrength[0];
					return b;
				case Defence:
					b = getXp() - vars.sDefence[0] - vars.savedDefence;
					vars.savedDefence = getXp() - vars.sDefence[0];
					return b;
				case Range:
					b = getXp() - vars.sRange[0] - vars.savedRange;
					vars.savedRange = getXp() - vars.sRange[0];
					return b;
				case Magic:
					b = getXp() - vars.sMagic[0] - vars.savedMagic;
					vars.savedMagic = getXp() - vars.sMagic[0];
					return b;
				case Hitpoints:
					b = getXp() - vars.sHitpoints[0] - vars.savedHitpoints;
					vars.savedHitpoints = getXp() - vars.sHitpoints[0];
					return b;
				case Slayer:
					b = getXp() - vars.sSlayer[0] - vars.savedSlayer;
					vars.savedSlayer = getXp() - vars.sSlayer[0];
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
				return getLevel() - vars.sAttack[1];
			case Strength:
				return getLevel() - vars.sStrength[1];
			case Defence:
				return getLevel() - vars.sDefence[1];
			case Range:
				return getLevel() - vars.sRange[1];
			case Magic:
				return getLevel() - vars.sMagic[1];
			case Hitpoints:
				return getLevel() - vars.sHitpoints[1];
			case Slayer:
				return getLevel() - vars.sSlayer[1];
			}
			return 0;
		}

		public int getXpGained() {
			switch (this) {
			case Attack:
				return getXp() - vars.sAttack[0];
			case Strength:
				return getXp() - vars.sStrength[0];
			case Defence:
				return getXp() - vars.sDefence[0];
			case Range:
				return getXp() - vars.sRange[0];
			case Magic:
				return getXp() - vars.sMagic[0];
			case Hitpoints:
				return getXp() - vars.sHitpoints[0];
			case Slayer:
				return getXp() - vars.sSlayer[0];
			}
			return 0;
		}

		public int getXpPerHour(long runtime) {
			return (int) ((3600000.0 / (double) runtime) * getXpGained());
		}

		public long TimeToLevel(long runtime) {
			long timeTillLevel = (long) (((double) xpToNextLevel() * 3600000.0) / (double) getXpPerHour(runtime));

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
			vars.sAttack[0] = Skill.Attack.getXp();
			vars.sAttack[1] = Skill.Attack.getLevel();

			vars.sStrength[0] = Skill.Strength.getXp();
			vars.sStrength[1] = Skill.Strength.getLevel();

			vars.sDefence[0] = Skill.Defence.getXp();
			vars.sDefence[1] = Skill.Defence.getLevel();

			vars.sRange[0] = Skill.Range.getXp();
			vars.sRange[1] = Skill.Range.getLevel();

			vars.sMagic[0] = Skill.Magic.getXp();
			vars.sMagic[1] = Skill.Magic.getLevel();

			vars.sHitpoints[0] = Skill.Hitpoints.getXp();
			vars.sHitpoints[1] = Skill.Hitpoints.getLevel();

			vars.sSlayer[0] = Skill.Slayer.getXp();
			vars.sSlayer[1] = Skill.Slayer.getLevel();

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
