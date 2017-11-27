from Properties import Stack

def reverse():
    a = input("Enter word or words you want to reverse: ")
    s = Stack()
    b = ""
    
    for i in a:
        s.push(i)

    while not s.is_empty():
        c = s.pop()
        b = b + c

    print(b)

reverse()

