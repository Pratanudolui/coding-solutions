class Solution {
    public boolean canAliceWin(int n) {
        int take = 10, moves = 0;
        while (n >= take) {
            n -= take;
            take--;
            moves++;
        }
        return moves % 2 == 1;
    }
}
