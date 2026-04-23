import java.util.Optional;

public class ScoreCard {

    private final String color;
    private String redCorner = "";
    private String blueCorner = "";

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

    @Override
    public String toString() {
        return "\n\t " + color + " SCORE CARD" +
               "\n\t Red corner: " + redCorner +
               "\n\t Blue corner: " + blueCorner;
    }
}