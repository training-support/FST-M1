import pytest
@pytest.fixture
def wallet_amount():
    amount =0
    return amount

@pytest.mark.parametrize("earn, spent, expected", [(100,80,20), (30,25,5),])
def test_transactions(wallet_amount,earn,spent,expected):
    wallet_amount +=earn

    wallet_amount -=spent

    assert wallet_amount == expected
