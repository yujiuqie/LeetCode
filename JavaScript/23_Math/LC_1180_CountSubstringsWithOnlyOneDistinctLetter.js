/**
 * @param {string} s
 * @return {number}
 */
var countLetters = function(s) {
    var res = 0;
    var count = 1;
    for(i = 1; i < s.length; i++){
        if(s[i] == s[i - 1]){
            count++;
        }
        else{
            res += count * (count + 1) / 2;
            count = 1;
        }
    }

    res += count * (count + 1) / 2;
    return res;
};