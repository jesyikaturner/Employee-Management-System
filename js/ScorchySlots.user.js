/*
 * Made this for Neopets, so it would play a Slot Machine Game for me.
 * Jessica Turner 2016.
*/


// ==UserScript==
// @name           Scorchy Slots
// @description	   Autoplays Scorchy Slots
// @include        http://www.neopets.com/games/slots.phtml*
// ==/UserScript==

var x = (Math.random() * 1000)+1000; //Page delay; 1000 = 1 second

function delay() 
{

    var button;

    if(document.body.innerHTML.indexOf('HOLD') != -1){

        var treasure, gold, faeries, bell, peach;
        var t = [0,0,0,0], g = [0,0,0,0], f = [0,0,0,0], b = [0,0,0,0], p = [0,0,0,0];

        var url = ["//form/table/tbody/tr[2]/td[1]/", "//form/table/tbody/tr[2]/td[2]/", 
                   "//form/table/tbody/tr[2]/td[3]/", "//form/table/tbody/tr[2]/td[4]/"];
        var images = ["http://images.neopets.com/games/slots/mappiece_0.gif",
                      "http://images.neopets.com/games/slots/baggold_0.gif",
                      "http://images.neopets.com/games/slots/faerie_0.gif",
                      "http://images.neopets.com/games/slots/bell_0.gif",
                      "http://images.neopets.com/games/slots/bell_1.gif",
                      "http://images.neopets.com/games/slots/bell_2.gif",
                      "http://images.neopets.com/games/slots/bell_3.gif",
                      "http://images.neopets.com/games/slots/peach_0.gif",
                      "http://images.neopets.com/games/slots/peach_1.gif",
                      "http://images.neopets.com/games/slots/peach_2.gif",
                      "http://images.neopets.com/games/slots/peach_3.gif"];

        for(var i = 0; i < 4; i++)
        {
            // Checking Treasure Maps
            treasure = document.evaluate(url[i]+'img[@src="'+images[0]+'"]',document,null,XPathResult.UNORDERED_NODE_SNAPSHOT_TYPE,null);
            if(treasure.snapshotLength > 0){t[i] = t[i]+1;}

            // Checking Gold
            gold = document.evaluate(url[i]+'img[@src="'+images[1]+'"]',document,null,XPathResult.UNORDERED_NODE_SNAPSHOT_TYPE,null);
            if(gold.snapshotLength > 0){g[i] = g[i]+1;}

            // Checking Faeries
            faeries = document.evaluate(url[i]+'img[@src="'+images[2]+'"]',document,null,XPathResult.UNORDERED_NODE_SNAPSHOT_TYPE,null);
            if(faeries.snapshotLength > 0){f[i] = f[i]+1;}

            // Checking Bells
            bell = document.evaluate(url[i]+'img[@src="'+images[3+i]+'"]',document,null,XPathResult.UNORDERED_NODE_SNAPSHOT_TYPE,null);
            if(bell.snapshotLength > 0){b[i] = b[i]+1;}

            // Checking Peaches
            peach = document.evaluate(url[i]+'img[@src="'+images[7+i]+'"]',document,null,XPathResult.UNORDERED_NODE_SNAPSHOT_TYPE,null);
            if(peach.snapshotLength > 0){p[i] = p[i]+1;}
        }

        // Clicking the Hold Checkboxes
        
        var tA = arrAdd(t), gA = arrAdd(g), fA = arrAdd(f), bA = arrAdd(b), pA = arrAdd(p);
        
        if(tA>=1 && gA<=1 && fA<=2 || tA>=2){check(t,button);}
        else if(gA>=2){check(g,button);}
        else if(fA>=2){check(f,button);}
        else if(bA>=3){check(b,button);}
        else if(pA>=3){check(p,button);}
        else if(gA>=1){check(g,button);}
        else if(fA>=1){check(f,button);}
        else if(bA>=2){check(b,button);}
        else if(pA>=2){check(p,button);}
        else if(fA>=1){check(f,button);}
    }

    if(document.body.innerHTML.indexOf('Click Here to Play') != -1){
        button = document.evaluate('//form[contains(@action,"slots.phtml")]/input[@type = "hidden" and @value = "yes"]',document,null,XPathResult.UNORDERED_NODE_SNAPSHOT_TYPE,null).snapshotItem(0);
    }

    if(document.body.innerHTML.indexOf('Play Again') != -1){
        button = document.evaluate('//form[contains(@action,"process_slots2.phtml")]/input[@type = "hidden" and @name = "_ref_ck"]',document,null,XPathResult.UNORDERED_NODE_SNAPSHOT_TYPE,null).snapshotItem(0);
    }

    if(document.body.innerHTML.indexOf('Collect Winnings') != -1){
        button = document.evaluate('//input[@type = "hidden" and @value = "true" and @name="collect"]',document,null,XPathResult.UNORDERED_NODE_SNAPSHOT_TYPE,null).snapshotItem(0);
    }
    button.click();
    button.form.submit();

}window.setTimeout(delay, x);

function check(inputarray, button)
{
    if(inputarray[0]>0){button = document.evaluate('//input[@type = "checkbox" and @name ="hold1"]',document,null,XPathResult.UNORDERED_NODE_SNAPSHOT_TYPE,null).snapshotItem(0); button.click();}
    if(inputarray[1]>0){button = document.evaluate('//input[@type = "checkbox" and @name ="hold2"]',document,null,XPathResult.UNORDERED_NODE_SNAPSHOT_TYPE,null).snapshotItem(0); button.click();}
    if(inputarray[2]>0){button = document.evaluate('//input[@type = "checkbox" and @name ="hold3"]',document,null,XPathResult.UNORDERED_NODE_SNAPSHOT_TYPE,null).snapshotItem(0); button.click();}
    if(inputarray[3]>0){button = document.evaluate('//input[@type = "checkbox" and @name ="hold4"]',document,null,XPathResult.UNORDERED_NODE_SNAPSHOT_TYPE,null).snapshotItem(0); button.click();}
}

// Adds the values in the array up and then returns the total
function arrAdd(inputarray)
{
    var total = 0;
    for (var i = 0; i < inputarray.length; i++){
        total += inputarray[i];
    }
    return total;
}
