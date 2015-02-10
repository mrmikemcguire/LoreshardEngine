import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Ingredient extends Item
	{
	private int herbValue;
	
	public Ingredient(String in, int v, int hv)
		{
		setItemName(in);
		setValue(v);
		herbValue = hv;
		}
	
	public static void brew()
		{
		int brewTotal = 0;
		Potion createdPotion = Potion.potions.get(0);
		ImageIcon icon = new ImageIcon(("cauldron.jpg"));
		JFrame frame = new JFrame();
		
		JOptionPane.showMessageDialog(frame, "You have found a cauldron to brew potions in!",
				"BREW",
				JOptionPane.QUESTION_MESSAGE,
				icon);
		
		if(Hero.alchemyBag.size() < 3)
			{
			JOptionPane.showMessageDialog(frame, "Unfortunately you don't have enough ingredients.",
					"BREW",
					JOptionPane.QUESTION_MESSAGE,
					icon);
			}
		
		else
			{
			Object[] potionType = {Hero.alchemyBag.get(0).getItemName(), Hero.alchemyBag.get(1).getItemName()};
			switch(Hero.alchemyBag.size())
				{
				case 3:
					{
					potionType = {Hero.alchemyBag.get(0).getItemName(), Hero.alchemyBag.get(1).getItemName()};
					}
				case 4:
				case 5:
				default:
				}
			for(int i = 0; i < 2; i++)
				{
				//Object[] potionType = {Hero.alchemyBag.get(0).getItemName(), Hero.alchemyBag.get(1).getItemName()};
				int ingredientChoice = JOptionPane.showOptionDialog(frame, "Which ingredient would you like to use?",
						"BREW",
						JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE,
						null, potionType, potionType[1]);

				brewTotal = brewTotal + Hero.alchemyBag.get(ingredientChoice).getHerbValue();
				Hero.alchemyBag.remove(ingredientChoice);
				}
			
			for(int i = 0; i < Potion.potions.size(); i++)
				{
				if(Potion.potions.get(i).getPotionID() == brewTotal)
					{
					createdPotion = Potion.potions.get(i);
					i = Potion.potions.size();
					}
				}
					
			JOptionPane.showMessageDialog(frame, "You have brewed: " + createdPotion.getItemName() + "!",
					"BREW",
					JOptionPane.QUESTION_MESSAGE,
					icon);
			
			Object[] potionType = {Hero.heroInventory.get(3).getItemName(), createdPotion.getItemName()};
			int PotionChoice = JOptionPane.showOptionDialog(frame, "Which potion would you like to keep?",
					"BREW",
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE,
					null, potionType, potionType[1]);
			switch(PotionChoice)
				{
				case 0:
					{
					break;
					}
				case 1:
					{
					Hero.heroInventory.set(3, createdPotion);
					break;
					}
				}
			}
		}

	public int getHerbValue()
		{
		return herbValue;
		}

	public void setHerbValue(int herbValue)
		{
		this.herbValue = herbValue;
		}
	
	
	}