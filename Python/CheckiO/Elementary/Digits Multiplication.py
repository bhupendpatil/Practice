"""
You are given a positive integer. Your function should calculate the product of the digits excluding any zeroes.

For example: The number given is 123405. The result will be 1*2*3*4*5=120 (don't forget to exclude zeroes).

Input: A positive integer.

Output: The product of the digits as an integer.

Example:

checkio(123405) == 120
checkio(999) == 729
checkio(1000) == 1
checkio(1111) == 1
    
1
2
3
4
5
How it is used: This task can teach you how to solve a problem with simple data type conversion.

Precondition: 0 < number < 106
"""

def checkio(number):
    a = str(number)
    b = []
    for i in a:
        if i=="0":
            pass
        else:
            b.append(i)

    c = list(map(int,b))

    d = 1
    for s in c:
        d*=s
    return d

#These "asserts" using only for self-checking and not necessary for auto-testing
if __name__ == '__main__':
    assert checkio(123405) == 120
    assert checkio(999) == 729
    assert checkio(1000) == 1
    assert checkio(1111) == 1
