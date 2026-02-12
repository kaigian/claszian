package pers.kaigian.claszian.leetcode.P1_100;

import java.util.*;

public class Solution {
    /**
     * P26:删除排序数组中的重复项
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        int slow = 1, fast = 1;
        while (fast < nums.length) {
            if (nums[fast] == nums[fast - 1]) {
                fast++;
                continue;
            }
            nums[slow] = nums[fast];
            slow++;
            fast++;
        }
        return slow;
    }

    /**
     * P27:移除元素
     */
    public int removeElement(int[] nums, int val) {
        int left = 0, right = nums.length - 1;
        while (left < nums.length && right >= 0 && left <= right) {
            while (nums[right] == val) {
                right--;
            }
            while (nums[left] != val) {
                left++;
            }
            if (left < right) {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                left++;
                right--;
            }
        }
        return left;
    }

    /**
     * P34:在排序数组中查找元素的第一个和最后一个位置
     */
    public int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length - 1, start = nums.length, end = -1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] >= target) {
                start = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (start > nums.length - 1 || nums[start] != target) {
            return new int[] { -1, -1 };
        }
        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] <= target) {
                end = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return new int[] { start, end };
    }

    /**
     * P35:搜索插入位置
     */
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid = -1;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (left == right) {
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] < target) {
                    return mid + 1;
                } else if (nums[mid] > target) {
                    return mid;
                }
            }
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * P54:螺旋矩阵
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = n - 1, top = 0, bottom = m - 1, i = 0, j = 0;
        boolean toRight = true, toBottom = false, toLeft = false, toTop = false;
        while (true) {
            result.add(matrix[i][j]);
            if (toRight) {
                if (j < right) {
                    j++;
                } else {
                    i++;
                    if (i > bottom) {
                        break;
                    }
                    top++;
                    toRight = false;
                    toBottom = true;
                }
            } else if (toBottom) {
                if (i < bottom) {
                    i++;
                } else {
                    j--;
                    if (j < left) {
                        break;
                    }
                    right--;
                    toBottom = false;
                    toLeft = true;
                }
            } else if (toLeft) {
                if (j > left) {
                    j--;
                } else {
                    i--;
                    if (i < top) {
                        break;
                    }
                    bottom--;
                    toLeft = false;
                    toTop = true;
                }
            } else if (toTop) {
                if (i > top) {
                    i--;
                } else {
                    j++;
                    if (j > right) {
                        break;
                    }
                    left++;
                    toTop = false;
                    toRight = true;
                }
            }
        }
        return result;
    }

    /**
     * P59:螺旋矩阵 II
     */
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int num = 1, left = 0, right = n - 1, top = 0, bottom = n - 1, i = 0, j = 0;
        boolean toRight = true, toBottom = false, toLeft = false, toTop = false;
        while (num <= n * n) {
            result[i][j] = num;
            num++;
            if (toRight) {
                if (j < right) {
                    j++;
                } else {
                    i++;
                    top++;
                    toRight = false;
                    toBottom = true;
                }
            } else if (toBottom) {
                if (i < bottom) {
                    i++;
                } else {
                    j--;
                    right--;
                    toBottom = false;
                    toLeft = true;
                }
            } else if (toLeft) {
                if (j > left) {
                    j--;
                } else {
                    i--;
                    bottom--;
                    toLeft = false;
                    toTop = true;
                }
            } else if (toTop) {
                if (i > top) {
                    i--;
                } else {
                    j++;
                    left++;
                    toTop = false;
                    toRight = true;
                }
            }
        }
        return result;
    }

    /**
     * P69:X的平方根
     */
    public int mySqrt(int x) {
        int left = 0, right = x, ans = x;
        while (left <= right) {
            int mid = left + ((right - left) / 2);
            if ((long) mid * mid > x) {
                ans = mid - 1;
                right = mid - 1;
            } else if ((long) mid * mid < x) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return ans;
    }

    /**
     * P76:最小覆盖子串
     */
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        Map<Character, Integer> tCntMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            tCntMap.put(ch, tCntMap.getOrDefault(ch, 0) + 1);
        }
        int left = 0, right = 0, len = 0;
        String ans = "";
        boolean needPut = true;
        while (right < s.length()) {
            if (left > right) {
                right++;
                continue;
            }
            char rightChar = s.charAt(right);
            if (tCntMap.containsKey(rightChar) && needPut) {
                tCntMap.put(rightChar, tCntMap.get(rightChar) - 1);
            }
            if (!checkMinWindow(tCntMap)) {
                right++;
                needPut = true;
            } else {
                if (len == 0 || len > right - left + 1) {
                    len = right - left + 1;
                    ans = s.substring(left, right + 1);
                }
                char leftChar = s.charAt(left);
                if (tCntMap.containsKey(leftChar)) {
                    tCntMap.put(leftChar, tCntMap.get(leftChar) + 1);
                }
                left++;
                needPut = false;
            }
        }
        return ans;
    }

    private boolean checkMinWindow(Map<Character, Integer> map) {
        for (Integer val : map.values()) {
            if (val > 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        System.out.println(solution.spiralOrder(matrix));
    }
}
