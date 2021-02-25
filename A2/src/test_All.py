from CircleT import CircleT
from TriangleT import TriangleT
from BodyT import BodyT


def compareFloats(f1, f2):
    return abs(f1 - f2) < 10e-9


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
        top += z[i] * m[i]
    return top / sum(m)


def circle_cm_x_test():
    global counter
    c1 = CircleT(12, 13, 15, 10)
    c2 = CircleT(1, 2, 0.0001, 0.0000001)

    try:
        assert compareFloats(c1.cm_x(), 12)
        assert compareFloats(c2.cm_x(), 1)
        counter += 1
        print("CircleT cm_x() test passed")
    except:
        print("CircleT cm_x() test FAILED")


def circle_cm_y_test():
    global counter
    c1 = CircleT(12, 13, 15, 10)
    c2 = CircleT(1, 2, 0.0001, 0.0000001)

    try:
        assert compareFloats(c1.cm_y(), 13)
        assert compareFloats(c2.cm_y(), 2)
        counter += 1
        print("CircleT cm_y() test passed")
    except:
        print("CircleT cm_y() test FAILED")


def circle_mass_test():
    global counter
    c1 = CircleT(23, 43, 1, 10000000)
    c2 = CircleT(3, 4, 29, 0.00001)
    c3 = CircleT(80, 1.5, 71, 132)

    try:
        assert compareFloats(c1.mass(), 10000000)
        assert compareFloats(c2.mass(), 0.00001)
        assert compareFloats(c3.mass(), 132)
        counter += 1
        print("CircleT mass() test passed")
    except:
        print("CircleT mass() test FAILED")


def circle_m_inert_test():
    global counter
    c1 = CircleT(3, 4, 1355555, 12)
    c2 = CircleT(1, 2, 0.00000001, 4)
    c3 = CircleT(25, 25, 1, 1)

    try:
        assert compareFloats(c1.m_inert(), (1355555 ** 2 * 12) / 2)
        assert compareFloats(c2.m_inert(), 0.00000001 ** 2 * 2)
        assert compareFloats(c3.m_inert(), 0.5)
        counter += 1
        print("CircleT m_inert() test passed")
    except:
        print("CircleT m_inert() test FAILED")


def triangle_cm_x_test():
    global counter
    c1 = TriangleT(13, 42, 15, 104)
    c2 = TriangleT(1000000, 23, 12, 0.000001)

    try:
        assert compareFloats(c1.cm_x(), 13)
        assert compareFloats(c2.cm_x(), 1000000)
        counter += 1
        print("TriangleT cm_x() test passed")
    except:
        print("TriangleT cm_x() test FAILED")


def triangle_cm_y_test():
    global counter
    c1 = TriangleT(13, 42, 15, 104)
    c2 = TriangleT(1000000, 23, 12, 0.000001)

    try:
        assert compareFloats(c1.cm_y(), 42)
        assert compareFloats(c2.cm_y(), 23)
        counter += 1
        print("TriangleT cm_y() test passed")
    except:
        print("TriangleT cm_y() test FAILED")


def triangle_mass_test():
    global counter
    c1 = TriangleT(13, 42, 15, 1000004)
    c2 = TriangleT(1000000, 23, 12, 0.00000001)

    try:
        assert compareFloats(c1.mass(), 1000004)
        assert compareFloats(c2.mass(), 0.00000001)
        counter += 1
        print("TriangleT mass() test passed")
    except:
        print("TriangleT mass() test FAILED")


def triangle_m_inert_test():
    global counter
    c1 = TriangleT(13, 42, 15, 1000004)
    c2 = TriangleT(1000000, 23, 12, 0.00000001)

    try:
        assert compareFloats(c1.m_inert(), (15 ** 2 * 1000004) / 12)
        assert compareFloats(c2.m_inert(), (12 ** 2 * 0.00000001) / 12)
        counter += 1
        print("TriangleT m_inert() test passed")
    except:
        print("TriangleT m_inert() test FAILED")


def body_cm_x_test():
    global counter
    x1 = [12, 21, 3, 1]
    y1 = [3, 1, 5, 9]
    m1 = [41, 3, 31, 91]

    body1 = BodyT(x1, y1, m1)

    x2 = [2, 25, 35, 11]
    y2 = [13, 21, 4, 29]
    m2 = [41, 31, 31, 191]

    body2 = BodyT(x2, y2, m2)

    x3 = [12]
    y3 = [3]
    m3 = [41]

    body3 = BodyT(x3, y3, m3)

    try:
        print(body1.cm_x())
        print('expected')
        print(cm(x1, m1))
        assert compareFloats(body1.cm_x(), cm(x1, m1))
        assert compareFloats(body2.cm_x(), cm(x2, m2))
        assert compareFloats(body3.cm_x(), cm(x3, m3))
        counter += 1
        print("BodyT cm_x() test passed")
    except:
        print("BodyT cm_x() test FAILED")


def body_cm_y_test():
    global counter
    x1 = [12, 21, 3, 1]
    y1 = [3, 1, 5, 9]
    m1 = [41, 3, 31, 91]

    body1 = BodyT(x1, y1, m1)

    x2 = [2, 25, 35, 11]
    y2 = [13, 21, 4, 29]
    m2 = [41, 31, 31, 191]

    body2 = BodyT(x2, y2, m2)

    x3 = [12]
    y3 = [3]
    m3 = [41]

    body3 = BodyT(x3, y3, m3)

    try:
        assert compareFloats(body1.cm_y(), cm(y1, m1))
        assert compareFloats(body2.cm_y(), cm(y2, m2))
        assert compareFloats(body3.cm_y(), cm(y3, m3))
        counter += 1
        print("BodyT cm_y() test passed")
    except:
        print("BodyT cm_y() test FAILED")


def body_mass_test():
    global counter
    x1 = [12, 21, 3, 1]
    y1 = [3, 1, 5, 9]
    m1 = [41, 3, 31, 91]

    body1 = BodyT(x1, y1, m1)

    x2 = [2, 25, 35, 11]
    y2 = [13, 21, 4, 29]
    m2 = [41, 31, 31, 191]

    body2 = BodyT(x2, y2, m2)

    x3 = [12]
    y3 = [3]
    m3 = [41]

    body3 = BodyT(x3, y3, m3)

    try:
        assert compareFloats(body1.mass(), sum(m1))
        assert compareFloats(body2.mass(), sum(m2))
        assert compareFloats(body3.mass(), sum(m3))
        counter += 1
        print("BodyT mass() test passed")
    except:
        print("BodyT mass() test FAILED")


def body_m_inert_test():
    global counter
    x1 = [12, 21, 3, 1]
    y1 = [3, 1, 5, 9]
    m1 = [41, 3, 31, 91]

    body1 = BodyT(x1, y1, m1)

    x2 = [2, 25, 35, 11]
    y2 = [13, 21, 4, 29]
    m2 = [41, 31, 31, 191]

    body2 = BodyT(x2, y2, m2)

    x3 = [12]
    y3 = [3]
    m3 = [41]

    body3 = BodyT(x3, y3, m3)

    inert1 = mnom(x1, y1, m1) - sum(m1) * (cm(x1, m1) ** 2 + cm(y1, m1) ** 2)
    inert2 = mnom(x2, y2, m2) - sum(m2) * (cm(x2, m2) ** 2 + cm(y2, m2) ** 2)
    inert3 = mnom(x3, y3, m3) - sum(m3) * (cm(x3, m3) ** 2 + cm(y3, m3) ** 2)

    try:
        assert compareFloats(body1.m_inert(), inert1)
        assert compareFloats(body2.m_inert(), inert2)
        assert compareFloats(body3.m_inert(), inert3)
        counter += 1
        print("BodyT m_inert() test passed")
    except:
        print("BodyT m_inert() test FAILED")


def sum_test():
    global counter
    list1 = [1, 2, 3, 12, 23, 2]
    list2 = [5, 5]
    list3 = [1, 2, 10, 1, 2, 3, 4, 5]

    sum1 = 0
    sum2 = 0
    sum3 = 0

    for i in list1:
        sum1 += i

    for i in list2:
        sum2 += i

    for i in list3:
        sum3 += i

    try:
        assert compareFloats(sum(list1), sum1)
        assert compareFloats(sum(list2), sum2)
        assert compareFloats(sum(list3), sum3)
        counter += 1
        print("sum() test passed")
    except:
        print("sum() test FAILED")


def cm_test():
    global counter
    list1 = [1, 2, 3, 12, 23, 2]
    list2 = [5, 5, 2, 3, 4, 5]
    list3 = [1, 2]
    list4 = [12222, 304955]

    total = 0
    for i in range(len(list1)):
        total += list1[i] * list2[i]
    cm1 = total / sum(list2)
    cm2 = total / sum(list1)

    total = 0
    for i in range(len(list4)):
        total += list3[i] * list4[i]
    cm3 = total / sum(list4)

    try:
        assert compareFloats(cm(list1, list2), cm1)
        assert compareFloats(cm(list2, list1), cm2)
        assert compareFloats(cm(list3, list4), cm3)
        counter += 1
        print("cm() test passed")
    except:
        print("cm() test FAILED")


def mnom_test():
    global counter
    list1 = [13, 29, 54, 33]
    list2 = [53, 55, 33, 22]
    list3 = [11, 13, 14, 123]
    sum1 = 0
    for i in range(len(list3)):
        sum1 += list3[i] * (list1[i] ** 2 + list2[i] ** 2)

    list4 = [312, 22, 231213, 232, 123, 4324]
    list5 = [321, 321, 213, 132, 213, 3441]
    list6 = [688999, 674, 98, 754, 123, 34]
    sum2 = 0
    for i in range(len(list4)):
        sum2 += list6[i] * (list4[i] ** 2 + list5[i] ** 2)
    try:
        assert compareFloats(mnom(list1, list2, list3), sum1)
        assert compareFloats(mnom(list4, list5, list6), sum2)
        counter += 1
        print("mnom() test passed")
    except:
        print("mnom() test FAILED")


counter = 0
circle_cm_x_test()
circle_cm_y_test()
circle_m_inert_test()
circle_mass_test()
triangle_cm_x_test()
triangle_cm_y_test()
triangle_m_inert_test()
triangle_mass_test()
body_cm_x_test()
body_cm_y_test()
body_mass_test()
body_m_inert_test()
cm_test()
sum_test()
mnom_test()
print("")
print("Passed " + str(counter) + " / 15 tests")
