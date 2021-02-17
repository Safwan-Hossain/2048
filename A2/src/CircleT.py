## @file CircleT.py
#  @author Safwan Hossain, Hossam18
#  @brief contains a class for working with circles
#  @date  2/16/2021
from Shape import Shape

## @brief An ADT for handling circles that inherits Shape.py
# @details A circle has an x and y coordinate, a non-zero radius,
# and a non-zero mass
class CircleT(Shape):
    ## @brief constructor for CircleT
    #  @param x Float representing the x coordinate of the circle
    #  @param y Float representing the y coordinate of the circle
    #  @param r Float representing the radius of the circle
    #  @param m Float representing the mass of the circle
    #  @throws ValueError when either mass or radius is 0 or lower

    def __init__(self, x, y, r, m):
        if r <= 0 or m <= 0:
            raise ValueError("mass and radius should be greater than zero")

        self.x = x
        self.y = y
        self.r = r
        self.m = m

    ## @brief gets the x coordinate of the circle
    # @return Float representing the x coordinate of the circle
    def cm_x(self):
        return self.x

    ## @brief gets the y coordinate of the circle
    # @return Float representing the y coordinate of the circle
    def cm_y(self):
        return self.y    

    ## @brief gets the mass of the circle
    # @return Float representing the mass of the circle
    def mass(self):
        return self.m   

    ## @brief gets the inertia of the circle
    # @details calculates the moment of inertia of the circle using the formula
    # that can be found in https://gitlab.cas.mcmaster.ca/smiths/se2aa4_cs2me3/-/blob/master/Assignments/A2/A2.pdf
    # @return Float representing the moment of inertia of the circle
    def m_inert(self):
        return (self.r ** 2 * self.m) / 2
