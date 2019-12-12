public class Cat implements attackInterface
{
    //instance variables
    private int lives;
    private int level;
    private String name;

    //constructors
    Cat()
    {
        level = 1;
        lives = 9;
        name = "Name";
    }//end 0-arg constructor
    Cat(String name)
    {
        level = 1;
        lives = 9;
        this.name = name;
    }//end 1 arg constructor

    //getters
    public int getLevel()
    {
        return level;
    }//end method to return level
    public int getLives()
    {
        return lives;
    }//end method to return lives
    public String getName()
    {
        return name;
    }//end method to return name

    //setters
    public void setLevel(int level)
    {
        this.level = level;
    }//end method to set level
    public void setLives(int lives)
    {
        this.lives = lives;
    }//end method to set lives
    public void setName(String name)
    {
        this.name = name;
    }//end method to set name

    //brain methods
    public int attack()
    {
        int force = level+5;
        return force;
    }//end method to calculate force of attack
    public int meow()
    {
        int force = level+1;
        return force;
    }//end method to calculate force of meow

    //toString
    public String toString()
    {
        return "Name: "+name+"\nLevel: "+level+"\nLives: "+lives;
    }//end toString
}//end Cat class
