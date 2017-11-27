"""
For language training our Robots want to learn about suffixes.

In this task, you are given a set of words in lower case. Check whether there is a pair of words, such that one word is the end of another (a suffix of another). For example: {"hi", "hello", "lo"} -- "lo" is the end of "hello", so the result is True.

Input: Words as a set of strings.

Output: True or False, as a boolean.

Example:

checkio({"hello", "lo", "he"}) == True
checkio({"hello", "la", "hellow", "cow"}) == False
checkio({"walk", "duckwalk"}) == True
checkio({"one"}) == False
checkio({"helicopter", "li", "he"}) == False
    
1
2
3
4
5
6
How it is used: Here you can learn about iterating through set type and string data type functions.

Precondition: 2 ≤ len(words) < 30
all(re.match(r"\A[a-z]{1,99}\Z", w) for w in words)
"""

def checkio(words_set):
    b = words_set
    c = []
    for i in words_set:
        for t in b:
            if t.endswith(i):
                c.append(t)
    if len(c)>len(words_set):
        return True
    else:
        return False

#These "asserts" using only for self-checking and not necessary for auto-testing
if __name__ == '__main__':
    assert checkio({"hello", "lo", "he"}) == True, "helLO"
    assert checkio({"hello", "la", "hellow", "cow"}) == False, "hellow la cow"
    assert checkio({"walk", "duckwalk"}) == True, "duck to walk"
    assert checkio({"one"}) == False, "Only One"
    assert checkio({"helicopter", "li", "he"}) == False, "Only end"
