
public class TennisGame3 implements TennisGame {

    public static final String[] POINTS_NAMES = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
    private int pointsPlayer1;
    private int pointsPlayer2;
    private final String namePlayer1;
    private final String namePlayer2;

    public TennisGame3(String namePlayer1, String namePlayer2) {
        this.namePlayer1 = namePlayer1;
        this.namePlayer2 = namePlayer2;
    }

    public String getScore() {
        if (isEarlyGame()) {
            return getEarlyGameScore();
        } else {
            return getScoreForLongerGame();
        }
    }

    private boolean isEarlyGame() {
        return pointsPlayer1 < 4 && pointsPlayer2 < 4 && !(pointsPlayer1 + pointsPlayer2 == 6);
    }

    private String getScoreForLongerGame() {
        if (isPlayersHaveSamePoints()) return "Deuce";

        String playerNameWithBetterScore = (pointsPlayer1 > pointsPlayer2) ? namePlayer1 : namePlayer2;
        if (isAdvantage()) return "Advantage " + playerNameWithBetterScore;

        return "Win for " + playerNameWithBetterScore;
    }

    private boolean isAdvantage() {
        int scoreDifferenceBetweenPlayers = pointsPlayer1 - pointsPlayer2;
        return scoreDifferenceBetweenPlayers * scoreDifferenceBetweenPlayers == 1;
    }

    private String getEarlyGameScore() {
        String pointNameForPlayer1 = getNameForPlayerPoints(pointsPlayer1);
        if (isPlayersHaveSamePoints()) return pointNameForPlayer1 + "-All";

        String pointNameForPlayer2 = getNameForPlayerPoints(pointsPlayer2);
        return pointNameForPlayer1 + "-" + pointNameForPlayer2;
    }

    private String getNameForPlayerPoints(int playerPoints) {
        return POINTS_NAMES[playerPoints];
    }

    private boolean isPlayersHaveSamePoints() {
        return pointsPlayer1 == pointsPlayer2;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1") {
            this.pointsPlayer1++;
        } else {
            this.pointsPlayer2++;
        }
    }

}
