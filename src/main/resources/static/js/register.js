$("#Slide1-form-register").on('submit', function(e){
    var address = [];
    var country = document.getElementById('country').value;
    var town = document.getElementById('town').value;
    var suburb = document.getElementById('suburb').value;
    var zip = document.getElementById('zip').value;
    address.push({"country": country, "town": town, "suburb": suburb, "zip": zip});
    var jsonAddress = JSON.stringify(address);
    //alert(jsonAddress);
    let addressfield = $('<input name="address" id="address"></input>');
    addressfield.attr("value", jsonAddress);
    $(this).append(addressfield);
});

$("#Slide2-form-register").on('submit', function(e){
    var mainservice = [];
    var servicename = document.getElementById('servicename').value;
    var servicecategory = document.getElementById('servicecategory').value;
    mainservice.push({"servicename": servicename, "servicecategory": servicecategory});
    var jsonMainservice = JSON.stringify(mainservice);
    let servicefield = $('<input name="mainservice" id="mainservice"></input>');
    servicefield.attr("value", jsonMainservice);
    $(this).append(servicefield);
    var otherservices = [];
    otherservices.push({"servicename": "service1", "servicecategory": "category"});
    otherservices.push({"servicename": "service2", "servicecategory": "category"});
    var jsonOtherservices = JSON.stringify(otherservices);
    let categoryfield = $('<input name="otherservices" id="otherservices"></input>');
    categoryfield.attr("value", jsonOtherservices);
    $(this).append(categoryfield);
});