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

            System.out.println("ROUND " + rounds + "\n--------------------------------------------------------------------");
            restoreEnergy();
            moveStack.clear();
            for (int bout = 0; bout < 3; bout++){
                int maxChoice = 5;
                String options = "\n1) Basic Attack (1 Cost)\n2) Critical Attack (2 Cost)\n3) Block (0 Cost)\n4) Parry (1 Cost)\n5) Use Item";
                if (!moveStack.isEmpty()){options += "\n6) UNDO"; maxChoice = 6;
                    System.out.println(moveStack);}
                    System.out.println("---------------------------------------------------------\nAction " + (bout + 1) + " of " + 3);
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




            }




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
                } else {
                    if (Utility.chance(1,2)){
                        enemyStack.push("parry");
                    } else {
                        if (Utility.chance(1,2)){
                            enemyStack.push("block");
                        } else {
                            enemyStack.push("attack");
                        }
                    }
                }
            } else if (enemyEnergy == 1){
                if (Utility.chance(1,2)){
                    enemyStack.push("attack");
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
            String pMove = moveStack.pop();
            String eMove = enemyStack.pop();
            if (pMove.equals("attack")){ // YOUR ATTACK
                if (eMove.equals("block")){System.out.println(enemy.getName() + " blocked your attack!");}
                if (eMove.equals("attack")){
                    if (playerSpeed >= enemySpeed){
                        System.out.println("You hit the" + enemy.getName() + " for " + (damageCalc(enemyDefense,playerAttack)));
                        if (enemyHealth > 0) {
                            System.out.println(enemy.getName() + " hits you back for " + damageCalc(playerDefense,enemyAttack));
                        }
                    } else {
                        System.out.println(enemy.getName() + " hits you for " + damageCalc(playerDefense,enemyAttack));
                        if (playerHealth > 0){
                            System.out.println("You hit the " + enemy.getName() + " back for " + (damageCalc(enemyDefense,playerAttack)));
                        }
                    }
                    }
                if (eMove.equals("parry")){System.out.println(enemy.getName() + " parried your attack!\nYou lose 1 energy"); playerEnergy--;}
                if (eMove.equals("critical")){
                    if (playerSpeed >= enemySpeed){
                      System.out.println("You hit the" + enemy.getName() + " for " + (damageCalc(enemyDefense,playerAttack)));
                    if (enemyHealth > 0) {
                        System.out.println(enemy.getName() + " hits you back critically for " + damageCalc(playerDefense,enemyAttack * 3 / 2));
                    }
                } else {
                    System.out.println(enemy.getName() + " hits you critically for " + damageCalc(playerDefense,enemyAttack * 2 / 3));
                    if (playerHealth > 0){
                        System.out.println("You hit the " + enemy.getName() + " back for " + (damageCalc(enemyDefense,playerAttack))); //MAYBE daze so you dont attack back
                    }
                }}
            }


        }


    }


    public static int damageCalc(int defense, int attack){
        if (defense > attack){
            return attack /20;
        } else {
            return defense - attack;
        }


    }






}
