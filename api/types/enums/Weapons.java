package scripts.ScriptMaker.api.types.enums;

public class Weapons {
	public enum Degradables {
		//ADD as we go
        GuthanWarspear(new int[] {4726,4910,4911,4912,4913}, 4914);
        
        private int[] id;
        private int Degraded;
        private Degradables(int[] id, int Degraded) {
                this.id = id;
                this.Degraded = Degraded;
        }
        
		public int[] getId() {
			return id;
		}
		
		public Equipment.Gear getGear() {
			return Equipment.Gear.WEAPON;
		}
		
		public int getDegraded() {
			return Degraded;
		}
	}
	
	public enum Gear {
		None(new int[] {-1},-1,-1,-1),
        AbyssalWhip(new int[] {4151}, 4, 1658, 100),
        DragonScimitar(new int[]{4587}, 4, 390, 55),
        DragonBattleAxe(new int[] {1377}, 6, 395, 100),
        RuneScimitar(new int[]{1333}, 4, 390, -1),
        Excaliber(new int[]{35}, 5, 390, 100),
        Dragon2hSword(new int[]{7158}, 6, 407, 60),
        DragonDagger(new int[]{1215,1231,5680,5698}, 4, 376, 25),
        DragonLongsword(new int[] {1305}, 5, -1, 25),
		MagicShortbow(new int[] {861}, 4, -1, 55);
        private int[] id;
        private int attackSpeed;
        private int animation;
        private int specialUsed;
        private Gear(int[] id, int attackSpeed, int animation, int specialUsed) {
                this.id = id;
                this.attackSpeed = attackSpeed;
                this.animation = animation;
                this.specialUsed = specialUsed;  
        }
        
		public int[] getId() {
			return id;
		}
		
		public int getAttackSpeed() {
			return attackSpeed;
		}
		
		public int getAnimation() {
			return animation;
		}
		
		public int specialUsed() {
			return specialUsed;
		}
	}
}
