## @file complex_adt.py
#  @author Safwan Hossain
#  @brief ADT for complex number
#  @date 1/21/2021

import math


## @brief An ADT for representing complex numbers
#  @details A complex number is defined by the addition of a real number with an
#           imaginary number
class ComplexT:

    ## @brief Constructor for ComplexT
    #  @details Creates a complex number using a real and an imaginary number
    #  @param x A float representing the real number
    #  @param y A float representing the imaginary number
    def __init__(self, x, y):
        self.x = x
        self.y = y

    ## @brief Gets the real part of the complex number
    #  @return Float representing the real part of the complex number
    def real(self):
        return self.x

    ## @brief Gets the imaginary part of the complex number
    #  @return Float representing the imaginary part of the complex number
    def imag(self):
        return self.y

    ## @brief Gets the magnitude of the complex number
    #  @details Assume the imaginary part of the complex number isn't zero
    #  @return Float representing magnitude of the complex number
    def get_r(self):
        return math.sqrt(self.x ** 2 + self.y ** 2)

    ## @brief Gets the phase of the complex number in radians
    #  @details Assume the imaginary part of the complex number isn't zero
    #  @return Float representing the phase of the complex number in radians
    def get_phi(self):
        return math.atan2(self.y, self.x)

    ## @brief Checks if a given complex number is equivalent to the current
    #         complex number
    #  @param other A complex number
    #  @return True if given complex number is equal to current complex number,
    #          False otherwise
    def equal(self, other):
        return self.x == other.x and self.y == other.y

    ## @brief Gets the conjugate of the complex number
    #  @details Assume the imaginary part of the complex number isn't zero
    #  @return ComplexT object that is the conjugate of the current complex number
    def conj(self):
        return ComplexT(self.x, -self.y)

    ## @brief Returns a complex number that is the addition of two complex numbers
    #  @param other A complex number
    #  @return ComplexT object that is the addition of the current complex number and a
    #          given complex number
    def add(self, other):
        return ComplexT(self.x + other.x, self.y + other.y)


    ## @brief Returns a complex number that is the subtraction of two complex numbers
    #  @param other A complex number
    #  @return ComplexT object that is the subtraction of the current complex number from a
    #          given complex number
    def sub(self, other):
        return ComplexT(self.x - other.x, self.y - other.y)


    ## @brief Returns a complex number that is the product of two complex numbers
    #  @param other A complex number
    #  @return ComplexT object that is the product of the current complex number and a
    #          given complex number
    def mult(self, other):
        x = self.x * other.x - self.y * other.y
        y = self.x * other.y + self.y * other.x

        return ComplexT(x, y)

    ## @brief Returns the reciprocal of the current complex number
    #  @details Assume the imaginary part of the complex number isn't zero
    #  @return ComplexT object that is the reciprocal of the current complex number
    def recip(self):
        denom = self.x ** 2 + self.y ** 2

        return ComplexT(self.x / denom, -self.y / denom)

    ## @brief Returns a complex number that is the quotient of two complex numbers
    #  @details Assume the imaginary parts of the complex numbers aren't zero
    #  @param other A complex number
    #  @return ComplexT object that is the quotient of the current complex number and a
    #          given complex number
    def div(self, other):
        denom = other.x ** 2 + other.y ** 2
        x = (self.x * other.x + self.y * other.y) / denom
        y = (self.y * other.x - self.x * other.y) / denom

        return ComplexT(x, y)

    ## @brief Returns the square root of the current complex number
    #  @details Assume the imaginary part of the complex number isn't zero
    #  @return ComplexT object that is the square root of the current complex number
    def sqrt(self):
        x = math.sqrt((self.get_r() + self.x) / 2)
        y = (self.y / abs(self.y)) * math.sqrt((self.get_r() - self.x) / 2)

        return ComplexT(x, y)