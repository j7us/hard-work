В данном проекте были реализованы две небольшие задачи, которые я делал вчера на проекте, код был немного упращен.
Обе задачи представляли собой добавление нового сохранения или вызова и небольшое изменение логики работы функции.

Первая задача это промежуточный шаг для отказа от онлайн подсчета рейтинга магазина по отзывам, мы добавили новую таблицу
и теперь нам временно все еще надо подсчитывать онлайн, но уже сохранять и в свою базу, также внешний сервис теперь хочет
получать именно средний отзыв по всему магазину.

основной класс здесь [CalculateAndSendRating](src/main/java/org/example/calculate/CalculateAndSendRating.java)

тесты:
[CalculateTest.addNewTableSaveRatingTest()](src/test/java/org/example/calculate/CalculateTest.java#L36)
[CalculateTest.saveFullRatingInNewTableTest()](src/test/java/org/example/calculate/CalculateTest.java#L46)
[CalculateTest.sendAvgRatingToKafkaOutboxTest()](src/test/java/org/example/calculate/CalculateTest.java#L59)

Вторая задача изменение поиска товаров по критериям. Теперь в репозиторий передается список критериев, дополнительно
выполняется поиск товаров во внешнем сервисе. Результаты двух источников объединяются, группируются по типу товара
и возвращаются без дубликатов.

основной класс здесь [FindItemsByCriteria](src/main/java/org/example/criteria/FindItemsByCriteria.java)

тесты:
[FindItemsByCriteriaTest.orderItemsRepositoryFindByCriteriaListTest()](src/test/java/org/example/criteria/FindItemsByCriteriaTest.java#L37)
[FindItemsByCriteriaTest.itemsGroupedByMapMapTest()](src/test/java/org/example/criteria/FindItemsByCriteriaTest.java#L47)
[FindItemsByCriteriaTest.itemsFromMarketTest()](src/test/java/org/example/criteria/FindItemsByCriteriaTest.java#L62)
[FindItemsByCriteriaTest.groupOnlyUniqueItemsTest()](src/test/java/org/example/criteria/FindItemsByCriteriaTest.java#L72)


Я старался делать тест под каждый следующий шаг в стиле добавления нового вызова или изменения логики функции, таким образом заметил,
что куда больше думаешь над каждым шагом в добавлении логики, но тратится прям сильно больше времени из-за непривычки в формате работы. Старым
способом мои тесты были написаны более цельно, чаще они проверяли сразу готовый флоу, не разделяя на проверки отдельных шагов
внутри самой функции. В рабочем коде раньше я делал комиты только когда задача была закончена или когда внутри себя задача разделялась
еще на несколько этапов, сейчас с агентами выполняю после 1-2 итераций агента.
