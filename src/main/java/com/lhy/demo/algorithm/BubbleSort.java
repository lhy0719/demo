/**
 * Company Copyright (C) 2004-2019 All Rights Reserved.
 */
package com.lhy.demo.algorithm;

import java.util.Arrays;
import org.apache.commons.lang3.ArrayUtils;

/**
 *
 * 冒泡排序
 * @author xuhaitao
 * @version v 1.0.0 
 * @since v 1.0.0 2019-01-18 17:52
 */
public class BubbleSort {

    private static void sort1() {
        int[] queue = {2,1,59,23,45,11,66,3};
        for (int i=0;i<queue.length;i++){
            for (int j=1;j<queue.length-i;j++){
                if (queue[j-1] > queue[j]){
                    int temp = queue[j-1];
                    queue[j-1] = queue[j];
                    queue[j] = temp;
                }
            }
        }
        Arrays.sort(queue);
        System.out.println("");
        System.out.println(ArrayUtils.isSorted(queue));
        System.out.println(ArrayUtils.toString(queue));
    }

    public static void main(String[] args) {
        sort1();
    }
}
