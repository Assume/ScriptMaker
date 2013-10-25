package scripts.ScriptMaker.main;

import java.util.ArrayList;
import java.util.List;

import scripts.ScriptMaker.GUI.MainGUI;
import scripts.ScriptMaker.api.types.block.Block;
import scripts.ScriptMaker.api.types.main.Intent;

public class vars
{

	public static int[] sAttack = new int[2];
	public static int[] sStrength = new int[2];
	public static int[] sDefence = new int[2];
	public static int[] sRange = new int[2];
	public static int[] sMagic = new int[2];
	public static int[] sHitpoints = new int[2];
	public static int[] sSlayer = new int[2];
	public static int savedAttack = 0;
	public static int savedStrength = 0;
	public static int savedDefence = 0;
	public static int savedRange = 0;
	public static int savedMagic = 0;
	public static int savedHitpoints = 0;
	public static int savedSlayer = 0;
	public static int[] duelRing = { 2552, 2554, 2556, 2558, 2560, 2562, 2564, 2566 };
	public static int[] gamesNeck = { 3853, 3855, 3857, 3859, 3861, 3863, 3865, 3867 };
	public static int[] gloryNeck = { 1712, 1710, 1708, 1706, 10354, 10356, 10358,
			10360 };
	public static long runtime;
	public static long startTime;
	public static String status;
	public static boolean scriptRunning = false;
	public static Thread thread;
	public static MainGUI gui;
	public static boolean stop = false;
	public static int lastIndex = 0;
	public static List<Intent> currentIntentList = new ArrayList<Intent>();
	public static Block lastBlock;
	public static Block currentBlock;
	public static boolean builderIsOpen = false;
	public static boolean isMain;
	public static String editName;
	public static boolean isEdit;
}
