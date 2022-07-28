package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void splitTest() {
        String[] actual = "1,2".split(",");
        String[] correct = {"1", "2"};
        assertThat(actual).containsExactly(correct);
        assertThat(actual.length).isEqualTo(2);
//        assertThat(actual).containsExactly()
    }

    @Test
    void splitTest2() {
        String[] actual = "1".split(",");
        String[] correct = {"1"};
        assertThat(actual.length).isEqualTo(1);
        assertThat(actual).containsExactly(correct);
    }

    @Test
    void subStringTest() {
        String str = "(1,2)";
        String actual = str.substring(1, 4);
        assertThat(actual).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt으로 index의 글자값을 올바로 가져올때랑 틀리게 가져올때 Test")
    void charAtTest() {
        String str = "abc";

        assertThat(str.charAt(1)).isEqualTo('b');
        assertThatThrownBy(() -> assertThat(str.charAt(3)).isEqualTo(""))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> assertThat(str.charAt(3)).isEqualTo(""))
                .withMessageMatching("String index out of range: \\d+");
    }
}
