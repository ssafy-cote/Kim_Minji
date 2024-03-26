import heapq

def solution(scoville, K):
    answer = 0

    pq = []
    for elem in scoville:
        heapq.heappush(pq, elem)
    
    while pq:
        a = heapq.heappop(pq)
        if a>=K:
            break
        if pq:
            b = heapq.heappop(pq)
            new = a + b*2
            heapq.heappush(pq, new)
            answer += 1
        else:
            return -1
    return answer
