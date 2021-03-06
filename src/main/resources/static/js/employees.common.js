/**
 * Абстрактный класс, с общими методами для работы с таблицами.
 * С помощью методов данного класса, можно создавать независимые таблицы,
 * легко манипулируя их данными.
 */

/**
 * Переменная формы, видна для всех методов, в ней хранятся
 * данные из формы редактирования таблицы (создания или редактирования
 * новой строки). Инициализируется при отрисовке таблицы.
 */
var form

/**
 * Данный метод является родителем для создания таблиц. Метод содержит
 * в себе общие настройки для создания таблиц.
 * @param datatableOpts - параметр, который содержит в себе остальные
 * параметры, которые для каждой таблицы индивидуальны. Например,
 * содержание колонок (параметр columns[]).
 */
function makeEditable(url, datatableOpts) {
    ctx.datatableApi = $("#datatable").DataTable(
        $.extend(true, datatableOpts, {
            processing: true,
            serverSide: true,
            "ajax": {
                url: url,
                "data": function (d) {
                    return $.extend({}, d, {
                        "search": JSON.stringify(getFormData($('.header')))
                    })
                },
            },
            "info": true,
            "searching": false,
        })
    )
    form = $('#detailsForm');

    /**
     * В случае, если произойдет какая-либо ошибка в любом аякс-запросе,
     * то сработает данный обработчик.
     */
    $(document).ajaxError(function (event, jqXHR, options, jsExc) {
        failNoty(jqXHR)
    })
}

$(document).ready(function () {
    $('.header').bind("keyup change", function () {
        ctx.datatableApi.draw()
    })
})

/**
 * Глобальная переменная с информацией об ошибке.
 * Значение устанавливается в методе failNoty(jqXHR)
 */
var failedNote

/**
 * Установка значения переменной failedNote и показ ошибки.
 * @param jqXHR - данные об ошибке
 */
function failNoty(jqXHR) {
    closeNoty()
    var errorInfo = jqXHR.responseJSON
    failedNote = new Noty({
        text: "<span class='fa fa-lg fa-exclamation-circle'></span> &nbsp" + errorInfo.typeMessage + "<br>",
        type: "error",
        layout: "bottomRight"
    }).show()
}

/**
 * Закрывает всплывающее уведомление.
 */
function closeNoty() {
    var el = document.getElementById('detailsForm')
    if (el.hasAttribute('value')) {
        $('#detailsForm').attr('value', '')
    }
    restoreColors()
    removeModalXlClass()
    if (failedNote) {
        failedNote.close()
        failedNote = undefined
    }
}

/**
 * Показывает уведомление об успешном выполнении операции. Текст
 * с информацией передается в параметре @param key
 */
function successNoty(key) {
    closeNoty()
    new Noty({
        text: "<span class='fa fa-lg fa-check'></span> &nbsp" + key,
        type: 'success',
        layout: "bottomRight",
        timeout: 1000
    }).show()
}

/**
 * Метод отрисовки кнопки Edit.
 * Параметры взяты из метода DataTables columns.render.
 * https://datatables.net/manual/data/renderers
 * @param data - данные о строке
 * @param type
 * @param row - объект изменяемой строки
 * @returns {string}
 */
function renderEditBtn(data, type, row) {
    if (type === "display") {
        return "<a onclick='updateRow(" + row.id + ")'><span class='fa fa-pencil'></span></a>"
    }
}

/**
 * Метод отрисовки кнопки Delete.
 * Параметры взяты из метода DataTables columns.render.
 * https://datatables.net/manual/data/renderers
 * @param data - данные о строке
 * @param type
 * @param row - объект изменяемой строки
 * @returns {string}
 */
function renderDeleteBtn(data, type, row) {
    if (type === "display") {
        return "<a onclick='deleteRow(" + row.id + ")'><span class='fa fa-remove'></span></a>"
    }
}

/**
 * Метод отрисовки кнопки History.
 * Параметры взяты из метода DataTables columns.render.
 * https://datatables.net/manual/data/renderers
 * @param data - данные о строке
 * @param type
 * @param row - объект изменяемой строки
 * @returns {string}
 */
function renderHistoryBtn(data, type, row) {
    if (type === "display") {
        return "<button onclick='showHistory(" + row.id + ")' type='button'  data-toggle='modal' data-target='#historyModal'><span class='fa fa-history'></span></button>"
    }
}

function showHistory(id) {
    var newId
    if (id == '') {
        newId = $('#detailsForm').attr('value')
    } else {
        newId = id
    }
    var el = document.getElementById('modalDialog')
    el.classList.add("modal-xl")
    $.ajax({
        type: "GET",
        url: historyAjaxUrl + newId,
        success: function (data) {
            historyCtx.datatableApi.clear().rows.add(data).draw();
        }
    })

}


/**
 * Метод открывает форму редактирования работника с переданным id в
 * качестве параметра @param id и заполняет форму уже существующими
 * данными работника.
 */
function updateRow(id) {
    $('#detailsForm').attr('value', id)
    form.find(":input").val("")
    $.get(ctx.ajaxUrl + id, function (data) {
        $.each(data, function (key, value) {
            form.find("input[name='" + key + "']").val(value)
        })
        $("#editRow").modal()
    })
}

/**
 * Метод для обозначения того, что кто-то изменил редактируемую
 * в текущий момент запись.
 * @param updatedEmployee
 */
function pushChanges(updatedEmployee) {
    var el = document.getElementById('detailsForm')
    if (el.hasAttribute('value')) {
        if (el.getAttribute('value') == (updatedEmployee.id)) {
            $.get(ctx.ajaxUrl + updatedEmployee.id, function (data) {
                $.each(data, function (key, value) {
                    document.getElementById(key).classList.add("bg-success", "text-light")
                })
            })
        }
    }
}

/**
 * Метод удаляет строку с требуемым id, который передается в
 * параметре @param id.
 */
function deleteRow(id) {
    if (confirm("Вы уверены?")) {
        $.ajax({
            type: "DELETE",
            url: ctx.ajaxUrl + id,
            success: function (data) {
                sendDeleteReq(id)
                successNoty("Удалено.")
            }
        })
    }
}

/**
 * Метод открывает модальное окно для добавления нового работника
 */
function add() {
    form.find(":input").val("")
    $("#editRow").modal()
}

/**
 * Метод сохраняет отредактированного или нового работника, а
 * также закрывает окно редактирования, затем обновляет таблицу,
 * и показывает уведомление об успешном изменении.
 */
function save() {
    $.ajax({
        type: "POST",
        url: employeeAjaxUrl,
        dataType: 'json',
        contentType: 'application/json',
        data: JSON.stringify(getFormData(form)),
        success: function (data) {
            $("#editRow").modal("hide")
            successNoty("Успешно!")
            $('#detailsForm').attr("value", "")
            restoreColors()
            removeModalXlClass()
            sendSaveReq(data)
        }
    })
}

/**
 * Вспомогательный метод, для восстановления стилей
 */
function restoreColors() {
    var inputId = document.getElementsByTagName('input')
    for (let i = 0; i < inputId.length; i++) {
        if (inputId.item(i).hasAttribute("class")) {
            inputId.item(i).classList.remove("bg-success", "text-light")
        }
    }
}
/**
 * Вспомогательный метод, для восстановления стилей
 */
function removeModalXlClass() {
    var el = document.getElementById('modalDialog')
    if (el.classList.contains("modal-xl")) {
        el.classList.remove("modal-xl")
    }
}

/**
 * Утилитный метод. Преобразовывает данные из формы в формат JSON,
 * для дальнейшей передачи объекта из формы в Rest Controller для сохранения
 * или обновления
 * @param form - глобальная переменная формы с данными о добавляемом/изменяемом сотруднике.
 * @returns массив с данными в формате JSON.
 */
function getFormData(form) {
    var unindexed_array = form.serializeArray()
    var indexed_array = {}

    $.map(unindexed_array, function (n, i) {
        indexed_array[n['name']] = n['value']
    })

    return indexed_array
}