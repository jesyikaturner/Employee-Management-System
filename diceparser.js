var string = "1d6+2 2d6-1 3d12 5d100"

console.log(DiceRoller(string));

// takes in the format [numberofdice]d[numberofsides][modifier] eg. 1d6+2 (currently can't do -2)
function DiceRoller(inputString){
	var result = "";
	var tokens = ['d','+'];
	var inputArray = inputString.split(" ");
	
	for(var i = 0; i < inputArray.length; i++){
		var temp = splitMulti(inputArray[i],tokens);
		result += printDiceRoll(temp) + "\n";
	}
	return result;
}

// splits the string up by the tokens.
function splitMulti(inputString, tokens){
	var tempChar = tokens[0];
	for (var i = 0; i < tokens.length; i++){
		inputString = inputString.split(tokens[i]).join(tempChar);
	}
	inputString = inputString.split(tempChar);
	return inputString;
}

// generates random numbers between 1 -> max, numOfDice times. Then returns them
// as an array.
function rollDice (numOfDice, howManySides){
	var array = new Array(numOfDice);
	for (var i = 0; i < array.length; i++){
		array[i] = GenerateNumber(howManySides + 1);
	}
	return array;
}

// adds up all the dice results and returns a total.
function calculateTotal(diceResults){
	var total = 0;
	for (var i  = 0; i < diceResults.length; i++){
		total += diceResults[i];
	}
	return total;
}

// format the results - Total (d1 result, d2 result...)modifier.
function printDiceRoll(parsedString){
	var numOfDice = parseInt(parsedString[0]);
	var howManySides = parseInt(parsedString[1]);
	if (parsedString[2] != null){
		var modifier = parseInt(parsedString[2]);
	}else{
		modifier = 0;
	}
	
	var diceResults = rollDice(numOfDice,howManySides);
	var total = calculateTotal(diceResults);
	total = total + modifier;
	
	var result = "" + total + " (";
	for (var i = 0; i < diceResults.length; i++){
		result += diceResults[i];
		if (diceResults.length > 1 && i != diceResults.length -1){
			result += ",";
		}
	}
	result += ")";
	
	if (modifier != 0){
		result += "+(" + modifier + ") ";
	}
	
	return result;
}

// takes in the max number of sides, then generates the random number from 1.
function GenerateNumber(max){
	var result = Math.floor(Math.random() * max); //should be from 1 -> max
	if (result > max){
		result = max;
	}
	if (result < 1){
		result = 1;
	}
	
	return result;
}