package scripts.ScriptMaker.api.types.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.io.Serializable;

import scripts.ScriptMaker.api.methods.DefaultMethods;

public abstract class PaintItem implements Serializable
{

    private static final long serialVersionUID = -84780207021049517L;
    private Color border;
    private Color inside;
    private String name;
    private String displayText;
    private String full;

    public PaintItem(Color border, Color inside, String name, String displayText)
    {
	this.border = border;
	this.inside = inside;
	this.name = name;
	this.displayText = displayText;
	this.full = "";
    }

    public PaintItem()
    {

    }

    public abstract void updateData();

    public abstract String[] values();

    public abstract void clearAll();

    public abstract void init();

    public void display(Point p, Graphics g)
    {
	Graphics2D gd = (Graphics2D) g;
	int width = DefaultMethods.stringLength(this.full, gd) + 5;

	gd.setColor(this.getInside());
	gd.fillRect((int) p.getX(), (int) p.getY(), width, 15);

	gd.setColor(this.getBorder());
	gd.drawRect((int) p.getX(), (int) p.getY(), width, 15);

	gd.setColor(Color.BLACK);
	gd.drawString(this.full, (int) p.getX() + 2, (int) p.getY() + 12);
    }

    public String getDefaultFull()
    {
	return this.getDisplayText().trim() + " : ";
    }

    public void setFull(String full)
    {
	this.full = full;
    }

    public Color getBorder()
    {
	return border;
    }

    public void setBorder(Color border)
    {
	this.border = border;
    }

    public Color getInside()
    {
	return inside;
    }

    public void setInside(Color inside)
    {
	this.inside = inside;
    }

    public String getDisplayText()
    {
	return displayText;
    }

    public void setDisplayText(String displayText)
    {
	this.displayText = displayText;
    }

    public String getName()
    {
	return name;
    }

    public void setName(String name)
    {
	this.name = name;
    }

}
