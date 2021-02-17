## @file CircleT.py
#  @author Safwan Hossain, Hossam18
#  @brief
#  @date  2/16/2021
from Shape import Shape


class CircleT(Shape):
    ## @brief constructor for CircleT
    #  @param x Float representing the x coordinate of the circle
    #  @param y Float representing the y coordinate of the circle
    #  @param r Float representing the radius of the circle
    #  @param r Float representing the mass of the circle
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