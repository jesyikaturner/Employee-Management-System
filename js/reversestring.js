// Takes in a string, and reverses it word by word

(function () {
  main();
})();

function main() {
  var input = "hello my name is world";
  //var newString = ReverseWordByWord(input);
  var newString = ReverseWholeSentence(input);
  console.log(newString);

}

function ReverseWordByWord(input) {
  var array = TurnStringToArray(input);
  var reverse = ReverseArray(array);
	var newString = TurnArrayToString(reverse);
  return newString;
}

function ReverseWholeSentence(input) {
  var newString = "";
  for (var i = 0; i < input.length; i++) {
    newString += input.charAt(input.length - 1 - i);
  }
  return newString;
}

function TurnStringToArray(inputString) {
  // remove white space between words
  //var newString = inputString.replace(/\s/g, '');
  var newStringArray = inputString.split(" ");
  return newStringArray;
}

function ReverseArray (inputArray) {
  var reversedArray = new Array(inputArray.length)
  for(var i = 0; i < inputArray.length; i++){
    reversedArray[inputArray.length-1-i] = inputArray[i];
  }
  return reversedArray;
}

function TurnArrayToString(inputArray) {
	var newString = "";
  for (var i  = 0; i < inputArray.length; i++){
  	newString += inputArray[i] + " ";
  }
	return newString;
}
