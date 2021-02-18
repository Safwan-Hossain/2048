## @file Scene.py
#  @author Samarth Kumar
#  @brief Contains a class for a Scene
#  @date Feb. 12th, 2021

import scipy.integrate as sp


## @brief A class for creating a scene
#  @details Used to simulate movement of a shape in a scene, based on its
#  shape properties, initial velocity, and unbalanced external forces
class Scene():

    ## @brief Constructor for Scene objects
    #  @param s Shape object
    #  @param F_x Function: Float -> Float,
    #  representing the unbalanced force in the x direction at a given time
    #  @param F_y Function: Float -> Float,
    #  representing the unbalanced force in the y direction at a given time
    #  @param v_x Float representing the initial velocity in the x direction
    #  @param v_y Float representing the initial velocity in the y direction
    def __init__(self, s, F_x, F_y, v_x, v_y):
        self.s = s
        self.F_x = F_x
        self.F_y = F_y
        self.v_x = v_x
        self.v_y = v_y

    ## @brief Gets the shape in the scene
    #  @return Shape object representing the shape in the scene
    def get_shape(self):
        return self.s

    ## @brief Gets the unbalanced forces in the scene
    #  @return Tuple of Functions: Float -> Float, representing the
    #  unbalanced forces in the x and y directions
    def get_unbal_forces(self):
        return self.F_x, self.F_y

    ## @brief Gets the initial velocities in the scene
    #  @return Tuple of Floats representing the initial velocities
    #  in the x and y directions
    def get_init_velo(self):
        return self.v_x, self.v_y

    ## @brief Sets the shape of the scene
    #  @param s Shape object
    def set_shape(self, s):
        self.s = s

    ## @brief Sets the unbalanced forces of the scene
    #  @param F_x Function: Float -> Float,
    #  representing the unbalanced force in the x direction at a given time
    #  @param F_y Function: Float -> Float,
    #  representing the unbalanced force in the y direction at a given time
    def set_unbal_forces(self, F_x, F_y):
        self.F_x = F_x
        self.F_y = F_y

    ## @brief Sets the initial velocities of the scene
    #  @param v_x Float representing the initial velocity in the x direction
    #  @param v_y Float representing the initial velocity in the y direction
    def set_init_velo(self, v_x, v_y):
        self.v_x = v_x
        self.v_y = v_y

    ## @brief Simulation based on the properties of the scene
    #  @param t_final Float representing the time to simulate up to (in seconds)
    #  @param nsteps Integer representing the number of steps to divide
    #  the time interval into
    #  @returns Tuple of Sequences, where the first sequence represents the
    #  time values, and the second sequence is the result of the solved ODE
    def sim(self, t_final, nsteps):
        t = [i * t_final / (nsteps - 1) for i in range(nsteps)]
        return t, sp.odeint(lambda w, t: [w[2], w[3], self.F_x(t) / self.s.mass(),
                            self.F_y(t) / self.s.mass()], [self.s.cm_x(), self.s.cm_y(),
                            self.v_x, self.v_y], t)
