## @file Shape.py
#  @author Safwan Hossain
#  @brief An interface for modules that implement shape entities
#  @date 2/16/2021

from abc import ABC, abstractmethod


##@brief Shape provides an interface for shape entities
##@details The methods used in this interface are abstract
# and must be overriden by modules that inherit this interface.

class Shape(ABC):

    @abstractmethod
    ## @brief a generic method for getting the x value of the center of
    # mass of a shape
    #  @details should be inherited and overridden for specific shape
    #  entity ADTs
    # @return Float representing the x position of the center of mass

    def cm_x(self):
        pass

    ## @brief a generic method for getting the y value of the center of
    # mass of a shape
    #  @details should be inherited and overridden for specific shape
    #  entity ADTs
    # @return Float representing the y position of the center of mass
    @abstractmethod
    def cm_y(self):
        pass

    ## @brief a generic method for getting the mass of a shape
    #  @details should be inherited and overridden for specific shape
    #  entity ADTs
    # @return Float representing the mass of a shape
    @abstractmethod
    def mass(self):
        pass

    ## @brief a generic method for getting the moment of inertia
    #  @details should be inherited and overridden for specific shape
    #  entity ADTs
    # @return Float representing the moment of inertia of a shape
    @abstractmethod
    def m_inert(self):
        pass
