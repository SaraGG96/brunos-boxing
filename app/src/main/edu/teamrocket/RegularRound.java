package edu.teamrocket;

public class RegularRound implements Round {

    private String roundScore;
    private byte redBoxerScore;
    private byte blueBoxerScore;

    public RegularRound(String roundScore) {
        this.roundScore = roundScore.replace(" ", "");
        boxerRoundScore();
    }

    public String getRoundScore() {
        return roundScore;
    }

    @Override
    public void boxerRoundScore() {
        String[] splitScore = roundScore.split("-");
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