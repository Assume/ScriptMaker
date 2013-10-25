package scripts.ScriptMaker.api.types.enums;

import org.tribot.api.General;
import org.tribot.api.input.Mouse;
import org.tribot.api2007.GameTab;
import org.tribot.api2007.GameTab.TABS;
import org.tribot.api2007.Interfaces;

public class EmoteHandler
{

	public static enum Emote
	{
		YES(38), NO(39), BOW(40), ANGRY(41), THINK(42), WAVE(43), SHRUG(44), CHEER(
						45), BECKON(46), LAUGH(47), JUMP_FOR_JOY(48), YAWN(49), DANCE(
						50), JIG(51), SPIN(52), HEADBANG(53), CRY(54), BLOW_KISS(
						55), PANIC(56), RASPBERRY(57);

		private int emote;
		Emote(int emote)
		{
			this.emote = emote;
		}
		
		private int getEmote()
		{
			return emote;
		}
	}

	public static final int PARENT_ID = 464;

	public static void doEmote(Emote emote)
	{
		int d = emote.getEmote();
		if (GameTab.getOpen().equals(TABS.EMOTES))
		{
			Mouse.click(730, 235, 1);
			clickWidget(d);
			General.sleep(100);
		}
		else
		{
			GameTab.open(TABS.EMOTES);
			doEmote(emote);
		}
	}

	private static void clickWidget(int l)
	{
		Mouse.click(730, 235, 1);
		General.sleep(100);
		if (Interfaces.get(PARENT_ID, l) != null)
		{
			Interfaces.get(PARENT_ID, l).click("");
			General.sleep(3000);
		}

	}
	
}
