def calc(start, stop):
    return sum(xrange(start, stop + 1)) ** 2 - sum(map(lambda x: x**2,
        xrange(start, stop + 1)))

print calc(1, 100)

