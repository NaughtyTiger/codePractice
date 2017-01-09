/**
 * @param {number} n
 * @return {string[]}
 */
var result=[];
var generateParenthesis = function(n) {
	result=[];
	var tmp='';
	generateTmpString(n, n, tmp);
	return result;
};

var generateTmpString = function(left, right, tmp){
	if (left===0 && right===0){
		result.push(tmp);
	}
	if (left>0){
		generateTmpString(left-1, right,tmp+'(');
	}
	if (right>0 && right>left){
		generateTmpString(left, right-1, tmp+')');
	}
	return;
};

console.log(generateParenthesis(3));
