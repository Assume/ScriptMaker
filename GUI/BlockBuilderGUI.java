package scripts.ScriptMaker.GUI;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import org.tribot.api2007.Skills.SKILLS;

import scripts.ScriptMaker.GUI.handler.GUIHandler;
import scripts.ScriptMaker.api.methods.paint.PaintHandler;
import scripts.ScriptMaker.api.types.block.Block;
import scripts.ScriptMaker.api.types.block.BlockCaller;
import scripts.ScriptMaker.api.types.block.handler.BlockHandler;
import scripts.ScriptMaker.api.types.enums.EmoteHandler;
import scripts.ScriptMaker.api.types.enums.Equipment;
import scripts.ScriptMaker.api.types.enums.Magic;
import scripts.ScriptMaker.api.types.intent.NPCChat.actions.ChooseNPCChatOptionAction;
import scripts.ScriptMaker.api.types.intent.NPCChat.actions.ClickToContinueAction;
import scripts.ScriptMaker.api.types.intent.NPCChat.conditionals.NPCChatIsOpenConditional;
import scripts.ScriptMaker.api.types.intent.NPCs.actions.ClickNPCAction;
import scripts.ScriptMaker.api.types.intent.NPCs.actions.TurnCameraToNPCAction;
import scripts.ScriptMaker.api.types.intent.NPCs.actions.WalkToNearestNPCAction;
import scripts.ScriptMaker.api.types.intent.NPCs.conditionals.DistanceToNearestNPCIsGreaterThanConditional;
import scripts.ScriptMaker.api.types.intent.NPCs.conditionals.DistanceToNearestNPCLessConditional;
import scripts.ScriptMaker.api.types.intent.NPCs.conditionals.NPCHPPercentIsLessThanConditional;
import scripts.ScriptMaker.api.types.intent.NPCs.conditionals.NPCIsInCombatConditional;
import scripts.ScriptMaker.api.types.intent.NPCs.conditionals.NPCIsNotInCombatConditional;
import scripts.ScriptMaker.api.types.intent.NPCs.conditionals.NPCIsNotOnScreenConditional;
import scripts.ScriptMaker.api.types.intent.NPCs.conditionals.NPCIsOnScreenConditional;
import scripts.ScriptMaker.api.types.intent.NPCs.conditionals.NPCIsValidConditional;
import scripts.ScriptMaker.api.types.intent.bank.CloseBankAction;
import scripts.ScriptMaker.api.types.intent.bank.DepositAllAction;
import scripts.ScriptMaker.api.types.intent.bank.DepositAllExceptAction;
import scripts.ScriptMaker.api.types.intent.bank.OpenBankAction;
import scripts.ScriptMaker.api.types.intent.bank.WaitUntilBankIsOpenAction;
import scripts.ScriptMaker.api.types.intent.bank.WithdrawItemAction;
import scripts.ScriptMaker.api.types.intent.chooseoptionmenu.ChooseOptionFromMenuAction;
import scripts.ScriptMaker.api.types.intent.conditionals.AnimationIsConditional;
import scripts.ScriptMaker.api.types.intent.conditionals.AreaContainsPlayerConditional;
import scripts.ScriptMaker.api.types.intent.conditionals.RunIsAboveConditional;
import scripts.ScriptMaker.api.types.intent.conditionals.RunIsBelowConditional;
import scripts.ScriptMaker.api.types.intent.conditionals.location.LocationIsOnScreenConditional;
import scripts.ScriptMaker.api.types.intent.conditionals.player.conditionals.PlayerIsInCombatConditional;
import scripts.ScriptMaker.api.types.intent.conditionals.player.conditionals.PlayerIsNotInCombatConditional;
import scripts.ScriptMaker.api.types.intent.conditionals.skills.HPIsLessThanConditional;
import scripts.ScriptMaker.api.types.intent.conditionals.skills.SkillIsLessThanConditional;
import scripts.ScriptMaker.api.types.intent.general.SleepAction;
import scripts.ScriptMaker.api.types.intent.general.TalkAction;
import scripts.ScriptMaker.api.types.intent.general.TurnRunOffAction;
import scripts.ScriptMaker.api.types.intent.general.TurnRunOnAction;
import scripts.ScriptMaker.api.types.intent.general.UnEquipItemAction;
import scripts.ScriptMaker.api.types.intent.general.UnequipAllAction;
import scripts.ScriptMaker.api.types.intent.general.UpdatePaintAction;
import scripts.ScriptMaker.api.types.intent.general.WaitUntilIdleAction;
import scripts.ScriptMaker.api.types.intent.general.WaitUntilInventoryContainsAction;
import scripts.ScriptMaker.api.types.intent.general.WaitUntilInventoryDoesntContainItem;
import scripts.ScriptMaker.api.types.intent.general.WaitUntilStoppedAction;
import scripts.ScriptMaker.api.types.intent.general.emotes.EmoteAction;
import scripts.ScriptMaker.api.types.intent.gotos.GOTOAction;
import scripts.ScriptMaker.api.types.intent.grounditems.ItemIsNotOnGroundConditional;
import scripts.ScriptMaker.api.types.intent.grounditems.ItemIsNotOnScreenConditional;
import scripts.ScriptMaker.api.types.intent.grounditems.ItemIsOnGroundConditional;
import scripts.ScriptMaker.api.types.intent.grounditems.ItemIsOnScreenConditional;
import scripts.ScriptMaker.api.types.intent.grounditems.actions.ClickGroundItemAction;
import scripts.ScriptMaker.api.types.intent.grounditems.actions.LootAllItemsAction;
import scripts.ScriptMaker.api.types.intent.inventory.InventoryContainsConditional;
import scripts.ScriptMaker.api.types.intent.inventory.InventoryDoesNotContainConditional;
import scripts.ScriptMaker.api.types.intent.inventory.InventoryIsEmptyConditional;
import scripts.ScriptMaker.api.types.intent.inventory.InventoryIsFullConditional;
import scripts.ScriptMaker.api.types.intent.inventory.InventoryIsNotFullConditional;
import scripts.ScriptMaker.api.types.intent.inventory.actions.CustomItemAction;
import scripts.ScriptMaker.api.types.intent.inventory.actions.DropAllAction;
import scripts.ScriptMaker.api.types.intent.inventory.actions.DropAllExceptAction;
import scripts.ScriptMaker.api.types.intent.magic.CastSpellAction;
import scripts.ScriptMaker.api.types.intent.mouse.LeftClickAction;
import scripts.ScriptMaker.api.types.intent.mouse.LeftClickPointAction;
import scripts.ScriptMaker.api.types.intent.mouse.MoveMouseAndChooseOptionAction;
import scripts.ScriptMaker.api.types.intent.mouse.RightClickAction;
import scripts.ScriptMaker.api.types.intent.mouse.SetMouseSpeedAction;
import scripts.ScriptMaker.api.types.intent.object.DistanceToObjectIsGreaterThanConditional;
import scripts.ScriptMaker.api.types.intent.object.ObjectIsNotOnScreenConditional;
import scripts.ScriptMaker.api.types.intent.object.ObjectIsOnScreenConditional;
import scripts.ScriptMaker.api.types.intent.object.ObjectIsValidConditional;
import scripts.ScriptMaker.api.types.intent.object.actions.ClickObjectAction;
import scripts.ScriptMaker.api.types.intent.object.actions.MoveMouseToObject;
import scripts.ScriptMaker.api.types.intent.object.actions.TurnToObjectAction;
import scripts.ScriptMaker.api.types.intent.object.actions.WalkToObjectAction;
import scripts.ScriptMaker.api.types.intent.walking.actions.WalkToTileAction;
import scripts.ScriptMaker.api.types.intent.walking.actions.WebWalkToBankAction;
import scripts.ScriptMaker.api.types.intent.walking.actions.WebWalkToTileAction;
import scripts.ScriptMaker.api.types.main.Intent;
import scripts.ScriptMaker.api.types.wrappers.CustomTile;
import scripts.ScriptMaker.main.vars;

public class BlockBuilderGUI extends JFrame
{

    private static final long serialVersionUID = 3221438968254241735L;
    public static final DefaultListModel<Intent> listModel = new DefaultListModel<Intent>();
    private static DefaultListModel<Integer> indexModel = new DefaultListModel<Integer>();
    public static final JList<Intent> list = new JList<Intent>(listModel);
    public static final JList<Integer> list_1 = new JList<Integer>(indexModel);
    private static JLabel lblCurrentBlockLabel;
    private static int indexTemp;

    private void fillList()
    {
	if (vars.currentIntentList.size() > 0)
	{
	    for (Intent t : vars.currentIntentList)
	    {
		listModel.addElement(t);
	    }
	    resetIndexes();
	}
    }

    public static void resetIndexes()
    {
	indexModel.clear();
	for (int i = 0; i < listModel.size(); i++)
	{
	    indexModel.addElement(i);
	}
    }

    public BlockBuilderGUI()
    {
	listModel.clear();
	indexModel.clear();
	setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
	JScrollPane scrollPane_1 = new JScrollPane();
	scrollPane_1.setBounds(0, 0, 38, 682);
	getContentPane().add(scrollPane_1);

	scrollPane_1.setViewportView(list_1);
	setBounds(100, 100, 661, 746);
	JMenuBar menuBar = new JMenuBar();
	setJMenuBar(menuBar);
	JMenu mnFile = new JMenu("File");
	menuBar.add(mnFile);
	JMenu mnNewMenu = new JMenu("Add Condition");
	menuBar.add(mnNewMenu);
	JMenu mnAddAction = new JMenu("Add Action");
	menuBar.add(mnAddAction);
	JButton btnAddLabel = new JButton("Add Label");
	menuBar.add(btnAddLabel);
	JButton btnCancel = new JButton("Cancel");
	menuBar.add(btnCancel);

	btnCancel.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent e)
	    {
		if (JOptionPane
			.showConfirmDialog(
				null,
				"Are you sure you want to cancel? You will lose all changes you have made",
				"Really Closing?", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION)
		{
		    vars.currentIntentList.clear();
		    GUIHandler.resetAll();
		    BlockHandler.resetAll();
		    vars.builderIsOpen = false;
		    GUIHandler.isCreating = false;
		    BlockBuilderGUI.this.setVisible(false);
		    BlockBuilderGUI.this.dispose();
		}
	    }
	});
	JButton btnDone = new JButton("Done");
	menuBar.add(btnDone);

	btnDone.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent e)
	    {
		if (BlockHandler.isMain())
		{
		    BlockHandler.addBlock(
			    "main",
			    new Block(vars.currentIntentList
				    .toArray(new Intent[vars.currentIntentList
					    .size()]), "main"));
		    BlockHandler.resetAll();
		    vars.builderIsOpen = false;
		    setVisible(false);
		    dispose();
		    GUIHandler.isCreating = false;
		    GUIHandler.resetAll();
		} else
		{
		    BlockHandler.addBlock(
			    BlockHandler.getCurrentBlockName(),
			    new Block(vars.currentIntentList
				    .toArray(new Intent[vars.currentIntentList
					    .size()]), BlockHandler
				    .getCurrentBlockName()));
		    BlockHandler.resetAll();
		    vars.builderIsOpen = false;
		    setVisible(false);
		    dispose();
		    GUIHandler.isCreating = false;
		    GUIHandler.resetAll();
		}
	    }
	});
	menuBar.add(btnDone);

	lblCurrentBlockLabel = new JLabel("Currently Building Block:");
	menuBar.add(lblCurrentBlockLabel);
	lblCurrentBlockLabel.setText("Currently Building Block: "
		+ BlockHandler.getCurrentBlockName());

	this.addWindowListener(new java.awt.event.WindowAdapter()
	{
	    @Override
	    public void windowClosing(java.awt.event.WindowEvent windowEvent)
	    {
		if (JOptionPane
			.showConfirmDialog(
				null,
				"Are you sure to close this window? All changes you have made will be lost",
				"Really Closing?", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION)
		{
		    vars.currentIntentList.clear();
		    GUIHandler.resetAll();
		    BlockHandler.resetAll();
		    vars.builderIsOpen = false;
		    GUIHandler.isCreating = false;
		}
	    }
	});

	JMenuItem remove = new JMenuItem("Remove selected item");
	mnFile.add(remove);

	remove.addActionListener(new ActionListener()
	{
	    @Override
	    public void actionPerformed(ActionEvent arg0)
	    {
		if (GUIHandler.isCreating)
		{
		    JOptionPane
			    .showMessageDialog(list,
				    "Please finish your current action/conditional before removing");
		    return;
		}
		int index = list.getSelectedIndex();
		if (index != -1)
		{
		    listModel.remove(index);
		    GUIHandler.resetAll();
		    vars.currentIntentList.remove(index);
		    BlockBuilderGUI.resetIndexes();
		}
	    }
	});

	JMenuItem updatePaint = new JMenuItem("Update paint element");
	mnFile.add(updatePaint);
	updatePaint.addActionListener(new ActionListener()
	{
	    @Override
	    public void actionPerformed(ActionEvent arg0)
	    {
		String[] o = PaintHandler.getAllPaintItems();
		JComboBox<String> b = new JComboBox<String>(o);
		JOptionPane.showMessageDialog(null, b, "Select a paint",
			JOptionPane.QUESTION_MESSAGE);
		String d = (String) b.getSelectedItem();
		if (d != null)
		    GUIHandler.setAction(new UpdatePaintAction(d));
	    }
	});

	// Conditionals for Objects
	JMenu mntmObjects = new JMenu("Objects");
	mnNewMenu.add(mntmObjects);

	JMenuItem dstToGreat = new JMenuItem(
		"If distance to... is greater than");
	mntmObjects.add(dstToGreat);
	dstToGreat.addActionListener(new ActionListener()
	{
	    @Override
	    public void actionPerformed(ActionEvent e)
	    {
		try
		{
		    String name = JOptionPane
			    .showInputDialog("Enter the objects name: ");
		    int distance = Integer.parseInt(JOptionPane
			    .showInputDialog("Enter the distance to the object must be greater than: "));
		    GUIHandler
			    .addCondition(new DistanceToObjectIsGreaterThanConditional(
				    name, distance));
		} catch (NumberFormatException ex)
		{
		    JOptionPane.showInternalMessageDialog(null,
			    "Please only enter numbers");
		}
	    }
	});

	JMenuItem obIsOnScreen = new JMenuItem("If object is on screen");
	mntmObjects.add(obIsOnScreen);
	obIsOnScreen.addActionListener(new ActionListener()
	{
	    @Override
	    public void actionPerformed(ActionEvent e)
	    {
		try
		{
		    String name = JOptionPane
			    .showInputDialog("Enter the objects name: ");
		    GUIHandler.addCondition(new ObjectIsOnScreenConditional(
			    name));
		} catch (NumberFormatException ex)
		{
		    JOptionPane.showInternalMessageDialog(null,
			    "Please only enter numbers");
		}
	    }
	});

	JMenuItem obIsNotOnScreen = new JMenuItem("If object is not on screen");
	mntmObjects.add(obIsNotOnScreen);
	obIsNotOnScreen.addActionListener(new ActionListener()
	{
	    @Override
	    public void actionPerformed(ActionEvent e)
	    {
		try
		{
		    String name = JOptionPane
			    .showInputDialog("Enter the objects name: ");
		    GUIHandler.addCondition(new ObjectIsNotOnScreenConditional(
			    name));
		} catch (NumberFormatException ex)
		{
		    JOptionPane.showInternalMessageDialog(null,
			    "Please only enter numbers");
		}
	    }
	});

	JMenuItem obIsValid = new JMenuItem("If object exists");
	mntmObjects.add(obIsValid);
	obIsValid.addActionListener(new ActionListener()
	{
	    @Override
	    public void actionPerformed(ActionEvent e)
	    {
		try
		{
		    String name = JOptionPane
			    .showInputDialog("Enter the objects name: ");
		    GUIHandler.addCondition(new ObjectIsValidConditional(name));
		} catch (NumberFormatException ex)
		{
		    JOptionPane.showInternalMessageDialog(null,
			    "Please only enter numbers");
		}
	    }
	});

	// end Conditionals for Objects

	JMenu mntmNewMenuItem = new JMenu("Location");
	mnNewMenu.add(mntmNewMenuItem);

	JMenuItem mntmDistanceTo = new JMenuItem(
		"Distance to [...] is greater than");
	mntmNewMenuItem.add(mntmDistanceTo);

	JMenuItem mntmDistanceTo_1 = new JMenuItem(
		"Distance to [...] is less than");
	mntmNewMenuItem.add(mntmDistanceTo_1);

	JMenuItem mntmLocationIsOn = new JMenuItem("Location is on screen");
	mntmLocationIsOn.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent e)
	    {
		int x = Integer.parseInt(JOptionPane.showInputDialog(
			"Enter tile x").replaceAll("[^0-9]", ""));
		int y = Integer.parseInt(JOptionPane.showInputDialog(
			"Enter tile y").replaceAll("[^0-9]", ""));
		GUIHandler
			.addCondition(new LocationIsOnScreenConditional(x, y));
	    }
	});
	mntmNewMenuItem.add(mntmLocationIsOn);

	JMenuItem mntmPlayerIsIn = new JMenuItem("Player is in area");
	mntmPlayerIsIn.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent e)
	    {
		int nwX = Integer.parseInt(JOptionPane.showInputDialog(
			"Enter North East Tile x").replaceAll("[^0-9]", ""));
		int nwY = Integer.parseInt(JOptionPane.showInputDialog(
			"Enter North east Tile y").replaceAll("[^0-9]", ""));
		int swX = Integer.parseInt(JOptionPane.showInputDialog(
			"Enter South West Tile x").replaceAll("[^0-9]", ""));
		int swY = Integer.parseInt(JOptionPane.showInputDialog(
			"Enter South West Tile y").replaceAll("[^0-9]", ""));
		GUIHandler.addCondition(new AreaContainsPlayerConditional(nwX,
			nwY, swX, swY));
	    }
	});
	mntmNewMenuItem.add(mntmPlayerIsIn);

	JMenu mntmGeneral = new JMenu("General");
	mnNewMenu.add(mntmGeneral);

	JMenuItem mntmRunIsAbove = new JMenuItem("Run is above [x]");
	mntmRunIsAbove.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent e)
	    {
		int percent = Integer.parseInt(JOptionPane.showInputDialog(
			"Enter percent").replaceAll("[^0-9]", ""));
		GUIHandler.addCondition(new RunIsAboveConditional(percent));
	    }
	});
	mntmGeneral.add(mntmRunIsAbove);

	JMenuItem mntmRunIsBelow = new JMenuItem("Run is below [x]");
	mntmRunIsBelow.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent e)
	    {
		int percent = Integer.parseInt(JOptionPane.showInputDialog(
			"Enter percent").replaceAll("[^0-9]", ""));
		GUIHandler.addCondition(new RunIsBelowConditional(percent));
	    }
	});
	mntmGeneral.add(mntmRunIsBelow);

	JMenuItem mntmNpcChatIs = new JMenuItem("NPC chat is on screen");
	mntmNpcChatIs.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent e)
	    {
		GUIHandler.addCondition(new NPCChatIsOpenConditional());
	    }
	});
	mntmGeneral.add(mntmNpcChatIs);

	JMenuItem mntmAnimationEqualsx = new JMenuItem("Animation equals [x]");
	mntmAnimationEqualsx.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent e)
	    {
		int animation = Integer.parseInt(JOptionPane.showInputDialog(
			"Enter animation id").replaceAll("[^0-9]", ""));
		GUIHandler.addCondition(new AnimationIsConditional(animation));
	    }
	});
	mntmGeneral.add(mntmAnimationEqualsx);

	JMenu mnSkills = new JMenu("Skills");
	mnNewMenu.add(mnSkills);

	JMenuItem mntmHpIsLess = new JMenuItem("HP is less than [x] percent");
	mntmHpIsLess.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent e)
	    {
		int percent = Integer.parseInt(JOptionPane.showInputDialog(
			"Enter percent").replaceAll("[^0-9]", ""));
		GUIHandler.addCondition(new HPIsLessThanConditional(percent));
	    }
	});
	mnSkills.add(mntmHpIsLess);

	JMenuItem mntmSkillIsLess = new JMenuItem(
		"Skill is less than [x] level");
	mntmSkillIsLess.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent e)
	    {
		JComboBox<SKILLS> box = new JComboBox<SKILLS>(SKILLS.values());
		JOptionPane.showMessageDialog(null, box, "Select a skill",
			JOptionPane.QUESTION_MESSAGE);
		SKILLS k = (SKILLS) box.getSelectedItem();
		int level = Integer.parseInt(JOptionPane.showInputDialog(
			"Enter level the skill should be under").replaceAll(
			"[^0-9]", ""));
		GUIHandler
			.addCondition(new SkillIsLessThanConditional(k, level));
	    }
	});
	mnSkills.add(mntmSkillIsLess);

	JMenu mnCombat = new JMenu("Combat");
	mnNewMenu.add(mnCombat);

	JMenuItem mntmPlayerIsNot = new JMenuItem("Player is not in combat");
	mntmPlayerIsNot.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent e)
	    {
		GUIHandler.addCondition(new PlayerIsNotInCombatConditional());
	    }
	});
	mnCombat.add(mntmPlayerIsNot);

	JMenuItem mntmPlayerIsIn_1 = new JMenuItem("Player is in combat");
	mntmPlayerIsIn_1.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent e)
	    {
		GUIHandler.addCondition(new PlayerIsInCombatConditional());
	    }
	});
	mnCombat.add(mntmPlayerIsIn_1);

	JMenu mnNpcs = new JMenu("NPCs");
	mnNewMenu.add(mnNpcs);

	JMenuItem mntmNearestNpcx = new JMenuItem(
		"Nearest NPC [x] is on screen");
	mntmNearestNpcx.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent e)
	    {
		String name = JOptionPane.showInputDialog("Enter NPC name");
		GUIHandler.addCondition(new NPCIsOnScreenConditional(name));
	    }
	});
	mnNpcs.add(mntmNearestNpcx);

	JMenuItem mntmNearestNpcx_3 = new JMenuItem(
		"Nearest NPC [x] is not on screen");
	mntmNearestNpcx_3.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent e)
	    {
		String name = JOptionPane.showInputDialog("Enter NPC name");
		GUIHandler.addCondition(new NPCIsNotOnScreenConditional(name));
	    }
	});
	mnNpcs.add(mntmNearestNpcx_3);

	JMenuItem mntmDistanceToNearest = new JMenuItem(
		"Distance to nearest NPC [x] < [y]");
	mntmDistanceToNearest.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent e)
	    {
		String name = JOptionPane.showInputDialog("Enter NPC name");
		int distance = Integer.parseInt(JOptionPane.showInputDialog(
			"Enter distance").replaceAll("[^0-9]", ""));
		GUIHandler
			.addCondition(new DistanceToNearestNPCLessConditional(
				name, distance));
	    }
	});
	mnNpcs.add(mntmDistanceToNearest);

	JMenuItem mntmDistanceToNearest_1 = new JMenuItem(
		"Distance to nearest NPC [x] > [y]");
	mntmDistanceToNearest_1.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent e)
	    {
		String name = JOptionPane.showInputDialog("Enter NPC name");
		int distance = Integer.parseInt(JOptionPane.showInputDialog(
			"Enter distance").replaceAll("[^0-9]", ""));
		GUIHandler
			.addCondition(new DistanceToNearestNPCIsGreaterThanConditional(
				name, distance));
	    }
	});
	mnNpcs.add(mntmDistanceToNearest_1);

	JMenuItem mntmNearestNpcx_1 = new JMenuItem(
		"Nearest NPC [x] is in combat");
	mntmNearestNpcx_1.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent e)
	    {
		String name = JOptionPane.showInputDialog("Enter NPC name");
		GUIHandler.addCondition(new NPCIsInCombatConditional(name));
	    }
	});
	mnNpcs.add(mntmNearestNpcx_1);

	JMenuItem mntmNearestNpcx_2 = new JMenuItem(
		"Nearest NPC [x] is not in combat");
	mntmNearestNpcx_2.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent e)
	    {
		String name = JOptionPane.showInputDialog("Enter NPC name");
		GUIHandler.addCondition(new NPCIsNotInCombatConditional(name));
	    }
	});
	mnNpcs.add(mntmNearestNpcx_2);

	JMenuItem mntmNearestNpcxs = new JMenuItem("Nearest NPC [x]'s HP < [y]");
	mntmNearestNpcxs.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent e)
	    {
		String name = JOptionPane.showInputDialog("Enter NPC name");
		int percent = Integer.parseInt(JOptionPane.showInputDialog(
			"Enter HP percent").replaceAll("[^0-9]", ""));
		GUIHandler.addCondition(new NPCHPPercentIsLessThanConditional(
			name, percent));
	    }
	});
	mnNpcs.add(mntmNearestNpcxs);

	JMenuItem mntmNpcxExists = new JMenuItem("NPC [x] exists");
	mntmNpcxExists.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent e)
	    {
		String name = JOptionPane.showInputDialog("Enter NPC name");
		GUIHandler.addCondition(new NPCIsValidConditional(name));
	    }
	});
	mnNpcs.add(mntmNpcxExists);

	JMenu mnInventory = new JMenu("Inventory");
	mnNewMenu.add(mnInventory);

	JMenuItem mntmInventoryContainsx = new JMenuItem(
		"Inventory contains at least [y] of [x]");
	mntmInventoryContainsx.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent e)
	    {
		int id = Integer.parseInt(JOptionPane.showInputDialog(
			"Enter id of the item").replaceAll("[^0-9]", ""));
		int amount = Integer.parseInt(JOptionPane.showInputDialog(
			"Enter amount it should contain at a minimum")
			.replaceAll("[^0-9]", ""));
		GUIHandler.addCondition(new InventoryContainsConditional(id,
			amount));
	    }
	});
	mnInventory.add(mntmInventoryContainsx);

	JMenuItem mntmInventoryDoesntContainx = new JMenuItem(
		"Inventory doesn't contain [x]");
	mntmInventoryDoesntContainx.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent e)
	    {
		int id = Integer.parseInt(JOptionPane.showInputDialog(
			"Enter id of the item").replaceAll("[^0-9]", ""));
		GUIHandler.addCondition(new InventoryDoesNotContainConditional(
			id));
	    }
	});
	mnInventory.add(mntmInventoryDoesntContainx);

	JMenuItem mntmInventoryIsEmpty = new JMenuItem("Inventory is empty");
	mntmInventoryIsEmpty.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent e)
	    {
		GUIHandler.addCondition(new InventoryIsEmptyConditional());
	    }
	});
	mnInventory.add(mntmInventoryIsEmpty);

	JMenuItem mntmInventoryIsFull = new JMenuItem("Inventory is full");
	mntmInventoryIsFull.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent e)
	    {
		GUIHandler.addCondition(new InventoryIsFullConditional());
	    }
	});
	mnInventory.add(mntmInventoryIsFull);

	JMenuItem mntmInventoryIsNot = new JMenuItem("Inventory is not full");
	mntmInventoryIsNot.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent e)
	    {
		GUIHandler.addCondition(new InventoryIsNotFullConditional());
	    }
	});
	mnInventory.add(mntmInventoryIsNot);

	JMenu mnGroundItems = new JMenu("Ground Items");
	mnNewMenu.add(mnGroundItems);

	JMenuItem mntmItemxIs = new JMenuItem("Item [x] is not on the ground");
	mntmItemxIs.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent arg0)
	    {
		int id = Integer.parseInt(JOptionPane.showInputDialog(
			"Enter id of the item").replaceAll("[^0-9]", ""));
		GUIHandler.addCondition(new ItemIsNotOnGroundConditional(id));
	    }
	});
	mnGroundItems.add(mntmItemxIs);

	JMenuItem mntmItemxIs_1 = new JMenuItem("Item [x] is on the ground");
	mntmItemxIs_1.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent e)
	    {
		int id = Integer.parseInt(JOptionPane.showInputDialog(
			"Enter id of the item").replaceAll("[^0-9]", ""));
		GUIHandler.addCondition(new ItemIsOnGroundConditional(id));
	    }
	});
	mnGroundItems.add(mntmItemxIs_1);

	JMenuItem mntmItemxIsOn = new JMenuItem("Item [x] is on screen");
	mntmItemxIsOn.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent e)
	    {
		int id = Integer.parseInt(JOptionPane.showInputDialog(
			"Enter id of the item").replaceAll("[^0-9]", ""));
		GUIHandler.addCondition(new ItemIsOnScreenConditional(id));
	    }
	});
	mnGroundItems.add(mntmItemxIsOn);

	JMenuItem mntmItemxIs_2 = new JMenuItem("Item [x] is not on screen");
	mntmItemxIs_2.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent e)
	    {
		int id = Integer.parseInt(JOptionPane.showInputDialog(
			"Enter id of the item").replaceAll("[^0-9]", ""));
		GUIHandler.addCondition(new ItemIsNotOnScreenConditional(id));
	    }
	});
	mnGroundItems.add(mntmItemxIs_2);

	JMenuItem mntmExecuteBlock = new JMenuItem("Execute Block...");
	mntmExecuteBlock.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent e)
	    {
		String[] blocks = BlockHandler.getAllBlockNames();
		JComboBox<String> box = new JComboBox<String>(
			new DefaultComboBoxModel<String>(blocks));
		JOptionPane.showMessageDialog(null, box,
			"Choose a block to execute",
			JOptionPane.QUESTION_MESSAGE);
		String name = (String) box.getSelectedItem();
		GUIHandler.setAction(new BlockCaller(name));
	    }
	});
	mnAddAction.add(mntmExecuteBlock);

	JMenuItem mntmGoto = new JMenuItem("GOTO");
	mnAddAction.add(mntmGoto);

	mntmGoto.addActionListener(new ActionListener()
	{
	    @Override
	    public void actionPerformed(ActionEvent arg0)
	    {

		String[] labels = BlockHandler.getAllLabels();
		if (labels.length == 0)
		{
		    JOptionPane.showMessageDialog(null,
			    "You do not have any labels added");
		    return;
		}
		JComboBox<String> b = new JComboBox<String>(labels);
		JOptionPane.showMessageDialog(null, b, "Select a label",
			JOptionPane.QUESTION_MESSAGE);
		String x = (String) b.getSelectedItem();
		GUIHandler.setAction(new GOTOAction(x));
	    }
	});

	JMenu mnGeneral = new JMenu("General");
	mnAddAction.add(mnGeneral);

	JMenuItem mntmSleepForx = new JMenuItem("Sleep for [x] seconds");
	mntmSleepForx.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent e)
	    {
		double seconds = Double.parseDouble(JOptionPane
			.showInputDialog("Enter seconds to sleep for")
			.replaceAll("[^0-9]&&[^.]", ""));
		GUIHandler.setAction(new SleepAction((long) (seconds * 1000)));
	    }
	});
	mnGeneral.add(mntmSleepForx);

	JMenuItem mntmTurnRunOn = new JMenuItem("Turn run on");
	mntmTurnRunOn.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent e)
	    {
		GUIHandler.setAction(new TurnRunOnAction());
	    }
	});
	mnGeneral.add(mntmTurnRunOn);

	JMenuItem mntmTurnRunOff = new JMenuItem("Turn run off");
	mntmTurnRunOff.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent e)
	    {
		GUIHandler.setAction(new TurnRunOffAction());
	    }
	});
	mnGeneral.add(mntmTurnRunOff);

	JMenuItem mntmTypexMessage = new JMenuItem(
		"Type [x] message and hit enter");
	mntmTypexMessage.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent e)
	    {
		String message = JOptionPane
			.showInputDialog("Enter the message to send");
		GUIHandler.setAction(new TalkAction(message));
	    }
	});
	mnGeneral.add(mntmTypexMessage);

	JMenu mntmObjects_1 = new JMenu("Objects");
	mnAddAction.add(mntmObjects_1);

	JMenuItem mntmClickNearestObject = new JMenuItem(
		"Click nearest object [x] with action [y]");
	mntmClickNearestObject.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent e)
	    {
		String name = JOptionPane.showInputDialog("Enter object name");
		String action = JOptionPane.showInputDialog("Enter action");
		GUIHandler.setAction(new ClickObjectAction(name, action));
	    }
	});
	mntmObjects_1.add(mntmClickNearestObject);

	JMenuItem mntmMoveMouseTo = new JMenuItem("Move mouse to object [x]");
	mntmMoveMouseTo.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent e)
	    {
		String name = JOptionPane.showInputDialog("Enter object name");
		GUIHandler.setAction(new MoveMouseToObject(name));
	    }
	});
	mntmObjects_1.add(mntmMoveMouseTo);

	JMenuItem mntmTurnCameraTo = new JMenuItem("Turn camera to object [x]");
	mntmTurnCameraTo.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent e)
	    {
		String name = JOptionPane.showInputDialog("Enter object name");
		GUIHandler.setAction(new TurnToObjectAction(name));
	    }
	});
	mntmObjects_1.add(mntmTurnCameraTo);

	JMenuItem mntmWalkToNearest = new JMenuItem(
		"Walk to nearest object [x]");
	mntmWalkToNearest.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent e)
	    {
		String name = JOptionPane.showInputDialog("Enter object name");
		GUIHandler.setAction(new WalkToObjectAction(name));
	    }
	});
	mntmObjects_1.add(mntmWalkToNearest);

	JMenu mnGroundItems_1 = new JMenu("Ground Items");
	mnAddAction.add(mnGroundItems_1);

	JMenuItem mntmClickItemx_1 = new JMenuItem(
		"Click item [x] with the action [y]");
	mntmClickItemx_1.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent e)
	    {
		int x = Integer.parseInt(JOptionPane.showInputDialog(
			"Enter id of the item to click").replaceAll("[^0-9]",
			""));
		String y = JOptionPane
			.showInputDialog("Enter the action to click the item with");
		GUIHandler.setAction(new ClickGroundItemAction(x, y));
	    }
	});
	mnGroundItems_1.add(mntmClickItemx_1);

	JMenuItem mntmLootAllItems = new JMenuItem(
		"Loot all items with the ids [x...]");
	mntmLootAllItems.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent arg0)
	    {
		List<Integer> list = new ArrayList<Integer>();
		int x;
		while ((x = Integer.parseInt(JOptionPane.showInputDialog(
			"Enter id to loot. Enter -1 to stop adding ids")
			.replaceAll("[^0-9]", ""))) != -1)
		{
		    list.add(x);
		}
		GUIHandler.setAction(new LootAllItemsAction(list
			.toArray(new Integer[list.size()])));

	    }
	});
	mnGroundItems_1.add(mntmLootAllItems);

	JMenu mntmItems = new JMenu("Items");
	mnAddAction.add(mntmItems);

	JMenuItem mntmWaitUntilInventory = new JMenuItem(
		"Wait until inventory doesn't contain [x]");
	mntmWaitUntilInventory.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent e)
	    {
		int id = Integer.parseInt(JOptionPane.showInputDialog(
			"Enter of id of item").replaceAll("[^0-9]", ""));
		int timeout = Integer.parseInt(JOptionPane.showInputDialog(
			"Enter a timeout in seconds").replaceAll("[^0-9]", ""));
		GUIHandler.setAction(new WaitUntilInventoryDoesntContainItem(
			id, timeout * 1000));
	    }
	});
	mntmItems.add(mntmWaitUntilInventory);

	JMenuItem mntmWaitUntilInventory_1 = new JMenuItem(
		"Wait until inventory contains [x]");
	mntmWaitUntilInventory_1.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent e)
	    {
		int id = Integer.parseInt(JOptionPane.showInputDialog(
			"Enter of id of item").replaceAll("[^0-9]", ""));
		int timeout = Integer.parseInt(JOptionPane.showInputDialog(
			"Enter a timeout in seconds").replaceAll("[^0-9]", ""));
		GUIHandler.setAction(new WaitUntilInventoryContainsAction(id,
			timeout * 1000));
	    }
	});
	mntmItems.add(mntmWaitUntilInventory_1);

	JMenuItem mntmClickItemx = new JMenuItem(
		"Click item [x]  with the action [y]");
	mntmClickItemx.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent e)
	    {
		int id = Integer.parseInt(JOptionPane.showInputDialog(
			"Enter of id of item").replaceAll("[^0-9]", ""));
		String action = JOptionPane.showInputDialog("Enter the action");
		GUIHandler.setAction(new CustomItemAction(id, action));

	    }
	});
	mntmItems.add(mntmClickItemx);

	JMenuItem mntmDropAllItems = new JMenuItem(
		"Drop all items in inventory");
	mntmDropAllItems.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent e)
	    {
		GUIHandler.setAction(new DropAllAction());
	    }
	});
	mntmItems.add(mntmDropAllItems);

	JMenuItem mntmDropAllItems_1 = new JMenuItem(
		"Drop all items in inventory except [x]");
	mntmDropAllItems_1.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent e)
	    {
		int id = Integer.parseInt(JOptionPane.showInputDialog(
			"Enter of id of item that you don't want to drop")
			.replaceAll("[^0-9]", ""));
		GUIHandler.setAction(new DropAllExceptAction(id));
	    }
	});
	mntmItems.add(mntmDropAllItems_1);

	JMenu mntmWalking = new JMenu("Walking");
	mnAddAction.add(mntmWalking);

	JMenuItem walkPath = new JMenuItem("Walk path");
	mntmWalking.add(walkPath);
	walkPath.addActionListener(new ActionListener()
	{
	    @Override
	    public void actionPerformed(ActionEvent arg0)
	    {
		PathGUI gui = new PathGUI();
		gui.setVisible(true);
	    }
	});

	JMenuItem walkToBank = new JMenuItem("WebWalk to bank");
	mntmWalking.add(walkToBank);
	walkToBank.addActionListener(new ActionListener()
	{
	    @Override
	    public void actionPerformed(ActionEvent arg0)
	    {
		GUIHandler.setAction(new WebWalkToBankAction());
	    }
	});

	JMenuItem webToTile = new JMenuItem("WebWalk to tile");
	mntmWalking.add(webToTile);
	webToTile.addActionListener(new ActionListener()
	{
	    @Override
	    public void actionPerformed(ActionEvent arg0)
	    {
		int x = Integer.parseInt(JOptionPane.showInputDialog(
			"Enter x coordinate").replaceAll("[^0-9]", ""));
		int y = Integer.parseInt(JOptionPane.showInputDialog(
			"Enter y coordinate").replaceAll("[^0-9]", ""));
		GUIHandler.setAction(new WebWalkToTileAction(new CustomTile(x,
			y)));
	    }
	});

	JMenuItem walkToTile = new JMenuItem("Walk to tile");
	mntmWalking.add(walkToTile);
	walkToTile.addActionListener(new ActionListener()
	{
	    @Override
	    public void actionPerformed(ActionEvent arg0)
	    {
		int x = Integer.parseInt(JOptionPane.showInputDialog(
			"Enter x coordinate").replaceAll("[^0-9]", ""));
		int y = Integer.parseInt(JOptionPane.showInputDialog(
			"Enter y coordinate").replaceAll("[^0-9]", ""));
		GUIHandler
			.setAction(new WalkToTileAction(new CustomTile(x, y)));
	    }
	});

	JMenu mntmBanking = new JMenu("Banking");
	mnAddAction.add(mntmBanking);

	JMenuItem mntmCloseBank = new JMenuItem("Close Bank");
	mntmCloseBank.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent e)
	    {
		GUIHandler.setAction(new CloseBankAction());
	    }
	});
	mntmBanking.add(mntmCloseBank);

	JMenuItem mntmDepositall = new JMenuItem("DepositAll");
	mntmDepositall.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent e)
	    {
		GUIHandler.setAction(new DepositAllAction());
	    }
	});
	mntmBanking.add(mntmDepositall);

	JMenuItem mntmDepositAllExcept = new JMenuItem("Deposit All Except [x]");
	mntmDepositAllExcept.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent e)
	    {
		int id = Integer.parseInt(JOptionPane.showInputDialog(
			"Enter id of item you don't want to deposit")
			.replaceAll("[^0-9]", ""));
		GUIHandler.setAction(new DepositAllExceptAction(id));
	    }
	});
	mntmBanking.add(mntmDepositAllExcept);

	JMenuItem mntmOpenBank = new JMenuItem("Open Bank");
	mntmOpenBank.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent e)
	    {
		GUIHandler.setAction(new OpenBankAction());
	    }
	});
	mntmBanking.add(mntmOpenBank);

	JMenuItem mntmWithdrawItem = new JMenuItem(
		"Withdraw [x] amount of item [y]");
	mntmWithdrawItem.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent e)
	    {
		int id = Integer.parseInt(JOptionPane.showInputDialog(
			"Enter ID of the item you want to withdraw")
			.replaceAll("[^0-9]", ""));
		int amount = Integer.parseInt(JOptionPane.showInputDialog(
			"Enter the amount to withdraw")
			.replaceAll("[^0-9]", ""));
		GUIHandler.setAction(new WithdrawItemAction(id, amount));
	    }
	});
	mntmBanking.add(mntmWithdrawItem);

	JMenuItem mntmWaitUntilBank = new JMenuItem("Wait until bank is open");
	mntmWaitUntilBank.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent e)
	    {
		int timeout = Integer.parseInt(JOptionPane.showInputDialog(
			"Enter a timeout").replaceAll("[^0-9]", ""));
		GUIHandler.setAction(new WaitUntilBankIsOpenAction(timeout));
	    }
	});
	mntmBanking.add(mntmWaitUntilBank);

	JMenu mntmNpcs = new JMenu("NPCs");
	mnAddAction.add(mntmNpcs);

	JMenuItem mntmClickNpcx = new JMenuItem(
		"Click NPC [x] with the action [y]");
	mntmClickNpcx.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent e)
	    {
		String name = JOptionPane.showInputDialog("Enter NPC name");
		String option = JOptionPane
			.showInputDialog("Enter the option to click the NPC with (be exact)");
		GUIHandler.setAction(new ClickNPCAction(name, option));
	    }
	});
	mntmNpcs.add(mntmClickNpcx);

	JMenuItem mntmWalkToNpc = new JMenuItem("Walk to NPC [x]");
	mntmWalkToNpc.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent e)
	    {
		String name = JOptionPane.showInputDialog("Enter NPC name");
		GUIHandler.setAction(new WalkToNearestNPCAction(name));
	    }
	});
	mntmNpcs.add(mntmWalkToNpc);

	JMenuItem mntmTurnCameraTo_1 = new JMenuItem("Turn camera to NPC [x]");
	mntmTurnCameraTo_1.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent e)
	    {
		String name = JOptionPane.showInputDialog("Enter NPC name");
		GUIHandler.setAction(new TurnCameraToNPCAction(name));
	    }
	});
	mntmNpcs.add(mntmTurnCameraTo_1);

	JMenu mntmMagic = new JMenu("Magic");
	mnAddAction.add(mntmMagic);

	JMenuItem mntmCastSpellx = new JMenuItem("Cast spell [x]");
	mntmCastSpellx.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent e)
	    {
		JComboBox<Magic.Spell> b = new JComboBox<Magic.Spell>(
			Magic.Spell.values());
		JOptionPane.showMessageDialog(null, b, "Select a spell",
			JOptionPane.QUESTION_MESSAGE);
		Magic.Spell d = (Magic.Spell) b.getSelectedItem();
		GUIHandler.setAction(new CastSpellAction(d));
	    }
	});
	mntmMagic.add(mntmCastSpellx);

	JMenu mntmEquipment = new JMenu("Equipment");
	mnAddAction.add(mntmEquipment);

	JMenuItem mntmRemoveEquipmentAt = new JMenuItem(
		"Unequip equipment at slot [x]");
	mntmRemoveEquipmentAt.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent e)
	    {
		JComboBox<Equipment.Gear> b = new JComboBox<Equipment.Gear>(
			Equipment.Gear.values());
		JOptionPane.showMessageDialog(null, b, "Select a gear slot",
			JOptionPane.QUESTION_MESSAGE);
		Equipment.Gear g = (Equipment.Gear) b.getSelectedItem();
		GUIHandler.setAction(new UnEquipItemAction(g));
	    }
	});
	mntmEquipment.add(mntmRemoveEquipmentAt);

	JMenuItem mntmUnequipAllEquipment = new JMenuItem(
		"Unequip all equipment");
	mntmUnequipAllEquipment.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent e)
	    {
		GUIHandler.setAction(new UnequipAllAction());
	    }
	});
	mntmEquipment.add(mntmUnequipAllEquipment);

	JMenu mntmNpcChat = new JMenu("NPC Chat");
	mnAddAction.add(mntmNpcChat);

	JMenuItem mntmClickToContinue = new JMenuItem("Click to continue");
	mntmClickToContinue.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent e)
	    {
		GUIHandler.setAction(new ClickToContinueAction());
	    }
	});
	mntmNpcChat.add(mntmClickToContinue);

	JMenuItem mntmClickOptionx = new JMenuItem("Click option [x]");
	mntmClickOptionx.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent e)
	    {
		String option = JOptionPane
			.showInputDialog("Enter the option to choose (must be exact)");
		GUIHandler.setAction(new ChooseNPCChatOptionAction(option));
	    }
	});
	mntmNpcChat.add(mntmClickOptionx);

	JMenu mnRightClickMenu = new JMenu("Right Click Menu");
	mnAddAction.add(mnRightClickMenu);

	JMenuItem mntmChooseAnOption = new JMenuItem(
		"Choose option[x]  from the right click menu");
	mntmChooseAnOption.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent e)
	    {
		String option = JOptionPane
			.showInputDialog("Enter the option to choose (be exact)");
		GUIHandler.setAction(new ChooseOptionFromMenuAction(option));
	    }
	});
	mnRightClickMenu.add(mntmChooseAnOption);

	JMenu mousePop = new JMenu("Mouse");
	mnAddAction.add(mousePop);

	JMenu mnWait = new JMenu("Wait until...");
	mnAddAction.add(mnWait);

	JMenuItem mntmWaitUntilIdle = new JMenuItem("Wait until idle");
	mntmWaitUntilIdle.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent e)
	    {
		GUIHandler.setAction(new WaitUntilIdleAction());
	    }
	});
	mnWait.add(mntmWaitUntilIdle);

	JMenuItem mntmWaitUntilStopped = new JMenuItem("Wait until stopped");
	mntmWaitUntilStopped.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent e)
	    {
		GUIHandler.setAction(new WaitUntilStoppedAction());
	    }
	});
	mnWait.add(mntmWaitUntilStopped);

	JMenuItem addEmote = new JMenuItem("Do emote");
	mnAddAction.add(addEmote);

	addEmote.addActionListener(new ActionListener()
	{
	    @Override
	    public void actionPerformed(ActionEvent arg0)
	    {
		EmoteHandler.Emote d = (EmoteHandler.Emote) JOptionPane
			.showInputDialog(null, "Choose an emote to do",
				"Emotes", JOptionPane.QUESTION_MESSAGE, null,
				EmoteHandler.Emote.values(),
				EmoteHandler.Emote.ANGRY);
		GUIHandler.setAction(new EmoteAction(d));

	    }
	});

	// MOUSE MENU STUFF
	JMenuItem moveAndLeftClick = new JMenuItem("Move and left click");
	mousePop.add(moveAndLeftClick);
	moveAndLeftClick.addActionListener(new ActionListener()
	{
	    @Override
	    public void actionPerformed(ActionEvent e)
	    {
		try
		{
		    int x = Integer.parseInt(JOptionPane
			    .showInputDialog("Enter x coordinate"));
		    int y = Integer.parseInt(JOptionPane
			    .showInputDialog("Enter y coordinate"));
		    GUIHandler.setAction(new LeftClickPointAction(new Point(x,
			    y)));
		} catch (NumberFormatException ex)
		{
		    JOptionPane.showInternalMessageDialog(null,
			    "Please only enter numbers");
		}
	    }
	});

	JMenuItem leftClick = new JMenuItem("Left click");
	mousePop.add(leftClick);
	leftClick.addActionListener(new ActionListener()
	{
	    @Override
	    public void actionPerformed(ActionEvent e)
	    {
		GUIHandler.setAction(new LeftClickAction());
	    }
	});

	JMenuItem rightClick = new JMenuItem("Right Click");
	mousePop.add(rightClick);
	rightClick.addActionListener(new ActionListener()
	{
	    @Override
	    public void actionPerformed(ActionEvent e)
	    {
		GUIHandler.setAction(new RightClickAction());
	    }
	});

	JMenuItem setMouseSpeed = new JMenuItem("Set mouse speed");
	mousePop.add(setMouseSpeed);
	setMouseSpeed.addActionListener(new ActionListener()
	{
	    @Override
	    public void actionPerformed(ActionEvent e)
	    {
		try
		{
		    int speed = Integer.parseInt(JOptionPane
			    .showInputDialog("Enter mouse speed"));
		    GUIHandler.setAction(new SetMouseSpeedAction(speed));
		} catch (NumberFormatException ex)
		{
		    JOptionPane.showInternalMessageDialog(null,
			    "Please only enter numbers");
		}
	    }
	});

	JMenuItem moveAndChoose = new JMenuItem(
		"Move mouse to a point and choose an option");
	mousePop.add(moveAndChoose);
	moveAndChoose.addActionListener(new ActionListener()
	{
	    @Override
	    public void actionPerformed(ActionEvent e)
	    {
		try
		{
		    int x = Integer.parseInt(JOptionPane
			    .showInputDialog("Enter x coordinate: "));
		    int y = Integer.parseInt(JOptionPane
			    .showInputDialog("Enter y coordinate: "));
		    String o = JOptionPane
			    .showInputDialog("Enter the option to choose: ");
		    GUIHandler.setAction(new MoveMouseAndChooseOptionAction(
			    new Point(x, y), o));
		} catch (NumberFormatException ex)
		{
		    JOptionPane.showInternalMessageDialog(null,
			    "Please only enter numbers");
		}
	    }
	});

	btnAddLabel.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent e)
	    {
		String d = JOptionPane
			.showInputDialog("Enter a name for the label");
		GUIHandler.addLabel(d);
	    }
	});

	getContentPane().setLayout(null);
	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(37, 0, 608, 682);
	getContentPane().add(scrollPane);
	final JPopupMenu menu = new JPopupMenu();
	JMenuItem insert = new JMenuItem("Insert");
	insert.addActionListener(new ActionListener()
	{
	    @Override
	    public void actionPerformed(ActionEvent arg0)
	    {
		GUIHandler.setIndex(indexTemp);
	    }
	});
	JMenuItem removeRight = new JMenuItem("Remove");
	menu.add(removeRight);
	menu.add(insert);
	removeRight.addActionListener(new ActionListener()
	{

	    @Override
	    public void actionPerformed(ActionEvent e)
	    {
		if (GUIHandler.isCreating)
		    return;
		if (indexTemp != -1)
		{
		    listModel.remove(indexTemp);
		    GUIHandler.resetAll();
		    vars.currentIntentList.remove(indexTemp);
		}
		BlockBuilderGUI.resetIndexes();
		indexTemp = -1;
	    }
	});
	list.addMouseListener(new MouseAdapter()
	{

	    @Override
	    public void mouseReleased(MouseEvent arg0)
	    {
		if (SwingUtilities.isRightMouseButton(arg0))
		{
		    if (GUIHandler.isCreating)
		    {
			JOptionPane
				.showMessageDialog(list,
					"Please finish your current action/conditional before removing/insert");
			return;
		    }
		    indexTemp = list.locationToIndex(arg0.getPoint());
		    menu.show(list, arg0.getX(), arg0.getY());
		}
	    }
	});
	scrollPane.setViewportView(list);
	fillList();
	GUIHandler.setIndex(listModel.size());
    }
}
