"""
How old are you in number of days? It's easy to calculate - just subtract your birthday from today. We could make this a real challenge though and count the difference between any dates.
You are given two dates as tuples with three numbers - year, month and day. For example: 19 April 1982 will be (1982, 4, 19). You should find the difference in days between the given dates. For example between today and tomorrow = 1 day. The difference will always be either a positive number or zero, so don't forget about absolute value.
Input: Two dates as tuples of integers.
Output: The difference between the dates in days as an integer.
Precondition: Dates between 1 january 1 and 31 december 9999. Dates are correct.
"""

import datetime

def days_diff(date1, date2):
    """
        Find absolute diff in days between dates
    """
    days = abs((datetime.datetime(*date2) - datetime.datetime(*date1)).days)
    return days

if __name__ == '__main__':
    #These "asserts" using only for self-checking and not necessary for auto-testing
    assert days_diff((1982, 4, 19), (1982, 4, 22)) == 3
    assert days_diff((2014, 1, 1), (2014, 8, 27)) == 238
    assert days_diff((2014, 8, 27), (2014, 1, 1)) == 238
