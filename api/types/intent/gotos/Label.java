package scripts.ScriptMaker.api.types.intent.gotos;

import java.io.Serializable;

import scripts.ScriptMaker.api.types.main.Action;

public class Label extends Action implements Serializable
{

	private static final long serialVersionUID = -2829956556393929734L;
	private String name;

	public Label(String name)
	{
		this.name = name.toUpperCase();
	}
	
	
	@Override
	public String toString()
	{
		return name;
	}


	@Override
	public boolean run()
	{
		// TODO Auto-generated method stub
		return false;
	}
	
}
