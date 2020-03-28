class Shark:
    def swim(self):
        print("Can Swim")
    def bones(self):
        print("soft")
    
class Clownfish:
    def swim(self):
        print("Can no Swim")
    def bones(self):
        print("have")

s1 = Shark()
c1 = Clownfish()

for i in (s1,c1):
    print(i.swim)
    print(i.bones)

def inOcean(fish):
    fish.swim()


inOcean(s1)
inOcean(c1)