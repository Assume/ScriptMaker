package scripts.ScriptMaker.api.types.intent.general;

import org.tribot.api.input.Keyboard;

import scripts.ScriptMaker.api.types.main.Action;

public class TalkAction extends Action
{

	private static final long serialVersionUID = -3888263562802211559L;
	private String text;
	
	public TalkAction(String text)
	{
		this.text = text;
	}

	@Override
	public boolean run()
	{
		Keyboard.typeSend(text);
		return true;
	}

	public String getText()
	{
		return text;
	}

	public void setText(String text)
	{
		this.text = text;
	}

	@Override
	public String toString()
	{
		return "type and send " + text;
	}
	
}
