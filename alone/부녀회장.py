t = int(input())

for _ in range(t):
    k = int(input())
    n = int(input())

    dp = [
        [0]*n for _ in range(k+1)
    ]
    # 초기 값 설정 (0층)
    for i in range(1, len(dp[0])+1):
        dp[0][i-1] = i
    
    for i in range(1, k+1):
        dp[i][0] = 1

    for i in range(1, k+1):
        for j in range(1, n):
            dp[i][j] = dp[i-1][j] + dp[i][j-1]

    print(dp[k][n-1])