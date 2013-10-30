package scripts.ScriptMaker.api.types.intent.chooseoptionmenu;

import java.io.Serializable;

import org.tribot.api2007.ChooseOption;

import scripts.ScriptMaker.api.types.main.Action;

public class ChooseOptionFromMenuAction extends Action implements Serializable
{

	private static final long serialVersionUID = 2449229557686917802L;
	private String option;

	public ChooseOptionFromMenuAction(String option)
	{
		this.option = option;
	}

	@Override
	public boolean run()
	{
		if (!ChooseOption.isOpen())
			return false;
		return ChooseOption.select(option);

	}
	
	@Override
	public String toString()
	{
		return "choose option "+option;
	}

}
