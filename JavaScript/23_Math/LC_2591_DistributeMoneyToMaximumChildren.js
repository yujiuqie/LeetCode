/**
 * @param {number} money
 * @param {number} children
 * @return {number}
 */
var distMoney = function(money, children) {
    if(money < children) return-1;
    if(money > children*8) return children-1;//每个人都分8，有剩余全部给一个人 
    if(money === (children*8-4)) return children-2;//n-1分8，正好剩下4，要调整2个人
    return Math.floor((money-children)/7);
 };