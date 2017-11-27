"""
Feed Pigeons

I start to feed one of the pigeons. A minute later two more fly by and a
minute after that another 3. Then 4, and so on (Ex: 1+2+3+4+...). One portion
of food lasts a pigeon for a minute, but in case there's not enough food for
all the birds, the pigeons who arrived first ate first. Pigeons are hungry
animals and eat without knowing when to stop. If I have N portions of bird
feed, how many pigeons will be fed with at least one portion of wheat?

pigeons

Input: A quantity of portions wheat as a positive integer.

Output: The number of fed pigeons as an integer.

Example:

checkio(1) == 1
checkio(2) == 1
checkio(5) == 3
checkio(10) == 6
    
1
2
3
4
5
How it is used: This task illustrates how we can model various situations.
Of course, the model has a limited approximation, but often-times we don't
need a perfect model.

Precondition: 0 < N < 105.
"""

def checkio(number):
    a = 1
    b = 1
    while number >= b:
        number -= b
        a += 1
        b += a
        
    return max(b - a, number)

if __name__ == '__main__':
    #These "asserts" using only for self-checking and not necessary for auto-testing
    assert checkio(1) == 1, "1st example"
    assert checkio(2) == 1, "2nd example"
    assert checkio(5) == 3, "3rd example"
    assert checkio(10) == 6, "4th example"
