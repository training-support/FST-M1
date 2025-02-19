# Given list of numbers
num_list= list(input("Enter a sequence of comma separated values: ").split(","))
	
print("Given list is ", num_list)

# Get first element in list
firstElement = num_list[0]
# Get last element in list
lastElement = num_list[-1]
# Check if first and last element are equal
	
if (firstElement == lastElement):
    print("The values are same")
else:
    print("The values are not same")

