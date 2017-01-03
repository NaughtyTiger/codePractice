/**
 * @param {string} str
 * @return {number}
 */
var myAtoi = function(str) {
	if (str.length===0){
		return 0;
	}
	str=str.trim();	
	
	var pattern=/^(\+|\-)?[0-9]+/; // RegExp object
  	var tmp = pattern.exec(str);

  	if (tmp) {
    	var num = Number(tmp[0]);
    	if (num < -2147483648)
      		return -2147483648;
    	if (num > 2147483647)
      		return 2147483647;
    	return num;
  	}

  	return 0;

};
