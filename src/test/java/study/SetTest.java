package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;

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

    // Test Case 구현
    @Test
    @DisplayName("Set Collections에 대한 학습 테스트 - 요구사항 1")
    void checkSetSize(){
        assertThat(numbers).hasSize(3);
    }

    @ParameterizedTest
    @DisplayName("Set Collections에 대한 학습 테스트 - 요구사항 2")
    @ValueSource(ints = {1,2,3})
    void contains(int number) {
        assertThat(numbers.contains(number)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("Set Collections에 대한 학습 테스트 - 요구사항 3")
    /*
    @ValueSource(ints = {1,2,3,4,5})
    void constainsResult(int number){
       switch(number){
           case 1:
           case 2:
           case 3:
               assertThat(numbers.contains(number)).isTrue();
               break;
           case 4:
           case 5:
               assertThat(numbers.contains(number)).isFalse();
               break;
       }
    }
     */
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void constainsResult(int number, boolean expected){
        assertThat(numbers.contains(number)).isEqualTo(expected);

        assertThat(numbers);
    }
}
