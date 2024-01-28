import sys
input = sys.stdin.readline

dxs, dys = [0, -1, -1, 0, 1, 1, 1, 0, -1], [0, 0, -1, -1, -1, 0, 1, 1, 1] # 위부터 반시계 방향으로 45도씩

# 열 기준 홀수번째는 방향을 의미 (근데 -1 해줘야함 !)
grid = [
    list(map(int, input().split())) for _ in range(4)
]

# 물고기와 방향 grid를 따로 나눠줌
fish_grid = []
dir_grid = []

for i in range(4):
    f_temp = []
    d_temp = []
    for j in range(len(grid[0])):
        if j%2 == 0:
            f_temp.append(grid[i][j])
        else:
            d_temp.append(grid[i][j])
    fish_grid.append(f_temp)
    dir_grid.append(d_temp)
for elem in dir_grid:
    print(*elem)  
cx, cy = 0, 0 #상어의 현재위치

result = grid[0][0]
grid[0][0] = -1 # 상어가 있을 때는 -1
fish_grid[0][0] = -1 # 상어가 있을 때는 -1
# 이동할 수 있는 칸은 빈칸, 다른 물고기가 있는 칸
# 이동할 수 없는 칸은 상어가 있건, 공간의 경계를 넘는 칸
def in_range(x, y):
    return 0<=x<4 and 0<=y<4

# 상어가 움직일 수 있는지
def shark_can_move():
    # True, False 반환
    return

# 상어 움직이기
def shark_move():
    return

def swap_pos(i, j, nx, ny):
  global dir_grid, fish_grid
  dir_grid[nx][ny], dir_grid[i][j] = dir_grid[i][j], dir_grid[nx][ny]
  fish_grid[nx][ny], fish_grid[i][j] = fish_grid[i][j], fish_grid[nx][ny]

# 물고기들 움직이기
def fishes_move():
    order = 1
    flag = False
    while(order < 17):
      for i in range(4):
        for j in range(4):
          if fish_grid[i][j] == order:
            now_dir = dir_grid[i][j]
            for _ in range(1, 9):
              dx, dy = dxs[now_dir], dys[now_dir]
              nx, ny = i+dx, j+dy
              if in_range(nx, ny) and (nx!=cx or ny!=cy):
                swap_pos(i, j, nx, ny)
                flag = True
                break
              else:
                now_dir+=1
                if now_dir == 9:
                  now_dir = 1
              print(now_dir)
            if flag:
              break
        if flag:
            break
      order+=1
      flag=False
      if order == 17:
        break
    return
fishes_move()
for elem in fish_grid:
    print(*elem)  
    print()