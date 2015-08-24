package org.hanjia.DataStructure.Sorting;

import java.util.Arrays;

/**
 * Reference: 
 * http://algs4.cs.princeton.edu/51radix/
 * https://www.cs.princeton.edu/~rs/AlgsDS07/18RadixSort.pdf
 * @author hajia
 *
 */
public class RadixSort {
    private static final int BITS_PER_BYTE =   8;
    private static final int BITS_PER_INT  =  32;   // each Java int is 32 bits 
    private static final int R             = 256;   // extended ASCII alphabet size
    private static final int CUTOFF        =  15;   // cutoff to insertion sort

	/**
	 * Radix LSD sort
	 */
	public static void lsdSort(int[] a) {
        int BITS = 32;                 // each int is 32 bits 
        int W = BITS / BITS_PER_BYTE;  // each int is 4 bytes
        int R = 1 << BITS_PER_BYTE;    // each bytes is between 0 and 255
        int MASK = R - 1;              // 0xFF

        int N = a.length;
        int[] aux = new int[N];

        for (int d = 0; d < W; d++) {         
            int[] count = new int[R+1];
            for (int i = 0; i < N; i++) { // compute frequency counts     
                int c = (a[i] >> BITS_PER_BYTE*d) & MASK;
                count[c + 1]++;
            }

            for (int r = 0; r < R; r++) { // compute cumulates
                count[r+1] += count[r];
            }

            // for most significant byte, 0x80-0xFF comes before 0x00-0x7F
            if (d == W-1) {
                int shift1 = count[R] - count[R/2];
                int shift2 = count[R/2];
                for (int r = 0; r < R/2; r++)
                    count[r] += shift1;
                for (int r = R/2; r < R; r++)
                    count[r] -= shift2;
            }

            // move data
            for (int i = 0; i < N; i++) {
                int c = (a[i] >> BITS_PER_BYTE * d) & MASK;
                aux[count[c]++] = a[i];
            }

            // copy back
            for (int i = 0; i < N; i++) {
                a[i] = aux[i];
            }
        }
    }
	
	/**
	 * Radix MSD sort
	 */
    public static void msdSort(int[] a) {
        int N = a.length;
        int[] aux = new int[N];
        sort(a, 0, N-1, 0, aux);
    }

    // MSD sort from a[lo] to a[hi], starting at the dth byte
    private static void sort(int[] a, int lo, int hi, int d, int[] aux) {

        // cutoff to insertion sort for small subarrays
        if (hi <= lo + CUTOFF) {
            insertion(a, lo, hi, d);
            return;
        }

        // compute frequency counts (need R = 256)
        int[] count = new int[R+1];
        int mask = R - 1;   // 0xFF;
        int shift = BITS_PER_INT - BITS_PER_BYTE*d - BITS_PER_BYTE;
        for (int i = lo; i <= hi; i++) {
            int c = (a[i] >> shift) & mask;
            count[c + 1]++;
        }

        // transform counts to indicies
        for (int r = 0; r < R; r++)
            count[r+1] += count[r];

        // distribute
        for (int i = lo; i <= hi; i++) {
            int c = (a[i] >> shift) & mask;
            aux[count[c]++] = a[i];
        }

        // copy back
        for (int i = lo; i <= hi; i++) 
            a[i] = aux[i - lo];

        // no more bits
        if (d == 4) return;

        // recursively sort for each character
        if (count[0] > 0) {
            sort(a, lo, lo + count[0] - 1, d+1, aux);
        }
        
        for (int r = 0; r < R; r++) {
            if (count[r+1] > count[r])
                sort(a, lo + count[r], lo + count[r+1] - 1, d+1, aux);
        }
    }
    
    // insertion sort a[lo..hi], starting at dth character
    private static void insertion(int[] a, int lo, int hi, int d) {
        for (int i = lo; i <= hi; i++)
            for (int j = i; j > lo && a[j] < a[j-1]; j--)
                exch(a, j, j-1);
    }

    // exchange a[i] and a[j]
    private static void exch(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
	
	public static void main(String[] args) {
		int[] a = {33, 21, 32, 24, 25};
		lsdSort(a);
		System.out.println(Arrays.toString(a));
		int[] b = {29, 30, 62, 44, 65};
		msdSort(b);
		System.out.println(Arrays.toString(b));
	}
}
