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
        "language": {
            "url": "//cdn.datatables.net/plug-ins/1.10.19/i18n/Russian.json"
        },
        "lengthMenu": [[3, 5, 10, 15, -1], [3, 5, 10, 15, "Все"]],
        "order": [1, 'asc'],
        "columns":
            [
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
                },

                {
                    "data": "contactDTO.questionnaireContactConfirm.confirmed",
                    "render": function (data, type, row) {
                        if (data) return 'да';
                        else return 'нет';
                    }
                }
            ],
        "createdRow": function (row, data, dataIndex) {
            if (data.contactDTO.questionnaireContactConfirm.confirmed === false) {
                $(row).addClass('lightpink');
            }
        }
    });
})
;