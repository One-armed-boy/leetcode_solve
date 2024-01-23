class RangeFreqQuery {
    int[] arr;
    HashMap<String, Integer> cache; 
    public RangeFreqQuery(int[] arr) {
        this.arr = arr;
        this.cache = new HashMap<>();
    }
    
    public int query(int left, int right, int value) {
        String key = left + ":" + right + ":" + value;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        int result = 0;
        for (int idx = left; idx < right + 1; idx++) {
            if (arr[idx] != value) {
                continue;
            }
            result+=1;
        }
        cache.put(key, result);
        return cache.get(key);
    }
}

/**
 * Your RangeFreqQuery object will be instantiated and called as such:
 * RangeFreqQuery obj = new RangeFreqQuery(arr);
 * int param_1 = obj.query(left,right,value);
 */