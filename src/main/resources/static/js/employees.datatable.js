/**
 * Глобальная переменная, адрес к ресурсам Rest контроллера.
 * @type {string}
 */
var employeeAjaxUrl = "rest/"

/**
 * Глобальная переменная, инициализируется каждый раз во время отрисовки таблицы,
 * с учетом фильтра по полям. При каждой инициализации перерисовывает таблицу.
 * @type {{ajaxUrl: string, updateTable: ctx.updateTable}}
 */
var ctx = {
    ajaxUrl: employeeAjaxUrl,
    updateTable: function () {
        $.ajax({
            type: "GET",
            url: employeeAjaxUrl + "filter",
            data: $("#filter").serialize()
        }).done(updateTableByData)
    }
}

/**
 * Создание таблицы. Отрисовка кнопок редактирования и удаления происходит
 * в общем для всех таблиц файле (employees.common.js).
 * Основная конфигурация (источник данных, пагинация) расположена в
 * файле (employees.common.js)
 */
function drawTable() {
    makeEditable({
        "columns": [
            {"data": "name"},
            {"data": "lastname"},
            {"data": "email"},
            {"data": "phoneNumber"},
            {
                "defaultContent": "",
                "orderable": false,
                "render": renderEditBtn
            },
            {
                "defaultContent": "",
                "orderable": false,
                "render": renderDeleteBtn
            }
        ]
    })
}

/**
 * Очищает фильтр и перерисовывает таблицу.
 */
function clearFilter() {
    $("#filter")[0].reset()
    $.get(employeeAjaxUrl, updateTableByData)
}
