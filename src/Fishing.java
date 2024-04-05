//import java.util.Scanner;
//import java.util.Spliterator;
//
//public class Fishing {
//    private Space[][] board;
//    private Player player;
//    private Scanner scan;
//    private int userMoves = 0;
//    private int fishCount = 0;
//
//
//    public Fishing() {
//        scan = new Scanner(System.in);
//        System.out.println("Easy, Medium, or Hard? (E/M/H): ");
//        String ans = scan.nextLine();
//        createPlayer();
//        setupBoard(ans);
//        play();
//    }
//
//
//    private void createPlayer() {
//        System.out.print("Please enter your name: ");
//        String name = scan.nextLine();
//        player = new Player(name);
//    }
//
//    private void setupBoard(String level) {
//        Treasure t1 = new Treasure("!", "Tuna", );
//        Treasure t2 = new Treasure("!");
//        Treasure t3 = new Treasure("!");
//        Treasure t4 = new Treasure("!");
//        Treasure[] treasureList = {t1, t2, t3, t4};
//        if (level.equals("E")) {
//            board = new Space[5][5];
//        } else if (level.equals("M")) {
//            board = new Space[7][7];
//        } else {
//            board = new Space[9][9];
//        }
//        for (int row = 0; row < board.length; row++) {
//            for (int col = 0; col < board[0].length; col++) {
//                board[row][col] = new Space("_");
//            }
//        }
//        board[0][board[0].length / 2] = player;
//        for (int i = 0; i < treasureList.length; i++) {
//            int randX = ((int) (Math.random() * board.length - 1)) + 1;
//            int randY = ((int) (Math.random() * board.length - 1)) + 1;
//            if (board[randX][randY].getSymbol().equals("_")) {
//                board[randX][randY] = treasureList[i];
//            } else {
//                i--;
//            }
//        }
//    }
//    private void printBoard() {
//        for (int row = 0; row < board.length; row++) {
//            for (int col = 0; col < board[0].length; col++) {
//                System.out.print(board[row][col].getSymbol());
//            }
//            System.out.println();
//        }
//    }
//    // plays the game;
//    private void play() {
//        printBoard();
//        Scanner scan = new Scanner(System.in);
//        int xCoord = 0;
//        int yCoord = board[0].length / 2;
//        String choice = "a";
//        while (!choice.equals("C") && userMoves < 10) {
//            System.out.println("Would you like to:\nW) move up\nA) move left\nS) move down\nD) move right\nC) cast your rod to fish ");
//            choice = scan.nextLine();
//            if (choice.equals("W") && xCoord - 1 >= 0) {
//                if (board[xCoord - 1][yCoord] instanceof Treasure) {
//                    System.out.println("You caught a fish!");
//                    fishCount++;
//                }
//                board[xCoord - 1][yCoord] = player;
//                board[xCoord][yCoord] = new Space("_");
//                xCoord--;
//                userMoves++;
//            } else if (choice.equals("A") && yCoord - 1 >= 0) {
//                if (board[xCoord][yCoord - 1] instanceof Treasure) {
//                    System.out.println("You caught a fish!");
//                    fishCount++;
//                }
//                    board[xCoord][yCoord - 1] = player;
//                board[xCoord][yCoord] = new Space("_");
//                yCoord--;
//                userMoves++;
//            } else if (choice.equals("S") && xCoord + 1 <= 7) {
//                if (board[xCoord + 1][yCoord] instanceof Treasure) {
//                    System.out.println("You caught a fish!");
//                    fishCount++;
//                }
//                board[xCoord + 1][yCoord] = player;
//                board[xCoord][yCoord] = new Space("_");
//                xCoord++;
//                userMoves++;
//            } else if (choice.equals("D") && yCoord + 1 <= 7) {
//                if (board[xCoord][yCoord + 1] instanceof Treasure) {
//                    System.out.println("You caught a fish!");
//                    fishCount++;
//                }
//                board[xCoord][yCoord  + 1] = player;
//                board[xCoord][yCoord] = new Space("_");
//                yCoord++;
//                userMoves++;
//            }
//            int remaining = 10 - userMoves;
//            System.out.println("User moves remaining: " + remaining);
//            printBoard();
//        }
//    }
//}
