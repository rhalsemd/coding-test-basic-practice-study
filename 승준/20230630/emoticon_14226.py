from collections import deque

def solve(n):
    dp = [[-1] * (n + 1) for _ in range(n + 1)]
    queue = deque()
    queue.append((1, 0))
    dp[1][0] = 0

    while queue:
        now, clip = queue.popleft()

        if now == n:
            return dp[now][clip]

        if dp[now][now] == -1:
            dp[now][now] = dp[now][clip] + 1
            queue.append((now, now))

        if now + clip <= n and dp[now + clip][clip] == -1:
            dp[now + clip][clip] = dp[now][clip] + 1
            queue.append((now + clip, clip))

        if now - 1 >= 0 and dp[now - 1][clip] == -1:
            dp[now - 1][clip] = dp[now][clip] + 1
            queue.append((now - 1, clip))

n = int(input())
result = solve(n)
print(result)
