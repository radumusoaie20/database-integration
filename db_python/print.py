def fixed_print(text, width, fillChar):
    l = len(text)
    if l > width:
        print(text[:width], end= "")
    else:
        print(text, end="")
        remaining = width - l + 1
        for i in range(1, remaining):
            print(fillChar, end="")
