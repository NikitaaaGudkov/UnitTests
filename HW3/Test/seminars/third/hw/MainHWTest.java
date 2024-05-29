package seminars.third.hw;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MainHWTest {

    MainHW mainHW;

    @BeforeEach
    void setUp() {
        mainHW = new MainHW();
    }

    @Test
    void checkIsEven() {
        assertThat(mainHW.isEven(4)).isEqualTo(true);
        assertThat(mainHW.isEven(5)).isEqualTo(false);
    }


    @Test
    void checkNumberInInterval() {
        assertThat(mainHW.numberInInterval(5)).isEqualTo(false);
        assertThat(mainHW.numberInInterval(25)).isEqualTo(false);
        assertThat(mainHW.numberInInterval(50)).isEqualTo(true);
        assertThat(mainHW.numberInInterval(100)).isEqualTo(false);
        assertThat(mainHW.numberInInterval(150)).isEqualTo(false);
    }
}