
public class TennisGame1 implements TennisGame {

    private int playerOneScore = 0;
    private int playerTwoScore = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            playerOneScore += 1;
        else
            playerTwoScore += 1;
    }

    public String getScore() {
        if (isSameScore()) {
            return handleSameScoreForBothPlayers();
        } else if (isAnyPlayerCloseToWin()) {
            return handlePlayerAboutToWin();
        } else {
            return handleRegularScore();
        }
    }

    private String handleRegularScore() {
        StringBuilder scoreBuilder = new StringBuilder();
        int tempScore = 0;
        for (int i = 1; i < 3; i++) {
            if (i == 1) tempScore = playerOneScore;
            else {
                scoreBuilder.append("-");
                tempScore = playerTwoScore;
            }
            switch (tempScore) {
                case 0 -> scoreBuilder.append("Love");
                case 1 -> scoreBuilder.append("Fifteen");
                case 2 -> scoreBuilder.append("Thirty");
                case 3 -> scoreBuilder.append("Forty");
            }
        }
        return scoreBuilder.toString();
    }

    private String handlePlayerAboutToWin() {
        int minusResult = playerOneScore - playerTwoScore;
        if (minusResult == 1) return "Advantage player1";
        else if (minusResult == -1) return "Advantage player2";
        else if (minusResult >= 2) return "Win for player1";
        else return "Win for player2";
    }

    private boolean isAnyPlayerCloseToWin() {
        return playerOneScore >= 4 || playerTwoScore >= 4;
    }

    private boolean isSameScore() {
        return playerOneScore == playerTwoScore;
    }

    private String handleSameScoreForBothPlayers() {
        return switch (playerOneScore) {
            case 0 -> "Love-All";
            case 1 -> "Fifteen-All";
            case 2 -> "Thirty-All";
            default -> "Deuce";
        };
    }
}
