/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var threeSum = function(nums) {
	nums.sort(function(x, y){
		if(x<y){
			return -1;
		}
		if (x>y){
			return 1;
		}
		return 0;
	});
	var result=[];

	debugger;
	for (var i=0; i<nums.length-2; i++){
		if (i===0 || (i>0 && nums[i]!==nums[i-1])){
			var lo=i+1;
			var hi=nums.length-1;
			var sum=0-nums[i];
			while (lo<hi){
				if(nums[lo]+nums[hi]===sum){
					result.push([nums[i],nums[lo],nums[hi]]);
					while (lo<hi && nums[lo]===nums[lo+1]){
						lo++;
					}
					while (lo<hi && nums[hi]===nums[hi-1]){
						hi--;
					}
					lo++;
					hi--;
				} else if (nums[lo]+nums[hi]<sum){
					lo++;
				} else {
					hi--;
				}
			}
		}
	}
	return result;
};

var num=[-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,16];
console.log(threeSum(num));
