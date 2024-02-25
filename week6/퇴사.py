n = int(input())
tables = [
    list(map(int, input().split())) for _ in range(n)
]

dp = [0]*(n+1)
if tables[n-1][0] == 1:
    dp[n-1] = tables[n-1][1]
    
for i in range(n-2, -1, -1):
    if i+tables[i][0] > n:
        dp[i] = dp[i+1]
    else:
        dp[i] = max(tables[i][1]+dp[i+tables[i][0]], dp[i+1])


print(max(dp))