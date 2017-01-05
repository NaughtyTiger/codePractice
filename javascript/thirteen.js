/**
 * @param {string} s
 * @return {number}
 */
var romanToInt = function(s) {
	var result=0;
	if (s.indexOf("IV")!=-1)result-=2;
	if (s.indexOf("IX")!=-1)result-=2;
	if (s.indexOf("XL")!=-1)result-=20;
	if (s.indexOf("XC")!=-1)result-=20;
	if (s.indexOf("CD")!=-1)result-=200;
	if (s.indexOf("CM")!=-1)result-=200;

	for (var i=0; i<s.length; i++){
		if (s[i]==='M') result+=1000;
		if (s[i]==='D') result+=500;
		if (s[i]==='C') result+=100;
		if (s[i]==='L') result+=50;
		if (s[i]==='X') result+=10;
		if (s[i]==='V') result+=5;
		if (s[i]==='I') result+=1;
	}

	return result;
};
