package scripts.ScriptMaker.api.methods.paint;

import java.awt.Color;

import scripts.ScriptMaker.api.types.main.PaintItem;

public class GenericPaintItemString extends PaintItem
{
	private static final long serialVersionUID = -8137040480322441140L;

	private String text;
	private String defaultText;

	public GenericPaintItemString(Color border, Color inside, String name,
			String displayText, String defaultText)
	{
		super(border, inside, name, displayText);
		this.defaultText = defaultText;
	}

	@Override
	public void updateData()
	{
		
	}

	public void updateData(String text)
	{
		super.setFull(super.getDefaultFull() + text);
	}
	
	@Override
	public String toString()
	{
		return "Custom Paint Type Text";
	}

	@Override
	public void init()
	{
		super.setFull(super.getDefaultFull() + defaultText);
	}

	@Override
	public void clearAll()
	{
		this.text = defaultText;
	}

	@Override
	public String[] values()
	{
		return new String[] { super.getDefaultFull() + text };
	}
}
