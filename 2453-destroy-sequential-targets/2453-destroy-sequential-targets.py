class Solution:
    def destroyTargets(self, nums: List[int], space: int) -> int:
        # 각 nums를 각각 나머지 해준다. 이 때 나머지가 같은 애들은 전부 함께 묶일 수 있으며, 그 중 가장 작은 애가 항상 최적 값이 된다
        
        modMap = {}

        for num in nums:
            modNum = num % space
            if modNum not in modMap:
                modMap[modNum] = [10**9 + 1, 0]
            modMap[modNum] = [min(modMap[modNum][0], num), modMap[modNum][1] + 1]
        
        result = 0
        maxDestroy = 0

        for idx in modMap:
            canDestroyCnt = modMap[idx][1]
            if canDestroyCnt > maxDestroy or (canDestroyCnt == maxDestroy and result > modMap[idx][0]):
                result, maxDestroy = modMap[idx]

        return result
        