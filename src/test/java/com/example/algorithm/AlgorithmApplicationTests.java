package com.example.algorithm;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AlgorithmApplicationTests {
    Logger logger = LoggerFactory.getLogger(AlgorithmApplicationTests.class);

    int[] array = new int[10000];

    public void initArray() {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10000);
        }
    }

    /**
     * 冒泡排序
     */
    @Test
    public void bubbleSort() {
        initArray();
        long t1 = System.currentTimeMillis();
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[i]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        long t2 = System.currentTimeMillis();
        logger.info("冒泡排序耗时: {}", t2 - t1);
        //logger.info("排序后数组: {}" , Arrays.toString(array));
    }

    /**
     * 直接插入排序，耗时在90-120毫秒之间
     */
    @Test
    public void insertionSort1() {
        initArray();
        long t1 = System.currentTimeMillis();
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--) {

                if (array[j] < array[j - 1]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
        long t2 = System.currentTimeMillis();
        logger.info("插入排序耗时: {}", t2 - t1);
    }

    /**
     * shell排序，27-90毫秒之间，不稳定
     */
    @Test
    public void insertionSort2() {
        initArray();
        long t1 = System.currentTimeMillis();
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
        long t2 = System.currentTimeMillis();
        logger.info("插入排序耗时: {}", t2 - t1);
    }


    /**
     * 选择排序
     */
    @Test
    public void selectSort() {
        initArray();
        long t1 = System.currentTimeMillis();
        for (int i = 1; i < array.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            int temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }
        long t2 = System.currentTimeMillis();
        logger.info("选择排序耗时: {}", t2 - t1);
    }

    /**
     * 快速排序
     */
    @Test
    public void quickSort() {
        initArray();
        long t1 = System.currentTimeMillis();
        sort(array, 0, array.length - 1);
        long t2 = System.currentTimeMillis();
        logger.info("快速排序耗时: {}", t2 - t1);
    }

    private void sort(int[] a, int low, int hight) {
        int i, j, index;
        if (low > hight) {
            return;
        }
        i = low;
        j = hight;
        //用字表的第一个记录做基数
        index = a[i];
        //从表的两端交替向中间扫描
        while (i < j) {
            while (i < j && a[j] >= index) {
                j--;
            }
            if (i < j) {
                //用比基准小的记录替换低位记录
                a[i++] = a[j];
            }
            while (i < j && a[j] < index) {
                i++;
            }
            if (i < j) {
                //用比基准大的记录替换高位记录
                a[j--] = a[i];
            }
        }
        //将基准数値替换回a[i]
        a[i] = index;
        //对低字表进行递归排序
        sort(a, low, i - 1);
        //对高子表进行递归排序
        sort(a, i + 1, hight);
    }

    /**
     * 归并排序
     */
    public void mergeSolt(){
        initArray();
    }


}
