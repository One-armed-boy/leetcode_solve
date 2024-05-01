class Solution:
    def strWithout3a3b(self, a: int, b: int) -> str:
        result = ""

        while a > 0 or b > 0:
            if len(result) >= 2 and (result[-2:] == "aa" or result[-2:] == "bb"):
                if result[-2:] == "aa":
                    result += "b"
                    b -= 1
                else:
                    result += "a"
                    a -= 1
            else:
                if a >= b:
                    if a - 2 >= b:
                        result += "aa"
                        a -= 2
                    else:
                        result += "a"
                        a -= 1
                else:
                    if b - 2 >= a:
                        result += "bb"
                        b -= 2
                    else:
                        result += "b"
                        b -= 1

        return result