#Program based on to check whether the day is hot or cold

temperature = int(input("Current temperatue:  "))

if temperature > 30:
    print("Day is hot")
elif temperature < 30:
    if temperature <= 0:
        print("Too cold")
    else:
        print("Day is cold")
