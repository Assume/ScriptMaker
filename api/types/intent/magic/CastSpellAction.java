package scripts.ScriptMaker.api.types.intent.magic;

import java.io.Serializable;

import scripts.ScriptMaker.api.types.enums.Magic;
import scripts.ScriptMaker.api.types.main.Action;

public class CastSpellAction extends Action implements Serializable
{
	
	private static final long serialVersionUID = -3898420033003141611L;

	private Magic.Spell spell;
	
	public CastSpellAction(Magic.Spell spell)
	{
		this.spell = spell;
	}
	
	@Override
	public boolean run()
	{
		Magic.teleport(spell);
		return true;
	}
	
	@Override
	public String toString()
	{
		return "cast spell "+spell;
	}

}
