"""
The singularity has happened and we are being made to build the ideal robo-city for our overlords. In this shining robotropolis, all buildings will be rectangular and all streets laid along south-north and east-west lines in a glorious grid. Before we get started, we to create a class to represent the perfect building.
Because all the buildings in the city are rectangular and their walls are parallel to the streets, we can define any building using only the coordinates of South-Western corner as two arguments (the length of the west to east walls, and the length of the north to south wall) along with the height of the building. These values are described as positive numbers using conventional units. The origin point of our coordinate system lies in the South-West , as a result the northern corner ends up having the greater coordinate value than the southern corner. To complete this mission we need to use a couple operations. See the class description below.
class Building(south, west, width_WE, width_NS, height=10)
Returns a new Building instance with the South-West corner at [south, west] coordinates, the size is width_WE by width_NS and the height of the building is height. "height" is a positive number with a default value of 10.
>>> Building(10, 10, 1, 2, 2)
Building(10, 10, 1, 2, 2)
>>> Building(0, 0, 10.5, 2.546)
Building(0, 0, 10.5, 2.546, 10)

corners()
Returns a dictionary with the coordinates of the building corners. The dictionary has following keys: "north-west", "north-east", "south-west", "south-east". The values are lists or tuples with two numbers.
>>> Building(1, 2, 2, 2).corners()
{"north-west": [3, 2], "north-east": [3, 4], "south-west": [1, 2], "south-east": [1, 4]}

area()
Returns the area of the building.
>>> Building(1, 2.5, 4.2, 1.25).area()
5.25

volume()
Returns the volume of the building.
>>> Building(1, 2.5, 4.2, 1.25, 101).volume()
530.25

__repr__()
This is a string representation of the Building. This method is used for "print" or "str" conversion. Returns the string in the following view:
"Building({south}, {west}, {width_we}, {width_ns}, {height})"
>>> str(Building(0, 0, 10.5, 2.546))
"Building(0, 0, 10.5, 2.546, 10)"

In this mission all data will be correct and you don't need to implement value checking.
Input: Statements and expression with the Building class.
Output: The behaviour as described.
Precondition: All data are correct.
"""

class Building:
    def __init__(self, south, west, width_WE, width_NS, height=10):
        self.south = south
        self.west = west
        self.width_WE = width_WE
        self.width_NS = width_NS
        self.height = height

    def corners(self):
        return {"north-east":[self.south + self.width_NS, self.west + self.width_WE],
                "south-east":[self.south, self.west + self.width_WE],
                "south-west":[self.south, self.west],
                "north-west":[self.south + self.width_NS, self.west]}

    def area(self):
        return self.width_WE * self.width_NS

    def volume(self):
        return self.area() * self.height

    def __repr__(self):
        return ("Building({}, {}, {}, {}, {})".format(self.south, self.west, self.width_WE, self.width_NS, self.height))


if __name__ == '__main__':
    #These "asserts" using only for self-checking and not necessary for auto-testing
    def json_dict(d):
        return dict((k, list(v)) for k, v in d.items())

    b = Building(1, 2, 2, 3)
    b2 = Building(1, 2, 2, 3, 5)
    assert json_dict(b.corners()) == {'north-east': [4, 4], 'south-east': [1, 4],
                                      'south-west': [1, 2], 'north-west': [4, 2]}, "Corners"
    assert b.area() == 6, "Area"
    assert b.volume() == 60, "Volume"
    assert b2.volume() == 30, "Volume2"
    assert str(b) == "Building(1, 2, 2, 3, 10)", "String"
