package com.laoliang.springboot.sort;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static cn.hutool.core.util.ArrayUtil.swap;

/**
 * @author laoliangliang
 * @date 2019/11/5 16:36
 */
public class SortTest {

    /**
     * 从小到大排
     */
    @Test
    public void quickSort() {
        // 初始化数据
        int[] nums = getInts();

        quick(nums, 0, nums.length - 1);
        System.out.println(JSON.toJSONString(nums));
    }

    private int[] getInts() {

        int[] nums = new int[4];
        Random random = new Random();
        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(100);
        }
        System.out.println(JSON.toJSONString(nums));
        return nums;
    }

    private void quick(int[] nums, int l, int r) {
        int p = nums[l];
        int left = l;
        int right = r;
        if (l == r) {
            return;
        }
        while (left < right) {
            while (left < right) {
                if (nums[left] > p) {
                    break;
                }
                left++;
            }

            while (left < right) {
                if (nums[right] < p) {
                    break;
                }
                right--;
            }

            if (left < right) {
                swap(nums, left, right);
            }

        }

        if (nums[left] < p) {
            swap(nums, left, l);
        }
        quick(nums, l, left - 1);
        quick(nums, left, r);
    }

    /**
     * 小到大
     */
    @Test
    public void heapSort() {
        // 初始化数据
        int[] nums = getInts();

        int length = nums.length;
        for (int i = 0; i < length-1; i++) {
            heapify(nums, (length - i - 2) / 2, length - i);
            swap(nums, 0, length - i - 1);
        }
        System.out.println(JSON.toJSONString(nums));
    }

    private void heapify(int[] nums, int i,int length) {
        int left = i * 2 + 1;
        int right = left + 1;
        //左右子节点最大值
        int max = i;

        if (right < length) {
            max = nums[left] > nums[right] ? left : right;
        }

        if (nums[left] > nums[max]) {
            max = left;
        }
        if (nums[max] > nums[i]) {
            swap(nums, max, i);
        }
        if (left == 1) {
            return;
        }
        i--;
        heapify(nums, i, length);
    }

}
