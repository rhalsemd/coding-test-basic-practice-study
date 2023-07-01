import sys
input = sys.stdin.readline

def dfs(num, parent):
    parent[num] = -2
    for i in range(len(parent)):
        if parent[i] == num:
            dfs(i, parent)

num = int(input())
parent = list(map(int, input().split()))
delete = int(input())

dfs(delete, parent)
count = 0
for j in range(len(parent)):
    if parent[j] != -2 and j not in parent:
        count += 1
print(count) 