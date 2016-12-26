/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstring = function(s) {
	if (!s || s.length===0){
		return 0;
	}

	var map={};
	var len=0;
	var maxLen=1;
    var start=0;

    for (var i=start; i<s.length; i++){
    	c=s[i];
    	if (map[c]!==undefined && map[c]>=start){
    		start=map[c]+1;
    	}
		len=i-start+1;

    	if (len>maxLen){
    		maxLen=len;
    	}

    	map[c]=i;
    }
    return maxLen;
};

console.log(lengthOfLongestSubstring("abcabcbb"));
console.log(lengthOfLongestSubstring("bbbbb"));
console.log(lengthOfLongestSubstring("pwwkew"));
console.log(lengthOfLongestSubstring("c"));
console.log(lengthOfLongestSubstring("au"));