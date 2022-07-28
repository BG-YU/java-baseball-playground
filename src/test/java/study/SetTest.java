package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("numbers의 사이즈 갯수가 3인지 테스트 한다.")
    void setSizeTest() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("numbers에 들어 있는 숫자가 1,2,3이 맞는지 테스트 한다.")
    void numbersSizeTest(Integer input) {
        assertTrue(numbers.contains(input));
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true","2:true","3:true","4:false","5:false"}, delimiter = ':')
    @DisplayName("numbers에 들어 있는 숫자가 1,2,3이 맞다면 true 나머지는 false")
    void numbersTrueOrFalseTest(int input, boolean expected) {
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }
}
