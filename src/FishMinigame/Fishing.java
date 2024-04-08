import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.Spliterator;

public class Fishing {

    private Player player;
    private Space[][] board;
    private Scanner scan;
    private int userMoves = 0;
    private int fishCount = 0;
    private int maxFish = 0;
    int level = 1;


    public Fishing(Player player) {
        scan = new Scanner(System.in);
        this.player = player;
    }

    private void setupBoard() {
        Treasure t1 = new Treasure("\uD83C\uDF0A");
        Treasure t2 = new Treasure("\uD83C\uDF0A");
        Treasure t3 = new Treasure("\uD83C\uDF0A");
        Treasure t4 = new Treasure("\uD83C\uDF0A");
        Treasure[] treasureList = {t1, t2, t3, t4};
        System.out.println("Where do you wish to Fish?\n1) Forest Pond\n2) Lake Pier\n3) Ocean" );
        level = Utility.tryInput(scan.nextLine(),3);
        Dictionary<Integer,Integer> fishCount = new Hashtable<>();
        fishCount.put(1,4); fishCount.put(2,6); fishCount.put(3,8);
        maxFish = fishCount.get(level);
        if (level == 1) {
            board = new Space[5][10];
        } else if (level == 2) {
            board = new Space[7][14];
        } else if (level == 3){
            board = new Space[9][18];
        }
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (col % 2 == 0) {
                    board[row][col] = new Space("\uD83D\uDFE6");
                } else {
                    board[row][col] = new Space(" ");
                }
            }
        }
        board[0][(board[0].length / 2) - 1] = new Space("\uD83E\uDE9D");
        for (int i = 0; i < fishCount.get(level); i++) {
            int randX = ((int) (Math.random() * board.length - 1)) + 1;
            int randY = ((int) (Math.random() * board[0].length - 1)) + 1;
            if (board[randX][randY].getSymbol().equals("\uD83D\uDFE6")) {
                board[randX][randY] = new Treasure("\uD83C\uDF0A");
            } else {
                i--;
            }
        }
    }
    private void printBoard() {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                System.out.print(board[row][col].getSymbol());
            }
            System.out.println();
        }
    }
    // plays the game;
    public void play() {
        setupBoard();
        printBoard();
        Scanner scan = new Scanner(System.in);
        int xCoord = 0;
        int yCoord = (board[0].length / 2) - 1;
        String choice = "z";
        Dictionary<Integer,Integer> maxMoves = new Hashtable<>();
        maxMoves.put(1,9); maxMoves.put(2,12); maxMoves.put(3,15);
        while (userMoves < maxMoves.get(level) && fishCount < maxFish) {
            System.out.println("\nWould you like to:\nW) move up\nA) move left\nS) move down\nD) move right");
            choice = scan.nextLine();
            if ((choice.equals("W") || choice.equals("w")) && xCoord - 1 >= 0) {
                if (board[xCoord - 1][yCoord] instanceof Treasure) {
                    System.out.println("You caught a fish!");
                    fishCount++;
                }
                board[xCoord - 1][yCoord] = new Space("\uD83E\uDE9D");
                board[xCoord][yCoord] = new Space("\uD83D\uDFE6");
                xCoord--;
                userMoves++;
            } else if ((choice.equals("A") || choice.equals("a")) && yCoord - 2 >= 0) {
                if (board[xCoord][yCoord - 2] instanceof Treasure) {
                    System.out.println("You caught a fish!");
                    fishCount++;
                }
                board[xCoord][yCoord - 2] = new Space("\uD83E\uDE9D");
                board[xCoord][yCoord] = new Space("\uD83D\uDFE6");
                yCoord-=2;
                userMoves++;
            } else if ((choice.equals("S") || choice.equals("s")) && xCoord + 1 <= board.length - 1) {
                if (board[xCoord + 1][yCoord] instanceof Treasure) {
                    System.out.println("You caught a fish!");
                    fishCount++;
                }
                board[xCoord + 1][yCoord] = new Space("\uD83E\uDE9D");
                board[xCoord][yCoord] = new Space("\uD83D\uDFE6");
                xCoord++;
                userMoves++;
            } else if ((choice.equals("D") || choice.equals("d")) && yCoord + 2 <= board[0].length - 1) {
                if (board[xCoord][yCoord + 2] instanceof Treasure) {
                    System.out.println("You caught a fish!");
                    fishCount++;
                }
                board[xCoord][yCoord  + 2] = new Space("\uD83E\uDE9D");
                board[xCoord][yCoord] = new Space("\uD83D\uDFE6");
                yCoord+=2;
                userMoves++;
            }
            int remaining = maxMoves.get(level) - userMoves;


            System.out.println("\n\n\nUser moves remaining: " + remaining);
            System.out.println("Total Fish caught: " + fishCount + "/" + maxFish );
            printBoard();
        } //end of Loop
        Dictionary<Integer,int[]> lootPool = new Hashtable<>();
        int[] pool1 = {38,38,39,39,40};
        int[] pool2 = {41,41,40,40,42};
        int[] pool3 = {43,43,44,44,45,47,46,};
        lootPool.put(1,pool1); lootPool.put(2,pool2); lootPool.put(3,pool3);
        System.out.println("est");
        for (int i = 0; i < fishCount; i++){
            int[] lootPoolPick = lootPool.get(level);
            int chosenLoot = lootPoolPick[(int)(Math.random() * lootPoolPick.length)];
            player.getBag().add(chosenLoot,1);
        }

    }
}