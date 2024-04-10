class Solution:
    def countVowelPermutation(self, n: int) -> int:
        mod = 10 ** 9 + 7
        mapp = {
            "a": 1,
            "e": 1,
            "i": 1,
            "o": 1,
            "u": 1
        }

        for i in range(n - 1):
            a = self.modSum([mapp["e"], mapp["i"], mapp["u"]], mod)
            e = self.modSum([mapp["a"], mapp["i"]], mod)
            i = self.modSum([mapp["e"], mapp["o"]], mod)
            o = self.modSum([mapp["i"]], mod)
            u = self.modSum([mapp["i"], mapp["o"]], mod)

            mapp["a"] = a
            mapp["e"] = e
            mapp["i"] = i
            mapp["o"] = o
            mapp["u"] = u

        result = self.modSum([mapp["a"], mapp["e"], mapp["i"], mapp["o"], mapp["u"]], mod)

        return result
    
    def modSum(self, nums, mod):
        result = 0
        for num in nums:
            result = (result + num) % mod
        return result