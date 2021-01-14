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

        /**
         * После того, как от сервера приходит рассылка, происходит обновление таблицы
         */
        stompClient.subscribe('/topic/updateTable', plug => {
            ctx.updateTable()
        })
    })
}

/**
 * Создание запроса серверу с той целью, чтобы обновить таблицу. Запрос происходит
 * в методах сохранения (employees.common.js#save()) и удаления (employees.common.js#delete())
 * записей в таблице.
 */
function sendReq() {
    stompClient.send("/app/requestForUpdate", {}, JSON.stringify({'id': 0}))
}


