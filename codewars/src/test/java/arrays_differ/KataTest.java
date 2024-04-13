package arrays_differ;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KataTest {
    @Test
    public void sampleTests() {
        assertArrayEquals(new int[] {2}, Kata.arrayDiff(new int [] {1,2}, new int[] {1}));
        assertArrayEquals(new int[] {2,2}, Kata.arrayDiff(new int [] {1,2,2}, new int[] {1}));
        assertArrayEquals(new int[] {1}, Kata.arrayDiff(new int [] {1,2,2}, new int[] {2}));
        assertArrayEquals(new int[] {1,2,2}, Kata.arrayDiff(new int [] {1,2,2}, new int[] {}));
        assertArrayEquals(new int[] {}, Kata.arrayDiff(new int [] {}, new int[] {1,2}));
        assertArrayEquals(new int[] {5}, Kata.arrayDiff(new int [] {3,4,5}, new int[] {1,2,3,4}));
    }
}