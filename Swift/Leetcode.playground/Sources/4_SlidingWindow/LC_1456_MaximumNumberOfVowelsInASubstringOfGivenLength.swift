class Solution {
    func maxVowels(_ s: String, _ k: Int) -> Int {
        let n : Int = s.count
        var vowel_count : Int = 0
        var stringArray = Array(s)

        for i in 0..<k {
            vowel_count += isVowel(stringArray[i])
        }

        var ans : Int = vowel_count
        for i in k..<n {
            vowel_count += isVowel(stringArray[i]) - isVowel(stringArray[i - k])
            ans = max(ans,vowel_count)
        }

        return ans
    }

    func isVowel(_ ch : Character) -> Int
    {
        return ch == "a" || ch == "e" || ch == "i" || ch == "o" || ch == "u" ? 1 : 0
    }
}