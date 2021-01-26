## @file complex_adt.py
#  @author Samarth Kumar
#  @brief Contains a class for working with complex numbers
#  @date 01/21/2021

import cmath

## @brief An ADT for handling complex numbers
#  @details A complex number contains a real and imaginary part
class ComplexT:

    ## @brief Constructor for ComplexT
    #  @details Creates a complex number based on 
    #  a given real value and imaginary value
    #  @details The complex number is x + y*i
    #  @details It is assumed that the passed real and 
    #  imaginary parts are Float values
    #  @param x Float representing the real part of the complex number
    #  @param y Float representing the imaginary part of the complex number
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
    #  @return Float representing the magnitude of the complex number
    def get_r(self):
        return abs(complex(self.x, self.y))

    ## @brief Gets the argument (phase) of the complex number
    #  @details The phase of the complex number, 0 + 0i, is returned as 
    #  0 rather than undefined
    #  @details Phase definition obtained from 
    #  https://en.wikipedia.org/wiki/Complex_number
    #  @return Float representing the phase in radians
    def get_phi(self):
        return cmath.phase(complex(self.x, self.y))

    ## @brief Checks if another complex number is equal to
    #  the current complex number
    #  @details Uses the __eq__() method to determine approximate equality
    #  @details Approximate equality is chosen 
    #  arbitrarily to within 10e-9
    #  @details It is assumed that the input parameter, c, 
    #  is a ComplexT object
    #  @param c A complex number (ComplexT object)
    #  @return True if the complex numbers are approximately equal, 
    #  False otherwise
    def equal(self, c):
        # Uses the '__eq__()' behaviour to approximately compare ComplexT objects
        return self == c
    
    # Private method for defining ComplexT '==' behavior
    def __eq__(self, c):
        # Used to avoid floating point errors when comparing complex numbers
        return abs(c.real()-self.x) < 10e-9 and abs(c.imag()-self.y) < 10e-9

    ## @brief Gets the conjugate of the complex number
    #  @return ComplexT object representing the conjugate
    def conj(self):
        return ComplexT(self.x, -1 * self.y)

    ## @brief Adds another complex number to the current complex number
    #  @details It is assumed that the input parameter, c, 
    #  is a ComplexT object
    #  @param c A complex number (ComplexT object)
    #  @return ComplexT object representing the sum of the two complex numbers
    def add(self, c):
        return ComplexT(c.real() + self.x, c.imag() + self.y)

    ## @brief Subtracts another complex number from the current complex number
    #  @details It is assumed that the input parameter, c, 
    #  is a ComplexT object
    #  @param c A complex number (ComplexT object)
    #  @return ComplexT object representing the difference 
    #  between the current complex number and the passed complex number
    def sub(self, c):
        return ComplexT(self.x - c.real(), self.y - c.imag())

    ## @brief Multiplies another complex number and the current complex number
    #  @details Complex number multiplication sourced from
    #  https://en.wikipedia.org/wiki/Complex_number
    #  @details It is assumed that the input parameter, c, 
    #  is a ComplexT object
    #  @param c A complex number (ComplexT object)
    #  @return ComplexT object representing
    #  the product of the complex numbers
    def mult(self, c):
        # perform binomial expansion for the complex numbers
        # i^2 becomes -1
        x = self.x * c.real() - self.y * c.imag()
        y = self.x * c.imag() + self.y * c.real()
        return ComplexT(x, y)

    ## @brief Gets the reciprocal of the complex number
    #  @details Complex number reciprocal sourced from 
    #  https://en.wikipedia.org/wiki/Complex_number
    #  @details It is assumed that this method is 
    #  not called when the complex number is 0 + 0i, 
    #  due to zero division
    #  @return ComplexT object representing
    #  the reciprocal of the current complex number
    def recip(self):
        # the denominator of both terms is x^2 + y^2
        denom = self.x * self.x + self.y * self.y
        x = self.x / denom
        y = -1 * self.y / denom
        return ComplexT(x, y)

    ## @brief Divides the current complex number by another complex number
    #  @details Complex number division sourced from 
    #  https://en.wikipedia.org/wiki/Complex_number
    #  @details It is assumed that the input parameter, c, 
    #  is a ComplexT object which is not 0 + 0i, due to zero division
    #  @param c A complex number (ComplexT object)
    #  @return ComplexT object representing
    #  the quotient of the complex numbers
    def div(self, c):
        # division can be rewritten as multiplication of the reciprocal
        return self.mult(c.recip())

    ## @brief Gets the positive square root of the complex number
    #  @details The square root of a complex number sourced from 
    #  https://en.wikipedia.org/wiki/Complex_number
    #  @return ComplexT object representing
    #  the positive square root of the complex number
    def sqrt(self):
        c = cmath.sqrt(complex(self.x, self.y))
        return ComplexT(c.real, c.imag)

    




    




    

