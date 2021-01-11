import pytest
import copy
from date_adt import DateT
from pos_adt import GPosT

testDate = DateT(14, 6, 1995)
halloween = DateT(31, 10, 2019)
aprilFools = DateT(1, 4, 2019)
newYearsEve = DateT(31, 12, 2019)
newYears = DateT(1, 1, 2020)

testPos = GPosT(50.4, -114.7)
testPos2 = GPosT(-78.2, 24.0)

def test_day():
  expectedDay = 14
  assert testDate.day() == expectedDay

def test_month():
  expectedMonth = 6
  assert testDate.month() == expectedMonth

def test_year():
  expectedYear = 1995
  assert testDate.year() == expectedYear

def test_next():
  expectedTomorrow = DateT(15, 6, 1995)
  assert testDate.next().equal(expectedTomorrow)

def test_prev():
  expectedYesterday = DateT(13, 6, 1995)
  assert testDate.prev().equal(expectedYesterday)

def test_before_before():
  assert testDate.before(halloween)

def test_before_after():
  assert not halloween.before(aprilFools)

def test_after_after():
  assert halloween.after(aprilFools)

def test_after_before():
  assert not halloween.after(newYearsEve)

def test_equal_equal():
  assert testDate.equal(testDate)

def test_equal_before():
  assert not halloween.equal(testDate)

def test_add_days_5():
  expectedFuture = DateT(19, 6, 1995)
  assert testDate.add_days(5).equal(expectedFuture)

def test_days_between_before():
  expectedDays1 = 1
  expectedDays2 = 0
  days = newYears.days_between(newYearsEve)
  assert days == expectedDays1 or days == expectedDays2

def test_lat():
  expectedLat = 50.4
  assert testPos.lat() == expectedLat

def test_long():
  expectedLong = -114.7
  assert testPos.long() == expectedLong

def test_west_of_west():
  assert testPos.west_of(testPos2)

def test_west_of_east():
  assert not testPos2.west_of(testPos)

def test_north_of_north():
  assert testPos.north_of(testPos2)

def test_north_of_south():
  assert not testPos2.north_of(testPos)

def test_distance_nonzero():
  assert testPos.distance(testPos2) == pytest.approx(16510, rel=1e-1)

def test_equal_equalPos():
  assert testPos.equal(testPos)

def test_equal_far():
  assert not testPos.equal(testPos2)

def test_move_somewhere():
  testPosCopy = copy.deepcopy(testPos)
  testPosCopy.move(45, 500)
  assert testPosCopy.lat() == pytest.approx(53, rel=1e-1) and \
    testPosCopy.long() == pytest.approx(-109, rel=1e-1)

def test_arrival_date():
  expectedDate1 = DateT(30, 6, 1995)
  expectedDate2 = DateT(1, 7, 1995)
  date = testPos.arrival_date(testPos2, testDate, 1000)
  assert date.equal(expectedDate1) or date.equal(expectedDate2)
  
