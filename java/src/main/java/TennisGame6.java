public class TennisGame6 implements TennisGame {
    private final String player1Name;
    private final String player2Name;
    private int player1Score;
    private int player2Score;

    public TennisGame6(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    @Override
    public void wonPoint(String playerName) {
        if (playerName.equals("player1"))
            player1Score++;
        else
            player2Score++;
    }

    public String getScore() {
        if (isTieScore()) {
            return getTieScore();
        } else if (player1Score >= 4 || player2Score >= 4) {
            return getEndGameScore();
        } else {
            return getRegularScore();
        }
    }

    private String getRegularScore() {
        return getScoreName(player1Score) + "-" + getScoreName(player2Score);
    }

    private String getScoreName(int score) {
        return switch (score) {
            case 0 -> "Love";
            case 1 -> "Fifteen";
            case 2 -> "Thirty";
            default -> "Forty";
        };
    }

    private String getTieScore() {
        return switch (player1Score) {
            case 0, 1, 2 -> getScoreName(player1Score) + "-All";
            default -> "Deuce";
        };
    }

    private String getEndGameScore() {
        if (player1Score - player2Score == 1) {
            return "Advantage " + player1Name;
        } else if (player1Score - player2Score == -1) {
            return "Advantage " + player2Name;
        } else if (player1Score - player2Score >= 2) {
            return "Win for " + player1Name;
        } else {
            return "Win for " + player2Name;
        }
    }

    private boolean isTieScore() {
        return player1Score == player2Score;
    }
}
