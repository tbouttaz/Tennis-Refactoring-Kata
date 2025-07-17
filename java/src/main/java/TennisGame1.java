
public class TennisGame1 implements TennisGame {

    private int playerOneScore = 0;
    private int playerTwoScore = 0;
    private final String player1Name;
    private final String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (isPlayerOne(playerName)) {
            playerOneScore += 1;
        } else {
            playerTwoScore += 1;
        }
    }

    private boolean isPlayerOne(String playerName) {
        return playerName == player1Name;
    }

    public String getScore() {
        if (isSameScore()) {
            return getSameScoreForBothPlayers();
        } else if (isAnyPlayerCloseToWin()) {
            return getScoreForPlayerCloseToWin();
        } else {
            return getRegularScore();
        }
    }

    private String getRegularScore() {
        return getRegularScoreForPlayer(playerOneScore) +
                "-" +
                getRegularScoreForPlayer(playerTwoScore);
    }

    private static String getRegularScoreForPlayer(int playerScore) {
        return switch (playerScore) {
            case 0 -> "Love";
            case 1 -> "Fifteen";
            case 2 -> "Thirty";
            case 3 -> "Forty";
            default -> throw new IllegalStateException("Unexpected value: " + playerScore);
        };
    }

    private String getScoreForPlayerCloseToWin() {
        int playerOneScoreDifference = playerOneScore - playerTwoScore;
        if (playerOneScoreDifference == 1) return "Advantage " + player1Name;
        else if (playerOneScoreDifference == -1) return "Advantage " + player2Name;
        else if (playerOneScoreDifference >= 2) return "Win for " + player1Name;
        else return "Win for " + player2Name;
    }

    private boolean isAnyPlayerCloseToWin() {
        return playerOneScore >= 4 || playerTwoScore >= 4;
    }

    private boolean isSameScore() {
        return playerOneScore == playerTwoScore;
    }

    private String getSameScoreForBothPlayers() {
        return switch (playerOneScore) {
            case 0 -> "Love-All";
            case 1 -> "Fifteen-All";
            case 2 -> "Thirty-All";
            default -> "Deuce";
        };
    }
}
