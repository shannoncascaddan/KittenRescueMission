import java.util.Scanner;

public class Human implements attackInterface
{
    //instance var
    int level;
    String clue;
    boolean hasClue;
    boolean mustFight;

    //constructors
    Human()
    {
        level = 0;
        clue = "";
        hasClue = false;
        mustFight = false;
    }//end 0-arg constructor
    Human(int level,boolean mustFight,boolean hasClue,String clue)
    {
        this.level = level;
        this.mustFight = mustFight;
        this.hasClue = hasClue;
        this.clue = clue;
    }//end 4-arg constructor

    //getters
    public int getLevel()
    {
        return level;
    }//end method to return level of human
    public String getClue()
    {
        return clue;
    }//end method to return a clue
    public boolean getHasClue()
    {
        return hasClue;
    }//end method to tell if human has a clue
    public boolean getMustFight()
    {
        return mustFight;
    }//end method to tell if you have to fight the human

    //Setters

    public void setLevel(int level)
    {
        this.level = level;
    }//end method to set the level of the human
    public void setClue(String clue)
    {
        this.clue = clue;
    }//end method to set the clue provided by the humans
    public void setHasClue(boolean hasClue)
    {
        this.hasClue = hasClue;
    }//end method to set if the human has clue
    public void setMustFight(boolean mustFight)
    {
        this.mustFight = mustFight;
    }//end method to set if the human must be fought

    //brain methods
    public int attack()
    {
        int force = level +1;
        return force;
    }//end method to determine force of human's attack
    public String giveClue()
    {
        return ("Your clue: "+clue);
    }//end method to give the cat a clue

    public static Human humanEncounter(Human human,Cat cat, Dragon dragon,String answer, Scanner keyboard)
    {
        boolean valid = false;
        Human winner = new Human();
        if (human.getMustFight())
        {
            Human lose = new Human();
            System.out.print("\nThis human is threatening and must be fought. Who fights them?(Me or Dragon)\nYour level: "+cat.getLevel()+
                    "\nDragon Uses Left: "+dragon.getUses());
            while (!valid)
            {
                answer = keyboard.next();
                if(answer.equalsIgnoreCase("me"))
                {
                    System.out.println("Do you want to 'meow' at them or 'attack'?" );
                    while (!valid)
                    {
                        answer = keyboard.next();
                        if(answer.equalsIgnoreCase("meow"))
                        {
                            if(cat.meow() >= human.attack())
                            {
                                System.out.println("You win the battle!");
                                cat.setLevel(cat.getLevel()+1);
                                winner =  lose;
                            }//end if cat wins
                            else
                            {
                                cat.setLives(cat.getLives()-1);
                                System.out.println("You lost the battle. You loose a life.\nYour lives: "+cat.getLives());
                                winner = human;
                            }//end if cat loses
                            if(human.getHasClue())
                            {
                                System.out.println("\nYou found a clue.\n\nClue: "+human.getClue());
                                System.out.println("\nYou are smart and follow the clue.");
                            }//end if hasClue
                            valid = true;
                        }//end if meow
                        else if (answer.equalsIgnoreCase("attack"))
                        {
                            if(cat.attack() >= human.attack())
                            {
                                System.out.println("You win the battle!");
                                cat.setLevel(cat.getLevel()+1);
                                if(human.getHasClue())
                                {
                                    System.out.println("You found a clue.\nClue: "+human.getClue());
                                    System.out.println("\nYou are smart and follow the clue.\n");
                                    winner = lose;
                                }//end if hasClue
                            }//end if cat wins
                            else
                            {
                                cat.setLives(cat.getLives()-1);
                                System.out.println("You lost the battle. You loose a life.\nYour lives: "+cat.getLives());
                                winner = human;
                            }//end if cat loses
                            valid =true;
                        }//end if you choose to attack
                        else
                        {
                            System.out.print("Please enter a valid input: ");
                        }//end not valid else
                    }//end validation while loop
                }//end if for if you fight
                else if(answer.equalsIgnoreCase("dragon"))
                {
                    if(dragon.getUses()>0)
                    {
                        valid = true;
                        System.out.println("Your dragon wins the battle!");
                        winner = lose;
                        dragon.setUses(dragon.getUses() - 1);
                        if(human.getHasClue())
                        {
                            System.out.println("You found a clue.\nClue: "+human.getClue());
                            System.out.println("\nYou are smart and follow the clue.\n");
                        }//end if hasClue
                    }//end if the dragon fights
                    else
                    {
                        System.out.println("You have no more dragon uses. Please enter a valid input.");
                    }//end no more dragon uses
                }
                else
                {
                    System.out.print("Please enter a valid input: ");
                }//end not valid else
            }//end validation loop
        }//end process that occours if you have to fight the human
        else if(human.getHasClue())
        {
            System.out.println("This human is kind and gives you a clue.\nClue: "+human.getClue());
            System.out.println("\nYou are smart and follow the clue.\n");
        }//end if has clue but not fight
        return winner;
    }//end method to determine course of an encounter with a human
    //toString
    public String toString()
    {
        return "Level: "+level+"\nMust Fight?: "+mustFight+"\nHas Clue?: "+hasClue+"\nClue: "+clue;
    }//end toString
}//end human class
