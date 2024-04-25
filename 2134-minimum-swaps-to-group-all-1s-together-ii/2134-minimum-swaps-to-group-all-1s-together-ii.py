import heapq

class Solution:
    def minSwaps(self, nums: List[int]) -> int:
        # 아이디어
        # 1. 1의 개수를 센 뒤 그 길이의 슬라이딩 윈도우를 생성
        # 2. 주어진 배열을 1번 더 반복해서 붙인 뒤 슬라이딩 윈도우를 가져다 댐
        # 3. 슬라이딩 윈도우를 밀면서 0의 개수를 세고, 그 중 최소값을 반환

        oneCnt = sum(nums)
        numsDouble = nums * 2
        zeroCntInWindow = sum([1 if i == 0 else 0 for i in nums[:oneCnt]])
        result = zeroCntInWindow

        for i in range(1, len(numsDouble) - oneCnt + 1):
            zeroCntInWindow -= 1 if numsDouble[i - 1] == 0 else 0
            zeroCntInWindow += 1 if numsDouble[i + oneCnt - 1] == 0 else 0
            result = min(result, zeroCntInWindow)
        
        return result

