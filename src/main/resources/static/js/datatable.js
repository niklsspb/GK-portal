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
    var table = $('#resultTable').DataTable({
        ajax: {
            "url": "/rest/questionnaire-result?questionnaireId=bb2248ae-2d7e-427d-85ef-7b85888f0319",
            "dataSrc": ""
        },
        language: {
            "url": "//cdn.datatables.net/plug-ins/1.10.19/i18n/Russian.json"
        },
        lengthMenu: [[3, 5, 10, 15, -1], [3, 5, 10, 15, "Все"]],
        // order: [0, 'asc'],
        ordering: false,
        fixedHeader: {
            "footer": "false"
        },
        columns:
            [
                {
                    data: "contactDTO",
                    render: function (data, type, row) {
                        return data.lastName + ' ' + data.firstName + ' ' + data.middleName + ' ';
                    }
                },

                {
                    data: "contactDTO",
                    render: function (data, type, row) {
                        var res = "";
                        $.each(data.communications, function (index, communication) {
                            switch (communication.communicationType.description) {
                                case 'Email':
                                    res += "<a href=\"mailto:";
                                    break;
                                case 'Телефон':
                                    res += "<a href=\"tel:+7";
                                    break;
                                default:
                                    break;
                            }
                            res += communication.identify + "\">" + communication.identify + "</a></br>";
                        });
                        return res;
                    }
                },

                {
                    data: "contactDTO",
                    render: function (data, type, row) {
                        var res = "";

                        $.each(data.ownerships, function (index, ownership) {
                            var style = "<i class=\"";
                            switch (ownership.ownershipType.name) {
                                case 'Квартира':
                                    style += "far fa-building\"></i>";
                                    break;
                                case 'Машиноместо':
                                    style += "fas fa-parking\"></i>";
                                    break;
                                case 'Автомобиль':
                                    style += "fas fa-car\"></i>";
                                    break;
                                case 'Нежилое помещение':
                                    style += "fas fa-briefcase\"></i>";
                                    break;
                                default:
                                    break;
                            }

                            res += '<p>' + style + '</br>' +
                                ownership.houseBuildNum + ' корпус, ' + '</br>' +
                                ownership.buildNumber + ' объект, ' + '</br>' +
                                '(S' + ownership.square + 'м<sup>2</sup>, ' + ownership.percentageOfOwner + '%)' +
                                '</p>';
                        });
                        return res;
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
                },

                {
                    "data": "contactDTO.questionnaireContactConfirm",
                    "render": function (data, type, row) {
                        var classNotFind = "btn-outline-secondary";
                        var classMatches = "btn-outline-success";
                        var classNotMatch = "btn-outline-danger";
                        var res = "";
                        switch (data.questionnaireConfirmedType.name) {
                            case 'не искали':
                                classNotFind = "btn-secondary";
                                break;
                            case 'совпадает':
                                classMatches = "btn-success";
                                break;
                            case 'не совпадает':
                                classNotMatch = "btn-danger";
                                break;
                            default:
                                break;
                        }
                        res += '<button type="button" class="btn ' + classNotFind + ' add-item-btn" confirmId="' + data.uuid + '" typeId="1b4976f3-8a81-45d0-b3b1-9f31dfafaad5">не искали</button>';
                        res += '<button type="button" class="btn ' + classMatches + ' add-item-btn" confirmId="' + data.uuid + '" typeId="6973e035-5196-48ed-bfba-2ca2935d47da">совпадает</button>';
                        res += '<button type="button" class="btn ' + classNotMatch + ' add-item-btn" confirmId="' + data.uuid + '" typeId="fff634b9-f5ae-4342-9135-1c086b75c39a">не совпадает</button>';

                        return res;
                    }
                }

            ],
        // "initComplete": questionnaireConfirmedTypesListener(settings, json, table),

        "createdRow": function (row, data, dataIndex) {
            if (data.contactDTO.questionnaireContactConfirm.confirmed === false) {
                $(row).addClass('lightpink');
            }
        }
    });

    $('#resultTable thead tr').clone(true).appendTo('#resultTable thead');
    $('#resultTable thead tr:eq(1) th').each(function (i) {
        // var title = $(this).text();
        // $(this).html('<input type="text" placeholder="Поиск ' + title + '" />');
        $(this).html('<input type="text" placeholder="Поиск"/>');

        $('input', this).on('keyup change', function () {
            if (table.column(i).search() !== this.value) {
                table
                    .column(i)
                    .search(this.value)
                    .draw();
            }
        });
    });
    $('#resultTable').on('click', '.add-item-btn', function questionnaireConfirmedTypesListener() {
            var confirmId = $(this).attr('confirmId');
            var typeId = $(this).attr('typeId');
            $.ajax({
                url: "/rest/change-questionnaireConfirmedType",
                type: "POST",
                data: {
                    "questionnaireContactConfirmId": confirmId,
                    "questionnaireConfirmedTypeId": typeId
                },
                complete: function (e, data, xhr, settings) {
                    if (e.status === 200) {
                        table.ajax.reload();
                    } else if (e.status === 204) {
                        alert('контент не найден');
                    } else if (e.status === 403) {
                        alert('доступ запрещен');
                        window.location.href = "/login"
                    } else if (e.status === 302) {
                        alert('необходимо авторизироваться');
                    } else {
                        alert('неизвестная ошибка, код ' + e.status);
                    }
                }
            })
        }
    );
});

