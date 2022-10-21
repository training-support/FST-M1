# Import pandas
import pandas

data = {
    "Usernames": ["admin", "Charles", "Deku"],
    "Passwords": ["password", "Charl13", "AllMight"]
}

dataframe = pandas.DataFrame(data)

# Print the DataFrame
print(dataframe)

dataframe.to_csv("sample.csv", index=False)