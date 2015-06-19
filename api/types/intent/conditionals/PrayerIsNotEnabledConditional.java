package scripts.ScriptMaker.api.types.intent.conditionals;

import org.tribot.api2007.Prayer;
import org.tribot.api2007.Prayer.PRAYERS;

import scripts.ScriptMaker.api.types.main.Conditional;

public class PrayerIsNotEnabledConditional extends Conditional {

	private static final long serialVersionUID = 7639645346272086456L;

	private PRAYERS prayer;

	public PrayerIsNotEnabledConditional(PRAYERS prayer) {
		this.prayer = prayer;
	}

	@Override
	public boolean run() {
		return !Prayer.isPrayerEnabled(prayer);
	}

	@Override
	public String toString() {
		return "if " + prayer + " is not enabled";
	}

}
