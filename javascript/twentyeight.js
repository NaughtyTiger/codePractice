/**
 * @param {string} haystack
 * @param {string} needle
 * @return {number}
 */
var strStr = function(haystack, needle) {
  for (var i=0; i<haystack.length+1-needle.length; i++){
  	var j=0;
  	for (; j<needle.length; j++){
		if (needle[j]!==haystack[i+j]){
  			break;
  		}
  	}
  }  
};