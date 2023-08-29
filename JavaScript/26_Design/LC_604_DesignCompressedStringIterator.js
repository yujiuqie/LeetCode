/**
 * @param {string} compressedString
 */

var StringIterator = function(compressedString) {
    this.index = 0;
    this.group = Array.from(compressedString.match(/\D|\d+/g))
};

/**
 * @return {character}
 */
StringIterator.prototype.next = function() {
    if(!this.hasNext()){
        return ' ';
    }

    const res = this.group[this.index];
    this.group[this.index + 1]--;

    if(this.group[this.index + 1] === 0){
        this.index += 2;
    }

    return res;
};

/**
 * @return {boolean}
 */
StringIterator.prototype.hasNext = function() {
    return this.group[this.index + 1] > 0;
};

/**
 * Your StringIterator object will be instantiated and called as such:
 * var obj = new StringIterator(compressedString)
 * var param_1 = obj.next()
 * var param_2 = obj.hasNext()
 */