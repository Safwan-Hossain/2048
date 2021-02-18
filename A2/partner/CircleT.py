## @file CircleT.py
#  @author Samarth Kumar
#  @brief Contains a class for circle objects
#  @date Feb. 12th, 2021

from Shape import Shape


## @brief An ADT for handling circles
#  @details Every circle has a mass, radius,
#  moment of inertia, and x and y coordinates
#  representing its center of mass
class CircleT(Shape):

    ## @brief Constructor for CircleT objects
    #  @details It is assumed that the arguments provided to
    #  the access programs will be of the correct type
    #  @param x Float representing the x coordinate
    #  @param y Float representing the y coordinate
    #  @param r Float representing the radius
    #  @param m Float representing the mass
    #  @throws ValueError if the radius or mass is 0 or negative
    def __init__(self, x, y, r, m):
        if not(r > 0 and m > 0):
            raise ValueError
        self.x = x
        self.y = y
        self.r = r
        self.m = m

    ## @brief Gets the x coordinate center of mass of the circle
    #  @return Float representing the x coordinate
    def cm_x(self):
        return self.x

    ## @brief Gets the y coordinate center of mass of the circle
    #  @return Float representing the y coordinate
    def cm_y(self):
        return self.y

    ## @brief Gets the mass of the circle
    #  @return Float representing the mass
    def mass(self):
        return self.m

    ## @brief Gets the moment of inertia of the circle
    #  @return Float representing the moment of inertia
    def m_inert(self):
        return self.m * (self.r * self.r) / 2
