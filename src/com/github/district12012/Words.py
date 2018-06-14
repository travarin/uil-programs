def main():
    f = open("words.dat", "r")

    names = int(f.read(1))
    lines = f.readlines()
    for i in range(1, names+1):
        line = lines[i]
        name = line.split()
        result = name[0]
        for x in name[1:]:
            result += " " + x[0]
        print (result)


if __name__ == "__main__":
  main()