import java.util.Scanner;

public class Game {
    public static void startGame(){

        Scanner sc = new Scanner(System.in);

        TicTacToePlayer t1 = new TicTacToePlayer();
        TicTacToePlayer t2 = new TicTacToePlayer();

        System.out.println("Provide informations for Player 1:");
        t1.input();
        t1.setSign('X');
        System.out.println("\nProvide informations for Player 2:");
        t2.input();
        t2.setSign('O');

        System.out.println("Sign for the player "+t1.getName()+" is: X");
        System.out.println("Sign for the player "+t2.getName()+" is: 0");

        boolean continuePlaying = true;

        while (continuePlaying){
            Board board = new Board();
            while (!board.gameOver(t1.getName(), t2.getName())){
                board.showBoard();
                String currentMove = board.whoseTurn()? t1.getName() : t2.getName();
                System.out.println("Move by "+currentMove+": ");
                int x,y;
                x = sc.nextInt();
                y = sc.nextInt();
                board.playerMove(x,y, board.whoseTurn());
            }

            System.out.println("Continue playing? [y/n]: ");
            String c = sc.next();
            if(c.charAt(0) != 'y' && c.charAt(0) != 'Y')
                continuePlaying = false;
        }
    }
}
