from collections import deque

dy = [-1, 1, 0, 0]
dx = [0, 0, -1, 1]

def bfs(sy, sx, arr, row, col):
    queue = deque()
    queue.append((sy, sx))

    distance = [[-1] * col for _ in range(row)]
    visited = [[False] * col for _ in range(row)]

    visited[sy][sx] = True
    distance[sy][sx] = 0
    max_distance = 0

    while queue:
        y, x = queue.popleft()

        for d in range(4):
            ny = y + dy[d]
            nx = x + dx[d]

            if 0 <= ny < row and 0 <= nx < col and not visited[ny][nx] and arr[ny][nx] == 1:
                visited[ny][nx] = True
                queue.append((ny, nx))
                distance[ny][nx] = distance[y][x] + 1
                if distance[ny][nx] > max_distance:
                    max_distance = distance[ny][nx]

    return max_distance

def solve():
    row, col = map(int, input().split())

    arr = []
    for _ in range(row):
        line = input().rstrip()
        arr.append([1 if ch == 'L' else 0 for ch in line])

    max_dist = 0

    for i in range(row):
        for j in range(col):
            if arr[i][j] == 1:
                dist = bfs(i, j, arr, row, col)
                if max_dist < dist:
                    max_dist = dist

    print(max_dist)

solve()
