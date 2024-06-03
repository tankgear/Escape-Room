import java.util.InputMismatchException;
import java.util.Scanner;
/*
  GameDriver.java
  @author Brett Kamen
  @version 1.0.0
  IMPORTANT PLEASE READ THIS!
  Escape Room Game
  Welcome to my escape room!
  This game takes place in one room, where you will interact with different objects and find your way out.
  The text printed onto the console will be delayed so that you can read each prompt.
  You will be prompted when to give user input on what to interact with.
  Anything in quotes are things that you can interact and/or respond with. For example you will see something like this: "baseball" or "Yes."
  You will also be timed and when you finish the game, you will see how long it took you to complete it. 
  Have fun and hope you enjoy my game.

  Credit:
  For Thread.sleep I got help from here: https://www.youtube.com/watch?v=sE6ksxK3oEg
  For the setting up the timer I got help from here: https://stackoverflow.com/questions/39702216/displaying-how-long-it-took-for-someone-to-do-something-in-java
*/
public class GameDriver {
    public static void main(String[] args) throws InterruptedException { //the exception allows Threads.sleep to work without causing the program to crash
        Backpack b = new Backpack();
        Timer time = new Timer();
        Dresser d = new Dresser();
        BigDoor door = new BigDoor();
        Bookshelf book = new Bookshelf();
        Safe s = new Safe();
        Scanner keyboard = new Scanner(System.in);
        String option = "";
        int code = 0;
        System.out.println("Welcome and thank you for taking part in this escape room.");
        Thread.sleep(3000); //delays each print statement to 3 seconds
        System.out.println("In this challege you are tasked with finding a way out of the room.");
        Thread.sleep(3000);
        System.out.println("Once you start you will be timed, good luck and have fun!");
        Thread.sleep(3000);
        System.out.println("When you are ready type \"start\" to begin the game");
        if(keyboard.next().equalsIgnoreCase("Start")){
            time.setStart(System.currentTimeMillis()); //The timer will begin counting up in milliseconds until the stop function is called
            System.out.println("You enter a small room with different objects.");
            Thread.sleep(3000);
            System.out.println("Looking around you notice a dresser, safe, and bookshelf.");
            Thread.sleep(3000);
            System.out.println("On the other side of the room you see a big-door.");
            Thread.sleep(3000);
            System.out.println("You can also check what's in your bag.");
    
            while(!door.getBigDoor().equals("open")){
                Thread.sleep(3000);
                System.out.println("Choose one to interact with: \"dresser,\" \"safe,\" \"bookshelf,\" \"big-door,\" or \"bag.\" ");
                option = keyboard.next();

                if(option.equalsIgnoreCase("Bag") && !b.inventory.isEmpty()){
                    System.out.println("In your bag you have a " + b.inventory);
                }

                else if(option.equalsIgnoreCase("Bag") && b.inventory.isEmpty()){
                    System.out.println("You currently have no items in your bag.");
                }

                if(option.equalsIgnoreCase("dresser") && !b.inventory.contains(d.getKey())){
                    System.out.println("You walk towards the dresser.");
                    Thread.sleep(3000);
                    System.out.println("Upon closer examination its a modern looking dresser made out of wood, with three drawers.");
                    while(!b.inventory.contains(d.getKey())){
                    Thread.sleep(3000);
                    System.out.println("Which drawer would you like to interact with? \"Drawer1,\" \"Drawer2,\" or \"Drawer3.\"");
                    option = keyboard.next();
                        if(option.equalsIgnoreCase("drawer1")){
                          System.out.println(d.getDrawer1());
                        }
                        
                        else if(option.equalsIgnoreCase("drawer2")){
                            System.out.println(d.getDrawer2());
                            b.inventory.add(d.getKey());
                            Thread.sleep(3000);
                            System.out.println("After grabbing the key, you put it into your bag and walk back to the center of the room.");
                        }

                        else if(option.equalsIgnoreCase("drawer3")){
                            System.out.println(d.getDrawer3());
                        }

                        else if(!option.equalsIgnoreCase("drawer1") && !option.equalsIgnoreCase("drawer2") && !option.equalsIgnoreCase("drawer3")){
                            System.out.println("Please respond using the options available, thank you.");
                        }
                    }
                }

                else if(option.equalsIgnoreCase("dresser") && b.inventory.contains(d.getKey())){
                    System.out.println("You already have whet you need from the dresser.");
                }

                else if(option.equalsIgnoreCase("safe") && !b.inventory.contains(s.getKey())){
                    System.out.println("You walk towards the safe.");
                    Thread.sleep(3000);
                    System.out.println("It's a small grey safe with a keypad and to get inside you need a code.");
                    while(!b.inventory.contains(s.getKey())){
                        Thread.sleep(3000);
                        System.out.println("Would you like to use the keypad? \"Yes\" or \"Leave\"");
                        option = keyboard.next();
                        try{
                            if(option.equalsIgnoreCase("Yes")){
                                System.out.println("Please enter a 4-digit code.");
                                code = keyboard.nextInt();
                            if(code == s.getCode()){
                                System.out.println(s.getKeypad());
                                b.inventory.add(s.getKey());
                                Thread.sleep(3000);
                                System.out.println("After grabbing the key, you put it in your bag and go back to the center of the room.");
                }
                            else{
                                System.out.println("The light on the keypad turned red, must have not been the right code.");
            }
                }
        }
                        catch (InputMismatchException e){
                                System.out.println("Please use a whole number and/or keep to it 4 numbers for next time.");
                                keyboard.nextLine(); // added this so print line on line 101 only gets printed once and not twice
                    
        }

                if(option.equalsIgnoreCase("leave")){
                    System.out.println("You decide to leave and return back to the center of the room.");
                    break;
                }

                else if(!option.equalsIgnoreCase("Yes") && !option.equalsIgnoreCase("Leave")){
                    System.out.println("Please respond using the options available, thank you.");
                }
                    }
                }

                else if(option.equalsIgnoreCase("safe") && b.inventory.contains(s.getKey())){
                    System.out.println("You already have what you need from the safe.");
                }

                else if(option.equalsIgnoreCase("bookshelf") && !b.inventory.contains(book.getPaper())){
                    System.out.println("You walk towards the bookshelf.");
                    Thread.sleep(3000);
                    System.out.println("Upon closer examination it has three shelves and they are filled with books.");
                    while(!b.inventory.contains(book.getPaper())){
                        Thread.sleep(3000);
                        System.out.println("Which shelf would you like to interact with? \"Shelf1,\" \"Shelf2,\" or \"Shelf3.\"");
                        option = keyboard.next();
                        if(option.equalsIgnoreCase("shelf1")){
                            System.out.println(book.getShelf1());
                        }

                        else if(option.equalsIgnoreCase("shelf2")){
                            System.out.println(book.getShelf2());
                        }

                       else  if(option.equalsIgnoreCase("shelf3")){
                            System.out.println(book.getShelf3());
                            b.inventory.add(book.getPaper());
                            Thread.sleep(3000);
                            System.out.println("After grabbing the piece of paper, you put it in your bag and walk back to the center of the room.");
                        }

                        else if(!option.equalsIgnoreCase("Shelf1") && !option.equalsIgnoreCase("Shelf2") && !option.equalsIgnoreCase("Shelf3")){
                            System.out.println("Please respond using the options available, thank you.");
                        }
                    }
                
                }

                else if(option.equalsIgnoreCase("bookshelf") && b.inventory.contains(book.getPaper())){
                    System.out.println("You already have what you need from the bookshelf.");
                }

                else if(option.equalsIgnoreCase("big-door")){
                    System.out.println("You walk towards the big door.");
                    Thread.sleep(3000);
                    System.out.println("Once you reach the big door, you notice two locks with strange symbols on them.");
                    while(!door.getBigDoor().equals("open")){ //made this while loop to account for error-handling, in case the user inputs something wrong on line 179
                    Thread.sleep(3000);
                    System.out.println("Would you like to inspect the locks? \"Yes\" or \"Leave\" ");
                    option = keyboard.next();
                    if(option.equalsIgnoreCase("Yes")){

                    if(!b.inventory.contains(d.getKey()) && !b.inventory.contains(s.getKey())){
                        Thread.sleep(3000);
                        System.out.println("You inspect the locks, but can't make out what the symbols mean. So you head back to the center of the room.");
                        break; //the break statement here and below are needed to get out of this nested while loop, since the condition won't be met unless both keys are present
                    }

                    if(b.inventory.contains(d.getKey()) && !b.inventory.contains(s.getKey())){
                        Thread.sleep(3000);
                        System.out.println("You reach into your bag and use the " + d.getKey() + ".");
                        Thread.sleep(3000);
                        System.out.println("It works on one of the locks, but you can't turn it.");
                        Thread.sleep(3000);
                        System.out.println("It seems like you need both keys.");
                        Thread.sleep(3000);
                        System.out.println("You put the key back into your bag and return to the center of the room.");
                        break;
                    }

                    if(b.inventory.contains(s.getKey()) && !b.inventory.contains(d.getKey())){
                        Thread.sleep(3000);
                        System.out.println("You reach into your bag and use the " + s.getKey() + ".");
                        Thread.sleep(3000);
                        System.out.println("It works on one of the locks, but you can't turn it.");
                        Thread.sleep(3000);
                        System.out.println("It seems like you need both keys.");
                        Thread.sleep(3000);
                        System.out.println("You put the key back into your bag and return to the center of the room.");
                        break;
                    }

                    if(b.inventory.contains(d.getKey()) && b.inventory.contains(s.getKey())){
                        Thread.sleep(3000);
                        System.out.println("You reach into your bag and use both the " + d.getKey() + " and the " + s.getKey() + ".");
                        Thread.sleep(3000);
                        System.out.println("At the same time you turn both keys and unlock the door.");
                        b.inventory.remove(d.getKey());
                        b.inventory.remove(s.getKey());
                        door.setBigDoor("open");
                        Thread.sleep(3000);
                        System.out.println("Quickly you open the door, and run out the room.");
                    }
            }
                    else if(option.equalsIgnoreCase("Leave")) {
                        Thread.sleep(3000);
                        System.out.println("You decide to return back to the center of the room.");
                        break;
                    }

                    else if(!option.equalsIgnoreCase("Yes") && !option.equalsIgnoreCase("Leave")){
                        System.out.println("Please respond using the options available, thank you.");
                    }
            }
        }

                    else if((!option.equalsIgnoreCase("dresser")) && (!option.equalsIgnoreCase("safe")) && (!option.equalsIgnoreCase("bookshelf")) && (!option.equalsIgnoreCase("big-door")) && (!option.equalsIgnoreCase("bag"))){
                        System.out.println("Please respond using the options available, thank you.");
                }
            }
        
            time.setStop(System.currentTimeMillis()); //this function stops the timer from continuing to go upward
            Thread.sleep(3000);
            System.out.println("Congradulations on completing the escape room!");
            
            long Difference = (time.getStop() - time.getStart()); //subtracts the end time from the start time to get accurate recording of your time
            long finalTimeM = ((Difference/1000) / 60); //conversion from milliseconds to seconds, and then minutes
            long finalTimeS = ((Difference/1000) % 60); // same conversion as above except trying to find the remainder time in seconds 
            Thread.sleep(3000);
            System.out.println("It took you " + finalTimeM + " minutes and " + finalTimeS + " seconds to complete the escape room.");
            keyboard.close();
        }

    else{
        System.out.println("Come back when you are ready, have a great day!");
    }
         }

         }
    

