from collections import deque

n = int(input())
queue = deque()
queue.append((1, 0))
visited = dict()
visited[(1, 0)] = 0

while queue:
    now, clip = queue.popleft()
    if now >= 0:
        if now == n:
            print(visited[(now, clip)])
            break
        if (now, now) not in visited.keys():
            visited[(now, now)] = visited[(now, clip)] + 1
            queue.append((now, now))
        if (now + clip, clip) not in visited.keys():
            visited[(now + clip, clip)] = visited[(now, clip)] + 1
            queue.append((now + clip, clip))
        if (now - 1, clip) not in visited.keys():
            visited[(now - 1, clip)] = visited[(now, clip)] + 1
            queue.append((now - 1, clip))
