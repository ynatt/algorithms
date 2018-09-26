package com.velvn.algorithms.sort.bubble;

import com.velvn.algorithms.Array;
import com.velvn.algorithms.sort.insert.InsertionSortWithBinarySearch;
import com.velvn.algorithms.sort.insert.InsertionSortWithoutBinarySearch;
import com.velvn.algorithms.sort.merge.MergeSort;
import com.velvn.algorithms.sort.quick.QuickSort;
import junit.framework.TestCase;

public class AllSortsTest extends TestCase {

    Array[] arrays = {new Array(new int[]{}),
            new Array(new int[]{1,1,1,1,1,1,1,1,1,1,1}),
            new Array(new int[]{10,9,8,7,6,5,4,3,2,1,0}),
            new Array(new int[]{1,2,3,4,5,6,7,8,9,10}),
            new Array(new int[]{8,8,1,2,10,10,4,4,7,7,6,6,6,7,8,2,10})};

    public void testBubbleSortWithoutForOptimization(){
        for(Array array : arrays) {
            new BubbleSortWithoutForOptimization(array.getArray()).execute();
            assertTrue(array.isSorted());
        }
    }

    public void testBubbleSortWithForOptimization(){
        for(Array array : arrays) {
            new BubbleSortWithForOptimization(array.getArray()).execute();
            assertTrue(array.isSorted());
        }
    }

    public void testBubbleSortWithFlag(){
        for(Array array : arrays) {
            new BubbleSortWithFlag(array.getArray()).execute();
            assertTrue(array.isSorted());
        }
    }

    public void testInsertionSortWithoutBinarySearch(){
        for(Array array : arrays) {
            new InsertionSortWithoutBinarySearch(array.getArray()).execute();
            assertTrue(array.isSorted());
        }
    }

    public void testInsertionSortWithBinarySearch(){
        for(Array array : arrays) {
            new InsertionSortWithBinarySearch(array.getArray()).execute();
            assertTrue(array.isSorted());
        }
    }

    public void testMergeSort(){
        for(Array array : arrays) {
            new MergeSort(array.getArray()).execute();
            assertTrue(array.isSorted());
        }
    }

    public void testQuickSort(){
        for(Array array : arrays) {
            new QuickSort(array.getArray()).execute();
            assertTrue(array.isSorted());
        }
    }
}