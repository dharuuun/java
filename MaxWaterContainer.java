public class MaxWaterContainer {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int width = right - left;
            int currentArea = Math.min(height[left], height[right]) * width;
            maxArea = Math.max(maxArea, currentArea);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        MaxWaterContainer solution = new MaxWaterContainer();
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("Max Area: " + solution.maxArea(height));
    }
}
