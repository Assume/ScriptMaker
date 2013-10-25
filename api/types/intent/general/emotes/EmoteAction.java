package scripts.ScriptMaker.api.types.intent.general.emotes;

import scripts.ScriptMaker.api.types.enums.EmoteHandler;
import scripts.ScriptMaker.api.types.main.Action;

public class EmoteAction extends Action
{
	
	private static final long serialVersionUID = -8315666462996285445L;
	private EmoteHandler.Emote e;
	
	public EmoteAction(EmoteHandler.Emote e)
	{
	
		this.e = e;
	}

	@Override
	public boolean run()
	{
		EmoteHandler.doEmote(e);
		return true;
	}
	
	@Override
	public String toString()
	{
		return "do emote "+ e.toString();
	}

}
