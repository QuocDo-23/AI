package Model;

public class RuleBasedStrategy implements SpamDetectionStrategy {
    @Override
    public boolean isSpam(String text) {
        String t = text.toLowerCase();
        return t.contains("win") || t.contains("free") || t.contains("prize")
                || t.contains("click here") || t.contains("money");
    }
}