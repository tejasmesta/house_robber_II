public int rob(int[] nums) {
	int length = nums.length;
	if(length<=2)
	{
		return length==1?nums[0]:Math.max(nums[0],nums[1]);
	}

	int maxWithStart = houseRobOne(Arrays.copyOfRange(nums, 0, length-1));
	int maxWithEnd = houseRobOne(Arrays.copyOfRange(nums, 1, length));
	return Math.max(maxWithStart,maxWithEnd);
}

public int houseRobOne(int[] nums){
	int length = nums.length;

	int[] maxAmount = new int[length];
	maxAmount[0] = nums[0];
	maxAmount[1] = Math.max(nums[0],nums[1]);

	for(int i=2; i<length; i++)
	{
		maxAmount[i] = Math.max(maxAmount[i-2]+nums[i],maxAmount[i-1]);
	}

	return maxAmount[length-1];
}
