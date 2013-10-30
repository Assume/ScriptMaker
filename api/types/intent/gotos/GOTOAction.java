package scripts.ScriptMaker.api.types.intent.gotos;

import java.io.Serializable;

import scripts.ScriptMaker.api.types.main.Action;

public class GOTOAction extends Action implements Serializable
{

	private static final long serialVersionUID = -7046821599278740638L;
	private String l;

	public GOTOAction(String l)
	{
		this.l = l.toUpperCase();
	}

	@Override
	public boolean run()
	{
		return false;
	}

	public String getLabel()
	{
		return l;
	}

	public void setKey(String l)
	{
		this.l = l.toUpperCase();
	}
	
	@Override
	public String toString()
	{
		return "GOTO "+l;
	}
	

}
