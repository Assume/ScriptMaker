package scripts.ScriptMaker.api.types.intent.camera;

import java.io.Serializable;

import org.tribot.api2007.Camera;

import scripts.ScriptMaker.api.types.main.Action;

public class CameraRotationAction extends Action implements Serializable
{

    private static final long serialVersionUID = -784850328600846716L;

    private int rotation;

    public CameraRotationAction(int rotation)
    {
	this.rotation = rotation;
    }

    @Override
    public boolean run()
    {
	Camera.setCameraRotation(rotation);
	return true;
    }

    @Override
    public String toString()
    {
	return "Set camera rotation to " + rotation;
    }
}
