import sys
input = sys.stdin.readline

n, m = map(int, input().split())
grid = [
    list(map(int, input().split())) for _ in range(n)
]
cctvs = []
for i in range(n):
    for j in range(m):
        if grid[i][j]>0 and grid[i][j] != 6:
            cctvs.append((grid[i][j], i, j)) ## cctvs 배열에 전체 cctv의 값, 위치 넣음

temp_cctv = [] # cctv의 모든 방향을 잡아줄 리스트
cnt = sys.maxsize # 반환할 정답

def to_top(x, y, ms): # 위치와 grid 받음
    for i in range(x, -1, -1):
        if ms[i][y] == 6:
            return
        if ms[i][y] == 0:
            ms[i][y] = -1
    return

def to_bottom(x, y, ms):
    for i in range(x, n, 1):
        if ms[i][y] == 6:
            return
        if ms[i][y] == 0:
            ms[i][y] = -1
    return


def to_left(x, y, ms):
    for j in range(y, -1, -1):
        if ms[x][j] == 6:
            return
        if ms[x][j] == 0:
            ms[x][j] = -1
    return

def to_right(x, y, ms):
    for j in range(y, m, 1):
        if ms[x][j] == 6:
            return
        if ms[x][j] == 0:
            ms[x][j] = -1
    return

def dfs(n): # dfs로 캠 넣어주기.
    global temp_cctv
    if n == len(cctvs):
        # 방향 잡아주고 1이면 상, 2이면 우, 3이면 하, 4이면 좌
        count_cam(make_direction()) # 캠 갯수 세주고
        return
    for i in range(1, 5):
        temp_cctv.append(i)
        dfs(n+1)
        temp_cctv.pop()
    

def count_cam(map): # 캠 갯수 세기
    global cnt
    temp_cnt = 0
    for i in range(n):
        for j in range(m):
            if map[i][j] == 0:
                temp_cnt += 1
    cnt = min(cnt, temp_cnt)
    return

def make_direction(): #방향 잡아서 
    temp_grid = [arr[:] for arr in grid]

    for i in range(len(cctvs)):
        v, x, y = cctvs[i]
        if v == 1:
            if temp_cctv[i] == 1:
                to_top(x, y, temp_grid)
            elif temp_cctv[i] == 2:
                to_right(x, y, temp_grid)        
            elif temp_cctv[i] == 3:
                to_bottom(x, y, temp_grid)        
            elif temp_cctv[i] == 4:
                to_left(x, y, temp_grid)                
            
        elif v==2:
            if temp_cctv[i] == 1:
                to_top(x, y, temp_grid)
                to_bottom(x, y, temp_grid)
            elif temp_cctv[i] == 2:
                to_left(x, y, temp_grid) 
                to_right(x, y, temp_grid) 
            elif temp_cctv[i] == 3:
                to_top(x, y, temp_grid)
                to_bottom(x, y, temp_grid)
            elif temp_cctv[i] == 4:
                to_left(x, y, temp_grid) 
                to_right(x, y, temp_grid) 
            
        elif v==3:
            if temp_cctv[i] == 1:
                to_top(x, y, temp_grid)
                to_right(x, y, temp_grid) 

            elif temp_cctv[i] == 2:
                to_right(x, y, temp_grid)      
                to_bottom(x, y, temp_grid) 

            elif temp_cctv[i] == 3:
                to_bottom(x, y, temp_grid) 
                to_left(x, y, temp_grid)

            elif temp_cctv[i] == 4:
                to_left(x, y, temp_grid)   
                to_top(x, y, temp_grid)             
            
        elif v==4:
            if temp_cctv[i] == 1:
                to_top(x, y, temp_grid)
                to_right(x, y, temp_grid)  
                to_bottom(x, y, temp_grid) 

            elif temp_cctv[i] == 2:
                to_right(x, y, temp_grid)      
                to_bottom(x, y, temp_grid)  
                to_left(x, y, temp_grid) 

            elif temp_cctv[i] == 3:
                to_bottom(x, y, temp_grid) 
                to_left(x, y, temp_grid)
                to_top(x, y, temp_grid) 

            elif temp_cctv[i] == 4:
                to_left(x, y, temp_grid)   
                to_top(x, y, temp_grid) 
                to_right(x, y, temp_grid)  
            
        elif v==5:
            to_top(x, y, temp_grid)
            to_right(x, y, temp_grid)  
            to_bottom(x, y, temp_grid)  
            to_left(x, y, temp_grid)
    
    return temp_grid
dfs(0)

print(cnt)