class Solution:
    def discountPrices(self, sentence: str, discount: int) -> str:
        words = sentence.split(' ')
        return ' '.join([self.applyDiscount(word, discount) for word in words])
    
    def applyDiscount(self, word, discount):
        if not word[0] == "$":
            return word
        num = 0
        try:
            num = int(word[1:])
        except:
            return word
        discounted = num * (1 - discount / 100)
        return "$" + f'{discounted:.2f}'