# Each new term in the Fibonacci sequence is generated by adding the previous
# two terms. By starting with 1 and 2, the first 10 terms will be:
# 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
# Find the sum of all the even-valued terms in the sequence which do not
# exceed four million.

def fibonacci():
    one = 0
    two = 1
    step = 1

    while True:
        one, two = two, one + two
        yield two
        step += 1

def calculate(limit):
    result = 0
    for value in fibonacci():
        if value > limit:
            break

        if value % 2 == 0:
            result += value

    return result

def print_result():
    print calculate(4000000)

if __name__ == '__main__':
    print_result()
