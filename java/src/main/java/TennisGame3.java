
public class TennisGame3 implements TennisGame {

    private int pointsPlayer1;
    private int pointsPlayer2;
    private String namePlayer1;
    private String namePlayer2;

    public TennisGame3(String namePlayer1, String namePlayer2) {
        this.namePlayer1 = namePlayer1;
        this.namePlayer2 = namePlayer2;
    }

    public String getScore() {
        String s;
        if (pointsPlayer1 < 4 && pointsPlayer2 < 4 && !(pointsPlayer1 + pointsPlayer2 == 6)) {
            String[] p = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
            s = p[pointsPlayer1];
            return (pointsPlayer1 == pointsPlayer2) ? s + "-All" : s + "-" + p[pointsPlayer2];
        } else {
            if (pointsPlayer1 == pointsPlayer2)
                return "Deuce";
            s = pointsPlayer1 > pointsPlayer2 ? namePlayer1 : namePlayer2;
            return ((pointsPlayer1 - pointsPlayer2) * (pointsPlayer1 - pointsPlayer2) == 1) ? "Advantage " + s : "Win for " + s;
        }
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            this.pointsPlayer1++;
        else
            this.pointsPlayer2++;

    }

}
