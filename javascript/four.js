/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number}
 */
var findMedianSortedArrays = function(nums1, nums2) {
	// console.log("findMedianSortedArrays: "+nums1+";"+nums2);
	var lengthX=nums1.length;
	var lengthY=nums2.length; 
	var middleIndex=Math.floor((lengthY+lengthX+1)/2)-1;
	// console.log("middleIndex: "+middleIndex);

   	var numsLong=lengthX>lengthY?nums1:nums2;
   	var numsShort=lengthX>lengthY?nums2:nums1;

   	if ((lengthX+lengthY)%2===1){
   		return getPosition(middleIndex, numsLong, numsShort);
    } else {
		return ((getPosition(middleIndex, numsLong, numsShort)+
			getPosition(middleIndex+1, numsLong, numsShort)))/2;
    }
};

var getPosition = function(middleIndex, numsLong, numsShort){
	// console.log("getPosition: "+middleIndex+";"+numsLong+";"+numsShort);
	var position=[];
	position.length=numsLong.length;
	for (var beginIndex=0, endIndex=numsLong.length-1;;){
		var offset=Math.floor((endIndex+beginIndex)/2);
		if (beginIndex===endIndex){
			position[offset]=findPosition(numsShort, numsLong[offset]);
			// console.log("position: "+position);
			var numOfSmall=position[offset]+offset;
			if (numOfSmall===middleIndex){
				return numsLong[beginIndex];
			} else {
				return numsShort[middleIndex-beginIndex
					+(numOfSmall>middleIndex?0:-1)];
			}
		}
		// console.log("numsShort:"+numsShort+"numsLong: "+numsLong+" offset:"+offset);
		// console.log("position: "+position);
		position[offset]=findPosition(numsShort, numsLong[offset]);
		// console.log("position: "+position);
		var numOfSmall=position[offset]+offset;
		if (numOfSmall===middleIndex){
			return numsLong[offset];
		} else if (numOfSmall>middleIndex){
			endIndex=offset;
		} else if (numOfSmall<middleIndex){
			beginIndex=offset+1;
		}
	}
};

var findPosition=function(nums, num){
	// console.log("findPosition: "+nums+","+num);
	if (nums.length===0){
		return 0;
	}
	if (num>nums[nums.length-1]){
		return nums.length;
	}
	if (num<nums[0]){
		return 0;
	}
	for (var beginIndex=0, endIndex=nums.length-1; beginIndex!=endIndex;){
		var offset=Math.floor((endIndex+beginIndex)/2);
		if (nums[offset]<num && nums[offset+1]>=num){
			return offset+1;
		}
		if (nums[offset+1]<num){
			beginIndex=offset+1;
		} else if (nums[offset]>=num){
			endIndex=offset;
		}
	}
	return 0;
};

console.log(findMedianSortedArrays([1, 1], [1,1]))
