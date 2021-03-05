## @file SeqServicesLibrary.py
#  @author Safwan Hossain, Hossam18, 400252391 
#  @brief Library module that provides functions for working with sequences
#  @details This library assumes that all functions will be provided with arguments of the expected types
#  @date 03/04/2021

def max_val(s):
    if len(s) == 0:
        raise ValueError("List is empty")

    m = 0
    for x in s:
        if m < abs(x):
            m = abs(x)

    return m


def count(t, s):
    if len(s) == 0:
        raise ValueError("List is empty")

    sum = 0
    for x in s:
        if x == t:
            sum += 1

    return sum


def spices(s):
    if len(s) == 0:
        raise ValueError("List is empty")

    return ["nutmeg" if x <= 0 else "ginger" for x in s]


def new_max_val(s, f):
    if len(s) == 0:
        raise ValueError("List is empty")

    return max_val([x if f(x) else False for x in s])

