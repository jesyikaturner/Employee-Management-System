/*
  * Exploring an older bit of code and making it more versitile.
  * User can input a date and a format to generate a date string. 
  * It's not the best, but it should handle most format inputs.
  * Jessica Turner. 2017.
*/

(function() {
    var birthdate = BirthDateGenerator(24,3,1992,2005,'yyyy-mm-dd');
    alert(birthdate);

})();

function BirthDateGenerator(day,month,startyear,endyear,format)
{	
	var s_day = '', s_month = '', s_year = '';
	var count;

	// Validating the format argument.
	if(typeof format === 'undefined' || format === '')
	{
		format = 'dd-mm-yy';
	}
	
	// Validating the month argument.
	if(typeof month != 'number'){
		s_month = RandomMonth();
	}else {
        if(check(month,1,12)){
            if(month < 10){
                s_month = '0'+ month;
            }else {
                s_month = month;
            }
        }else{
            s_month = RandomMonth();
        }
	}
	
	// Validating the day argument.
	if(typeof day != 'number'){
		s_day = RandomDay(s_month);
	}else {
        if(check(day,1,31)){
            if(day < 10){
                s_day = '0'+ day;
            }else {
                s_day = day;
            }
        }else{
            s_day = RandomDay(s_month);
        }
	}
	
	// Validating the years.	
	if(typeof startyear === 'undefined'){
		startyear = 1985;
	}
	if(typeof endyear === 'undefined'){
		endyear = 2005;
	}
	
	s_year = ''+randomInt(startyear,endyear);
	
	// Replacing the format with the dates.
	format = format.replace(/dd/gi,s_day);
	format = format.replace(/mm/gi,s_month);
	
	if(CountCharacters(format, 'y') > 2){
		format = format.replace(/yyyy/gi,s_year);
	}else{
		format = format.replace(/yy/gi,''+s_year[2]+s_year[3]);
	}
	
	//alert(format);
  return format;
}

function check(value, min_limit, max_limit)
{
    if(value < min_limit || value > max_limit){
        return false;
    }
    return true;
}

function RandomMonth()
{
	var month;
	var s_month = '';
	
	month = randomInt(1,12);
	
	if(month < 10){
		s_month = '0'+ month;
	}else {
		s_month = month;
	}
	return s_month;
}

function RandomDay(month)
{
	var day, m_days;
	var s_day = '';
	
	switch(month)
	{
		case '02':
			m_days = 28;
			break;
		case '04':
			m_days = 30;
			break;
		case '06':
			m_days = 30;
			break;
		case '08':
			m_days = 30;
			break;
		case '09':
			m_days = 30;
			break;
		case '11':
			m_days = 30;
			break;
		default:
			m_days = 31;
	}
	
	day = randomInt(1,m_days);
	
	if(day < 10){
		s_day = '0' + day;
	}else{
		s_day = day;
	}
	
	return s_day;
}

function CountCharacters(string, character)
{
	var count = 0;
	
	for(var i = 0; i < string.length; i++)
	{
		if(string[i] == character){
			count++;
		}
	}
	return count;
}

function randomInt(min, max)
{  
  // If values haven't been defined, basically it won't work.
  if(typeof min == 'undefined' || typeof max == 'undefined'){
    return -1;
  }
  return Math.floor(Math.random()*(max-min+1)+min);
}