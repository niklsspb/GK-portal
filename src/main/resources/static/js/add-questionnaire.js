var questionLastNumber = 1;
var answerBlock;

$(document).ready(function () {
    answerBlock = $('#question-template').clone();
    addAnswerButtonClickListener();
    addQuestionButtonClickListener();
});

function setAnswerAttributes(currentAnswer, questionId, answerIndex) {
    currentAnswer.attr('answerIndex', answerIndex + 1);
    currentAnswer.children('div').children('div').text('Вариант ' + (answerIndex + 1));
    currentAnswer.children('input')
        .attr('id', 'questions' + questionId + '.answers' + answerIndex + '.name')
        .attr('name', 'questions\[' + questionId + '\].answers\[' + answerIndex + '\].name')
        .val('');
}

//todo убрать повторное создание листнеров
function addAnswerButtonClickListener() {
    $('.question-button').on("click", function () {

        var questionBlock = $(this).parent();
        var questionId = parseInt(questionBlock.attr('questionnumber'));
        var currentAnswer = questionBlock.children('div').last().clone();
        var answerIndex = parseInt(currentAnswer.attr('answerIndex'));

        setAnswerAttributes(currentAnswer, questionId, answerIndex);
        currentAnswer.insertBefore($(this));

    });
}

function addQuestionButtonClickListener() {
    $('#add-question').on("click", function () {
        var currentAnswerBlock = answerBlock.clone();
        currentAnswerBlock.attr('questionnumber', questionLastNumber);
        currentAnswerBlock.find('.form-question')
            .attr('id', 'questions' + questionLastNumber + '.name')
            .attr('name', 'questions\[' + questionLastNumber + '\].name');

        currentAnswerBlock.find('.form-answer').each(function (answerIndex) {
            $(this).attr('name', 'questions\[' + questionLastNumber + '\].answers\[' + answerIndex + '\].name');//.replace('questions\[0\]', 'questions\[' + questionLastNumber + '\]'));
            setAnswerAttributes($(this), questionLastNumber, answerIndex);
        });

        questionLastNumber++;
        currentAnswerBlock.appendTo($('#question-group'));
        addAnswerButtonClickListener();
    });
}