/**
 *
 * <p>
 * Title: LCSAlgorithm.java
 * </p>
 *
 * <p>
 * Description:
 * </p>
 *
 * <p>
 * Copyright: Copyright (c) 2017
 * </p>
 *
 * <p>
 * Company: zyx@taeyeon.cn
 * </p>
 *
 * @author KEN
 *
 * @date 2018年2月26日
 *
 * @version 1.0
 *
 */

package com.zyx.dynamicPrograming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author KEN
 *
 */
public class LCSAlgorithm {
    public void myLCS(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        int c[][] = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                if (i == 0 || j == 0) {
                    c[i][j] = 0;
                } else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    c[i][j] = c[i - 1][j - 1] + 1;
                } else {
                    c[i][j] = Math.max(c[i - 1][j], c[i][j - 1]);
                }
            }
        }
        System.out.println("++++++++++++++++++打印序列+++++++++++++++++++");
        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                System.out.print(c[i][j] + "\t");
            }
            System.out.println();
        }
        // return c[len1][len2];
    }

    public int[] twoSum(int[] nums, int target) {
        if (nums.length <= 1) {
            return null;
        }
        // int[] result = null;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    nums[0] = i;
                    nums[1] = j;
                }
            }
        }

        return nums;

    }

    public int[] twoSum2(int[] nums, int target) {
        if (nums.length <= 1) {
            return null;
        }
        int[] result = { 0, 0 };
        int a = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int j = 0; j < nums.length; j++) {
            a = target - nums[j];
            if (map.containsKey(a) && j != map.get(a)) {

                result[0] = j;
                result[1] = map.get(a);
                return result;
            }
        }

        throw new IllegalArgumentException("No two sum solution");
    }

    public List<List<Integer>> twoSum2(int[] nums, int target, int start) {
        if (nums.length <= 1) {
            return null;
        }
        int a = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        List<List<Integer>> list1 = new ArrayList();
        List<Integer> list2 = new ArrayList();
        for (int j = start; j < nums.length - 1; j++) {
            a = target - nums[j];
            if (map.containsKey(a) && j != map.get(a)) {
                list2 = new ArrayList();
                list2.add(map.get(a));
                list2.add(j);
                list1.add(list2);
            } else {
                map.put(nums[j], j);
            }
        }

        return list1;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 2) {
            return null;
        }
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i + 2 < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) { // skip same result
                continue;
            }
            int j = i + 1, k = nums.length - 1;
            int target = 0 - nums[i];
            while (j < k) {
                if (nums[j] + nums[k] == target) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++; // skip same result
                    }
                    while (j < k && nums[k] == nums[k + 1]) {
                        k--; // skip same result
                    }
                } else if (nums[j] + nums[k] > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        for (List l : res) {
            for (int i = 0; i < l.size(); i++) {
                System.out.print(l.get(i) + "\t");
            }
            System.out.println();
        }
        return res;

    }

    public List<List<Integer>> threeSum(int[] nums, int start, int factor, int sum) {
        if (nums.length < 2) {
            return null;
        }
        List<List<Integer>> res = new ArrayList<>();

        for (int i = start + 1; i + 2 < nums.length; i++) {
            if (i > start + 1 && nums[i] == nums[i - 1]) { // skip same result
                continue;
            }
            int j = i + 1, k = nums.length - 1;
            int target = sum - nums[i];
            while (j < k) {
                if (nums[j] + nums[k] == target) {
                    res.add(Arrays.asList(factor, nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++; // skip same result
                    }
                    while (j < k && nums[k] == nums[k + 1]) {
                        k--; // skip same result
                    }
                } else if (nums[j] + nums[k] > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return res;
    }

    public List<List<Integer>> fourSum2(int[] nums, int target) {
        if (nums.length < 4) {
            return null;
        }
        List<List<Integer>> res = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);

        for (int i = 0; i + 3 < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) { // skip same result
                continue;
            }
            res = threeSum(nums, i, nums[i], target - nums[i]);
            if (null != res) {
                result.addAll(res);
            }
        }

        for (List l : result) {
            for (int i = 0; i < l.size(); i++) {
                System.out.print(l.get(i) + "\t");
            }
            System.out.println();
        }
        return result;

    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 4) {
            return res;
        }
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 3; i++) {
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            if (nums[i] + nums[n - 1] + nums[n - 2] + nums[n - 3] < target) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < n - 2; j++) {
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                if (nums[i] + nums[j] + nums[n - 2] + nums[n - 1] < target) {
                    continue;
                }
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int low = j + 1, high = n - 1;
                while (low < high) {
                    int sum = nums[i] + nums[j] + nums[low] + nums[high];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
                        while (low < high && nums[low] == nums[low + 1]) {
                            low++;
                        }
                        while (low < high && nums[high] == nums[high - 1]) {
                            high--;
                        }
                        low++;
                        high--;
                    } else if (sum < target) {
                        low++;
                    } else {
                        high--;
                    }
                }
            }
        }
        for (List l : res) {
            for (int i = 0; i < l.size(); i++) {
                System.out.print(l.get(i) + "\t");
            }
            System.out.println();
        }
        return res;

    }

    public static void main(String[] args) {
        // String str1 = "cnblogs";
        // String str2 = "belongg";
        LCSAlgorithm lcs = new LCSAlgorithm();
        // lcs.myLCS(str1, str2);

        int[] a = { 1, 0, -1, 0, -2, 2 };// { -1, 0, 1, 2, -1, -4 };
        // a = lcs.twoSum2(a, 2, 0);
        // for (int i = 0; i < a.length; i++) {
        // System.out.println(a[i]);
        // }

        lcs.fourSum(a, 0);

    }

}
