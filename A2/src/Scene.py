## @file Scene.py
#  @author Safwan Hossain
#  @brief ADT for handling shape objects for establishing motion
#  @date 2/16/2021
#  @details
from scipy.integrate import odeint
from Shape import Shape
from SciPy import SciPy


class Scene(Shape, SciPy):

    ## @brief constructor for Scene
    #  @param s shape obj,
    #  @param Float representing the sum of all x forces
    #  @param Float representing sum of all y forces
    #  @param Float representing x velocity
    #  @param Float representing y velocity

    def __init__(self, s, fx, fy, vx, vy):
        self.s = s
        self.fx = fx
        self.fy = fy
        self.vx = vx
        self.vy = vy

    ## @brief gets the shape of the scene
    # @returns Shape s representing the shape of the scene
    def get_shape(self):
        return self.s

    ## @brief gets the unbalanced forces from the scene
    # @returns Float fx representing all the x forces
    # @returns Float fy representing all the y forces
    def get_unbal_forces(self):
        return self.fx, self.fy

    ## @brief gets the initial velocities from the scene
    # @returns Float vx representing the initial x velocity of the shape
    # @returns Float vy representing the initial y velocity of the shape
    def get_init_velo(self):
        return self.vx, self.vy
