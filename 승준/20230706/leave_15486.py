import sys
input = sys.stdin.readline

n = int(input())
t, p = [0] * (n+2), [0] * (n+2)
dp = [0] * (n+2)
for i in range(1, n+1):
    t[i], p[i] = map(int, input().split())

for i in range(1, n+1):
    if(i+t[i] <= n+1):
        dp[i+t[i]] = max(dp[i+t[i]], dp[i] + p[i])
    dp[i+1] = max(dp[i+1], dp[i])
    
print(max(dp))
