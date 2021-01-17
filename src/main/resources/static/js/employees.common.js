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
function makeEditable(datatableOpts, page) {
    ctx.datatableApi = $("#datatable").DataTable(
        $.extend(true, datatableOpts, {
            "ajax": {
                "url": employeeAjaxUrl+"?page="+page,
                "dataSrc": ""
            },
            "info": true,
            paging:false
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

/**
 * Глобальная переменная с информацией об ошибке.
 * Значение устанавливается в методе failNoty(jqXHR)
 */
var failedNote

/**
 * Установка значения переменной failedNote и показ ошибки.
 * Данные об ошибке переданы в параметре @param jqXHR
 */
function failNoty(jqXHR) {
    closeNoty()
    var errorInfo = jqXHR.responseJSON
    failedNote = new Noty({
        text:"<span class='fa fa-lg fa-exclamation-circle'></span> &nbsp;" + errorInfo.typeMessage + "<br>",
        type: "error",
        layout: "bottomRight"
    }).show()
}

/**
 * Закрывает всплывающее уведомление.
 */
function closeNoty() {
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
 * Перерисовывает таблицу из данных, взятых из переданного
 * параметра @param data
 */
function updateTableByData(data){
    var totalNumberOfEmployees = ()=>{

    }
    ctx.datatableApi.clear().rows.add(data).draw()
}

/**
 * Метод открывает форму редактирования работника с переданным id в
 * качестве параметра @param id и заполняет форму уже существующими
 * данными работника.
 */
function updateRow(id) {
    form.find(":input").val("")
    $.get(ctx.ajaxUrl + id, function (data){
        $.each(data, function (key, value){
            form.find("input[name='"+ key +"']").val(value)
        })
        $("#editRow").modal()
    })
}

/**
 * Метод удаляет строку с требуемым id, который передается в
 * параметре @param id.
 */
function deleteRow(id) {
    if (confirm("Вы уверены?")) {
        $.ajax({
            type: "DELETE",
            url: ctx.ajaxUrl + id
        }).done(function (){
            sendReq()
            ctx.updateTable()
            successNoty("Удалено.")
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
        data: JSON.stringify(getFormData(form))
    }).done(function (){
        sendReq()
        $("#editRow").modal("hide")
        ctx.updateTable()
        successNoty("Успешно!")
    })
}

/**
 * Утильный метод. Преобразовывает данные из формы в формат JSON,
 * для дальнейшей передачи объекта из формы в Rest Controller для сохранения
 * или обновления
 * @param form - глобальная переменная формы с данными о добавляемом/изменяемом сотруднике.
 * @returns массив с данными в формате JSON.
 */
function getFormData(form){
    var unindexed_array = form.serializeArray();
    var indexed_array = {};

    $.map(unindexed_array, function(n, i){
        indexed_array[n['name']] = n['value'];
    });

    return indexed_array;
}

function previousPage(){

}

function nextPage(){

}

function toPage(event){
    event.preventDefault() //для того, чтобы не осуществлялось обновление страницы
    var i = document.getElementById("pageNumber").value
    console.log(i)
    // document.getElementById("pageNumber").value = "" //для стирания значения поля
    ctx.updateTable()
}

function pagination(){

}