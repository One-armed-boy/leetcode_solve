class Solution {
    public int eatenApples(int[] apples, int[] days) {
        // 못먹는 날 기준 최소 힙
        PriorityQueue<Apple> pQueue = new PriorityQueue<>((a, b) -> a.expiredDate() - b.expiredDate());
        int maxDay = Math.max(apples.length, Arrays.stream(apples).sum());
        int result = 0;
        int day = -1;
        while (day < maxDay) {
            day++;
            if (day < apples.length) {
                addApple(pQueue, day + days[day], apples[day]);
            }
            Apple apple = getEatableFirstApple(pQueue, day);
            if (apple == null) {
                // 최소 힙이 비어있는데 이미 사과 보급이 끝났다면, early break
                if (day >= apples.length) {
                    break;
                }
                continue;
            }

            int appleCnt = apple.cnt();
            int expiredDate = apple.expiredDate();
            result++;

            if (appleCnt - 1 > 0) {
                addApple(pQueue, expiredDate, appleCnt - 1);
            }
        }

        return result;
    }

    private void addApple(PriorityQueue<Apple> pQueue, int expiredDate, int cnt) {
        pQueue.offer(new Apple(expiredDate, cnt));
    }

    private Apple getEatableFirstApple(PriorityQueue<Apple> pQueue, int day) {
        Apple nextApple = null;
        while (!pQueue.isEmpty()) {
            nextApple = pQueue.poll();
            int expiredDate = nextApple.expiredDate();
            if (expiredDate > day) {
                break;
            }
            nextApple = null;
        }
        return nextApple;
    }

    record Apple(int expiredDate, int cnt) {}
}