import sys
input = sys.stdin.readline

N = int(input())
buildings = [int(input()) for _ in range(N)]

stack = []
count = 0

for b in buildings:
    while stack and stack[-1] <= b:
        stack.pop()
    stack.append(b)
    
    count += len(stack) - 1
    
print(count)