## @file TriangleT.py
#  @author Samarth Kumar
#  @brief Contains a class for triangle objects
#  @date Feb. 12th, 2021

from Shape import Shape


## @brief An ADT for handling equilateral triangles
#  @details Every triangle has 3 equal sidelengths,
#  a mass, moment of inertia, and x and y
#  coordinates representing its center of mass
class TriangleT(Shape):

    ## @brief Constructor for TriangleT objects
    #  @details It is assumed that the arguments provided to
    #  the access programs will be of the correct type
    #  @param x Float representing the x coordinate
    #  @param y Float representing the y coordinate
    #  @param s Float representing one sidelength of the equilateral triangle
    #  @param m Float representing the mass
    #  @throws ValueError if a sidelength or mass is 0 or negative
    def __init__(self, x, y, s, m):
        if not(s > 0 and m > 0):
            raise ValueError
        self.x = x
        self.y = y
        self.s = s
        self.m = m

    ## @brief Gets the x coordinate center of mass of the triangle
    #  @return Float representing the x coordinate
    def cm_x(self):
        return self.x

    ## @brief Gets the y coordinate center of mass of the triangle
    #  @return Float representing the y coordinate
    def cm_y(self):
        return self.y

    ## @brief Gets the mass of the triangle
    #  @return Float representing the mass
    def mass(self):
        return self.m

    ## @brief Gets the moment of inertia of the triangle
    #  @return Float representing the moment of inertia
    def m_inert(self):
        return self.m * (self.s * self.s) / 12
