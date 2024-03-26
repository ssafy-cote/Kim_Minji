import sys
from collections import Counter

n, m = map(int, input().split())

list = [
    sys.stdin.readline().rstrip() for  _ in range(n)
]
counter_list = Counter(list)
set_list = set(list)
result = []

for elem in set_list:
    if len(elem)<m: #길이제한
        continue
    result.append([elem])

for elem in result:
    cur = elem[0]
    elem.append(counter_list[cur]) # 빈도수
    elem.append(len(cur)) #길이순

result.sort(key = lambda x:(-x[1], -x[2], x[0]))
for elem in result:
    print(elem[0])

## 자주 나오는 단어일수록 앞에 배치
## 단어 길이가 길수록 앞에
## 알파벳 사전 순으로 앞에있느 단어일수록 앞에 배치

# list.sorted(key = lambda x: ())
