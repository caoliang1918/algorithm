package com.example.algorithm;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

/**
 * @author : caoliang
 * @date : 2018/1/3  下午3:08
 */
public class MergeSort {
    Logger logger = LoggerFactory.getLogger(MergeSort.class);

    int[] array = new int[10000];

    public void initArray() {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10000);
        }
    }

    @Test
    public void test() {
        initArray();
        long t1 = System.currentTimeMillis();
        mergeSort(array);
        long t2 = System.currentTimeMillis();
        logger.info("归并排序耗时: {}", t2-t1);

    }

    private void mergeSort(int[] array) {
        int[] aux = new int[array.length];
        sort(array, aux, 0, array.length - 1);
    }

    private void sort(int[] array, int[] aux, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(array, aux, lo, mid);
        sort(array, aux, mid + 1, hi);
        merge(array, aux, lo, mid, hi);
    }

    private void merge(int[] array, int[] aux, int lo, int mid, int hi) {
        System.arraycopy(array, 0, aux, 0, array.length);
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) array[k] = aux[j++];
            else if (j > hi) array[k] = aux[i++];
            else if (aux[j] < aux[i]) array[k] = aux[j++];
            else array[k] = aux[i++];
        }
    }
}
