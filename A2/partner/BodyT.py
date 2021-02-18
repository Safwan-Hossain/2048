## @file BodyT.py
#  @author Samarth Kumar
#  @brief Contains a class for BodyT objects
#  @date Feb. 12th, 2021

from Shape import Shape
from functools import reduce


## @brief An ADT for handling BodyT objects
#  @details Every BodyT object has a sequence of masses,
#  each with x and y center of mass coordinates. It also has a
#  total mass and moment of inertia.
class BodyT(Shape):

    ## @brief Constructor for BodyT objects
    #  @details It is assumed that the arguments provided to
    #  the access programs will be of the correct type
    #  @param x Sequence of Floats representing the x coordinates
    #  for each center of mass
    #  @param y Sequence of Floats representing the y coordinates
    #  for each center of mass
    #  @param m Sequence of Floats representing the masses
    #  @throws ValueError if sequences are not all the same size,
    #  a sequence is empty, or at least one of the masses is 0 or negative
    def __init__(self, x, y, m):
        if not(len(x) == len(y) == len(m)):
            raise ValueError
        if not reduce(lambda u, v: u and v, [u > 0 for u in m], True):
            raise ValueError
        # Empty lists
        if (len(x) == 0):
            raise ValueError

        self.cmx = sum([x[i] * m[i] for i in range(len(m))]) / sum(m)
        self.cmy = sum([y[i] * m[i] for i in range(len(m))]) / sum(m)
        self.m = sum(m)
        self.moment = sum([m[i] * (x[i]**2 + y[i]**2) for i in range(len(m))]) \
            - sum(m) * ((self.cmx**2) + self.cmy**2)

    ## @brief Gets the x coordinate center of mass of the BodyT object
    #  @return Float representing the x coordinate
    def cm_x(self):
        return self.cmx

    ## @brief Gets the y coordinate center of mass of the BodyT object
    #  @return Float representing the y coordinate
    def cm_y(self):
        return self.cmy

    ## @brief Gets the total mass of the BodyT object
    #  @return Float representing the mass
    def mass(self):
        return self.m

    ## @brief Gets the moment of inertia of the BodyT object
    #  @return Float representing the moment of inertia
    def m_inert(self):
        return self.moment
