from collections import deque

def bfs(graph, number, sy, sx):
    global n, count
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]
    
    queue = deque()
    queue.append((sy, sx))
    
    while (queue):
        y, x = queue.popleft()
        graph[y][x] = number
        count += 1
        
        for d in range(4):
            ny = y + dy[d]
            nx = x + dx[d]
            if ( 0 <= ny < n and 0 <= nx < n and graph[ny][nx] == 1):
                queue.append((ny, nx))
                graph[ny][nx] = number
                
    return count

n = int(input())
graph = []
number = 1
count_lst = []
count = 0

for _ in range(n):
    graph.append(list(map(int, input())))
    
for i in range(n):
    for j in range(n):
        if graph[i][j] == 1:
            number += 1
            count_lst.append(bfs(graph, number, i, j))
        count = 0

print(number-1)
count_lst.sort()
for _ in range(len(count_lst)): print(count_lst[_])

    


    