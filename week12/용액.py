import sys

input = sys.stdin.readline
n = int(input())

things = list(map(int, input().split()))

left, right = 0, n-1
start, end = things[0], things[-1]
ans = abs(start+end)
ans_left = left
ans_right = right

while left < right:
    temp = things[left] + things[right]

    if abs(temp) <= ans:
        ans_left = left
        ans_right = right
        ans = abs(temp)

        if ans == 0:
            break
    if temp < 0:
        left += 1
    
    else:
        right -= 1

print(things[ans_left], things[ans_right])
