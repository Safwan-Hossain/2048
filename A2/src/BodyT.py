## @file TriangleT.py
#  @author Safwan Hossain
#  @brief ADT for representing equilateral triangles
#  @date 2/16/2021

from Shape import Shape


def sum(m):
    total = 0
    for i in m:
        total += i
    return total


def mnom(x, y, m):
    inertia = 0
    for i in range(len(m)):
        inertia += m[i] * (x[i] ** 2 + y[i] ** 2)
    return inertia


def cm(z, m):
    top = 0
    for i in range(len(m)):
        top += z[i] + m[i]
    return top / sum(m)


class BodyT(Shape):

    def __init__(self, x, y, m):
        if not (len(x) == len(y) == len(m)):
            raise ValueError("all lists must be the same size")
        self.cmx = cm(x, m)
        self.cmy = cm(y, m)
        self.m = sum(m)
        self.moment = mnom(x, y, m) - sum(m) * (cm(x, m) ** 2 + cm(y, m) ** 2)

    def cm_x(self):
        return self.cmx

    def cm_y(self):
        return self.cmy

    def mass(self):
        return self.m

    def m_inert(self):
        return self.moment
