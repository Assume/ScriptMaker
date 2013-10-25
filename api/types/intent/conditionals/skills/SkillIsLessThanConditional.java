package scripts.ScriptMaker.api.types.intent.conditionals.skills;

import org.tribot.api2007.Skills;

import scripts.ScriptMaker.api.types.main.Conditional;

public class SkillIsLessThanConditional extends Conditional
{

	private static final long serialVersionUID = 4849136071897332885L;

	private Skills.SKILLS skill;
	private int level;
	
	public SkillIsLessThanConditional(Skills.SKILLS skill, int level)
	{
		this.skill = skill;
		this.level = level;
	}
	
	@Override
	public boolean run()
	{
		return skill.getCurrentLevel() < level;
	}
	
}
