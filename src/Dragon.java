public class Dragon implements attackInterface
{
    //instance var
    int uses;
    String name;
    int level;

    //constructors
    Dragon()
    {
        uses = 1;
        name = "Name";
        level = 1;
    }//end 0-arg constructor
    Dragon(String name)
    {
        uses = 1;
        this.name = name;
        level = 1;
    }//end 1-arg constructor

    //getters
    public int getUses()
    {
        return uses;
    }//end method to get number of uses
    public String getName()
    {
        return name;
    }//end method to get Dragon name
    public int getLevel()
    {
        return level;
    }//end method to return level of dragon

    //setters
    public void setUses(int uses)
    {
        this.uses = uses;
    }//end method to set num of uses
    public void setName(String name)
    {
        this.name = name;
    }//end method to set name
    public void setLevel(int level)
    {
        this.level = level;
    }//end method to set level of dragon

    //brian methods
    public int attack()
    {
        int force;

        if (uses>0)
        {
            force = 100000;
            uses--;
            return force;
        }
        uses--;
        return 0;
    }//end method to determine force of attack/decrease num uses
    //toString
    public String toString()
    {
        return "Name: "+name+"\nLevel: "+level+"\nUses: "+uses;
    }//end toString
}//end Dragon class
