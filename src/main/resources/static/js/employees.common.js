/**
 * Абстрактный класс, с общими методами для работы с таблицами.
 * С помощью данного класса можно создавать независимые таблицы,
 * легко манипулируя их данными с помощью этого класса.
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
function makeEditable(datatableOpts) {
    ctx.datatableApi = $("#datatable").DataTable(
        $.extend(true, datatableOpts, {
            // serverSide: true,
            "ajax": {
                // type:"POST",
                "url": employeeAjaxUrl,
                "dataSrc": ""
            },
            // "displayStart":1,
            "info": true
        })
    )
    form = $('#detailsForm')

    /**
     * В случае, если произойдет какая-либо ошибка в любом аякс-запросе,
     * то сработает данный обработчик.
     */
    $(document).ajaxError(function (event, jqXHR, options, jsExc) {
        failNoty(jqXHR)
    })
}


function renderEditBtn(data, type, row) {
    if (type === "display") {
        return "<a onclick='updateRow(" + row.id + ")'>Edit</a>"
    }
}

function renderDeleteBtn(data, type, row) {
    if (type === "display") {
        return "<a onclick='deleteRow(" + row.id + ")'>Delete</a>"
    }
}

/**
 * Метод перерисовывает таблицу из данных, взятых из переданного
 * параметра @param data
 */
function updateTableByData(data){
    ctx.datatableApi.clear().rows.add(data).draw()
}

/**
 * Метод открывает форму редактирования работника с переданным id в
 * качестве параметра: @param id и заполняет форму существующими данными
 * работника.
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
 * параметрах: @param id.
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
 * Метод открывает форму для добавления нового работника
 */
function add() {
    form.find(":input").val("")
    $("#editRow").modal()
}

/**
 * Метод сохраняет отредактированного или нового работника, а
 * также закрывает окно редактирования, и затем обновляет таблицу.
 */
function save() {
    //подставить значение из формы
    id = form.find("#id")
    $.ajax({
        type: "POST",
        url: employeeAjaxUrl,
        data: form.serialize()
    }).done(function (){
        sendReq()
        $("#editRow").modal("hide")
        ctx.updateTable()
        successNoty("Успешно!")
    })
}

var failedNote

//TODO: create description
function closeNoty() {
    if (failedNote) {
        failedNote.close()
        failedNote = undefined
    }
}

//TODO: create description
function successNoty(key) {
    closeNoty()
    new Noty({
        text: "<span class='fa fa-lg fa-check'></span> &nbsp" + key,
        type: 'success',
        layout: "bottomRight",
        timeout: 1000
    }).show()
}

//TODO: create description
function failNoty(jqXHR) {
    closeNoty()
    var errorInfo = jqXHR.responseJSON
    failedNote = new Noty({
        text:"<span class='fa fa-lg fa-exclamation-circle'></span> &nbsp;" + errorInfo.typeMessage + "<br>",
        type: "error",
        layout: "bottomRight"
    }).show()
}