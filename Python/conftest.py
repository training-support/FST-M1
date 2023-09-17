import pytest


# Create fixture
@pytest.fixture
def num_list():
    # Create list
    list = [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]

    # Alternatively
    # list = list(range(11))

    return list
