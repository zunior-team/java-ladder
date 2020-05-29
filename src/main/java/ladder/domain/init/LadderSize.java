package ladder.domain.init;

public class LadderSize {
    private final int width;
    private final int height;

    private LadderSize(final int width, final int height) {
        this.width = width;
        this.height = height;
    }

    public static LadderSize init(final int width, final int height) {
        return new LadderSize(width, height);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
