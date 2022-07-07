$("#signup_form").on('submit', function(e){
    var address = [];
    var country = document.getElementById('country').value;
    var town = document.getElementById('town').value;
    var suburb = document.getElementById('suburb').value;
    var zip = document.getElementById('zip').value;
    address.push({"country": country, "town": town, "suburb": suburb, "zip": zip});
    var jsonAddress = JSON.stringify(address);
    let addressfield = $('<input name="address" id="address"></input>');
    addressfield.attr("value", jsonAddress);
    $(this).append(addressfield);
});
/*
$("#signup_form").on('submit', function(e){
    e.preventDefault();
    var formData = $(this).serializeArray();
    var address = [];
    var country = document.getElementById('country').value;
    var town = document.getElementById('town').value;
    var suburb = document.getElementById('suburb').value;
    var zip = document.getElementById('zip').value;
    address.push({"country": country, "town": town, "suburb": suburb, "zip": zip});
    var jsonAddress = JSON.stringify(address);
    alert("address: "+jsonAddress);
    formData.push({name:"address", value: jsonAddress});

    $.ajax({
        url:"signup",
        type: "POST", 
        data: $.param(formData),
        success: function () {
            alert("sucess");
            window.location.href = "/";
        },
        error: function (response, errorThrown) {
            alert("error");
            document.open();
            document.write(response.responseText);
            document.close();
        }
    });
});*/