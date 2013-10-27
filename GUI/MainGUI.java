package scripts.ScriptMaker.GUI;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.tribot.api.General;

import scripts.ScriptMaker.api.methods.FileIO;
import scripts.ScriptMaker.api.methods.paint.GenericPaintItem;
import scripts.ScriptMaker.api.methods.paint.PaintHandler;
import scripts.ScriptMaker.api.types.block.BlockExecutor;
import scripts.ScriptMaker.api.types.block.handler.BlockHandler;
import scripts.ScriptMaker.api.types.main.Intent;
import scripts.ScriptMaker.main.vars;

public class MainGUI extends JFrame
{

    private static final long serialVersionUID = -1379705500204890724L;
    private JPanel contentPane;

    public MainGUI()
    {
	setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	setBounds(100, 100, 164, 426);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);

	this.addWindowListener(new java.awt.event.WindowAdapter()
	{
	    @Override
	    public void windowClosing(java.awt.event.WindowEvent windowEvent)
	    {
		if (JOptionPane
			.showConfirmDialog(
				null,
				"Are you sure to close this window? This will end the script.",
				"Really Closing?", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION)
		{
		    if (vars.thread != null)
		    {
			vars.stop = true;
		    }
		    General.println("You closed the GUI so the script stopped!");
		    setVisible(false);
		    dispose();
		    throw new RuntimeException(
			    "You closed the GUI so the script stopped!");
		}
	    }
	});

	JButton btnStartScript = new JButton("Start Script");
	btnStartScript.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent e)
	    {
		if (!vars.hasHitStart)
		{
		    vars.startTime = System.currentTimeMillis();
		}
		vars.hasHitStart = true;
		if (!PaintHandler.isCreatorAdded())
		{
		    PaintHandler.addItem("CREATOR",
			    new GenericPaintItem(Color.BLACK, Color.WHITE,
				    "CREATOR", "Logic Script Creator: "
					    + General.getTRiBotUsername()));
		}
		PaintHandler.initAll();
		if (BlockHandler.isMainAdded())
		{
		    vars.stop = false;
		    vars.thread = new Thread()
		    {
			@Override
			public void run()
			{
			    BlockExecutor.execute(BlockHandler.getMain());
			}
		    };
		    vars.thread.start();
		} else
		{
		    JOptionPane
			    .showMessageDialog(null,
				    "You must setup your main block before running the script");
		}

	    }
	});
	btnStartScript.setBounds(11, 11, 132, 23);
	contentPane.add(btnStartScript);

	JButton btnStopScript = new JButton("Stop Script");
	btnStopScript.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent e)
	    {
		if (vars.thread != null)
		{
		    vars.stop = true;
		    vars.thread.interrupt();
		}
	    }
	});
	btnStopScript.setBounds(11, 43, 132, 23);
	contentPane.add(btnStopScript);

	JButton btnShowAllBlocks = new JButton("Show all Blocks");
	btnShowAllBlocks.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent e)
	    {
		new ShowAllBlocksGUI().setVisible(true);
	    }
	});
	btnShowAllBlocks.setBounds(11, 77, 132, 23);
	contentPane.add(btnShowAllBlocks);

	JButton btnCreateNewBlock = new JButton("Create new Block");
	btnCreateNewBlock.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent e)
	    {
		if (vars.builderIsOpen)
		{
		    JOptionPane.showMessageDialog(null,
			    "You can only build one Block at a time. You are currently building block: "
				    + BlockHandler.getCurrentBlockName());
		    return;
		}
		String name = JOptionPane
			.showInputDialog("Enter a name for the block. This should relate to what it will do");

		if (name != null)
		{
		    if (BlockHandler.getBlock(name) != null)
		    {
			JOptionPane
				.showMessageDialog(
					null,
					"You already added a block named "
						+ name
						+ " please choose edit block or name this block something else");
			return;
		    }
		    BlockHandler.setCurrentBlockName(name);
		    vars.builderIsOpen = true;
		    vars.isMain = false;
		    new BlockBuilderGUI().setVisible(true);
		}
	    }
	});
	btnCreateNewBlock.setBounds(11, 108, 132, 23);
	contentPane.add(btnCreateNewBlock);

	JButton btnMainBlock = new JButton("Setup Main Block");
	btnMainBlock.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent e)
	    {
		if (BlockHandler.isMainAdded())
		{
		    JOptionPane.showMessageDialog(null,
			    "Please choose edit main instead");
		    return;
		}
		if (vars.builderIsOpen)
		{
		    JOptionPane.showMessageDialog(null,
			    "You can only build one Block at a time. You are currently building block: "
				    + BlockHandler.getCurrentBlockName());
		    return;
		}
		vars.builderIsOpen = true;
		vars.isMain = true;
		BlockHandler.setCurrentBlockName("main");
		BlockHandler.setIsMain();
		new BlockBuilderGUI().setVisible(true);
	    }
	});
	btnMainBlock.setBounds(11, 176, 132, 23);
	contentPane.add(btnMainBlock);

	JButton btnSetupPaint = new JButton("Setup Paint");
	btnSetupPaint.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent e)
	    {
		new PaintSetupGUI().setVisible(true);
	    }
	});
	btnSetupPaint.setBounds(9, 244, 133, 23);
	contentPane.add(btnSetupPaint);

	JButton btnSave = new JButton("Save");
	btnSave.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent e)
	    {
		FileIO.save();
	    }
	});
	btnSave.setBounds(11, 278, 133, 23);
	contentPane.add(btnSave);

	JButton btnLoad = new JButton("Load");
	btnLoad.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent e)
	    {
		FileIO.load();
		PaintHandler.resetAllPaintItems();
	    }
	});
	btnLoad.setBounds(11, 312, 133, 23);
	contentPane.add(btnLoad);

	JButton btnEditButton = new JButton("Edit Block");
	btnEditButton.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent e)
	    {
		if (vars.builderIsOpen)
		{
		    JOptionPane.showMessageDialog(null,
			    "You can only build one Block at a time. You are currently building block: "
				    + BlockHandler.getCurrentBlockName());
		    return;
		}
		String[] blocks = BlockHandler.getAllBlockNames();
		if (blocks.length == 0)
		{
		    JOptionPane.showMessageDialog(null,
			    "You have not made any blocks.");
		    return;
		}
		if (blocks.length == 1 && BlockHandler.isMainAdded())
		{
		    JOptionPane.showMessageDialog(null,
			    "You have not made any blocks.");
		    return;
		}
		JComboBox<String> box = new JComboBox<String>(
			new DefaultComboBoxModel<String>(blocks));
		if (BlockHandler.isMainAdded())
		    box.removeItem("main");
		JOptionPane.showMessageDialog(null, box,
			"Choose a Block to edit", JOptionPane.QUESTION_MESSAGE);
		String name = (String) box.getSelectedItem();
		vars.builderIsOpen = true;
		vars.isMain = false;
		try
		{
		    for (Intent t : BlockHandler.getBlock(name).getIntets())
		    {
			vars.currentIntentList.add(t);
		    }
		} catch (Exception d)
		{
		    d.printStackTrace();
		}

		BlockHandler.setCurrentBlockName(name);
		new BlockBuilderGUI().setVisible(true);
	    }
	});
	btnEditButton.setBounds(11, 142, 130, 23);
	contentPane.add(btnEditButton);

	JButton btnEditMain = new JButton("Edit Main Block");
	btnEditMain.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent e)
	    {
		if (vars.builderIsOpen)
		{
		    JOptionPane.showMessageDialog(null,
			    "You can only build one Block at a time. You are currently building block: "
				    + BlockHandler.getCurrentBlockName());
		    return;
		}
		if (!BlockHandler.isMainAdded())
		{
		    JOptionPane.showMessageDialog(null,
			    "Please click setup main block first!");
		    return;
		}
		{
		    for (Intent t : BlockHandler.getBlock("main").getIntets())
		    {
			vars.currentIntentList.add(t);
		    }
		}
		vars.builderIsOpen = true;
		vars.isMain = true;
		BlockHandler.setCurrentBlockName("main");
		BlockHandler.setIsMain();
		new BlockBuilderGUI().setVisible(true);
	    }
	});
	btnEditMain.setBounds(11, 210, 131, 23);
	contentPane.add(btnEditMain);

	JButton btnNewButton = new JButton("Get Scripts!");
	btnNewButton.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent arg0)
	    {
		if (Desktop.isDesktopSupported())
		{
		    try
		    {
			Desktop.getDesktop()
				.browse(new URI(
					"https://tribot.org/forums/index.php?/topic/22111-logic-pro-premade-scripts/"));
		    } catch (IOException | URISyntaxException e)
		    {
			e.printStackTrace();
		    }
		} else
		{
		    JOptionPane.showMessageDialog(null,
			    "Visit Assume's thread to get premade scripts!");
		}
	    }
	});
	btnNewButton.setBounds(11, 346, 133, 23);
	contentPane.add(btnNewButton);
    }
}
