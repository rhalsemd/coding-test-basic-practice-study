def dfs(graph, visited, start, current):
    visited[current] = True
    next = graph[current]
    
    if not visited[next]:
        dfs(graph, visited, start, next)
    elif start == next:
        result.append(start)

n = int(input())
numbers = [0]
for i in range(n):
    numbers.append(int(input()))
    
result = []    
for j in range(1, n+1):
    visited= [False] * (n+1)
    dfs(numbers, visited, j, j)
    
result.sort()
print(len(result))
for ans in result:
    print(ans)