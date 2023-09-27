package Menegroth_package;

import java.util.Scanner;

/**
 * @author Jakub Polacek
 * Date: 28.11. - 7.12. 2022
 * inspiration: Belegost (1989) by Frantisek Fuky, Miroslav Fidlera and Tomas Rylek
 * sources for backstory: Silmarillion (1978) by John Ronald Reuel Tolkien
 * published by Mlada Fronta (1992), translated by Stanislava Posustova-Mensikova
 *
 * Shortest route to death:
 * Play, north, north, north
 * Shortest route to victory:
 * Play, east - examine, south, east, north, north - examine, south - examine, south, inside - examine,
 * outside, south, west, west, west -  examine, east, east, north - examine, inside.
 *
 * Tested by Tomas Szabo on 8.12.
 *
 */

public class Menegroth {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String play;
        boolean alive = true;
        boolean badlyHurt = false;
        String direction;
        String location = "meadow";  //Starting location

        //text typed by player compared to these, not case sensitive
        String north = "north";
        String south = "south";
        String west = "west";
        String east = "east";
        String inside = "inside";
        String outside = "outside";
        String examine = "examine"; //interacts with the current location
        String inventory = "inventory"; //displays current inventory
        String inventoryList = "Haversack with food and water\nSmall war hammer"; //starting equipment

        //Items obtainable in the game
        boolean ironKey = false;
        boolean axe = false;
        boolean smallTrunk = false;
        boolean boulderOut = false;
        boolean oil = false;
        boolean steel = false;
        boolean flint = false;
        boolean lantern = false;
        boolean litLantern = false;


        //First thing player sees, explains rules
        System.out.println("     *****************************");
        System.out.println("     *   Welcome to Menegroth!   *");
        System.out.println("     ***************************** \n");
        System.out.println("This is a text-based adventure game, styled after old gem of my youth, Belegost!");
        System.out.println("In order to play this game, you will need:");
        System.out.println(" Pencil \n Sheet of paper\n Good memory");
        System.out.println("In the game, to go/move somewhere, simply write the direction you want to go - 'north', 'west' etc.");
        System.out.println("At some places, you may acquire an interstings items, which you may then use at other places.");
        System.out.println("If you want to display all the items you have, just type 'inventory' instead of the directions.");
        System.out.println("You can also write 'examine' to interact with your surroundings and items.");
        System.out.println("On your journey you may fall at some points, so be sure to take notes for future playthroughs.");
        System.out.println("\nType PLAY to start the game or anything else to exit.");
        play = input.next();

        //Ask if player wants to play (for cases they open it by mistake)
        if(!play.equalsIgnoreCase("play")){
            System.out.println("Goodbye, maybe next time.");
            System.exit(0);
        }

        //Start of the game
        System.out.println("**************************************************************************************************");
        System.out.println("\nMenu gunud, Khazad!");
        System.out.println("You are a dwarf from Ered Luins, the Blue Mountains.");
        System.out.println("Your name is Orik and you were tasked with retieving an old artifact, Velqualamir, from Menegroth.");
        System.out.println("It is a very powerfull artifact, second side of the long-lost Alqualamir, which was triumphantly recovered in the Belegost.");
        System.out.println("\nMenegroth, an ancient fort of grey elves, also called a 'Thousand caves'.");
        System.out.println("Its history is as old as it is bloody.");
        System.out.println("After dwarves built it in the first age for elvish king Thingol, it stopped the goblin raids in the area.");
        System.out.println("As a response, goblins created a strong army joining forces with orcs, but were ultimately defeated with the help of Laiquendi.");
        System.out.println("In the following years, Menegroth prospered and become one of the two most dominant cities in the region.");
        System.out.println("Unfortunately, this also foretold his fall, when betrayal upon betrayal came into it's halls.");
        System.out.println("Now, long lost and and brimming with goblins and orcs, it is needed once again.\n");

        while(alive){

            if(location.equals("meadow")){

                //Displayed when player starts/moves here
                System.out.println("\nYou stand on a road in the middle of a small meadow.");
                System.out.println("Gentle breeze is slowly blowing from the southern path, where you started this journey.");
                System.out.println("To the north you see the spectacular gate, which serves as the main entrance into Menegroth.");
                System.out.println("A healthy looking deciduous forest is beginning on the west of the meadow.");
                System.out.println("To the east you notice some kind of flowing water in a distance, probably a river.");

                //Depending on user input moves/do action
                while(location.equals("meadow")){
                    System.out.println("");
                    Scanner go = new Scanner(System.in);
                    direction = go.next();
                    System.out.println("");

                    //Shows inventory and resets scanner
                    if(direction.equalsIgnoreCase(inventory)){
                        System.out.println(inventoryList);
                    }
                    //Interacts with current location
                    else if(direction.equalsIgnoreCase(examine)){
                        System.out.println("The grass is fresh and green, but you don't see anything worth interest here.");
                    }
                    //Traveling messages
                    else if(direction.equalsIgnoreCase(north)){
                        System.out.println("You follow the path to the gate.");
                        location = "beforeGate";
                    }
                    else if(direction.equalsIgnoreCase(west)){
                        System.out.println("You make your way into the green forest.");
                        location = "forest";
                    }
                    else if(direction.equalsIgnoreCase(east)){
                        System.out.println("You go for a while, until you end up before a river with a small pond.");
                        location = "pond";
                    }
                    else if(direction.equalsIgnoreCase(south)){
                        System.out.println("You can't go back now. You still don't have the Velqualamir.");
                        System.out.println("Your rock-hard determination knows no bounds, so no giving up!");
                    }
                    //Asks to type again and resets the scanner
                    else{
                        System.out.println("Looks like you typed a wrong letter somewhere, try again.");
                    }
                }
            } //End of meadow


            if(location.equals("forest")){

                System.out.println("\nYou enter the forest. It looks as good as any other would, but you don't really like forests.");
                System.out.println("A weird bird is chirping above your head and you also saw few deers running away.");
                System.out.println("Fuzzy moss beneath your feet just doesn't feel right. Oh, how you wish to be back in some cozy mine.");
                System.out.println("On the other hand, if you ever need some wood, this looks like a perfect place.");
                System.out.println("There also lies a young felled tree. Probably went down in some storm, but looks surprisingly durable on closer look.");
                System.out.println("To the north, east and south the forest starts thickening, branches twisting and path disappearing. Looks like a dead end.");

                while(location.equals("forest")){
                    System.out.println("");
                    Scanner go = new Scanner(System.in);
                    direction = go.next();
                    System.out.println("");

                    if(direction.equalsIgnoreCase(inventory)){
                        System.out.println(inventoryList);
                    }
                    else if(direction.equalsIgnoreCase(examine)){
                        if(axe){
                            System.out.println("You cut off the branches and take the sturdy trunk with you.");
                            smallTrunk = true; inventoryList = inventoryList + "\nSmall trunk";
                        }
                        else{
                            System.out.println("The small tree maybe usefull, but with this many branches, its impossible to carry it around and use for anything.");
                            System.out.println("Maybe if you find something to cut the branches off.");
                        }
                    }
                    else if(direction.equalsIgnoreCase(north) || direction.equalsIgnoreCase(south) || direction.equalsIgnoreCase(west)){
                        System.out.println("You really don't want to fight an unknown way through some vegetation.");
                    }
                    else if(direction.equalsIgnoreCase(east)){
                        System.out.println("You finally make your way out of the forest.");
                        System.out.println("Something really felt off there, so you don't want to go back unless absolutely necessary.");
                        location = "meadow";
                    }
                    else{
                        System.out.println("Looks like you typed a wrong letter somewhere, try again.");
                    }
                }
            }//End of forest


            if(location.equals("beforeGate")){

                if(badlyHurt){
                    System.out.println("\nYou try to return back to the main gate, but you are intercepted on the way by a group of big orcs.");
                    System.out.println("They were specifically looking for you, if you are so dumb to come back again.");
                    System.out.println("After a very short struggle, you die at their hands and will presumably be eaten in next couple of hours.");
                    alive = false;
                    break;
                }

                System.out.println("\nYou are about thousand feets from the gate.");
                System.out.println("The gate looks exactly like from the legends. Huge door, spectacular ornaments and multiple statues visible even from here.");
                System.out.println("But there is a little time to indulge yourself in the fine craftsmanship, because you spot a pack of vile goblins patrolling around the gate.");
                System.out.println("You can either risk it and try to break in through them or find a different way in.");

                while(location.equals("beforeGate")){
                    System.out.println("");
                    Scanner go = new Scanner(System.in);
                    direction = go.next();
                    System.out.println("");

                    if(direction.equalsIgnoreCase(inventory)){
                        System.out.println(inventoryList);
                    }
                    else if(direction.equalsIgnoreCase(examine)){
                        System.out.println("Rushing in solo seems like a bad idead, maybe you should try to look for another way in.");
                    }
                    else if(direction.equalsIgnoreCase(west) || direction.equalsIgnoreCase(east)){
                        System.out.println("You can't go there.");
                    }
                    else if(direction.equalsIgnoreCase(north)){
                        System.out.println("You prepare your hammer and run the rest to the gate.");
                        location = "gate";
                    }
                    else if(direction.equalsIgnoreCase(south)){
                        System.out.println("Probably for the best, you turn around and go back to start looking for alternative way in.");
                        System.out.println("Considering the name 'Thousand caves' isn't just a joke, there should at least one in near vicinity.");
                        location = "meadow";
                    }
                    else{
                        System.out.println("Looks like you typed a wrong letter somewhere, try again.");
                    }
                }
            } //End of beforeGate


            if(location.equals("gate")){

                System.out.println("\nYou valiantly charge in and kill the first surprised goblin with one swing.");
                System.out.println("However the other 7 goblins prepare their weapons in the meantime and close in on you.");
                System.out.println("After a close fight, you somehow manage to kill 6 of them, but one gets away in the meantime.");
                System.out.println("With mutiple smaller wounds on your arms and a festering cut in your leg you want to get out as soon as possible, before any reinforcements arrive.");
                System.out.println("You ran (as much as you can with the wounded leg) back to the meadow.");
                badlyHurt = true;
                location = "meadow";
            }//End of gate


            if(location.equals("pond")){

                System.out.println("\nYou arrive at a small blue pond with a pebble beach.");
                System.out.println("Small river flows from north to south. You also notice a small chimney on the other side of the pond.");
                System.out.println("Water is very clear and see through, river that flows in must have a spring in Menegroth.");
                System.out.println("You can either go north to look for the river's source");
                System.out.println("Or follow the river flow to the south.");
                System.out.println("Of course, you can also go back to the nice meadow.");

                while(location.equals("pond")){
                    System.out.println("");
                    Scanner go = new Scanner(System.in);
                    direction = go.next();
                    System.out.println("");

                    if(direction.equalsIgnoreCase(inventory)){
                        System.out.println(inventoryList);
                    }
                    else if(direction.equalsIgnoreCase(examine)){
                        if(flint){
                            System.out.println("Nothing interesting here anymore.");
                        }
                        else{
                            System.out.println("You don't know how to swim, but you try to look for something on the beach.");
                            System.out.println("After a while you find an flint stone with nice shape, it may be lucky so you take it.");
                            flint = true; inventoryList = inventoryList + "\nFlint" ;
                        }
                    }
                    else if(direction.equalsIgnoreCase(east)){
                        System.out.println("Unfortunately you can't swim, so you can't go there.");
                    }
                    else if (direction.equalsIgnoreCase(north)){
                        System.out.println("You follow the river upwards to the mountains.");
                        location = "riverEntrance";
                    }
                    else if(direction.equalsIgnoreCase(west)){
                        System.out.println("You leave the pond and go back to the meadow.");
                        location = "meadow";
                    }
                    else if(direction.equalsIgnoreCase(south)){
                        System.out.println("You follow the river downstream until you find a ford.");
                        location = "ford";
                    }
                    else{
                        System.out.println("Looks like you typed a wrong letter somewhere, try again.");
                    }
                }
            }//End of pond


            if(location.equals("ford")){

                System.out.println("\nYou arrive at the ford across the river. You can get to the other side of the river here.");
                System.out.println("Not much of interest here, but it feels nice to stand in middle of the river and wash your feets.");
                System.out.println("Because you don't really want to get any further south from Menegroth, you have only two options:");
                System.out.println("Go back either on west or east side of the river.");

                while(location.equals("ford")){
                    System.out.println("");
                    Scanner go = new Scanner(System.in);
                    direction = go.next();
                    System.out.println("");

                    if(direction.equalsIgnoreCase(inventory)){
                        System.out.println(inventoryList);
                    }
                    else if(direction.equalsIgnoreCase(examine)){
                        System.out.println("You stand in the water for a while longer.");
                        System.out.println("After a bit more thinking, nothing comes to mind.");
                    }
                    else if(direction.equalsIgnoreCase(north) || direction.equalsIgnoreCase(south)){
                        System.out.println("Please choose either west or east side of the river.");
                    }
                    else if(direction.equalsIgnoreCase(east)){
                        System.out.println("You come out of the river on the east side and follow it to the north.");
                        location = "hut";
                    }
                    else if(direction.equalsIgnoreCase(west)){
                        System.out.println("You come out of the river on the west side and follow it to the north");
                        location = "pond";
                    }
                    else{
                        System.out.println("Looks like you typed a wrong letter somewhere, try again.");
                    }
                }
            }//End of ford


            if(location.equals("hut")){

                System.out.println("\nYou come to a small hut, located on the east side of the pond.");
                System.out.println("It appears that a woodcutter of unknown race lived here.");
                System.out.println("You notice a wood splitting block, but no logs around.");
                System.out.println("When looking through the tiny window, the hut looks even more abandoned.");
                System.out.println("On the other hand, there is an iron lock on the door.");
                System.out.println("If you want to try go in, type 'inside'.");
                System.out.println("Other than that, you can go to the mountain on the north.");
                System.out.println("Or you can go south with the river's downstream.");
                System.out.println("On the east side starts a very large and dark forest, where you definitely don't want to go.");

                while(location.equals("hut")){
                    System.out.println("");
                    Scanner go = new Scanner(System.in);
                    direction = go.next();
                    System.out.println("");

                    if(direction.equalsIgnoreCase(inventory)){
                        System.out.println(inventoryList);
                    }
                    else if(direction.equalsIgnoreCase(examine)){
                        System.out.println("The door looks heavy, you doubt you can get inside without key. But never hurts to try, eh?");
                    }
                    else if(direction.equalsIgnoreCase(inside)){
                        if(ironKey){
                            System.out.println("You slowly turn around the iron key in the lock.");
                            System.out.println("After you hear a light click, you open the door and step inside.");
                            location = "hutInside";
                        }
                        else{
                            System.out.println("You try to smash the lock with your hammer, but it doesn't budge an inch.");
                            System.out.println("You are going to need a key if you want to get inside.");
                        }
                    }
                    else if(direction.equalsIgnoreCase(north)){
                        System.out.println("You go to the mountains where you find a small cave.");
                        location = "underLedge";
                    }
                    else if(direction.equalsIgnoreCase(south)){
                        System.out.println("You go down with the river stream until you find a ford.");
                        location = "ford";
                    }
                    else if(direction.equalsIgnoreCase(east)){
                        System.out.println("Whatever is in that forest, you don't want to disturb it.");
                        System.out.println("Be it treants, elves or dryad, that much deep forest is never a good choice.");
                    }
                    else if(direction.equalsIgnoreCase(west)){
                        System.out.println("Unfortunately you can't swim, so you can't go there.");
                    }
                    else{
                        System.out.println("Looks like you typed a wrong letter somewhere, try again.");
                    }
                }
            }//End of hut


            if(location.equals("hutInside")){

                System.out.println("\nYou enter the small hut.");
                System.out.println("The hearth is a long out and there isn't any wood left around.");
                System.out.println("Closet is open and empty. Floor has a fair layer of dust.");
                System.out.println("The bed is half-eaten by wood-worm, but the closed drawer still looks good.");
                System.out.println("If you want to go back out, type 'outside'.");

                while(location.equals("hutInside")){
                    System.out.println("");
                    Scanner go = new Scanner(System.in);
                    direction = go.next();
                    System.out.println("");

                    if(direction.equalsIgnoreCase(inventory)){
                        System.out.println(inventoryList);
                    }
                    else if(direction.equalsIgnoreCase(examine)){
                        if(axe){
                            System.out.println("You try to look for something more, but everything else is empty.");
                        }
                        else{
                            System.out.println("After some time searching, you find an oil and steel without flint.");
                            System.out.println("There is also an axe next to the drawer, so you take it as well.");
                            axe = true; oil = true; steel = true; inventoryList = inventoryList + "\nAxe" + "\nOil" + "\nSteel";
                        }
                    }
                    else if(direction.equalsIgnoreCase(outside)){
                        System.out.println("You step outside the hut and lock again out of respect for the old woodcutter.");
                        location = "hut";
                    }
                    else if(direction.equalsIgnoreCase(north)||direction.equalsIgnoreCase(south)||direction.equalsIgnoreCase(east)||direction.equalsIgnoreCase(west)){
                        System.out.println("You can only go outside from here.");
                    }
                    else{
                        System.out.println("Looks like you typed a wrong letter somewhere, try again.");
                    }



                }
            }//End of hutInside


            if(location.equals("underLedge")){

                System.out.println("\nYou stand before a small cave.");
                System.out.println("Inside, you see some old goblin bones, probably a bear lived here.");
                System.out.println("The cave has a ledge over itself.");
                System.out.println("If you want to climb up, type 'north' as usual.");
                System.out.println("Otherwise you can go south to the hut.");

                while(location.equals("underLedge")){
                    System.out.println("");
                    Scanner go = new Scanner(System.in);
                    direction = go.next();
                    System.out.println("");

                    if(direction.equalsIgnoreCase(inventory)){
                        System.out.println(inventoryList);
                    }
                    else if(direction.equalsIgnoreCase(examine)){
                        if(ironKey){
                            System.out.println("You try to look for something more, but no luck.");
                        }
                        else{
                            System.out.println("After going through some rubbish and another pile of bones you find a small iron key.");
                            System.out.println("The old woodcutter must have died at the hands of the goblins. At least the bear avenged their death.");
                            ironKey = true; inventoryList = inventoryList + "\nIron key";
                        }
                    }
                    else if(direction.equalsIgnoreCase(north)){
                        if(badlyHurt){
                            System.out.println("You try to climb up, but your leg fails you and you fall down.");
                            System.out.println("In this condition, you concede on trying to get up.");
                        }
                        else{
                            System.out.println("You climb up the ledge without much issues.");
                            location = "ledge";
                        }
                    }
                    else if(direction.equalsIgnoreCase(south)){
                        System.out.println("You return back to the hut.");
                        location = "hut";
                    }
                    else if(direction.equalsIgnoreCase(west) || direction.equalsIgnoreCase(east)){
                        System.out.println("You can't go there.");
                    }
                    else{
                        System.out.println("Looks like you typed a wrong letter somewhere, try again.");
                    }


                }
            }//End of underLedge


            if(location.equals("ledge")){

                System.out.println("\nYou stand on a small ledge.");
                System.out.println("There indeed is a way inside to the mountain through another small cave.");
                System.out.println("Or should you say, 'was', because its clogged by stones and broken joists.");
                System.out.println("On the ledge itself is an antique looking lantern, laying on side, but still looks usable.");
                System.out.println("If you want to climb down, type 'south'.");

                while(location.equals("ledge")){
                    System.out.println("");
                    Scanner go = new Scanner(System.in);
                    direction = go.next();
                    System.out.println("");

                    if(direction.equalsIgnoreCase(inventory)){
                        System.out.println(inventoryList);
                    }
                    else if(direction.equalsIgnoreCase(examine)){
                        if(lantern){
                            System.out.println("Nothing else here. Just a rocky ledge.");
                        }
                        else{
                            System.out.println("You take the lanter with you, but there appears to be nothing inside.");
                            System.out.println("So, if you want to light it up, you will need to find some fuel and starter.");
                            lantern = true; inventoryList = inventoryList + "\nLantern";
                        }
                    }
                    else if(direction.equalsIgnoreCase(south)){
                        System.out.println("You clim down the ledge.");
                        location = "underLedge";
                    }
                    else if(direction.equalsIgnoreCase(north) || direction.equalsIgnoreCase(east) || direction.equalsIgnoreCase(west)){
                        System.out.println("You can't go there.");
                    }
                    else{
                        System.out.println("Looks like you typed a wrong letter somewhere, try again.");
                    }


                }
            }//End of ledge


            if(location.equals("riverEntrance")){

                System.out.println("\nYou came across a place where water comes out of the mountain.");
                if(boulderOut){
                    System.out.println("The boulder is finally out of the way. Now you can finally head inside the Menegroth.");
                    System.out.println("BUT, it is very dark inside, so some sort of light may be needed.");
                    System.out.println("If you wish to step inside, type 'inside'.");
                }
                else{
                    System.out.println("It looks like there is a cave inside, but it is blocked by a large boulder.");
                    System.out.println("From here you can only go back south.");
                }

                while(location.equals("riverEntrance")){
                    System.out.println("");
                    Scanner go = new Scanner(System.in);
                    direction = go.next();
                    System.out.println("");

                    if(direction.equalsIgnoreCase(inventory)){
                        System.out.println(inventoryList);
                    }
                    else if(direction.equalsIgnoreCase(examine)){

                        if(boulderOut){
                            System.out.println("The boulder is already out. Now you can finally head inside the Menegroth.");
                            System.out.println("BUT, it is very dark inside, so some sort of light may be needed.");
                            System.out.println("If you wish to step inside, type 'inside'.");
                        }
                        else if(smallTrunk){
                            System.out.println("With great strength of mind, less burden is placed on your muscles.");
                            System.out.println("After a quick fight using the trunk as a lever, you manage to get the boulder out of the way.");
                            System.out.println("The boulder is finally out of the way. Now you can finally head inside the Menegroth.");
                            System.out.println("BUT, it is very dark inside, so some sort of light may be needed.");
                            System.out.println("If you wish to step inside, type 'inside'.");
                            boulderOut = true;
                        }
                        else{
                            System.out.println("The boulder is heavy and even with your greatest efforts you can't move it.");
                            System.out.println("You are going to need some kind of lever to get it out.");
                        }
                    }
                    else if(direction.equalsIgnoreCase(inside) && boulderOut){

                        //If all items are gathered - win the game!
                        if(flint && steel && lantern && oil){
                            System.out.println("You pour the oil into the lantern and light it up.");
                            System.out.println("This should be sufficient light source for whatever happens.");
                            litLantern = true;
                        }

                        if(litLantern){
                            System.out.println("You go inside, carefully lighting your way in.");
                            System.out.println("There is a lot of sharp river turns and twists, but you manage to stand strong.");
                            System.out.println("Eventually you find a sligtly bigger cave. Looks like this place was used for gathering water in the times of old.");
                            System.out.println("\n     !CONGRATULATIONS!");
                            System.out.println("You managed to get inside the Menegroth!");
                            System.out.println("This is the end of this part of the journey.");
                            System.out.println("But don't be sad, the next part is already in development.");
                            System.out.println("And as for that, you will need this special code:");
                            System.out.println("     'EnTaroZeratul' ");
                            System.out.println("This proves you completed first part of the Menegroth journey.");
                            System.out.println("So, be sure to note it somewhere safe.");
                            System.out.println("Now, thank you for playing and hope we see each other soon in the next part!");
                            System.out.println("Jakub Polacek");
                            System.exit(0);
                        }
                        else{
                            System.out.println("You walk for a while in the river and everything seems fine.");
                            System.out.println("Suddenly, the water stream under your feet does some wild turbulence and drags you under.");
                            System.out.println("You never really like water, but this is probably the last time you can think about it.");
                            alive = false; break;
                        }
                    }
                    else if(direction.equalsIgnoreCase(south)){
                        System.out.println("You go back to the pond.");
                        location = "pond";
                    }
                    else if(direction.equalsIgnoreCase(north) || direction.equalsIgnoreCase(east) || direction.equalsIgnoreCase(west)){
                        System.out.println("You can't go there.");
                    }
                    else{
                        System.out.println("Looks like you typed a wrong letter somewhere, try again.");
                    }

                }
            }//End of riverEntrance


        }//End of the game (end of Alive)


        //On-death message
        if(!alive){
            System.out.println("\n     !YOU DIED!");
            System.out.println("Your journey ends here, but your experience made you stronger.");
            System.out.println("Next time, you will definitely succeed, retrieve the artifact and save the dwarves.");
            System.out.println("I believe in you, so come back once you have a time again.");
            System.out.println("Until then, goodbye and wish you all best!");
            System.out.println("Jakub Polacek");
        }


    }

}
