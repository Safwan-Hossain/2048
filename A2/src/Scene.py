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

    ## @brief sets the shape of the scene
    # @param s the new shape of the scene
    def set_shape(self, s):
        self.s = s

    ## @brief sets the forces of the scene
    # @param fx the new x force of the scene
    # @param fy the new y force of the scene
    def set_unbal_forces(self, fx, fy):
        self.fx = fx
        self.fy = fy

    ## @brief sets the velocities of the scene
    # @param vx the new x velocity of the shape
    # @param vy the new y velocity of the shape
    def set_init_velo(self, vx, vy):
        self.vx = vx
        self.vy = vy

    ## @brief
    # @param t_final a Float value representing final time
    # @param nsteps representing number of steps
    # @return List containing Floats that represent time
    # @reutrn List containing Floats that represent the solution.
    def sim(self, t_final, nsteps):
        t = []
        for i in range * nsteps:
            t.append((i * t_final) / (nsteps - 1))
        return t, odeint(self.ode, [self.s.cm_x(), self.s.cm_y(), self.Vx, self.Vy], t)

    ## @brief a method for finding the ode
    # @details This method is used to find the ode more details about ode can
    # be found in https://en.wikipedia.org/wiki/Ordinary_differential_equation
    # @param w List containing Floats that represent rx, ry, vx and vy
    # @param t List containing Floats that represent time
    # @return List of Floats that represent the solution
    def ode(self, w, t):
        return [w[2], w[3], self.Fx(t) / self.s.mass(), self.Fy(t) / self.s.mass()]