## @file Plot.py
#  @author Safwan Hossain, hossam18
#  @brief Plots the x and y positions of a shape in Scene.py
#  @date 2/16/2021
#  @details Takes the x, y and time values from lists and compares first
#  the x values to time, then y values to time, then x and y values without
#  time.


import matplotlib.pyplot as plt

## @brief method for plotting moving shapes in Scene.py
#  @param w List containing another list of Floats, where the first 
#  index is the x value and the second index is the y value of a shape
#  @param t List containing Floats of time
#  @throws ValueError if lists are not all the same size

def plot(w, t):
    list_x = []
    list_y = []

    for i in w:
        list_x.append(i[0])
        list_y.append(i[1])

    if len(list_x) != len(t):
        raise ValueError("Lists are not of same length")

    plt.figure(1)

    plt.subplot(3, 1, 1)
    plt.plot(t, list_x, "k")
    plt.xlabel("time(s)")
    plt.ylabel("x(m)")

    plt.subplot(3, 1, 2)
    plt.plot(t, list_y, "k")
    plt.xlabel("time(s)")
    plt.ylabel("y(m)")

    plt.subplot(3, 1, 3)
    plt.plot(list_x, list_y, "k")
    plt.xlabel("x(m)")
    plt.ylabel("y(m)")

    # plt.show()
