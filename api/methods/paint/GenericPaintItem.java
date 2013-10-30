package scripts.ScriptMaker.api.methods.paint;

import java.awt.Color;
import java.io.Serializable;

import scripts.ScriptMaker.api.types.main.PaintItem;

public class GenericPaintItem extends PaintItem implements Serializable
{

    private static final long serialVersionUID = -8137040480322441140L;
    private int count;

    public GenericPaintItem(Color border, Color inside, String name,
	    String displayText)
    {
	super(border, inside, name, displayText);
    }

    @Override
    public void updateData()
    {
	super.setFull(super.getDefaultFull() + ++count);
    }

    @Override
    public String toString()
    {
	return "Custom Paint Type";
    }

    @Override
    public void init()
    {
	super.setFull(super.getDefaultFull() + count);
    }

    @Override
    public void clearAll()
    {
	count = 0;
    }

    @Override
    public String[] values()
    {
	return new String[] {super.getDefaultFull() + count};
    }

}
