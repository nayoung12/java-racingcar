package study;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    @DisplayName("String 클래스에 대한 학습 테스트 - 요구사항1")
    void Test1() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");

        String[] texts = "1".split(",");
        assertThat(texts).containsExactly("1");
    }

    @Test
    @DisplayName("String 클래스에 대한 학습 테스트 - 요구사항2")
    void Test2(){
        String text = "(1,2)";
        assertThat(text.substring(1,4)).isEqualTo("1,2");
    }

    @Test
    @DisplayName("String 클래스에 대한 학습 테스트 - 요구사항3")
    void Test3(){
        String data3 = "abc";
        assertThat(data3.charAt(0)).isEqualTo('a');
        assertThat(data3.charAt(2)).isEqualTo('c');
        Assertions.assertThrows(StringIndexOutOfBoundsException.class, () -> {
            assertThat(data3.charAt(5)).isEqualTo('c');
        });
    }
}