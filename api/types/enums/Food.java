package scripts.ScriptMaker.api.types.enums;

public class Food {
	public enum Edibles {		
		None(0,0),
		Lobster(379,12),
		BonesToPeaches(6883,8),
		Trout(333,8),
		Salmon(329,8),
		Monkfish(7946,16),
		Shark(385,20),
		Swordfish(373,14),
		Tuna(361,8),
		Kebab(1971,8),
		Karambwan(3144,20),
		Bass(365,8);

		private int Id, healAmount;
		Edibles(final int Id, final int healAmount) {
			this.Id = Id;
			this.healAmount = healAmount;
		}

		public int getId() {
			return Id;
		}

		public int getHealAmount() {
			return healAmount;
		}
	}

	/*public static void eat() 
	{
		if(DefaultMethods.getHPPercent() < vars.eatPercent)
		{
			if (!(GameTab.getOpen() == TABS.INVENTORY)) {
				Keyboard.pressKey((char) KeyEvent.VK_ESCAPE);
			}

			for(RSItem i : Inventory.getAll())
			{
				for(String s : i.getDefinition().getActions())
				{
					final int t = Inventory.getAll().length;
					if(s.contains("Eat"))
					{
						i.click("Eat");
						Timing.waitCondition(new Condition()
						{;
						@Override
						public boolean active()
						{
							return Inventory.getAll().length < t;
						}
						}, General.random(1200, 1300));
						if(DefaultMethods.getHPPercent() > vars.eatPercent)
						{
							return;
						}
					}
				}
			}

			if (Inventory.find(vars.food.getId()).length > 0)
			{
				vars.status = "Eating";
				final int t = Inventory.getAll().length;
				Inventory.find(vars.food.getId())[0].click("Eat"); 
				Timing.waitCondition(new Condition(){;
				@Override
				public boolean active()
				{
					return Inventory.getAll().length < t;
				}}, General.random(1200, 1300));
				vars.eatPercent = General.random(vars.minEatPercent, vars.maxEatPercent);
			}
		}			
	}*/

}
