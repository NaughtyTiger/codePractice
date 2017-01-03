/**
 * @param {number} x
 * @return {number}
 */
var reverse = function(x) {
	debugger;
	var result=0;
	var flag=false;
	
	var maxInt=Math.floor(((1<<30)*2-1)/10);
	if (x<0){
		x=-x;
		flag=true;
	}
	while (x>0){
		if (result>maxInt){
			return 0;
		}
		result=result*10+x%10;
		x=Math.floor(x/10);
	}
	return flag?-result:result;
};

console.log(reverse(1));
