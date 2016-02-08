import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class BowlingGameTest {

    private Game game;

    @Before
    public void setUp() throws Exception {
        game = new Game();
    }

    @Test
    public void testGutterGame() {
        rollMany(20, 0);
        assertThat(game.score()).isEqualTo(0);
    }

    @Test
    public void testAllOnes() {
        rollMany(20, 1);
        assertThat(game.score()).isEqualTo(20);
    }

    @Test
    public void testOneSpare() {
        rollSpare();
        game.roll(3);
        rollMany(17, 0);
        assertThat(game.score()).isEqualTo(16);
    }

    private void rollSpare() {
        game.roll(5);
        game.roll(5);
    }

    private void rollMany(int n, int pins) {
        for (int i = 0; i < n; i++) {
            game.roll(pins);
        }
    }
}
