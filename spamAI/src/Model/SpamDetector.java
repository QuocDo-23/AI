package Model;

public class SpamDetector {
    private static SpamDetector instance;
    private SpamDetectionStrategy strategy;

    private SpamDetector() {
        this.strategy = new RuleBasedStrategy(); // mặc định
    }

    public static SpamDetector getInstance() {
        if (instance == null)
            instance = new SpamDetector();
        return instance;
    }

    public void setStrategy(SpamDetectionStrategy s) {
        this.strategy = s;
    }

    public boolean isSpam(String text) {
        return strategy.isSpam(text);
    }
}
