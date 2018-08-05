/*
 * Auto-Form Filler, with random email and birthdate.
 * Jessica Turner 2016.
*/

function randomInt(min, max)
{  
  // If values haven't been defined, basically it won't work.
  if(typeof min == 'undefined' || typeof max == 'undefined'){
    return -1;
  }
  return Math.floor(Math.random()*(max-min+1)+min);
}

function randomBirthDateToString()
{
  var day, month, year;
  var s_day = '', s_month = '', date;
  
  month = randomInt(1,12);
  
  /* 
   * Prepending a '0' to the month if it's a single digit
   * to make it a legit date.
  */
  if(month < 10){
    s_month = '0'+ month;
  }else {
    s_month = month;
  }
  
  /*
   * Since every month has different dates, I'm setting the
   * max date as 28 days. This could be expanded to change
   * depending on the month but I'm lazy.
  */
  day = randomInt(1,28);
  if(day < 10){
    s_day = '0' + day;
  }else{
    s_day = day;
  }
  
  year = randomInt(1985,2005);
    
  date = year + '-' + s_month + '-' + s_day;
  return date;
}

function CreateRandomEmail(length, domain)
{
  var domains = ["@hotmail.com","@yahoo.com", "@gmail.com",
  "@live.com","@live.com.au","@outlook.com"];
  var chars = 'abcdefghijklmnopqrstuvwxyz1234567890';
  var email = '';
  
  /*
   * If the parameters have been left blank, putting in some random
   * arguments to make it work.
  */ 
  if(typeof domain == 'undefined' || domain === ''){
    domain = domains[Math.floor(Math.random() * domains.length)];
  }
  if(typeof length == 'undefined' || length = 0){
    length = 7;
  }
  
  for(var i = 0; i < length; i++){
    email += chars[Math.floor(Math.random() * chars.length)];
  }
  
  email+= domain;
  
  return email;
}