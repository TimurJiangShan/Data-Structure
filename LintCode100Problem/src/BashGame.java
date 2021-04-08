public class BashGame {
    public boolean canWinBash(int n) {
        if(n%4 == 0){
            return false;//后手必赢
        }
        else return true;
    }
}
