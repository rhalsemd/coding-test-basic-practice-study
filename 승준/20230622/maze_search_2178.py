
from collections import deque

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def solveMaze(n, m, maze):
    dist = [[-1] * m for _ in range(n)]
    dist[0][0] = 1
    
    queue = deque()
    queue.append((0, 0))
    
    while queue:
        y, x = queue.popleft()
        
        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]
            
            if 0 <= ny < n and 0 <= nx < m and maze[ny][nx] == 1 and dist[ny][nx] == -1:
                queue.append((ny, nx))
                dist[ny][nx] = dist[y][x] + 1
                
    return dist[n - 1][m - 1]

n, m = map(int, input().split())

maze = []
for _ in range(n):
    line = list(map(int, input().strip()))
    maze.append(line)
    
result = solveMaze(n, m, maze)
print(result)