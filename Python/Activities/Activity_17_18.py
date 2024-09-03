import pandas as pd

# Create a Dictionary that will hold our data
data = {
    "Usernames": ["admin", "Charles", "Deku"],
    "Passwords": ["password", "Charl13", "AllMight"]
}

# Create a DataFrame using that data
df = pd.DataFrame(data)

# Print the DataFrame
print(df)

"""
 Write the DataFrame to a CSV file
 To avoid writing the index numbers to the file as well
 the index property is set to false
"""
df.to_csv("../inputs/creds.csv", index= False)


# Read the CSV file and store it into a DataFrame
creds = pd.read_csv("../inputs/creds.csv")

# Print the full data
print("Full Data: ")
print(creds)

# Print the values in the Usernames column only
print("===============")
print("Usernames:")
print(creds["Usernames"])

# Print the username and password of the second row
print("===============")
print("Username: ", creds["Usernames"][1], " | ", "Password: ", creds["Passwords"][1])

#Sort the Usernames column in ascending order
print("====================================")
print("Data sorted in ascending Usernames:")
print(creds.sort_values('Usernames'))

#Sort the Passwords column in descending order
print("====================================")
print("Data sorted in descending Passwords:")
print(creds.sort_values('Passwords', ascending=False))