import java.util.Optional;

public class RoundFactory {

    public static Round getRound(String roundScore) {
        if (Optional.ofNullable(roundScore).isEmpty()) {
            return null;
        }

        String normalizedScore = roundScore.replace(" ", "");

        if (normalizedScore.equals("10-8,1") || normalizedScore.equals("1,8-10")) {
            return new PointsDeducted(normalizedScore);
        }

        if (normalizedScore.equals("10-8") || normalizedScore.equals("8-10")) {
            return new KnockdownRound(normalizedScore);
        }

        if (normalizedScore.equals("10-9") || normalizedScore.equals("9-10")) {
            return new RegularRound(normalizedScore);
        }

        return null;
    }
}