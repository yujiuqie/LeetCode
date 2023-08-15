/**
 * @param {string} s
 * @param {number[]} indices
 * @param {string[]} sources
 * @param {string[]} targets
 * @return {string}
 */
var findReplaceString = function(s, indices, sources, targets) {
    const n = s.length;
    const m = indices.length;

    const map = new Map();
    for(let i = 0; i < m; i++){
        map.set(indices[i],i);
    }

    let ans = "";
    for(let i = 0; i < n;){
        let succeed = false;
        if(map.has(i)){
            let pt = map.get(i);
            if(s.startsWith(sources[pt],i)){
                succeed = true;
                ans += targets[pt];
                i += sources[pt].length;
            }
        }
        if(!succeed){
            ans += s[i];
            ++i;
        }
    }

    return ans;
};