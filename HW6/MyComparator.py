from typing import List


class MyComparator:
    @staticmethod
    def get_medium_value(numbers: List[int]) -> float:
        if not isinstance(numbers, list):
            raise TypeError('В метод нужно передать список')
        if not numbers:
            raise ValueError('Список пуст')
        try:
            return sum(numbers) / len(numbers)
        except TypeError:
            raise TypeError('В списке должны находиться целые числа')

    @staticmethod
    def my_compare(firstList: List[int], secondList: List[int]) -> str:
        first_medium_value = MyComparator.get_medium_value(firstList)
        second_medium_value = MyComparator.get_medium_value(secondList)
        if first_medium_value > second_medium_value:
            return 'Первый список имеет большее среднее значение'
        elif first_medium_value < second_medium_value:
            return 'Второй список имеет большее среднее значение'
        else:
            return 'Средние значения равны'
