import pytest

# Create fixture
@pytest.fixture
def num_list():

    # Create list
    list = [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]

    # Alternatively
    # list = list(range(11))

    return list

# Write test method
def test_sum(num_list):

    # Initialize sum
    sum = 0

    # Add number in the list
    for n in num_list:
        sum += n

    # Assertion
    assert sum == 11