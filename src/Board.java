public class Board {
    public String name;
    //    public char sign;
    public boolean turn;
    public final char[][] playground;

    public Board() {
        this.playground = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.playground[i][j] = '_';
            }
        }
    }

    public boolean whoseTurn(){return turn;}

    public void showBoard(){
        for (int i = 0; i<3; i++){
            for (int j = 0; j<3; j++){
                System.out.print(playground[i][j]+ (j!=2? " | ":""));
            }
            System.out.println();
        }

    }
    public boolean checkTie(){
        for (int i = 0; i<3; i++){
            for (int j = 0; j<3; j++){
                if(playground[i][j] == '_')
                    return false;
            }
        }
        return true;
    }

    public void playerMove(int x, int y, boolean man){
        --x; --y;

        if(x<0 || x>2 || y<0 || y>2 || playground[x][y] != '_'){
            System.out.println("Invalid move! Try Again: ");
            return;
        }

        this.playground[x][y] = man ? 'X':'O';
        this.turn = !this.turn;
    }

    public boolean gameOver(String man, String kid){
        String winner = this.turn ? man:kid;
        char sign = this.turn? 'X':'O';

        for (int i = 0; i < 3; i++) {
            if (playground[0][i] == sign && playground[1][i] == sign && playground[2][i] == sign) {
                System.out.println(winner + " is the winner!");
                return true;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (playground[i][0] == sign && playground[i][1] == sign && playground[i][2] == sign) {
                System.out.println(winner + " is the winner!");
                return true;
            }
        }

        if ((playground[0][0] == sign && playground[1][1] == sign && playground[2][2] == sign) || (playground[0][2] == sign && playground[1][1] == sign && playground[2][0] == sign)) {
            System.out.println("Game over, " + winner + " has won!");
            return true;
        }

        if (this.checkTie()) {
            System.out.println("Tie! Well played both of you!");
            return true;
        }

        return false;
    }
}
