## @file test_driver.py
#  @author Safwan Hossain
#  @brief test driver for modules ComplexT and TriangleT
#  @date 1/21/2021

import math

from complex_adt import ComplexT
from triangle_adt import TriangleT, TriType


# ComplexT Interface Syntax
def test_check(name, calculatedOutput, expectedOutput):
    counter = 0
    numOfTests = len(calculatedOutput)
    for i in range(numOfTests):
        calculated = calculatedOutput[i]
        expected = expectedOutput[i]
        if calculated == expected:
            counter = counter + 1

    if counter != numOfTests:
        print(name + " test FAILED: Passed " + str(counter) + " / " + str(numOfTests) + " tests")
    else:
        print(name + " test PASSED: Passed " + str(counter) + " / " + str(numOfTests) + " tests")


# ComplexT Interface Syntax
def object_test_check(name, calculatedOutput, expectedOutput):
    counter = 0
    numOfTests = len(calculatedOutput)
    for i in range(numOfTests):
        calculated = calculatedOutput[i]
        expected = expectedOutput[i]
        if calculated.equal(expected):
            counter = counter + 1

    if counter != numOfTests:
        print(name + " test FAILED: Passed " + str(counter) + " / " + str(numOfTests) + " tests")
    else:
        print(name + " test PASSED: Passed " + str(counter) + " / " + str(numOfTests) + " tests")


a = ComplexT(1.0, 2.0)
b = ComplexT(0.5, -0.5)
c = ComplexT(10.0, 5.0)
aCopy = ComplexT(1.0, 2.0)
bCopy = ComplexT(0.5, -0.5)


def real_check():
    test_check("ComplexT real", [a.real(), b.real()], [1.0, 0.5])


def imag_check():
    test_check("ComplexT imag", [a.imag(), b.imag()], [2.0, -0.5])


def get_r_check():
    calculatedOutput = [a.get_r(), b.get_r()]
    expectedOutput = [math.sqrt(1.0 ** 2 + 2.0 ** 2), math.sqrt(0.5 ** 2 + (-0.5) ** 2)]
    test_check("ComplexT get_r", calculatedOutput, expectedOutput)


def get_phi_check():
    calculatedOutput = [a.get_phi(), b.get_phi()]
    expectedOutput = [math.atan2(2.0, 1.0), math.atan2(-0.5, 0.5)]
    test_check("ComplexT get_phi", calculatedOutput, expectedOutput)


def equal_check():
    calculatedOutput = [a.equal(aCopy), b.equal(bCopy), a.equal(b), b.equal(aCopy)]
    expectedOutput = [True, True, False, False]
    test_check("ComplexT equal", calculatedOutput, expectedOutput)


def conj_check():
    calculatedOutput = [a.conj(), b.conj()]
    expectedOutput = [ComplexT(1.0, -2.0), ComplexT(0.5, 0.5)]
    object_test_check("ComplexT conj", calculatedOutput, expectedOutput)


def add_check():
    calculatedOutput = [a.add(b), a.add(a), b.add(a)]
    expectedOutput = [ComplexT(1.5, 1.5), ComplexT(2, 4), ComplexT(1.5, 1.5)]
    object_test_check("ComplexT add", calculatedOutput, expectedOutput)


def sub_check():
    calculatedOutput = [a.sub(b), c.sub(b), c.sub(a)]
    expectedOutput = [ComplexT(0.5, 2.5), ComplexT(9.5, 5.5), ComplexT(9, 3)]
    object_test_check("ComplexT sub", calculatedOutput, expectedOutput)


def mult_check():
    calculatedOutput = [a.mult(b), a.mult(c), b.mult(a)]
    expectedOutput = [ComplexT(1.5, 0.5), ComplexT(0, 25), ComplexT(1.5, 0.5)]
    object_test_check("ComplexT mult", calculatedOutput, expectedOutput)


def recip_check():
    calculatedOutput = [a.recip(), b.recip()]
    expectedOutput = [ComplexT(1.0 / (1.0 ** 2 + 2.0 ** 2), - 2.0 / (1.0 ** 2 + 2.0 ** 2)),
                      ComplexT(0.5 / (0.5 ** 2 + 0.5 ** 2), 0.5 / (0.5 ** 2 + 0.5 ** 2))]
    object_test_check("ComplexT recip", calculatedOutput, expectedOutput)


def div_check():
    calculatedOutput = [a.div(b), b.div(c)]
    x1 = (1.0 * 0.5 + 2.0 * (-0.5)) / (0.5 ** 2 + 0.5 ** 2)
    y1 = (2.0 * 0.5 - 1.0 * (-0.5)) / (0.5 ** 2 + 0.5 ** 2)
    x2 = (0.5 * 10.0 + (-0.5) * 5) / (10.0 ** 2 + 5.0 ** 2)
    y2 = (-0.5 * 10.0 - 0.5 * 5) / (10.0 ** 2 + 5.0 ** 2)
    expectedOutput = [ComplexT(x1, y1),
                      ComplexT(x2, y2)]
    object_test_check("ComplexT div", calculatedOutput, expectedOutput)


def sqrt_check():
    calculatedOutput = [a.sqrt(), b.sqrt()]
    x1 = math.sqrt((a.get_r() + a.real()) / 2)
    y1 = math.sqrt((a.get_r() - a.real()) / 2) * (a.imag() / abs(a.imag()))
    x2 = math.sqrt((b.get_r() + b.real()) / 2)
    y2 = math.sqrt((b.get_r() - b.real()) / 2) * (b.imag() / abs(b.imag()))
    expectedOutput = [ComplexT(x1, y1),
                      ComplexT(x2, y2)]
    object_test_check("ComplexT sqrt", calculatedOutput, expectedOutput)


# a = ComplexT(1.0, 2.0)
# b = ComplexT(0.5, -0.5)
# c = ComplexT(10.0, 5.0)

real_check()
imag_check()
get_r_check()
get_phi_check()
equal_check()
conj_check()
add_check()
sub_check()
mult_check()
recip_check()
div_check()
sqrt_check()

# TriangleT
t1 = TriangleT(3, 4, 5)
t2 = TriangleT(4, 3, 5)

t1Copy = TriangleT(3, 4, 5)
t3 = TriangleT(43, 32, 51)
t4 = TriangleT(24, 30, 18)
t5 = TriangleT(1, 10, 130)
t6 = TriangleT(1, 1, 1)


def get_sides_check():
    calculatedOutput = [t1.get_sides(), t2.get_sides()]
    expectedOutput = [(3, 4, 5), (4, 3, 5)]
    test_check("TriangleT get_sides", calculatedOutput, expectedOutput)


def triangle_equal_check():
    calculatedOutput = [t1.equal(t1Copy), t1.equal(t2), t2.equal(t3)]
    expectedOutput = [True, True, False]
    test_check("TriangleT equal", calculatedOutput, expectedOutput)


def perim_check():
    calculatedOutput = [t1.perim(), t2.perim(), t3.perim()]
    expectedOutput = [12, 12, 126]
    test_check("TriangleT perim", calculatedOutput, expectedOutput)


def area_check():
    calculatedOutput = [t1.area(), t2.area(), t4.area()]
    expectedOutput = [6.0, 6.0, 216.0]
    test_check("TriangleT area", calculatedOutput, expectedOutput)


def is_valid_check():
    calculatedOutput = [t1.is_valid(), t2.is_valid(), t5.is_valid()]
    expectedOutput = [True, True, False]
    test_check("TriangleT is_valid", calculatedOutput, expectedOutput)


def tri_type_check():
    calculatedOutput = [t1.tri_type(), t2.tri_type(), t3.tri_type(), t6.tri_type()]
    expectedOutput = [TriType.right, TriType.right, TriType.scalene, TriType.equilat]
    test_check("TriangleT is_valid", calculatedOutput, expectedOutput)


get_sides_check()
triangle_equal_check()
perim_check()
area_check()
is_valid_check()
tri_type_check()
