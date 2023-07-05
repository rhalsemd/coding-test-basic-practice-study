h, w = map(int, input().split())
blocks = list(map(int, input().split()))

def calculate_rainwater(h, w, blocks):
    total = 0
    for col in range(1, w-1):
        left_max = max(blocks[:col])
        right_max = max(blocks[col+1:])
        
        if blocks[col] < left_max and blocks[col] < right_max:
            total += min(left_max, right_max) - blocks[col]
            
    return total

result = calculate_rainwater(h, w, blocks)
print(result)