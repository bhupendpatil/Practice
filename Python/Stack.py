class Stack:
    def __init__(self):
        self.items = []
    def is_empty(self):
        return self.items == []
    def push(self,item):
        return self.items.insert(0,item)
    def pop(self):
        return self.items.pop()
    def size(self):
        return len(self.items)

s = Stack()
s.push('hello')
s.push('true')
while not s.is_empty():
    print('Stack Elements are :- {}'.format(s.pop()))
