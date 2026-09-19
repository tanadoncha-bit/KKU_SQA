package test.java.com.Lab4;

import main.java.com.Lab4.HealthIndexScore;
import main.java.com.Lab4.HealthIndexScore.FitnessLevel;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HealthIndexScoreRobustnessTest {

    @Test
    @DisplayName("TC001: Nominal Case")
    void TC001() {
        HealthIndexScore health = new HealthIndexScore(40, 72, 20);

        assertEquals(2, health.calculateVo2MaxScore());
        assertEquals(3, health.calculateRhrScore());
        assertEquals(4, health.calculateHrrScore());
        
        assertEquals(9, health.getTotalScore());
        assertEquals(FitnessLevel.STANDARD, health.getFitnessLevel());
    }

    @Test
    @DisplayName("TC002: VO2 = min-")
    void TC002() {
        HealthIndexScore health = new HealthIndexScore(23, 72, 20);

        assertEquals(0, health.calculateVo2MaxScore());
        assertEquals(3, health.calculateRhrScore());
        assertEquals(4, health.calculateHrrScore());
        
        assertEquals(7, health.getTotalScore());
        assertEquals(FitnessLevel.STANDARD, health.getFitnessLevel());
    }

    @Test
    @DisplayName("TC003: VO2 = min")
    void TC003() {
        HealthIndexScore health = new HealthIndexScore(24, 72, 20);

        assertEquals(0, health.calculateVo2MaxScore());
        assertEquals(3, health.calculateRhrScore());
        assertEquals(4, health.calculateHrrScore());
        
        assertEquals(7, health.getTotalScore());
        assertEquals(FitnessLevel.STANDARD, health.getFitnessLevel());
    }

    @Test
    @DisplayName("TC004: VO2 = min+")
    void TC004() {
        HealthIndexScore health = new HealthIndexScore(25, 72, 20);

        assertEquals(1, health.calculateVo2MaxScore());
        assertEquals(3, health.calculateRhrScore());
        assertEquals(4, health.calculateHrrScore());
        
        assertEquals(8, health.getTotalScore());
        assertEquals(FitnessLevel.STANDARD, health.getFitnessLevel());
    }

    @Test
    @DisplayName("TC005: VO2 = max-")
    void TC005() {
        HealthIndexScore health = new HealthIndexScore(60, 72, 20);

        assertEquals(4, health.calculateVo2MaxScore());
        assertEquals(3, health.calculateRhrScore());
        assertEquals(4, health.calculateHrrScore());
        
        assertEquals(11, health.getTotalScore());
        assertEquals(FitnessLevel.STANDARD, health.getFitnessLevel());
    }

    @Test
    @DisplayName("TC006: VO2 = max")
    void TC006() {
        HealthIndexScore health = new HealthIndexScore(61, 72, 20);

        assertEquals(5, health.calculateVo2MaxScore());
        assertEquals(3, health.calculateRhrScore());
        assertEquals(4, health.calculateHrrScore());
        
        assertEquals(12, health.getTotalScore());
        assertEquals(FitnessLevel.EXCELLENT, health.getFitnessLevel());
    }

    @Test
    @DisplayName("TC007: VO2 = max+")
    void TC007() {
        HealthIndexScore health = new HealthIndexScore(62, 72, 20);

        assertEquals(5, health.calculateVo2MaxScore());
        assertEquals(3, health.calculateRhrScore());
        assertEquals(4, health.calculateHrrScore());
        
        assertEquals(12, health.getTotalScore());
        assertEquals(FitnessLevel.EXCELLENT, health.getFitnessLevel());
    }

    @Test
    @DisplayName("TC008: RHR = min-")
    void TC008() {
        assertThrows(IllegalArgumentException.class,
                () -> new HealthIndexScore(40, 39, 20));
    }

    @Test
    @DisplayName("TC009: RHR = min")
    void TC009() {
        HealthIndexScore health = new HealthIndexScore(40, 40, 20);

        assertEquals(2, health.calculateVo2MaxScore());
        assertEquals(5, health.calculateRhrScore());
        assertEquals(4, health.calculateHrrScore());
        
        assertEquals(11, health.getTotalScore());
        assertEquals(FitnessLevel.STANDARD, health.getFitnessLevel());
    }

    @Test
    @DisplayName("TC010: RHR = min+")
    void TC010() {
        HealthIndexScore health = new HealthIndexScore(40, 41, 20);

        assertEquals(2, health.calculateVo2MaxScore());
        assertEquals(5, health.calculateRhrScore());
        assertEquals(4, health.calculateHrrScore());
        
        assertEquals(11, health.getTotalScore());
        assertEquals(FitnessLevel.STANDARD, health.getFitnessLevel());
    }

    @Test
    @DisplayName("TC011: RHR = max-")
    void TC011() {
        HealthIndexScore health = new HealthIndexScore(40, 219, 20);

        assertEquals(2, health.calculateVo2MaxScore());
        assertEquals(1, health.calculateRhrScore());
        assertEquals(4, health.calculateHrrScore());
        
        assertEquals(7, health.getTotalScore());
        assertEquals(FitnessLevel.STANDARD, health.getFitnessLevel());
    }

    @Test
    @DisplayName("TC012: RHR = max")
    void TC012() {
        HealthIndexScore health = new HealthIndexScore(40, 220, 20);

        assertEquals(2, health.calculateVo2MaxScore());
        assertEquals(1, health.calculateRhrScore());
        assertEquals(4, health.calculateHrrScore());
        
        assertEquals(7, health.getTotalScore());
        assertEquals(FitnessLevel.STANDARD, health.getFitnessLevel());
    }

    @Test
    @DisplayName("TC013: RHR = max+")
    void TC013() {
        assertThrows(IllegalArgumentException.class,
                () -> new HealthIndexScore(40, 221, 20));
    }

    @Test
    @DisplayName("TC014: HRR = min-")
    void TC014() {
        HealthIndexScore health = new HealthIndexScore(40, 72, 10);

        assertEquals(2, health.calculateVo2MaxScore());
        assertEquals(3, health.calculateRhrScore());
        assertEquals(1, health.calculateHrrScore());
        
        assertEquals(6, health.getTotalScore());
        assertEquals(FitnessLevel.STANDARD, health.getFitnessLevel());
    }

    @Test
    @DisplayName("TC015: HRR = min")
    void TC015() {
        HealthIndexScore health = new HealthIndexScore(40, 72, 11);

        assertEquals(2, health.calculateVo2MaxScore());
        assertEquals(3, health.calculateRhrScore());
        assertEquals(1, health.calculateHrrScore());
        
        assertEquals(6, health.getTotalScore());
        assertEquals(FitnessLevel.STANDARD, health.getFitnessLevel());
    }

    @Test
    @DisplayName("TC016: HRR = min+")
    void TC016() {
        HealthIndexScore health = new HealthIndexScore(40, 72, 12);

        assertEquals(2, health.calculateVo2MaxScore());
        assertEquals(3, health.calculateRhrScore());
        assertEquals(3, health.calculateHrrScore());
        
        assertEquals(8, health.getTotalScore());
        assertEquals(FitnessLevel.STANDARD, health.getFitnessLevel());
    }

    @Test
    @DisplayName("TC017: HRR = max-")
    void TC017() {
        HealthIndexScore health = new HealthIndexScore(40, 72, 29);

        assertEquals(2, health.calculateVo2MaxScore());
        assertEquals(3, health.calculateRhrScore());
        assertEquals(5, health.calculateHrrScore());
        
        assertEquals(10, health.getTotalScore());
        assertEquals(FitnessLevel.STANDARD, health.getFitnessLevel());
    }

    @Test
    @DisplayName("TC018: HRR = max")
    void TC018() {
        HealthIndexScore health = new HealthIndexScore(40, 72, 30);

        assertEquals(2, health.calculateVo2MaxScore());
        assertEquals(3, health.calculateRhrScore());
        assertEquals(5, health.calculateHrrScore());
        
        assertEquals(10, health.getTotalScore());
        assertEquals(FitnessLevel.STANDARD, health.getFitnessLevel());
    }

    @Test
    @DisplayName("TC019: HRR = max+")
    void TC019() {
        HealthIndexScore health = new HealthIndexScore(40, 72, 31);

        assertEquals(2, health.calculateVo2MaxScore());
        assertEquals(3, health.calculateRhrScore());
        assertEquals(5, health.calculateHrrScore());
        
        assertEquals(10, health.getTotalScore());
        assertEquals(FitnessLevel.STANDARD, health.getFitnessLevel());
    }
}