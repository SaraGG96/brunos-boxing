import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ScoreCard {

    private final String color;
    private String redCorner = "";
    private String blueCorner = "";
    private final List<Round> rounds = new ArrayList<>();

    public ScoreCard(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setRCorner(String boxerName) {
        this.redCorner = Optional.ofNullable(boxerName).orElse("");
    }

    public void setBCorner(String boxerName) {
        this.blueCorner = Optional.ofNullable(boxerName).orElse("");
    }

    public void loadJudgeScoreCard(String[] judgeScoreCard) {
        rounds.clear();

        Optional.ofNullable(judgeScoreCard).ifPresent(scoreCard -> {
            for (String roundScore : scoreCard) {
                Optional.ofNullable(roundScore).ifPresent(score -> rounds.add(new RegularRound(score)));
            }
        });
    }

    public byte getNumRounds() {
        return (byte) rounds.size();
    }

    public int getRedBoxerFinalScore() {
        int totalScore = 0;

        for (Round round : rounds) {
            totalScore += round.getRedBoxerScore();
        }

        return totalScore;
    }

    public int getBlueBoxerFinalScore() {
        int totalScore = 0;

        for (Round round : rounds) {
            totalScore += round.getBlueBoxerScore();
        }

        return totalScore;
    }

    @Override
    public String toString() {
        StringBuilder text = new StringBuilder();
        text.append("\n\t ").append(color).append(" SCORE CARD");
        text.append("\n\t Red corner: ").append(redCorner);
        text.append("\n\t Blue corner: ").append(blueCorner);

        for (int i = 0; i < rounds.size(); i++) {
            Round round = rounds.get(i);
            text.append("\n\t Round ").append(i + 1).append(": ");
            text.append(round.getRedBoxerScore()).append(" - ").append(round.getBlueBoxerScore());
        }

        return text.toString();
    }
}