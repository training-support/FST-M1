import pytest

def test_sum(num_list):
 
    # Initialize sum
    sum = 0
 
    # Add number in the list
    for n in num_list:
        sum += n
 
    # Assertion
    print(sum) 
    assert sum == 55