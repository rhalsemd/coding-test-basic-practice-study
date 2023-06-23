from collections import deque

v = int(input())
w = int(input())
graph = [[] for _ in range(v + 1)]
visited = [False] * (v + 1)

for _ in range(w):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

start = 1
queue = deque()
queue.append(start)
visited[start] = True
count = 0

while queue:
    node = queue.popleft()

    for next_node in graph[node]:
        if not visited[next_node]:
            count += 1
            queue.append(next_node)
            visited[next_node] = True

print(count)