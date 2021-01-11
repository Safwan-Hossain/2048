## @file complex_adt.py
#  @author 
#  @brief 
#  @date 

import math

## @brief 
#  @details 

class ComplexT:

  ## @brief 
  #  @details 
  #  @param 
  #  @param 
  def __init__(self, x, y):
    self.x = x
    self.y = y
    
  ## @brief 
  #  @return 
  def real(self):
    return self.x

  ## @brief 
  #  @return 
  def imag(self):
    return self.y

  ## @brief 
  #  @return 
  def get_r(self):
    return math.sqrt(self.x*self.x + self.y*self.y)

  def get_phi(self):
    return 0.0 #FIXME

  def equals(self, c):
    return (self.x == c.real()) and (self.y == c.imag())

  def conj(self):
    return ComplexT(self.x, self.y) #FIXME

  ## @brief 
  #  @return 
  def add(self, a):
    return ComplexT(self.x + a.real(), self.y + a.imag())

  def sub(self, a):
    return ComplexT(self.x - a.real(), self.y - a.imag())

  def mult(self, a):
    return ComplexT(self.x - a.real(), self.y - a.imag()) #FIXME

  def recip(self):
    return ComplexT(self.x, self.y) #FIXME

  def div(self, a):
    return ComplexT(self.x - a.real(), self.y - a.imag()) #FIXME

  def sqrt(self):
    return ComplexT(self.x, self.y) #FIXME

