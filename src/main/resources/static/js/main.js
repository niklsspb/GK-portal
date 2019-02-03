function constructFlatObject(flat) {
    const fNumber = flat.children('.gk-flat-number').text();
    const fId = flat.attr('data-flat-id');
    const fBuildNumber = flat.children('.gk-flat-build-number').text();
    const fFloor = flat.parent().parent().attr('data-floor-number');
    const fRizer = flat.parent().attr('data-rizer-number');
    const fPorch = flat.parent().parent().parent().attr('data-porch-number');
    var flatObject = {id : fId, porch : fPorch, floor : fFloor, flatNumber : fNumber, riser : fRizer, flatNumberBuild : fBuildNumber};
    return flatObject;
}

function onChangeHousing() {
    var house_selid = document.getElementById("housingNumber").options.selectedIndex;
    var house_value = document.getElementById("housingNumber").options[house_selid].value;
    if (house_value != "") {
        $.ajax({
            url: '/getPorchCount/' + house_value,
            success: function (data) {
                console.log(data);
                //$('#div_porch').html(data);
                document.getElementById("div_porch").innerHTML = data;
                document.getElementById("div_show_flat").innerHTML = "";


            }
        });
    } else {
        document.getElementById("div_porch").innerHTML = "";
        document.getElementById("div_show_flat").innerHTML = "";
    }
    ;
}

function onChangePorch(selectObject) {

    var house_selid = document.getElementById("housingNumber").options.selectedIndex;
    var house_value = document.getElementById("housingNumber").options[house_selid].text;

    var porch_selid = selectObject.options.selectedIndex;
    var porch_value = selectObject.options[porch_selid].text;

    console.log(porch_value);
    //  var porch_selid = document.getElementsByName("porchNumber").options.selectedIndex;
    //  var porch_value= document.getElementsByName("porchNumber").options[porch_selid].value;
    $.ajax({


        url: '/showPorch/' + house_value + '/' + porch_value + '/',
        success: function (data) {
            console.log(data);
            $('#div_show_flat').html(data);

        }
    });

}

function clickFlat(th) {
    var flat = constructFlatObject($(th));
    $('#porchNumber').val(flat.porch);
    $('#floorNumber').val(flat.floor);
    $('#flatNumber').val(flat.flatNumber);
}

