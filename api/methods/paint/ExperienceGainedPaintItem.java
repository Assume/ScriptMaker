package scripts.ScriptMaker.api.methods.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import org.tribot.api2007.Skills;

import scripts.ScriptMaker.api.methods.DefaultMethods;
import scripts.ScriptMaker.api.types.main.PaintItem;
import scripts.ScriptMaker.main.vars;

public class ExperienceGainedPaintItem extends PaintItem
{

    private static final long serialVersionUID = -9156180490877174777L;
    private Skills.SKILLS sk;
    private int exp;
    private int startingXp;
    private int levelsGained;
    private int startingLevel;

    public ExperienceGainedPaintItem(Color border, Color inside, String name,
	    String displayText, Skills.SKILLS sk)
    {
	super(Color.BLACK, Color.DARK_GRAY, name, displayText);
	this.sk = sk;
	this.startingLevel = sk.getActualLevel();
	this.levelsGained = 0;
	this.startingXp = Skills.getXP(sk);
    }

    @Override
    public void display(Point p, Graphics g)
    {
	String l = toString(vars.runtime);
	int length = DefaultMethods.stringLength(l, g) + 10;
	this.exp = Skills.getXP(sk) - startingXp;
	if (startingLevel < sk.getActualLevel())
	{
	    this.levelsGained++;
	    startingLevel = sk.getActualLevel();
	}
	g.setColor(super.getBorder());
	g.fillRect((int) p.getX(), (int) p.getY(), length, 13);
	// Progress
	g.setColor(super.getInside());
	g.fillRect((int) p.getX(), (int) p.getY(),
		Skills.getPercentToNextLevel(sk) * length / 100, 13);

	// Trim
	g.setColor(Color.WHITE);
	g.drawRect((int) p.getX(), (int) p.getY(), length, 13);

	g.setColor(Color.WHITE);
	// Text
	g.drawString(toString(vars.runtime), 11, (int) p.getY() + 11);
    }

    public String toString(long runtime)
    {
	return (sk.name() + " | " + sk.getActualLevel() + "("
		+ this.levelsGained + ") | " + this.exp + " XP | "
		+ getXpPerHour(runtime) + "XP/HR | TTL: " + formatTime(timeToLevel(runtime)));
    }

    public long timeToLevel(long runtime)
    {
	long timeTillLevel = (long) (((double) Skills.getXPToNextLevel(sk) * 3600000.0) / (double) getXpPerHour(runtime));

	return timeTillLevel;
    }

    public int getXpPerHour(long runtime)
    {
	return (int) ((3600000.0 / (double) runtime) * this.exp);
    }

    public static String formatTime(long runTime)
    {
	long seconds = 0;
	long minutes = 0;
	long hours = 0;
	seconds = runTime / 1000;
	if (seconds >= 60)
	{
	    minutes = seconds / 60;
	    seconds -= (minutes * 60);
	}
	if (minutes >= 60)
	{
	    hours = minutes / 60;
	    minutes -= (hours * 60);
	}
	return (hours + ":" + minutes + ":" + seconds);
    }

    @Override
    public void updateData()
    {

    }

    @Override
    public String toString()
    {
	return "Experience gained tracker";
    }

    @Override
    public void init()
    {
	this.startingLevel = sk.getActualLevel();
	this.levelsGained = 0;
	this.startingXp = Skills.getXP(sk);
    }

    @Override
    public void clearAll()
    {
	this.startingLevel = 0;
	this.levelsGained = 0;
	this.startingXp = 0;
    }

    @Override
    public String[] values()
    {
	return new String[] { "Starting "+startingLevel, "Gained "+levelsGained, "Starting exp "+startingXp};
    }

}
