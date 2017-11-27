from Properties import Stack

def is_mutual_html(raw):
    s = Stack()
    j = raw.find("<")
    while j!= -1:
        k = raw.find(">",j+1)
        if k==-1:
            return False
        tag = raw[j+1:k]
        if not tag.startswith('/'):
            s.push(tag)
        else:
            if s.is_empty():
                return False
            if tag[1:]!=s.pop():
                return False
        j = raw.find("<",k+1)
        
    return s.is_empty()


print(is_mutual_html('<html><body></body></html>'))
