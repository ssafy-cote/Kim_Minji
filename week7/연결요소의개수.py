import sys
from collections import deque

def bfs(grid, start, visited):
  q = deque([start])
  visited[start] = True
  while q:
    v = q.popleft()
    for i in grid[v]:
      if not visited[i]:
        q.append(i)
        visited[i] = True

n, m = map(int, sys.stdin.readline().split())

grid = [
  [] for _ in range(n)
]

for _ in range(m):
  u, v = map(int, sys.stdin.readline().split())
  grid[u-1].append(v-1)
  grid[v-1].append(u-1)

cnt = 0
visited = [False] * n

for i in range(n):
  if not visited[i]:
    bfs(grid, i, visited)
    cnt += 1

print(cnt)