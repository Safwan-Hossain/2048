## @file complex_adt.py
#  @author Safwan Hossain
#  @brief ADT for complex number
#  @date 1/21/2021

import math


class ComplexT:
    def __init__(self, x, y):
        self.x = x
        self.y = y

    def real(self):
        return self.x

    def imag(self):
        return self.y

    def get_r(self):
        return math.sqrt(self.x ** 2 + self.y ** 2)

    def get_phi(self):
        return math.atan2(self.y, self.x)

    def equal(self, other):
        return self.x == other.x and self.y == other.y

    def conj(self):
        return ComplexT(self.x, -self.y)

    def add(self, other):
        return ComplexT(self.x + other.x, self.y + other.y)

    def sub(self, other):
        return ComplexT(self.x - other.x, self.y - other.y)

    def mult(self, other):
        x = self.x * other.x - self.y * other.y
        y = self.x * other.y + self.y * other.x

        return ComplexT(x, y)

    def recip(self):
        denom = self.x ** 2 + self.y ** 2

        return ComplexT(self.x / denom, -self.y / denom)

    def div(self, other):
        denom = other.x ** 2 + other.y ** 2
        x = (self.x * other.x + self.y * other.y) / denom
        y = (self.y * other.x - self.x * other.y) / denom

        return ComplexT(x, y)

    def sqrt(self):
        x = math.sqrt((self.get_r() + self.x) / 2)
        y = (self.y / abs(self.y)) * math.sqrt((self.get_r() - self.x) / 2)

        return ComplexT(x, y)


