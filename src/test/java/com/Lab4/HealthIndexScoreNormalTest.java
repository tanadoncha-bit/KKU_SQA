package test.java.com.Lab4;

import main.java.com.Lab4.HealthIndexScore;
import main.java.com.Lab4.HealthIndexScore.FitnessLevel;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HealthIndexScoreNormalTest {

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
    @DisplayName("TC002: VO2 = min")
    void TC002() {
        HealthIndexScore health = new HealthIndexScore(24, 72, 20);

        assertEquals(0, health.calculateVo2MaxScore());
        assertEquals(3, health.calculateRhrScore());
        assertEquals(4, health.calculateHrrScore());
        
        assertEquals(7, health.getTotalScore());
        assertEquals(FitnessLevel.STANDARD, health.getFitnessLevel());
    }

    @Test
    @DisplayName("TC003: VO2 = min+")
    void TC003() {
        HealthIndexScore health = new HealthIndexScore(25, 72, 20);

        assertEquals(1, health.calculateVo2MaxScore());
        assertEquals(3, health.calculateRhrScore());
        assertEquals(4, health.calculateHrrScore());
        
        assertEquals(8, health.getTotalScore());
        assertEquals(FitnessLevel.STANDARD, health.getFitnessLevel());
    }

    @Test
    @DisplayName("TC004: VO2 = max-")
    void TC004() {
        HealthIndexScore health = new HealthIndexScore(60, 72, 20);

        assertEquals(4, health.calculateVo2MaxScore());
        assertEquals(3, health.calculateRhrScore());
        assertEquals(4, health.calculateHrrScore());
        
        assertEquals(11, health.getTotalScore());
        assertEquals(FitnessLevel.STANDARD, health.getFitnessLevel());
    }

    @Test
    @DisplayName("TC005: VO2 = max")
    void TC005() {
        HealthIndexScore health = new HealthIndexScore(61, 72, 20);

        assertEquals(5, health.calculateVo2MaxScore());
        assertEquals(3, health.calculateRhrScore());
        assertEquals(4, health.calculateHrrScore());
        
        assertEquals(12, health.getTotalScore());
        assertEquals(FitnessLevel.EXCELLENT, health.getFitnessLevel());
    }

    @Test
    @DisplayName("TC006: RHR = min")
    void TC006() {
        HealthIndexScore health = new HealthIndexScore(40, 40, 20);

        assertEquals(2, health.calculateVo2MaxScore());
        assertEquals(5, health.calculateRhrScore());
        assertEquals(4, health.calculateHrrScore());
        
        assertEquals(11, health.getTotalScore());
        assertEquals(FitnessLevel.STANDARD, health.getFitnessLevel());
    }

    @Test
    @DisplayName("TC007: RHR = min+")
    void TC007() {
        HealthIndexScore health = new HealthIndexScore(40, 41, 20);

        assertEquals(2, health.calculateVo2MaxScore());
        assertEquals(5, health.calculateRhrScore());
        assertEquals(4, health.calculateHrrScore());
        
        assertEquals(11, health.getTotalScore());
        assertEquals(FitnessLevel.STANDARD, health.getFitnessLevel());
    }

    @Test
    @DisplayName("TC008: RHR = max-")
    void TC008() {
        HealthIndexScore health = new HealthIndexScore(40, 219, 20);

        assertEquals(2, health.calculateVo2MaxScore());
        assertEquals(1, health.calculateRhrScore());
        assertEquals(4, health.calculateHrrScore());
        
        assertEquals(7, health.getTotalScore());
        assertEquals(FitnessLevel.STANDARD, health.getFitnessLevel());
    }

    @Test
    @DisplayName("TC009: RHR = max")
    void TC009() {
        HealthIndexScore health = new HealthIndexScore(40, 220, 20);

        assertEquals(2, health.calculateVo2MaxScore());
        assertEquals(1, health.calculateRhrScore());
        assertEquals(4, health.calculateHrrScore());
        
        assertEquals(7, health.getTotalScore());
        assertEquals(FitnessLevel.STANDARD, health.getFitnessLevel());
    }

    @Test
    @DisplayName("TC010: HRR = min")
    void TC010() {
        HealthIndexScore health = new HealthIndexScore(40, 72, 11);

        assertEquals(2, health.calculateVo2MaxScore());
        assertEquals(3, health.calculateRhrScore());
        assertEquals(1, health.calculateHrrScore());
        
        assertEquals(6, health.getTotalScore());
        assertEquals(FitnessLevel.STANDARD, health.getFitnessLevel());
    }

    @Test
    @DisplayName("TC011: HRR = min+")
    void TC011() {
        HealthIndexScore health = new HealthIndexScore(40, 72, 12);

        assertEquals(2, health.calculateVo2MaxScore());
        assertEquals(3, health.calculateRhrScore());
        assertEquals(3, health.calculateHrrScore());
        
        assertEquals(8, health.getTotalScore());
        assertEquals(FitnessLevel.STANDARD, health.getFitnessLevel());
    }

    @Test
    @DisplayName("TC012: HRR = max-")
    void TC012() {
        HealthIndexScore health = new HealthIndexScore(40, 72, 29);

        assertEquals(2, health.calculateVo2MaxScore());
        assertEquals(3, health.calculateRhrScore());
        assertEquals(5, health.calculateHrrScore());
        
        assertEquals(10, health.getTotalScore());
        assertEquals(FitnessLevel.STANDARD, health.getFitnessLevel());
    }

    @Test
    @DisplayName("TC013: HRR = max")
    void TC013() {
        HealthIndexScore health = new HealthIndexScore(40, 72, 30);

        assertEquals(2, health.calculateVo2MaxScore());
        assertEquals(3, health.calculateRhrScore());
        assertEquals(5, health.calculateHrrScore());
        
        assertEquals(10, health.getTotalScore());
        assertEquals(FitnessLevel.STANDARD, health.getFitnessLevel());
    }
}