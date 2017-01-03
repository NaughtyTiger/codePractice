/**
 * @param {string} s
 * @return {string}
 */

var longestPalindrome = function(s) {
	var n=s.length;
	if (n<=1) return s;
	var longest="";
	var tmpString;
	for (var i=0; i<n-1; i++){
		tmpString=findPalindrome(s,i,i);
		if (tmpString.length>longest.length){
			longest=tmpString;
		}
		tmpString=findPalindrome(s, i, i+1);
		if (tmpString.length>longest.length){
			longest=tmpString;
		}
	}
	return longest;
};

var findPalindrome=function(s, left, right){
	var n=s.length;
	while (left>=0 && right<=n-1 && s[left]==s[right]){
		left--;
		right++;
	}
	return s.substring(left+1, right);
};	

console.log(longestPalindrome("abc"));
console.log(longestPalindrome("abb"));
console.log(longestPalindrome("abba"));
console.log(longestPalindrome("ccc"));

