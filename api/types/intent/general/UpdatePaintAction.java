package scripts.ScriptMaker.api.types.intent.general;

import java.io.Serializable;

import scripts.ScriptMaker.api.methods.paint.PaintHandler;
import scripts.ScriptMaker.api.types.main.Action;

public class UpdatePaintAction extends Action implements Serializable
{

	private static final long serialVersionUID = 3017645304415504712L;
	private String name;
	
	public UpdatePaintAction(String name)
	{
		this.name = name;
	}
	
	@Override
	public boolean run()
	{
		PaintHandler.updateItem(name, null);
		return true;
	}
	
	@Override
	public String toString()
	{
		return "Update paint element "+name;
	}

}
