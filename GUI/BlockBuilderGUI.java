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
import scripts.ScriptMaker.api.methods.paint.GenericPaintItemString;
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
import scripts.ScriptMaker.api.types.intent.NPCs.actions.id.ClickNPCIDAction;
import scripts.ScriptMaker.api.types.intent.NPCs.actions.id.TurnCameraToNPCIDAction;
import scripts.ScriptMaker.api.types.intent.NPCs.actions.id.WalkToNearestNPCIDAction;
import scripts.ScriptMaker.api.types.intent.NPCs.actions.name.ClickNPCAction;
import scripts.ScriptMaker.api.types.intent.NPCs.actions.name.TurnCameraToNPCAction;
import scripts.ScriptMaker.api.types.intent.NPCs.actions.name.WalkToNearestNPCAction;
import scripts.ScriptMaker.api.types.intent.NPCs.conditionals.id.DistanceToNearestNPCIsGreaterThanIDConditional;
import scripts.ScriptMaker.api.types.intent.NPCs.conditionals.id.DistanceToNearestNPCIsLessIDConditional;
import scripts.ScriptMaker.api.types.intent.NPCs.conditionals.id.NPCHPPercentIsLessThanIDConditional;
import scripts.ScriptMaker.api.types.intent.NPCs.conditionals.id.NPCIsInCombatIDConditional;
import scripts.ScriptMaker.api.types.intent.NPCs.conditionals.id.NPCIsNotInCombatIDConditional;
import scripts.ScriptMaker.api.types.intent.NPCs.conditionals.id.NPCIsNotOnScreenIDConditional;
import scripts.ScriptMaker.api.types.intent.NPCs.conditionals.id.NPCIsOnScreenIDConditional;
import scripts.ScriptMaker.api.types.intent.NPCs.conditionals.id.NPCIsValidIDConditional;
import scripts.ScriptMaker.api.types.intent.NPCs.conditionals.name.DistanceToNearestNPCIsGreaterThanConditional;
import scripts.ScriptMaker.api.types.intent.NPCs.conditionals.name.DistanceToNearestNPCLessConditional;
import scripts.ScriptMaker.api.types.intent.NPCs.conditionals.name.NPCHPPercentIsLessThanConditional;
import scripts.ScriptMaker.api.types.intent.NPCs.conditionals.name.NPCIsInCombatConditional;
import scripts.ScriptMaker.api.types.intent.NPCs.conditionals.name.NPCIsNotInCombatConditional;
import scripts.ScriptMaker.api.types.intent.NPCs.conditionals.name.NPCIsNotOnScreenConditional;
import scripts.ScriptMaker.api.types.intent.NPCs.conditionals.name.NPCIsOnScreenConditional;
import scripts.ScriptMaker.api.types.intent.NPCs.conditionals.name.NPCIsValidConditional;
import scripts.ScriptMaker.api.types.intent.bank.CloseBankAction;
import scripts.ScriptMaker.api.types.intent.bank.DepositAllAction;
import scripts.ScriptMaker.api.types.intent.bank.DepositAllExceptAction;
import scripts.ScriptMaker.api.types.intent.bank.OpenBankAction;
import scripts.ScriptMaker.api.types.intent.bank.WaitUntilBankIsOpenAction;
import scripts.ScriptMaker.api.types.intent.bank.WithdrawItemAction;
import scripts.ScriptMaker.api.types.intent.camera.CameraAngleAction;
import scripts.ScriptMaker.api.types.intent.camera.CameraRotationAction;
import scripts.ScriptMaker.api.types.intent.chooseoptionmenu.ChooseOptionFromMenuAction;
import scripts.ScriptMaker.api.types.intent.conditionals.AnimationIsConditional;
import scripts.ScriptMaker.api.types.intent.conditionals.AreaContainsPlayerConditional;
import scripts.ScriptMaker.api.types.intent.conditionals.RunIsAboveConditional;
import scripts.ScriptMaker.api.types.intent.conditionals.RunIsBelowConditional;
import scripts.ScriptMaker.api.types.intent.conditionals.location.DistanceToIsGreaterConditional;
import scripts.ScriptMaker.api.types.intent.conditionals.location.DistanceToIsLessThanConditional;
import scripts.ScriptMaker.api.types.intent.conditionals.location.LocationIsOnScreenConditional;
import scripts.ScriptMaker.api.types.intent.conditionals.player.conditionals.PlayerIsInCombatConditional;
import scripts.ScriptMaker.api.types.intent.conditionals.player.conditionals.PlayerIsNotInCombatConditional;
import scripts.ScriptMaker.api.types.intent.conditionals.skills.HPIsLessThanConditional;
import scripts.ScriptMaker.api.types.intent.conditionals.skills.SkillIsLessThanConditional;
import scripts.ScriptMaker.api.types.intent.general.EndScriptAction;
import scripts.ScriptMaker.api.types.intent.general.SleepAction;
import scripts.ScriptMaker.api.types.intent.general.TalkAction;
import scripts.ScriptMaker.api.types.intent.general.TurnRunOffAction;
import scripts.ScriptMaker.api.types.intent.general.TurnRunOnAction;
import scripts.ScriptMaker.api.types.intent.general.UnEquipItemAction;
import scripts.ScriptMaker.api.types.intent.general.UnequipAllAction;
import scripts.ScriptMaker.api.types.intent.general.UpdatePaintAction;
import scripts.ScriptMaker.api.types.intent.general.UpdatePaintItemStringAction;
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
import scripts.ScriptMaker.api.types.intent.interfaces.actions.ClickInterfaceAction;
import scripts.ScriptMaker.api.types.intent.interfaces.actions.WaitUntilInterfaceIsClosedAction;
import scripts.ScriptMaker.api.types.intent.interfaces.actions.WaitUntilInterfaceIsOpenAction;
import scripts.ScriptMaker.api.types.intent.interfaces.conditionals.InterfaceIsClosedConditional;
import scripts.ScriptMaker.api.types.intent.interfaces.conditionals.InterfaceIsOpenConditional;
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
import scripts.ScriptMaker.api.types.intent.mouse.MousePointAction;
import scripts.ScriptMaker.api.types.intent.mouse.MoveMouseAndChooseOptionAction;
import scripts.ScriptMaker.api.types.intent.mouse.RightClickAction;
import scripts.ScriptMaker.api.types.intent.mouse.SetMouseSpeedAction;
import scripts.ScriptMaker.api.types.intent.object.actions.id.ClickObjectIDAction;
import scripts.ScriptMaker.api.types.intent.object.actions.id.MoveMouseToObjectIDAction;
import scripts.ScriptMaker.api.types.intent.object.actions.id.TurnToObjectIDAction;
import scripts.ScriptMaker.api.types.intent.object.actions.id.WalkToObjectIDAction;
import scripts.ScriptMaker.api.types.intent.object.actions.name.ClickObjectAction;
import scripts.ScriptMaker.api.types.intent.object.actions.name.MoveMouseToObject;
import scripts.ScriptMaker.api.types.intent.object.actions.name.TurnToObjectAction;
import scripts.ScriptMaker.api.types.intent.object.actions.name.WalkToObjectAction;
import scripts.ScriptMaker.api.types.intent.object.id.DistanceToObjectIDConditional;
import scripts.ScriptMaker.api.types.intent.object.id.ObjectIsNotValidIDConditional;
import scripts.ScriptMaker.api.types.intent.object.id.ObjectIsOnScreenIDConditional;
import scripts.ScriptMaker.api.types.intent.object.id.ObjectIsValidIDConditional;
import scripts.ScriptMaker.api.types.intent.object.id.ObjectisNotOnScreenIDConditional;
import scripts.ScriptMaker.api.types.intent.object.name.DistanceToObjectIsGreaterThanConditional;
import scripts.ScriptMaker.api.types.intent.object.name.ObjectIsNotOnScreenConditional;
import scripts.ScriptMaker.api.types.intent.object.name.ObjectIsNotValidConditional;
import scripts.ScriptMaker.api.types.intent.object.name.ObjectIsOnScreenConditional;
import scripts.ScriptMaker.api.types.intent.object.name.ObjectIsValidConditional;
import scripts.ScriptMaker.api.types.intent.players.actions.ClickNearestPlayerWithAction;
import scripts.ScriptMaker.api.types.intent.players.actions.RSPlayerClickAction;
import scripts.ScriptMaker.api.types.intent.players.actions.RSPlayerTurnToAction;
import scripts.ScriptMaker.api.types.intent.players.conditionals.RSPlayerCountConditional;
import scripts.ScriptMaker.api.types.intent.players.conditionals.RSPlayerIsNotOnScreenConditional;
import scripts.ScriptMaker.api.types.intent.players.conditionals.RSPlayerIsOnScreenConditional;
import scripts.ScriptMaker.api.types.intent.walking.actions.AStarWalkAction;
import scripts.ScriptMaker.api.types.intent.walking.actions.WalkToTileAction;
import scripts.ScriptMaker.api.types.intent.walking.actions.WebWalkToBankAction;
import scripts.ScriptMaker.api.types.intent.walking.actions.WebWalkToTileAction;
import scripts.ScriptMaker.api.types.intent.worldhopping.HopToRandomWorldAction;
import scripts.ScriptMaker.api.types.intent.worldhopping.HopToWorldAction;
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
				}
				else
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
					BlockBuilderGUI.this.setVisible(false);
					BlockBuilderGUI.this.dispose();
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
				{
					if (PaintHandler.getItem(d) instanceof GenericPaintItemString)
					{
						String extra = JOptionPane
								.showInputDialog("Enter text to replace current text");
						GUIHandler.setAction(new UpdatePaintItemStringAction(d,
								extra));

					}
					else
					{
						GUIHandler.setAction(new UpdatePaintAction(d));
					}

				}

			}
		});

		// Conditionals for Objects
		JMenu mntmObjects = new JMenu("Objects");
		mnNewMenu.add(mntmObjects);

		JMenu mnNames = new JMenu("Names");
		mntmObjects.add(mnNames);

		JMenuItem dstToGreat = new JMenuItem(
				"If distance to [x] is greater than [y] (Name)");
		mnNames.add(dstToGreat);

		JMenuItem obIsOnScreen = new JMenuItem(
				"If object [x] is on screen (Name)");
		mnNames.add(obIsOnScreen);

		JMenuItem obIsNotOnScreen = new JMenuItem(
				"If object [x] is not on screen (Name)");
		mnNames.add(obIsNotOnScreen);

		JMenuItem obIsValid = new JMenuItem("If object [x] exists (Name)");
		mnNames.add(obIsValid);

		JMenuItem mntmIfObjectx_3 = new JMenuItem(
				"If object [x] doesn't exist (Name)");
		mntmIfObjectx_3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String name = JOptionPane.showInputDialog("Enter Object name");
				GUIHandler.addCondition(new ObjectIsNotValidConditional(name));
			}
		});
		mnNames.add(mntmIfObjectx_3);
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
				}
				catch (NumberFormatException ex)
				{
					JOptionPane.showInternalMessageDialog(null,
							"Please only enter numbers");
				}
			}
		});
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
				}
				catch (NumberFormatException ex)
				{
					JOptionPane.showInternalMessageDialog(null,
							"Please only enter numbers");
				}
			}
		});
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
				}
				catch (NumberFormatException ex)
				{
					JOptionPane.showInternalMessageDialog(null,
							"Please only enter numbers");
				}
			}
		});
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
				}
				catch (NumberFormatException ex)
				{
					JOptionPane.showInternalMessageDialog(null,
							"Please only enter numbers");
				}
			}
		});

		JMenu mnIds = new JMenu("IDs");
		mntmObjects.add(mnIds);

		JMenuItem mntmIfDistanceTo = new JMenuItem(
				"If distance to [x] is greater than [y] (ID)");
		mntmIfDistanceTo.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					int id = Integer.parseInt(JOptionPane
							.showInputDialog("Enter the objects id: "));
					int distance = Integer.parseInt(JOptionPane
							.showInputDialog("Enter the distance to the object must be greater than: "));
					GUIHandler.addCondition(new DistanceToObjectIDConditional(
							id, distance));
				}
				catch (NumberFormatException ex)
				{
					JOptionPane.showInternalMessageDialog(null,
							"Please only enter numbers");
				}
			}
		});
		mnIds.add(mntmIfDistanceTo);

		JMenuItem mntmIfObjectx = new JMenuItem(
				"If object [x] is on screen (ID)");
		mntmIfObjectx.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					int id = Integer.parseInt(JOptionPane
							.showInputDialog("Enter the objects id: "));
					GUIHandler.addCondition(new ObjectIsOnScreenIDConditional(
							id));
				}
				catch (NumberFormatException ex)
				{
					JOptionPane.showInternalMessageDialog(null,
							"Please only enter numbers");
				}
			}
		});
		mnIds.add(mntmIfObjectx);

		JMenuItem mntmIfObjectx_1 = new JMenuItem(
				"If object [x] is not on screen (ID)");
		mntmIfObjectx_1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					int id = Integer.parseInt(JOptionPane
							.showInputDialog("Enter the objects id: "));
					GUIHandler
							.addCondition(new ObjectisNotOnScreenIDConditional(
									id));
				}
				catch (NumberFormatException ex)
				{
					JOptionPane.showInternalMessageDialog(null,
							"Please only enter numbers");
				}
			}
		});
		mnIds.add(mntmIfObjectx_1);

		JMenuItem mntmIfObjectx_2 = new JMenuItem("If object [x] exists (ID)");
		mntmIfObjectx_2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					int id = Integer.parseInt(JOptionPane
							.showInputDialog("Enter the objects id: "));
					GUIHandler.addCondition(new ObjectIsValidIDConditional(id));
				}
				catch (NumberFormatException ex)
				{
					JOptionPane.showInternalMessageDialog(null,
							"Please only enter numbers");
				}
			}
		});
		mnIds.add(mntmIfObjectx_2);

		JMenuItem mntmIfObjectx_4 = new JMenuItem(
				"If object [x] doesn't exist (ID)");
		mntmIfObjectx_4.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int id = Integer.parseInt(JOptionPane
						.showInputDialog("Enter Object id"));
				GUIHandler.addCondition(new ObjectIsNotValidIDConditional(id));
			}
		});
		mnIds.add(mntmIfObjectx_4);

		// end Conditionals for Objects

		JMenu mntmNewMenuItem = new JMenu("Location");
		mnNewMenu.add(mntmNewMenuItem);

		JMenuItem mntmDistanceTo = new JMenuItem(
				"Distance to [...] is greater than");
		mntmDistanceTo.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int x = Integer.parseInt(JOptionPane.showInputDialog(
						"Enter tile x").replaceAll("[^0-9]", ""));
				int y = Integer.parseInt(JOptionPane.showInputDialog(
						"Enter tile y").replaceAll("[^0-9]", ""));
				int distance = Integer.parseInt(JOptionPane.showInputDialog(
						"Enter distance").replaceAll("[^0-9]", ""));
				GUIHandler.addCondition(new DistanceToIsGreaterConditional(
						distance, new CustomTile(x, y)));
			}
		});
		mntmNewMenuItem.add(mntmDistanceTo);

		JMenuItem mntmDistanceTo_1 = new JMenuItem(
				"Distance to [...] is less than");
		mntmDistanceTo_1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int x = Integer.parseInt(JOptionPane.showInputDialog(
						"Enter tile x").replaceAll("[^0-9]", ""));
				int y = Integer.parseInt(JOptionPane.showInputDialog(
						"Enter tile y").replaceAll("[^0-9]", ""));
				int distance = Integer.parseInt(JOptionPane.showInputDialog(
						"Enter distance").replaceAll("[^0-9]", ""));
				GUIHandler.addCondition(new DistanceToIsLessThanConditional(
						distance, new CustomTile(x, y)));
			}
		});
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
						"Enter animation id").replaceAll("[^0-9-]", ""));
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

		JMenu mnNames_2 = new JMenu("Names");
		mnNpcs.add(mnNames_2);

		JMenuItem mntmNearestNpcx = new JMenuItem(
				"Nearest NPC [x] is on screen");
		mnNames_2.add(mntmNearestNpcx);

		JMenuItem mntmNearestNpcx_3 = new JMenuItem(
				"Nearest NPC [x] is not on screen");
		mnNames_2.add(mntmNearestNpcx_3);

		JMenuItem mntmDistanceToNearest = new JMenuItem(
				"Distance to nearest NPC [x] < [y]");
		mnNames_2.add(mntmDistanceToNearest);

		JMenuItem mntmDistanceToNearest_1 = new JMenuItem(
				"Distance to nearest NPC [x] > [y]");
		mnNames_2.add(mntmDistanceToNearest_1);

		JMenuItem mntmNearestNpcx_1 = new JMenuItem(
				"Nearest NPC [x] is in combat");
		mnNames_2.add(mntmNearestNpcx_1);

		JMenuItem mntmNearestNpcx_2 = new JMenuItem(
				"Nearest NPC [x] is not in combat");
		mnNames_2.add(mntmNearestNpcx_2);

		JMenuItem mntmNearestNpcxs = new JMenuItem("Nearest NPC [x]'s HP < [y]");
		mnNames_2.add(mntmNearestNpcxs);

		JMenuItem mntmNpcxExists = new JMenuItem("NPC [x] exists");
		mnNames_2.add(mntmNpcxExists);

		JMenu mnIds_2 = new JMenu("IDs");
		mnNpcs.add(mnIds_2);

		JMenuItem mntmNearestNpcx_4 = new JMenuItem(
				"Nearest NPC [x] is on screen");
		mntmNearestNpcx_4.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int id = Integer.parseInt(JOptionPane.showInputDialog(
						"Enter NPC id").replaceAll("[^0-9]", ""));
				GUIHandler.addCondition(new NPCIsOnScreenIDConditional(id));
			}
		});
		mnIds_2.add(mntmNearestNpcx_4);

		JMenuItem mntmNearestNpcx_5 = new JMenuItem(
				"Nearest NPC [x] is not on screen");
		mntmNearestNpcx_5.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int id = Integer.parseInt(JOptionPane.showInputDialog(
						"Enter NPC id").replaceAll("[^0-9]", ""));
				GUIHandler.addCondition(new NPCIsNotOnScreenIDConditional(id));
			}
		});
		mnIds_2.add(mntmNearestNpcx_5);

		JMenuItem mntmDistanceToNearest_2 = new JMenuItem(
				"Distance to nearest NPC [x] < [y]");
		mntmDistanceToNearest_2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int id = Integer.parseInt(JOptionPane.showInputDialog(
						"Enter NPC id").replaceAll("[^0-9]", ""));
				int dis = Integer.parseInt(JOptionPane.showInputDialog(
						"Enter distance").replaceAll("[^0-9]", ""));
				GUIHandler
						.addCondition(new DistanceToNearestNPCIsLessIDConditional(
								id, dis));
			}
		});
		mnIds_2.add(mntmDistanceToNearest_2);

		JMenuItem mntmDistanceToNearest_3 = new JMenuItem(
				"Distance to nearest NPC [x] > [y]");
		mntmDistanceToNearest_3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int id = Integer.parseInt(JOptionPane.showInputDialog(
						"Enter NPC id").replaceAll("[^0-9]", ""));
				int dis = Integer.parseInt(JOptionPane.showInputDialog(
						"Enter distance").replaceAll("[^0-9]", ""));
				GUIHandler
						.addCondition(new DistanceToNearestNPCIsGreaterThanIDConditional(
								id, dis));
			}
		});
		mnIds_2.add(mntmDistanceToNearest_3);

		JMenuItem mntmNearestNpcx_6 = new JMenuItem(
				"Nearest NPC [x] is in combat");
		mntmNearestNpcx_6.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int id = Integer.parseInt(JOptionPane.showInputDialog(
						"Enter NPC id").replaceAll("[^0-9]", ""));
				GUIHandler.addCondition(new NPCIsInCombatIDConditional(id));
			}
		});
		mnIds_2.add(mntmNearestNpcx_6);

		JMenuItem mntmNearestNpcx_7 = new JMenuItem(
				"Nearest NPC [x] is not in combat");
		mntmNearestNpcx_7.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int id = Integer.parseInt(JOptionPane.showInputDialog(
						"Enter NPC id").replaceAll("[^0-9]", ""));
				GUIHandler.addCondition(new NPCIsNotInCombatIDConditional(id));
			}
		});
		mnIds_2.add(mntmNearestNpcx_7);

		JMenuItem mntmNearestNpcx_8 = new JMenuItem(
				"Nearest NPC [x]'s HP  < [y]");
		mntmNearestNpcx_8.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int id = Integer.parseInt(JOptionPane.showInputDialog(
						"Enter NPC id").replaceAll("[^0-9]", ""));
				int hp = Integer.parseInt(JOptionPane.showInputDialog(
						"Enter HP").replaceAll("[^0-9]", ""));
				GUIHandler
						.addCondition(new NPCHPPercentIsLessThanIDConditional(
								id, hp));
			}
		});
		mnIds_2.add(mntmNearestNpcx_8);

		JMenuItem mntmNpcxExists_1 = new JMenuItem("NPC [x] exists");
		mntmNpcxExists_1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int id = Integer.parseInt(JOptionPane.showInputDialog(
						"Enter NPC id").replaceAll("[^0-9]", ""));
				GUIHandler.addCondition(new NPCIsValidIDConditional(id));
			}
		});
		mnIds_2.add(mntmNpcxExists_1);
		mntmNpcxExists.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String name = JOptionPane.showInputDialog("Enter NPC name");
				GUIHandler.addCondition(new NPCIsValidConditional(name));
			}
		});
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
		mntmNearestNpcx_2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String name = JOptionPane.showInputDialog("Enter NPC name");
				GUIHandler.addCondition(new NPCIsNotInCombatConditional(name));
			}
		});
		mntmNearestNpcx_1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String name = JOptionPane.showInputDialog("Enter NPC name");
				GUIHandler.addCondition(new NPCIsInCombatConditional(name));
			}
		});
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
		mntmNearestNpcx_3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String name = JOptionPane.showInputDialog("Enter NPC name");
				GUIHandler.addCondition(new NPCIsNotOnScreenConditional(name));
			}
		});
		mntmNearestNpcx.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String name = JOptionPane.showInputDialog("Enter NPC name");
				GUIHandler.addCondition(new NPCIsOnScreenConditional(name));
			}
		});

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

		JMenu mnInterfaces = new JMenu("Interfaces");
		mnNewMenu.add(mnInterfaces);

		JMenuItem mntmInterfaceIsOpen = new JMenuItem("Interface is open");
		mntmInterfaceIsOpen.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int parent = Integer.parseInt(JOptionPane.showInputDialog(
						"Enter parent ID").replaceAll("[^0-9]", ""));
				GUIHandler.addCondition(new InterfaceIsOpenConditional(parent));
			}
		});
		mnInterfaces.add(mntmInterfaceIsOpen);

		JMenuItem mntmInterfaceIsClosed = new JMenuItem("Interface is closed");
		mntmInterfaceIsClosed.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int parent = Integer.parseInt(JOptionPane.showInputDialog(
						"Enter parent ID").replaceAll("[^0-9]", ""));
				GUIHandler
						.addCondition(new InterfaceIsClosedConditional(parent));
			}
		});
		mnInterfaces.add(mntmInterfaceIsClosed);

		JMenu mnOtherPlayers = new JMenu("Other Players");
		mnNewMenu.add(mnOtherPlayers);

		JMenuItem mntmAtLeastx = new JMenuItem(
				"at least [x] players are around");
		mntmAtLeastx.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				int amount = Integer.parseInt(JOptionPane.showInputDialog(
						"Enter amount that should be around").replaceAll(
						"[^0-9]", ""));
				GUIHandler.addCondition(new RSPlayerCountConditional(amount));

			}
		});
		mnOtherPlayers.add(mntmAtLeastx);

		JMenuItem mntmPlayerxIs_1 = new JMenuItem("Player [x] is on screen");
		mntmPlayerxIs_1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String name = JOptionPane.showInputDialog("Enter players name");
				GUIHandler
						.addCondition(new RSPlayerIsOnScreenConditional(name));
			}
		});
		mnOtherPlayers.add(mntmPlayerxIs_1);

		JMenuItem mntmPlayerxIs = new JMenuItem("Player [x] is not on screen");
		mntmPlayerxIs.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String name = JOptionPane.showInputDialog("Enter players name");
				GUIHandler.addCondition(new RSPlayerIsNotOnScreenConditional(
						name));
			}
		});
		mnOtherPlayers.add(mntmPlayerxIs);

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

		JMenuItem mntmEndScript = new JMenuItem("End Script");
		mntmEndScript.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				GUIHandler.setAction(new EndScriptAction());
			}
		});
		mnGeneral.add(mntmEndScript);
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

		JMenu mnNames_1 = new JMenu("Names");
		mntmObjects_1.add(mnNames_1);

		JMenuItem mntmClickNearestObject = new JMenuItem(
				"Click nearest object [x] with action [y] (Name)");
		mnNames_1.add(mntmClickNearestObject);

		JMenuItem mntmMoveMouseTo = new JMenuItem(
				"Move mouse to object [x] (Name)");
		mnNames_1.add(mntmMoveMouseTo);

		JMenuItem mntmTurnCameraTo = new JMenuItem(
				"Turn camera to object [x] (Name)");
		mnNames_1.add(mntmTurnCameraTo);

		JMenuItem mntmWalkToNearest = new JMenuItem(
				"Walk to nearest object [x] (Name)");
		mnNames_1.add(mntmWalkToNearest);

		JMenu mnIds_1 = new JMenu("IDs");
		mntmObjects_1.add(mnIds_1);

		JMenuItem mntmClickNearestObject_1 = new JMenuItem(
				"Click nearest object [x] with the action [y] (ID)");
		mntmClickNearestObject_1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int id = Integer.parseInt(JOptionPane
						.showInputDialog("Enter object id"));
				String action = JOptionPane.showInputDialog("Enter action");
				GUIHandler.setAction(new ClickObjectIDAction(id, action));
			}
		});
		mnIds_1.add(mntmClickNearestObject_1);

		JMenuItem mntmClickNearest = new JMenuItem(
				"Move mouse to object [x] (ID)");
		mntmClickNearest.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int id = Integer.parseInt(JOptionPane
						.showInputDialog("Enter object id"));
				GUIHandler.setAction(new MoveMouseToObjectIDAction(id));
			}
		});
		mnIds_1.add(mntmClickNearest);

		JMenuItem mntmTurnCameraTo_2 = new JMenuItem(
				"Turn camera to object [x] (ID)");
		mntmTurnCameraTo_2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int id = Integer.parseInt(JOptionPane
						.showInputDialog("Enter object id"));
				GUIHandler.setAction(new TurnToObjectIDAction(id));
			}
		});
		mnIds_1.add(mntmTurnCameraTo_2);

		JMenuItem mntmWalkToNearest_1 = new JMenuItem(
				"Walk to nearest object [x] (ID)");
		mntmWalkToNearest_1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int id = Integer.parseInt(JOptionPane
						.showInputDialog("Enter object id"));
				GUIHandler.setAction(new WalkToObjectIDAction(id));
			}
		});
		mnIds_1.add(mntmWalkToNearest_1);
		mntmWalkToNearest.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String name = JOptionPane.showInputDialog("Enter object name");
				GUIHandler.setAction(new WalkToObjectAction(name));
			}
		});
		mntmTurnCameraTo.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String name = JOptionPane.showInputDialog("Enter object name");
				GUIHandler.setAction(new TurnToObjectAction(name));
			}
		});
		mntmMoveMouseTo.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String name = JOptionPane.showInputDialog("Enter object name");
				GUIHandler.setAction(new MoveMouseToObject(name));
			}
		});
		mntmClickNearestObject.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String name = JOptionPane.showInputDialog("Enter object name");
				String action = JOptionPane.showInputDialog("Enter action");
				GUIHandler.setAction(new ClickObjectAction(name, action));
			}
		});

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
						.replaceAll("[^0-9-]", ""))) != -1)
				{
					list.add(x);
				}
				GUIHandler.setAction(new LootAllItemsAction(list
						.toArray(new Integer[list.size()])));

			}
		});
		mnGroundItems_1.add(mntmLootAllItems);

		JMenu mnNewMenu_1 = new JMenu("Other Players");
		mnAddAction.add(mnNewMenu_1);

		JMenuItem mntmClickNearestPlayer = new JMenuItem(
				"Click nearest player with the action [x]");
		mntmClickNearestPlayer.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String action = JOptionPane
						.showInputDialog("Enter the action to click with");
				GUIHandler.setAction(new ClickNearestPlayerWithAction(action));
			}
		});
		mnNewMenu_1.add(mntmClickNearestPlayer);

		JMenuItem mntmTurnToPlayer = new JMenuItem("Turn to Player [x]");
		mntmTurnToPlayer.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String name = JOptionPane
						.showInputDialog("Enter name of player");
				GUIHandler.setAction(new RSPlayerTurnToAction(name));
			}
		});
		mnNewMenu_1.add(mntmTurnToPlayer);

		JMenuItem mntmClickPlayerx = new JMenuItem(
				"Click Player [x] with the action [y]");
		mntmClickPlayerx.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String name = JOptionPane
						.showInputDialog("Enter name of player");
				String action = JOptionPane.showInputDialog("Enter action");
				GUIHandler.setAction(new RSPlayerClickAction(name, action));
			}
		});
		mnNewMenu_1.add(mntmClickPlayerx);

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

		JMenuItem mntmAWalkTo = new JMenuItem("A* walk to tile");
		mntmAWalkTo.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int x = Integer.parseInt(JOptionPane.showInputDialog(
						"Enter x coordinate").replaceAll("[^0-9]", ""));
				int y = Integer.parseInt(JOptionPane.showInputDialog(
						"Enter y coordinate").replaceAll("[^0-9]", ""));
				GUIHandler.setAction(new AStarWalkAction(new CustomTile(x, y)));
			}
		});
		mntmWalking.add(mntmAWalkTo);
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
				double timeout = Double.parseDouble(JOptionPane
						.showInputDialog("Enter a timeout in seconds")
						.replaceAll("[^0-9.]", ""));
				GUIHandler.setAction(new WaitUntilBankIsOpenAction(
						(long) (timeout * 1000)));
			}
		});
		mntmBanking.add(mntmWaitUntilBank);

		JMenu mntmNpcs = new JMenu("NPCs");
		mnAddAction.add(mntmNpcs);

		JMenu mnNames_3 = new JMenu("Names");
		mntmNpcs.add(mnNames_3);

		JMenuItem mntmClickNpcx = new JMenuItem(
				"Click NPC [x] with the action [y]");
		mnNames_3.add(mntmClickNpcx);

		JMenuItem mntmWalkToNpc = new JMenuItem("Walk to NPC [x]");
		mnNames_3.add(mntmWalkToNpc);

		JMenuItem mntmTurnCameraTo_1 = new JMenuItem("Turn camera to NPC [x]");
		mnNames_3.add(mntmTurnCameraTo_1);
		mntmTurnCameraTo_1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String name = JOptionPane.showInputDialog("Enter NPC name");
				GUIHandler.setAction(new TurnCameraToNPCAction(name));
			}
		});
		mntmWalkToNpc.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String name = JOptionPane.showInputDialog("Enter NPC name");
				GUIHandler.setAction(new WalkToNearestNPCAction(name));
			}
		});
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

		JMenu mnIds_3 = new JMenu("IDs");
		mntmNpcs.add(mnIds_3);

		JMenuItem mntmClickNpcx_1 = new JMenuItem(
				"Click NPC [x] with the action [y]");
		mntmClickNpcx_1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int id = Integer.parseInt(JOptionPane.showInputDialog(
						"Enter NPC id").replaceAll("[^0-9]", "'"));
				String option = JOptionPane
						.showInputDialog("Enter the option to click the NPC with (be exact)");
				GUIHandler.setAction(new ClickNPCIDAction(id, option));
			}
		});
		mnIds_3.add(mntmClickNpcx_1);

		JMenuItem mntmWalkToNpc_1 = new JMenuItem("Walk to NPC [x]");
		mntmWalkToNpc_1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int id = Integer.parseInt(JOptionPane.showInputDialog(
						"Enter NPC id").replaceAll("[^0-9]", "'"));
				GUIHandler.setAction(new WalkToNearestNPCIDAction(id));
			}
		});
		mnIds_3.add(mntmWalkToNpc_1);

		JMenuItem mntmTurnCameraTo_3 = new JMenuItem("Turn camera to NPC [x]");
		mntmTurnCameraTo_3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int id = Integer.parseInt(JOptionPane.showInputDialog(
						"Enter NPC id").replaceAll("[^0-9]", "'"));
				GUIHandler.setAction(new TurnCameraToNPCIDAction(id));
			}
		});
		mnIds_3.add(mntmTurnCameraTo_3);

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

		JMenu mnCamera = new JMenu("Camera");
		mnAddAction.add(mnCamera);

		JMenuItem mntmSetCameraAngle = new JMenuItem("Set Camera Angle");
		mntmSetCameraAngle.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				int angle = Integer.parseInt(JOptionPane.showInputDialog(null,
						"Enter angle to set the camera to").replaceAll(
						"[^0-9]", ""));
				GUIHandler.setAction(new CameraAngleAction(angle));

			}
		});
		mnCamera.add(mntmSetCameraAngle);

		JMenuItem mntmSetCameraRotation = new JMenuItem("Set Camera Rotation");
		mntmSetCameraRotation.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int angle = Integer.parseInt(JOptionPane.showInputDialog(null,
						"Enter rotation to set the camera to").replaceAll(
						"[^0-9]", ""));
				GUIHandler.setAction(new CameraRotationAction(angle));
			}
		});
		mnCamera.add(mntmSetCameraRotation);

		JMenu mousePop = new JMenu("Mouse");
		mnAddAction.add(mousePop);

		JMenu mnInterfaces_1 = new JMenu("Interfaces");
		mnAddAction.add(mnInterfaces_1);

		JMenuItem mntmWaitUntilInterface = new JMenuItem(
				"Wait until interface is open");
		mntmWaitUntilInterface.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int parent = Integer.parseInt(JOptionPane.showInputDialog(null,
						"Enter parent id").replaceAll("[^0-9]", ""));
				double timeout = Double.parseDouble(JOptionPane
						.showInputDialog(null, "Enter timeout in seconds")
						.replaceAll("[^0-9.]", ""));
				GUIHandler.setAction(new WaitUntilInterfaceIsOpenAction(parent,
						(long) (timeout * 1000)));
			}
		});
		mnInterfaces_1.add(mntmWaitUntilInterface);

		JMenuItem mntmWaitUntilInterface_1 = new JMenuItem(
				"Wait until interface is closed");
		mntmWaitUntilInterface_1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int parent = Integer.parseInt(JOptionPane.showInputDialog(null,
						"Enter parent id").replaceAll("[^0-9]", ""));
				double timeout = Double.parseDouble(JOptionPane
						.showInputDialog(null, "Enter timeout in seconds")
						.replaceAll("[^0-9.]", ""));
				GUIHandler.setAction(new WaitUntilInterfaceIsClosedAction(
						parent, (long) (timeout * 1000)));
			}
		});
		mnInterfaces_1.add(mntmWaitUntilInterface_1);

		JMenuItem mntmClickInterfacexy = new JMenuItem(
				"Click interface [x][y] with the action [z]");
		mntmClickInterfacexy.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int parent = Integer.parseInt(JOptionPane.showInputDialog(null,
						"Enter parent id").replaceAll("[^0-9]", ""));
				int child = Integer.parseInt(JOptionPane.showInputDialog(null,
						"Enter child id").replaceAll("[^0-9]", ""));
				String action = JOptionPane.showInputDialog(null,
						"Enter action");
				GUIHandler.setAction(new ClickInterfaceAction(parent, child,
						action));
			}
		});
		mnInterfaces_1.add(mntmClickInterfacexy);

		JMenu mnWorldHopping = new JMenu("World Hopping");
		mnAddAction.add(mnWorldHopping);

		JMenuItem mntmHopToWorld = new JMenuItem("Hop to World [x]");
		mntmHopToWorld.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int world = Integer.parseInt(JOptionPane.showInputDialog(null,
						"Enter world").replaceAll("[^0-9]", ""));
				GUIHandler.setAction(new HopToWorldAction(world));
			}
		});
		mnWorldHopping.add(mntmHopToWorld);

		JMenuItem mntmHopToRandom = new JMenuItem("Hop to random world");
		mntmHopToRandom.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				GUIHandler.setAction(new HopToRandomWorldAction());
			}
		});
		mnWorldHopping.add(mntmHopToRandom);

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

		JMenu mnRightClickMenu = new JMenu("Right Click Menu");
		mousePop.add(mnRightClickMenu);

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

		JMenuItem mntmMoveMouseTo_1 = new JMenuItem("Move mouse to point");
		mntmMoveMouseTo_1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int x = Integer.parseInt(JOptionPane
						.showInputDialog("Enter x coordinate"));
				int y = Integer.parseInt(JOptionPane
						.showInputDialog("Enter y coordinate"));
				GUIHandler.setAction(new MousePointAction(new Point(x, y)));
			}
		});
		mousePop.add(mntmMoveMouseTo_1);

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
				}
				catch (NumberFormatException ex)
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
				}
				catch (NumberFormatException ex)
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
				}
				catch (NumberFormatException ex)
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
				if (GUIHandler.isCreating)
					return;
				GUIHandler.setIndex(indexTemp);
			}
		});

		JMenuItem removeRight = new JMenuItem("Remove");
		final JMenuItem removeLastConditional = new JMenuItem(
				"Remove last conditional");
		removeLastConditional.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				GUIHandler.removeLastCondition();
				menu.remove(removeLastConditional);
			}
		});
		menu.add(removeRight);
		menu.add(insert);
		removeRight.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				if (indexTemp == -1)
					return;
				if (GUIHandler.isCreating)
				{
					GUIHandler.removeCurrentBuilder();
					GUIHandler.resetAll();
				}
				else
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
					indexTemp = list.locationToIndex(arg0.getPoint());
					if (GUIHandler.isCreating)
						menu.add(removeLastConditional);
					menu.show(list, arg0.getX(), arg0.getY());
				}
			}
		});
		scrollPane.setViewportView(list);
		fillList();
		GUIHandler.setIndex(listModel.size());
	}
}
