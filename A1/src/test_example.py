# Sample tests for minimal experiments with the ADT interfaces

a = ComplexT(1.0, 2.0)
b = ComplexT(0.5, -0.5)
c = a.add(b)
if (not((aprx_eq(c.real(), 1.5) and (aprx_eq(c.imag(), 1.5))))):
   print("add test FAILS")
else:
   print("add test passes")

def aprx_eq(a, b):
   return (a - b)/a <= 0.00001
