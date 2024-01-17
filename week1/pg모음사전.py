from itertools import product

def solution(word):
    answer = -1
    word_list = list()
    words = ['A', 'E', 'I', 'O', 'U']
    
    for i in range(1, 6):
        for j in list(product(words, repeat = i)):
            word_list.append(j)
    word_list.sort()
    for i in range(len(word_list)):
        cand = ''.join(word_list[i])
        if cand == word:
            answer = i+1
            break
    return answer