import csv

def main():
    with open('./lab2/AIRLINES/airports.csv') as csv_file:
        csv_reader = csv.reader(csv_file, delimiter=',')
        line = 0
        for row in csv_reader:
            if line > 0:
                if len(row) == 5:
                    print(f"INSERT INTO airports(CITY, AirportCode, AirportName, Country, CountryAbbrev) VALUES(\"{row[0]}\", \"{row[1]}\", \"{row[2]}\", \"{row[3]}\", \"{(row[4].strip())}\")")

            line = line + 1


if __name__ == "__main__":
    main()
