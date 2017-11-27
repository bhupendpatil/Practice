"""
For the Robots the decimal format is inconvenient. If they need to count to "1", their computer brains want to count it in the binary representation of that number. You can read more about binary here.

You are given a number (a positive integer). You should convert it to the binary format and count how many unities (1) are in the number spelling. For example: 5 = 0b101 contains two unities, so the answer is 2.

Input: A number as a positive integer.

Output: The quantity of unities in the binary form as an integer.

Example:

checkio(4) == 1
checkio(15) == 4
checkio(1) == 1
checkio(1022) == 9
    
1
2
3
4
5
How it is used: How to convert a number to the binary form. It can be useful for Computer Science purposes.

Precondition: 0 < number ≤ 232
"""

def checkio(number):
    a = str(bin(number))
    b = []
    for i in a:
        if i=="1":
            b.append(i)
    return len(b)

#These "asserts" using only for self-checking and not necessary for auto-testing
if __name__ == '__main__':
    assert checkio(4) == 1
    assert checkio(15) == 4
    assert checkio(1) == 1
    assert checkio(1022) == 9
