package scripts.ScriptMaker.api.methods.paint.generic;

import java.awt.Color;
import java.io.Serializable;

import scripts.ScriptMaker.api.types.main.PaintItem;

public class XPGainedGeneric extends PaintItem implements Serializable
{

    private static final long serialVersionUID = -3693653543754552265L;

    public XPGainedGeneric(Color border, Color inside, String name,
	    String displayText)
    {
	super(border, inside, name, displayText);

    }

    @Override
    public void updateData()
    {
	// TODO Auto-generated method stub

    }

    @Override
    public String toString()
    {
	return "Experience gained tracker";
    }

    @Override
    public void init()
    {
	// TODO Auto-generated method stub

    }

    @Override
    public void clearAll()
    {
	// TODO Auto-generated method stub

    }

    @Override
    public String[] values()
    {
	// TODO Auto-generated method stub
	return null;
    }

}
