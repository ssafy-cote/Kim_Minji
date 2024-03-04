def solution(phone_book):
    answer = True
    phone_book.sort()
    
    for i in range(len(phone_book)-1): # 맨 처음부터 그 다음 요소랑 값 비교할거니까 range 안에 들어가는 수는 전체 range에서 하나 빼줘야함.
        if phone_book[i] == phone_book[i+1][:len(phone_book[i])]:
            answer = False
            
    return answer