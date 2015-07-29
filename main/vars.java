package scripts.ScriptMaker.main;

import java.util.ArrayList;
import java.util.List;

import scripts.ScriptMaker.GUI.MainGUI;
import scripts.ScriptMaker.api.methods.WorldHopping;
import scripts.ScriptMaker.api.types.block.Block;
import scripts.ScriptMaker.api.types.main.Intent;

public class vars {

	public static int[] duelRing = { 2552, 2554, 2556, 2558, 2560, 2562, 2564,
			2566 };
	public static int[] gamesNeck = { 3853, 3855, 3857, 3859, 3861, 3863, 3865,
			3867 };
	public static int[] gloryNeck = { 1712, 1710, 1708, 1706, 10354, 10356,
			10358, 10360 };
	public static long runtime;
	public static long startTime;
	public static String status;
	public static boolean scriptRunning = false;
	public static Thread thread;
	public static MainGUI gui;

	public static int lastIndex = 0;
	public static List<Intent> currentIntentList = new ArrayList<Intent>();
	public static Block lastBlock;
	public static Block currentBlock;
	public static boolean builderIsOpen = false;
	public static boolean isMain;
	public static String editName;
	public static boolean isEdit;

	public static WorldHopping world;

	public static boolean hasHitStart = false;
	public static boolean isLiteMode = false;
	public static String version = "1.3.9_1";
	public static Intent currentIntent;
	public static boolean isHopping;

	public static boolean pause = false;
	public static boolean fullStop = false;
}
