package lzhang.leetcode;

/*
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 *
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 */
public class Four {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int lengthX=nums1.length;
    int lengthY=nums2.length;
    int middleIndex=(lengthX+lengthY+1)/2-1;
    
    int numsLong[]=lengthX>=lengthY?nums1:nums2;
    int numsShort[]=lengthX>=lengthY?nums2:nums1;
    
    if ((lengthX+lengthY)%2==1){
      return getPosition(middleIndex, numsLong, numsShort);
    } else {
      return (getPosition(middleIndex, numsLong, numsShort)
          +getPosition(middleIndex+1, numsLong, numsShort))/2;
    }
  }

  private double getTwoPosition(int middleIndex, int[] numsLong, int[] numsShort) {
    int position[]=new int[numsLong.length];
    int middle=Integer.MAX_VALUE;
    int middlePlus=Integer.MAX_VALUE;
    for (int beginIndex=0,endIndex=numsLong.length-1;;){
      int offset=(endIndex+beginIndex)/2;
      if (beginIndex==endIndex){
        position[offset]=findPosition(numsShort, numsLong[offset]);
        int numOfSmall=position[offset]+offset;
        if (numOfSmall==middleIndex){
          middle=numsLong[beginIndex];
        } else if (numOfSmall==middleIndex+1){
          middlePlus=numsLong[beginIndex];
        }
        if (middle==Integer.MAX_VALUE){
          middle=numsShort[middleIndex-beginIndex+(numOfSmall>middleIndex?0:-1)];
        } 
        if (middlePlus==Integer.MAX_VALUE){
          middlePlus=numsShort[middleIndex+1-beginIndex
                               +((numOfSmall>middleIndex+1)?0:-1)];
        }
        return (middleIndex+middle)/2;
      }
      
      position[offset]=findPosition(numsShort, numsLong[offset]);
      int numOfSmall=position[offset]+offset;
      if (numOfSmall==middleIndex){
        middle=numsLong[offset];
        if (middlePlus!=Integer.MAX_VALUE){
          return (middle+middlePlus)/2;
        }
      } else if (numOfSmall==middleIndex+1){
        middlePlus=numsLong[offset];
        if (middle!=Integer.MAX_VALUE){
          return (middle+middlePlus)/2;
        }
      } else if (numOfSmall>middleIndex+1){
        endIndex=offset;
      } else if (numOfSmall<middleIndex){
        beginIndex=offset+1;
      }
    }
  }

  public double getPosition(int middleIndex, int[] numsLong, int[] numsShort) {
    int position[]=new int[numsLong.length];
    for (int beginIndex=0,endIndex=numsLong.length-1;;){
      int offset=(endIndex+beginIndex)/2;
      if (beginIndex==endIndex){
        position[offset]=findPosition(numsShort, numsLong[offset]);
        int numOfSmall=position[offset]+offset;
        if (numOfSmall==middleIndex){
          return numsLong[beginIndex];
        }
        else return numsShort[middleIndex-beginIndex+(numOfSmall>middleIndex?0:-1)];
      }
      
      position[offset]=findPosition(numsShort, numsLong[offset]);
      int numOfSmall=position[offset]+offset;
      if (numOfSmall==middleIndex){
        return numsLong[offset];//TODO
      } else if (numOfSmall>middleIndex){
        endIndex=offset;
      } else if (numOfSmall<middleIndex){
        beginIndex=offset+1;
      }
    }
  }
  
  private int findPosition(int nums[], int num){
    if (nums.length==0){
      return 0;
    }
    if (num>nums[nums.length-1]){
      return nums.length;
    } 
    if (num<nums[0]){
      return 0;
    }
    for (int beginIndex=0,endIndex=nums.length-1;beginIndex!=endIndex;){
      int offset=(endIndex+beginIndex)/2;
      if (nums[offset]<num && nums[offset+1]>=num){
        return offset+1;
      } 
      if (nums[offset+1]<num){
        beginIndex=offset+1;
      } else if (nums[offset]>=num){
        endIndex=offset;
      }
    }
    return 0;//TODO
  }
}
