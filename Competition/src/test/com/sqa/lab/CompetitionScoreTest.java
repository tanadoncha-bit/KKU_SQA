package test.com.sqa.lab;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import main.com.sqa.lab.CompetitionScore;

public class CompetitionScoreTest {

    CompetitionScore cs = new CompetitionScore();

    // ===========================
    // Valid Test : score1, score2, score3
    // ===========================
    @ParameterizedTest
    @CsvSource({
        // TC001
        "100,200,300,300",
        // คะแนนต่ำสุด
        "0,0,0,0",
        // คะแนนสูงสุดอยู่ score1
        "500,200,300,500",
        // คะแนนสูงสุดอยู่ score2
        "100,500,300,500",
        // คะแนนสูงสุดอยู่ score3
        "100,200,500,500"
    })
    void testFindMaxScore(int score1, int score2, int score3, int expected) {

        assertEquals(expected,
                cs.findMaxScore(score1, score2, score3));

    }

    // ===========================
    // Invalid Test : score1, score2, score3
    // ===========================
    @ParameterizedTest
    @CsvSource({
        // TC002
        "-1,200,300",

        // TC003
        "501,200,300",

        // TC004
        "100,-1,300",

        // TC005
        "100,501,300",

        // TC006
        "100,200,-1",

        // TC007
        "100,200,501",

        // TC010
        "-1,-1,300",

        // TC011
        "-1,200,-1",

        // TC012
        "501,501,300",

        // TC013
        "501,200,501",

        // TC014
        "100,501,501",

        // TC015
        "-1,-1,-1",

        // TC016
        "501,501,501"
    })
    void testFindMaxScoreException(int score1, int score2, int score3) {

        assertThrows(IllegalArgumentException.class,
                () -> cs.findMaxScore(score1, score2, score3));

    }

    // ===========================
    // Valid Test : int[] scores
    // ===========================
    @ParameterizedTest
    @CsvSource({
        "100,200,300,300",
        "0,0,0,0",
        "500,200,300,500",
        "100,500,300,500",
        "100,200,500,500"
    })
    void testFindMaxScoreArray(int score1, int score2, int score3, int expected) {

        int[] scores = {score1, score2, score3};

        assertEquals(expected,
                cs.findMaxScore(scores));

    }

    // ===========================
    // Invalid Test : int[] scores
    // ===========================
    static Stream<Arguments> invalidArrayProvider() {

        return Stream.of(
                // TC008
                Arguments.of(new int[]{100,200}),

                // TC009
                Arguments.of(new int[]{100,200,300,400}),

                // Null
                Arguments.of((Object) null)
        );

    }

    @ParameterizedTest
    @MethodSource("invalidArrayProvider")
    void testFindMaxScoreArrayException(int[] scores) {

        assertThrows(IllegalArgumentException.class,
                () -> cs.findMaxScore(scores));

    }

}