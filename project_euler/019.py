from math import ceil


def main():
    DAYS_PER_WEEK = 7
    years = 2000 - 1900
    months = years * 12
    return ceil(months / DAYS_PER_WEEK)


if __name__ == "__main__":
    print main()
