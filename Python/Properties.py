#Stack
class Stack:
    def __init__(self):
        self.items = []
    def push(self,item):
        self.items.insert(0,item)
    def pop(self):
        return self.items.pop(0)
    def is_empty(self):
        return self.items == []
    def peek(self):
        return self.items[0]

#Queue
class Queue:
    def __init__(self):
        self.items = []
    def is_empty(self):
        return self.items == []
    def enqueue(self, item):
        self.item.insert(0,item)
    def dequeue(self):
        return self.items.pop()
    def size(self):
        return len(self.items)

#Node
class Node:
    def __init__(self, data, next=None):
        self.data = data
        self.next = next
    def __str__(self):
        return str(self.data)
