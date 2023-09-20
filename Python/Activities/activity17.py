import pandas
from pandas.tests.frame.test_validate import dataframe

data = {
     "username":["admin","Charles","Deku"],
     "password":["password","Charl13","AllMight"]
}
dataframe = pandas.DataFrame(data)
print(dataframe)

dataframe.to_csv("lakshmi.csv",index=False)


