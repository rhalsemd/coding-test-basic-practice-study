import sys
input = sys.stdin.readline

n = int(input())
solution = list(map(int, input().split()))
solution.sort()

left = 0
right = n - 1
diff = abs(solution[left] + solution[right])
diff_match = [solution[left], solution[right]]

while left < right:
    sum_val = solution[left] + solution[right]
    if abs(sum_val) < diff:
        diff = abs(sum_val)
        diff_match = [solution[left], solution[right]]
    
    if sum_val < 0:
        left += 1
    else:
        right -= 1
        
print(diff_match[0], diff_match[1])