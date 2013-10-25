package scripts.ScriptMaker.api.types.enums;

public class Armor {
	
	static int[] gHelm = {4724,4904,4905,4906,4907} ;
    static int[] gLegs = {4730,4922,4923,4924,4925}; 
	static int[] gBody = {4728,4916,4917,4918,4919};
	
	public enum Degradables {
		//Add as we go
        GuthanHelm(new int[] {4724,4904,4905,4906,4907}, Equipment.Gear.HELM,4908),
        GuthanLegs(new int[] {4730,4922,4923,4924,4925}, Equipment.Gear.LEGS,4926),
		GuthanBody(new int[] {4728,4916,4917,4918,4919}, Equipment.Gear.BODY,4920);
        
        private int[] id;
        private Equipment.Gear gear;
        private int Degraded;
        private Degradables(int[] id, Equipment.Gear gear, int Degraded) {
                this.id = id;
                this.gear = gear;
                this.Degraded = Degraded;
        }
        
		public int[] getId() {
			return id;
		}
		
		public Equipment.Gear getGear() {
			return gear;
		}
		
		public int getDegraded() {
			return Degraded;
		}
	}
	
	public enum Gear {
		
	}

	public static boolean isGuthanDegraded() {
		if (Equipment.isEquiped(Degradables.GuthanBody.getDegraded())) {
			return true;
		}
		if (Equipment.isEquiped(Degradables.GuthanLegs.getDegraded())) {
			return true;
		}
		if (Equipment.isEquiped(Degradables.GuthanHelm.getDegraded())) {
			return true;
		}
		if (Equipment.isEquiped(Weapons.Degradables.GuthanWarspear.getDegraded())) {
			return true;
		}
		return false;
	}
}
