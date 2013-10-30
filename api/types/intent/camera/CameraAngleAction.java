package scripts.ScriptMaker.api.types.intent.camera;

import java.io.Serializable;

import org.tribot.api2007.Camera;

import scripts.ScriptMaker.api.types.main.Action;

public class CameraAngleAction extends Action implements Serializable
{
    
    
    private static final long serialVersionUID = -5464640202500844720L;

    private int angle;
    
    public CameraAngleAction(int angle)
    {
	this.angle = angle;
    }
    
    
    @Override
    public boolean run()
    {
	Camera.setCameraAngle(angle);
	return true;
    }
    
    @Override
    public String toString()
    {
	return "Set camera angle to "+angle;
    }

}
