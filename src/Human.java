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

    //toString
    public String toString()
    {
        return "Level: "+level+"\nMust Fight?: "+mustFight+"\nHas Clue?: "+hasClue+"\nClue: "+clue;
    }//end toString
}//end human class
