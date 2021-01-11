## @file triangle_adt.py
#  @author 
#  @brief 
#  @date 

from enum import Enum, auto
from itertools import permutations

class TriType(Enum):
    equilat = auto()
    isosceles = auto()
    scalene = auto()
    right = auto()

## @brief 
#  @details 

class TriangleT:

  ## @brief 
  #  @details 
  #  @param 
  #  @param 
  def __init__(self, a, b, c):
    self.s = (a, b, c)

  def get_sides(self):
    return self.s

  def equals(self, t):
    perm = permutations(t.get_sides())
    return (self.s in list(perm))

  def perim(self):
    return 1 #FIXME

  def area(self):
    return 1.0 #FIXME

  def is_valid(self):
    return False #FIXME

  def tri_type(self):
    return TriType.right #FIXME
