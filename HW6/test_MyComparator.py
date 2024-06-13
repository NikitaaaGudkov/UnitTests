import unittest
from unittest import TestCase

import pytest

from MyComparator import MyComparator


class TestMyComparator(TestCase):

    def test_get_medium_value(self):
        # Подаём обычный список чисел
        self.assertEqual(2, MyComparator.get_medium_value([1, 2, 3]))
        # Подаём список чисел с одним элементом
        self.assertEqual(5, MyComparator.get_medium_value([5]))
        # Подаём пустой список
        with pytest.raises(ValueError):
            MyComparator.get_medium_value([])
        # Подаём НЕ список чисел
        with pytest.raises(TypeError):
            MyComparator.get_medium_value('string')
        # Подаём НЕ список
        with pytest.raises(TypeError):
            MyComparator.get_medium_value(['1', '2', '3'])

    def test_my_compare(self):
        list_a = [1, 2, 3]
        list_b = [4, 5, 6]
        list_c = [4, 5, 6]
        param_list = [(list_a, []), ([], list_b), ([], [])]
        # Подаём два списка целых чисел, среднее значение первого больше,
        # чем среднее значение второго
        self.assertEqual('Первый список имеет большее среднее значение',
                         MyComparator.my_compare(list_b, list_a))
        # Подаём два списка целых чисел, среднее значение второго больше,
        # чем среднее значение первого
        self.assertEqual('Второй список имеет большее среднее значение',
                         MyComparator.my_compare(list_a, list_b))
        # Подаём два списка целых чисел, средние значения которых равны
        self.assertEqual('Средние значения равны',
                         MyComparator.my_compare(list_b, list_c))
        # Подаём два списка, содержащие целые числа и отсутствие элементов в
        # различных сочетаниях
        for p1, p2 in param_list:
            with pytest.raises(ValueError):
                MyComparator.my_compare(p1, p2)


if __name__ == '__main__':
    unittest.main()
