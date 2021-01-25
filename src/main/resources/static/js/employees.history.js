let historyAjaxUrl = "/rest/history/"

let historyCtx = {
    ajaxUrl: historyAjaxUrl,
}

function drawHistoryTable() {
    historyCtx.datatableApi = $("#historyTable, #historyTableInHistoryTab").DataTable({
        "ajax": {
            url: historyAjaxUrl,
            "dataSrc":"",
        },
        "info": false,
        "searching": false,
        "retrieve":true,
        "paging": false,
        "columns":[
            {
                "data": "editTime",
            },
            {
                "data": "name",
            },
            {
                "data": "lastname",
            },
            {
                "data": "email",
            },
            {
                "data": "phoneNumber",
            },
        ],
        "order": [
            [
                0, 'desc'
            ]
        ]
    })
}
