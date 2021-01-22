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
        return self.a == other.a and self.b == other.b and self.c == other.c

    def perim(self):
        return self.a + self.b + self.c

    def area(self):
        p = self.perim()

        return math.sqrt(p * (p - self.a) * (p - self.b) * (p - self.c))

    def is_valid(self):
        a = self.a
        b = self.b
        c = self.c

        return a + b > c or a + c > b or b + c > a

    def tri_type(self):
        a = self.a
        b = self.b
        c = self.c

        hyp = max(a, b, c)
        list1 = [a, b, c]
        list1.remove(hyp)
        side1 = list1[0]
        side2 = list1[1]

        if a == b and a == c:
            return TriType(1)
        elif (a == b and not a == c) or (a == c and not a == b) or (b == c and not a == b):
            return TriType(2)
        elif (side1 ** 2 + side2 ** 2) == hyp ** 2:
            return TriType(4)
        else:
            return TriType(3)
