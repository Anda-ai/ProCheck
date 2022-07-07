    let formData = new FormData(); 
    var username = "";
    $("#login-form").on('submit', function(e){
        e.preventDefault();
        var username = document.getElementById('username').value;
        formData.append("username", username);
        var password = document.getElementById('password').value;
        formData.append("password", password);


        $.ajax({
            url:"login",
            type: "POST", 
            //enctype: 'multipart/form-data',
            data: formData,
            contentType: false,
            cache: false,
            processData:false,
            success: function (data) {
                alert("works!");

            },
            error: function (xhr, ajaxOptions, thrownError) {
                alert("6");
                

            }
        });
    });
    $("#submit-pro").on('click', function(e){
        e.preventDefault();



        $.ajax({
            url:"signup",
            type: "POST", 
            //enctype: 'multipart/form-data',
            data: formData,
            contentType: false,
            cache: false,
            processData:false,
            success: function (data) {
                alert("works!");

            },
            error: function (xhr, ajaxOptions, thrownError) {
                alert("6");
                

            }
        });
    });
    