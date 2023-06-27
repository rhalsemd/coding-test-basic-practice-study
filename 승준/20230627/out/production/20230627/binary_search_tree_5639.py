def get_postorder(preorder):
    if len(preorder) <= 1:
        return preorder

    stack = []
    postorder = []
    stack.append((preorder, False))

    while stack:
        nodes, visited = stack.pop()
        
        if visited:
            postorder.append(nodes[0])
        else:
            root = nodes[0]
            left = [node for node in nodes[1:] if node < root]
            right = [node for node in nodes[1:] if node > root]
            
            stack.append((nodes, True))
            if right:
                stack.append((right, False))
            if left:
                stack.append((left, False))
    
    return postorder 

# 전위 순회
preorder= []
while True:
    try:
        node = int(input())
        preorder.append(node)
    except:
        break
    
postorder = get_postorder(preorder)
for n in postorder:
    print(n)