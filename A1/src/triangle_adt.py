## @file triangle_adt.py
#  @author Safwan Hossain
#  @brief ADT for triangles
#  @date 1/21/2021

import math
from enum import Enum


## @brief An enumerated data type for representing types of triangles
#  @details A triangle can be an equilateral, isosceles, scalene or right triangle
class TriType(Enum):
    equilat = 1
    isosceles = 2
    scalene = 3
    right = 4

## @brief An ADT for representing triangles
#  @details A triangle is composed of 3 connecting sides
class TriangleT:

    ## @brief Constructor for TriangleT
    #  @details Creates a triangle given 3 sides
    #  @param a Integer representing the first side
    #  @param b Integer representing the second side
    #  @param c Integer representing the third side
    def __init__(self, a, b, c):
        self.a = a
        self.b = b
        self.c = c

    ## @brief Gets all the sides of the current triangle
    #  @return Tuple containing three Integers, each representing a side of
    #          the current triangle
    def get_sides(self):
        return self.a, self.b, self.c

    ## @brief Checks if the current triangle is equivalent to a given triangle
    #  @param other A triangle
    #  @return True if the current triangle is equivalent to a given triangle,
    #          False otherwise
    def equal(self, other):
        return sorted([self.a, self.b, self.c]) == sorted([other.a, other.b, other.c])

    ## @brief Calculates the perimeter of the current triangle
    #  @return Integer representing the perimeter of the current triangle
    def perim(self):
        return self.a + self.b + self.c

    ## @brief Calculates the area of the current triangle
    #  @return Float representing the area of the current triangle
    def area(self):
        p = self.perim() / 2
        return math.sqrt(p * (p - self.a) * (p - self.b) * (p - self.c))

    ## @brief Checks if the current triangle is possible with its sides
    #  @return True if triangle is valid, False otherwise
    def is_valid(self):
        a = self.a
        b = self.b
        c = self.c

        return a + b > c and a + c > b and b + c > a

    ## @brief Determines the type of the current triangle
    #  @return TriType that represents the type of the current triangle
    def tri_type(self):
        a = self.a
        b = self.b
        c = self.c

        hyp = max(a, b, c)

        if a == b and a == c:
            return TriType.equilat
        elif (a ** 2 + b ** 2 + c ** 2) == 2 * hyp ** 2:
            return TriType.right
        elif (a == b and not a == c) or (a == c and not a == b) or (b == c and not a == b):
            return TriType.isosceles
        else:
            return TriType.scalene
