package leetcode.dynamicPromgramming;

import java.util.ArrayList;

public class FindSubSeq {


    private static ArrayList<Integer> path = new ArrayList<>();

    private static int ret;

    private static void dfs(int[] nums, boolean[] used){
        if(path.size()==3){
            ret++;
            return;
        }
        for(int i = 1;i<nums.length;i++){
            if(nums[i-1]>nums[i]||used[i-1]){
                continue;
            }
            path.add(nums[i-1]);
            used[i-1] = true;
            dfs(nums,used);
            path.remove(path.size()-1);
            used[i-1] = false;
        }
    }


    public static void main(String[] args) {

    }
}
