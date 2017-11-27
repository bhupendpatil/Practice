"""
You are given a chunk of text. Gather all capital letters in one word in the order that they appear in the text.

For example: text = "How are you? Eh, ok. Low or Lower? Ohhh.", if we collect all of the capital letters, we get the message "HELLO".

Input: A text as a string (unicode).

Output: The secret message as a string or an empty string.

Example:

find_message("How are you? Eh, ok. Low or Lower? Ohhh.") == "HELLO"
find_message("hello world!") == ""
    
1
2
3
How it is used: This is a simple exercise in working with strings: iterate, recognize and concatenate.

Precondition: 0 < len(text) ≤ 1000
all(ch in string.printable for ch in text)
"""


def find_message(text):
    """Find a secret message"""
    a = "".join(i for i in text if i == i.upper()and i.isalpha())
    return a

if __name__ == '__main__':
    #These "asserts" using only for self-checking and not necessary for auto-testing
    assert find_message("How are you? Eh, ok. Low or Lower? Ohhh.") == "HELLO", "hello"
    assert find_message("hello world!") == "", "Nothing"
    assert find_message("HELLO WORLD!!!") == "HELLOWORLD", "Capitals"
