def get_postorder(preorder):
    if not preorder:
        return []

    root = preorder[0]
    left = []
    right = []
    
    for node in preorder[1:]:
        if node < root:
            left.append(node)
        else:
            right.append(node)
    
    left_postorder = get_postorder(left)
    right_postorder = get_postorder(right)
    
    return left_postorder + right_postorder + [root]


# 전위 순회
preorder= []
while True:
    try:
        node = int(input())
        preorder.append(node)
    except EOFError:
        break
    
postorder = get_postorder(preorder)
for n in postorder:
    print(n)