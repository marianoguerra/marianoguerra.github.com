
NUMS = [float(x) for x in range(11, 19)]
NUMS.reverse()

def first_multiple_from_1_to_20():
    num = 380

    while True:
        for x in NUMS:
            if num % x != 0:
                break
        else:
            return num

        num += 380

num = first_multiple_from_1_to_20()

print num
