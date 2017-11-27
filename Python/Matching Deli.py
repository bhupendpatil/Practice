from Properties import Stack

def par_checker(symbol_string):
    s = Stack()
    balanced = True
    index = 0
    while index < len(symbol_string) and balanced:
        symbol = symbol_string[index]
        if symbol in '([{':
            s.push(symbol)
        else:
            if s.is_empty():
                balanced = False
            else:
                top = s.pop()
                if not matches(top,symbol):
                    balanced = False
        index = index + 1

    if balanced and s.is_empty():
        return True
    else:
        return False

def matches(o,c):
    opens="([{"
    closes=")]}"
    return opens.index(o)==closes.index(c)

print(par_checker('([{{{}}}])'))
print(par_checker("(()())[)"))
