/**
 * @param {number} n
 * @return {boolean}
 */
var isArmstrong = function(n) {
    var ori = n;
    var bit = String(n).split('')
    var sum = 0;
    var len = bit.length;
    for(var i = 0; i < len; i++){
        sum = sum + Math.pow(Number(bit[i]),len);
    }
    return sum === ori;
};