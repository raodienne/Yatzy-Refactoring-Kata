package org.codingdojo.yatzy1;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

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
        if (Arrays.stream(dices).allMatch(i -> i == dices[0])) {
            return 50;
        }

        return 0;
    }

    public int ones() {
        return sumValues(1);
    }

    public int twos() {
        return sumValues(2);
    }

    public int threes() {
        return sumValues(3);
    }

    public int fours() {
        return sumValues(4);
    }

    public int fives() {
        return sumValues(5);
    }

    public int sixes() {
        return sumValues(6);
    }

    public int pair() {
        return nOfAKind(2);
    }

    public int threeOfAKind() {
        return nOfAKind(3);
    }

    public int fourOfAKind() {
        return nOfAKind(4);
    }

    public int doublePair() {

        var pairMap = Arrays.stream(dices)
            .boxed()
            .collect(Collectors.groupingBy(e -> e))
            .entrySet().stream()
            .filter(e -> e.getValue().size() >= 2)
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        if (pairMap.size() == 2) {
            return pairMap.keySet().stream().mapToInt(Integer::intValue).sum() * 2;
        }
        return 0;
    }

    public int smallStraight() {
        int[] copy = Arrays.copyOf(dices, 5);
        Arrays.sort(copy);

        for (int i = 0; i < 5; i++) {
            if (copy[i] != i + 1) {
                return 0;
            }
        }
        return 15;
    }

    public int largeStraight() {
        int[] copy = Arrays.copyOf(dices, 5);
        Arrays.sort(copy);

        for (int i = 0; i < 5; i++) {
            if (copy[i] != i + 2) {
                return 0;
            }
        }
        return 20;
    }

    public int fullHouse() {
        var pair = exactNOfAKind(2);
        var trio = exactNOfAKind(3);

        if (pair > 0 && trio > 0) {
            return pair + trio;
        }
        return 0;
    }

    private int sumValues(int expected) {
        return Arrays.stream(dices)
            .filter(i -> i == expected)
            .sum();
    }

    private Integer nOfAKind(int n) {
        return Arrays.stream(dices)
            .boxed()
            .collect(Collectors.groupingBy(e -> e))
            .entrySet().stream()
            .filter(e -> e.getValue().size() >= n)
            .map(Map.Entry::getKey)
            .max(Integer::compareTo)
            .map(i -> i * n)
            .orElse(0);
    }

    private Integer exactNOfAKind(int n) {
        return Arrays.stream(dices)
            .boxed()
            .collect(Collectors.groupingBy(e -> e))
            .entrySet().stream()
            .filter(e -> e.getValue().size() == n)
            .map(Map.Entry::getKey)
            .max(Integer::compareTo)
            .map(i -> i * n)
            .orElse(0);
    }
}



