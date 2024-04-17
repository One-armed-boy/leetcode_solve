class AuthenticationManager {
    private int ttlSeconds;
    private HashMap<String, Integer> tokenStore;

    public AuthenticationManager(int timeToLive) {
        this.ttlSeconds = timeToLive;
        this.tokenStore = new HashMap<>();
    }
    
    public void generate(String tokenId, int currentTime) {
        tokenStore.put(tokenId, currentTime + ttlSeconds);
    }
    
    public void renew(String tokenId, int currentTime) {
        if (!tokenStore.containsKey(tokenId) || isExpired(tokenId, currentTime)) {
            return;
        }
        tokenStore.replace(tokenId, currentTime + ttlSeconds);
    }
    
    public int countUnexpiredTokens(int currentTime) {
        var cnt = 0;
        for (var tokenId: tokenStore.keySet()) {
            cnt += isExpired(tokenId, currentTime) ? 0 : 1;
        }
        return cnt;
    }

    private boolean isExpired(String tokenId, int currentTime) {
        return tokenStore.get(tokenId) <= currentTime;
    }
}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */