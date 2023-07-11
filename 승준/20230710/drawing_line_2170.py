import sys
input = sys.stdin.readline

n = int(input())
        
lines = []

for _ in range(n):
    x, y = map(int, input().split())
    lines.append((x, y))
lines.sort()

total_length = 0
start = lines[0][0]
end = lines[0][1]

for i in range(1, n):
    if lines[i][0] > end:
        total_length += end - start
        start = lines[i][0]
        end = lines[i][1]
    else:
        end = max(end, lines[i][1])
        
total_length += end - start
print(total_length)