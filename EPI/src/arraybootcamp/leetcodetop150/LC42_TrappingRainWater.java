package arraybootcamp.leetcodetop150;

public class LC42_TrappingRainWater {

    public static void main(String[] args) {

        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(trap(new int[]{4, 2, 0, 3, 2, 5}));

        System.out.println(trapDP(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(trapDP(new int[]{4, 2, 0, 3, 2, 5}));

        System.out.println(trap2Pointer(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(trap2Pointer(new int[]{4, 2, 0, 3, 2, 5}));

    }


    // time complexity : O(n^2)
    // space : O(1)
    // lead to TLE
    // Hint for more optimisation : Why to calculate left max and right max for every cel? instead store them in separate array (DP)
    public static int trap(int[] height) {

        int answer = 0;

        for (int i = 1; i < height.length - 1; i++) {
            int leftMax = 0, rightMax = 0;

            for (int j = i; j >= 0; j--) {
                leftMax = Math.max(leftMax, height[j]);
            }

            for (int k = i; k < height.length; k++) {
                rightMax = Math.max(rightMax, height[k]);
            }

            answer += Math.min(leftMax, rightMax) - height[i];

        }

        return answer;
    }


    // time complexity : O(n)
    // space : O(n)
    // Can we do it in constant space? (yes - 2 pointers)
    // Hint for more optimisation :
    public static int trapDP(int[] height) {
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        int answer = 0;

        leftMax[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        rightMax[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        for (int i = 1; i< height.length-1; i++){
            answer+= Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return answer;
    }
    public static int trap2Pointer(int[] height) {
        int left = 0, right = height.length -1, answwer = 0;
        int leftMax = 0, rightMax =0;
        while(left < right){

            if (height[left] < height[right]){
                leftMax = Math.max(leftMax, height[left]);
                answwer += leftMax - height[left];
                left++;
            }else{
                rightMax = Math.max(height[right], rightMax);
                answwer += rightMax - height[right];
                right--;
            }
        }

        return answwer;
    }
}
