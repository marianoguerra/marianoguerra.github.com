import math

def factors(value):
    factors = []
    factor = 2.0
    new_value = value
    val_sqrt = math.sqrt(value)

    while factor < val_sqrt:
        if new_value % factor == 0:
            factors.append(factor)
            #new_value /= factor

        factor += 1

    return factors

def calculate(value):
    return factors(value)[-1]

def print_results():
    print calculate(600851475143)

if __name__ == '__main__':
    print_results()
