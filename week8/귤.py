def solution(k, tangerine):
    a = {}
    for elem in tangerine:
        if elem in a:
            a[elem] += 1
        else:
            a[elem] = 1
    a = dict(sorted(a.items(), key=lambda x: x[1], reverse=True))
    answer = 1

    for i in a:
        k -= a[i]
        if k <= 0:
            return answer
        answer += 1
    
    return answer