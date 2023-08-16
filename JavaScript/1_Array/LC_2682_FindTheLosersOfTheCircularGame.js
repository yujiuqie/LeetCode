/**
 * @param {number} n
 * @param {number} k
 * @return {number[]}
 */
var circularGameLosers = function (n, k) {
    var visited = []
    var index = 0;
    var jump = k;
    while (!visited[index]) {
        visited[index] = true;
        index = (index + jump) % n;
        jump = jump + k;
    }

    var res = [];
    var j = 0;

    for (i = 0; i < n; i++) {
        if (!visited[i]) {
            res[j++] = i + 1;
        }
    }

    return res;
};