package scripts.ScriptMaker.api.methods;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.tribot.api.General;
import org.tribot.util.Util;

import scripts.ScriptMaker.GUI.handler.GUIHandler;
import scripts.ScriptMaker.api.methods.paint.GenericPaintItem;
import scripts.ScriptMaker.api.methods.paint.PaintHandler;
import scripts.ScriptMaker.api.types.block.handler.BlockHandler;
import scripts.ScriptMaker.api.types.main.ScriptSaveFile;

public class FileIO
{

    private static FileOutputStream fOut = null;
    private static ObjectOutputStream oos = null;
    private static FileInputStream fis = null;
    private static ObjectInputStream ois = null;
    private static List<String> results = new ArrayList<String>();
    private static String name = null;

    public static void save()
    {
	if (!PaintHandler.isCreatorAdded())
	{
	    PaintHandler.addItem(
		    "CREATOR",
		    new GenericPaintItem(Color.BLACK, Color.WHITE, "CREATOR",
			    "Logic Script Creator: "
				    + General.getTRiBotUsername()));
	}
	String name = JOptionPane.showInputDialog("Enter name for the script");
	try
	{
	    boolean exist = (new File(Util.getAppDataDirectory(),
		    "Logic Script Maker").exists());
	    if (!exist)
	    {
		new File(Util.getAppDataDirectory(), "Logic Script Maker")
			.mkdirs();
	    }
	    fOut = new FileOutputStream(new File(Util.getAppDataDirectory(),
		    "Logic Script Maker" + File.separator + name + ".script"));
	    oos = new ObjectOutputStream(fOut);
	    oos.writeObject(new ScriptSaveFile(BlockHandler.getMap(),
		    PaintHandler.getMap(), name));
	} catch (Exception d)
	{
	    d.printStackTrace();
	}
	try
	{
	    oos.flush();
	} catch (IOException e)
	{
	    e.printStackTrace();
	}
	try
	{
	    oos.close();
	} catch (IOException e)
	{
	    e.printStackTrace();
	}
	try
	{
	    fOut.flush();
	} catch (IOException e)
	{
	    e.printStackTrace();
	}
    }

    public static void load()
    {
	try
	{
	    results.clear();
	    File[] files = new File(Util.getAppDataDirectory(),
		    "Logic Script Maker").listFiles();
	    for (File file : files)
	    {
		if (file.isFile() && file.getName().endsWith(".script"))
		{
		    results.add(file.getName().replace(".script", ""));
		}
	    }

	    String[] fileNames = results.toArray(new String[results.size()]);
	    if (fileNames.length > 0)
	    {
		name = (String) JOptionPane.showInputDialog(null,
			"Which script would you like to load?",
			"File Selection", JOptionPane.QUESTION_MESSAGE, null,
			fileNames, fileNames[0]);
		fis = new FileInputStream(new File(Util.getAppDataDirectory(),
			"Logic Script Maker" + File.separator + name
				+ ".script"));
		ois = new ObjectInputStream(fis);
		ScriptSaveFile file = (ScriptSaveFile) ois.readObject();
		PaintHandler.setMap(PaintHandler.resetAllPaintItems(file
			.getPaint()));
		BlockHandler.setMap(file.getBlocks());
	    } else
	    {
		JOptionPane.showMessageDialog(null,
			"You do not have scripts saved");
	    }

	} catch (Exception e)
	{
	    e.printStackTrace();
	}
	if (ois != null && fis != null)
	{
	    try
	    {
		ois.close();
	    } catch (IOException e)
	    {
		e.printStackTrace();
	    }
	    try
	    {
		fis.close();
	    } catch (IOException e)
	    {
		e.printStackTrace();
	    }
	}
	GUIHandler.fillJListWithIntents();

    }

}
