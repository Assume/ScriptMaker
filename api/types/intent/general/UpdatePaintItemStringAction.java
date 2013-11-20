package scripts.ScriptMaker.api.types.intent.general;

import scripts.ScriptMaker.api.methods.paint.PaintHandler;
import scripts.ScriptMaker.api.types.main.Action;

public class UpdatePaintItemStringAction extends Action
{

	private static final long serialVersionUID = 8450805544176808722L;

	private String name;
	private String text;

	public UpdatePaintItemStringAction(String name, String text)
	{
		this.name = name;
		this.text = text;
	}

	@Override
	public boolean run()
	{
		PaintHandler.updateItem(name, text);
		return true;
	}

	@Override
	public String toString()
	{
		return "Update paint element " + name + " with the text: " + text;
	}
}
