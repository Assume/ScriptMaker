package scripts.ScriptMaker.api.types.intent.camera;

import org.tribot.api2007.Camera;

import scripts.ScriptMaker.api.types.main.Action;

public class CameraAngleAction extends Action
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
