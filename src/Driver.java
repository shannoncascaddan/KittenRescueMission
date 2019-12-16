import java.util.Scanner;
import java.util.Random;
public class Driver
{
    public static void main(String [] args)
    {
        Scanner keyboard = new Scanner(System.in);
        boolean valid=false;
        Random rand = new Random();

        //input
        System.out.print("Please enter your name: ");
        String catName = keyboard.next();
        System.out.print("Please your dragon's name: ");
        String dragonName = keyboard.next();

        //objects
        Cat cat = new Cat(catName);
        Dragon dragon = new Dragon(dragonName);

        beginStory(valid,cat,keyboard,dragon, rand);

    }//end main method

    //tell the story
    public static void beginStory(boolean valid, Cat cat,Scanner keyboard, Dragon dragon,Random rand)
    {
        String answer;
        //plot begins
        System.out.println("\nHello " + cat.getName() + "! We have some unfortunate news for you. It has been discovered that " +
                "your kittens have been stolen by humans. \nIt has been rumored that they are being taken to Finland. " +
                "It is up to you to get them back or they will be lost to us.\n" +
                "   Sincerely, Feline Headquarters ");

        System.out.println("\nYou are troubled by this message and know that you must begin a journey to rescue your children. " +
                "Immediately you set off through the forest to begin your quest. \n\nOnce in the forest, you reach a " +
                "fork in the road. Left there are dragon eggs. Right there is the unknown. \nWhich way do you go?:(left or right)");

        //first choice
        //determine plot that follows choice 1
        while (!valid)
        {
            answer = keyboard.next();
            if(answer.equalsIgnoreCase("left"))
            {
                System.out.println("You approach the dragon eggs. They appear to be unattended. Do you take one?(Yes or No)");
                while (!valid)
                {
                    answer = keyboard.next();

                    if (answer.equalsIgnoreCase("yes"))
                    {
                        System.out.println("\nYou have just gained a dragon egg. You take it back to Feline Headquarters and " +
                                "raise it as your own. You name it "+dragon.getName()+". When it gets old enough, you take the dragon out with you to " +
                                "\nfind your kittens.");
                        System.out.println("\nYou venture back out into the forest and encounter a human");
                        Human human1 = new Human(rand.nextInt(cat.attack()+1),true, true,"\nYou find a map to a town with kittens marked as the destination");
                        human1.humanEncounter(human1,cat,dragon,answer,keyboard);
                        System.out.println("You follow the map in the hopes that the kittens it is referring to are yours.\nUpon entering the town, you find " +
                                "a gaggle of humans that spot you. They approach. \nFortunately these are cat lovers and with to help you." +
                                " They have another clue, which they give  to you freely.");
                        human1.setMustFight(false);
                        human1.setClue("Down the street to the left there is a suspicious building. There kittens have been found before.\n" +
                                "It is probably your best bet. Good luck, "+cat.getName()+"!");
                        human1.humanEncounter(human1,cat,dragon,answer,keyboard);
                        System.out.println("You follow their instructions and hope that your kittens will be found there.");
                        System.out.println("\nYou and "+dragon.getName()+" enter the building and you notice that you are surrounded by menacing looking humans.\n" +
                                "You and your dragon must battle them all!");

                        // final battles
                        Human human2 = new Human(rand.nextInt(cat.attack()+1),true,false,"");
                        human2.humanEncounter(human2,cat,dragon,answer,keyboard);

                        human2.setLevel(rand.nextInt(cat.attack()+1));
                        human2.humanEncounter(human2,cat,dragon,answer,keyboard);

                        human2.setLevel(rand.nextInt(cat.attack()+1));
                        human2.humanEncounter(human2,cat,dragon,answer,keyboard);

                        human2.setLevel(rand.nextInt(cat.attack()+1));
                        human2.humanEncounter(human2,cat,dragon,answer,keyboard);

                        human2.setLevel(rand.nextInt(cat.attack()+1));
                        human2.humanEncounter(human2,cat,dragon,answer,keyboard);

                        human2.setLevel(rand.nextInt(cat.attack()+1));
                        human2.humanEncounter(human2,cat,dragon,answer,keyboard);

                        human2.setLevel(rand.nextInt(cat.attack()+1));
                        human2.humanEncounter(human2,cat,dragon,answer,keyboard);

                        human2.setLevel(rand.nextInt(cat.attack()+1));
                        human2.humanEncounter(human2,cat,dragon,answer,keyboard);

                        System.out.println("Congratulations!You have won the battles!\nYou enter a room with the boss human. " +
                                "This human admires your efforts at reaching him and grants you a key. " +
                                "\nYou use this key to open a door, behind which you find your family.\n" +
                                "You introduce your kittens to the new pet dragon and all fly home upon his back to live your lives as a happy family.");
                        System.out.println("\nWould you like to play again?('yes'or 'no')");
                        answer = keyboard.next();
                        if(answer.equalsIgnoreCase("yes"))
                        {
                            beginStory(valid,cat,keyboard,dragon,rand);
                        }//end if to restart4
                        else
                        {
                            return;
                        }//end else to quit

                        if(cat.getLives()<=0)
                        {
                            System.out.println("Sorry you lost the game... Would you like to restart?('yes' or 'no'");
                            answer = keyboard.next();
                            if(answer.equalsIgnoreCase("yes"))
                            {
                                beginStory(valid,cat,keyboard,dragon,rand);
                            }//end if to restart4
                            else
                            {
                                return;
                            }//end else to quit
                        }//end if cat is still alive
                    }//end if to get dragon egg
                    else if(answer.equalsIgnoreCase("no"))
                    {
                        System.out.println("That makes no sense! Why wouldn't you want a dragon? You turn around and " +
                                "take the right path without a dragon. ");
                        System.out.println("\nYou fool! The unknown is dangerous. You encounter the mother dragon and meet your demise. " +
                                "Would you like to restart? (Yes or No)");
                        while (!valid)
                        {
                            answer = keyboard.next();

                            if(answer.equalsIgnoreCase("yes"))
                            {
                                beginStory(valid,cat,keyboard,dragon,rand);
                            }//end if to restart
                            else if (answer.equalsIgnoreCase("no"))
                            {
                                return;
                            }//end if to quit
                            else
                            {
                                System.out.print("Please enter a valid input: ");
                            }//end inner else for valid input
                        }//end validation loop
                        valid = true;
                    }//end if to not take egg
                    else
                    {
                        System.out.print("Please enter a valid input: ");
                    }//end inner else for valid input
                }//end validation loop
                valid = true;
            }//end if left
            if (answer.equalsIgnoreCase("right"))
            {
                System.out.println("\nYou fool! The unknown is dangerous. You encounter the mother dragon and meet your demise. " +
                        "Would you like to restart? (Yes or No)");
                while (!valid)
                {
                    answer = keyboard.next();

                    if(answer.equalsIgnoreCase("yes"))
                    {
                        beginStory(valid,cat,keyboard,dragon,rand);
                    }//end if to restart
                    else if (answer.equalsIgnoreCase("no"))
                    {
                        return;
                    }//end if to quit
                    else
                    {
                        System.out.print("Please enter a valid input: ");
                    }//end inner else for valid input
                }//end validation loop
                valid = true;
            }//end if right
            else
            {
                System.out.print("Please enter a valid input: ");
            }//end else for invalid input
        }//end while loop to validate answer
    }//end first part of story

}//end driver class

