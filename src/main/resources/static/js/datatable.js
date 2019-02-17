// https://datatables.net/


$.fn.dataTable.render.answerResult = function () {
    return function (data, type, row) {
        //строка для тестирвоания вывода данных по нужным столбцам
        // if (data != null) return data.answer.question.name + '</br>' + data.answer.name;
        if (data != null) return data.answer.name;
        else return "-";
    };
};


$(document).ready(function () {
    $('#resultTable').DataTable({
        "ajax": {
            "url": "/rest/questionnaire-result?questionnaireId=bb2248ae-2d7e-427d-85ef-7b85888f0319",
            "dataSrc": ""
        },
        "order": [1, 'asc'],
        "columns": [
            {"data": "contactDTO.questionnaireContactConfirm.confirmed"},
            {
                "data": "contactDTO",
                "render": function (data, type, row) {
                    return data.lastName + ' ' + data.firstName + ' ' + data.middleName + ' ';
                }
            },
            {
                "data": "integerAnswerResultDTO1Map.2",
                "render": $.fn.dataTable.render.answerResult()
            },

            {
                "data": "integerAnswerResultDTO1Map.3",
                "render": $.fn.dataTable.render.answerResult()
            },

            {
                "data": "integerAnswerResultDTO1Map.4",
                "render": $.fn.dataTable.render.answerResult()
            },

            {
                "data": "integerAnswerResultDTO1Map.5",
                "render": $.fn.dataTable.render.answerResult()
            },

            {
                "data": "integerAnswerResultDTO1Map.6",
                "render": $.fn.dataTable.render.answerResult()
            }
        ],
        "columnDefs": [
            {
                "targets": 0,
                "render": function (data, type, row, meta) {
                    if (data === false) { // todo
                        var rowIndex = meta.row + 1;
                        console.log('data ' + data + ', rowIndex ' + rowIndex);
                        $('#resultTable tbody tr:nth-child(' + rowIndex + ')').addClass('lightpink');
                        return data;
                    } else {
                        console.log('data ' + data);
                        return data;
                    }
                }
                // "visible": false
            }
        ]

    });
});