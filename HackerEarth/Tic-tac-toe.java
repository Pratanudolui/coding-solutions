import java.io.*;

public class TestClass {

    // Helper method to count how many 3-in-a-row lines a player has
    private static int countWinningLines(char[][] board, char p) {
        int lines = 0;
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == p && board[i][1] == p && board[i][2] == p) lines++;
        }
        // Check columns
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == p && board[1][j] == p && board[2][j] == p) lines++;
        }
        // Check diagonals
        if (board[0][0] == p && board[1][1] == p && board[2][2] == p) lines++;
        if (board[0][2] == p && board[1][1] == p && board[2][0] == p) lines++;

        return lines;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] board = new char[3][3];
        int countX = 0, countO = 0;

        for (int i = 0; i < 3; i++) {
            String line = br.readLine();
            if (line == null) return;
            for (int j = 0; j < 3; j++) {
                board[i][j] = line.charAt(j);
                if (board[i][j] == 'X') countX++;
                else if (board[i][j] == 'O') countO++;
            }
        }

        // Rule 1: X goes first, so countX can only be equal to countO or countO + 1
        if (countX < countO || countX > countO + 1) {
            System.out.println("Wait, what?");
            return;
        }

        int xLines = countWinningLines(board, 'X');
        int oLines = countWinningLines(board, 'O');

        // Rule 2: Both players cannot have winning lines simultaneously 
        // (nor can a player have more than one winning line without overlapping impossibly)
        if (xLines > 0 && oLines > 0) {
            System.out.println("Wait, what?");
            return;
        }

        // Rule 3: If X has won, X must have made the last move (countX == countO + 1)
        if (xLines > 0) {
            if (countX != countO + 1) {
                System.out.println("Wait, what?");
                return;
            }
            System.out.println("X won.");
            return;
        }

        // Rule 4: If O has won, O must have made the last move (countX == countO)
        if (oLines > 0) {
            if (countX != countO) {
                System.out.println("Wait, what?");
                return;
            }
            System.out.println("O won.");
            return;
        }

        // Rule 5: Check for draw or whose turn it is
        if (countX + countO == 9) {
            System.out.println("It's a draw.");
        } else {
            if (countX == countO) {
                System.out.println("X's turn.");
            } else {
                System.out.println("O's turn.");
            }
        }
    }
}
