package scripts.ScriptMaker.api.methods;

import java.awt.Color;

import org.tribot.api.General;
import org.tribot.api.input.Mouse;
import org.tribot.api2007.Login;
import org.tribot.api2007.Screen;

import scripts.ScriptMaker.main.Main;

public class WorldHopping
{

    Main m;

    public WorldHopping(Main m)
    {
	this.m = m;
    }

    public boolean hop(int world)
    {
	m.setLoginBotState(false);
	if ((Login.getLoginState().equals(Login.STATE.INGAME))
		&& (Login.logout()))
	{
	    if (world == -1)
		switchWorld(General.random(1, 78));
	    else
		switchWorld(world);

	    if (!Login.login())
	    {
		m.setLoginBotState(true);
		return false;
	    }
	    m.setLoginBotState(true);
	    return true;
	} else if (!Login.getLoginState().equals(Login.STATE.INGAME)
		&& !isNewUserOpen())
	{
	    if (world == -1)
		switchWorld(General.random(1, 78));
	    else
		switchWorld(world);
	    if (!Login.login())
	    {
		m.setLoginBotState(true);
		return false;
	    }
	    m.setLoginBotState(true);
	    return true;
	}
	return false;
    }

    private boolean isWorldSelectOpen()
    {
	if (Login.getLoginState() == Login.STATE.LOGINSCREEN)
	{
	    Color tmpC = Screen.getColorAt(100, 200);
	    if ((tmpC.getBlue() == 0) && (tmpC.getRed() == 0)
		    && (tmpC.getGreen() == 0))
		return true;
	}
	return false;
    }

    private boolean isNewUserOpen()
    {
	if (Login.getLoginState() == Login.STATE.LOGINSCREEN)
	{
	    Color tmpC = Screen.getColorAt(379, 321);
	    if ((tmpC.getBlue() == 255) && (tmpC.getRed() == 255)
		    && (tmpC.getGreen() == 255))
	    {
		Mouse.click(General.random(320, 440), General.random(308, 335),
			1);
		return true;
	    }
	}
	return false;
    }

    private boolean openWorldSelect()
    {
	if (Login.getLoginState() == Login.STATE.LOGINSCREEN)
	{
	    Mouse.clickBox(10, 465, 100, 495, 0);
	    General.sleep(500, 1000);
	    if (isWorldSelectOpen())
		return true;
	}
	return false;
    }

    private boolean switchWorld(int world)
    {
	if (!isWorldSelectOpen())
	{
	    openWorldSelect();
	}
	if ((world == 1) || (world == 2) || (world == 6) || (world == 9)
		|| (world == 8) || (world == 16))
	{
	    return false;
	}
	int xCoord = 0;
	int yCoord = 0;

	switch (world)
	{
	case 1:
	    yCoord = 83;
	    xCoord = 248;
	    break;
	case 2:
	    yCoord = 107;
	    xCoord = 248;
	    break;
	case 3:
	    yCoord = 131;
	    xCoord = 248;
	    break;
	case 4:
	    yCoord = 155;
	    xCoord = 248;
	    break;
	case 5:
	    yCoord = 179;
	    xCoord = 248;
	    break;
	case 6:
	    yCoord = 203;
	    xCoord = 248;
	    break;
	case 8:
	    yCoord = 227;
	    xCoord = 248;
	    break;
	case 9:
	    yCoord = 251;
	    xCoord = 248;
	    break;
	case 10:
	    yCoord = 275;
	    xCoord = 248;
	    break;
	case 11:
	    yCoord = 299;
	    xCoord = 248;
	    break;
	case 12:
	    yCoord = 323;
	    xCoord = 248;
	    break;
	case 13:
	    yCoord = 347;
	    xCoord = 248;
	    break;
	case 14:
	    yCoord = 371;
	    xCoord = 248;
	    break;
	case 16:
	    yCoord = 395;
	    xCoord = 248;
	    break;
	case 17:
	    yCoord = 419;
	    xCoord = 248;
	    break;
	case 18:
	    yCoord = 443;
	    xCoord = 248;
	    break;

	case 19:
	    yCoord = 107;
	    xCoord = 340;
	    break;
	case 20:
	    yCoord = 131;
	    xCoord = 340;
	    break;
	case 21:
	    yCoord = 155;
	    xCoord = 340;
	    break;
	case 22:
	    yCoord = 179;
	    xCoord = 340;
	    break;
	case 25:
	    yCoord = 203;
	    xCoord = 340;
	    break;
	case 26:
	    yCoord = 227;
	    xCoord = 340;
	    break;
	case 27:
	    yCoord = 251;
	    xCoord = 340;
	    break;
	case 28:
	    yCoord = 275;
	    xCoord = 340;
	    break;
	case 29:
	    yCoord = 299;
	    xCoord = 340;
	    break;
	case 30:
	    yCoord = 323;
	    xCoord = 340;
	    break;
	case 33:
	    yCoord = 347;
	    xCoord = 340;
	    break;
	case 34:
	    yCoord = 371;
	    xCoord = 340;
	    break;
	case 35:
	    yCoord = 395;
	    xCoord = 340;
	    break;
	case 36:
	    yCoord = 419;
	    xCoord = 340;
	    break;
	case 37:
	    yCoord = 443;
	    xCoord = 340;
	    break;
	case 38:
	    yCoord = 467;
	    xCoord = 340;
	    break;
	case 41:
	    yCoord = 83;
	    xCoord = 430;
	    break;
	case 42:
	    yCoord = 107;
	    xCoord = 430;
	    break;
	case 43:
	    yCoord = 131;
	    xCoord = 430;
	    break;
	case 44:
	    yCoord = 155;
	    xCoord = 430;
	    break;
	case 45:
	    yCoord = 179;
	    xCoord = 430;
	    break;
	case 46:
	    yCoord = 203;
	    xCoord = 430;
	    break;
	case 49:
	    yCoord = 227;
	    xCoord = 430;
	    break;
	case 50:
	    yCoord = 251;
	    xCoord = 430;
	    break;
	case 51:
	    yCoord = 275;
	    xCoord = 430;
	    break;
	case 52:
	    yCoord = 299;
	    xCoord = 430;
	    break;
	case 53:
	    yCoord = 323;
	    xCoord = 430;
	    break;
	case 54:
	    yCoord = 347;
	    xCoord = 430;
	    break;
	case 57:
	    yCoord = 371;
	    xCoord = 430;
	    break;
	case 58:
	    yCoord = 395;
	    xCoord = 430;
	    break;
	case 59:
	    yCoord = 419;
	    xCoord = 430;
	    break;
	case 60:
	    yCoord = 443;
	    xCoord = 430;
	    break;

	case 61:
	    yCoord = 83;
	    xCoord = 523;
	    break;
	case 62:
	    yCoord = 107;
	    xCoord = 523;
	    break;
	case 65:
	    yCoord = 131;
	    xCoord = 523;
	    break;
	case 66:
	    yCoord = 155;
	    xCoord = 523;
	    break;
	case 67:
	    yCoord = 179;
	    xCoord = 523;
	    break;
	case 68:
	    yCoord = 203;
	    xCoord = 523;
	    break;
	case 69:
	    yCoord = 227;
	    xCoord = 523;
	    break;
	case 70:
	    yCoord = 251;
	    xCoord = 523;
	    break;
	case 73:
	    yCoord = 275;
	    xCoord = 523;
	    break;
	case 74:
	    yCoord = 299;
	    xCoord = 523;
	    break;
	case 75:
	    yCoord = 323;
	    xCoord = 523;
	    break;
	case 76:
	    yCoord = 347;
	    xCoord = 523;
	    break;
	case 77:
	    yCoord = 371;
	    xCoord = 523;
	    break;
	case 78:
	    yCoord = 395;
	    xCoord = 523;
	    break;
	case 7:
	    switchWorld(General.random(1, 78));
	    break;
	case 15:
	    switchWorld(General.random(1, 78));
	    break;
	case 23:
	    switchWorld(General.random(1, 78));
	    break;
	case 24:
	    switchWorld(General.random(1, 78));
	    break;
	case 31:
	    switchWorld(General.random(1, 78));
	    break;
	case 32:
	    switchWorld(General.random(1, 78));
	    break;
	case 39:
	    switchWorld(General.random(1, 78));
	    break;
	case 40:
	    switchWorld(General.random(1, 78));
	    break;
	case 47:
	    switchWorld(General.random(1, 78));
	    break;
	case 48:
	    switchWorld(General.random(1, 78));
	    break;
	case 55:
	    switchWorld(General.random(1, 78));
	    break;
	case 56:
	    switchWorld(General.random(1, 78));
	    break;
	case 63:
	    switchWorld(General.random(1, 78));
	    break;
	case 64:
	    switchWorld(General.random(1, 78));
	    break;
	case 71:
	    switchWorld(General.random(1, 78));
	    break;
	case 72:
	    switchWorld(General.random(1, 78));
	    break;
	default:
	    switchWorld(General.random(1, 78));
	}

	Mouse.clickBox(xCoord, yCoord, xCoord + General.random(-5, 5), yCoord
		+ General.random(-5, 5), 0);
	General.sleep(500, 1000);
	if (isWorldSelectOpen())
	{
	    return true;
	}
	return false;
    }
}
