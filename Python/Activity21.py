import pytest

num1=30
num2=14

def test_addtional():
    
    total = num1 + num2
    assert total == 44

def test_subtraction():
    remainer = num1 - num2
    assert remainer == 16

def test_multiplication():
    product = num1 * num2
    assert product == 420

def test_division():
    quotiont = num1/num2
    assert quotiont == 1.4
