N  = int(input())

arr = [[i for i in range(1,N+1)] for _ in range(2)]

for i in range(N):
    arr[1][i] = int(input())

ans = [0] * (N+1)

for i in range(N):
    now = arr[0][i]
    visit = [1] * (N+1)
    while visit[now]:
        visit[now] = 0
        now = arr[1][now-1]
    if i + 1 == now:
        ans[now] = 1
        now =arr[1][i]
        while arr[0][i] != now:
            ans[now] = 1
            now = arr[1][now-1]

    
print(sum(ans))
for i in range(N+1):
    if ans[i] > 0:
        print(i)
