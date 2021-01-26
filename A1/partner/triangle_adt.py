## @file triangle_adt.py
#  @author Samarth Kumar
#  @brief Contains a class for working with triangles
#  @date 01/21/2021

from math import sqrt
from enum import Enum, auto

## @brief An ADT for handling triangles
#  @details A triangle consists of its 3 Integer sidelengths
class TriangleT:

    ## @brief Constructor for TriangleT
    #  @details Creates a triangle given its 3 sidelengths
    #  @details It is assumed that sidelengths are passed as Integers
    #  @param x First Integer sidelength
    #  @param y Second Integer sidelength
    #  @param z Third Integer sidelength
    def __init__(self, x, y, z):
        self.x = x
        self.y = y
        self.z = z

    ## @brief Gets the sidelengths of the triangle
    #  @return Tuple containing the 3 Integer sidelengths
    def get_sides(self):
        return self.x, self.y, self.z

    ## @brief Check if another triangle is equal to the current triangle object
    #  @details Uses the __eq__() method to determine exact triangle equality
    #  @details Since sidelengths are Integers, they must 
    #  exactly match to be equal triangles
    #  @details It is assumed that two invalid triangles can still be equal
    #  @details It is assumed that the input parameter, t, 
    #  is a TriangleT object
    #  @param t A triangle (TriangleT object)
    #  @return True if the triangles are equal, False otherwise
    def equal(self, t):
        return self == t

    # Private method for defining TriangleT '==' behaviour
    def __eq__(self, t):
        # Sort both triangle sidelengths first -- uses a version of mergesort
        sides1 = sorted(self.get_sides())
        sides2 = sorted(t.get_sides())
        # '==' will return true iff each index of the tuples match
        return sides1 == sides2

    ## @brief Gets the perimeter of the triangle
    #  @return Integer value of the perimeter of the triangle 
    #  or 0 if the triangle is not valid
    def perim(self):
        if not self.is_valid():
            return 0
        return self.x + self.y + self.z

    ## @brief Gets the area of the triangle
    #  @details Area is calculated using Heron's formula as obtained from:
    #  https://en.wikipedia.org/wiki/Heron's_formula
    #  @return Float value of the area of the triangle
    #  or 0.0 if the triangle is not valid
    def area(self):
        if not self.is_valid():
            return 0.0
        s = self.perim() / 2
        return sqrt(s * (s - self.x) * (s - self.y) * (s - self.z))

    ## @brief Checks if the 3 sidelengths of the triangle form a valid triangle
    #  @details For validity, the sum of any 2 sidelengths 
    #  must be greater than the third sidelength
    #  @details Reference material obtained from:
    #  https://en.wikipedia.org/wiki/Triangle_inequality
    #  @details It is assumed that a degenerate triangle 
    #  (collinear sides and 0 area) is invalid
    #  @return True if it is a valid triangle, False otherwise
    def is_valid(self):
        # Immediately return False if there are sidelengths below or equal to 0
        for s in self.get_sides():
            if s <= 0:
                return False
        # Check that the sum of each pair of sidelengths is greater than 
        # the other sidelength
        return ((self.x + self.y > self.z) and (self.x + self.z > self.y) and (self.y + self.z > self.x))

    ## @brief Determines the type of triangle
    #  @details A triangle can be classified as equilateral, isosceles, 
    #  scalene, or right
    #  @details Sidelengths must exactly match for equality,
    #  since they are Integers
    #  @details A triangle may meet the criteria for more than one TriType, 
    #  but it is classified as only one of them 
    #  @details All equilateral triangles are also isosceles, 
    #  but the triangle is classified as equilateral
    #  @details If a triangle is both right and scalene, 
    #  it is classified as right
    #  @details It is assumed that the current TriangleT object
    #  is a valid triangle
    #  @return TriType which represents the type of triangle
    def tri_type(self):
        # Equilateral
        if self.x == self.y == self.z:
            return TriType.equilat

        # Right
        # Uses Pythagorean theorem to check if it is a right triangle
        s = sorted(self.get_sides())
        if s[0] * s[0] + s[1] * s[1] == s[2] * s[2]:
            return TriType.right

        # Scalene
        if (self.x != self.y) and (self.x != self.z) and (self.y != self.z):
            return TriType.scalene

        # Isosceles
        # All other classifications have been handled, must be isosceles
        return TriType.isosceles

## @brief TriType contains an enumeration for types of triangles
#  @details A triangle can be typed as equilateral, isosceles, 
#  scalene, or right
class TriType(Enum):
    equilat = auto()
    isosceles = auto()
    scalene = auto()
    right = auto()
