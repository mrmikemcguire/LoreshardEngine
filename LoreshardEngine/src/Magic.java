import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Magic
	{
	public static void castMagic(int hitPoints, int magicLev, int monsterNum)
		{
		JFrame frame = new JFrame();
		
		Object[] magicType = {"Fire", "Water", "Earth", "Air"};
		int magicChoice = JOptionPane.showOptionDialog(frame, "What element would you like to cast?",
				"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null, magicType, magicType[1]);
		
		switch(magicChoice)
			{
			case 0:
				{
				castFireBall(hitPoints, magicLev, monsterNum);
				break;
				}
			case 1:
				{
				castHeal(hitPoints, magicLev);
				break;
				}
			case 2:
				{
				//castStoneSkin(magicLev);
				//NEEDS WORK
				break;
				}
			case 3:
				{
				//castTeleport(magicLev);
				//NEEDS WORK
				break;
				}
			}
		}
	
	public static void castFireBall(int hitPoints, int magicLev, int monsterNum)
		{
		int damage = (int) (Math.random() * (magicLev * 10)) + magicLev;
		JFrame frame = new JFrame();
		
		JOptionPane.showMessageDialog(frame, "You blast fire at the creature and do " + 5 * magicLev + " damage!",
				"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "",
				JOptionPane.QUESTION_MESSAGE);
		hitPoints = hitPoints - damage;
				JOptionPane.showMessageDialog(frame, "The monster has " + hitPoints + " HP left!",
				"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "",
				JOptionPane.QUESTION_MESSAGE);
		Monster.monsters.get(monsterNum).setHitPoints(hitPoints);
		}
	
	public static void castHeal(int hitPoints, int magicLev)
		{
		int healValue = (int) (Math.random() * (magicLev * 10)) + magicLev;
		JFrame frame = new JFrame();
		
		Hero.heroes.get(0).setHeroHP(Hero.heroes.get(0).getHeroHP() + healValue);
		
		JOptionPane.showMessageDialog(frame, "You heal yourself for " + healValue + " health!",
				"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "",
				JOptionPane.QUESTION_MESSAGE);
		}
	
	public static void castStoneSkin(int armor, int magicLev)
		{
		int stoneValue = (int) (Math.random() * (magicLev * 2)) + magicLev;
		JFrame frame = new JFrame();
		
		Hero.heroInventory.get(1).setArmorLevel(armor + stoneValue);
		
		JOptionPane.showMessageDialog(frame, "You turn your skin to stone!",
				"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "",
				JOptionPane.QUESTION_MESSAGE);
		}
	
	public static void castTeleport(int magicLev)
		{
		JFrame frame = new JFrame();
		
		JOptionPane.showMessageDialog(frame, "You teleport past the monster!",
				"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "",
				JOptionPane.QUESTION_MESSAGE);
		}
	}