# import pandas
import pandas as pd

data = {
    "X": [1, 2, 3, 4, 5],
    "Y": [9, 8, 7, 6, 5],
    "Z": [10, 12, 8, 4, 3]
}
table = pd.DataFrame(data)

print(table)