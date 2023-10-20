class Solution {
    func categorizeBox(_ length: Int, _ width: Int, _ height: Int, _ mass: Int) -> String {
        let maxd = max(length, max(width, height))
        let vol = Int64(length * width * height)
        let isBulky = maxd >= 10000 || vol >= 1000000000
        let isHeavy = mass >= 100
        
        if isBulky && isHeavy {
            return "Both"
        } else if isBulky {
            return "Bulky"
        } else if isHeavy {
            return "Heavy"
        } else {
            return "Neither"
        }
    }
}