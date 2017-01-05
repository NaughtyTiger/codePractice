/**
 * @param {number} x
 * @return {boolean}
 */
var isPalindrome = function(x) {
	if (x===0){
		return true;
	} else if (x<0){
		return false;
	}
	var p=x;
	var length=0;
	while (p>0){
		length++;
		p=Math.floor(p/10);
	}

	p=x;
	for (var i=0; i<length/2; i++){
		if (m%10===Math.floor(m/Math.pow(10, length-i*2-1))){
			m=m%Math.floor(Math.pow(10, length-i*2-1));
			m=Math.floor(m/10);
			continue;
		} 
		return false;
	}
	return true;
};
