main();

function main() {
  var number = "";
  var finalString = "";
  for(var i = 0; i < 101; i++){
    if(i % 3 == 0 && i % 5 == 0){
    	number = "FizzBuzz";
    }
    else if(i % 5 == 0){
      number = "Buzz";
    }
    else if (i % 3 == 0) {
      number = "Fizz";
    }else {
        number = "" + i;
    }
    finalString += number + "  ";
  }
  console.log(finalString);
}
