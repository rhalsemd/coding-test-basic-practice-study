A, B = map(int, input().split())
res = A*B

while B:
    if A > B:
        A, B = B, A
    B %= A

print(res//A)