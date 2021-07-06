from math import factorial
r, p = map(float, input().split())
def comb(n, r):
	return factorial(n) / (factorial(r) * factorial(n - r))
print(round(sum([comb(p, i) * (r / 100)**i * ((100 - r) / 100)**(p - i)  for i in range(0, 3)]), 3))
print(round(sum([comb(p, i) * (r / 100)**i * ((100 - r) / 100)**(p - i)  for i in range(2, 11)]), 3))