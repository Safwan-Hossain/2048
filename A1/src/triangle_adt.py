## @file triangle_adt.py
#  @author Safwan Hossain
#  @brief Hossam18
#  @date 1/21/2021

import math
from enum import Enum


class TriType(Enum):
    equilat = 1
    isosceles = 2
    scalene = 3
    right = 4


class TriangleT:
    def __init__(self, a, b, c):
        self.a = a
        self.b = b
        self.c = c

    def get_sides(self):
        return self.a, self.b, self.c

    def equal(self, other):
        return sorted([self.a, self.b, self.c]) == sorted([other.a, other.b, other.c])

    def perim(self):
        return self.a + self.b + self.c

    def area(self):
        p = self.perim() / 2
        return math.sqrt(p * (p - self.a) * (p - self.b) * (p - self.c))

    def is_valid(self):
        a = self.a
        b = self.b
        c = self.c

        return a + b > c and a + c > b and b + c > a

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
