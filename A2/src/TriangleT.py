## @file TriangleT.py
#  @author Safwan Hossain
#  @brief ADT for representing equilateral triangles
#  @date 2/16/2021

from Shape import Shape


## @brief An ADT for handling equliateral triangle that inherits Shape.py
# @details An equilateral triangle has an x and y coordinate,
# non-zero (equal) side lengths, and a non-zero mass
class TriangleT(Shape):
    ## @brief constructor for TriangleT
    #  @param x Float representing the x coordinate of the triangle
    #  @param y Float representing the y coordinate of the triangle
    #  @param s Float representing the side lengths of the triangle
    #  @param m Float representing the mass of the triangle
    #  @throws ValueError when either mass or side lengths are 0 or lower

    def __init__(self, x, y, s, m):
        if s <= 0 or m <= 0:
            raise ValueError("mass and side lengths must be greater than zero")

        self.x = x
        self.y = y
        self.s = s
        self.m = m

    ## @brief gets the x coordinate of the triangle
    # @return Float representing the x coordinate of the triangle
    def cm_x(self):
        return self.x

    ## @brief gets the y coordinate of the triangle
    # @return Float representing the y coordinate of the triangle
    def cm_y(self):
        return self.y

    ## @brief gets the mass of the triangle
    # @return Float representing the mass of the triangle
    def mass(self):
        return self.m

    ## @brief gets the inertia of the triangle
    # @details calculates the moment of inertia of the triangle using the formula
    # that can be found in https://gitlab.cas.mcmaster.ca/smiths/se2aa4_cs2me3/-/blob/master/Assignments/A2/A2.pdf
    # @return Float representing the moment of inertia of the triangle
    def m_inert(self):
        return (self.m * (self.s ** 2)) / 12
