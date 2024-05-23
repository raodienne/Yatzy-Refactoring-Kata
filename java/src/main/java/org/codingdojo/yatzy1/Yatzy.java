package org.codingdojo.yatzy1;

import java.util.Arrays;

public class Yatzy {

    protected int[] dices;

    public static Yatzy of(int d1, int d2, int d3, int d4, int d5) {
        return new Yatzy(new int[]{d1, d2, d3, d4, d5});
    }

    private Yatzy(int[] dices) {
        this.dices = dices;
    }

    public int chance() {
        return Arrays.stream(dices).sum();
    }

    public int yatzy() {
        int[] counts = new int[6];
        for (int die : dices)
            counts[die - 1]++;
        for (int i = 0; i != 6; i++)
            if (counts[i] == 5)
                return 50;
        return 0;
    }

    public int ones() {
        int sum = 0;
        if (dices[0] == 1) sum++;
        if (dices[1] == 1) sum++;
        if (dices[2] == 1) sum++;
        if (dices[3] == 1) sum++;
        if (dices[4] == 1)
            sum++;

        return sum;
    }

    public int twos() {
        int sum = 0;
        if (dices[0] == 2) sum += 2;
        if (dices[1] == 2) sum += 2;
        if (dices[2] == 2) sum += 2;
        if (dices[3] == 2) sum += 2;
        if (dices[4] == 2) sum += 2;
        return sum;
    }

    public int threes() {
        int s;
        s = 0;
        if (dices[0] == 3) s += 3;
        if (dices[1] == 3) s += 3;
        if (dices[2] == 3) s += 3;
        if (dices[3] == 3) s += 3;
        if (dices[4] == 3) s += 3;
        return s;
    }

    public int fours() {
        int sum;
        sum = 0;
        for (int at = 0; at != 5; at++) {
            if (dices[at] == 4) {
                sum += 4;
            }
        }
        return sum;
    }

    public int fives() {
        int s = 0;
        int i;
        for (i = 0; i < dices.length; i++)
            if (dices[i] == 5)
                s = s + 5;
        return s;
    }

    public int sixes() {
        int sum = 0;
        for (int at = 0; at < dices.length; at++)
            if (dices[at] == 6)
                sum = sum + 6;
        return sum;
    }

    public int pair() {
        int[] counts = new int[6];
        counts[dices[0] - 1]++;
        counts[dices[1] - 1]++;
        counts[dices[2] - 1]++;
        counts[dices[3] - 1]++;
        counts[dices[4] - 1]++;
        int at;
        for (at = 0; at != 6; at++)
            if (counts[6 - at - 1] >= 2)
                return (6 - at) * 2;
        return 0;
    }

    public int doublePair() {
        int[] counts = new int[6];
        counts[dices[0] - 1]++;
        counts[dices[1] - 1]++;
        counts[dices[2] - 1]++;
        counts[dices[3] - 1]++;
        counts[dices[4] - 1]++;
        int n = 0;
        int score = 0;
        for (int i = 0; i < 6; i += 1)
            if (counts[6 - i - 1] >= 2) {
                n++;
                score += (6 - i);
            }
        if (n == 2)
            return score * 2;
        else
            return 0;
    }

    public int threeOfAKind() {
        int[] t;
        t = new int[6];
        t[dices[0] - 1]++;
        t[dices[1] - 1]++;
        t[dices[2] - 1]++;
        t[dices[3] - 1]++;
        t[dices[4] - 1]++;
        for (int i = 0; i < 6; i++)
            if (t[i] >= 3)
                return (i + 1) * 3;
        return 0;
    }

    public int fourOfAKind() {
        int[] tallies;
        tallies = new int[6];
        tallies[dices[0] - 1]++;
        tallies[dices[1] - 1]++;
        tallies[dices[2] - 1]++;
        tallies[dices[3] - 1]++;
        tallies[dices[4] - 1]++;
        for (int i = 0; i < 6; i++)
            if (tallies[i] >= 4)
                return (i + 1) * 4;
        return 0;
    }

    public int smallStraight() {
        int[] tallies;
        tallies = new int[6];
        tallies[dices[0] - 1] += 1;
        tallies[dices[1] - 1] += 1;
        tallies[dices[2] - 1] += 1;
        tallies[dices[3] - 1] += 1;
        tallies[dices[4] - 1] += 1;
        if (tallies[0] == 1 &&
            tallies[1] == 1 &&
            tallies[2] == 1 &&
            tallies[3] == 1 &&
            tallies[4] == 1)
            return 15;
        return 0;
    }

    public int largeStraight() {
        int[] tallies;
        tallies = new int[6];
        tallies[dices[0] - 1] += 1;
        tallies[dices[1] - 1] += 1;
        tallies[dices[2] - 1] += 1;
        tallies[dices[3] - 1] += 1;
        tallies[dices[4] - 1] += 1;
        if (tallies[1] == 1 &&
            tallies[2] == 1 &&
            tallies[3] == 1 &&
            tallies[4] == 1
            && tallies[5] == 1)
            return 20;
        return 0;
    }

    public int fullHouse() {
        int[] tallies;
        boolean _2 = false;
        int i;
        int _2_at = 0;
        boolean _3 = false;
        int _3_at = 0;

        tallies = new int[6];
        tallies[dices[0] - 1] += 1;
        tallies[dices[1] - 1] += 1;
        tallies[dices[2] - 1] += 1;
        tallies[dices[3] - 1] += 1;
        tallies[dices[4] - 1] += 1;

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 2) {
                _2 = true;
                _2_at = i + 1;
            }

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 3) {
                _3 = true;
                _3_at = i + 1;
            }

        if (_2 && _3)
            return _2_at * 2 + _3_at * 3;
        else
            return 0;
    }
}



