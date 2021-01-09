var employeeAjaxUrl = "rest/";

$(function () {
        $('#datatable').DataTable({
            "ajax": {
                "url": employeeAjaxUrl,
                "dataSrc": ""
            },
            // "paging": false,
            // "info": true,
            "columns": [
                {"data": "name"},
                {"data": "lastname"},
                {"data": "email"},
                {"data": "phoneNumber"},
                {
                    "defaultContent": "Edit",
                    "orderable": false
                },
                {
                    "defaultContent": "Edit",
                    "orderable": false
                }
            ]
        })
    }
);