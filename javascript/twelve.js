/**
 * @param {number} num
 * @return {string}
 */
var intToRoman = function(num) {
	var symbol=["M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", 
			"IX", "V", "IV", "I"];
	var value=[1000,900,500,400, 100, 90,  50, 40,  10, 9,   5,  4,   1];

	var result="";
	for (var i=0; num!=0; i++){
		while (num>=value[i]){
			num=num-value[i];
			result+=symbol[i];
		}
	}
	
	return result;
};
