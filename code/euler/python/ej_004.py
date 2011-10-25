
def is_palindromic(number):
    '''return True if the number is a palindrome'''
    number = str(number)
    return number == number[::-1]

def get_largest_palindrome():
    '''get the largest 3  digit palindrome'''
    temp = 0

    for i in range(999, 0, -1):
        for j in range(i, 0, -1):
            value = i * j
            if is_palindromic(value):
                if temp < value:
                    temp = value

    return temp

print get_largest_palindrome()

