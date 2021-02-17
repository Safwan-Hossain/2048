## @file BodyT.py
#  @author Safwan Hossain
#  @brief ADT for handling multiple shapes
#  @date 2/16/2021

from Shape import Shape


## @brief helper method that adds all the items in a list and returns the total
#  @details adds all the elements of the list and divides by the number of elements
#  in the list and returns the Float value
#  @param m List containing Floats
#  @return total Float representing the addition of all elements of the list
def sum(m):
    total = 0
    for i in m:
        total += i
    return total

## @brief helper method that calculates the moment of inertia of multiple
#  for a collective of objects
# @details calculates the moment of inertia using the formula
# that can be found in https://gitlab.cas.mcmaster.ca/smiths/se2aa4_cs2me3/-/blob/master/Assignments/A2/A2.pdf
#  @param x List containing x coordinates of BodyT
#  @param y List containing y coordinates of BodyT
#  @param m List containing masses of BodyT
#  @return inertia Float representing the moment of inertia of BodyT
def mnom(x, y, m):
    inertia = 0
    for i in range(len(m)):
        inertia += m[i] * (x[i] ** 2 + y[i] ** 2)
    return inertia

## @brief helper method that calculates the center of mass
#  for a collective of objects
#  @details calculates the center of mass using the formula
#  that can be found in https://gitlab.cas.mcmaster.ca/smiths/se2aa4_cs2me3/-/blob/master/Assignments/A2/A2.pdf
#  @param z List containing x coordinates of BodyT
#  @param m List containing masses of BodyT
#  @return Float representing the center of mass of a BodyT
def cm(z, m):
    top = 0
    for i in range(len(m)):
        top += z[i] + m[i]
    return top / sum(m)

## @brief An ADT for handling a collective of multiple shapes that inherits Shape.py
# @details BodyT contains a Float list of x coordinates, a Float list of y coordinates
# and a Float list of masses
class BodyT(Shape):
    ## @brief constructor for BodyT
    #  @param x List containing Floats representing the x coordinate of the BodyT
    #  @param y List containing Floats representing the y coordinate of the BodyT
    #  @param m List containing Floats representing the masses of the BodyT
    #  @throws ValueError when the lengths of the parameters are not of equal
    # length

    def __init__(self, x, y, m):
        if not (len(x) == len(y) == len(m)):
            raise ValueError("all lists must be the same size")
        self.cmx = cm(x, m)
        self.cmy = cm(y, m)
        self.m = sum(m)
        self.moment = mnom(x, y, m) - sum(m) * (cm(x, m) ** 2 + cm(y, m) ** 2)

    ## @brief gets the x portion of the center of mass of the BodyT
    # @return Float representing the x poriton of the
    # center of mass of the BodyT
    def cm_x(self):
        return self.cmx

    ## @brief gets the y portion of the center of mass of the BodyT
    # @return Float representing the y poriton of the
    # center of mass of the BodyT
    def cm_y(self):
        return self.cmy

    ## @brief gets the overall mass of the BodyT
    # @return Float representing the overall mass of the BodyT
    def mass(self):
        return self.m

    ## @brief gets the inertia of the BodyT
    # @return Float representing the moment of inertia of the BodyT
    def m_inert(self):
        return self.moment
