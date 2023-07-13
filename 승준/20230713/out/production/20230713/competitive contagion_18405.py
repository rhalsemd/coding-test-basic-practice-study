def bfs(blocks, visited, queue, S, N, X, Y):
    dy = [-1, 1, 0, 0]
    dx = [0, 0, -1, 1]
    
    while queue:
        value, y, x, sec = queue.pop(0)
        
        if sec == S: 
            break
        
        for d in range(4):
            ny = dy[d] + y
            nx = dx[d] + x
            if 0 <= ny < N and 0 <= nx < N and not visited[ny][nx] and blocks[ny][nx] == 0:
                blocks[ny][nx] = value
                visited[ny][nx] = True
                queue.append((value, ny, nx, sec+1))
    
    return blocks[X-1][Y-1]
        
N, K = map(int, input().split())
blocks = [list(map(int, input().split())) for _ in range(N)]
S, X, Y = map(int, input().split())
visited = [[False] * N for _ in range(N)]

queue = []
for i in range(N):
    for j in range(N):
        if blocks[i][j] != 0:
            queue.append((blocks[i][j], i, j, 0))
            visited[i][j] = True
            
queue.sort()
result = bfs(blocks, visited, queue, S, N, X, Y)
print(result)