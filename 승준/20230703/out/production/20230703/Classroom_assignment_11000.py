import heapq

n = int(input())
times = []

for _ in range(n):
    st, en = map(int, input().split())
    times.append((st, en))

times.sort(key=lambda x: x[0])

cnt = 0
end_times = []

for st, en in times:
    if end_times and end_times[0] <= st:
        heapq.heappop(end_times)
    heapq.heappush(end_times, en)
    cnt = max(cnt, len(end_times))

print(cnt)
