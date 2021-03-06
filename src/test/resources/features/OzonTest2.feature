#language: ru

Функционал: Покупка

  @scenario2 @all
  Сценарий: Выбор и добавление товаров в корзину

    * выполнен поиск по наименованию "беспроводные наушники"
    * поле "Максимальная цена" ограничено до "10000"
    * выбраны чекбоксы "Beats", "Samsung"
    * в корзину добавлены все "четные" товары и выполнен переход в корзину
    * Купленные товары
    * проверено наличие товаров
    * выполнено нажатие на кнопку "удалить выбранные"
    * проверено, что поле "Корзина" имеет значение "Корзина пуста"