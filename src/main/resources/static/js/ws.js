/**
 * В данном классе расположена логика работы вебсокета. Сразу же
 * после загрузки страницы происходит создание коннекта и отрисовка
 * таблицы.
 */

let stompClient = null

$(function () {
    connect()
    drawTable()
    drawHistoryTable()
})

/**
 * Создание нового сокета с подпиской на топики, необходимые для обновления таблицы.
 */
function connect() {
    var socket = new SockJS('/employees')
    stompClient = Stomp.over(socket)
    stompClient.connect({}, function (frame) {
        console.log('Connected: ' + frame)

        stompClient.subscribe('/topic/updateTable', updatedEmployee => {
            ctx.datatableApi.ajax.reload(null, false)
            showHistory(JSON.parse(updatedEmployee.body).id)
            pushChanges(JSON.parse(updatedEmployee.body))
        })

        stompClient.subscribe('/topic/delete', edit => {
            ctx.datatableApi.ajax.reload(null, false)
            showHistory(JSON.parse(updatedEmployee.body).id)
        })
    })
}

/**
 * Создание запроса серверу с той целью, чтобы обновить таблицу. Запрос происходит
 * в методах сохранения (employees.common.js#save()) и удаления (employees.common.js#delete())
 * записей в таблице.
 */
function sendSaveReq(data) {
    stompClient.send("/app/requestForUpdate", {}, JSON.stringify(data))
}

function sendDeleteReq(id) {
    stompClient.send("/app/requestForDelete", {}, JSON.stringify({"id": id}))
}

