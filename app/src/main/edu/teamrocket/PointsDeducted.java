package edu.teamrocket;

public class PointsDeducted implements Round {

    private String roundScore;
    private byte redBoxerScore;
    private byte blueBoxerScore;

    public PointsDeducted(String roundScore) {
        this.roundScore = roundScore.replace(" ", "");
        boxerRoundScore();
    }

    public String getRoundScore() {
        return roundScore;
    }

    @Override
    public void boxerRoundScore() {
        String scoreWithoutDeduction = roundScore;

        if (scoreWithoutDeduction.startsWith("1,")) {
            scoreWithoutDeduction = scoreWithoutDeduction.substring(2);
        }

        if (scoreWithoutDeduction.endsWith(",1")) {
            scoreWithoutDeduction = scoreWithoutDeduction.substring(0, scoreWithoutDeduction.length() - 2);
        }

        String[] splitScore = scoreWithoutDeduction.split("-");
        redBoxerScore = Byte.parseByte(splitScore[0]);
        blueBoxerScore = Byte.parseByte(splitScore[1]);
    }

    @Override
    public byte getRedBoxerScore() {
        return redBoxerScore;
    }

    @Override
    public byte getBlueBoxerScore() {
        return blueBoxerScore;
    }
}