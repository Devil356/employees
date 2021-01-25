var historyAjaxUrl = "/rest/history/"

var historyCtx = {
    ajaxUrl: historyAjaxUrl,
}

function drawHistoryTable(id) {
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
                4, 'desc'
            ]
        ]
    })
}
