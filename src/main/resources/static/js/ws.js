/**
 * В данном классе расположена логика работы вебсокета. Сразу же
 * после загрузки страницы происходит создание коннекта и отрисовка
 * таблицы.
 */

var stompClient = null

$(function () {
    connect()
    drawTable()
})

/**
 * Создание нового сокета с подпиской на топик, необходимый для обновления таблицы.
 */
function connect() {
    var socket = new SockJS('/employees')
    stompClient = Stomp.over(socket)
    stompClient.connect({}, function (frame) {
        console.log('Connected: ' + frame)

        stompClient.subscribe('/topic/updateTable', update => {
            ctx.datatableApi.ajax.reload(null, false)
        })

        stompClient.subscribe('/topic/edit', edit => {
            checkIfEdit(JSON.parse(edit.body).id)
        })
    })
}

/**
 * Создание запроса серверу с той целью, чтобы обновить таблицу. Запрос происходит
 * в методах сохранения (employees.common.js#save()) и удаления (employees.common.js#delete())
 * записей в таблице.
 */
function sendSaveReq(request) {
    stompClient.send("/app/requestForUpdate", {}, JSON.stringify(request))
}

function sendDeleteReq(request) {
    stompClient.send("/app/requestForUpdate", {}, JSON.stringify(request))
}

function sendEditReq(id) {
    stompClient.send("/app/requestForEdit", {}, JSON.stringify({"id": id}))
}


