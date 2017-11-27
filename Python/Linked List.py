from Properties import Node

class LinkedList:
    def __init__(self):
        self.head = None
        self.size = 0
    def isEmpty(self):
        return not self.head
    def append(self, data):
        if not self.head:
            n = Node(data)
            self.head = n
            return
        else:
            n = self.head
            while n.next != None:
                n = n.next
            new_node = Node(data)
            n.next = new_node
            return

    def addFirst(self,e):
        newest = Node(e)
        newest.next = self.head
        self.head = newest
        self.size = self.size + 1

    def removeFirst(self):
        print("Remove First Item: ")
        if self.head is None:
            print("List is Empty")
        self.head = self.head.next
        self.size = self.size - 1

    def removeLast(self):
        print("Remove Last Item: ")
        n = self.head
        while n.next != None:
            temp = n
            n = n.next
        temp.next = None
        self.size = self.size - 1

    def printList(self):
        n = self.head
        while n:
            print("Current Node is: ",str(n))
            n = n.next

a = LinkedList()
a.append(10)
a.addFirst(30)
a.addFirst(90)
a.append(60)
a.printList()
a.removeFirst()
a.printList()
a.removeLast()
a.printList()
