n  = int(input())
dp = [0]*n

dp[0] = 1 #1

if n>=2: 
    dp[1] = 2 #00, 11
    for i in range(2, n):
        dp[i] = (dp[i-2] + dp[i-1])%15746
    
print(dp[n-1])

