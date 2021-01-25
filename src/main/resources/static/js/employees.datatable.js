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
}

/**
 * Создание таблицы. Отрисовка кнопок редактирования и удаления происходит
 * в общем для всех таблиц файле (employees.common.js).
 * Основная конфигурация (источник данных, пагинация) расположена в
 * файле (employees.common.js)
 */
function drawTable() {
    makeEditable("", employeeAjaxUrl,{
        "columns": [
            {
                "data": "name",
                "searchable": true
            },
            {
                "data": "lastname",
                "searchable": true
            },
            {
                "data": "email",
                "searchable": true
            },
            {
                "data": "phoneNumber",
                "searchable": true
            },
            {
                "defaultContent": "",
                "orderable": false,
                "render": renderHistoryBtn
            },
            {
                "defaultContent": "",
                "orderable": false,
                "render": renderEditBtn
            },
            {
                "defaultContent": "",
                "orderable": false,
                "render": renderDeleteBtn
            },
        ]
    })
}