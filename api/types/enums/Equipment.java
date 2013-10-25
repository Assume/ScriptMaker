package scripts.ScriptMaker.api.types.enums;

import java.awt.event.KeyEvent;
import java.io.Serializable;
import java.util.ArrayList;

import org.tribot.api2007.GameTab.TABS;
import org.tribot.api.input.Keyboard;
import org.tribot.api2007.GameTab;
import org.tribot.api2007.Interfaces;
import org.tribot.api2007.Inventory;
import org.tribot.api2007.types.RSItem;

public class Equipment implements Serializable
{

	private static final long serialVersionUID = -1403025417212242040L;

	public enum Gear implements Serializable
	{
		HELM(0), CAPE(1), NECK(2), WEAPON(3), BODY(4), SHIELD(5), LEGS(7), GLOVES(
						9), BOOTS(10), RING(12), ARROW(13);
		private static final long serialVersionUID = -140302541345345345L;
		private int value;

		private Gear(int value)
		{
			this.value = value;
		}
	}

	public static void equip(int... id)
	{
		if (Inventory.find(id).length > 0)
		{
			Inventory.find(id)[0].click("W");
		}
	}

	public static int getEquipmentID(Gear spot)
	{
		if (Interfaces.get(387, 28) != null)
		{
			for (RSItem i : Interfaces.get(387, 28).getItems())
			{
				if (i.getIndex() == spot.value)
				{
					return i.getID();
				}
			}
		}
		return -1;
	}

	public static ArrayList<Integer> getEquipedSpots()
	{
		ArrayList<Integer> arl = new ArrayList<Integer>();
		for (int spot = 0; spot < 13; spot++)
		{
			if (Interfaces.get(387, 28) != null)
			{
				for (RSItem i : Interfaces.get(387, 28).getItems())
				{
					if (i.getIndex() == spot)
					{
						arl.add(spot);
					}
				}
			}
		}
		return arl;
	}

	public static void unequip(Gear g)
	{
		if (!GameTab.getOpen().equals(TABS.INVENTORY))
		{
			Keyboard.pressKey((char) KeyEvent.VK_ESCAPE);
		}
		if (Interfaces.get(387, g.value) != null)
		{
			Interfaces.get(387, g.value).click("");
		}
	}

	public static void unequipAll()
	{
		ArrayList<Integer> arl = getEquipedSpots();
		ArrayList<Integer> interfaces = new ArrayList<Integer>();
		if (arl.isEmpty())
		{
			return;
		}
		if (!GameTab.getOpen().equals(TABS.EQUIPMENT))
		{
			Keyboard.pressFunctionKey(4);
		}
		for (int a : arl)
		{
			switch (a)
			{
			case 0:
				interfaces.add(12);
				break;
			case 1:
				interfaces.add(13);
				break;
			case 2:
				interfaces.add(14);
				break;
			case 3:
				interfaces.add(16);
				break;
			case 4:
				interfaces.add(17);
				break;
			case 5:
				interfaces.add(18);
				break;
			case 7:
				interfaces.add(19);
				break;
			case 9:
				interfaces.add(21);
				break;
			case 10:
				interfaces.add(20);
				break;
			case 12:
				interfaces.add(22);
				break;
			case 13:
				interfaces.add(15);
				break;
			}
		}
		for (int a : interfaces)
		{
			if (Interfaces.get(387, a) != null)
			{
				Interfaces.get(387, a).click("");
			}
		}
		if (!GameTab.getOpen().equals(TABS.INVENTORY))
		{
			Keyboard.pressKey((char) KeyEvent.VK_ESCAPE);
		}
	}

	public static boolean isGuthanEquiped()
	{
		boolean[] equipCheck = new boolean[4];
		if (isEquiped(Armor.Degradables.GuthanHelm.getId()))
		{
			equipCheck[0] = true;
		}
		if (isEquiped(Armor.Degradables.GuthanBody.getId()))
		{
			equipCheck[1] = true;
		}
		if (isEquiped(Armor.Degradables.GuthanLegs.getId()))
		{
			equipCheck[2] = true;
		}
		if (isEquiped(Weapons.Degradables.GuthanWarspear.getId()))
		{
			equipCheck[3] = true;
		}
		for (boolean b : equipCheck)
			if (!b)
				return false;
		return true;
	}

	public static boolean isEquiped(int id)
	{
		if (Interfaces.get(387, 28) != null)
		{
			for (RSItem i : Interfaces.get(387, 28).getItems())
			{
				if (i.getID() == id)
				{
					return true;
				}
			}
		}
		return false;
	}

	public static boolean isEquiped(int[] id)
	{
		if (Interfaces.get(387, 28) != null)
		{
			for (RSItem i : Interfaces.get(387, 28).getItems())
			{
				for (int a : id)
				{
					if (i.getID() == a)
					{
						return true;
					}
				}
			}
		}
		return false;
	}
}
