package org.codingdojo;

import org.codingdojo.yatzy1.Yatzy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class YatzyTest {

    @Test
    public void chance_shouldScoresSum() {
        int expected = 15;
        int actual = Yatzy.of(2, 3, 4, 5, 1).chance();
        assertEquals(expected, actual);
        assertEquals(16, Yatzy.of(3, 3, 4, 5, 1).chance());
    }

    @Test
    public void yatzy_scores_50() {
        int expected = 50;
        int actual = Yatzy.of(4, 4, 4, 4, 4).yatzy();
        assertEquals(expected, actual);
        assertEquals(50, Yatzy.of(6, 6, 6, 6, 6).yatzy());
        assertEquals(0, Yatzy.of(6, 6, 6, 6, 3).yatzy());
    }

    @Test
    public void test_1s() {
        assertEquals(1, Yatzy.of(1, 2, 3, 4, 5).ones());
        assertEquals(2, Yatzy.of(1, 2, 1, 4, 5).ones());
        assertEquals(0, Yatzy.of(6, 2, 2, 4, 5).ones());
        assertEquals(4, Yatzy.of(1, 2, 1, 1, 1).ones());
    }

    @Test
    public void test_2s() {
        assertEquals(4, Yatzy.of(1, 2, 3, 2, 6).twos());
        assertEquals(10, Yatzy.of(2, 2, 2, 2, 2).twos());
    }

    @Test
    public void test_threes() {
        assertEquals(6, Yatzy.of(1, 2, 3, 2, 3).threes());
        assertEquals(12, Yatzy.of(2, 3, 3, 3, 3).threes());
    }

    @Test
    public void fours_test() {
        assertEquals(12, Yatzy.of(4, 4, 4, 5, 5).fours());
        assertEquals(8, Yatzy.of(4, 4, 5, 5, 5).fours());
        assertEquals(4, Yatzy.of(4, 5, 5, 5, 5).fours());
    }

    @Test
    public void fives() {
        assertEquals(10, Yatzy.of(4, 4, 4, 5, 5).fives());
        assertEquals(15, Yatzy.of(4, 4, 5, 5, 5).fives());
        assertEquals(20, Yatzy.of(4, 5, 5, 5, 5).fives());
    }

    @Test
    public void sixes_test() {
        assertEquals(0, Yatzy.of(4, 4, 4, 5, 5).sixes());
        assertEquals(6, Yatzy.of(4, 4, 6, 5, 5).sixes());
        assertEquals(18, Yatzy.of(6, 5, 6, 6, 5).sixes());
    }

    @Test
    public void one_pair() {
        assertEquals(6, Yatzy.of(3, 4, 3, 5, 6).pair());
        assertEquals(10, Yatzy.of(5, 3, 3, 3, 5).pair());
        assertEquals(12, Yatzy.of(5, 3, 6, 6, 5).pair());
    }

    @Test
    public void doublePair() {
        assertEquals(16, Yatzy.of(3, 3, 5, 4, 5).doublePair());
        assertEquals(16, Yatzy.of(3, 3, 5, 5, 5).doublePair());
    }

    @Test
    public void threeOfAKind() {
        assertEquals(9, Yatzy.of(3, 3, 3, 4, 5).threeOfAKind());
        assertEquals(15, Yatzy.of(5, 3, 5, 4, 5).threeOfAKind());
        assertEquals(9, Yatzy.of(3, 3, 3, 3, 5).threeOfAKind());
        assertEquals(9, Yatzy.of(3, 3, 3, 3, 3).threeOfAKind());
    }

    @Test
    public void four_of_a_knd() {
        assertEquals(12, Yatzy.of(3, 3, 3, 3, 5).fourOfAKind());
        assertEquals(20, Yatzy.of(5, 5, 5, 4, 5).fourOfAKind());
    }

    @Test
    public void smallStraight() {
        assertEquals(15, Yatzy.of(1, 2, 3, 4, 5).smallStraight());
        assertEquals(15, Yatzy.of(2, 3, 4, 5, 1).smallStraight());
        assertEquals(0, Yatzy.of(1, 2, 2, 4, 5).smallStraight());
    }

    @Test
    public void largeStraight() {
        assertEquals(20, Yatzy.of(6, 2, 3, 4, 5).largeStraight());
        assertEquals(20, Yatzy.of(2, 3, 4, 5, 6).largeStraight());
        assertEquals(0, Yatzy.of(1, 2, 2, 4, 5).largeStraight());
    }

    @Test
    public void fullHouse() {
        assertEquals(18, Yatzy.of(6, 2, 2, 2, 6).fullHouse());
        assertEquals(0, Yatzy.of(2, 3, 4, 5, 6).fullHouse());
    }
}
