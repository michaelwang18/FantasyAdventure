import java.util.*;

public class Battle {

    Scanner scan = new Scanner(System.in);
    Dictionary<Integer,String> actions;
    ArrayList<Consumable> handbag;
    MoveStack moveStack = new MoveStack();
    MoveStack enemyStack = new MoveStack();
    Player player;
    int playerMaxHealth;
    int playerHealth;
    int playerAttack;
    int playerDefense;
    int playerSpeed;

    int playerEnergy;

    Entity enemy;

    int enemyMaxHealth;
    int enemyHealth;
    int enemyAttack;
    int enemyDefense;
    int enemySpeed;
    int enemyEnergy;


    public Battle(Player player, Entity enemy){
        actions = new Hashtable<>();
        actions.put(1, "attack");
        actions.put(2, "critical");
        actions.put(3, "block");
        actions.put(4, "parry");
        actions.put(5, "consume");
        handbag = player.getHandbag();
        this.player = player;
        this.enemy = enemy;

    }


    private void initializeStats(){
        //PLAYER
        playerHealth = player.getBaseHealth() + player.getArmour().getHealth();
        playerMaxHealth = playerHealth;
        playerAttack = player.getBaseAttack() + player.getArmour().getAttack();
        playerDefense = player.getBaseDefense() + player.getArmour().getDefense();
        playerSpeed = player.getBaseSpeed() + player.getArmour().getSpeed();
        playerEnergy = 0;  //POTENTIALLY MAKE SO MORE ENERGY START IF YOU FASTER

        //ENEMY
        enemyHealth = enemy.getBaseHealth();
        enemyMaxHealth = enemyHealth;
        enemyAttack= enemy.getBaseAttack();
        enemyDefense= enemy.getBaseDefense();
        enemySpeed =  enemy.getBaseSpeed();
        enemyEnergy = 0;

    }

    public void start(){

        initializeStats();
        System.out.println("BATTLE START");
        handbag.add(new Consumable("Potion Ahh","Potion",10,.70,.1,.1,.1)); //TESTING;


        for (int rounds = 1; playerHealth > 0 || enemyHealth > 0; rounds++){
            int usedEnergy = 0;

            System.out.println("ROUND " + rounds + "\n-------------------------------------------------------------------------");
            restoreEnergy();
            moveStack.clear();
            for (int bout = 0; bout < 3; bout++){
                int maxChoice = 5;
                String options = "\n1) Basic Attack (1 Cost)\n2) Critical Attack (2 Cost)\n3) Block (0 Cost)\n4) Parry (1 Cost)\n5) Use Item";
                if (!moveStack.isEmpty()){options += "\n6) UNDO"; maxChoice = 6;
                    System.out.println(moveStack + "\n-------------------------------------------------------------------------");}
                    System.out.println(Utility.spaceout("Your  Health: " + playerHealth +"/" + playerMaxHealth,24) +Utility.healthBar(playerHealth, playerMaxHealth));
                    System.out.println(Utility.spaceout("Enemy Health: " + enemyHealth +"/" + enemyMaxHealth,24) +Utility.healthBar(enemyHealth, enemyMaxHealth));
                    System.out.println("-------------------------------------------------------------------------\nAction " + (bout + 1) + " of " + 3);
                    System.out.println("ENERGY: " + playerEnergy + " ENERGY USED: " + usedEnergy);
                    System.out.println("What would you like to do?" + options);
                    int choice = Utility.tryInput(scan.nextLine(),maxChoice);
                    while (choice < 5 && playerEnergy < getCost(actions.get(choice))){
                        if (playerEnergy < getCost(actions.get(choice))){
                            System.out.println("Insufficent Energy, Try again");
                        }
                         choice = Utility.tryInput(scan.nextLine(),maxChoice);
                    }
                    if (choice == 5){
                        if (handbag.isEmpty()){
                            System.out.println("You got no Consumables left");
                            bout--;
                        } else {
                            String res = chooseConsume();
                            if (res.equals("undo")){
                                bout--;
                            } else {
                                moveStack.push(res);
                            }
                        }
                    }
                    if (choice == 6){

                        bout -= 2;
                        String previous = moveStack.pop();
                        playerEnergy += getCost(previous);
                        usedEnergy -= getCost(previous);
                        if (previous.contains(",")){

                            handbag.add(Consumable.decode(previous.substring(0,previous.length()-2)));
                        }
                    } else {
                        if (choice != 5){moveStack.push(actions.get(choice));}
                        playerEnergy -= getCost(actions.get(choice));
                        usedEnergy += getCost(actions.get(choice));
                    }
            } // end of choosing for one round
            enemyMove();
            useStacks();



        }





    }//END of START-------------------


    private void restoreEnergy(){
        playerEnergy += 3;
        enemyEnergy += 3;
        if (playerEnergy > 5){
            playerEnergy = 5;
        }
        if (enemyEnergy > 5){
            enemyEnergy = 5;
        }
    }

    private int getCost(String move){
        if (move.equals("attack") || move.equals("parry")){ return 1;}
        if (move.equals("critical")){ return 2;}
        return 0;
    }

    private String chooseConsume(){
        Consumable consumable = null;
        boolean picked = false;
        while (!picked){
            System.out.println("What item would you like to use?\n");
            for (int i = 0; i < handbag.size(); i++){
                System.out.println((i+1) + ") " + handbag.get(i));
            }
            System.out.println( handbag.size() + 1 + ") Decide not to use a potion");
            int pickConsumable = Utility.tryInput(scan.nextLine(),handbag.size() + 1) - 1;
            if ( pickConsumable != handbag.size()){
                consumable = handbag.get(pickConsumable);
                System.out.println("Are you sure you want to use: " + consumable + "\n----------\n1)Yes\n2)No");
                int decide = Utility.tryInput(scan.nextLine(),2);
                if (decide == 1){picked = true; handbag.remove(pickConsumable);}
            } else {
                return "undo";
            }


        }
        System.out.println("Who do you want to use it on?\n1) Yourself\n2) Enemy");
        return consumable.encode() + "," + Utility.tryInput(scan.nextLine(),2);
    }


//////////// ENEMY SIDE


    private void enemyMove(){
        for (int bout = 0; bout < 3; bout++){
            if (enemyEnergy >= 2){
                if (Utility.chance(1,3)){
                    enemyStack.push("critical");
                    enemyEnergy -= 2;
                } else {
                    if (Utility.chance(1,2)){
                        enemyStack.push("parry");
                        enemyEnergy--;
                    } else {
                        if (Utility.chance(1,2)){
                            enemyStack.push("block");
                        } else {
                            enemyStack.push("attack");
                            enemyEnergy--;
                        }
                    }
                }
            } else if (enemyEnergy == 1){
                if (Utility.chance(1,2)){
                    enemyStack.push("attack");
                    enemyEnergy--;
                } else {
                    enemyStack.push("block");
                }
            } else {
                enemyStack.push("block");
            }

        }


    }



///// DO THE BATTLE

    private void useStacks(){
        for (int bout =  0; bout < 3; bout++){
            System.out.println("\nBOUT " + (bout+1) + "-------------------------------------------------------------------------");
            String pMove = moveStack.getInternalList().get(bout);
            String eMove = enemyStack.getInternalList().get(bout);
            if (pMove.equals("attack")){ // YOUR ATTACK
                if (eMove.equals("block")){System.out.println(enemy.getName() + " blocked your attack!");}
                if (eMove.equals("attack")){
                    if (playerSpeed >= enemySpeed){
                        System.out.println("You hit the " + enemy.getName() + " for " + (damageCalc(enemyDefense,playerAttack))+ " damage!");
                        if (enemyHealth > 0) {
                            System.out.println(enemy.getName() + " hits you back for " + damageCalc(playerDefense,enemyAttack)+ " damage!");
                        }
                    } else {
                        System.out.println(enemy.getName() + " hits you for " + damageCalc(playerDefense,enemyAttack)+ " damage!");
                        if (playerHealth > 0){
                            System.out.println("You hit the " + enemy.getName() + " back for " + (damageCalc(enemyDefense,playerAttack))+ " damage!");
                        }
                    }
                    }
                if (eMove.equals("parry")){System.out.println(enemy.getName() + " parried your attack, catching you off guard.\nYou lose 1 energy"); playerEnergy--;}
                if (eMove.equals("critical")){
                    if (playerSpeed >= enemySpeed){
                      System.out.println("You hit the " + enemy.getName() + " for " + (damageCalc(enemyDefense,playerAttack))+ " damage!");
                    if (enemyHealth > 0) {
                        System.out.println(enemy.getName() + " hits you back critically for " + damageCalc(playerDefense,enemyAttack * 3 / 2)+ " damage!");
                    }
                } else {
                    System.out.println(enemy.getName() + " hits you critically for " + damageCalc(playerDefense,enemyAttack * 2 / 3)+ " damage!");
                    if (playerHealth > 0){
                        System.out.println("Dazed, you weren't able to attack back" ); //MAYBE daze so you dont attack back
                    }
                }}
            }

            if (pMove.equals("block")){ ////////////
                if (eMove.equals("block")){System.out.println("You stare at each other...\nawkwardly");}
                if (eMove.equals("attack")){System.out.println(enemy.getName() + " tries to attack you but you blocked ");}
                if (eMove.equals("parry")){System.out.println(enemy.getName() + " anticipated an attack, however you sat there starring...\ngood for you..");}
                if (eMove.equals("critical")){
                    System.out.println("The " + enemy.getName() + " strikes through your block, dealing " + damageCalc(playerDefense,enemyAttack*3/2) + " damage!");
                }
            }

            if (pMove.equals("critical")){
                if (eMove.equals("block")){System.out.println("You crush through their defense, dealing " + damageCalc(enemyDefense,playerAttack*3/2) + " damage");}
                if (eMove.equals("attack")){ if (playerSpeed >= enemySpeed){
                    System.out.println("You critically hit the " + enemy.getName() + " for " + (damageCalc(enemyDefense,playerAttack * 3/2))+ " damage!");
                    System.out.println("Dazed, the " + enemy.getName() + " was unable to retaliate");
                } else {
                    System.out.println(enemy.getName() + " hits you for " + damageCalc(playerDefense,enemyAttack)+ " damage!");
                    if (playerHealth > 0){
                        System.out.println("You critically hit the " + enemy.getName() + "  for " + (damageCalc(enemyDefense,playerAttack * 3/2))+ " damage!");
                    }
                }}
                if (eMove.equals("parry")){System.out.println( enemy.getName() + " parried your attack, catching you off guard.\nYou lose 1 energy"); playerEnergy--;}
                if (eMove.equals("critical")){
                    if (playerSpeed >= enemySpeed){
                        System.out.println("You critically hit the " + enemy.getName() + " for " + (damageCalc(enemyDefense,playerAttack * 3/2))+ " damage!");
                        System.out.println("Dazed, the " + enemy.getName() + " was unable to retaliate");
                    } else {
                        System.out.println(enemy.getName() + " hits you critically for " + damageCalc(playerDefense,enemyAttack * 3 / 2)+ " damage!");
                        if (playerHealth > 0){
                            System.out.println("Dazed, you weren't able to attack back" );
                        }
                    }}

            }

            if (pMove.equals("parry")){
                if (eMove.equals("block")){System.out.println("The " + enemy.getName() + " predicts your counter");}
                if (eMove.equals("attack") || eMove.equals("critical")){System.out.println("You parry their attack, breaking their stance\n-1 Enemy Energy"); enemyEnergy--;}
                if (eMove.equals("parry")){System.out.println("Both you and the " + enemy.getName() + " contemplate your life choices ");}
                if (eMove.equals("critical")){System.out.println("You parry their attack, breaking their balance \n-1 Enemy Energy");enemyEnergy--;}

            }


        } ///
        System.out.println("-------------------------------------------------------------------------------\n\n\n");

    }


    public static int damageCalc(int defense, int attack){
        if (defense > attack){
            return attack /5;
        } else {
            return  attack - defense;
        }


    }



}
