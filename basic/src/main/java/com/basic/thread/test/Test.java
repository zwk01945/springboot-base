package com.basic.thread.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName: Test <br/>
 * Description: <br/>
 * date: 2020/6/24 16:55<br/>
 *
 * @author zyl<br />
 */
public class Test {

    public static void main(String[] args) {
        Solution solution=new Solution();
        int[] nums=new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(solution.threeSum(nums));
    }

    static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i++) {
                System.out.print(nums[i]);
            }
            List reslist=new ArrayList();
            List arrlist=new ArrayList();
            for (int i=0;i<nums.length;i++){
                if(nums[i]>0&&nums[i]==nums[i-1]){
                    continue;
                }
                int j=i+1;
                int k=nums.length-1;
                while (j<k){
                    if(nums[i]+nums[j]+nums[k]==0){
                        arrlist.clear();
                        arrlist.add(nums[i]);
                        arrlist.add(nums[j]);
                        arrlist.add(nums[k]);

                        reslist.add(arrlist);
                        j++;
                    }else if(nums[i]+nums[j]+nums[k]>0){
                        k--;
                    }else{
                        j++;
                    }
                }


            }
            return reslist;
        }
    }
}
