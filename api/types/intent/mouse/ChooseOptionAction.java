package scripts.ScriptMaker.api.types.intent.mouse;

import java.io.Serializable;

import org.tribot.api2007.ChooseOption;

import scripts.ScriptMaker.api.types.main.Action;

public class ChooseOptionAction extends Action implements Serializable
{

	private static final long serialVersionUID = 7521170651407207980L;
	private String option;
	
	public ChooseOptionAction(String option)
	{
		this.option = option;
	}

	@Override
	public boolean run()
	{
		if(ChooseOption.isOpen())
		{
			if(ChooseOption.select(option));
		}
		return false;
	}
	
	@Override
	public String toString()
	{
		return "choose option " + option;
	}

}
