/**
 * @param {string} s
 * @param {number} numRows
 * @return {string}
 */

var convert = function(s, numRows) {
	var map, numCols;
	if (numRows===1){
		return s;
	}
	var result='';
	map=[];
	for (var i=0; i<numRows; i++){
		map[i]=[];
	}
	var down=true;
	numCols=0;
	var rol=0;
	for (var i=0; i<s.length; i++){
		map[rol][numCols]=s[i];
		if (down){
			if (rol===numRows-1){
				down=false;
				rol--;
				numCols++;
			} else {
				rol++;				
			}
		} else {
			if (rol===0){
				down=true;
				rol++;
				numCols++;
			} else {
				rol--;
			}
		}
	}

	for (var i=0; i<numRows; i++){
		for (var j=0; j<=numCols; j++){
			if (map[i][j]!==undefined){
				result+=map[i][j];
			}
		}
	}

	return result;
};

console.log(convert("PAYPALISHIRING", 3));
